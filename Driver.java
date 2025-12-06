public class Driver extends Person {
     
		private double odometer;
		private double raiting;
		private String carModel;
		private Order currentOrder;
		private String deliveryTime;


public Driver(String password, String name, String phoneNumber, String email, String carModel, double odometer, double raiting/*, remainder of constructor for default totxt*/){
	super(password,name,phoneNumber,email);
	this.carModel = carModel;
	this.odometer = odometer;
	this.raiting = raiting;

	/*remainder of constructor for default totxt*/
}

//Temp from order since I need it for code
		private double distance = 5.5;


	public boolean isDriver(){
		return true;
	}


	public void setOdometer(){
		odometer = odometer + distance;
	}




	public double getOdometer(){
		
		return odometer;
	}




	public double getRaiting(){
		
		return raiting;
	}




	public void setCarModel(String userInput){
		this.carModel = userInput;
	}




	public String getCarModel(){

		return carModel;
	}




	public void setCurrentOrder(Order d){
		this.currentOrder = d;		
	}





	public Order getCurrentOrder(){
		return currentOrder;
	}





	public String getDeliveryAddress(){
		return "";
	}




	public String viewOrder(){
		return "";
	}


    

  
}
