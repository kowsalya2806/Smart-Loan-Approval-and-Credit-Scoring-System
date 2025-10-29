package com.example.LoanApproval.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "credit_scores")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class CreditScore {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer score;

    private String riskLevel;

    @OneToOne
    @JoinColumn(name = "loan_id")
    private Loan loan;
}
