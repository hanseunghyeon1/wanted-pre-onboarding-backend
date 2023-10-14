package com.example.preassignment.company.service;

import com.example.preassignment.company.dto.request.CompanyRegistRequestDto;
import com.example.preassignment.company.dto.request.CompanyUpdateRequestDto;
import com.example.preassignment.company.dto.response.CompanyRegistResponseDto;
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
    public CompanyRegistResponseDto regist(CompanyRegistRequestDto requestDto){
        Company companyBuilder = Company.builder()
            .position(requestDto.getPosition())
            .reward(requestDto.getReward())
            .content(requestDto.getContent())
            .tech(requestDto.getTech())
            .build();

        Company saved = companyRepository.save(companyBuilder);

        return CompanyRegistResponseDto.builder()
            .companyId(saved.getCompanyId())
            .build();
    }

    @Transactional
    public void update(CompanyUpdateRequestDto requestDto){
        Company company = companyRepository.findById(requestDto.getCompanyId())
            .orElseThrow(() -> new NullPointerException("id에 맞는 company가 없음"));

        company.companyUpdate(requestDto);
    }
}
