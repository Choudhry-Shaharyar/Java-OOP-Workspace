package model;

import java.util.Iterator;






public class VaccinationSite {

	private int MaxNumberOfAvailableDoses;
	private String siteName;
	private int numberOfAvailableDoses;
	private int numModerna;
	private int numPfizer;
	private int numAstraZeneca;
	private int numJandJ;
	private int order;
	private boolean statusModerna;
	private boolean statusJandJ;
	private boolean statusPfizer;
	private boolean statusAstraZeneca;
	private VaccineDistribution[] vd;
	private int novd;
	private int modernaOrder;
	private int index;
	//private String s;
	private String status;
	private int MaxNumberAppointments;
	private HealthRecord[] appointments;
	private int noa; // number of appointments
	private boolean administered;
	private Vaccine[] vaccines;
	public int nov;
public int j ;

	public VaccinationSite(String siteName, int MaxNumberOfAvailableDoses){
		this.MaxNumberOfAvailableDoses= MaxNumberOfAvailableDoses;
		this.siteName = siteName;
		this.numberOfAvailableDoses = 0;
		this.vaccines = new Vaccine[MaxNumberOfAvailableDoses];
		this.vd = new VaccineDistribution[4];
		this.order = 0;
		this.status = "";
		this.novd = 0;
		this.MaxNumberAppointments = 200;
		this.appointments = new HealthRecord[200];
		this.noa = 0;
		this.nov = 0;
	}


	public int getMaxNumberOfAvailableDoses() {
		return MaxNumberOfAvailableDoses;
	}


	public void setMaxNumberOfAvailableDoses(int maxNumberOfAvailableDoses) {
		MaxNumberOfAvailableDoses = maxNumberOfAvailableDoses;
	}


	public Vaccine[] getVaccines() {
		return vaccines;
	}


	public void setVaccines(Vaccine[] vaccines) {
		this.vaccines = vaccines;
	}


	public String getSiteName() {
		return siteName;
	}

	//	public void addVaccine(Vaccine v) {
	//		for(int i = 0; i < 4; i++) {
	//			this.vaccine[i] = v;
	//		}
	//	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}


	//	public int getNumberVaccineKinds() {
	//		return NumberVaccineKinds;
	//	}
	//
	//
	//	public void setNumberVaccineKinds(int numberVaccineKinds) {
	//		NumberVaccineKinds = numberVaccineKinds;
	//	}
	//

	public int getNovd() {
		return novd;
	}


	public void setNovd(int novd) {
		this.novd = novd;
	}


	public void setNumModerna(int numModerna) {
		this.numModerna = numModerna;
	}


	public void setNumPfizer(int numPfizer) {
		this.numPfizer = numPfizer;
	}


	public void setNumAstraZeneca(int numAstraZeneca) {
		this.numAstraZeneca = numAstraZeneca;
	}


	public void setNumJandJ(int numJandJ) {
		this.numJandJ = numJandJ;
	}


	public int getNumModerna() {
		return numModerna;
	}


	public int getNumPfizer() {
		return numPfizer;
	}


	public int getNumAstraZeneca() {
		return numAstraZeneca;
	}


	public boolean isStatusModerna() {
		return statusModerna;
	}


	public boolean isStatusJandJ() {
		return statusJandJ;
	}


	public boolean isStatusPfizer() {
		return statusPfizer;
	}


	public boolean isStatusAstraZeneca() {
		return statusAstraZeneca;
	}


	public int getNumJandJ() {
		return numJandJ;
	}

	public int getNumberOfAvailableDoses() {
		return numberOfAvailableDoses;
	}

	public int getNumberOfAvailableDoses(String codename) {
		if (codename.equals("mRNA-1273")){
			return this.getNumModerna();
		}
		else if(codename.equals("BNT162b2")){
			return this.getNumPfizer();
		}
		else if(codename.equals("Ad26.COV2.S")){
			return this.getNumJandJ();
		}
		else if(codename.equals("AZD1222")){
			return this.getNumAstraZeneca();
		} else {
			return 0;
		}


	}

