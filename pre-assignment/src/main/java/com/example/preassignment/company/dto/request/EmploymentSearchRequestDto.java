package com.example.preassignment.company.dto.request;

import com.example.preassignment.common.dto.reqeust.ListRequestDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmploymentSearchRequestDto extends ListRequestDto {
    private String search;
}
