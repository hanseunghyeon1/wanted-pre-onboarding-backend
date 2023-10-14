package com.example.preassignment.company.dto.request;

import java.util.UUID;
import lombok.Getter;

@Getter
public class CompanyUpdateRequestDto {
    private UUID companyId;

    private String position;

    private int reward;

    private String content;

    private String tech;

}
