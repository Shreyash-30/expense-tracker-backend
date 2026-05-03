package com.project.paytrack_backend.repository;

import com.project.paytrack_backend.model.PaymentCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentCategory, Integer> {

}
