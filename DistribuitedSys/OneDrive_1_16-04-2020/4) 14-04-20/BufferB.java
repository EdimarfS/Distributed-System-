//class Full extends Exception{}
//class Empty extends Exception{}

class BoudedBuffer{
	final Object[] items = new Object[100];
	int count; //current number of elements
	int putptr, takeptr;
	
	public synchronized void put(Object o) throws InterruptedException{
		while(count == items.length){
			System.out.println("Waiting: Full buffer");
			wait();
		}
		items[putptr] = o;
		putptr++;
		
		if(putptr == items.length)
			putptr = 0;
		
		count++;
		notify(); // notifying waiting consumers
	}
	
	public synchronized Object take() throws InterruptedException{
		while(count == 0){
			System.out.println("Waiting: Empty buffer");
			wait();
		}
		
		Object o = items[takeptr];
		takeptr++;
		
		if(takeptr == items.length)
			takeptr = 0;
		
		count--;
		notify(); // notifying waiting producers
		return o;
	}
}

class Producer extends Thread{
	private BoudedBuffer b;
	public Producer(BoudedBuffer b){
		this.b = b;
	}
	public void run(){
		int i = 0;
		while(i < 200){
			synchronized(b){ //not necessary and potentially confusing
				try{
					b.put("Car");
					System.out.println("Element: " + i + " inserted");
					i++;
				}catch(InterruptedException e){
					System.out.println(e);
				}
			}
			try{
				Thread.sleep((int)(Math.random()*100));
			}catch(InterruptedException e){}
		}
	}
}

class Consumer extends Thread{
	private BoudedBuffer b;
	public Consumer(BoudedBuffer b){
		this.b = b;
	}
	public void run(){
		int i = 0;
		while(i < 200){
			synchronized(b){ //not necessary and potentially confusing
				try{
					System.out.println("Element: " + b.take() + " at position " + i + " taken");
					i++;
				}catch(InterruptedException e){
					System.out.println(e);
				}
			}
			try{
				Thread.sleep((int)(Math.random()*100));
			}catch(InterruptedException e){}
		}
	}
}

public class BufferB{
	public static void main(String[] args){
		BoudedBuffer buff = new BoudedBuffer();
		Producer prod = new Producer(buff);
		Consumer cons = new Consumer(buff);
		
		prod.start();
		cons.start();
	}
}