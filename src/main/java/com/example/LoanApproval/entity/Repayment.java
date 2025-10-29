package com.example.LoanApproval.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "repayments")
@Data


public class Repayment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dueDate;

    private Double amount;

    private boolean paid;

    @ManyToOne
    @JoinColumn(name = "loan_id")
    private Loan loan;
}
