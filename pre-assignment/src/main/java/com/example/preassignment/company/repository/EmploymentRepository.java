package com.example.preassignment.company.repository;

import com.example.preassignment.company.entity.Employment;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmploymentRepository extends JpaRepository<Employment, Long> {

}