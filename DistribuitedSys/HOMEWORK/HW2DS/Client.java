/*
The client creat user then send Hi ... 
the server say HI ... .. 
the cliend send the user object ... 
the server put it in Arraylisr the put it in file
*/
import java.io.*;
import java.util.*;
import java.net.*;

//-> The begining of CLIENT CLASS 

//Client Main Class -> here we are getting into work everything from client  
public class Client {
	private Socket s = null;
	private InetAddress ip;
	private int port = 1234;


	public void go() throws IOException //Try to make new users inside the function go.
	{
		ip = InetAddress.getByName("localhost");
		s  = new Socket(ip, port);


		try{ 
			
			//Write and Read part 
			//.
			//.
			//.
		

			//Serializing the user data to SEVER!
			String filename = "user.data";
			User user = new User("marcos","mrsabtos@gmail.com","finallymylove",new Date(1977-01-19), 100);
			Serialization.serialize(user,filename);


			//Message from Sever 
			//System.out.println(receivedMsg);
			 System.out.println("Connection with Server established");

		}catch(IOException e)
		{

			System.out.println("I/O Exception");

		}finally{

			s.close();

		}


	}


public static void main(String[] args) throws IOException {	
	//Since we declared everything to be run in the head of Client class we need an instance of it and after that call the function 
	Client c = new Client();
	c.go();	

	System.out.println("CLIENT STARTED");






}


}