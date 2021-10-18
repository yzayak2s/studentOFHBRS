package src.org.hbrs.se1.ws21.uebung2;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestClass {
    @Test
    public void test(){
        Container container = new Container();
        container.addMember(Container.newMember());
        Container.newMember().setID(-1);
        Container.newMember().setID(0);

    }
}