	public void administer(String date) {
		int count = 0;
		int counter = 0;
		//int j = 0;
//		  for(int i = 0; counter < this.noa; i++) {
//			  for(int j = 0; j < this.vd[i].getNod(); j++){
//			  	this.appointments[j].addVaccine(this.vd[i].getVaccine());
//			  	//j--;
//			  	//this.vd[i].setNod(this.vd[i].getNod() - 1);
//			  	
//			    counter++;
//			  }
//		  }
		  
		 

		for(int i = 0; i < this.noa; i++) {
			this.appointments[i].addDateReceivedDose(date);
			//this.appointments[i].addVaccinationSite(this.getSiteName());
			////////
			 this.appointments[i].addVaccine(this.vd[j].getVaccine());
			 this.vd[j].setNod(this.vd[j].getNod() - 1);
			  if(this.vd[j].getNod() == 0) {
				  j = j + 1;
			  }
			//////
			//this.appointments[i].addVaccine(this.vd[i].getVaccine());
		    //this.appointments[i].addVaccine(this.getVaccines()[i]);
	//for(int j = 0; j < this.vd[i].getNod(); j++) {
			//	this.appointments[i].addVaccine(this.vd[i].getVaccine());
//				this.appointments[i].addVaccine(this.vd[i].getVaccine());
//			    this.appointments[i].addVaccine(this.getVaccines()[i]);		
	//	}
			//////////////////////////////
			
			this.appointments[i].setAdministered(true);
	//		this.vd[i].setNod(this.vd[i].getNod() - 1);
//			
//			if(this.getVaccines()[i].getCodename().equals("mRNA-1273") ) {
//				this.setNumModerna((this.getNumModerna() - 1));						
//			}
//			else if(this.getVaccines()[i].getCodename().equals("BNT162b2")) {
//				this.setNumPfizer((this.getNumPfizer()- 1));
//			}
//			else if(this.getVaccines()[i].getCodename().equals("Ad26.COV2.S")) {
//				this.setNumJandJ((this.getNumJandJ() - 1));			
//			}
//			else if(this.getVaccines()[i].getCodename().equals("AZD1222")) {
//				this.setNumAstraZeneca((this.getNumAstraZeneca() - 1));				
//			}
			
			this.numberOfAvailableDoses--;
			count++;
		}
	
		 this.noa = this.noa - count;
	}


	public void bookAppointment(HealthRecord hr) throws InsufficientVaccineDosesException {
		//if(this.numberOfAvailableDoses == 0)
		if(this.noa == this.numberOfAvailableDoses) {
			hr.setStatus("fail");
			hr.setVaccinationSite(this.getSiteName());
			throw new InsufficientVaccineDosesException("Unexpected exception thrown");
		}
		//else if(alan.admistered = true) {
			
	//	}
		else {
			
			hr.setVaccinationSite(this.getSiteName());
			this.appointments[this.noa] = hr;
			
			this.noa++;
			//this.numberOfAvailableDoses--;
			hr.setNoa(hr.getNoa() + 1);
			//hr.setNOD(hr.getNOD() + 1); //
			
		}
	}



	//"Last vaccination appointment for Alan with North York General Hospital succeeded", alan.getAppointmentStatus()



	public void setNumberOfAvailalbleDoses(int numberOfAvailableDoses) {
		this.numberOfAvailableDoses = numberOfAvailableDoses;
	}



