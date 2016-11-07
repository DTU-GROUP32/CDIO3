package spil;

import spil.language.LanguageHandler;

import java.util.Scanner;

public class GameBoard {
	private Scanner input = new Scanner(System.in);
	private LanguageHandler language;
	private DiceCup diceCup;
	private Player[] players = new Player[2];
	private Player winner = null;
	private Field[] fields = new Field[11];

	public GameBoard(){}

	/**
	 * Default constructor
	 */
	public void createGame(){
		diceCup  = new DiceCup();
		this.chooseLanguage();
		this.createPlayers();
		this.initFields();
	}

	/**
	 * Entry method for starting the program
	 * @param args unused
	 */
	public static void main(String[] args){
		GameBoard spil = new GameBoard();
		spil.createGame();
		spil.playGame();
	}

	/**1
	 * Method to start playing the game
	 */
	public void playGame(){
		System.out.println(language.readyToBegin());
		while (winner == null) {
			for (int i=0; i<this.players.length; i++){
				if(winner == null)
					this.playTurn(players[i]);
			}
		}
		input.close();
	}

	/**
	 * Method to change & set language for the gameboard
	 */
	public void chooseLanguage(){
		String choice = this.getInput("Type 1 for English \nTryk 2 for dansk");
		switch (choice){
		case "1":
			language = new LanguageHandler("English");
			break;
		case "2":
			language = new LanguageHandler("Dansk");
			break;
		default:
			language = new LanguageHandler("Dansk");
			break;
		}
		System.out.println(language.notifyLangChange());
	}

	/**
	 * Method to ask for each players name and generate a player object from it.
	 */
	public void createPlayers(){
		for(int i = 0; i < players.length; i++){
			String name = this.getInput(this.language.askForPlayerName(i+1));
			players[i] = new Player(name);
		}
		System.out.println(language.printRules());
	}

	/**
	 * Method to create fields in gameboard.
	 */
	public void initFields(){
		fields[0] = new Field(250);
		fields[1] = new Field(-100);
		fields[2] = new Field(100);
		fields[3] = new Field(-20);
		fields[4] = new Field(180);
		fields[5] = new Field(0);
		fields[6] = new Field(-70);
		fields[7] = new Field(60);
		fields[8] = new Field(-80, true);
		fields[9] = new Field(-50);
		fields[10] = new Field(650);
	}


	/**
	 * Method that receives a player object and posts a message with instructions for the player.
	 * After the player has pressed "enter" the method will roll the dices, print the result of the roll,
	 * enforce the landOnField method for the given field and do a win condition check. The method keeps
	 * running that sequence until the player has no more extra turns or has won the game. If the players
	 * turn ends and he hasn't won, the method will print a message with the players current score,
	 * if the player has won, the method will post a message saying that.
	 * @param Player player
	 */
	public void playTurn(Player player){
		boolean extraTurn = true;
		while (extraTurn && winner == null) {
			String response = getInput(language.preMsg(player));
			if (response.equals("help")) {
				this.gameMenu();
				continue;
			}
			extraTurn = false;
			if (winner == null) {
				diceCup.rollDices();
				System.out.println(language.rollResult(diceCup));
				System.out.println(language.fieldMsg(diceCup));

				extraTurn = fields[diceCup.getSum()-2].landOnField(player);

				if (player.getBank().getBalance() >= 3000)
					winner = player;
			}
		}
		if (winner == null){
			System.out.println(language.postMsg(player));
		} else System.out.println(language.winnerMsg(winner));
	}

	/**
	 * Gamemenu shown before the start of each turn. Lets player end game, continue or switch language
	 * @return
	 */
	public void gameMenu() {
		String choice = this.getInput(language.menu());
		switch (choice) {
		// Change dice sides
		case "1":
			String subchoice = this.getInput(language.changeDices());
			if(subchoice.length() > 2) {
				if(diceCup.setDiceSides(Character.getNumericValue(subchoice.charAt(0)), Character.getNumericValue(subchoice.charAt(2))))
					System.out.println(language.printDiceChangeSucces());
				break;
			}
			else System.out.println(language.printDiceChangeNotExecuted());
			break;
			// Change Language
		case "2":
			this.chooseLanguage();
			break;
			// Show Score
		case "3":
			System.out.println(language.printScore(this.players));
			break;
			// End Game
		case "4":
			System.exit(1);
			// Continue game
		case "5":
			break;
			// Default
		default: break;
		}
	}

	/**
	 * Method created to take a user-input from the scanner and print a message beforehand
	 * @param message String
	 * @return userInput String
	 */
	public String getInput(String message){
		System.out.println(message);
		return input.nextLine();
	}
}
