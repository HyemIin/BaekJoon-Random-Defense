package com.hyem.baekjoon_random_defense.domain.exam.controller;

import com.hyem.baekjoon_random_defense.domain.exam.service.BaekJoonCrwalService;
import com.hyem.baekjoon_random_defense.domain.exam.service.ExamService;
import com.hyem.baekjoon_random_defense.domain.global.api.ApiUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ExamController {
    private final BaekJoonCrwalService baekJoonCrwalService;
    private final ExamService ExamService;

    @PostMapping("/")
    public ResponseEntity<?> getCorrectExam(@RequestParam(name = "account") String account) {
        return ResponseEntity
            .ok()
            .body(ApiUtils.success(baekJoonCrwalService.getUserCorrectExamNumber(account)));
    }

    @GetMapping("/")
    public ResponseEntity<?> getRandomExam(@RequestParam(name = "tier") String tier) {
        return ResponseEntity
            .ok()
            .body(ApiUtils.success(ExamService.getRamdomExam(tier)));
    }

    @GetMapping("/challenge")
    public ResponseEntity<?> getChallengeExam(
        @RequestParam(name = "tier") String tier,
        @RequestParam(name = "account") String account) {
        return ResponseEntity
            .ok()
            .body(ApiUtils.success(ExamService.getChallengeExam(tier, account)));
    }

}
