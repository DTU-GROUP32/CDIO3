package spil;

import java.util.Scanner;

public class Territory extends Ownable {

	private int rent;
	
	public Territory(int price, int rent) {
		this(price, null, rent);
	}
	
	public Territory(int price, Player owner, int rent) {
		this.price = price;
		this.owner = owner;
		this.rent = rent;
	}
	
	@Override
	public void landOnField(Player player) {
		
		if(owner != null) { // If territory is owned by someone
			player.getBank().changeBalance(rent*(-1)); // Withdraws rent from the player that lands on the field
			owner.getBank().changeBalance(rent); // Deposits rent to the owner
		} else {
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
			// System.out.println("Feltet blev købt");
			break;
		default:
			break;
		}
		
		input.close();
	}
	
	@Override
	public int getRent() {
		return rent;
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
