//Task -> Runnable object
//Thread -> Thread object

import java.util.concurrent.Executor;

class IncWebServer{ //incomplete web server
	private static final int NTHR = 100; //number of threads
	private final Executor exec = Executor.newFixedThreadPool(NTHR);
								//newSingleThreadExecutor - Single thread
								//newCachedThreadPool - Dynamic pool
	
	private void handleRequest(Socket s){ //handle a client request
		//should be thread safe
	}
	
	public static void main(String[] args){
		ServerSocket socket = new ServerSocket(80);
		while(true){
			final Socket connection = socket.accept();
			
			Runnable task = new Runnable(){
				public void run(){
					handleRequest(connection);
				}
			}
			
			exec.execute(task);
		}
	}
}