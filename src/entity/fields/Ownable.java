package entity.fields;

import entity.Player;

public abstract class Ownable extends Field {

	protected int price;
	protected Player owner;
	
	public Ownable(int price){
		this.Ownable = true;
		this.price = price;
		this.owner = null;
	}
	
	public int getPrice() {
		return price;
	}
	
	public Player getOwner(){
		return owner;
	}
	
	public void setOwner(Player newOwner){
		this.owner = newOwner;
	}
	
	public void landOnField(Player player) {
		if(owner != null)
			owner.getBankAccount().deposit(player.getBankAccount().withdraw(this.getRent()));
	}
	
	public abstract int getRent();
	
	public void buyField(Player player) {
		if(player.getBankAccount().getBalance() >= this.price)
		{
			player.getBankAccount().withdraw(this.price);
			this.setOwner(player);
		}
	}
}
