package com.example.preassignment.company.dto.response;

import java.util.UUID;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompanyRegistResponseDto {
    private UUID companyId;

    @Builder
    public CompanyRegistResponseDto(UUID companyId) {
        this.companyId = companyId;
    }
}
