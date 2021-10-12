 package model;

public class Account {

	private String ownerName;
	private AppStore appStore;
	private App[] downloadedApps;
	private int NumberOfDownloadedApps;
	private String status;
	private String approved;
	private String tempName;
	private int maxNOA = 50;
	private String newStatus;
	private int tempRating;

	public Account( String ownerName, AppStore appStore) {
		this.appStore = appStore;
		this.ownerName = ownerName;
		this.downloadedApps = new App[maxNOA];
		this.NumberOfDownloadedApps = 0;
		this.status = "";
		this.approved = "true";
		this.newStatus ="";
		this.tempRating =0;
	}


	public App[] getObjectsOfDownloadedApps() {
		App[] a = new App[this.NumberOfDownloadedApps];
		for(int i = 0; i < this.NumberOfDownloadedApps; i++) {
			a[i] = this.downloadedApps[i];
		}
		return a;
	}

	public String[] getNamesOfDownloadedApps() {

		App[] a = new App[this.NumberOfDownloadedApps];
		String[] s = new String[this.NumberOfDownloadedApps];
		for(int i = 0; i < this.NumberOfDownloadedApps; i++) {
			s[i] = getObjectsOfDownloadedApps()[i].getName();
			//			a[i] = this.downloadedApps[i];
			//s[i] = this.downloadedApps[i].getName();
		}
		return s;
	}

	public int getNumberOfDownloadedApps() {
		return NumberOfDownloadedApps;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public App[] getDownloadedApps() {
		return downloadedApps;
	}

	public void setDownloadedApps(App[] downloadedApps) {
		this.downloadedApps = downloadedApps;
	}


	public void switchStore(AppStore appStore) {
		this.appStore = appStore;


		this.status = "switch";
		this.approved  = "true";

	}


	public String getNewStatus() {
		return newStatus;
	}

	public void setNewStatus(String newStatus) {
		this.newStatus = newStatus;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getApproved() {
		return approved;
	}

	public void setApproved(String approved) {
		this.approved = approved;
	}

	public void uninstall(String name) {
		int index = -1; //

		for(int i = 0; i < this.NumberOfDownloadedApps; i++) {
			//	App a = this.downloadedApps[i];
			String s = this.downloadedApps[i].getName();
			if(s.equals(name)) {
				this.tempName = name; 
				NumberOfDownloadedApps--;
				this.status = "uninstall";
				this.approved  = "true";
				index = i;
				this.downloadedApps[i] = null;				
			}
		}


		if(index == -1) {
			this.status ="uninstall";
			setApproved("false");
			this.tempName = name; 
		}
	}



	public void download(String name) {
		int index = -1; //
		App a = appStore.getApp(name);

		for(int i = 0; i < this.appStore.getNoa(); i++) {
			//	App a = this.appStore.getApp()[i];
			String s = this.appStore.getApp()[i].getName();
			if(downloadedApps[i] == appStore.getApp(name)) { 
				this.status= "download";
				this.approved  = "false";
				this.newStatus = "failDownload";
				this.tempName = name;
			}
		}

		if(this.NumberOfDownloadedApps < 3) {
			this.downloadedApps[this.NumberOfDownloadedApps]  = a;
			this.status = "download";
			this.approved = "true";
			this.tempName = name; 
			this.NumberOfDownloadedApps++;
		}
		else {
			this.approved = "false";
		}
		status = "download";
		this.tempName = name;
	}



	public void submitRating(String name, int rating) {
		int index = -1;
		for(int i = 0; i < this.NumberOfDownloadedApps; i++) {
			App a = this.downloadedApps[i];
			if(a.getName().equals(name)) {
				index = i;				
				this.downloadedApps[index].submitRating(rating);
				this.status= "submitRating";
				this.approved  = "true";
				this.tempName = name;
				this.tempRating  = rating;
			}

		}
		if(index == -1) {
			this.status = "submitRating";
			this.approved = "false";
			this.tempName = name; 
		}
	}

	public String toString() {
		String s = "";
		if(this.status.equals("uninstall")) {

			if (this.approved.equals("false")) {
				s = "Error: " + this.tempName +" has not been downloaded for " + this.ownerName + ".";    
				return s;
			}

			else if (getApproved().equals("true")) {
				s = this.tempName + " is successfully uninstalled for " + this.ownerName +  "."; 
			}
		}
		else if (getStatus().equals("download") && getNewStatus() != "failDownload") {
			if (getApproved().equals("false")) {
				s = "Error: " + this.tempName + " is not a downloaded app for " + this.ownerName + ".";    
			}
			else if (getApproved().equals("true")) {
				s = this.tempName + " is successfully downloaded for " + this.ownerName + "."; 
			}
		}
		else if (getStatus().equals("download") && getNewStatus() == "failDownload") {
			s = "Error: " + this.tempName + " has already been downloaded for " + this.ownerName + ".";    
		}
		
		else if(this.status.equals("submitRating")) {
			if (getApproved().equals("false")) {
				s = "Error: " + this.tempName + " is not a downloaded app for " + this.ownerName + ".";                                  
			}
			else if (getApproved().equals("true")) {
				s = "Rating score " + this.tempRating + " of " + this.ownerName + " is successfully submitted for " + this.tempName + "."; 
			}
		}
		
		else if(this.status.equals("switch")) {
			s = "Account for " +  this.ownerName + " is now linked to the " + this.appStore.getBranch() +" store."; 
		}

		else if (this.status.equals("")){
			s = "An account linked to the " + this.appStore.getBranch() + " store is created for " + this.ownerName + "."; 
			return s;
		}

		return s;
	}
}
