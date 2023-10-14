package com.example.preassignment.company.dto.response;

import java.util.UUID;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EmploymentRegistResponseDto {
    private Long companyId;

    @Builder
    public EmploymentRegistResponseDto(Long companyId) {
        this.companyId = companyId;
    }
}
