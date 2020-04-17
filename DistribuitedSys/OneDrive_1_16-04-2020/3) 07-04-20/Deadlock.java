class C{
	public synchronized void m(D d){
		for(int k=0; k<10000000; k++){}
		d.m(this);
	}
}

class D{
	public synchronized void m(C c){
		for(int k=0; k<10000000; k++){}
		c.m(this);
	}
}

class T1 extends Thread{
	private C c;
	private D d;
	
	public T1(C c, D d){
		this.c = c;
		this.d = d;
	}
	
	public void run(){
		c.m(d);
		d.m(c);
		System.out.println("T1 finished");
	}
}

class T2 extends Thread{
	private C c;
	private D d;
	
	public T2(C c, D d){
		this.c = c;
		this.d = d;
	}
	
	public void run(){
		d.m(c);
		c.m(d);
		System.out.println("T2 finished");
	}
}

public class Deadlock{
	public static void main(String[] args){
		C c = new C();
		D d = new D();
		
		T1 t1 = new T1(c, d);
		T2 t2 = new T2(c, d);
		
		t1.start();
		t2.start();
	}
}