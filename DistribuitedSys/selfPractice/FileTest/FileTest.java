import java.io.*;
import java.util.*;

public class FileTest{


	public static void main(String[] args) throws IOException{
	String file1, file2;

	Scanner input = new Scanner(System.in);
	System.out.println("Insert the file name");
	file1 = input.next();
	file2 = input.next();
	PrintWriter out = new PrintWriter(new File(file2));
	Scanner in = new Scanner(new File(file1));



	while(in.hasNext())
	{

		String c = in.next();
		out.print(c);
		out.print(" ");
		out.flush();
	}

	out.close();

	RandomAccessFile rf = new RandomAccessFile("rtest.dat", "rw");
	for(int i=0; i < 10; i++)
		rf.writeDouble(i*2.0);
	rf.close();

	rf = new RandomAccessFile("rtest.dat","rw");
	rf.seek(5*8);
	rf.close();

	rf = new RandomAccessFile("rtest.dat","r");
	for(int i=0; i < 10; i++)
		System.out.println("Valeu " + i + ": " + rf.readDouble());



}


}