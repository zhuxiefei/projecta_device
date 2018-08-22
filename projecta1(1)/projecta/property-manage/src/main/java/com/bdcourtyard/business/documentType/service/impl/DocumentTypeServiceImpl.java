package com.bdcourtyard.business.documentType.service.impl;
import com.bdcourtyard.business.documentType.service.DocumentTypeService;
import com.bdcourtyard.business.documentType.dao.DocumentTypeDao;
import com.bdcourtyard.business.documentType.model.DocumentType;



import com.bdcourtyard.business.documentType.vo.DocumentTypeParm;
import com.bdcourtyard.common.exception.GlobalException;
import com.bdcourtyard.common.page.Page;
import org.apache.log4j.Logger;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.github.pagehelper.PageHelper;

/**
 *  DocumentTypeServiceImpl
 *
 * @version : Ver 1.0
 * @date	: 2018-7-31 
 */
@Service
public class DocumentTypeServiceImpl  implements DocumentTypeService {
	private static Logger log = Logger.getLogger(DocumentTypeServiceImpl.class);


	@Autowired
	private DocumentTypeDao documentTypeDao;

	//新增资料类别管理
	public int insertDocumentType(DocumentType documentType){


		if (documentType!=null&&documentType.getTypeName()!=null && !("".equals(documentType.getTypeName().trim()))){
			boolean b = isSpecialChar(documentType.getTypeName());
			if(b){ //有特殊字符
				throw new GlobalException("DC0003");
			}
			if (documentType.getTypeName().length()>50){
				throw new GlobalException("DC0005");
			}
		}else {
			throw new GlobalException("DC0004");
		}

		documentType.setTypeName(documentType.getTypeName().trim());
		documentType.setCreateTime(new Date());
		documentType.setUpdateTime(new Date());


		//新增前验证名称
		DocumentType d = documentTypeDao.vailDateTypeName(documentType);
		if (d!=null){
			throw new GlobalException("DC0008");
		}
		return documentTypeDao.insertDocumentType(documentType);
	}


	public int insertDocumentTypeBatch(List<DocumentType> list){
		return documentTypeDao.insertDocumentTypeBatch(list);
	}


	//更新资料信息
	public int updateDocumentTypeById(DocumentType documentType){
		if (documentType!=null&&documentType.getTypeId()!=null && "".equals(documentType.getTypeId().trim())){
		}else {
			throw new GlobalException("DC0007");
		}

		if (documentType != null&&documentType.getTypeName() != null&& !("".equals(documentType.getTypeName().trim()))){
			boolean b = isSpecialChar(documentType.getTypeName());
			if(b){ //有特殊字符
				throw new GlobalException("DC0003");
			}
			if (documentType.getTypeName().length()>50){
				throw new GlobalException("DC0005");
			}

		}else {
			throw new GlobalException("DC0004");
		}



		documentType.setTypeName(documentType.getTypeName().trim());
		documentType.setUpdateTime(new Date());

		//更新前前验证类型名称
		DocumentType d = documentTypeDao.vailDateTypeName(documentType);
		if (d!=null){
			throw new GlobalException("DC0007");
		}

		return documentTypeDao.updateDocumentTypeById(documentType);
	}


	public boolean deleteDocumentTypeById(  String typeId  ){
		try{
			String[] ids = typeId.split(",");
			for (String id : ids){
				if (id!=null&&!("".equals(id))){
					DocumentType d = documentTypeDao.getDocumentTypeById(id);
					documentTypeDao.deleteDocumentTypeById(id);
				}
			}
			return true;
		}catch (Exception e){
			log.error("异常",e);
			return false;
		}
	}


    //根据id获取资料类别
	public DocumentType getDocumentTypeById(  String typeId  ){

		return documentTypeDao.getDocumentTypeById(  typeId  );
	}


 	public List<DocumentType> getDocumentTypes(DocumentType documentType){
		return documentTypeDao.getDocumentTypes(documentType);

 	}

 	public Page<DocumentType> getDocumentTypesForPage(DocumentTypeParm param,Pageable pageable){

		Page page = new Page();
		long count = documentTypeDao.getDocumentTypesForPage(param).size();
		PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
		List<DocumentType> list = documentTypeDao.getDocumentTypesForPage(param);


		if (list != null) {
			page.setPage(pageable.getPageNumber());
			page.setPageSize(pageable.getPageSize());
			page.setRows(list);
			page.setTotal(count);
		} else {
			page.setRows(new ArrayList<DocumentType>());
			page.setTotal(0l);
		}

		return page;

 	}



	/**
	 * 判断是否含有特殊字符
	 *
	 * @param str
	 * @return true为包含，false为不包含
	 */
	public static boolean isSpecialChar(String str) {
		String regEx = "[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		return m.find();
	}

	/**
	 * 时间比较  若date1>date2返回false
	 * @param DATE1
	 * @param DATE2
	 * @return
	 */
	public static boolean compare_date(String DATE1, String DATE2) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date dt1 = df.parse(DATE1);
			Date dt2 = df.parse(DATE2);
			if (dt1.getTime() >= dt2.getTime()) {
				return false;
			} else {
				return true;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}

	}

}
