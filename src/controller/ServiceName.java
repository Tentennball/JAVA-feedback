package controller;

public enum ServiceName {
    REGISTER("1"),
    PRINT_INFO("2"),
    SEARCH("3"),
    EDIT("4"),
    DELETE("5"),
    EXIT("6");
    private final String cmd;

    ServiceName(String cmd) {
        this.cmd = cmd;
    }
}
