package com.bdcourtyard.business.documentType.dao;
import com.bdcourtyard.business.documentType.model.DocumentType;
import com.bdcourtyard.business.documentType.vo.DocumentTypeParm;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

import com.bdcourtyard.common.mybatis.QueryCondition;

/**
 *  DocumentTypeDao 资料类型
 *
 * @version : Ver 1.0
 * @date	: 2018-7-31
 */
@Repository
public interface DocumentTypeDao {
	
	int insertDocumentType(DocumentType documentType);
	
	int insertDocumentTypeBatch(List<DocumentType> list);

	//更行前验证
	DocumentType vailDateTypeName(DocumentType documentType);
	
	int updateDocumentTypeById(DocumentType documentType);
	
	boolean deleteDocumentTypeById(@Param("typeId")  String typeId  );
	
 	DocumentType getDocumentTypeById(@Param("typeId")  java.lang.String typeId  );

 	List<DocumentType> getDocumentTypes(DocumentType documentType);

	List<DocumentType> getDocumentTypesForPage(DocumentTypeParm parm);
 	
 	List<DocumentType> getDocumentTypesByConditions(@Param("conditions") List<QueryCondition> conditions);

}
