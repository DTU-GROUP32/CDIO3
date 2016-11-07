package spil.language;

import spil.DiceCup;
import spil.Player;

public interface Language {

	/** 
	 * Welcome message for user with commands available.
	 * @return
	 */
		
	public String welcomeMsg();

	/** 
	 * Asks for player name.
	 * @return
	 */
	public String askForPlayerName(int playerNumber);


	/** 
	 * Tells user that the game will start shortly. 
	 * @return
	 */
	public String readyToBegin();

	/**
	 * Premessage at the start of players turn, tells player help option. 
	 * @return
	 */
	public String preMsg(Player player);

	/**
	 * Displays the result of the dice roll. 
	 * @return
	 */
	public String rollResult(DiceCup diceCup);

	/**
	 * Switch case that displays the field message that was landed on.
	 * @return
	 */
	public String fieldMsg(DiceCup diceCup);
	/**
	 * Prints how many points the player have after the throw.
	 * @return
	 */
	public String postMsg(Player player);

	/**
	 * Prints who won with how many points.
	 * @return
	 */
	public String winnerMsg(Player player);

	/**
	 * Prints the available commands in the menu.
	 * @return
	 */
	public String menu();
	/**
	 * Prints the rules of the game.
	 * @return
	 */
	public String printRules();
	/**
	 * Prints the score. 
	 * @return
	 */
	public String printScore(Player[] players);

	/** 
	 * Prints how to change the dices.
	 * @return
	 */
	public String changeDices();
	/**
	 * Prints that the dices were changed successfully.		
	 * @return
	 */
	public String printDiceChangeSucces();
	/**
	 * Prints a error message if the dices couldn't be changed.
	 * @return
	 */
	public String printDiceChangeNotExecuted();
	/**
	 * Notifies of language change
	 * @return String
	 */
	public String notifyLangChange();
}