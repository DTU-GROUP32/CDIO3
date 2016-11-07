package spil;

public class Bank {

	private int balance;

	/**
	 * Default constructor
	 */
	public Bank(){
		this(1000);
	}

	/**
	 * Constructor for bank-class which takes integer to set balance
	 * @param balance
	 */
	public Bank(int balance){
		if (balance < 0)
			this.balance = 0;
		else
			this.balance = balance;
	}

	/**
	 * Method to change balance +/- on a bankaccount
	 * @param amount int
	 */
	public void changeBalance(int amount){

		if ((this.balance + amount)<0){
			this.balance = 0;
		}
		else{
			this.balance += amount;
		}
	}

	/**
	 * Return balance from Balance object
	 * @return int balance
	 */
	public int getBalance()
	{
		return this.balance;
	}
}
