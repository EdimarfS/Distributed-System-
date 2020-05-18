import java.rmi.*;
//contains the interface java.rmi.Remote
//contains the class java.rmi.Naming
import java.rmi.server.*;

interface Hello extends Remote{
	public String sayHello() throws RemoteException;
}

class HelloImpl extends UnicastRemoteObject implements Hello{
	public HelloImpl() throws RemoteException{
		
	}
	public String sayHello() throws RemoteException{
		return "Hello world!!!";
	}
	public int giveNumber(){ //the client doesn't know about this
		return 4;
	} // can only be called locally on the server
}

public class Server{
	private static final String HOST = "localhost";
	
	public static void main(String[] args) throws Exception {
		//create an instance of the remote object
		HelloImpl ref = new HelloImpl();
		//generate a name with which the object should be published
		String rmiObjName = "rmi://"+HOST+"/Hello";
		//register the object in the Java RMI registry
		Naming.rebind(rmiObjName, ref);
		System.out.println("Server ready");
	}
}

/*
	public String sayHello(T obj) throws RemoteException{
		return "Hello world!!!";
	}
	
	obj1.sayHello(obj2);
*/