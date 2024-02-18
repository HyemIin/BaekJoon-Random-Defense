package com.hyem.baekjoon_random_defense.domain.global.api;

public class ApiResult<T> {
    private final boolean success;
    private final T response;
    private final ApiError error;

    public ApiResult(boolean success, T response, ApiError error) {
        this.success = success;
        this.response = response;
        this.error = error;
    }

    public boolean isSuccess() {
        return success;
    }

    public T getResponse() {
        return response;
    }
}
