package sii.maroc;

public class Meal {
	private int disheNumber = 0;
	private int timeToPrepare = 0;

	public int servedDishes() {
		// TODO Auto-generated method stub
		return disheNumber;
	}

	public int cookingDuration() {
		// TODO Auto-generated method stub
		return timeToPrepare;
	}

	public void addDishe(Dishe dishe, int quantity) {
		this.disheNumber += quantity;
		for (int i = 0; i < quantity; i++) {
			if (i == 0) {
				this.timeToPrepare += dishe.getPreparationTime();
			}

			else {
				this.timeToPrepare += dishe.getPreparationTime() / 2;
			}
		}

	}

}
