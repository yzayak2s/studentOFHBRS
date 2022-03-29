package org.hbrs.se1.ws21.uebung4.model;

import java.text.ParseException;

public interface Command {

    public void execute() throws ContainerException, ParseException;

    void undo();
}
