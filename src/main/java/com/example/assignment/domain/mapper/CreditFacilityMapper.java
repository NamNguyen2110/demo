package com.example.assignment.domain.mapper;

import com.example.assignment.domain.dto.CreditFacilityDTO;
import com.example.assignment.domain.dto.LoanDTO;
import com.example.assignment.domain.entity.CreditFacility;
import com.example.assignment.domain.entity.Loan;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreditFacilityMapper {
    CreditFacility toEntity(CreditFacilityDTO dto);
    CreditFacilityDTO toDto(CreditFacility entity);
}
