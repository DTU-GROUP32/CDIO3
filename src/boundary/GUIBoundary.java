package boundary;

import java.awt.Color;

import desktop_fields.Brewery;
import desktop_fields.Field;
import desktop_fields.Refuge;
import desktop_fields.Shipping;
import desktop_fields.Street;
import desktop_fields.Tax;
import desktop_resources.GUI;
import entity.DiceCup;
import entity.GameBoard;
import language.LanguageHandler;

public class GUIBoundary {
	
	public void createGameBoard(GameBoard gameBoard, LanguageHandler language) {
		Field[] fields = new Field[gameBoard.getFields().length];
		fields[0] = new Street.Builder()
				.setTitle(language.fieldNames(0))
				.setSubText(language.fieldPrices(0, gameBoard))
				.setBgColor(Color.RED)
				.build();
		fields[1] = new Street.Builder()
				.setTitle(language.fieldNames(1))
				.setSubText(language.fieldPrices(1, gameBoard))
				.setBgColor(Color.cyan)
				.build();
		fields[2] = new Shipping.Builder()
				.setTitle(language.fieldNames(2))
				.setSubText(language.fieldPrices(2, gameBoard))
				.build();
		fields[3] = new Street.Builder()
				.setTitle(language.fieldNames(3))
				.setSubText(language.fieldPrices(3, gameBoard))
				.setBgColor(Color.cyan)
				.build();
		fields[4] = new Brewery.Builder()
				.setTitle(language.fieldNames(4))
				.setSubText(language.fieldPrices(4, gameBoard))
				.build();
		fields[5] = new Street.Builder()
				.setTitle(language.fieldNames(5))
				.setSubText(language.fieldPrices(5, gameBoard))
				.setBgColor(Color.PINK)
				.build();
		fields[6] = new Refuge.Builder()
				.setTitle(language.fieldNames(6))
				.setSubText(language.fieldDescription(6))
				.build();
		fields[7] = new Street.Builder()
				.setTitle(language.fieldNames(7))
				.setSubText(language.fieldPrices(7, gameBoard))
				.setBgColor(Color.PINK)
				.build();
		fields[8] = new Shipping.Builder()
				.setTitle(language.fieldNames(8))
				.setSubText(language.fieldPrices(8, gameBoard))
				.build();
		fields[9] = new Street.Builder()
				.setTitle(language.fieldNames(9))
				.setSubText(language.fieldPrices(9, gameBoard))
				.setBgColor(Color.GREEN)
				.build();
		fields[10] = new Tax.Builder()
				.setTitle(language.fieldNames(10))
				.setDescription(language.fieldDescription(10))
				.build();
		fields[11] = new Street.Builder()
				.setTitle(language.fieldNames(11))
				.setSubText(language.fieldPrices(11, gameBoard))
				.setBgColor(Color.GREEN)
				.build();
		fields[12] = new Brewery.Builder()
				.setTitle(language.fieldNames(12))
				.setSubText(language.fieldPrices(12, gameBoard))
				.build();
		fields[13] = new Street.Builder()
				.setTitle(language.fieldNames(13))
				.setSubText(language.fieldPrices(13, gameBoard))
				.setBgColor(Color.GRAY)
				.build();
		fields[14] = new Shipping.Builder()
				.setTitle(language.fieldNames(14))
				.setSubText(language.fieldPrices(14, gameBoard))
				.build();
		fields[15] = new Street.Builder()
				.setTitle(language.fieldNames(15))
				.setSubText(language.fieldPrices(15, gameBoard))
				.setBgColor(Color.GRAY)
				.build();
		fields[16] = new Refuge.Builder()
				.setTitle(language.fieldNames(16))
				.setSubText(language.fieldDescription(16))
				.build();
		fields[17] = new Street.Builder()
				.setTitle(language.fieldNames(17))
				.setSubText(language.fieldPrices(17, gameBoard))
				.setBgColor(Color.WHITE)
				.build();
		fields[18] = new Tax.Builder()
				.setTitle(language.fieldNames(18))
				.setDescription(language.fieldDescription(18))
				.build();
		fields[19] = new Street.Builder()
				.setTitle(language.fieldNames(19))
				.setSubText(language.fieldPrices(19, gameBoard))
				.setBgColor(Color.WHITE)
				.build();
		fields[20] = new Shipping.Builder()
				.setTitle(language.fieldNames(20))
				.setSubText(language.fieldPrices(20, gameBoard))
				.build();
		fields[21] = new Street.Builder()
				.setTitle(language.fieldNames(21))
				.setSubText(language.fieldPrices(21, gameBoard))
				.setBgColor(Color.YELLOW)
				.build();
		GUI.create(fields);
		GUI.setDice(1, 1);
	}
	
	public String getLanguage() {
		return GUI.getUserSelection("Select language. \nVælg sprog.", "Dansk", "English");
	}
	
	public void setDices(DiceCup diceCup) {
		GUI.setDice(diceCup.getDices()[0].getFaceValue(), diceCup.getDices()[1].getFaceValue());
	}
	
	public void addPlayer(String name, int startingBalance) {
		GUI.addPlayer(name, startingBalance);
		GUI.setCar(1, name);
	}
	
	public void moveCar(int fieldNumber, String playerName) {
		GUI.setCar(fieldNumber, playerName);
	}
	
	public void removeCar(int fieldNumber, String playerName) {
		GUI.removeCar(fieldNumber, playerName);
	}
	
	public void updateBalance(String playerName, int newBalance) {
		GUI.setBalance(playerName, newBalance);
	}
	
	public void setOwner(int fieldNumber, String playerName) {
		GUI.setOwner(fieldNumber, playerName);
	}
	
	public int getInteger(String message, int min, int max) {
		return GUI.getUserInteger(message, min, max);
	}
	
	public String getString(String message) {
		return GUI.getUserString(message);
	}
	
	public boolean getBoolean(String message, String optionTrue, String optionFalse) {
		String response = GUI.getUserButtonPressed(message, optionTrue, optionFalse);
		if (response.equals(optionTrue))
			return true;
		else return false;
	}
	
	public boolean getButtonPressed(String message) {
		GUI.getUserButtonPressed(message, "OK!");
		return true;
	}
	
	
}
