package model;

public class Vaccine {

	private String codename;
	private String type;
	private String manufacturer;
	private String status;
	
	public Vaccine(String codename, String type, String manufacturer) {

		if ((codename.equals("mRNA-1273")) || (codename.equals("BNT162b2")) || (codename.equals("Ad26.COV2.S")) || (codename.equals("AZD1222"))){
			this.status = "Recognized vaccine";
		}
		else {
			this.status = "Unrecognized vaccine";
		}
		
		this.codename = codename;
		this.manufacturer = manufacturer;
		this.type = type;
	}
	
	
	
	
	public String getCodename() {
		return codename;
	}




	public void setCodename(String codename) {
		this.codename = codename;
	}




	public String getType() {
		return type;
	}




	public void setType(String type) {
		this.type = type;
	}




	public String getManufacturer() {
		return manufacturer;
	}




	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}




	public String toString() {
		return String.format("%s: %s (%s; %s)", this.status, this.codename, this.type, this.manufacturer);
		
	}
}

