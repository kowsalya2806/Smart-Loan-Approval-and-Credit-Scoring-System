package com.example.LoanApproval.service;

import com.example.LoanApproval.entity.Loan;
import com.example.LoanApproval.entity.Repayment;
import com.example.LoanApproval.repository.LoanRepository;
import com.example.LoanApproval.repository.RepaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepaymentService {
    

    @Autowired
    private RepaymentRepository repaymentRepository;

    @Autowired
    private LoanRepository loanRepository;

    public Repayment addRepayment(Long loanId, Repayment repayment){
        Loan loan = loanRepository.findById(loanId).orElseThrow(()-> new RuntimeException("Loan not found with ID:" + loanId
                 ));
        repayment.setLoan(loan);
        return repaymentRepository.save(repayment);
    }

    public List<Repayment> getRepayments(Long loanId){
        return repaymentRepository.findByLoanId(loanId);
    }
}
