package org.hbrs.se.ws20.prototype.uebung4;

public interface Command {

    public void execute( String[] args );
    public void undo();
}
