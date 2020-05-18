import java.net.*;

public class IPFinder{
	public static void main(String[] args){
		String host = "www.oracle.com";
		try{
			InetAddress localAdd = InetAddress.getLocalHost();
			InetAddress address = InetAddress.getByName(host);
			System.out.println("Address: " + address);
			System.out.println("Local: " + localAdd);
		}catch(UnknownHostException e){
			System.out.println(host + " unknown");
		}
	}
}