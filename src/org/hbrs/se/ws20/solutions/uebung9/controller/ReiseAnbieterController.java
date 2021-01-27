package org.hbrs.se.ws20.solutions.uebung9.controller;

import org.hbrs.se.ws20.solutions.uebung9.*;

public class ReiseAnbieterController {
	
	private VerificationContext context = null; // = new ...
	
	public void doSomething() {
		Status status = context.verifyBooking( new Buchung() );
	}

}
