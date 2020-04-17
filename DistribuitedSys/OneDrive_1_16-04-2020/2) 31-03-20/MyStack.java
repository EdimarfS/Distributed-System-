public class MyStack{
	int top = 0;
	char[] data = new char[6];
	
	public void push(char c){
		synchronized(this){
			data[top] = c;
			top++;
		}
	}
	
	public synchronized char pop(){
		top--;
		return data[top+1];
	}
}

//2 threads t1 and t2, accessing 1 instance of MyStack

MyStack s = new MyStack();

//t1 and t2 both have references to s

s.push('c'); //t1
s.pop(); //t2



synchronized(obj){ //expr is the obj on which you want to acquire the lock
	//instructions (critical section)
}