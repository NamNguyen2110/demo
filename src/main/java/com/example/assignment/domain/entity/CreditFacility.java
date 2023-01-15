package com.example.assignment.domain.entity;

import java.awt.print.Book;
import java.util.Iterator;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
public class CreditFacility {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "credit_id")
  private Long creditId;

  @Column(name = "total_limit")
  private Double totalLimit;

  @Column(name = "currency")
  private String currency;

  @Column(name = "start_date")
  private LocalDate startDate;

  @Column(name = "end_date")
  private LocalDate endDate;

  @Column(name = "applicant_id")
  private String applicantId;

  @OneToMany(
      mappedBy = "creditFacility",
      cascade = CascadeType.ALL,
      fetch = FetchType.LAZY)
  private Set<CreditDetail> creditDetails;

  public void addCreditDetail(CreditDetail creditDetail) {
    this.creditDetails.add(creditDetail);
  }

  public void removeCreditDetail(CreditDetail creditDetail) {
    creditDetail.setCreditFacility(null);
    this.creditDetails.remove(creditDetail);
  }

  public void removeBooks() {
    Iterator<CreditDetail> iterator = this.creditDetails.iterator();
    while (iterator.hasNext()) {
      CreditDetail creditDetail = iterator.next();
      creditDetail.setCreditFacility(null);
      iterator.remove();
    }
  }
}
