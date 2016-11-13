package entity;

public class LaborCamp extends Ownable {
	
	private int baseRent;
	
	public LaborCamp() {
		super(2500);
		this.baseRent = 100;
	}

	@Override
	public void landOnField(Player player) {
		if(owner != null)
			owner.getBankAccount().deposit(player.getBankAccount().withdraw(this.getRent() * player.getLastRoll()));
	}
	
	@Override
	public int getRent() {
		return baseRent;
	}
	
	
}
