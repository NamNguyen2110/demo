package com.example.assignment.service.impl;

import com.example.assignment.domain.dto.CreditFacilityDTO;
import com.example.assignment.domain.entity.CreditFacility;
import com.example.assignment.domain.mapper.CreditFacilityMapper;
import com.example.assignment.repository.CreditFacilityRepository;
import com.example.assignment.service.CreditFacilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
@RequiredArgsConstructor
public class CreditFacilityServiceImpl implements CreditFacilityService {

    private final CreditFacilityRepository creditFacilityRepository;
    private final CreditFacilityMapper creditFacilityMapper;
    @Override
    public CreditFacility save(CreditFacilityDTO dto) {

        //TODO validate credit data
        return creditFacilityRepository.save(creditFacilityMapper.toEntity(dto));
    }
}
