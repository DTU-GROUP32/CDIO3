package spil;

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
	
	//Jeg og Viktor, vi har talt om at jeg bruger en anden metode i sted for boolean
	private void payTax
	Tax = GUI.getUserButtonPressed("You have to choose"+taxAmount+"or paying 10% of your property.","Pay "+textAmount+"")

	@Override
	public String getFieldMessage(Player player) {
		// TODO Auto-generated method stub
		return null;
	}

}
