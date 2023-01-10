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
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;

    private final CreditFacilityService creditFacilityService;
    private final LoanMapper loanMapper;

    private final PaymentMapper paymentMapper;
    private final PaymentRepository paymentRepository;
    @Override
    public Loan save(LoanDTO loanDTO) {

        //TODO: validate loan data

        //TODO: validate limit of credis of applicant: total loan amount < credit

        //TODO: validate startDate < now < endDate of credit

        return loanRepository.save(loanMapper.toEntity(loanDTO));
    }

    @Override
    @Transactional
    public Loan paidLoan(PaymentDTO paidDTO) throws Exception {
        //TODO validate loanId not null, paidAmount not null, greater than 0

        Loan loan = loanRepository.findById(paidDTO.getLoanId()).
                orElseThrow(() -> new Exception("Loan not found"));

        Double debt = loan.getAmount() - paidDTO.getPaidAmount() > 0
                ? loan.getAmount() - paidDTO.getPaidAmount(): 0;
        loan.setAmount(debt);

        loan = loanRepository.save(loan);

        // save payment of loan
        Payment payment = paymentMapper.toEntity(paidDTO);
        payment.setDebt(debt);
        payment.setApplicant(loan.getApplicant());
        paymentRepository.save(payment);

        return loan;
    }

    @Override
    public List<Loan> getLoanByApplicant(String applicant) {
        return loanRepository.findByApplicant(applicant);
    }
}
