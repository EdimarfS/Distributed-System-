class Daemon extends Thread{
	private int i;
	public Daemon(){
		setDaemon(true);
	}
	public void run(){
		//infinite loop
		while(true){
			++i;
			if(i>100000000)
				i = 0;
		}
	}
	
	public int getI(){
		return i;
	}
}

public class Example2 extends Thread{
	private Daemon dm = new Daemon();
	private int j;
	
	public void run(){
		dm.start(); //daemon started
		while(j<100){
			System.out.print(dm.getI() + " "); //sevice provided by daemon (dm.getI())
			j++;
		}
	}
	
	public static void main(String[] args){
		Example2 e = new Example2();
		e.start();
	}
}