	public String toString() {

		String s="";
		for(int i = 0; i < this.novd; i++) {

			if(i == (this.novd - 1)) {
				s = s + this.vd[i].getNod() + " doses of " + this.vd[i].getVaccine().getManufacturer();
			}
			else {
				s = s + this.vd[i].getNod() + " doses of " + this.vd[i].getVaccine().getManufacturer() + ", ";
			}
		}

		return String.format("%s has %s available doses: <%s>", this.getSiteName(), this.getNumberOfAvailableDoses(), s);
	}
	//	public String toString() {
	//		//String[] s = new String[this.novd];
	//		if (this.getNovd() == 0) {
	//			return String.format("%s has %s available doses: <>", this.getSiteName(), this.getNumberOfAvailableDoses());
	//		}
	//		else if (this.getNovd() == 1) {
	//			return String.format("%s has %s available doses: <%s doses of %s>", this.getSiteName(), this.getNumberOfAvailableDoses(), this.vd[0].getNod(), this.vd[0].getVaccine().getManufacturer());
	//		}
	//		else if (this.getNovd() == 2) {
	//			if(this.vd[0].getVaccine().getCodename().equals(this.vd[1].getVaccine().getCodename())) {
	//				return String.format("%s has %s available doses: <%s doses of %s>", this.getSiteName(), this.getNumberOfAvailableDoses(), this.vd[0].getNod() + this.vd[1].getNod(), this.vd[0].getVaccine().getManufacturer());
	//			}
	//			else {
	//				return String.format("%s has %s available doses: <%s doses of %s, %s doses of %s>", this.getSiteName(), this.getNumberOfAvailableDoses(), this.vd[0].getNod(), this.vd[0].getVaccine().getManufacturer(), this.vd[1].getNod(), this.vd[1].getVaccine().getManufacturer());
	//			}
	//		}
	//		/////////////////////////////// -------
	//		else if (this.getNovd() == 3) {
	//			if(this.vd[0].getVaccine().getCodename().equals(this.vd[1].getVaccine().getCodename())) { 
	//				return String.format("%s has %s available doses: <%s doses of %s, %s doses of %s>", this.getSiteName(), this.getNumberOfAvailableDoses(), this.vd[0].getNod() + this.vd[1].getNod(), this.vd[0].getVaccine().getManufacturer(), this.vd[2].getNod(), this.vd[2].getVaccine().getManufacturer());
	//			}
	//			else if (this.vd[0].getVaccine().getCodename().equals(this.vd[2].getVaccine().getCodename())) {
	//				return String.format("%s has %s available doses: <%s doses of %s, %s doses of %s>", this.getSiteName(), this.getNumberOfAvailableDoses(), this.vd[0].getNod() + this.vd[2].getNod(), this.vd[0].getVaccine().getManufacturer(), this.vd[1].getNod(), this.vd[1].getVaccine().getManufacturer());
	//			}
	//			else if(this.vd[1].getVaccine().getCodename().equals(this.vd[2].getVaccine().getCodename())) {
	//				return String.format("%s has %s available doses: <%s doses of %s, %s doses of %s>", this.getSiteName(), this.getNumberOfAvailableDoses(), this.vd[0].getNod(), this.vd[0].getVaccine().getManufacturer(), this.vd[2].getNod() + this.vd[1].getNod(), this.vd[2].getVaccine().getManufacturer());
	//			}
	//			else if (this.vd[0].getVaccine().getCodename().equals(this.vd[1].getVaccine().getCodename()) && this.vd[1].getVaccine().getCodename().equals(this.vd[2].getVaccine().getCodename())) {
	//				return String.format("%s has %s available doses: <%s doses of %s>", this.getSiteName(), this.getNumberOfAvailableDoses(), this.vd[0].getNod() + this.vd[1].getNod() + this.vd[2].getNod(), this.vd[0].getVaccine().getManufacturer());
	//			}
	//			else {
	//				return String.format("%s has %s available doses: <%s doses of %s, %s doses of %s, %s doses of %s>", this.getSiteName(), this.getNumberOfAvailableDoses(), this.vd[0].getNod(), this.vd[0].getVaccine().getManufacturer(), this.vd[1].getNod(), this.vd[1].getVaccine().getManufacturer(), this.vd[2].getNod(), this.vd[2].getVaccine().getManufacturer());
	//			}
	//		}
	//
	//		else if (this.getNovd() == 4) {
	//			if(this.vd[0].getVaccine().getCodename().equals(this.vd[1].getVaccine().getCodename())) { 
	//				return String.format("%s has %s available doses: <%s doses of %s, %s doses of %s, %s doses of %s>", this.getSiteName(), this.getNumberOfAvailableDoses(), this.vd[0].getNod() + this.vd[1].getNod(), this.vd[0].getVaccine().getManufacturer(), this.vd[2].getNod(), this.vd[2].getVaccine().getManufacturer(), this.vd[3].getNod(), this.vd[3].getVaccine().getManufacturer());
	//			}
	//			else if (this.vd[0].getVaccine().getCodename().equals(this.vd[2].getVaccine().getCodename())) {
	//				return String.format("%s has %s available doses: <%s doses of %s, %s doses of %s, %s doses of %s>", this.getSiteName(), this.getNumberOfAvailableDoses(), this.vd[0].getNod() + this.vd[2].getNod(), this.vd[0].getVaccine().getManufacturer(), this.vd[1].getNod(), this.vd[1].getVaccine().getManufacturer(), this.vd[3].getNod(), this.vd[3].getVaccine().getManufacturer());
	//			}
	//			else if(this.vd[0].getVaccine().getCodename().equals(this.vd[3].getVaccine().getCodename())) {
	//				return String.format("%s has %s available doses: <%s doses of %s, %s doses of %s>", this.getSiteName(), this.getNumberOfAvailableDoses(), this.vd[0].getNod(), this.vd[0].getVaccine().getManufacturer(), this.vd[2].getNod() + this.vd[1].getNod(), this.vd[2].getVaccine().getManufacturer());	
	//			}
	//			else if(this.vd[1].getVaccine().getCodename().equals(this.vd[2].getVaccine().getCodename())) {
	//				return String.format("%s has %s available doses: <%s doses of %s, %s doses of %s>", this.getSiteName(), this.getNumberOfAvailableDoses(), this.vd[0].getNod(), this.vd[0].getVaccine().getManufacturer(), this.vd[2].getNod() + this.vd[1].getNod(), this.vd[2].getVaccine().getManufacturer());
	//			}
	//			else if(this.vd[1].getVaccine().getCodename().equals(this.vd[3].getVaccine().getCodename())) {
	//				return String.format("%s has %s available doses: <%s doses of %s, %s doses of %s>", this.getSiteName(), this.getNumberOfAvailableDoses(), this.vd[0].getNod(), this.vd[0].getVaccine().getManufacturer(), this.vd[2].getNod() + this.vd[1].getNod(), this.vd[2].getVaccine().getManufacturer());
	//			}
	//			else if(this.vd[3].getVaccine().getCodename().equals(this.vd[3].getVaccine().getCodename())) {
	//				return String.format("%s has %s available doses: <%s doses of %s, %s doses of %s>", this.getSiteName(), this.getNumberOfAvailableDoses(), this.vd[0].getNod(), this.vd[0].getVaccine().getManufacturer(), this.vd[2].getNod() + this.vd[1].getNod(), this.vd[2].getVaccine().getManufacturer());
	//			}
	//			else {
	//				return String.format("%s has %s available doses: <%s doses of %s, %s doses of %s, %s doses of %s, %s doses of %s>", this.getSiteName(), this.getNumberOfAvailableDoses(), this.vd[0].getNod(), this.vd[0].getVaccine().getManufacturer(), this.vd[1].getNod(), this.vd[1].getVaccine().getManufacturer(), this.vd[2].getNod(), this.vd[2].getVaccine().getManufacturer(), this.vd[3].getNod(), this.vd[3].getVaccine().getManufacturer());
	//			}
	//		}
	//
	//		else if (this.getNovd() == 5) {
	//			if (this.vd[0].getVaccine().getCodename().equals(this.vd[2].getVaccine().getCodename()) && this.vd[1].getVaccine().getCodename().equals(this.vd[4].getVaccine().getCodename())  ) {
	//				return String.format("%s has %s available doses: <%s doses of %s, %s doses of %s, %s doses of %s>", this.getSiteName(), this.getNumberOfAvailableDoses(), this.vd[0].getNod() + this.vd[2].getNod(), this.vd[0].getVaccine().getManufacturer(), this.vd[1].getNod() + this.vd[4].getNod(), this.vd[1].getVaccine().getManufacturer(), this.vd[3].getNod(), this.vd[3].getVaccine().getManufacturer());
	//			}
	//		}


