package org.hbrs.se1.ws21.uebung2;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestClass {
    @Test
    public void test(){
        Container container = new Container();
        Member member1 = container.addMember(Container.newMember()).setID(33);
        Member member2 = container.addMember(Container.newMember()).setID(0);
        Member member3 = container.addMember(Container.newMember()).setID(-1);
        assertEquals("33", member1.toString());
        assertEquals("0", member2.toString());
        assertEquals("-1", member3.toString());


    }
}
