package spil;

public class LaborCamp extends Ownable {
	
	private int baseRent;
	
	public LaborCamp(int price, Player owner, int baseRent) {
		this.price = price;
		this.owner = owner;
		this.baseRent = baseRent;
	}
	
	
	
	@Override
	public int getRent() {
		return baseRent;
	}
	
	@Override
	public void landOnField(Player player) {
		
		if (owner != null) {
			
		} else if (owner == null) {
			
		}
		
	}

	@Override
	public void setOwner(Player newOwner) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Player getOwner() {
		// TODO Auto-generated method stub
		return null;
	}

}
