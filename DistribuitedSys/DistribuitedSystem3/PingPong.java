//First Thread example  



//This is the class  PingPong which extends Thread class 
 public class PingPong extends Thread {
	 
	 //Class variables
	 private String word;
	 private int wait;

	 

	 //Constructor 
	 public PingPong(String word, int wait)
	 {
		 this.word = word;
		 this.wait = wait;

		 Thread t = new Thread(this);
		 t.start();
	 }
	 
	 
	 //Behaviour -> We are calling the run function
	 public void run(){
		 int count =0;
		 try{
			 while(true)
			 {
				
				//System.out.println("I promise  I won't give up");
				System.out.println(word + " " + count);
				Thread.sleep(wait);
				count++;

			 }
			 
		 }catch(InterruptedException e) {
			 return;
		 }
		 
		 
	 }
	 

//main function of  the Class PingPong ->  Here we are calling the Threads
//The processors 
public static void main(String[] args)
{
	PingPong t1 = new  PingPong("I am still alive",1000);
	PingPong t2 = new  PingPong("I am dead",300);
	PingPong t3 = new  PingPong("not sure",100);
		
}





}
