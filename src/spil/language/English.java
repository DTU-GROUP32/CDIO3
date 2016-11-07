package spil.language;

import spil.DiceCup;
import spil.Player;

public class English implements Language{

	public English(){}

	/**
	 * Welcome message for user with commands available.
	 * @return
	 */
	@Override
	public String welcomeMsg(){
		return "Welcome to the game!";
	}

	/**
	 * Asks for playername
	 * @return
	 */
	@Override
	public String askForPlayerName(int playerNumber){
		return "Type player " + playerNumber + "'s name";
	}

	/**
	 * Tells user that the game will start shortly.
	 * @return
	 */
	@Override
	public String readyToBegin(){
		return "\nThe game is starting. The player who reaches 3000 coins first is the winner.\nYou can type 'help' at any time"
				+ " to open a help menu. "; // Skal bruger trykke på noget for at starte?
	}

	/**
	 * Premessage at the start of players turn, tells player help option.
	 * @return
	 */
	public String preMsg(Player player){
		return "\nIt's " + player.getName() + "s turn, press 'enter' to roll the dices!"; // getbank.getbalance
	}

	/**
	 * Displays the result of the dice roll.
	 * @return
	 */
	@Override
	public String rollResult(DiceCup diceCup){
		return "You rolled a " + diceCup.getDices()[0].getFaceValue() + " and a " + diceCup.getDices()[1].getFaceValue();
	}

	/**
	 * Switch case that displays the field message that was landed on.
	 * @return
	 */
	@Override
	public String fieldMsg(DiceCup diceCup){
		String fieldString;
		switch (diceCup.getSum()) {
		case 2:  fieldString = "You've climbed to the top of the tower and found 250 coins!";
		break;
		case 3:  fieldString = "You've fallen into the crater, it'll cost you 100 coins to get back up.";
		break;
		case 4:  fieldString = "You've arrived at the palace gates, the guards greets you with 100 coins when you pass.";
		break;
		case 5:  fieldString = "You've gotten lost in the cold dessert, you find a guy who sells you warm clothes costs you 20 coins.";
		break;
		case 6:  fieldString = "You've arrived at the walled city. A man needs your help, after you've helped him he gave you 180 coins!";
		break;
		case 7:  fieldString = "You've seen a monastery, you didn't find anything there.";
		break;
		case 8:  fieldString = "You've walked into a black cave and taken captive, it costs you 70 coins to walk free.";
		break;
		case 9:  fieldString = "You've found some huts in the mountains, the people that live there likes you and give you 60 coins!";
		break;
		case 10: fieldString = "You've arrived at the werewall. The werewolf doesn't want to let you go, you give them 80 coins, as thanks they let you walk free and roll the dice again.";
		break;
		case 11: fieldString = "You've fallen into the pit, a friendly man helps you back up. You give him 50 coins as thanks.";
		break;
		case 12: fieldString = "You've arrived at the goldmine. You find gold in there, you sell it for 650 coins!";
		break;
		default: fieldString = "Unknown field.";
		break;
		}
		return fieldString;
	}

	/**
	 * Prints how many points the player have after the throw.
	 * @return
	 */
	@Override
	public String postMsg(Player player){
		return "After this round " + player.getName() + " has got " + player.getBank().getBalance() + " coins";
	}

	/**
	 * Prints who won with how many points.
	 * @return
	 */
	@Override
	public String winnerMsg(Player player){
		return player.getName() + " has won the game with " + player.getBank().getBalance() + "coins!";
	}
	/**
	 * Prints the available commands in the menu.
	 * @return
	 */
	@Override
	public String menu(){
		return "Type 1 to change sides on dice.\n" +
				"Type 2 to change language.\n" +
				"Type 3 to show the score.\n"+
				"Type 4 to end the game.\n" +
				"Type 5 to continue the game.";
	}

	/**
	 * Prints the rules of the game.
	 * @return
	 */
	@Override
	public String printRules(){
		return "This is a dice game with 2 players. You roll the dices and land on a field inbetween 2 and 12. \nAll fields have a different effect on your score, either positive or negative. Here's a list of all the fields: \n"
				+ "2. Tower: +250 coins \n"
				+ "3. Crater: -100 coins \n"
				+ "4. Palace gates: +100 coins \n"
				+ "5. Cold Desert: -20 coins \n"
				+ "6. Walled city: +180 coins \n"
				+ "7. Monastery: 0 coins \n"
				+ "8. Black cave: -70 coins \n"
				+ "9. Huts in the mountain: +60 coins \n"
				+ "10. The Werewall (werewolf-wall): -80 coins, The player get an extra throw aswell \n"
				+ "11. The pit: -50 coins \n"
				+ "12. Goldmine: +650 coins";
	}

	/**
	 * Prints the score. 
	 * @return
	 */
	@Override
	public String printScore(Player[] players){
		StringBuilder str = new StringBuilder();
		str.append("The score is:");
		for (int i = 0; i < players.length; i++)
			str.append("\n" + players[i].getName() + " has " + players[i].getBank().getBalance() + " coins.");
		return str.toString();
	}

	/** 
	 * Prints how to change the dices.
	 * @return
	 */
	@Override
	public String changeDices(){
		return "Type how many sides the two dices should have, on the format \"x,y\" - the sum has to be 12"; // Summen måtte kun gå op til 12?
	}

	/**
	 * Prints that the dices were changed successfully.
	 * @return
	 */
	@Override
	public String printDiceChangeSucces(){
		return "The dices have been changed.";
	}

	/**
	 * Prints a error message if the dices couldn't be changed.
	 * @return
	 */
	@Override
	public String printDiceChangeNotExecuted(){
		return "The dices couldn't be changed.";
	}

	/**
	 * Notifies of language change
	 * @return String
	 */
	@Override
	public String notifyLangChange(){
		return "The language is now English!";
	}
}
