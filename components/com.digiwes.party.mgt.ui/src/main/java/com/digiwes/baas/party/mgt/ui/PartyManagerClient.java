package com.digiwes.baas.party.mgt.ui;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.context.ConfigurationContext;
import com.digiwes.baas.party.mgt.data.xsd.Party;
import java.lang.Exception;


public class PartyManagerClient {
	
	private PartyManagerStub stub;
	
	public PartyManagerClient(ConfigurationContext configCtx, String backendServerURL, String cookie) throws Exception{
		String serviceURL = backendServerURL + "PartyManager";
        stub = new PartyManagerStub(configCtx, serviceURL);
        ServiceClient client = stub._getServiceClient();
        Options options = client.getOptions();
        options.setManageSession(true);
        options.setProperty(org.apache.axis2.transport.http.HTTPConstants.COOKIE_STRING, cookie);
	}
	
	public void addParty(Party party) throws Exception{
		try{
			stub.addParty(party);
		}catch (RemoteException e) {
            String msg = "Cannot add the party"
                + " . Backend service may be unvailable";
            throw new Exception(msg, e);
		}
	}
	
	public Party[] getPartys() throws Exception{
		try{
			return stub.getPartys();
		}catch (RemoteException e) {
            String msg = "Cannot get the list of partys"
                + " . Backend service may be unvailable";
            throw new Exception(msg, e);
		}
	}	
}
