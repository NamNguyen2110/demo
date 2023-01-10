package com.example.assignment.domain.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
public class CreditFacilityDTO {
    private Long creditId;
    private Double totalLimit;
    private String currency;
    private LocalDate startDate;
    private LocalDate endDate;
    private String applicant;
}
