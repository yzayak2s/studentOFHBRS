package org.hbrs.se.ws20.uebung3.persistence;

import java.util.List;

public class PersistenceStrategyStream<Member> implements PersistenceStrategy<Member> {
    @Override
    public void openConnection() throws PersistenceException {

    }

    @Override
    public void closeConnection() throws PersistenceException {

    }

    @Override
    public void save(List<Member> member) throws PersistenceException  {

    }

    @Override
    public List<Member> load() throws PersistenceException  {
        return null;
    }
}
