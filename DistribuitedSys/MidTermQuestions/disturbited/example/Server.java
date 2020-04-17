import java.net.*;
import java.util.*;
import javaio.*;

public class Server{
	public static void main(String [] args) throws Exception{
		int port =  12345;
		
		try(
			ServerSocket ss = new ServerSocket (port);
			//to accept a connection from server 
			//the socket we will use it to connect 
			Socket socket = ss.accept();
			Scanner scanner = new Scanner(socket.getInputStream());
			printWriteer printer = new PrintWriter(socket.getputStream());
		){
			String text = scanner .nextLine();
			printer.println(text.length());
			
			printer.flush();
			
			socket.close();
			
			
		}
	}
	
} 