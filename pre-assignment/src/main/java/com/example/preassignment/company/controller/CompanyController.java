package com.example.preassignment.company.controller;

import com.example.preassignment.company.dto.request.CompanyRegistRequestDto;
import com.example.preassignment.company.dto.request.CompanyUpdateRequestDto;
import com.example.preassignment.company.dto.response.CompanyRegistResponseDto;
import com.example.preassignment.company.service.CompanyService;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequiredArgsConstructor
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CompanyRegistRequestDto requestDto){
        CompanyRegistResponseDto response = companyService.regist(requestDto);

        URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{companyId}")
            .buildAndExpand(response.getCompanyId())
            .toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody CompanyUpdateRequestDto requestDto){
        companyService.update(requestDto);
        return ResponseEntity.ok().build();
    }
}
