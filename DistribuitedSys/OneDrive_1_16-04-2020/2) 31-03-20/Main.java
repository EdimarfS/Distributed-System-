//1 - both threads are instances of the same class
//2 - the run method should contain some separate print instructions
//3 - every execution of the program should produs an alternating sequence of words

class T extends Thread{
	Object l; //lock object defined as an attribute
	public T(Object o){
		l = o;
	} 
	public void run(){
		synchronized(l){ //defines the critical section within the threads
			System.out.println("Car");
			for(int i = 0; i<10000; i++){}
			System.out.println("Tree");
		}
	}
}

public class Main{
	public static void main(String[] args){
		Object lock = new Object();
		T t1 = new T(lock);
		T t2 = new T(lock);
		
		t1.start();
		t2.start();
	}
}