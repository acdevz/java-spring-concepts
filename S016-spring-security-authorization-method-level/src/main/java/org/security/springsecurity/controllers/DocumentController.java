package org.security.springsecurity.controllers;

import org.security.springsecurity.models.Document;
import org.security.springsecurity.repositories.DocumentRepository;
import org.security.springsecurity.services.DocumentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DocumentController {
    private final DocumentService documentService;

    @GetMapping("/document/{code}")
    public Document getDocument(@PathVariable String code){
        return documentService.getDocument(code);
    }

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }
}
