Thread.MAX_PRIORITY = 10
-
-
-
Thread.NORM_PRIORITY = 5
-
-
-
Thread.MIN_PRIORITY = 1


Thread.yield()




public void doSomething(){
	SomeThread t = new SomeThread();
	t.start();
	doSomethingElse();
	
	try{
		//long m = 1000000000000;
		t.join();
		//t.join(m);
	}catch(InterruptedException e){
		//the current thread was interrupted while it was suspended for
		//t.join() operation
	}
	
	
	//t has stopped
	//whatever happens here is after the completion of t
}




Thread.currentThread().isInterrupted() //within a Runnable object

static boolean interrupted() // return true if the the thread is interrupted
//set the interruption flag to false


public void run(){
	try{
		while(!Thread.currentThread().isInterrupted() && ...){
			//do job
		}
	}catch(InterruptedException e){
		//react accordingly
	}finally{
		//operation in case you need to quit
	}
}








Thread t = new T();
t.setDaemon(true);
t.start();











