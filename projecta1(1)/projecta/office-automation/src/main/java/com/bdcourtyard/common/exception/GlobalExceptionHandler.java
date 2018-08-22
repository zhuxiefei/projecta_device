package com.bdcourtyard.common.exception;

import java.util.HashMap;
import java.util.Map;

import com.bdcourtyard.business.login.service.impl.LoginServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static Logger LOG = Logger.getLogger(GlobalExceptionHandler.class);

	/**
	 * 全局异常捕捉处理
	 * 
	 * @param ex
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(value = Exception.class)
	public Map<String, String> errorHandler(Exception ex) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("code", "99999");
		map.put("msg", ex.getMessage());
		LOG.error("************系统异常************",ex);
		return map;
	}

	/**
	 * 拦截捕捉自定义异常 MyException.class
	 * 
	 * @param ex
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(value = GlobalException.class)
	public Map<String, String> myErrorHandler(GlobalException ex) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("code", ex.getCode());
		map.put("msg", ex.getMsg());
		return map;
	}

}