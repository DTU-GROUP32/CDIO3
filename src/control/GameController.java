package control;

import boundary.GUIBoundary;
import entity.DiceCup;
import entity.GameBoard;
import entity.Player;
import entity.PlayerList;
import language.LanguageHandler;

public class GameController {
	
	private GUIBoundary boundary;
	private SetupController setupController;
	private GameBoard gameBoard;
	private LanguageHandler language;
	private PlayerList playerList;
	private DiceCup diceCup;

	public GameController() {
		setupController = new SetupController();
		gameBoard = setupController.setupGameBoard();
		language = setupController.chooseLanguage();
		playerList = setupController.setupPlayers();
		boundary = setupController.getBoundary();
		diceCup = new DiceCup();
	}

	/**
	 * Entry method for starting the program
	 * @param args unused
	 */
	public static void main(String[] args){
		GameController spil = new GameController();
		spil.runGame();
	}

	/**1
	 * Method to start playing the game
	 */
	public void runGame() {
		if(boundary.getButtonPressed(language.readyToBegin()));
		while(true) {
			for(int i = 0; i < playerList.getPlayers().length; i++)
				if(playerList.isThereAWinner() == false && playerList.isPlayerBroke(i) == false)
					playTurn(playerList.getPlayer(i));
		if(playerList.isThereAWinner())
			break;
		}
		if(boundary.getButtonPressed(language.winnerMsg(playerList.whoIsTheWinner())));
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
	public void playTurn(Player player) {
		if(boundary.getButtonPressed(language.preMsg(player)));
		diceCup.rollDices();
		boundary.setDices(diceCup);
		boundary.removeCar(player.getOnField()+1, player.getName());
		player.movePlayer(diceCup.getSum());
		boundary.moveCar(player.getOnField()+1, player.getName());
//		if(boundary.getButtonPressed(language.fieldMsg(player)));
//		if(gameBoard.getField(player.getOnField()).isOwnable() == true)
//			if(gameBoard.getField(player.getOnField()).getOwner != null)
				
		
	}

	/**
	 * Gamemenu shown before the start of each turn. Lets player end game, continue or switch language
	 * @return
	 */
//	public void gameMenu() {
//		String choice = this.getInput(language.menu());
//		switch (choice) {
//		// Change dice sides
//		case "1":
//			String subchoice = this.getInput(language.changeDices());
//			if(subchoice.length() > 2) {
//				if(diceCup.setDiceSides(Character.getNumericValue(subchoice.charAt(0)), Character.getNumericValue(subchoice.charAt(2))))
//					System.out.println(language.printDiceChangeSucces());
//				break;
//			}
//			else System.out.println(language.printDiceChangeNotExecuted());
//			break;
//			// Change Language
//		case "2":
//			this.chooseLanguage();
//			break;
//			// Show Score
//		case "3":
//			System.out.println(language.printScore(this.players));
//			break;
//			// End Game
//		case "4":
//			System.exit(1);
//			// Continue game
//		case "5":
//			break;
//			// Default
//		default: break;
//		}
//	}
}
