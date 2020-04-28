class Numbers extends Thread{

	Object lock = new Object(); // this is the responsability of programmer

	Numbers(Object o)
	{
		this.lock = o;
	}


	public  void run()
	{

		synchronized(lock)
		{
		int cnt = 1;
		for(int i=0; i < 10; i++)
		{


			System.out.println("Hello  -> from Numbers run Function " + "Counter :" + cnt);
			cnt++;
		}
		}

	}

}



class Counter {
	
public static void main(String[] args)
{

	//System.out.println("Hello  -> from the main Thread");

	Object lock = new Object();

	Numbers n1 = new Numbers(lock);
	Numbers n2 = new Numbers(lock);

	n1.start();
	n2.start();

}



}