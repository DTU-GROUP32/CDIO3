package spil;

public class Territory extends Ownable {

	private int rent;
	
	public Territory(int price, Player owner, int rent) {
		this.price = price;
		this.owner = owner;
		this.rent = rent;
	}
	
	@Override
	public int getRent() {
		return rent;
	}
	
	@Override
	public void landOnField(Player player) {

	}

	@Override
	public void setOwner(Player newOwner) {
		this.owner = newOwner;
	}

	@Override
	public Player getOwner() {
		return this.owner;
	}

}
