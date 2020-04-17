import java.net.*;
import java.util.*;
import javaio.*;

public class Client{
	public static void main (String args []) throws Exception) {
		int port = 12345;
		String computer = "localhost";
		
		try{
			Socket socket = new Socket(computer,port);
			Scanner = scanner = new Scanner(socket.getInputStream());
			prirntWriter printer = new PrintWriter(socket.getOutputStream());
			
		}{
			printer.println(args[0]);
			printer.flush();
			
			int numer = scanner.nextInt();
			System.out.println(number);
			
			socket.close();
		}
	}
}