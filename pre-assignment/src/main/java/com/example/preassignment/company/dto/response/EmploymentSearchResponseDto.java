package com.example.preassignment.company.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EmploymentSearchResponseDto {
    private Long employmentId;

    private String name;

    private String nation;

    private String region;

    private String position;

    private Integer reward;

    private String tech;

    public EmploymentSearchResponseDto(Long employmentId, String name, String nation, String region, String position, Integer reward, String tech) {
        this.employmentId = employmentId;
        this.name = name;
        this.nation = nation;
        this.region = region;
        this.position = position;
        this.reward = reward;
        this.tech = tech;
    }
}
