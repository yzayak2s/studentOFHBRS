package org.hbrs.se.ws20.uebung3;

public class MemberKonkret implements Member, Info {
	
	private Integer id = null;
	
	private String name;
	
	public MemberKonkret( Integer id ){
		this.id = id;  
	}

	public MemberKonkret(Integer id, String str) {
		this.name = str;
		this.id = id;
	}

	public Integer getID() { 
		return this.id;
	}
	
	public void setID ( Integer id ) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "MemberKonkret [id=" + id + "]";
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
		
	} 
	
	

}
