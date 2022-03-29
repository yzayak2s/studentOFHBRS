package org.hbrs.se1.ws21.uebung4.model;

import java.text.ParseException;
import java.util.EmptyStackException;

public class UndoCommand implements Command {

        public void execute() throws ContainerException, ParseException{
            try {
                Command command1 = CommandList.pop();

                assert command1 != null;
                command1.undo();
                System.out.println("LOG: Command wurde rückgängig gemacht!");
            } catch (EmptyStackException | NullPointerException e) {
                System.out.println("Kein Befehl vorhanden, der Rückgängig gemacht werden kann.");
            }
        };

        public void undo(){

    }
}
