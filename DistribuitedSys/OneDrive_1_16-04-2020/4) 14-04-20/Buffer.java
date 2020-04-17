class Full extends Exception{}
class Empty extends Exception{}

class BoudedBuffer{
	final Object[] items = new Object[100];
	int count; //current number of elements
	int putptr, takeptr;
	
	public synchronized void put(Object o) throws Full{
		if(count == items.length)
			throw new Full();
		else{
			items[putptr] = o;
			putptr++;
			
			if(putptr == items.length)
				putptr = 0;
			
			count++;
		}
	}
	
	public synchronized Object take() throws Empty{
		if(count == 0)
			throw new Empty();
		else{
			Object o = items[takeptr];
			takeptr++;
			
			if(takeptr == items.length)
				takeptr = 0;
			
			count--;
			return o;
		}
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
				}catch(Full f){
					System.out.println("Full buffer");
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
				}catch(Empty e){
					System.out.println("Empty buffer");
				}
			}
			try{
				Thread.sleep((int)(Math.random()*100));
			}catch(InterruptedException e){}
		}
	}
}

public class Buffer{
	public static void main(String[] args){
		BoudedBuffer buff = new BoudedBuffer();
		Producer prod = new Producer(buff);
		Consumer cons = new Consumer(buff);
		
		prod.start();
		cons.start();
	}
}