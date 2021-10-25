package org.hbrs.se1.ws21.uebung2;
/**
 *
 * @author yzayak2s rfalke2s
 *
 */
public class ContainerException extends Exception {
    public ContainerException(Member member){
        super("Das Member-Objekt mit der ID " + member.getID() + " ist bereits vorhanden!");
    }
}
