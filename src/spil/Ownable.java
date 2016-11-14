package spil;

public abstract class Ownable extends Field {

	protected int price;
	protected Player owner;
	
	public abstract void setOwner(Player newOwner);
	public abstract Player getOwner();
	public abstract int getRent();
	
}
