package com.example.preassignment.company.entity;

import com.example.preassignment.company.dto.request.EmploymentUpdateRequestDto;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Employment {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private Long employmentId;

    @NotNull
    private String position;

    @NotNull
    private int reward;

    @NotNull
    private String content;

    @NotNull
    private String tech;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "companyId")
    private Company company;

    @Builder
    public Employment(Long employmentId, String position, int reward, String content, String tech,
        Company company) {
        this.employmentId = employmentId;
        this.position = position;
        this.reward = reward;
        this.content = content;
        this.tech = tech;
        this.company = company;
    }

    public void employmentUpdate(EmploymentUpdateRequestDto requestDto){
        this.position = requestDto.getPosition();
        this.reward = requestDto.getReward();
        this.content = requestDto.getContent();
        this.tech = requestDto.getTech();
    }
}
