package com.example.LoanApproval.controller;

import com.example.LoanApproval.entity.Repayment;
import com.example.LoanApproval.service.RepaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/repayments")
public class RepaymentController {
 
    @Autowired
    private RepaymentService repaymentService;

    @PostMapping("/{loanId}")
    public ResponseEntity<Repayment> addRepayment(@PathVariable Long loanId, @RequestBody Repayment repayment){
        Repayment saved = repaymentService.addRepayment(loanId, repayment);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{loanId}")
    public ResponseEntity<List<Repayment>> getRepayments(@PathVariable Long loanId){
        List<Repayment> repayments = repaymentService.getRepayments(loanId);
        return ResponseEntity.ok(repayments);
    }
}
