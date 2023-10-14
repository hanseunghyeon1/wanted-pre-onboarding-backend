package com.example.preassignment.company.dto.response;

import com.example.preassignment.common.dto.response.ListResponseDto;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EmploymentSearchListResponseDto extends ListResponseDto {
    List<EmploymentSearchResponseDto> employmentList;
}
