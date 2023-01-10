package com.example.assignment.domain.mapper;

import com.example.assignment.domain.dto.LoanDTO;
import com.example.assignment.domain.dto.PaymentDTO;
import com.example.assignment.domain.entity.Loan;
import com.example.assignment.domain.entity.Payment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    Payment toEntity(PaymentDTO dto);
    PaymentDTO toDto(Payment entity);

    List<Payment> toEntity(List<PaymentDTO> dto);
    List<PaymentDTO> toDto(List<Payment> entity);
}
