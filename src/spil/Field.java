package spil;

public class Field {
	
	/**
	 * Tells which effect landing on the field has on a players balance.
	 */
	private int effect;
	
	/**
	 * Tells if landing on the field gives an extra turn, before the next player can roll.
	 */
	private boolean extraTurn;

	/**
	 * Default field constructor
	 */
	public Field(){
		this(0);
	}
	
	/**
	 * Constructor for the Field class that only lets you assign the effect and has
	 * the extraTurn set to false by default.
	 * @param int effect
	 */
	public Field(int effect) {
		this(effect, false);
	}
	
	/**
	 * Constructor for the Field class that lets you assign both effect and extraTurn.
	 * @param int effect
	 * @param boolean extraTurn
	 */
	public Field(int effect, boolean extraTurn) {
		this.effect = effect;
		this.extraTurn = extraTurn;
	}
	
	/**
	 * Method that takes in a Player object, enforces the effect of the field on the players balance,
	 * and returns whether or not the field grants and extra turn.
	 * @param Player player
	 * @return boolean extraTurn
	 */
	public boolean landOnField(Player player) {
		player.getBank().changeBalance(this.effect);
		return extraTurn;
	}
}
