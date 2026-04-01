package org.example;

public class Action {
    public static Object door(String act){
        return switch (act.toLowerCase()) {
            case "open" -> true;
            case "close" -> false;
            default -> null;
        };
    }

}
