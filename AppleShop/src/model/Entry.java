package model;


/*
 * Template of a unit of storage in the apple refurbished shop.
 * Think of a shop as a collection of entries. 
 */
public class Entry {
	private String serialNumber; // e.g., F9FDN4NKQ1GC (unique)
	/* the type of attribute is a reference type, denoting an existing class
    * Consequently, at runtime, this attribute will store the address
    * of some Product object.
    */  
	private Product product;
	
	// Constructor
	public Entry (String serialNumber, Product product) {
		this.serialNumber = serialNumber;
		this.product = product;
	}

	// getters and setters
	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	/*
	 * An overloaded version of the setProduct mutator.
	 * This version of setProduct does not expect the user to create a Product object and pass it as an argument.
	 * Instead we would expect the user to pass a String model and a value of the original price.
	 * (internally inside the method, it's expected that a local, new Product object is created accordingly)
	 */
	public void setProduct(String model, double originalPrice) {
		//	this.product = new Product(model,originalPrice); // Anonymous object (objects without a name)
		Product p = new Product(model,originalPrice);
		this.product =p;
	}
	public String toString() {
		return "[" + this.serialNumber + "] " + this.product.toString();
	}
	
	
	
	
	
	
	
	
	
	
	
	

}