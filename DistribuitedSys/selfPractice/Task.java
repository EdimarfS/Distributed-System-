


class Task extends  Thread {

	public void run()
	{
		System.out.println("inside Runnable");
	}







	public static void main(String[] args)
	{
		//System.out.println("Edimarf");

		Task t1 = new  Task();
		t1.start();

	}
}