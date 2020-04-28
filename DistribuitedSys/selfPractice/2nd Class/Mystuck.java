// we must use thread safty 





class StuckClass {
 
int top = 0;
	char[] data = new char[6];

	//method push 
	public void push(char c)
	{
		synchronized(this)
		{
			data[top] = c;
			top++;
		}

	}

	//method pop 
	public synchronized char pop() // -> Here we will use the sync in the whole function 
	{
		top--;
		return data[top+1];
	}

}



class Mystuck {


public static void main(String[] args)
{
	//System.out.println("Working from home");

	StuckClass s = new StuckClass();
	StuckClass o = new StuckClass();

	s.push('a');
	o.push('o');
	s.pop();
	s.pop(); 

}
	

}

