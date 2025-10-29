package com.example.LoanApproval.controller;

import com.example.LoanApproval.entity.Document;
import com.example.LoanApproval.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @PostMapping("/upload/{loanId}")
    public ResponseEntity<Document> uploadDocument(@PathVariable Long loanId, @RequestBody Document document) {
        Document saved = documentService.uploadDocument(loanId, document);
        return ResponseEntity.ok(saved);
    }

   
    @GetMapping("/{loanId}")
    public ResponseEntity<Document> getDocument(@PathVariable Long loanId) {
        return documentService.getDocument(loanId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    
    @PutMapping("/verify/{docId}")
    public ResponseEntity<Document> verifyDocument(@PathVariable Long docId) {
        Document verified = documentService.verifyDocument(docId);
        return ResponseEntity.ok(verified);
    }
}