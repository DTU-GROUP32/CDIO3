package language;

import entity.Player;

public interface Language {

	public String notifyLangChange();

	public String fieldNames(int fieldNumber);

	public String fieldPrices(int fieldNumber);

	public String fieldDescription(int fieldNumber);

	public String welcomeMsg();

	public String askForNumberOfPlayers();

	public String askForPlayerName(int playerNumber);

	public String readyToBegin();

	public String preMsg(Player player);

	public String fieldMsg(int fieldNumber);

	public String buyingOfferMsg(int price);

	public String yes();

	public String no();

	public String purchaseConfirmation();

	public String notEnoughMoney();

	public String landedOnOwnedField(Player owner);

	public String youPaidThisMuchToThisPerson(int amountPayed, Player owner);

	public String youOwnThisField();

	public String getTaxChoice();

	public String nonOwnableFieldEffectMsg(int onField);

	public String youAreBroke();

	public String winnerMsg(Player player);

	public String menu();

	public String printRules();

	public String printScore(Player[] players);

	public String changeDices();

	public String printDiceChangeSucces();

	public String printDiceChangeNotExecuted();
}