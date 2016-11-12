package spil;

public class Fleet extends Ownable {

	private final int RENT_1 = 500;
	private final int RENT_2 = 1000;
	private final int RENT_3 = 2000;
	private final int RENT_4 = 4000;
	private int fleetsOwned;
	
	public Fleet(int price, Player owner, int fleetsOwned) {
		this.price = price;
		this.owner = owner;
		this.fleetsOwned = fleetsOwned;
	}
	
	@Override
	public int getRent() {
		int temp;
		
		switch (fleetsOwned) {
		case 1:
			temp = RENT_1;
			break;
		case 2:
			temp = RENT_2;
			break;
		case 3:
			temp = RENT_3;
			break;
		case 4:
			temp = RENT_4;
			break;
		default:
			temp = 0;
			break;
		}
		
		return temp;
	}
	
	@Override
	public void setOwner(Player newOwner) {

	}

	@Override
	public Player getOwner() {
		return this.owner;
	}
	
	@Override
	public void landOnField(Player player) {
		
	}


	
}
