package com.hyem.baekjoon_random_defense.domain.exam.type;

import lombok.Getter;

@Getter
public enum Tier {
    BRONZE("1%2C2%2C3%2C4%2C5"),SILVER("6%2C7%2C8%2C9%2C10");
    private final String tier;
    Tier(String tier) {
        this.tier = tier;
    }
}
