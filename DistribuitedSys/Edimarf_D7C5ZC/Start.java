import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;



//Car class 
class Car{
	String direction;
	long time;
	int id;
	
	Car(String direction,long time,int id){
		this.direction = direction ;
		this.time = time;
		this.id = id;
	}
	
	String getDirection_(){
		return direction;
	}
	long getTime(){
		return time;
	}
	int getID(){
		return id;
	}
	
	 public String toString(){
		return "car :" + getID() +" taken time: " + getTime();
	}
}


//Que Class 
class Queue extends Thread {
	
	PriorityQueue<Car> traffic;
	String direction;
	Passage passage;
	int carNm;
	
	Queue(String dir ,int N, Passage p){
		direction = dir;
		passage = p;
		carNm=N;
		Comparator<Car> compare = new Comparator<Car>() {
			
            @Override
            public int compare(Car c1, Car c2) {
                return (int)(c1.getTime() - c2.getTime());
            }
        };
		traffic = new PriorityQueue<>(compare);
		
	}

public  void  passing(){

	synchronized(passage){
		//System.out.println(Thread.getName());
		Car tmp = traffic.poll();
		try{
			this.sleep(tmp.getTime());
			
		 }catch(InterruptedException e){
			 
			 System.out.println(" interrupted ");
		 }
		
		passage.carPassing_Info(tmp);
	}

}
	public void run(){
		while (!traffic.isEmpty()) { //Passsage
            this.passing();
        }
	
	}
	
	void  populate (){
		for(int i =0 ;i<carNm;){
			Car tmpcar = new Car(direction,(int)(Math.random()*2000),i++);
			traffic.add(tmpcar);
			System.out.println(tmpcar+" comming from "+direction);
		}
	}
}

class Passage {

	Passage(){
		
	}
	
	 void carPassing_Info(Car car){
		System.out.println(car +" from "+car.getDirection_()+ " is passing the Passage " );
		
	}
}



public class Start{
	public static void main(String[] args){
		
		Passage passage = new Passage();

		Queue queue1 = new Queue("right" ,12 , passage);
		Queue queue2 = new Queue("left",19, passage);
		
		queue1.populate();
		queue2.populate();

		queue1.start();
		queue2.start();
		
		
	}
}







/*

  Name: Edimarf Satumbo

  Neptun code: D7C5ZC

*/