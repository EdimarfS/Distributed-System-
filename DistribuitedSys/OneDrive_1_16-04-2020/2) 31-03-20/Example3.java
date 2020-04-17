class C{
	private int i;
	public synchronized void m(){ //locking "this"
		for(int k = 0; k<100000; k++)
			i++;
		
		for(int k = 0; k<100000; k++)
			i--;
	}
	
	public synchronized int getI(){
		return i;
	}
}

public class Example3 extends Thread{
	private int num; //ID of the thread
	private C c;
	public Example3(int n, C c){
		num = n;
		this.c = c;
	}
	
	public void run(){
		for(int i = 0; i<10; i++){
			c.m(); //the print should always be 0
			System.out.println("Thread " + num + ": c.i = " + c.getI());
		}
	}
	
	public static void main(String[] args){
		C c = new C();
		Example3 t1 = new Example3(1, c);
		Example3 t2 = new Example3(2, c);
		
		t1.start();
		t2.start();
	}
}