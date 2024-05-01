package controller;

import view.ErrorMessage;

public enum EditType {
    CHANGE_NAME(1),
    CHANGE_KOREAN_GRADE(2),
    CHANGE_ENGLISH_GRADE(3),
    CHANGE_MATH_GRADE(4),
    EXIT(5);

    private final int cmd;

    EditType(int cmd) {
        this.cmd = cmd;
    }
    public static EditType from(int cmd) {
        for (EditType serviceName : EditType.values()) {
            if (serviceName.cmd == cmd) {
                return serviceName;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.NOT_VALID_INPUT_CMD);
    }
}
