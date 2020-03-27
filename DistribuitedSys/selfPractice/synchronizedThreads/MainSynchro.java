
class Counter {

		public int count=0;

		/*
		Multi-threaded programs may often come to a situation where 
		multiple threads try to access the same resources and finally 
		produce erroneous and unforeseen results.
		*/

		public synchronized void increaseCounter()
		{

			count++;

		}

	}



class MainSynchro {

	public static void main(String[] args) throws Exception {
		
		//Here we have an instance of Counter class
		Counter counter = new Counter();


		//Instances of threads. We are working with multiple threads where we have T1 and T2



		//T1 thread 
		Thread t1 = new Thread(new Runnable(){

			public void run(){


				//for loop to increase the counter till <=10

				for(int i=1; i <= 10; i++)
				{
				counter.increaseCounter();
				System.out.println("Thread 1 : " + counter.count);
				}

			}
	
		});

		//T2 thread 
		Thread t2 = new Thread(new Runnable(){

			public void run(){


				

				//for loop to increase the counter till <=10
				for(int i=1; i <= 10; i++)
				{
				counter.increaseCounter();
				System.out.println("Thread 2 : " + counter.count);
		
				}

			}
	
		});




		//To be able the thread work we need to start them.
		t1.start();
		t2.start();
		

		//Join() -> allows one thread to wait until another thread completes its execution.
		//We are givin high priority to of them to complete his work and other start working.
		//it's hard to say who gonna be the first, this Job is JVM to arrange the Schedule. 
		t1.join();
		t2.join();



		/*If we don't use synchronized method... both threads will try 
		to access the same functions at the same time which can produce 
		erroneous and unfareseen results. 


		Most of the time can give the right rsult, but u should check many times 
		and will realize that it's not true at all
		*/
		System.out.println("Final counter " + counter.count);

	
	}



}