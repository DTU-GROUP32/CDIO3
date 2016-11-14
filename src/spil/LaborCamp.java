package spil;

import java.util.Scanner;

public class LaborCamp extends Ownable {
	
	private int baseRent;
	
	public LaborCamp(int price, Player owner, int baseRent) {
		this.price = price;
		this.owner = owner;
		this.baseRent = baseRent;
	}
	
	@Override
	public void landOnField(Player player) {	
		if (owner != null) {
			player.getBank().changeBalance(determineRent()*(-1));
			owner.getBank().changeBalance(determineRent());
		} else if (owner == null) {
			buyTerritory(player);
		}
		
	}
	
	public int determineRent() {
		DiceCup dc = new DiceCup();
		dc.rollDices();
		if (this.owner.getLaborCampsOwned() == 1) {
			baseRent = dc.getSum()*100;
		} else if (this.owner.getLaborCampsOwned() == 2) {
			baseRent = dc.getSum()*200;
		}
		return baseRent;
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
			player.setFleetsOwned(player.getLaborCampsOwned() + 1);
			// System.out.println("Feltet blev købt");
			break;
		default:
			break;
		}
		
		input.close();
	}
	
	@Override
	public int getRent() {
		return baseRent;
	}

	@Override
	public void setOwner(Player newOwner) {
		this.owner = newOwner;		
	}

	@Override
	public Player getOwner() {
		return owner;
	}

	@Override
	public String getFieldMessage(Player player) {
		return null;
	}

}
