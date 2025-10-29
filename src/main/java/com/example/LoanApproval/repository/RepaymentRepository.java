package com.example.LoanApproval.repository;

import com.example.LoanApproval.entity.Repayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  RepaymentRepository extends JpaRepository<Repayment, Long>{
    
    List<Repayment> findByLoanId(Long loanId);
}
