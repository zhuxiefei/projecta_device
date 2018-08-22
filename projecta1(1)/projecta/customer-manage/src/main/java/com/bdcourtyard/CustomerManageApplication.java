package com.bdcourtyard;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@MapperScan("com.bdcourtyard.business.*.dao")
// 将项目中对应的mapper类的路径加进来就可以了
public class CustomerManageApplication  extends WebMvcConfigurerAdapter{

	public static void main(String[] args) {
		SpringApplication.run(CustomerManageApplication.class, args);
	}

}


