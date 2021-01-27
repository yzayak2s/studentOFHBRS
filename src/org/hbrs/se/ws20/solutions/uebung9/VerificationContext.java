package org.hbrs.se.ws20.solutions.uebung9;

public class VerificationContext {
	
	private VerificationAlgo algo = null;
	
	/**
	 * Paket-private Methode zum Setzen der aktuellen Strategy durch GlobalConfig
	 * Kann nicht durch den Client aufgerufen werden (wenn dieser in einem anderen Package liegt)
	 * @param algo
	 */
	void setVerificationAlgo ( VerificationAlgo algo ) {
		this.algo = algo;
	}
	
	/**
	 * Context Interface gemaess Strategy Pattern
	 * @param booking
	 * @return
	 */
	public Status verifyBooking( Buchung booking ) {
		return algo.verifyBooking( booking );
	}
	
	

}
