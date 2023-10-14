package com.example.preassignment.common.dto.response;

import com.example.preassignment.common.PagingUtil;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
public class ListResponseDto {
    private PagingUtil pagingUtil;
}
