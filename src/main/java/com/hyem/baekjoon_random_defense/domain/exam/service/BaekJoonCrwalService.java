package com.hyem.baekjoon_random_defense.domain.exam.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class BaekJoonCrwalService {

    public List<String> getUserCorrectExamNumber(String account) {
        List<String> ExamSuccessNumberList;
        try {
            Document document = Jsoup.connect("https://www.acmicpc.net/user/"+account).get();
            Elements exam = document.select("div.problem-list a");
            ExamSuccessNumberList = new ArrayList<>();
            for (Element element : exam) {
                String parsedElement = element.text();
                String ExamNumber = parsedElement.replaceAll("[^0-9]", "");
                ExamSuccessNumberList.add(ExamNumber);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ExamSuccessNumberList;
    }

}
