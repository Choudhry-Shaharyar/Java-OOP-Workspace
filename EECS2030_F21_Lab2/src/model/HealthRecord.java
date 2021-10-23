package model;

public class HealthRecord {
	
	private int MAXnod;
	private String name;
	private Vaccine[] vaccine;
	private String[] dateReceivedDose;
	private String[] vaccinationSite;
	private int nod;
	private int noa; // number of appointments
	private String status;
	private boolean administered;
	
	public HealthRecord(String name, int MAXnod) {
		this.name = name;
		this.MAXnod = MAXnod;
		this.vaccine = new Vaccine[MAXnod];
		this.dateReceivedDose = new String[MAXnod];
		this.vaccinationSite = new String[MAXnod];
		this.status=  "pass";
	}
	

	public boolean isAdministered() {
		return administered;
	}


	public void setAdministered(boolean administered) {
		this.administered = administered;
	}


	public void setDateReceivedDose(String[] dateReceivedDose) {
		this.dateReceivedDose = dateReceivedDose;
	}


	public Vaccine[] getVaccine() {
		return vaccine;
	}


	public void setVaccine(Vaccine[] vaccine) {
		this.vaccine = vaccine;
	}

//	public void addVaccine(Vaccine vaccine) {
//		this.vaccine[this.nod - 1] = vaccine; // this.nod
//		//this.nod++;
//	}
	public void addVaccine(Vaccine vaccine) {
		this.vaccine[this.nod] = vaccine; // this.nod
		this.nod++;
	}



	public String[] getDateReceivedDose() {
		return dateReceivedDose;
	}


	public void addDateReceivedDose(String dateReceivedDose) {
		this.dateReceivedDose[this.nod] = dateReceivedDose;
	}

	public void addVaccinationSite(String vaccinationSite) {
		this.vaccinationSite[this.nod] = vaccinationSite;
	}
	
	
	public void setVaccinationSite(String[] vaccinationSite) {
		this.vaccinationSite = vaccinationSite;
	}
	


	public int getNod() {
		return nod;
	}


	public void setNod(int nod) {
		this.nod = nod;
	}


	public int getNoa() {
		return noa;
	}


	public void setNoa(int noa) {
		this.noa = noa;
	}



	public String[] getVaccinationSite() {
		return vaccinationSite;
	}


	public void setVaccinationSite(String vaccinationSite) {
		this.vaccinationSite[this.noa] = vaccinationSite; // nod
	}


	public int getMAXnod() {
		return MAXnod;
	}


	public int getNOD() {
		return nod;
	}


	public void setNOD(int nod) {
		this.nod = nod;
	}


	public void setMAXnod(int mAXnod) {
		MAXnod = mAXnod;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	public String getVaccineList() {
		String s = "";
		
		if(this.getNOD() == 1) {
			for(int i = 0; i < this.getNOD(); i++) {
			s =  this.getVaccine()[i].toString() + " in " + this.getVaccinationSite()[i] + " on " + this.getDateReceivedDose()[i];
			}
			return s;
		}
		else {
		
		for(int i = 0; i < this.getNOD(); i++) {
			if(i == (this.getNOD() - 1)) {
			s = s + this.getVaccine()[i].toString() + " in " + this.getVaccinationSite()[i] + " on " + this.getDateReceivedDose()[i];
	
			} else {
			s = s + this.getVaccine()[i].toString() + " in " + this.getVaccinationSite()[i] + " on " + this.getDateReceivedDose()[i] + "; ";
			}
		}
		return s;
		}
	}


	public String getVaccinationReceipt() {
		if(this.getNOD() == 0) {
		return String.format("%s has not yet received any doses.", this.getName());
		}
		// if adminsteref
	
		return String.format("Number of doses %s has received: %s [%s]",this.getName(),this.getNOD(),this.getVaccineList());
	}
	//"Number of doses Alan has received: 1 [Recognized vaccine: mRNA-1273 (RNA; Moderna) in North York General Hospital on April-20-2021]"


	public String getAppointmentStatus() {
		
	 if(this.getStatus().equals("fail")) {
			return String.format("Last vaccination appointment for %s with %s failed", this.getName(), this.getVaccinationSite()[this.noa]);
		}
	 else if(this.noa == 0) {
			return String.format("No vaccination appointment for %s yet", this.getName());
		}
		else {
			return String.format("Last vaccination appointment for %s with %s succeeded", this.getName(), this.getVaccinationSite()[this.noa - 1]);
		}
		
	}


	public void addRecord(Vaccine v1, String vaccinationSite, String dateReceivedDose) {
		this.vaccine[this.nod] = v1;
		this.vaccinationSite[this.nod] = vaccinationSite;
		this.dateReceivedDose[this.nod] = dateReceivedDose;
		this.nod++;
	}

}
