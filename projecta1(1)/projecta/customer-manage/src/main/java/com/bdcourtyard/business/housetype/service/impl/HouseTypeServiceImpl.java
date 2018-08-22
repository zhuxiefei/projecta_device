package com.bdcourtyard.business.housetype.service.impl;

import basic.common.core.id.IdUtil;
import com.bdcourtyard.business.common.dao.SystemFileDao;
import com.bdcourtyard.business.common.model.SystemFile;
import com.bdcourtyard.business.house.dao.HouseHouseDao;
import com.bdcourtyard.business.house.model.HouseHouse;
import com.bdcourtyard.business.housetype.constant.TypeConstant;
import com.bdcourtyard.business.housetype.dao.HouseTypeDao;
import com.bdcourtyard.business.housetype.dao.HouseTypeSenceDao;
import com.bdcourtyard.business.housetype.domain.*;
import com.bdcourtyard.business.housetype.model.HouseType;
import com.bdcourtyard.business.housetype.model.HouseTypeSence;
import com.bdcourtyard.business.housetype.service.HouseTypeService;
import com.bdcourtyard.business.housetype.util.Validate;
import com.bdcourtyard.common.exception.GlobalException;
import com.bdcourtyard.common.page.Page;
import com.bdcourtyard.common.utils.StringUtil;
import com.beite.tools.utils.AESUtil;
import com.beite.tools.utils.FileUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * HouseTypeServiceImpl
 *
 * @version : Ver 1.0
 * @date    : 2018-7-23
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class HouseTypeServiceImpl implements HouseTypeService {

    @Autowired
    private HouseTypeDao houseTypeDao;

    @Autowired
    private SystemFileDao systemFileDao;

    @Autowired
    private HouseHouseDao houseDao;

    @Autowired
    private HouseTypeSenceDao houseTypeSenceDao;

    public int insertHouseType(AddTypeReq typeReq, HttpServletRequest request) {
        HouseType houseType = typeReq.getHouseType();
        List<HouseTypeSence> sences = typeReq.getSences();
        try {
            houseType.setEmployeeId(AESUtil.decrypt(request.getHeader("employeeId")));
            houseType.setEstateId(AESUtil.decrypt(request.getHeader("estateId")));
        } catch (Exception e) {
            throw new GlobalException("99999");
        }
        validateHouseType(houseType);
        if (null != houseTypeDao.findByNameAndEstateId(houseType.getTypeName(),houseType.getEstateId())){
            throw new GlobalException("T0012");
        }
        String typeId = IdUtil.getLongId()+"";
        houseType.setTypeNo(UUID.randomUUID().toString());
        houseType.setCreateTime(new Date(System.currentTimeMillis()));
        houseType.setTypeId(typeId);
        houseTypeDao.insertHouseType(houseType);
        if (null != sences && sences.size() > 0){
            if (sences.size() > 9){
                throw new GlobalException("T0014");
            }
            List<HouseTypeSence> senceList = new ArrayList<>();
            for (HouseTypeSence sence:
                 sences) {
                sence.setTypeId(typeId);
                sence.setCreateTime(new Date(System.currentTimeMillis()));
                sence.setSenceId(IdUtil.getLongId()+"");
                senceList.add(sence);
            }
            houseTypeSenceDao.insertHouseTypeSenceBatch(senceList);
        }
        return 0;
    }

    public int insertHouseTypeBatch(List<HouseType> list) {
        return houseTypeDao.insertHouseTypeBatch(list);
    }

    public int updateHouseTypeById(AddTypeReq typeReq,HttpServletRequest request) {
        HouseType houseType = typeReq.getHouseType();
        List<HouseTypeSence> sences = typeReq.getSences();
        try {
            houseType.setEstateId(AESUtil.decrypt(request.getHeader("estateId")));
        } catch (Exception e) {
            throw new GlobalException("99999");
        }
        //判断名称是否重复
        HouseType oldType = houseTypeDao.getHouseTypeById(houseType.getTypeId());
        if (null == oldType){
            throw new GlobalException("T0013");
        }else {
            if (!oldType.getTypeName().equals(houseType.getTypeName())
                    && null != houseTypeDao.findByNameAndEstateId(houseType.getTypeName(),houseType.getEstateId())){
                throw new GlobalException("T0012");
            }
        }
        validateHouseType(houseType);
        houseTypeDao.updateHouseTypeById(houseType);
        //修改场景图
        houseTypeSenceDao.deleteByTypeId(houseType.getTypeId());
        if (null != sences && sences.size() > 0){
            if (sences.size() > 9){
                throw new GlobalException("T0014");
            }
            List<HouseTypeSence> senceList = new ArrayList<>();
            for (HouseTypeSence sence:
                    sences) {
                sence.setTypeId(houseType.getTypeId());
                sence.setCreateTime(new Date(System.currentTimeMillis()));
                sence.setSenceId(IdUtil.getLongId()+"");
                senceList.add(sence);
            }
            houseTypeSenceDao.insertHouseTypeSenceBatch(senceList);
        }
        return 0;
    }

    public int deleteHouseTypeById(String typeId) {
        String[] typeIds = typeId.split(",");
        List<HouseHouse> houseList = new ArrayList<>();
        for (String id:
             typeIds) {
            List<HouseHouse> list = houseDao.findByTypeId(id);
            if (null != list && list.size() > 0){
                for (HouseHouse house:
                     list) {
                    house.setTypeId(null);
                    houseList.add(house);
                }
            }
        }
        if (null != houseList && houseList.size() > 0){
            houseDao.updateTypeIdByHouseList(houseList);
        }
        houseTypeSenceDao.deleteByTypeIds(typeIds);
        houseTypeDao.deleteByIds(typeIds);
        return 0;
    }

    public FindTypeResp getHouseTypeById(String typeId) {
        if (null == houseTypeDao.getHouseTypeById(typeId)){
            throw new GlobalException("T0013");
        }else {
            FindTypeResp resp = houseTypeDao.findByTypeId(typeId);
            if (null != resp){
                resp.setSences(houseTypeSenceDao.fingByTypeId(typeId));
            }
            return resp;
        }
    }

    public Page<FindAllTypesResp> getHouseTypesForPage(FindAllTypesReq typesReq, Pageable pageable,HttpServletRequest request) {
        try {
            typesReq.setEstateId(AESUtil.decrypt(request.getHeader("estateId")));
        } catch (Exception e) {
            throw new GlobalException("99999");
        }
        if (!StringUtil.isBlank(typesReq.getTypeName())
                && !Validate.isCommonString(typesReq.getTypeName(),TypeConstant.TYPE_NAME_LENGTH)){
            throw new GlobalException("T0007");
        }
        long count = houseTypeDao.getHouseTypes(typesReq).size();
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        List<FindAllTypesResp> houseTypes = houseTypeDao.getHouseTypes(typesReq);

        Page<FindAllTypesResp> pageDto = new Page<>();
        pageDto.setPage(pageable.getPageNumber());
        pageDto.setPageSize(pageable.getPageSize());
        if (houseTypes != null) {
            pageDto.setRows(houseTypes);
            pageDto.setTotal(count);
        } else {
            pageDto.setRows(new ArrayList<>());
            pageDto.setTotal(0l);
        }

        return pageDto;
    }

    @Override
    public UploadPicResp uploadPic(MultipartFile file) {
        UploadPicResp resp = new UploadPicResp();
        String imagname = file.getOriginalFilename();
        //获取文件的类型
        String picType = imagname.substring(imagname.lastIndexOf(".") + 1);
        //图片名长度验证
        if (imagname.length() > TypeConstant.IMAGE_NAME_LENGTH) {
            throw new GlobalException("T0003");
        } else if (!Validate.isImage(picType)) {
            //图片类型错误
            throw new GlobalException("T0002");
        } else if (file.getSize() > TypeConstant.IMAGE_SIZE_MAX) {
            //图片过大
            throw new GlobalException("T0001");
        } else {
            String filrUrl;
            try {
                filrUrl = FileUtil.uploadFile(file, "houseType");
            } catch (Exception e) {
                throw new GlobalException("99999");
            }
            String fileId = IdUtil.getLongId()+"";
            SystemFile systemFile = new SystemFile();
            systemFile.setFileId(fileId);
            systemFile.setCreateTime(new Date(System.currentTimeMillis()));
            systemFile.setFileName(imagname);
            systemFile.setFileType(3);
            systemFile.setFileUrl(filrUrl);
            systemFileDao.insertSystemFile(systemFile);
            resp.setFileUrl(filrUrl);
            resp.setFileId(fileId);
            return resp;
        }
    }

    private void validateHouseType(HouseType houseType){
        //去空格
        if (!StringUtil.isEmpty(houseType.getTypeDesc())){
            houseType.setTypeDesc(houseType.getTypeDesc().trim());
        }
        if (!StringUtil.isEmpty(houseType.getTypeName())){
            houseType.setTypeName(houseType.getTypeName().trim());
        }
        //校验
        if (StringUtil.isBlank(houseType.getFileId())){
            throw new GlobalException("T0004");
        }
        if (!StringUtil.isBlank(houseType.getTypeDesc())
                && houseType.getTypeDesc().length() > TypeConstant.TYPE_DESC_LENGTH){
            throw new GlobalException("T0005");
        }
        if (StringUtil.isBlank(houseType.getTypeName())){
            throw new GlobalException("T0006");
        }
        if (!Validate.isCommonString(houseType.getTypeName(),TypeConstant.TYPE_NAME_LENGTH)){
            throw new GlobalException("T0007");
        }
        if (null == houseType.getFloorArea()){
            throw new GlobalException("T0008");
        }
        if (null == houseType.getInterFloorArea()){
            throw new GlobalException("T0009");
        }
        if (!(houseType.getFloorArea()+"").matches(TypeConstant.AREA_RULE)){
            throw new GlobalException("T0010");
        }
        if (!(houseType.getInterFloorArea()+"").matches(TypeConstant.AREA_RULE)){
            throw new GlobalException("T0011");
        }
    }
}
