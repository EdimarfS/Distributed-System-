package server;

import java.rmi.registry.*;



public class RMICalServer {	
	
		
	public static void main(String args[]) throws Exception
	{
		final int PORT = 12345;
		Registry registry = LocateRegistry.createRegistry(PORT);
		registry.rebind("current value", new Cal(1, 1));
		registry.rebind("current value", new Cal(0 , 0));
		
		
	}

}
	
