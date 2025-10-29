package com.example.LoanApproval.service;

import com.example.LoanApproval.entity.CreditScore;
import com.example.LoanApproval.entity.Loan;
import com.example.LoanApproval.repository.CreditScoreRepository;
import com.example.LoanApproval.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CreditScoreService {
    
    @Autowired
    private CreditScoreRepository  creditScoreRepository;

    @Autowired
    private LoanRepository loanRepository;

    public CreditScore calculateScore(Long loanId){
        Loan loan = loanRepository.findById(loanId).orElseThrow(()-> new RuntimeException("Loan not found with ID: " + loanId));
        double amount = loan.getAmount();
        int score;
        String risk;

        if(amount <= 50000){
            score = 750;
            risk ="LOW";

        }
        else if(amount <=200000){
            score =650;
            risk="MEDIUM";
        }
        else{
            score =550;
            risk = "HIGH";
        }

        CreditScore creditScore = new CreditScore();
        creditScore.setLoan(loan);
        creditScore.setScore(score);
        creditScore.setRiskLevel(risk);

        return creditScoreRepository.save(creditScore);
    }

    public Optional<CreditScore> getScoreByLoan(Long loanId){
        return creditScoreRepository.findByLoanId(loanId);
    }
}
