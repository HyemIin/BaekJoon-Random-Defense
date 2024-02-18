package com.hyem.baekjoon_random_defense.domain.exam.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GetCorrectExamDTO {
    private String email;
}
