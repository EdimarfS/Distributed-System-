class T1 extends Thread{
	private int i;
	T2 t2;
	
	public T1(T2 t){
		t2 = t;
	}
	
	public void run(){
		while(i<10000){
			synchronized(t2){
				i++;
				if(i == 2000)
					t2.suspend = true;
				if(i == 6000){
					t2.suspend = false;
					t2.notify();
				}
			} //end synchronization
			try{
				Thread.sleep((int)(Math.random()*100));
			}catch(InterruptedException e){}
		}
	}
}

class T2 extends Thread{
	public boolean suspend = false;
	
	public void run(){
		while(true){
			synchronized(this){
				while(suspend)
					try{
						wait();
					}catch(InterruptedException e){}
				System.out.println("suspend: " + suspend + " - something");
			} //end synchronization
			try{
				Thread.sleep((int)(Math.random()*100));
			}catch(InterruptedException e){}
		}
	}
}

public class Example4{
	public static void main(String[] args){
		T2 t2 = new T2();
		T1 t1 = new T1(t2);
		
		t1.start();
		t2.start();
	}
}