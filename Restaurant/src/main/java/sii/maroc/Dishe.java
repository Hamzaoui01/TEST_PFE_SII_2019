package sii.maroc;

import java.util.HashMap;
import java.util.Map;

public class Dishe {
	private String name;
	private Map<String, Integer> recipe = new HashMap<String, Integer>();
	private int preparationTime;

	public Dishe(String name, int preparationTime) {
		super();
		this.name = name;
		this.preparationTime = preparationTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, Integer> getRecipe() {
		return recipe;
	}

	public void setRecipe(Map<String, Integer> recipe) {
		this.recipe = recipe;
	}

	public int getPreparationTime() {
		return preparationTime;
	}

	public void setPreparationTime(int preparationTime) {
		this.preparationTime = preparationTime;
	}

	public void addIngredientToRecipe(String ingredientName, int quantity) {
		this.recipe.put(ingredientName, quantity);
	}
}
