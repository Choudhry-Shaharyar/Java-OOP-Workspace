package model;

public class Account {

	private String name;
	private int balance;
	private String type;
	private int deposit;
	public Account(String name, int balance) {
		this.balance = balance;
		this.name = name;
		this.type = "regular";
	}
	public Account(Account a1) {
		this.balance = a1.getBalance();
		this.name = a1.getName();
		this.type = a1.getType();
		
		if(this.type.equals("VIP")) {
			this.deposit = a1.getDeposit();
		}
	}
	public void switchToVIP(int deposit) throws InvalidStatusToSwitchException, InsufficientBalanceException{
		if(this.getType().equals("VIP")) {
			throw new InvalidStatusToSwitchException("");
		}
		if(deposit > this.getBalance()) {
			throw new InsufficientBalanceException("");
		}



		this.setType("VIP");
		this.setDeposit(deposit);
		this.decreaseBalance(deposit);


	}
	
//	 Two accounts are considered equal if their owner names, balance, 
//	 * and types (regular or VIP) are equal. 
//	 * 
//	 * Note. For two VIP accounts, if their owners and balances are equal,
//	 * 			the VIP fees they got charged need not be considered. 

	public boolean equals(Object obj) {
		boolean result;
		if(this == obj) {
			return true;
		}
		if(obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		Account other = (Account)obj;
		result = (this.balance == other.balance && this.name.equals(other.name) && this.type.equals(other.type));
	
		if(result == true && this.type.equals("VIP")) {
			this.refund(this.getDeposit());
			other.refund(other.getDeposit());
		}
		
		return result;
	}

	private void decreaseBalance(int deposit2) {
		this.balance = this.getBalance() - deposit2;

	}
	public void refund(int amount) {
		this.setDeposit(0);
		this.setBalance(this.getBalance()+amount);
	}


	public int getDeposit() {
		return deposit;
	}
	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String toString(){
		if(this.type == "regular") {
			return String.format("A regular account owned by %s with balance $%s", this.getName(), this.getBalance());
		}
		else {
			return String.format("A VIP account owned by %s with balance $%s ($%s deposited for maintaining the VIP stauts)", this.getName(), this.getBalance(), this.getDeposit());
		}

	}
	public void switchToRegular() throws InvalidStatusToSwitchException{

		if(this.type.equals("regular"))  {
			throw new InvalidStatusToSwitchException("");
		}

		this.setType("regular");
		this.refund(this.getDeposit());
	}
}
