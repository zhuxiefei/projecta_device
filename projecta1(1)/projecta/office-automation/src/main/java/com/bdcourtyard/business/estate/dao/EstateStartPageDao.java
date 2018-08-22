package com.bdcourtyard.business.estate.dao;

import com.bdcourtyard.business.estate.model.EstateStartPage;
import com.bdcourtyard.common.mybatis.QueryCondition;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  EstateStartPageDao app启动页的广告
 *
 * @version : Ver 1.0
 * @date	: 2018-7-19
 */
@Repository
public interface EstateStartPageDao {
	
	int insertEstateStartPage(EstateStartPage estateStartPage);
	
	int insertEstateStartPageBatch(List<EstateStartPage> list);
	
	int updateEstateStartPageById(EstateStartPage estateStartPage);
	
	int deleteEstateStartPageById(@Param("pageId") String pageId);

 	EstateStartPage getEstateStartPageById(@Param("pageId") String pageId);

 	List<EstateStartPage> getEstateStartPages(@Param("estateStartPage") EstateStartPage estateStartPage);
 	
 	List<EstateStartPage> getEstateStartPagesByConditions(@Param("conditions") List<QueryCondition> conditions);

	List<String> findPages(Integer appType);
}
