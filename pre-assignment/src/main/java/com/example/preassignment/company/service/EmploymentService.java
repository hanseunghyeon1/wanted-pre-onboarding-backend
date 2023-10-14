package com.example.preassignment.company.service;

import com.example.preassignment.common.PagingUtil;
import com.example.preassignment.company.dto.request.EmploymentRegistRequestDto;
import com.example.preassignment.company.dto.request.EmploymentSearchRequestDto;
import com.example.preassignment.company.dto.request.EmploymentUpdateRequestDto;
import com.example.preassignment.company.dto.response.EmploymentRegistResponseDto;
import com.example.preassignment.company.dto.response.EmploymentSearchListResponseDto;
import com.example.preassignment.company.dto.response.EmploymentSearchResponseDto;
import com.example.preassignment.company.entity.Company;
import com.example.preassignment.company.entity.Employment;
import com.example.preassignment.company.repository.CompanyRepository;
import com.example.preassignment.company.repository.EmploymentRepository;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmploymentService {
    private final EmploymentRepository employmentRepository;

    private final CompanyRepository companyRepository;

    @Transactional
    public EmploymentRegistResponseDto regist(EmploymentRegistRequestDto requestDto){
        Company company = companyRepository.findById(requestDto.getCompanyId())
            .orElseThrow(() -> new NullPointerException("id에 맞는 회사가 없음"));

        Employment employmentBuilder = Employment.builder()
            .position(requestDto.getPosition())
            .reward(requestDto.getReward())
            .content(requestDto.getContent())
            .tech(requestDto.getTech())
            .company(company)
            .build();

        Employment saved = employmentRepository.save(employmentBuilder);

        return EmploymentRegistResponseDto.builder()
            .companyId(saved.getEmploymentId())
            .build();
    }

    @Transactional
    public void update(EmploymentUpdateRequestDto requestDto){
        Employment employment = employmentRepository.findById(requestDto.getEmploymentId())
            .orElseThrow(() -> new NullPointerException("id에 맞는 공고가 없음"));

        employment.employmentUpdate(requestDto);
    }

    @Transactional
    public void delete(Long employmentIds){
        employmentRepository.deleteById(employmentIds);
    }

    public EmploymentSearchListResponseDto searchEmploymentList(EmploymentSearchRequestDto requestDto){
        Page<EmploymentSearchResponseDto> list = employmentRepository.searchEmployment(requestDto,
            PageRequest.of(requestDto.getPage(), requestDto.getPageSize()));
        return EmploymentSearchListResponseDto.builder()
            .pagingUtil(new PagingUtil(list.getTotalElements(), list.getTotalPages(), list.getNumber(), list.getSize()))
            .employmentList(list.toList())
            .build();
    }
}
