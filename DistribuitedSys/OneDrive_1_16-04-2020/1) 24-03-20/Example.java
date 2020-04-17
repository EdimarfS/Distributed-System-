class T extends Thread{
	private int num;
	private boolean runFlag = false;
	
	public T(int n){
		num = n;
	}
	
	public boolean isRunning(){
		return runFlag;
	}
	
	public void run(){
		runFlag = true;
		for(int i=0; i<100000; i++){}
		System.out.println("Thread num " + num + " has finished");
	}
}

public class Example{
	public static void main(String[] args){
		T t1 = new T(1);
		T t2 = new T(2);
		t2.setPriority(Thread.MAX_PRIORITY);
		t1.start();
		
		try{
			t1.join(); //stopping the main thread to wait for the completion of t1
		}catch(InterruptedException e){}
		
		t2.start();
	}
}