import java.util.*;
import java.io.*;
import java.net.*;

public class Server{
	public static void main(String [] args){
		int port = 12345;
		
		
		
		try{
			ServerSocket ss = new ServerSocket(port);
			Socket socket = ss.accept();
			
			ObjectInputStream Input = 
		     new ObjectInputStream(socket.getInputStream());
			Animal a =  (Animal) Input.readObject();
			System.out.println(a.getName());
			socket.close();
		
		
			
		}catch(Exception e){
			System.out.println(e);
		}
	}
}