package language;

import entity.GameBoard;
import entity.Player;

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
	 * Notifies of language change
	 * @return String
	 */
	public String notifyLangChange(){
		return selectedLanguage.notifyLangChange();
	}

	public String fieldNames(int fieldNumber) {
		return selectedLanguage.fieldNames(fieldNumber);
	}
	
	public String fieldPrices(int fieldNumber, GameBoard gameBoard) {
		return selectedLanguage.fieldPrices(fieldNumber, gameBoard);
	}
	
	public String fieldDescription(int fieldNumber) {
		return selectedLanguage.fieldDescription(fieldNumber);
	}

	public String askForNumberOfPlayers() {
		return selectedLanguage.askForNumberOfPlayers();
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
	 * Switch case that displays the field message that was landed on.
	 * @return String
	 */
	public String fieldMsg(int fieldNumber){
		return selectedLanguage.fieldMsg(fieldNumber);
	}
	
	public String buyingOfferMsg(int price){
		return selectedLanguage.buyingOfferMsg(price);
	}

	public String yes() {
		return selectedLanguage.yes();
	}

	public String no() {
		return selectedLanguage.no();
	}
	
	public String purchaseConfirmation() {
		return selectedLanguage.purchaseConfirmation();
	}

	public String notEnoughMoney() {
		return selectedLanguage.notEnoughMoney();
	}

	public String landedOnOwnedField(Player owner) {
		return selectedLanguage.landedOnOwnedField(owner);
	}
	
	public String youPaidThisMuchToThisPerson(int amountPayed, Player owner) {
		return selectedLanguage.youPaidThisMuchToThisPerson(amountPayed, owner);
	}

	public String getTaxChoice() {
		return selectedLanguage.getTaxChoice();
	}

	public String nonOwnableFieldEffectMsg(int onField) {
		return selectedLanguage.nonOwnableFieldEffectMsg(onField);
	}

	public String youAreBroke() {
		return selectedLanguage.youAreBroke();
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
}
