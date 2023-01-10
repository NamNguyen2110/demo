package com.example.assignment.controller;

import com.example.assignment.domain.dto.LoanDTO;
import com.example.assignment.domain.dto.PaymentDTO;
import com.example.assignment.domain.entity.Loan;
import com.example.assignment.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/loan")
public class LoanController {

    private final LoanService loanService;

    @PostMapping()
    public ResponseEntity<Loan> createNewLoan(
            @RequestBody LoanDTO loanDTO) {
        return ResponseEntity.ok(loanService.save(loanDTO));
    }

    @PostMapping("/paid")
    public ResponseEntity<Loan> paidLoan(@RequestBody PaymentDTO paidDTO) throws Exception {
        return ResponseEntity.ok(loanService.paidLoan(paidDTO));
    }

    @GetMapping("/{applicant}")
    public ResponseEntity<List<Loan>> getLoanByApplicant(@PathVariable("applicant") String applicant) {
        return ResponseEntity.ok(loanService.getLoanByApplicant(applicant));
    }


}
