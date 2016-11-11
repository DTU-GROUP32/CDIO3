package spil;

import desktop_resources.GUI;

public class Tax extends Field {
	
	private String Tax, fieldName;
	private int Pay, taxAmount, taxRate = -1;
	private Player player;
	private String[] strings;
	
	public Tax(int tax, String fieldname){
		taxAmount = tax;
		this.fieldName = fieldName;
	}

	@Override
	public void landOnField(Player player) {
		// TODO Auto-generated method stub
		this.player = player;
		GUI.showMessage(getFieldMessage(player));
		payTax();

	}
	
	//not sure I will find out in test, that I have to use modulus or devide.
	private int minusTen(Player player){
		return player.getBank().getBalance()%10;
	}
	
	//Jeg og Viktor, vi har talt om at jeg bruger en anden metode i sted for boolean
	private void payTax(){
	Tax = GUI.getUserButtonPressed("You have to choose"+taxAmount+"or paying 10% of your property.","Pay "+taxAmount, "Pay "+ minusTen(player));
	Pay = Integer.parseInt(Tax.replaceAll("[\\D]", ""));
	player.getBank().changeBalance(-Pay);
	GUI.setBalance(player.getName(), player.getBank().getBalance());
	}
	
	//Juts think it's a good idea to tell player which field he or she landed on.
	@Override
	public String getFieldMessage(Player player) {
		// TODO Auto-generated method stub
		return player.getName()+"you landed on "+fieldName;
	}

}
