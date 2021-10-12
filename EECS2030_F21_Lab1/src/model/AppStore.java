package model;

public class AppStore {

	private String branch;
	private int maxNOA = 50;
	private int noa;
	private App[] app;
	private int NumberOfStores;

	public AppStore(String branch, int maxNOA) {
		this.branch = branch;
		this.maxNOA = maxNOA;
		this.app = new App[maxNOA];
		this.NumberOfStores = 0;

	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
		this.NumberOfStores++;
	}

	public App[] getApp() {
		return app;
	}
	public int getNoa() {
		return this.noa;
	}

	public App getApp(String appName) {
		int index = -1; // 
		for(int i = 0; i < this.noa; i++) {
			App a = this.app[i];
			if(a.getName().equals(appName)) {
				index = i;
			}
		}
		if(index < 0) {
			return null;
		}
		else {
			return this.app[index];
		}
	}



	public void addApp(App app) {
		this.app[this.noa] = app;
		this.noa++;
	}

	public String[] getStableApps(int NumberOfUpdates) {
		int count = 0; 
		int[] indices = new int[this.noa]; 


		for(int i = 0; i < this.noa; i++) {
			App a = this.app[i];
			if(a.getNol() >= NumberOfUpdates) {
				indices[count] = i;
				count++;
			}
		}

		String[] stableApps = new String[count];

		for(int i = 0; i < count; i++) {
			stableApps[i] = this.app[indices[i]].getName() +" (" + this.app[indices[i]].getNol() + " versions; Current Version: " + this.app[indices[i]].getWhatIsNew() + ")";
		}
		return stableApps;
	}

}
