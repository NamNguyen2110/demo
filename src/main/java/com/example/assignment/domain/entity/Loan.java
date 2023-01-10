package com.example.assignment.domain.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;
    private Double amount;
    private String currency;
    private LocalDate startDate;
    private LocalDate endDate;
    private String interestRate;
    private String applicant;
}
