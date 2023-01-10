package com.example.assignment.service;

import com.example.assignment.domain.dto.LoanDTO;
import com.example.assignment.domain.dto.PaymentDTO;
import com.example.assignment.domain.entity.Loan;

import java.util.List;

public interface PaymentService {
    List<PaymentDTO> getByLoan(Long loanId);
}
