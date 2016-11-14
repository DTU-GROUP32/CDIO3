package entity.fields;

import entity.Player;

public class Tax extends Field {

	private int taxAmount;
	private int taxRate; //in percent

	public Tax(int taxAmount) {
		this(taxAmount,0);
	}

	public Tax(int taxAmount, int taxRate) {
		this.Ownable = false;
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
}
