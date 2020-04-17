//DS homework - Tansit 

import java.util.ArrayDeque;
import java.lang.Integer;
import java.lang.Exception;






//Passage class 
class Passage {

//something to write




	
}

//Queue Class 
class Queue extends Thread {
//something to write
	private ArrayDeque<Car> q = new ArrayDeque();
	private Passage p;
	private String direction;




	public Queue(String direction, Passage p)
	{

		this.direction = direction;
		this.p = p;
	}

	public void run()
	{

		System.out.println("Hello");
	}






}


//Car Class

class Car {
	private static int i=1;
	private Integer id;

	public Car()
	{
		id = new Integer(i);
		i++;
	}

	public String toString()
	{
		return "The Car id : " + id;  
	}




}

//Start Class
class Start {
//something to write

	public Start()
	{
	Passage passage = new Passage();
	Queue 	queue1 = new Queue("Right",passage);
	Queue 	queue2 = new Queue("Left",passage);

	//queue1.start();
	//queue2.start();
	}

}






//main class 
public class Transit {

public static void main(String[] args)
{

		System.out.println("Hello world!");
}


}



