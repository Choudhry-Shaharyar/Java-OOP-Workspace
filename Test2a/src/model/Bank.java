package model;


public class Bank {
	private Account[] accounts;
	private Account[] accountsCopy;
	private int noa;

	public Bank() {
		this.accounts = new Account[5]; //change to 5 if needed
		this.noa = 0;
		this.accountsCopy = new Account[5]; //change to 5 if needed
	}

	public Bank(Bank b1) {
		this.accounts = b1.getReferencesOfAccounts();
		this.noa = b1.getNumberOfAccounts();
		this.accountsCopy = b1.getCopiesOfAccounts();
	}

	/*
	 * Two banks are equal if they store the same number of accounts, 
	 * 	and accounts at the corresponding positions are equal.
	 */
	public boolean equals(Object obj) {
		int count = 0;
		boolean result;
		if(this == obj) {
			return true;
		}
		if(obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		Bank other = (Bank)obj;
		if(this.noa == other.noa) {
			for(int i = 0; i  < this.noa; i ++) {
				if(this.accounts[i].equals(other.accounts[i])) {
					count = count + 1;
				}
			}
		}
		else {
			return false;
		}

		return count == this.noa;

	}


	public int getNumberOfAccounts() {

		return this.noa;
	}

	public Account[] getReferencesOfAccounts() {
		Account[] accountCopy = new Account[noa];

		if(accounts != null) {


			for(int i = 0; i < noa; i ++) {
				accountCopy[i] = accounts[i];
			}
		}
		return accountCopy;
	}

	public Account[] getCopiesOfAccounts() {
		Account[] accountCopy = new Account[noa];

		if(accounts != null) {


			for(int i = 0; i < noa; i ++) {
				accountCopy[i] = new Account(accounts[i]);
			}

		}
		return accountCopy;

	}

	public void addAccount(Account a1) {
		accounts[this.noa] =  a1;
		noa++;
	}

	public void addAccounts(Account[] accounts2) {
		for(int i =0; i  < accounts2.length; i++) {
			this.accounts[this.noa] = accounts2[i];
			this.noa++;
		}

	}
}
