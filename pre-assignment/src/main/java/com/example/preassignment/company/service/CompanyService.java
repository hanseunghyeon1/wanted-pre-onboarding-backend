package com.example.preassignment.company.service;

import com.example.preassignment.company.dto.request.CompanyCreateRequestDto;
import com.example.preassignment.company.entity.Company;
import com.example.preassignment.company.repository.CompanyRepository;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;

    @Transactional
    public void create(CompanyCreateRequestDto requestDto){
        companyRepository.save(Company.builder()
                .name(requestDto.getName())
                .nation(requestDto.getNation())
                .region(requestDto.getRegion())
            .build());
    }
}
