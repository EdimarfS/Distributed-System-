

import java.io.*;

class BufferRead {


	public static void main(String[] args) throws IOException{
		FileInputStream in = null;
		FileOutputStream out= null;



		try {
			in = new FileInputStream("in.txt");
			out = new FileOutputStream("out.txt");

			int c;
			while((c = in.read()) != -1)
			{
				out.write(c);
			}



		}finally {
			if(in != null)
			{	
				in.close();

			}
			if(out!=null)
			{
				out.close();
			}

		}


		//in.close();
		//in.flush();
		//out.close();
		//out.flush();

		//System.out.println("Working");

	}




}





















