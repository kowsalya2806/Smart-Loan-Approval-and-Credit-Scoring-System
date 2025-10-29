package com.example.LoanApproval.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "documents")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Document {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String documentType;

    private String fileName;

    private String filePath;

    private boolean verified;

    @OneToOne@JoinColumn(name= "loan_id")
    private Loan loan;
}
