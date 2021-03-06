package sii.maroc;

import java.util.HashMap;
import java.util.Map;

public class Ticket {
	private Map<Dishe, Integer> dishesOrdred = new HashMap<Dishe, Integer>();

	public Ticket and(String disheWithQuantity) {
		// TODO Auto-generated method stub
		String disheName = disheWithQuantity.substring(disheWithQuantity.indexOf(" ") + 1);
		String quantityString = disheWithQuantity.substring(0, disheWithQuantity.indexOf(" "));
		addDisheToTicket(disheName,quantityString);
		return this;
	}
	

	private void addDisheToTicket(String disheName, String quantityString) {
		// TODO Auto-generated method stub
		int quantity = Integer.parseInt(quantityString);
		Dishe dishe = Restaurant.getDisheByName(disheName);
		this.dishesOrdred.put(dishe, quantity);
	}
	
	public Map<Dishe, Integer> getDishesOrdred() {
		return dishesOrdred;
	}

	public void setDishesOrdred(Map<Dishe, Integer> dishesOrdred) {
		this.dishesOrdred = dishesOrdred;
	}

}
