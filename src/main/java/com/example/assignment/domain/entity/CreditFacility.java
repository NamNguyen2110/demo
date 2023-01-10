package com.example.assignment.domain.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
public class CreditFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long creditId;
    private Double totalLimit;
    private String currency;
    private LocalDate startDate;
    private LocalDate endDate;
    private String applicant;
}
