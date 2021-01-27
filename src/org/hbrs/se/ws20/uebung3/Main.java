package org.hbrs.se.ws20.uebung3;

import org.hbrs.se.ws20.uebung3.persistence.PersistenceStrategyStream;

public class Main {

    public static void main(String[] args) {
        Container container = Container.getInstance();
        container.setPersistenceStrategie( new PersistenceStrategyStream() );

       Client client = new Client();
       client.startClient();
    }
}
