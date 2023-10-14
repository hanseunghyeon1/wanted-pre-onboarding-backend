package com.example.preassignment.company.entity;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Company {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID companyId;

    @NotNull
    private String position;

    @NotNull
    private int reward;

    @NotNull
    private String content;

    @NotNull
    private String tech;

    @Builder
    public Company(UUID companyId, String position, int reward, String content, String tech) {
        this.companyId = companyId;
        this.position = position;
        this.reward = reward;
        this.content = content;
        this.tech = tech;
    }
}
