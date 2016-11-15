package entity.fields;

import entity.Player;

public class Tax extends Field {

	private int taxAmount;
	private int taxRate; //in percent

	public Tax(int taxAmount) {
		this(taxAmount,0);
		this.ownable = false;
	}

	public Tax(int taxAmount, int taxRate) {
		this.taxAmount = taxAmount;
		this.taxRate = taxRate;
	}
	
	public int getTaxAmount() {
		return taxAmount;
	}
	
	public int getTaxRate() {
		return taxRate;
	}

	@Override
	public void landOnField(Player player) {
		if (player.isTaxChoice())
			player.getBankAccount().withdraw(player.getBankAccount().getBalance() * taxRate / 100);
		else player.getBankAccount().withdraw(taxAmount);
		player.setTaxChoice(false);
	}
	
	@Override
	public int getPrice() {
		return -1;
	}

	@Override
	public Player getOwner() {
		return null;
	}

	@Override
	public void setOwner(Player newOwner) {}

	@Override
	public int getRent() {
		return -1;
	}

	@Override
	public void buyField(Player player) {}
}
