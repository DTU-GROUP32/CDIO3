package spil.language;

import spil.DiceCup;
import spil.Player;

public class LanguageHandler {

	private Language selectedLanguage;

	public LanguageHandler(String language) {
		setLanguage(language);
	}

	public void setLanguage(String language) {
		switch(language) {
		case "Dansk": selectedLanguage = new Dansk(); break;
		case "English": selectedLanguage = new English(); break;
		default: selectedLanguage = new English();
		}
	}

	/** 
	 * Welcome message for user with commands available.
	 * @return
	 */
	
	public String welcomeMsg(){
		return selectedLanguage.welcomeMsg();
	}

	/** 
	 * Asks for player name.
	 * @return String
	 */
	public String askForPlayerName(int playerNumber){
		return selectedLanguage.askForPlayerName(playerNumber);
	}


	/** 
	 * Tells user that the game will start shortly. 
	 * @return String
	 */
	public String readyToBegin(){
		return selectedLanguage.readyToBegin();
	}

	/**
	 * Premessage at the start of players turn, tells player help option. 
	 * @return String
	 */
	public String preMsg(Player player){
		return selectedLanguage.preMsg(player);
	}

	/**
	 * Displays the result of the dice roll. 
	 * @return String
	 */
	public String rollResult(DiceCup diceCup){
		return selectedLanguage.rollResult(diceCup);
	}

	/**
	 * Switch case that displays the field message that was landed on.
	 * @return String
	 */
	public String fieldMsg(DiceCup diceCup){
		return selectedLanguage.fieldMsg(diceCup);
	}
	/**
	 * Prints how many points the player have after the throw.
	 * @return String
	 */
	public String postMsg(Player player){
		return selectedLanguage.postMsg(player);
	}

	/**
	 * Prints who won with how many points.
	 * @return String
	 */
	public String winnerMsg(Player player){
		return selectedLanguage.winnerMsg(player);
	}

	/**
	 * Prints the available commands in the menu.
	 * @return String
	 */
	public String menu(){
		return selectedLanguage.menu();
	}
	/**
	 * Prints the rules of the game.
	 * @return String
	 */
	public String printRules(){
		return selectedLanguage.printRules();
	}
	/**
	 * Prints the score. 
	 * @return String
	 */
	public String printScore(Player[] players){
		return selectedLanguage.printScore(players);
	}

	/** 
	 * Prints how to change the dices.
	 * @return String
	 */
	public String changeDices(){
		return selectedLanguage.changeDices();
	}
	/**
	 * Prints that the dices were changed successfully.			
	 * @return String
	 */
	public String printDiceChangeSucces(){
		return selectedLanguage.printDiceChangeSucces();
	}
	/**
	 * Prints a error message if the dices couldn't be changed.
	 * @return String
	 */
	public String printDiceChangeNotExecuted(){
		return selectedLanguage.printDiceChangeNotExecuted();
	}

	/**
	 * Notifies of language change
	 * @return String
	 */
	public String notifyLangChange(){
		return selectedLanguage.notifyLangChange();
	}
}
