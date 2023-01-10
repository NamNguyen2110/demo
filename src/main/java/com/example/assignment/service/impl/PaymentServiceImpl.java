package com.example.assignment.service.impl;

import com.example.assignment.domain.dto.LoanDTO;
import com.example.assignment.domain.dto.PaymentDTO;
import com.example.assignment.domain.entity.Loan;
import com.example.assignment.domain.entity.Payment;
import com.example.assignment.domain.mapper.LoanMapper;
import com.example.assignment.domain.mapper.PaymentMapper;
import com.example.assignment.repository.LoanRepository;
import com.example.assignment.repository.PaymentRepository;
import com.example.assignment.service.CreditFacilityService;
import com.example.assignment.service.LoanService;
import com.example.assignment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    private final PaymentMapper paymentMapper;

    @Override
    public List<PaymentDTO> getByLoan(Long loanId) {
        return paymentMapper.toDto(paymentRepository.findByLoanId(loanId));
    }
}
