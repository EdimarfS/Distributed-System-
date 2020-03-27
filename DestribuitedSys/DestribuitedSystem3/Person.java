package bar;


public class Person {
	
	private String name;
	private final int age;
	private AgeGroup ageGroup;
	
	
	
	
	
	//constructor
	public Person(String name, int age, AgeGroup ageGroup) throw illegalArgumentException{
		
		//checking
		if(name != null && !name.trim().isEmpty())
			this.name = name;
		else 
			throw new illegalArgumentException();
		
		
		
		//checking age
		if(age > 0)
		{
				this.age = age;
		}else	{throw new illegalArgumentException();}
	
		
		this.ageGroup = ageGroup;
	}
	
	//Setters 
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setAgeGroup(int age)
	{
		this.age = age;
	}
	
	//getters 
	public AgeGroup getAgeGroup()
	{
		return ageGroup;
	}
	
	public int Age()
	{
		return age;
	}
	
	public String getName()
	{
		return name;
	}
	
	
	//toString method, used to print out the date from the current class
	public String toString()
	{
		return name + " (" + age + ", " + ageGroup + ")"; 
	}
	
	public boolean eqquals(Object o)
	{
		if(o != null && o instanceof Person)
		{
			Person = (Person) o;
			if(name == p.name && age == p.age && ageGroup == o.ageGroup)
			{
				return true;
			}
			
			return false;
		}
	}
	
	
	public void giveBeverage()
	{
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}