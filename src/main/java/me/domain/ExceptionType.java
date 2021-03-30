package me.domain;

public enum ExceptionType {
    INVALID_INPUT_NUMBER_SIZE("3개의 숫자만 입력할 수 있습니다."),
    REQUIRED_NUMBER_TYPES("숫자만 입력하여야 합니다.");

    private final String message;

    ExceptionType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
