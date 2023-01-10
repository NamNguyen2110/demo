package com.example.assignment.controller;

import com.example.assignment.domain.dto.CreditFacilityDTO;
import com.example.assignment.domain.entity.CreditFacility;
import com.example.assignment.service.CreditFacilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/credit")
public class CreditFacilityController {

    private final CreditFacilityService creditFacilityService;

    @PostMapping()
    public ResponseEntity<CreditFacility> createNewCreadit(
            @RequestBody CreditFacilityDTO creditFacilityDTO) {
        return ResponseEntity.ok(creditFacilityService.save(creditFacilityDTO));
    }
}
