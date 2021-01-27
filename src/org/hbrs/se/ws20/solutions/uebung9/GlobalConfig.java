package org.hbrs.se.ws20.solutions.uebung9;

public class GlobalConfig {
	
	private VerificationContext context = new VerificationContext();
	
	public void doSomething() {
		// ...
		VerificationAlgo algo = new IFRS();
		context.setVerificationAlgo( algo );
	}

}
