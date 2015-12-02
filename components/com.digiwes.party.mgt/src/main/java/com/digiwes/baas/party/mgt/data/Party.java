package com.digiwes.baas.party.mgt.data;

public class Party {
	
    private String partyId;
	private String firstName;
	private String lastName;
	private int age;

    public String getPartyId(){
        return partyId;
    }

    public void setPartyId(String partyId){
        this.partyId = partyId;
    }
	
	public String getFirstName(){
		return firstName;
	}
	
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public void setLastName(String lastName){
		this.lastName = lastName;
	}                   
	
	public int getAge(){
		return age;
	}
	
	public void setAge(int age){
		this.age = age;
	}
}
