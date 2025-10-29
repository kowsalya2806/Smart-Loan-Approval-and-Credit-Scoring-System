package com.example.LoanApproval.controller;

import com.example.LoanApproval.entity.CreditScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/creditscore")
public class CreditScoreController{
    
    @Autowired
    private com.example.LoanApproval.service.CreditScoreService creditScoreService;

    @PostMapping("/calculate/{loanId}")
    public ResponseEntity<CreditScore> calculateScore(@PathVariable Long loanId){
        CreditScore score = creditScoreService.calculateScore(loanId);
        return ResponseEntity.ok(score);
 
    }

    @GetMapping("/{loanId}")
    public ResponseEntity<CreditScore> getScore(@PathVariable Long loanId){
        return creditScoreService.getScoreByLoan(loanId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}