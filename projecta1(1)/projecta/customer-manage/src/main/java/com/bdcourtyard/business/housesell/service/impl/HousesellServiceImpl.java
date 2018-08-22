package com.bdcourtyard.business.housesell.service.impl;

import com.bdcourtyard.business.housesell.service.HousesellService;
import com.bdcourtyard.business.housesell.dao.HousesellDao;
import com.bdcourtyard.business.housesell.model.Housesell;
import com.bdcourtyard.business.housesell.vo.HousePriceDiscountVo;
import com.bdcourtyard.business.housesell.vo.HousePriceVo;
import com.bdcourtyard.business.housesell.vo.HouseSellDetailVo;
import com.bdcourtyard.business.housesell.vo.HouseTypeVo;
import com.bdcourtyard.common.exception.GlobalException;
import com.bdcourtyard.common.page.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import com.github.pagehelper.PageHelper;

/**
 * HousesellServiceImpl
 *
 * @version : Ver 1.0
 * @date : 2018-7-24
 */
@Service
public class HousesellServiceImpl implements HousesellService {

    @Autowired
    private HousesellDao housesellDao;

    public int insertHousesell(Housesell housesell) {
        return housesellDao.insertHousesell(housesell);
    }

    public int insertHousesellBatch(List<Housesell> list) {
        return housesellDao.insertHousesellBatch(list);
    }

    public int updateHousesellById(Housesell housesell) {
        return housesellDao.updateHousesellById(housesell);
    }

    public int deleteHousesellById(String houseId) {
        return housesellDao.deleteHousesellById(houseId);
    }

    public Housesell getHousesellById(String houseId) {
        return housesellDao.getHousesellById(houseId);
    }

    public List<Housesell> getHousesells(Housesell housesell) {
        return housesellDao.getHousesells(housesell);

    }

    public Page<Housesell> getHousesellsForPage(Housesell housesell, Pageable pageable) {

        long count = housesellDao.getHousesells(housesell).size();
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        List<Housesell> housesells = housesellDao.getHousesells(housesell);

        Page<Housesell> pageDto = new Page<Housesell>();
        pageDto.setPage(pageable.getPageNumber());
        pageDto.setPageSize(pageable.getPageSize());
        if (housesells != null) {
            pageDto.setRows(housesells);
            pageDto.setTotal(count);
        } else {
            pageDto.setRows(new ArrayList<Housesell>());
            pageDto.setTotal(0l);
        }

        return pageDto;
    }

    @Override
    public Page<Housesell> getHousesellsForPage_new(Housesell housesell, Pageable pageable) {
        if (housesell != null) {
            if (housesell.getTypeId() == null || housesell.getTypeId().equals("")) {
                housesell.setTypeId("");
            }
            if (housesell.getFloorArea() != null) {
                housesell.setFloorArea(housesell.getFloorArea().trim());
            }
            //estateType
            if (housesell.getEstateType() == null || housesell.getEstateType().equals("")) {
                housesell.setEstateType("");
            }

        } else {
            throw new GlobalException("SA001");
        }

        long count = housesellDao.getHousesellsForPage_new(housesell).size();
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        List<Housesell> housesells = housesellDao.getHousesellsForPage_new(housesell);

        Page<Housesell> pageDto = new Page<Housesell>();
        pageDto.setPage(pageable.getPageNumber());
        pageDto.setPageSize(pageable.getPageSize());
        if (housesells != null) {
            pageDto.setRows(housesells);
            pageDto.setTotal(count);

        } else {
            pageDto.setRows(new ArrayList<Housesell>());
            pageDto.setTotal(0l);
        }

        return pageDto;

    }

    @Override
    public List<HouseTypeVo> getAllHouseType(String estateId) {
        return housesellDao.getAllHouseType(estateId);
    }

    @Override
    public HouseSellDetailVo getHouseSellDetail(String houseId) {
        HouseSellDetailVo vo = housesellDao.getHouseSellDetail(houseId);

        if(vo==null||vo.getHouseNo()==null){
            throw new GlobalException("SA049");
        }

        if(vo.getSaleStatus().equals("4")){ //若已售的房屋 ，折扣已固定  价格也已保存
            //do something
            List<HousePriceVo> pl = housesellDao.getsaleHousePrice(vo.getHouseId());
            if(pl!=null&& pl.size()>0){
                vo.setPrice(pl.get(0).getPrice());
                vo.setTotalPrice(pl.get(0).getTotalPrice());
                vo.setHousePriceId(pl.get(0).getHousePriceId());
                ;
            }
            List<HousePriceDiscountVo> ld = housesellDao.getsaleHousePriceDiscount(vo.getHouseId());
            if(ld!=null&&ld.size()>0){
                vo.setHousePriceDiscountVo(ld);
            }


        }else{ //非已售





            if (vo.getEstateId()!=null&&!("".equals(vo.getEstateId()))&&vo.getTypeId() != null && !("".equals(vo.getTypeId().trim())) && vo.getBuildingId() != null && !("".equals(vo.getBuildingId().trim())) && vo.getUnitId() != null && !("".equals(vo.getUnitId().trim()))) {
                List<HousePriceVo> pricelist = housesellDao.getHousePrice(vo);
                HousePriceVo finalPrice = new HousePriceVo();
                if(pricelist==null||pricelist.size()==0){

                }else{
                    finalPrice = pricelist.get(0);

                   /* labelA:
                    for(HousePriceVo pvo:pricelist){
                        if(pvo.getStorey()!=null){
                            String story = pvo.getStorey().trim();
                            String[] storyAttr = story.split(",");
                            labelB:
                            for(String s:storyAttr){
                                if(vo.getFloor().trim().equals(s.trim())){
                                    finalPrice =pvo;
                                    break labelA;
                                }
                            }

                        }else{
                            finalPrice = pvo;
                            break labelA;
                        }
                    }*/



                    if(finalPrice!=null&&finalPrice.getHousePriceId()!=null){
                        vo.setPrice(finalPrice.getPrice());
                        vo.setTotalPrice(finalPrice.getTotalPrice());
                        vo.setHousePriceId(finalPrice.getHousePriceId());
                        List<HousePriceDiscountVo> discountVoList = new ArrayList<HousePriceDiscountVo>();
                        //查询折扣

                        if(finalPrice.getDiscountId()!=null&&!(finalPrice.getDiscountId().trim().equals(""))){
                            for(String discountId : finalPrice.getDiscountId().split(",")){
                                if(discountId!=null&&!(discountId.equals(""))){
                                    HousePriceDiscountVo discountVo = housesellDao.getHousePriceDiscount(discountId);
                                    if(discountVo!=null&&discountVo.getDiscountId()!=null){
                                        discountVoList.add(discountVo);
                                    }

                                }


                            }
                            vo.setHousePriceDiscountVo(discountVoList);

                        }

                    }
                }

            }







        }

        return vo;
    }
}
