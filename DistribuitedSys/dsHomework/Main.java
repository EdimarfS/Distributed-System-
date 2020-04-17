import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;



//Car class

class Car{
	String direction;
	long time;
	int id;
	
	Car(String direction,long time,int id){
		direction = direction ;
		time = time;
		id = id;
	}
	
	String getDirection_(){
		return direction;
	}
	long getTime_(){
		return time;
	}
	int getID_(){
		return id;
	}
	
	 public String toString(){
		return "car :" + id +" taken time: " + getTime_();
	}
}

//Quee class
class Queue extends Thread {
	
	PriorityQueue<Car> traffic;
	String direction;
	Passage passage;
	int carNumber;
	
	Queue(String direction ,int N, Passage passage){
		direction = direction;
		passage = passage;
		carNumber=N;
		
		Comparator<Car> compare = new Comparator<Car>() {
			
            @Override
            public int compare(Car c1, Car c2) {
                return (int)(c1.getTime_() - c2.getTime_());
            }
        };
		traffic = new PriorityQueue<>(compare);
		
		
	}


//
public  void  attempPass(){

	synchronized(passage){
		Car tmp = traffic.poll();
		try{
			this.sleep(tmp.getTime_());
			
		 }catch(InterruptedException e){
			 
			 System.out.println(" interrupted ");
		 }
		
		passage.carpassing(tmp);
}

}

//Run function, overried from Runnable 
public void run(){
while (!traffic.isEmpty()) {

		this.attempPass();

   
}

}
	
	void  populate (){
		for(int i =0 ;i<carNumber;){
			Car tmpcar = new Car(direction,(int)(Math.random()*2000),i++);
			traffic.add(tmpcar);
			System.out.println(tmpcar + " comming from " + direction);
		}
	}
}


//Passgae class 
class Passage {

	Passage(){
		
	}
	
	 void carpassing(Car car){
		System.out.println(car +" from "+car.getDirection_()+ " is passing the Passage " );
		
	}
}


//Main class 
public class Main{
	public static void main(String[] args){
		
		Passage p = new Passage();
		
		Queue q1 = new Queue("left" ,11 , p);
		Queue q2 = new Queue("right",13, p);
		
		q1.populate();
		q2.populate();
		
		q1.start();
		q2.start();
		
		
	}
}


