import java.io.*;
public class SpaceCounter{
	public static void main(String[] args) throws IOException{
		InputStream is;
		if(args.length == 0)
			is = System.in;
		else
			is = new FileInputStream(args[0]);
		
		int ch, tot, spaces = 0;
		for(tot = 0; (ch = is.read()) != -1; tot++) // -1 = EOF
			if(Character.isWhitespace((char)ch))
				spaces++;
		
	/*
		tot = 0;
		ch = is.read();
		while(ch != -1){
			if(Character.isWhitespace((char)ch)) // ((char)ch) == " "
				spaces++;
			ch = is.read();
			tot++;
		}
	*/
		if(args.length != 0)
			System.out.println("The file "+args[0]+" has size "+tot+" bytes, of which "+spaces+" are white spaces");
		else
			System.out.println("The inserted text has size "+tot+" bytes, of which "+spaces+" are white spaces");
	}
}