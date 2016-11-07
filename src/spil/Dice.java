package spil;

public class Dice {
	
	private int sides = 6; // Number of sides of the dice
	private int faceValue; // Current face value of the dice
	
	/**
	 * Default constructor, where dice has 6 sides
	 */
	public Dice() {
		this(6);
	}
	
	/**
	 * Secondary constructor, changes the number of sides on of the dice
	 * @param sides
	 */
	public Dice(int sides) {
		this.sides = sides;
	}
	
	/**
	 * Gets the number of sides of the dice
	 * @return sides
	 */
	public int getSides() {
		return this.sides;
	}
	
	/**
	 * Sets the number of sides of the dice
	 * @param sides
	 * @return sides
	 */
	public int setSides(int sides) {
		this.sides = sides;
		return sides;
	}
	
	/**
	 * Gets face value of the dice
	 * @return faceValue
	 */
	public int getFaceValue() {
		return this.faceValue;
	}
	
	/**
	 * Sets face value to random generated number inbetween 1 and the int 'sides'
	 */
	public void roll() {
		this.faceValue = (int) ((Math.random()*sides)+1);
	}
}
