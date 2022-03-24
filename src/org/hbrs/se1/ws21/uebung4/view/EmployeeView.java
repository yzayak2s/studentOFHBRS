package org.hbrs.se1.ws21.uebung4.view;

import org.hbrs.se1.ws21.uebung4.model.Employee;

import java.util.List;

public class EmployeeView {

    public void dumpEmpl(List<Employee> list1){
        for (Employee employee : list1) { // Lösung mit Member For each:
            System.out.println(employee.toString()); //Ausgabe auf der Konsole
        }
    }
}
