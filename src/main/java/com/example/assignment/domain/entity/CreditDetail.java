package com.example.assignment.domain.entity;

import com.example.assignment.domain.enums.LoanType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class CreditDetail {

  @Id
  @Column(name = "credit_detail_id")
  private Long creaditDetailId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="credit_facility_id", nullable=false)
  private CreditFacility creditFacility;

  @Enumerated(EnumType.STRING)
  @Column(name = "loan_type")
  private LoanType loanType;

  @Column(name = "loan_limit")
  private Double loanLimit;
}
