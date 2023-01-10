package com.example.assignment.controller;

import com.example.assignment.domain.dto.LoanDTO;
import com.example.assignment.domain.dto.PaymentDTO;
import com.example.assignment.domain.entity.Loan;
import com.example.assignment.domain.entity.Payment;
import com.example.assignment.service.LoanService;
import com.example.assignment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping()
    public ResponseEntity<List<PaymentDTO>> get(
            @RequestParam Long loanId) {
        return ResponseEntity.ok(paymentService.getByLoan(loanId));
    }


}
