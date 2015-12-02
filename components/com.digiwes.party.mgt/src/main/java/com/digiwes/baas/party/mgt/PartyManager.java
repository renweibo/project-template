package com.digiwes.baas.party.mgt;

import java.util.Map;
import java.util.HashMap;

import com.digiwes.baas.party.mgt.data.Party;

public class PartyManager {
	
	private Map<String, Party> partyMap;
	
	public PartyManager(){
		partyMap = new HashMap<String, Party>();
		
		Party party1 = new Party();
        party1.setPartyId("876123746v");
        party1.setFirstName("John");
        party1.setLastName("Carter");
        party1.setAge(25);

		Party party2 = new Party();
		party2.setPartyId("846123746v");        
		party2.setFirstName("Tom");
		party2.setLastName("Hanks");
		party2.setAge(28);

		partyMap.put(party1.getPartyId(), party1);
		partyMap.put(party2.getPartyId(), party2);
	}

    /**
     * Adds the party information
     * @param party Instance of the Party bean class which contains information
     * @throws Exception if an invalid input is provided
     */
	public void addParty(Party party) throws Exception{
		if(party == null || party.getPartyId() == null){
			throw new Exception("Invalid Party");
		}
		partyMap.put(party.getPartyId(), party);
	}

    /**
     * Delete the party having the give ID from the party store
     * @param partyId Party's ID
     * @throws Exception, if an invalid ID is given.
     */
    public void deleteParty(String partyId) throws Exception{
        if( partyId == null || partyMap.get(partyId) == null) {
            throw new Exception("Invalid Party ID");
        }

        partyMap.remove(partyId);
    }

    /**
     * Returns an array of Party instances.
     * @return Party array.
     */
	public Party[] getPartys(){
		Party[] partys = new Party[partyMap.size()];
        partyMap.values().toArray(partys);
		return partys;
	}
}
