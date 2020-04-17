import java.util.*; 
import java.io.*;
import java.net.*;

public class TelnetClient{
	public Static void main(String [] args)throws Exception {
		String machine = args[0];
		int port = Integer.parseInt(args[1]);
		 try (
            Socket s = new Socket(machine, port);
            Scanner sc = new Scanner(s.getInputStream());
            PrintWriter pw = new PrintWriter(s.getOutputStream());
        ) {
            Thread t1 = new Thread (new ClientToSrvThread(pw));
            Thread t2 = new SrvToClientThread(sc);

            t1.start();
            t2.start();

            t1.join();
            t2.join();
        }
    }
		
	}
}


class ClientToSrvThread implements Runnable
{
    PrintWriter pw;

   public  ClientToSrvThread(PrintWriter pw)
    {
        this.pw = pw;
    }

	@Override
    public void run()
    {
        Scanner sc = new Scanner(System.in);
		while(true)
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            pw.println(line);
            pw.flush();
        }
       
    }
}

class SrvToClientThread implements Runnable
{
    Scanner sc;

   public  SrvToClientThread(Scanner scanner)
    {
        this.sc = scanner;
    }

    public void run()
    {
        while (true)
        while (sc.hasNextLine()) {

            String sor = sc.nextLine();
            System.out.println(sor);
            System.out.flush();
        }
        
    }
}