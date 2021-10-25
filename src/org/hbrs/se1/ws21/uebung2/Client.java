package org.hbrs.se1.ws21.uebung2;

import java.util.Arrays;

public class Client {

    public static void Client(int... array){
        /*Arrays.stream(array).forEach(value -> {
            try {
                Container.getInstance().addMember(new Mitglied(value));
            } catch (ContainerException e) {
                e.printStackTrace();
            }
        });
        */
        for (int e: array) {
            try {
                Container.getInstance().addMember(Container.newMember(e));
            } catch (ContainerException ex) {
                ex.printStackTrace();
            }
        }
        MemberView memberView = new MemberView();
        memberView.dump();
    }
    public static class Main{
        public static void main(String[] args) {
            Client.Client(1,2,3,4,5);

        }


    }
}
