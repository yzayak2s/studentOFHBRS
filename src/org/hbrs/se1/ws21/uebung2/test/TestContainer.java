import org.hbrs.se1.ws21.uebung2.Client;
import org.hbrs.se1.ws21.uebung2.Container;
import org.hbrs.se1.ws21.uebung2.ContainerException;
import org.hbrs.se1.ws21.uebung2.Mitglied;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 *
 * @author yzayak2s rfalke2s
 *
 */
public class TestContainer {
    @Test
    public void test(){
        //System.out.println("TEST");
        Container container = Container.getInstance();
        //Container container2 = Container.getInstance();
        Mitglied mitglied1 = new Mitglied(33);
        Mitglied mitglied2 = new Mitglied(5);
        Mitglied mitglied3 = new Mitglied(22);
        assertEquals(0,container.size()); // Keine Mitglieder
        try {
            container.addMember(mitglied1);
            container.addMember(mitglied2);
        } catch (ContainerException e) {
            e.printStackTrace();
        }
        assertEquals(2,container.size());
        container.deleteMember(5);
        assertEquals(1,container.size()); // Nach Löschung eines Mitglieds
        assertThrows(ContainerException.class, () -> container.addMember(mitglied1)); // 1. Objekt - 2. Argument Throwable
        try {
            container.addMember(mitglied3);
        } catch (ContainerException e) {
            e.printStackTrace();
        }
        assertEquals(2, container.size());
        //assertEquals(null,);
        //Member member3 = container.addMember(Container.newMember()).setID(-1);
        //assertEquals("33", mitglied1.getID());
        //assertEquals("0", member2.toString());
        //assertEquals("-1", member3.toString());
    }

    public void testNullStrategy(){

    }

    public void testPersistenceStrategy(){
        Client.Client(1,2,3);
        //assertThrows(3,Container.getInstance().size());
    }

}
