import package bar;

public class Bartender extends Person {
	
	public Bartender(String name, int age, AgeGroup ageGroup) throw new AgeGroupException{
		super(name, age, ageGroup);
		
		if(ageGroup!=AgeGroup.ADULT) {
			throw new AgeGroupException("Only Adult Bartenders are allowed");
		}
	}
	
	public void giveBeverage(Guest guest, Beverage beverage)
	{
		if(guest.getAge() < beverage.getAge())
		{
			throw new AgeGroupException();
			
		}else{
			guest.setBeverage(beverage);
			increasepaiAmount(b.getPrice());
		}
	}
	
	
	
}
