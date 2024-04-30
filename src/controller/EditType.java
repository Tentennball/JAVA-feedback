package controller;

public enum EditType {
    CHANGE_NAME("1"),
    CHANGE_KOREAN_GRADE("2"),
    CHANGE_ENGLISH_GRADE("3"),
    CHANGE_MATH_GRADE("4"),
    EXIT("5");

    private final String cmd;

    EditType(String cmd) {
        this.cmd = cmd;
    }
}
