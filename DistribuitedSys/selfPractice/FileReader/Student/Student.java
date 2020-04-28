import java.io.*;
import java.util.*;



 class Student {


public static void main(String[] args) throws IOException{
	String file1, file2;

	
	Scanner readFiles = new Scanner(System.in);
	file1="in.txt";
	file2="out.txt";


	if(args.length == 0)
	{
		file1 = readFiles.next();
		file2 = readFiles.next();
	}




	Scanner in = new Scanner(new File(file1));
	PrintWriter output = new PrintWriter(new File(file2));

	while(in.hasNext())
	{
		String c = in.next();
		output.print(c);
		output.print(" ");
		output.flush();

	}

	output.close();


	

}


}