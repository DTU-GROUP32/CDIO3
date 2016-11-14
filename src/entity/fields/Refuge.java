package entity.fields;

import entity.Player;

public class Refuge extends Field {

	private int bonus;

	public Refuge(int bonus) {
		this.Ownable = false;
		this.bonus = bonus;
	}
	
	public int getBonus() {
		return bonus;
	}

	@Override
	public void landOnField(Player player) {
		player.getBankAccount().deposit(bonus);
	}
}
