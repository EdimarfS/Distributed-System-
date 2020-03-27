package bar;


public class Guest extends Person{
	//Variables declarations
	
	private Beverage beverage =  new Beverage();
	private int paidAmount;
	private static final Beverage noneBev = beverage;  
	
	//Setters and getters : 
	
	//Beverage 
	public void setBeverage(Beverage beverage){
		
		this.beverage = beverage;
	}
	
	public Beverage getBeverage(){
		
		return beverage;
	}
	
	//Paid Amount 
	public int getpaidAmount(){
		
		return paidAmount;
	}
	
		public void setpaidAmount(int paidAmount){
		
		this.paidAmount = paidAmount;
	}
	
	public void increasePaidAmount(int i){
		//...
		
		paidAmount+=1;
	}
	
		public void giveBeverage(Guest guest, Beverage beverage)
	{	
		if(beverage.getName() != noneBev.getName()){
			
			guest.setBeverage(beverage);
			beverage = noneBev;
		}else{
			
			increasePaidAmount(b.getPrice());
			guest.setBeverage(b);
			
			
		}
	
	}
	
	
	
	
	
	
}