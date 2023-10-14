package com.example.preassignment.company.repository;

import com.example.preassignment.company.dto.request.EmploymentSearchRequestDto;
import com.example.preassignment.company.dto.response.EmploymentSearchResponseDto;
import com.example.preassignment.company.repository.querydslCustom.EmploymentRepositoryCustom;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import static com.example.preassignment.company.entity.QEmployment.employment;

@RequiredArgsConstructor
public class EmploymentRepositoryImpl implements EmploymentRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Page<EmploymentSearchResponseDto> searchEmployment(EmploymentSearchRequestDto requestDto, Pageable pageable){
        List<EmploymentSearchResponseDto> content = jpaQueryFactory
            .select(Projections.constructor(EmploymentSearchResponseDto.class,
                employment.employmentId,
                employment.company.name,
                employment.company.nation,
                employment.company.region,
                employment.position,
                employment.reward,
                employment.tech))
            .from(employment)
            .where(allEq(requestDto.getSearch()))
            .offset(pageable.getOffset())
            .limit(requestDto.getPageSize())
            .fetch();

        Long count = jpaQueryFactory
            .select(employment.count())
            .from(employment)
            .where(allEq(requestDto.getSearch())
            ).fetchOne();

        return new PageImpl<>(content, pageable, count);
    }

    private BooleanExpression nameEq(String keyword){
        return keyword == null ? null : employment.company.name.containsIgnoreCase(keyword);
    }

    private BooleanExpression nationEq(String keyword){
        return keyword == null ? null : employment.company.nation.containsIgnoreCase(keyword);
    }

    private BooleanExpression regionEq(String keyword){
        return keyword == null ? null : employment.company.region.containsIgnoreCase(keyword);
    }

    private BooleanExpression positionEq(String keyword){
        return keyword == null ? null : employment.position.containsIgnoreCase(keyword);
    }

    private BooleanExpression techEq(String keyword){
        return keyword == null ? null : employment.tech.containsIgnoreCase(keyword);
    }

    private BooleanExpression allEq(String keyword){
        return keyword == null ? null : nameEq(keyword)
            .or(nationEq(keyword))
            .or(regionEq(keyword))
            .or(positionEq(keyword))
            .or(techEq(keyword));
    }
}
