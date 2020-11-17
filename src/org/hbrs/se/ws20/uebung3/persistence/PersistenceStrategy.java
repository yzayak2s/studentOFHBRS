package org.hbrs.se.ws20.uebung3.persistence;

import java.util.List;

public interface PersistenceStrategy<E> {
    public void openConnection() throws PersistenceException;
    public void closeConnection() throws PersistenceException;
    public void save(List<E> member) throws PersistenceException;
    public List<E> load() throws PersistenceException;
}
