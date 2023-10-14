package com.example.preassignment.company.controller;

import com.example.preassignment.company.dto.request.CompanyCreateRequestDto;
import com.example.preassignment.company.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/companies")
public class CompanyController {
    private final CompanyService companyService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CompanyCreateRequestDto requestDto){
        companyService.create(requestDto);
        return ResponseEntity.ok().build();
    }
}
