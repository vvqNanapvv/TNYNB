package org.example;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {

    Human.John John = new Human.John();
    System.out.println(John.getName());

    Action.Gate();

    Action.Cll cll = new Action.Cll();
    cll.prepend((Method) Action.Gate());
    cll.prepend((Method) Action.Gate());
    cll.Pop();
    }
}