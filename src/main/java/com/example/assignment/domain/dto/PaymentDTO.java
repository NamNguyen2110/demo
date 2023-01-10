package com.example.assignment.domain.dto;

import lombok.Data;

@Data
public class PaymentDTO {
    private Long loanId;
    private Double paidAmount;
    private Double debt;
    private String applicant;
}
