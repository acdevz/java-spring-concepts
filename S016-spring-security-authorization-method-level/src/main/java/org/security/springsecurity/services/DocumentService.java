package org.security.springsecurity.services;

import org.security.springsecurity.models.Document;
import org.security.springsecurity.repositories.DocumentRepository;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Service;

@Service
public class DocumentService {
    private final DocumentRepository documentRepository;

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @PostAuthorize("returnObject.owner().equals(authentication.principal.username)")
    public Document getDocument(String code){
        return documentRepository.findDocumentByCode(code);
    }
}
