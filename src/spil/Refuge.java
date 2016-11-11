package spil;

public class Refuge extends Field {

	private int bonus;
	private Player player;
	private String fieldName;

	public Refuge(int bonus, String fieldName){
		this.bonus = bonus;
		this.fieldName = fieldName;
	}

	@Override
	public void landOnField(Player player) {
		this.player = player;
		GUI.showMessage(getFieldMessage(player));
		bonus();
	}
	
	@Override
	public String getFieldMessage(Player player){
		return player.getName()+",you are on land "+fieldName+" Your bonus is"+bonus;
	}
	private void bonus(){
		player.getBank().changeBalance(bonus);
		GUI.setBalance(player.getName(),player.getBank().getBalance());
	}
	


}
