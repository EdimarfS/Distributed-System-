import java.io.*;




class checkingArgs {


public static void main(String[] args) throws IOException{
	InputStream is;




	if(args.length == 0)
	{
		is = System.in;

		
	}else{

		is = new FileInputStream(args[0]);
	}


// we need to check 

	int ch, tot, spaces = 0;


	for(tot = 0; (ch = is.read()) != -1; tot++)
	{
		if(Character.isWhitespace((char)ch))
		{

			spaces++;
		}

		

	}

	System.out.println("The file "+ args[0]+ " The size "+ tot + ", bytes of which " + spaces + " are white spaces");




}




}