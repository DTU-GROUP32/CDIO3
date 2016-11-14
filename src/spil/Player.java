package spil;

public class Player{
	private String playerName;
	private Bank bankAccount;
	private int ID;
	private static int nextID = 0;
	private int laborCampsOwned;
	private int fleetsOwned;

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
	
	public int getLaborCampsOwned() {
		return laborCampsOwned;
	}
	
	public void setLaborCampsOwned(int laborCampsOwned) {
		this.laborCampsOwned = laborCampsOwned;
	}
	
	public int getFleetsOwned() {
		return fleetsOwned;
	}
	
	public void setFleetsOwned(int fleetsOwned) {
		this.fleetsOwned = fleetsOwned;
	}
	
}