public class Driver extends Person {

     private String vehicle;
		private double odometer = 0;
		private double raiting = 0;
		private String carModel = "1978 Boogati";
		private String currentOrder;
		private String deliveryTime;




//Temp from order since I need it for code
		private double distance = 5.5;


	public boolean isDriver(){
				boolean verify = false;

		if(userID.charAt(0) == 'D'){
			verify = true;
		}
		return verify;
	}



	public void setOdometer(){
		odometer = odometer + distance;
	}




	public double getOdometer(){

		return odometer;
	}




	public double getRaiting(){

		return -1;
	}




	public void setCarModel(){
		
	}




	public String getCarModel(){

		return "";
	}




	public void setCurrentOrder(){
		
	}





	public String getCurrentOrder(){
		return "";
	}





	public String getDeliveryAddress(){
		return "";
	}




	public String viewOrder(){
		return "";
	}


    

  
}
