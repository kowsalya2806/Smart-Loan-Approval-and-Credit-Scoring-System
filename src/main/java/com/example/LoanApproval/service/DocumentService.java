package com.example.LoanApproval.service;

import com.example.LoanApproval.entity.Document;
import com.example.LoanApproval.entity.Loan;
import com.example.LoanApproval.repository.DocumentRepository;
import com.example.LoanApproval.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import javax.management.RuntimeErrorException;

@Service
public class DocumentService {
    
    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private LoanRepository loanRepository;

    public Document uploadDocument(Long loanId, Document document){
        Loan loan = loanRepository.findById(loanId).orElseThrow(()-> new RuntimeException("Loan not found with ID: " + loanId));
        document.setLoan(loan);
        document.setVerified(false);
        return documentRepository.save(document);
    }

    public Optional<Document> getDocument(Long loanId){
        return documentRepository.findByLoanId(loanId);
    }

    public Document verifyDocument(Long docId){
        Document doc = documentRepository.findById(docId).orElseThrow(()-> new RuntimeException("Document not found with ID: " + docId));
        doc.setVerified(true);
        return documentRepository.save(doc);
    }
}
