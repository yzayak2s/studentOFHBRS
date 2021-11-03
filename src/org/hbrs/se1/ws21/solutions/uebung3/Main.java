package org.hbrs.se1.ws21.solutions.uebung3;

import org.hbrs.se1.ws21.solutions.uebung3.persistence.*;

public class Main {

    public static void main(String[] args) {
        Container container = Container.getInstance();
        container.setPersistenceStrategie( new PersistenceStrategyStream() );

       Client client = new Client();
       client.startClient();
    }
}
