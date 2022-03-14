import org.hbrs.se1.ws21.uebung2.Client;
import org.hbrs.se1.ws21.uebung2.Container;
import org.hbrs.se1.ws21.uebung2.ContainerException;
import org.hbrs.se1.ws21.uebung2.ConcreteMitglied;
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
        ConcreteMitglied concreteMitglied1 = new ConcreteMitglied(33);
        ConcreteMitglied concreteMitglied2 = new ConcreteMitglied(5);
        ConcreteMitglied concreteMitglied3 = new ConcreteMitglied(22);
        assertEquals(0,container.size()); // Keine Mitglieder
        try {
            container.addMember(concreteMitglied1);
            container.addMember(concreteMitglied2);
        } catch (ContainerException e) {
            e.printStackTrace();
        }
        assertEquals(2,container.size());
        container.deleteMember(5);
        assertEquals(1,container.size()); // Nach Löschung eines Mitglieds
        assertThrows(ContainerException.class, () -> container.addMember(concreteMitglied1)); // 1. Objekt - 2. Argument Throwable
        try {
            container.addMember(concreteMitglied3);
        } catch (ContainerException e) {
            e.printStackTrace();
        }
        assertEquals(2, container.size());
        //assertEquals(null,);
        //Member member3 = container.addMember(Container.newMember()).setID(-1);
        //assertEquals("33", concreteMitglied1.getID());
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
