package com.example.assignment.service.impl;

import com.example.assignment.domain.dto.LoanDTO;
import com.example.assignment.domain.dto.PaymentDTO;
import com.example.assignment.domain.entity.CreditFacility;
import com.example.assignment.domain.entity.Loan;
import com.example.assignment.domain.entity.Payment;
import com.example.assignment.domain.mapper.LoanMapper;
import com.example.assignment.domain.mapper.PaymentMapper;
import com.example.assignment.repository.CreditFacilityRepository;
import com.example.assignment.repository.LoanRepository;
import com.example.assignment.repository.PaymentRepository;
import com.example.assignment.service.CreditFacilityService;
import com.example.assignment.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;

    private final CreditFacilityRepository creditFacilityRepository;
    private final LoanMapper loanMapper;

    private final PaymentMapper paymentMapper;
    private final PaymentRepository paymentRepository;
    @Override
    public Loan save(LoanDTO loanDTO) {

        //TODO: validate loan data
        Assert.isTrue(loanDTO.getLoanId() != null, "loanId is required");
        Assert.isTrue(loanDTO.getApplicant() != null, "applicant is required");
        Assert.isTrue(loanDTO.getCurrency() != null, "currency is required");
        Assert.isTrue(loanDTO.getStartDate() != null, "startDate is required");
        Assert.isTrue(loanDTO.getEndDate() != null, "endDate is required");
        Assert.isTrue(loanDTO.getAmount() != null, "amount is required");
        Assert.isTrue(loanDTO.getInterestRate() != null, "rate is required");


        //TODO: validate limit of credis of applicant: total loan amount < credit

        CreditFacility credit = creditFacilityRepository.findByApplicant(loanDTO.getApplicant());

        List<Loan> loansOfApplicant = getLoanByApplicant(loanDTO.getApplicant());

        Double totalDebt = loansOfApplicant.stream().map(Loan::getAmount).collect(Collectors.summingDouble(Double::intValue));

        Assert.isTrue(credit.getTotalLimit() <= totalDebt, "cant create loan. total debt is maximum");

        //TODO: validate startDate < now < endDate of credit

        Assert.isTrue(credit.getStartDate().isBefore(LocalDate.now()) && credit.getEndDate().isAfter(LocalDate.now()), "credit is out of date");

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
