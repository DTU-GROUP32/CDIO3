package spil;

import java.util.Scanner;

public class Fleet extends Ownable {

	private final int RENT_1 = 500;
	private final int RENT_2 = 1000;
	private final int RENT_3 = 2000;
	private final int RENT_4 = 4000;
	
	public Fleet(int price, Player owner, int fleetsOwned) {
		this.price = price;
		this.owner = owner;
	}
	
	@Override
	public void landOnField(Player player) {
		if (owner != null) {
			player.getBank().changeBalance(getRent()*(-1));
			owner.getBank().changeBalance(getRent());
		} else if (owner == null) {
			buyTerritory(player);
		}
	}
	
	public void buyTerritory(Player player) {
		Scanner input = new Scanner(System.in);
		// System.out.println("Dette felt ejes ikke af nogen. Feltet koster " + this.price);
		// System.out.println("Tast 1 for at gå videre");
		// System.out.println("Tast 2 for at købe dette felt");
		
		int temp = Integer.parseInt(input.nextLine());
		
		switch (temp) {
		case 1:
			break;
		case 2:
			player.getBank().changeBalance(this.price*(-1));
			setOwner(player);
			player.setFleetsOwned(player.getFleetsOwned() + 1);
			// System.out.println("Feltet blev købt");
			break;
		default:
			break;
		}
		
		input.close();
	}
	
	@Override
	public int getRent() {
		int temp;
		
		switch (this.owner.getFleetsOwned()) {
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
		this.owner = newOwner;
	}

	@Override
	public Player getOwner() {
		return this.owner;
	}

	@Override
	public String getFieldMessage(Player player) {
		return null;
	}


	
}
