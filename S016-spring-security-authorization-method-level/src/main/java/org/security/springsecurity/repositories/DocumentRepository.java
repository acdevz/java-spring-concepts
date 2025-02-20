package org.security.springsecurity.repositories;

import org.security.springsecurity.models.Document;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DocumentRepository {
    private final Map<String, Document> data = new HashMap<>(Map.of(
            "113114", new Document(24L,"acdevs"),
            "454545", new Document(96L, "admin")
    ));

    public Document findDocumentByCode(String code){
        return data.get(code);
    }
}
