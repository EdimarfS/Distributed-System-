/*
The client creat user then send Hi ... 
the server say HI ... .. 
the cliend send the user object ... 
the server put it in Arraylisr the put it in file
*/
//package ServerClient;

import java.net.*;
import java.io.*;
import java.util.*;




class ServerThread extends Thread {

	private Socket s = null;
	public ServerThread(Socket socket)
	{	
		super("ServerThread");
		this.s = socket;
	}

	//run function
	public void run()
	{
		//System.out.println("Hello from Thread");

		try{
			
			//Write and Read part 
			//.
			//.
			//.
		

		
			//The message get from Client
			//Sending the obejct user throgh socket
			String filename = "user.data";
			User user = (User) Serialization.deserialize(filename); 
			//printing the user out 
			System.out.println(user);
			
			

		}catch(IOException e ){
			System.err.println("I/O exception 1");

		}catch(ClassNotFoundException e)
		{
			System.out.println("Class Not Found");
		}
		finally{

			try{
				//Closing the Socket connection 
				s.close();
			}catch(IOException e)
			{	
				System.err.println("Something went wrong");

				System.exit(2);
			}
		}


	}


}



public class Server {


	private static final int port = 1234;
	private ServerSocket s = null;

	public void activate() throws IOException{
		
		try{

			s = new ServerSocket(port);

		}catch(IOException e)
		{

			System.err.println("Could not listen on port " + port);
			System.exit(1);

		}

		while(true)
		{
			Socket conn = s.accept();
			ServerThread st = new ServerThread(conn);
			st.start();
		}



	}

public static void main(String[] args) throws IOException, Exception{


	Server server = new Server();
	server.activate();

	System.out.println("SERVER STARTED");



}


}





