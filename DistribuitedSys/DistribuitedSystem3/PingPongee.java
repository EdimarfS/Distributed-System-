//First Thread example  


 public class PingPongee extends Thread {
	 
	 private String word;
	 private int del;
	 
	 public PingPongee(String world, int del)
	 {
		 this.word = word;
		 this.del = del;
	 }
	 
	 
	 //Behaviour 
	 public void run(){
	 
		 try{
			 while(true)
			 {
				
				System.out.println("On Word Thread");
				 System.out.println(word);
				
				Thread.sleep(del);
		
			 }


		 }catch(InterruptedException e) {
			 return;
		 }
		 
		 
	 }
	 
 
public static void main(String[] args)
{
	Thread t1 = new PingPong("ping",33);
		t1.start();
	Thread t2 = new PingPong("ping",33);
		t2.start();
		
}
}
