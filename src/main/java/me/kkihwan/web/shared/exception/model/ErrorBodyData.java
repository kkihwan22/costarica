package me.kkihwan.web.shared.exception.model;

import lombok.*;

@Getter @ToString
public class ErrorBodyData {
    private final String fieldName;
    private final String message;

    public ErrorBodyData(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }
}