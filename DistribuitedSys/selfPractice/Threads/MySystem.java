package thread;



public  class MySystem extends Thread{

	private String message = "default";
	private int delay   = 0;

	public MySystem(String message, int  delay)
	{
		this.message = message;
		this.delay = delay;
	}
	
	public void run()
	{
		try {

		System.out.println("Hello from -> MySystem");
		//Thread.sleep(1000);
		System.out.println("Thread Slept");



		}
		catch(Exception e)
		{
			System.out.println("Error");
		}

	}


}