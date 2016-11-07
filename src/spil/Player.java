package spil;

public class Player{
	private String playerName;
	private Bank bankAccount;
	private int ID;
	private static int nextID = 0;

	/**
	 * Default constructor
	 */
	public Player(){
		this("No Name");
	}

	/**
	 * String Constructor
	 * @param name
	 */
	public Player(String name) {
		playerName = name;
		this.ID = nextID++;
		bankAccount = new Bank(1000);
	}
	/**
	 * Sets player names on player object
	 * @param name String
	 */
	public void setName(String name){
		this.playerName = name;
	}

	/**
	 * Return player's bank account from Bank object
	 * @return this.bankAccount Bank
	 */
	public Bank getBank(){
		return this.bankAccount;
	}

	/**
	 * Return player's name from Player object
	 * @return
	 */
	public String getName(){
		return this.playerName;
	}

	/**
	 * Return player's ID
	 * @return this.ID integer
	 */
	public int getID(){
		return this.ID;
	}
}