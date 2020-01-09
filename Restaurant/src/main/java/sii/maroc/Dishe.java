package sii.maroc;

import java.util.ArrayList;
import java.util.List;

public class Dishe {

	private String name;
	private List<Ingredient> recipe;
	private int preparationTime;

	private Dishe(String name, int preparationTime,List<Ingredient> recipe) {
		super();
		this.name = name;
		this.preparationTime = preparationTime;
		this.recipe=recipe;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPreparationTime() {
		return preparationTime;
	}

	public void setPreparationTime(int preparationTime) {
		this.preparationTime = preparationTime;
	}	

	public List<Ingredient> getRecipe() {
		return recipe;
	}

	public void setRecipe2(List<Ingredient> recipe) {
		this.recipe = recipe;
	}

	static class DisheBuilder {
		private String name;
		private int timeToprepare;
		private List<Ingredient> recipe = new ArrayList<Ingredient>();

		public DisheBuilder name(String name) {
			this.name = name;
			return this;
		}
		
		public DisheBuilder timeToPrepare(int timeToPrepare) {
			this.timeToprepare=timeToPrepare;
			return this;
		}

		public DisheBuilder needIgredient(Ingredient ingredient) {
			this.recipe.add(ingredient);
			return this;
		}
		
		public Dishe build() {
			return new Dishe(name, timeToprepare,recipe);
		}		
	}
}
