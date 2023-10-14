package com.example.preassignment.company.dto.request;

import java.util.UUID;
import lombok.Getter;

@Getter
public class EmploymentUpdateRequestDto {
    private Long companyId;

    private String position;

    private int reward;

    private String content;

    private String tech;

}
