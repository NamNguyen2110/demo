package com.example.assignment.repository;

import com.example.assignment.domain.entity.CreditFacility;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditFacilityRepository extends JpaRepository<CreditFacility, Long> {
    CreditFacility findByApplicant(String applicant);
}
