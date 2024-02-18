package com.hyem.baekjoon_random_defense.domain.exam.type;

import lombok.Getter;

@Getter
public enum Tier {
    BRONZE("1%2C2%2C3%2C4%2C5"),SILVER("6%2C7%2C8%2C9%2C10"),
    GOLD("11%2C12%2C13%2C14%2C15"),PLATINUM("16%2C17%2C18%2C19%2C20"),
    DIAMOND("21%2C22%2C23%2C24%2C25"), RUBY("26%2C27%2C28%2C29%2C30");
    private final String tier;
    Tier(String tier) {
        this.tier = tier;
    }
}
