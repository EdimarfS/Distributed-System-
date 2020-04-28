import java.io.*;
import java.util.*;


class FileTest {


public static void main(String[] args) throws IOException{
	String file1, file2;
	Scanner input = new Scanner(System.in);
	//file1 = args[0];
	String message = "message.txt";
	file2 = args[1];

	PrintWriter output = new PrintWriter(new File(file2));



	if(args.length == 0)
	{
		System.out.println("No file founded");
	}else {

	

	Scanner in = new Scanner(new File(message));

	while(in.hasNext())
	{
		String c = in.next();
		output.print(c);
		output.print(" ");
		output.flush();

	}
}

	output.close();

}





}