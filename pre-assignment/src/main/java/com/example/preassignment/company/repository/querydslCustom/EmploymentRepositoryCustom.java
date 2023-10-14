package com.example.preassignment.company.repository.querydslCustom;

import com.example.preassignment.company.dto.request.EmploymentSearchRequestDto;
import com.example.preassignment.company.dto.response.EmploymentSearchResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmploymentRepositoryCustom {
    Page<EmploymentSearchResponseDto> searchEmployment(EmploymentSearchRequestDto requestDto, Pageable pageable);
}
