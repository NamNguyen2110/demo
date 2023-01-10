package com.example.assignment.service;

import com.example.assignment.domain.dto.CreditFacilityDTO;
import com.example.assignment.domain.entity.CreditFacility;
import org.springframework.stereotype.Service;

public interface CreditFacilityService {
    CreditFacility save(CreditFacilityDTO creditFacilityDTO);
}
