package com.example.demo.util;


public enum CustomHttpStatus{
    CUSTOM_VALUE(1080, 2, "Good");
    private final int value;
    private int series;
    private final String state;

    CustomHttpStatus(int value, int series, String reasonPhrase) {
        this.value = value;
        this.series = series;
        this.state = reasonPhrase;
    }
}
