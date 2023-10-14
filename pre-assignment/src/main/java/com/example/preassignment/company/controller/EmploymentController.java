package com.example.preassignment.company.controller;

import com.example.preassignment.company.dto.request.EmploymentRegistRequestDto;
import com.example.preassignment.company.dto.request.EmploymentSearchRequestDto;
import com.example.preassignment.company.dto.request.EmploymentUpdateRequestDto;
import com.example.preassignment.company.dto.response.EmploymentRegistResponseDto;
import com.example.preassignment.company.dto.response.EmploymentSearchListResponseDto;
import com.example.preassignment.company.service.EmploymentService;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employments")
public class EmploymentController {

    private final EmploymentService employmentService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody EmploymentRegistRequestDto requestDto){
        EmploymentRegistResponseDto response = employmentService.regist(requestDto);

        URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{companyId}")
            .buildAndExpand(response.getCompanyId())
            .toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody EmploymentUpdateRequestDto requestDto){
        employmentService.update(requestDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{employmentId}")
    public ResponseEntity<Void> delete(@PathVariable Long employmentId){
        employmentService.delete(employmentId);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<EmploymentSearchListResponseDto> getEmploymentList(EmploymentSearchRequestDto requestDto){
        System.out.println(requestDto.getSearch());
        EmploymentSearchListResponseDto list = employmentService.searchEmploymentList(requestDto);
        return ResponseEntity.ok(list);
    }
}
