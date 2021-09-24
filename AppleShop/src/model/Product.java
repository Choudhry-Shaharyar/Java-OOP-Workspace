package model;
/*
 * Date: September 16, 2021
 * Description: Template for individual apple product in the refurbished store
 */
public class Product {	
	/* attributes: should be private so that they are only visible within the current class 
	 * 
	 * If you intend to make an attribute public, it will be visible to all classes.
	 * Instead, create a public accessor for this private attribute.
	 * */
	private String model; // e.g., iPad Pro 12.9
	private String finish; // e.g., Silver, Space Grey
	private int storage; // in the unit of GB, e.g., 265, 512, 1000 (1TB)
	private boolean hasCellularConnectivity; // e.g., false (only wifi), true (wifi + cellular)
	private double originalPrice; // e.g., 1789.00
	private double discountValue; // e.g., 200.00
   
	
	/* constructors */
	// if no constructor are declared here, an implicit default constructor is available
	// Advice: if you really find the default constructor useful, define one explicitly,
	// otherwise as soon as any additional constructors are added, the implicit one becomes unavailable.
	public Product() {
		// do nothing: all attributes will be stored their default values after an object is created.
	}
	
	// An overloaded version of the constructor.
	public Product(String model, double originalPrice) {
		this.model = model;
		this.originalPrice = originalPrice; 
 	}
	
	
	/* accessors */
	public String getModel() {
		return this.model;
	}
	
	/* mutators */
	public void setModel(String model) {
		this.model = model;
	}


	public String getFinish() {
		return finish;
	}


	public void setFinish(String finish) {
		this.finish = finish;
	}


	public int getStorage() {
		return storage;
	}


	public void setStorage(int storage) {
		this.storage = storage;
	}


	public boolean hasCellularConnectivity() {
		return hasCellularConnectivity;
	}


	public void setHasCellularConnectivity(boolean hasCellularConnectivity) {
		this.hasCellularConnectivity = hasCellularConnectivity;
	}


	public double getOriginalPrice() {
		return originalPrice;
	}


	public void setOriginalPrice(double originalPrice) {
		this.originalPrice = originalPrice;
	}
   

	public double getDiscountValue() {
		return discountValue;
	}


	public void setDiscountValue(double discountValue) {
		this.discountValue = discountValue;
	}
	
	public double getPrice() {
		// local variable declarations
		double price = 0.0;
			
		// computation (this. is not required to add. because we do not have 2 of the same variable name)
		price = this.originalPrice - this.discountValue; 
		
		// return
		return price; 
	}
	
	// showing 3 different ways to write the toString method
	public String toString() {
		String s = "";
		
//		StringBuilder sb = new StringBuilder();
//		sb.append(model + " "  + finish + " " + storage + "GB "
//	    		 + "(cellular connectivity: " + hasCellularConnectivity + "): $("
//    		     + String.format("%2f", originalPrice) + " - " + String.format("%2f", discountValue) + ")" )
//		s = sb.toString();
		
	    s += model + " "  + finish + " " + storage + "GB " + "(cellular connectivity: " + hasCellularConnectivity + "): $(" + String.format("%.2f", originalPrice) + " - " + String.format("%.2f", discountValue) + ")";
	
//		s = String.format("%s %s %dGB (cellular connectivity: %s): $(%.2f - %.2f)",
//				this.model, this.finish, this.storage, this.hasCellularConnectivity, 
//				this.originalPrice,  this.discountValue);
				
		
		return s;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
