package com.bdcourtyard.business.documentType.rest;
import com.bdcourtyard.business.documentType.service.DocumentTypeService;
import com.bdcourtyard.business.documentType.model.DocumentType;

import basic.common.core.id.IdUtil;

import com.bdcourtyard.business.documentType.vo.DocumentTypeParm;
import com.bdcourtyard.common.exception.GlobalException;
import com.bdcourtyard.common.page.Page;
import com.beite.tools.utils.AESUtil;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.bdcourtyard.common.response.Response;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  DocumentTypeController
 *
 * @version : Ver 1.0
 * @date	: 2018-7-31
 */
@RestController
@Api(value = "DocumentTypeController", description = "资料类型相关")
@RequestMapping(value = "/pm/web/documentType")
public class DocumentTypeController {

	private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(DocumentTypeController.class);
	
	   @InitBinder   
	    public void initBinder(WebDataBinder binder) {
	        DateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
	        dateFormat.setLenient(true);   
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   
	    }  
	
	@Autowired
	private DocumentTypeService documentTypeService;
	
	@ApiOperation(value = "新增资料类型", notes = "新增资料类型")
	@RequestMapping(value = "/insertDocumentType", method = RequestMethod.POST)
	public Response<Integer> insertDocumentType(@RequestBody DocumentType documentType, HttpServletRequest request){
		documentType.setTypeId(IdUtil.getId()+"");

		String estateId;
		try {
			estateId = AESUtil.decrypt(request.getHeader("estateId"));
		} catch (Exception e) {
			throw new GlobalException("99999");
		}
		if(estateId==null||"".equals(estateId.trim())){
			throw new GlobalException("DC0008");
		}else{
			documentType.setEstateId(estateId);
		}
		String employeeId;
		try {
			employeeId = AESUtil.decrypt(request.getHeader("employeeId"));
		} catch (Exception e) {
			throw new GlobalException("99999");
		}
		if(employeeId==null||"".equals(employeeId.trim())){
			throw new GlobalException("DC0008");
		}else{
			documentType.setEmployeeId(employeeId);
		}


		return new Response<Integer>(documentTypeService.insertDocumentType(documentType));


		/*if (LOG.isInfoEnabled()){
			LOG.info("----------/pm/web/documentType/insertDocumentType------start-documentType:" + documentType);
		}
		Response<String> response = new Response<>();

		documentTypeService.insertDocumentType(documentType);
		if (LOG.isInfoEnabled()){
			LOG.info("----------/pm/web/documentType/insertDocumentType------end-response:" + response);
		}

		return response;*/
	}


	@ApiOperation(value = "批量新增资料类型", notes = "批量新增资料类型")
	@RequestMapping(value = "/insertDocumentTypeBatch", method = RequestMethod.POST)
	public Response<Integer> insertDocumentTypeBatch(@RequestBody List<DocumentType> list){
		return  new Response<Integer>(documentTypeService.insertDocumentTypeBatch(list));
	}


	@ApiOperation(value = "根据ID修改资料类型", notes = "根据ID修改资料类型")
	@RequestMapping(value = "/updateDocumentTypeById", method = RequestMethod.POST)
	public Response<Integer> updateDocumentTypeById(@RequestBody DocumentType documentType,HttpServletRequest request){

		return new Response<Integer>(documentTypeService.updateDocumentTypeById(documentType));


	}
	@ApiOperation(value = "根据ID删除资料类型", notes = "根据ID删除资料类型")
	@RequestMapping(value = "/deleteDocumentTypeById", method = RequestMethod.GET)
	public Response<Boolean> deleteDocumentTypeById( @RequestParam String typeId  ){
		if (typeId == null||"".equals(typeId.trim())){
			throw new GlobalException("DC0006");
		}
		boolean b = documentTypeService.deleteDocumentTypeById(typeId);
		if(!b){
			throw new GlobalException("DC0006");
		}
		return new Response<Boolean>(b);
	}
	@ApiOperation(value = "根据ID获取资料类型", notes = "根据ID获取资料类型")
	@RequestMapping(value = "/getDocumentTypeById", method = RequestMethod.GET)
	public Response<DocumentType> getDocumentTypeById( @RequestParam String typeId  ){
		if (typeId == null||"".equals(typeId.trim())){
			throw new GlobalException("DC0007");
		}

		return new Response<DocumentType>(documentTypeService.getDocumentTypeById(  typeId  ));
	}
 
	@ApiOperation(value = "根据对象获取资料类型", notes = "根据对象获取资料类型")
	@RequestMapping(value = "/getDocumentTypes", method = RequestMethod.POST)
	public  Response<List<DocumentType>> getDocumentTypes( @RequestBody DocumentType documentType){

		return new Response<List<DocumentType>>(documentTypeService.getDocumentTypes(documentType));

 	}

	@ApiOperation(value = "根据对象分页获取资料类型", notes = "根据对象分页获取资料类型")
	@RequestMapping(value = "/getDocumentTypesForPage", method = RequestMethod.POST)
	public  Response<Page<DocumentType>> getDocumentTypesForPage(HttpServletRequest request, @RequestBody DocumentTypeParm parm,
																	@RequestParam(value="page", defaultValue="1")  int page,
																	@RequestParam(value="pageSize", defaultValue="10") int pageSize
	                                                               ){
		String estateId =null;
		try {
			estateId = AESUtil.decrypt(request.getHeader("estateId"));
		} catch (Exception e) {
			throw new GlobalException("99999");
		}

		parm.setEstateId(estateId);
		Pageable pageable = new PageRequest(page, pageSize);


		Page pageDto= documentTypeService.getDocumentTypesForPage(parm,pageable);
		return new Response(pageDto);
 	}



	/**
	 * 查看日期格式是否正确
	 * @param str
	 * @param format
	 * @return
	 */
	public static boolean checkDate(String str,String format){

		DateFormat formatter = new SimpleDateFormat(format);
		try{
			Date date = formatter.parse(str);
			return true;
		}catch(Exception e){
			return false;
		}
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


