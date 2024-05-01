package controller;

import view.ErrorMessage;

public enum ServiceName {
    REGISTER(1),
    PRINT_INFO(2),
    SEARCH(3),
    EDIT(4),
    DELETE(5),
    EXIT(6);
    private final int cmd;

    ServiceName(int cmd) {
        this.cmd = cmd;
    }

    public static ServiceName from(int cmd) {
        for (ServiceName serviceName : ServiceName.values()) {
            if (serviceName.cmd == cmd) {
                return serviceName;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.NOT_VALID_INPUT_CMD);
    }
}
