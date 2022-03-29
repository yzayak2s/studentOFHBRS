package org.hbrs.se1.ws21.uebung4.model;

import java.util.Stack;

public class CommandList {
    private static Stack<Command> stack = new Stack();

    public CommandList() {
    }


    public static Command pop() {
        try {
            return stack.pop();
        } catch (Exception var1) {
            System.out.println("Befehlsspeicher ist leer.");
            return null;
        }
    }

    public static void addBefehl(Command befehl) {
        try {
            stack.add(befehl);
        } catch (NullPointerException var2) {
            System.out.println("AddBefehl geht nicht");
        }

    }

    public static int size() {
        return stack.size();
    }
}

