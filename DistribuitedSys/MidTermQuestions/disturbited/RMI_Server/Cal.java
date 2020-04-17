package server;
import java.rmi.*;

public class Cal extends java.rmi.server.UnicastRemoteObject
   implements CalInterface {
	
	public Cal(int a, int b) throws RemoteException {
		super();
	}

	@Override
	public int add(int a, int b) throws RemoteException {
		return a + b;
	}

	@Override
	public int subt(int a, int b) throws RemoteException {
		return a - b;
	}

	@Override
	public int mult(int a, int b) throws RemoteException {
		  return a * b;
	}

	@Override
	public int div(int a, int b) throws RemoteException {
		return a / b;
	}
	

}
