package com.example.assignment.domain.mapper;

import com.example.assignment.domain.dto.LoanDTO;
import com.example.assignment.domain.dto.request.UserRequest;
import com.example.assignment.domain.entity.Loan;
import com.example.assignment.domain.entity.Users;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LoanMapper {
    Loan toEntity(LoanDTO dto);
    LoanDTO toDto(Loan entity);
}
