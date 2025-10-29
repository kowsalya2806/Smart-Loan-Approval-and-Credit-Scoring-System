package com.example.LoanApproval.service;

import com.example.LoanApproval.entity.Loan;
import com.example.LoanApproval.entity.User;
import com.example.LoanApproval.repository.LoanRepository;
import com.example.LoanApproval.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private UserRepository userRepository;

    public Loan applyLoan(Long userId, Loan loan){
        Optional<User> userOpt = userRepository.findById(userId);
        if(userOpt.isPresent()){
            loan.setUser(userOpt.get());
            loan.setStatus("PENDING");
            loan.setApplicationDate(LocalDate.now());
            return loanRepository.save(loan);
        }
        else{
            throw new RuntimeException("User not found with ID:" + userId);
        }
    }
    
    public List<Loan> getLoansByUser(Long userId){
        return loanRepository.findByUserId(userId);
    }
    
    public List<Loan> getAllLoans(){
        return loanRepository.findAll();
    }
}
