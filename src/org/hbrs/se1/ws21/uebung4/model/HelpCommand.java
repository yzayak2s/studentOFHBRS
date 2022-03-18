package org.hbrs.se1.ws21.uebung4.model;

public class HelpCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Folgende Befehle stehen zur Verfuegung:\n" +
                "   dump    Zeigt alle Mitarbeiter an\n" +
                "   enter   [new sprint]|[expertise]|[start]|[end]\n" +
                "   delete  [start]\n" +
                "   store   [sprint] <Name des Sprints>\n" +
                "   exit    Anwendung beenden\n" +
                "   search  Suche nach Expertisen\n" +
                "   load    [force]|[merge] Laden aller persistenten Mitarbeiter|Laden aller Mitarbeiter die sowohl persistent als auch flüchtig gespeichert sind...");
    }

    @Override
    public void undo() {

    }
}
