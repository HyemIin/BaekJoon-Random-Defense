package com.hyem.baekjoon_random_defense.domain.exam.service;

import com.hyem.baekjoon_random_defense.domain.exam.type.Tier;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ExamService {
    private final String URL = "https://www.acmicpc.net/problemset?sort=no_asc&tier=";

    public Document getRamdomExam(String tier) {
        String selectedTier = Tier.valueOf(tier).getTier();
        Document document = null;
        try {
            document = Jsoup.connect(URL+selectedTier).get();
            System.out.println(document);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Elements exam = document.select("div.problem-list a");
        return document;
    }

}
