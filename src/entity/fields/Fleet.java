package entity.fields;

import entity.Player;

public class Fleet extends Ownable {

	private final int RENT_1 = 500;
	private final int RENT_2 = 1000;
	private final int RENT_3 = 2000;
	private final int RENT_4 = 4000;
	private static int[] numberOfFleetsOwnedByEachPlayer = {0,0,0,0,0,0};

	public Fleet() {
		super(4000);
	}

	@Override
	public int getRent() {
		int[] values = {RENT_1,RENT_2,RENT_3,RENT_4};
		return values[numberOfFleetsOwnedByEachPlayer[owner.getID()]-1];
	}

	@Override
	public void buyField(Player player) {
		super.buyField(player);
		numberOfFleetsOwnedByEachPlayer[player.getID()]++;
	}
}
