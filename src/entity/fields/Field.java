package entity.fields;

import entity.Player;

public abstract class Field {

	protected boolean ownable;

	public boolean isOwnable() {
		return ownable;
		}

	public abstract int getPrice();

	public abstract Player getOwner();

	public abstract void setOwner(Player newOwner);

	public abstract void landOnField(Player player);

	public abstract int getRent();

	public abstract void buyField(Player player);
}
