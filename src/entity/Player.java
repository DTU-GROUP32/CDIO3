package entity;

public class Player{
	
	private String playerName;
	private BankAccount bankAccount;
	private int onField;
	private int ID;
	private static int nextID = 0;
	private int lastRoll;
	private boolean taxChoice;

	/**
	 * Default constructor.
	 */
	public Player(){
		this("John Doe");
	}

	/**
	 * Constructor that can give the player a name.
	 * @param the players name.
	 */
	public Player(String name){
		this(name,30000);
	}
	
	/**
	 * Constructor that can give the player a name and a starting balance.
	 * @param the players name.
	 * @param the players starting balance.
	 */
	public Player(String name, int startingBalance) {
		playerName = name;
		bankAccount = new BankAccount(startingBalance);
		this.onField = 0;
		this.ID = nextID++;
	}
	
	public String getName(){
		return this.playerName;
	}
	
	public void setName(String name){
		this.playerName = name;
	}

	public BankAccount getBankAccount(){
		return this.bankAccount;
	}

	public int getOnField(){
		return this.onField;
	}
	
	/**
	 * Adds the number that was rolled to the field the player was on and moves him to a new field.
	 * @param Integer that was rolled.
	 */
	public void movePlayer(int roll){
		this.onField += roll;
		while(this.onField > 21)
			this.onField -= 22;
	}
	
	public int getID(){
		return this.ID;
	}

	public int getLastRoll() {
		return lastRoll;
	}

	public void setLastRoll(int lastRoll) {
		this.lastRoll = lastRoll;
	}

	public boolean isTaxChoice() {
		return taxChoice;
	}

	public void setTaxChoice(boolean taxChoice) {
		this.taxChoice = taxChoice;
	}
}