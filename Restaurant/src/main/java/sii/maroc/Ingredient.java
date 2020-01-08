package sii.maroc;

public class Ingredient {
	private String name;
	private int quantity;
	private boolean unlimited;

	public Ingredient(String name, int quantity, boolean unlimited) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.unlimited = unlimited;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean isUnlimited() {
		return unlimited;
	}

	public void setUnlimited(boolean unlimited) {
		this.unlimited = unlimited;
	}

	public void consume(int quantityConsummed) {
		// TODO Auto-generated method stub
		if (!isUnlimited()) {
			quantity -= quantityConsummed;
			if (quantity < 0)
				throw new UnavailableDishException("Unavailable Dish");
		}

	}
}