	//		else if (this.getNovd() == 3) {
	//			if(this.vd[0].getVaccine().getCodename().equals(this.vd[1].getVaccine().getCodename()) || this.vd[0].getVaccine().getCodename().equals(this.vd[2].getVaccine().getCodename()) || this.vd[2].getVaccine().getCodename().equals(this.vd[1].getVaccine().getCodename())) {
	//				return String.format("%s has %s available doses: <%s doses of %s, %s doses of %s>", this.getSiteName(), this.getNumberOfAvailableDoses(), this.vd[0].getNod(), this.vd[0].getVaccine().getManufacturer(), this.vd[1].getNod(), this.vd[1].getVaccine().getManufacturer());
	//			}
	//			else {
	//				return String.format("%s has %s available doses: <%s doses of %s, %s doses of %s, %s doses of %s>", this.getSiteName(), this.getNumberOfAvailableDoses(), this.vd[0].getNod(), this.vd[0].getVaccine().getManufacturer(), this.vd[1].getNod(), this.vd[1].getVaccine().getManufacturer(), this.vd[2].getNod(), this.vd[2].getVaccine().getManufacturer());
	//			}
	//		}
	//////////////////// -------------- 
	//return "";
	//}


	/////////////////////////////////


	//		else  {
	//
	//		}
	//		for(int i = 0; i < this.novd; i++) {
	//			if (this.isStatusModerna() == true) {
	//				i = i + 1;
	//			}
	//			s[i] = this.vd[i].getVaccine().getManufacturer();
	//		}



