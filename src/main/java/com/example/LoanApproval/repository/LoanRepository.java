package com.example.LoanApproval.repository;

import com.example.LoanApproval.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long>{

    List<Loan> findByUserId(Long userId);

    Long countByStatus(String status);
    
}
