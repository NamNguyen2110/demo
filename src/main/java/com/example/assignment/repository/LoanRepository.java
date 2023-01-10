package com.example.assignment.repository;

import com.example.assignment.domain.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    List<Loan> findByApplicant(String applicant);
    
}
