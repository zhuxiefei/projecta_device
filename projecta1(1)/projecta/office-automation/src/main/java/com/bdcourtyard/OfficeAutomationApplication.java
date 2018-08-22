package com.bdcourtyard;

import com.bdcourtyard.common.security.WebHandlerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@MapperScan("com.bdcourtyard.business.*.dao")
// 将项目中对应的mapper类的路径加进来就可以了
public class OfficeAutomationApplication extends WebMvcConfigurerAdapter{

	@Autowired
	WebHandlerInterceptor webHandlerInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(webHandlerInterceptor).addPathPatterns("oa/web/**");
	}

	public static void main(String[] args) {
		SpringApplication.run(OfficeAutomationApplication.class, args);
	}

}


