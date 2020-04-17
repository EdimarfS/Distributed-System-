/* This is the exercise that is complementary to the homework.

   - The first task is to define method m() in such a way that the execution
     of this program will aways cause the print of the string "PingPong"
     exactly 5 times in total.
   
   - The second task is to modify the main() method in such a way that the
     print statement will always happen after the 2 threads terminate
     their execution (it shouldn't break the "PingPong" sequence).
	 (Changing its position is also allowed.)
   
   Nothing else can be changed in the code.
*/

class Z{
	private String s = new String("PingPong");
	private int i =0;
	public void m(){
		//Define m(). You are allowed to add something to its declaration, but the parameter list
		//should remain empty

		while(i < 5)
		{
			System.out.println(s);
			i++;
		}

	}
}

class T extends Thread{
	private Z z;
	public T(Z z){
		this.z = z;
	}
	public void run(){
		for(int i=0; i<5; i++)
			z.m();
	}
}

public class HW1_Exercise2{
	public static void main(String[] args){
		Z z = new Z();
		
		T t1 = new T(z), t2 = new T(z);

		//Starting the Thread 1
		t1.start();
		try {

			t1.join();

		}catch(Exception e)
		{
			System.out.println("Thread t1 went wrong");

		}
		
		System.out.println("Finished!!!"); //Print statement
		

		//Starting the Thread 2
		t2.start();
		try{

		}catch(Exception e){

			System.out.println("Thread t2 went wrong");

		}




	}
}