	// 2a vid D1
	
	/// initialize vaccine objects!

	public void addDistribution(Vaccine v1, int nod) throws  UnrecognizedVaccineCodeNameException, TooMuchDistributionException {
		VaccineDistribution distribution = new VaccineDistribution(v1, nod);
		//////////////////////
		if(distribution.getVaccine().getManufacturer().equals("Moderna") || distribution.getVaccine().getManufacturer().equals("Pfizer/BioNTech") || distribution.getVaccine().getManufacturer().equals("Janssen") || distribution.getVaccine().getManufacturer().equals("Oxford/AstraZeneca")) {

		}
		else {
			throw new UnrecognizedVaccineCodeNameException("Unexpected exception thrown");	
		}
		///////////////////////
		if((nod + this.getNumberOfAvailableDoses()) > this.getMaxNumberOfAvailableDoses()) {
			throw new TooMuchDistributionException("Unexpected exception thrown");
		}

		if(this.novd == 0  && (distribution.getVaccine().getManufacturer().equals("Moderna") || distribution.getVaccine().getManufacturer().equals("Pfizer/BioNTech") || distribution.getVaccine().getManufacturer().equals("Janssen") || distribution.getVaccine().getManufacturer().equals("Oxford/AstraZeneca"))) {
			for(int i = 0; i < nod; i++) {
				this.vaccines[i] = v1;
				this.nov = nod;
			}
			
			this.vd[this.novd] = distribution;
			this.vd[this.novd].setNod(nod);
			this.novd++; // number of unique vaccine distributuion increase
			this.numberOfAvailableDoses = this.getNumberOfAvailableDoses() + nod;
		}
		else {

			for(int i = 0; i < this.novd; i++) {
				if(distribution.getVaccine().getCodename().equals(this.vd[i].getVaccine().getCodename())) {
					index = i;
					this.status = "exists";
					i = this.novd + 1; // exists for loop and wont add to vaccineDistribution array
				}
				else {
					this.status = "dne";
				}
			}
			if(this.status.equals("dne")) {

				if(distribution.getVaccine().getManufacturer().equals("Moderna") || distribution.getVaccine().getManufacturer().equals("Pfizer/BioNTech") || distribution.getVaccine().getManufacturer().equals("Janssen") || distribution.getVaccine().getManufacturer().equals("Oxford/AstraZeneca")) {
					for(int i = this.nov; i < (this.nov + nod); i++) {
						this.vaccines[i] = v1;
					}
					this.nov = this.nov + nod;
					this.vd[this.novd] = distribution;
					this.vd[this.novd].setNod(nod);
					this.novd++; // number of unique vaccine distributuion increase
					this.numberOfAvailableDoses = this.getNumberOfAvailableDoses() + nod;
				}
				else {
					throw new UnrecognizedVaccineCodeNameException("Unexpected exception thrown");	
				}


			}

			//this.status.equals("exists")
			else{
				for(int i = this.nov; i <(this.nov+ nod); i++) {
					this.vaccines[i] = v1;
				}
				this.nov = this.nov + nod;
				this.vd[index].setNod(this.vd[index].getNod() + nod); // if manufacturer already exists in the array
				this.numberOfAvailableDoses = this.getNumberOfAvailableDoses() + nod;
			}
		}

		if(v1.getCodename().equals("mRNA-1273") ) {
			this.setNumModerna((this.getNumModerna() + nod));						
		}
		else if(v1.getCodename().equals("BNT162b2")) {
			this.setNumPfizer((this.getNumPfizer() + nod));
		}
		else if(v1.getCodename().equals("Ad26.COV2.S")) {
			this.setNumJandJ((this.getNumJandJ() + nod));			
		}
		else if(v1.getCodename().equals("AZD1222")) {
			this.setNumAstraZeneca((this.getNumAstraZeneca() + nod));				
		}
		else {

		}

	}

