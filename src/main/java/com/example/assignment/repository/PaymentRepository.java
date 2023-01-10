package com.example.assignment.repository;

import com.example.assignment.domain.entity.Loan;
import com.example.assignment.domain.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    List<Payment> findByLoanId(Long loanId);
    
}
