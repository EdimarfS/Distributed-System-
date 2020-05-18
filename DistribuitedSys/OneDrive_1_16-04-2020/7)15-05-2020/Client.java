import java.rmi.*;
//contains the interface java.rmi.Remote
//contains the class java.rmi.Naming

interface Hello extends Remote{
	public String sayHello() throws RemoteException;
}

public class Client{
	private static final String HOST = "localhost";
	
	public static void main(String[] args) throws Exception {
		try{
			//obtain an instance of our remote object (of the right type)
			Hello ref = (Hello)Naming.lookup("rmi://"+HOST+"/Hello");
			//invoke the remote method
			System.out.println("Received message: "+ref.sayHello());
		}catch(ConnectException e){
			System.out.println("Problems connecting to the server");
		}
		catch(Exception exc){
			exc.printStackTrace();
		}
	}
}