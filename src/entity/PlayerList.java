package entity;

public class PlayerList {

	private Player[] players;

	/**
	 * Creates an empty array of player objects.
	 * @param Number of players.
	 */
	public PlayerList(int numberOfPlayers) {
		this.players = new Player[numberOfPlayers];
		for (int i = 0; i < numberOfPlayers; i++)
			players[i] = new Player();
	}

	/**
	 * Instantiates a player object in the array at the index specified.
	 * @param Index of the player to be instantiated.
	 * @param Name of the player to be instantiated.
	 */
	public void addPlayer(int index, String playerName) {
		this.players[index].setName(playerName);
	}

	public boolean isPlayerBroke(int atIndex) {
		if (players[atIndex].getBankAccount().getBalance() <= 0)
			return true;
		else return false;
	}

	public boolean isThereAWinner() {
		int brokePlayers = 0;
		for (int i = 0; i < players.length; i++)
			if (players[i].getBankAccount().getBalance() <= 0)
				brokePlayers++;
		if (brokePlayers == players.length - 1)
			return true;
		else return false;
	}

	public Player whoIsTheWinner() {
		Player winner = new Player();
		for (int i = 0; i < players.length; i++)
			if (players[i].getBankAccount().getBalance() > 0)
				winner = players[i];
		return winner;
	}

	public Player[] getPlayers() {
		return players;
	}

	public Player getPlayer(int atIndex) {
		return players[atIndex];
	}
}
