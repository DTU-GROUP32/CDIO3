package entity.fields;

import entity.Player;

public abstract class Field {
	
	protected boolean Ownable;
	
	public abstract void landOnField(Player player);
	
	public boolean isOwnable() {
		return Ownable;
	}
	
}
