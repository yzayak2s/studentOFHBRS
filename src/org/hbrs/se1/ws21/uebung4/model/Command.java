package org.hbrs.se1.ws21.uebung4.model;

public interface Command {

    public void execute();

    void undo();
}
