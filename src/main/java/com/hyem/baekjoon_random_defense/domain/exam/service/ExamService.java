package com.hyem.baekjoon_random_defense.domain.exam.service;

import com.hyem.baekjoon_random_defense.domain.exam.type.Tier;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class ExamService {
    private final String URL = "https://www.acmicpc.net/problemset?sort=no_asc&tier=";

    public String getRamdomExam(String tier) {
        String selectedTier = Tier.valueOf(tier).getTier();
        List ExamCandidateList = new ArrayList<>();
        try {
            //티어별 문제 리스트 특정 페이지 가져오기
            Document selectedPageUrl = getDocument(selectedTier);
            //위에서 가져온 페이지에 포함된 문제번호 파싱
            Elements selectedExam = selectedPageUrl.select("td.list_problem_id");
            getRandomExamNumber(selectedExam, ExamCandidateList);
            String Exam;
            for (Object examNumber : ExamCandidateList) {
                return "https://www.acmicpc.net/problem/" + examNumber;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return selectedTier;
    }

    private static void getRandomExamNumber(Elements selectedExam, List ExamCandidateList) {
        for (Element element : selectedExam) {
            String parsedElement = element.text();
            String ExamNumber = parsedElement.replaceAll("[^0-9]", "");
            ExamCandidateList.add(ExamNumber);
        }
    }

    private Document getDocument(String selectedTier) throws IOException {
        Document document = Jsoup.connect(URL+ selectedTier).get();
        Elements pageList = document.select("div.text-center ul.pagination li");
        int randomPageNumber = new Random().nextInt(pageList.size());
        Document selectedPageUrl = Jsoup.connect(URL+ selectedTier +"&page="+randomPageNumber).get();
        return selectedPageUrl;
    }

}