	//	public void addDistribution(Vaccine v1, int nod) throws UnrecognizedVaccineCodeNameException {
	//
	//		int[] count = new int[10];
	//		
	//		if((nod + this.getNumberOfAvailableDoses()) > this.getMaxNumberOfAvailableDoses()) {
	//			// exception error TooMuchDistributionException
	//		}
	//		else {
	//			//	&& this.statusModerna == false
	//			if(v1.getCodename().equals("mRNA-1273") ) {
	//
	//				this.setNumModerna((this.getNumModerna() + nod));
	//				this.order = this.novd;
	//				this.modernaOrder = this.order;
	//				this.statusModerna = true;
	//				//this.vd[this.order].setNod((this.vd[this.order].getNod() + nod));
	//			}
	//			//	if(v1.getCodename().equals("mRNA-1273") && this.statusModerna == true) {
	//			//		this.vd[this.modernaOrder].setNod((this.vd[this.modernaOrder].getNod() + nod));
	//			//	}
	//
	//			else if(v1.getCodename().equals("BNT162b2")) {
	//				this.setNumPfizer((this.getNumPfizer() + nod));
	//				this.order = this.novd;
	//				this.statusPfizer = true;
	//				
	//	
	//			}
	//			else if(v1.getCodename().equals("Ad26.COV2.S")) {
	//				this.setNumJandJ((this.getNumJandJ() + nod));
	//				this.order = this.novd;
	//				this.statusJandJ = true;
	//			}
	//			else if(v1.getCodename().equals("AZD1222")) {
	//				this.setNumAstraZeneca((this.getNumAstraZeneca() + nod));
	//				this.order = this.novd;
	//				this.statusAstraZeneca = true;
	//			}
	//			else {
	//				throw new  UnrecognizedVaccineCodeNameException("Unexpected exception thrown");
	//				// exception error
	//			}
	//
	//			VaccineDistribution distrubution = new VaccineDistribution(v1, nod);
	//			for( ||  || )
	//			this.vd[this.novd] = distrubution;
	//
	//			novd++; // number of vaccine distributions
	//
	//			//		if(v1.get)
	//			//			//		for(int i = 0; i < this.getNumberVaccineKinds() ; i++) {
	//			//			//			this.vaccine[i] = v1;
	//			//			//		}
	//			//			//		
	//
	//			this.setNumberOfAvailalbleDoses(this.getNumberOfAvailableDoses() + nod);
	//
	//			this.order = this.order + 1;
	//
	//
	//		}
	//
	//	}

}
