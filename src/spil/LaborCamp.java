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
	public int getRent() {
		return baseRent;
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
		// TODO Need to add a part with the double amount, when owning 2 Labor Camps
		Scanner input = new Scanner(System.in);
		DiceCup dc = new DiceCup();
		
		dc.rollDices();
		System.out.println("Du slog en " + dc.getDices()[0] + "'er og en " + dc.getDices()[1] + "'er.");
		baseRent = dc.getSum()*100;
		
		input.close();
		
		return baseRent;
		
	}
	
	public void buyTerritory(Player player) {
		// TODO Method needs to be reworked. This is only a temporary version
		System.out.println("Dette felt ejes ikke af nogen. Feltet koster " + this.price);
		Scanner input = new Scanner(System.in);
		System.out.println("Tast 1 for at gå videre");
		System.out.println("Tast 2 for at købe dette felt");
		
		int temp = Integer.parseInt(input.nextLine());
		
		switch (temp) {
		case 1:
			break;
		case 2:
			player.getBank().changeBalance(this.price*(-1));
			setOwner(player);
			System.out.println("Feltet blev købt");
			break;
		default:
			break;
		}
		
		input.close();
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
