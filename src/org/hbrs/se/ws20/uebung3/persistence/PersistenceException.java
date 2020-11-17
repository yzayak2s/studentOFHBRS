package org.hbrs.se.ws20.uebung3.persistence;

public class PersistenceException extends Exception {

    private ExceptionType exceptionType;

    public ExceptionType getExceptionTypeType() {
        return this.exceptionType;
    }

    public PersistenceException( ExceptionType exceptionType, String message) {
        super(message);
        this.exceptionType = exceptionType;
    }

    /**
     * ExceptionTypes for declaring the type of an exception.
     * Please feel free to extend this list!
     */
    public enum ExceptionType {
        ImplementationNotAvailable, ConnectionNotAvailable, NoStrategyIsSet, SaveFailure, LoadFailure
    }
}
