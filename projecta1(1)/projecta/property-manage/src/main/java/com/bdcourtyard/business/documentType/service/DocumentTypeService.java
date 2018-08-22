package com.bdcourtyard.business.documentType.service;
import com.bdcourtyard.business.documentType.vo.DocumentTypeParm;
import com.bdcourtyard.common.page.Page;
import org.springframework.data.domain.Pageable;
import com.bdcourtyard.business.documentType.model.DocumentType;
import java.util.List;

/**
 *  DocumentTypeService
 *
 * @version : Ver 1.0
 * @date	: 2018-7-31 
 */
public interface DocumentTypeService {
	
	int insertDocumentType(DocumentType documentType);
	
	int insertDocumentTypeBatch(List<DocumentType> list);
	
	int updateDocumentTypeById(DocumentType documentType);
	
	boolean deleteDocumentTypeById(String typeId);
	
 	DocumentType getDocumentTypeById(String typeId);
 
 	List<DocumentType> getDocumentTypes(DocumentType documentType);

 	Page<DocumentType> getDocumentTypesForPage(DocumentTypeParm param,Pageable pageable);
}
