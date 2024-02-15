package com.hyem.baekjoon_random_defense.domain.exam.repository;

import com.hyem.baekjoon_random_defense.domain.exam.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exam,Long> {
}
