package org.hbrs.se1.ws21.uebung4.model;

public class ShowCommand implements Command{
    private final String parameter;

    public ShowCommand(String parameter) {
        this.parameter = parameter;
    }

    @Override
    public void execute() {// TODO: 28.02.22 switch case zu ende machen; show command ist das Ziel
        //switch (parameter){
        //    case "employee" -> System.out.println("Employee");
        //
        //
        //        default -> for (SprintsprintFromList : )
        //            if(parameter.equals(Container.getInstance().getSprintList().getName())){
        //        return true;
        //    }
        //        System.out.println();
        //}
    }

    @Override
    public void undo() {

    }
}
