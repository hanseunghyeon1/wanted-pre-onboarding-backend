package com.example.preassignment.company.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CompanyRegistRequestDto {
    private String position;

    private int reward;

    private String content;

    private String tech;

    @Builder
    public CompanyRegistRequestDto(String position, int reward, String content,
        String tech) {
        this.position = position;
        this.reward = reward;
        this.content = content;
        this.tech = tech;
    }
}
