package com.hyem.baekjoon_random_defense.domain.exam.controller;

import com.hyem.baekjoon_random_defense.domain.exam.dto.request.RequestCorrectExamDTO;
import com.hyem.baekjoon_random_defense.domain.exam.service.BaekJoonCrwalService;
import com.hyem.baekjoon_random_defense.domain.global.api.ApiUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExamController {
    private final BaekJoonCrwalService baekJoonCrwalService;

    @PostMapping("/")
    public ResponseEntity<?> getCorrectExam(@RequestBody RequestCorrectExamDTO requestCorrectExamDTO) {
        return ResponseEntity
            .ok()
            .body(ApiUtils.success(baekJoonCrwalService.getCorrectExamNumber(requestCorrectExamDTO)));
    }

}
