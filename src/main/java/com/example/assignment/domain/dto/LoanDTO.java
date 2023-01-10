package com.example.assignment.domain.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class LoanDTO {
    private Long loanId;
    private Double amount;
    private String currency;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double interestRate;
    private String applicant;
}
