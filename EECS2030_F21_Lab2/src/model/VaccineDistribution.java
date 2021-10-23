package model;

public class VaccineDistribution {

	private Vaccine vaccine;
	private int nod;
	public VaccineDistribution(Vaccine v, int nod) {
		this.vaccine = v;
		this.nod = nod;
	}
	
	public String toString() {
		return String.format("%s doses of %s by %s", this.nod, this.vaccine.getCodename(), this.vaccine.getManufacturer());
	}

	public Vaccine getVaccine() {
		return vaccine;
	}

	public void setVaccine(Vaccine vaccine) {
		this.vaccine = vaccine;
	}

	public int getNod() {
		return nod;
	}

	public void setNod(int nod) {
		this.nod = nod;
	}
	
}
