package sii.maroc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import sii.maroc.Dishe.DisheBuilder;

public class Restaurant {

	private List<Ingredient> stockIngredient = new ArrayList<Ingredient>();
	static List<Dishe> dishes = new ArrayList<Dishe>();

	/**
	 * Ces donn�es sont partag� entre tout les instances de classes, sinon il
	 * doivent figurer dans le constructeur.
	 */
	static {
		
		dishes.add(
				new DisheBuilder().name("Tomato Mozzarella Salad")
							 .timeToPrepare(6)
							 .needIgredient(new Ingredient("balls Mozzarella Salad", 1,false))
							 .needIgredient(new Ingredient("tomatoes", 2, false))
							 .needIgredient(new Ingredient("olive oil", -1,true ))
							 .build()
					);
		
		dishes.add(
				new DisheBuilder().name("Pizza")
							 .timeToPrepare(10)
							 .needIgredient(new Ingredient("balls Mozzarella Salad", 1,false))
							 .needIgredient(new Ingredient("tomatoes", 4, false))
							 .needIgredient(new Ingredient("olive oil", -1,true ))
							 .needIgredient(new Ingredient("water", 100, false))
							 .needIgredient(new Ingredient("Flour", 300, false))
							 .needIgredient(new Ingredient("sea salt", -1, true))
							 .build()
					);		
	}

	public Restaurant(String... ingredientsWithQuantity) {
		// TODO Auto-generated constructor stub
		fillStock(ingredientsWithQuantity);

	}

	/**
	 * cette methode remlit le stock des ingredients
	 * 
	 * @param ingredientsWithQuantity
	 */
	private void fillStock(String[] ingredientsWithQuantity) {
		// TODO Auto-generated method stub
		for (String ingredientWithQuantity : ingredientsWithQuantity) {
			stockIngredient.add(createIngredient(ingredientWithQuantity));
		}
	}

	/**
	 * cette methode creer un nouveau ingredient par l entree de l'utilisateur.
	 * 
	 * @param ingredientWithQuantity
	 * @return
	 */
	private Ingredient createIngredient(String ingredientWithQuantity) {
		String[] ingredientWithQuantityArray = ingredientWithQuantity.split(" ");
		if (isNumber(ingredientWithQuantityArray[0])) {
			String name = ingredientWithQuantity.substring(ingredientWithQuantity.indexOf(" ") + 1);
			int quantity = Integer.parseInt(ingredientWithQuantityArray[0]);
			Ingredient ingredient = new Ingredient(name, quantity, false);
			return ingredient;
		}
		return new Ingredient(ingredientWithQuantity, -1, true);
	}

	/**
	 * test si un string ets u num�ro
	 * 
	 * @param stringToCheck
	 * @return
	 */
	private boolean isNumber(String stringToCheck) {
		// TODO Auto-generated method stub
		try {
			Integer.parseInt(stringToCheck);
			return true;
		} catch (NumberFormatException e) {
			// TODO: handle exception
			return false;
		}
	}

	public Ticket order(String disheWithQuantity) {
		// TODO Auto-generated method stub
		Ticket ticket = new Ticket();
		return ticket.and(disheWithQuantity);
	}
	
	/**
	 * rretourn Dishe par son nom depuis la liste des dishe
	 * 
	 * @param name
	 * @return
	 */
	public static Dishe getDisheByName(String name) {
		for (Dishe dishe : dishes) {
			if (dishe.getName().contains(name))
				return dishe;
		}
		return null;
	}

	public Meal retrieve(Ticket ticket) {
		// TODO Auto-generated method stub
		Meal meal = new Meal();
		for (Entry<Dishe, Integer> dishe : ticket.getDishesOrdred().entrySet()) {
			consumeIngredient(dishe);
			meal.addDishe(dishe.getKey(), dishe.getValue());
		}
		return meal;
	}

	private void consumeIngredient(Entry<Dishe, Integer> dishe) {
		// TODO Auto-generated method stub
		for(Ingredient ingredient:dishe.getKey().getRecipe()) {
			Ingredient ingredientInStock = getIngredientByNameFromStock(ingredient.getName());
			if (ingredientInStock != null) {
				for (int i = 0; i < dishe.getValue(); i++) {
					ingredientInStock.consume(ingredient.getQuantity());
				}
			}
		}
	}

	private Ingredient getIngredientByNameFromStock(String name) {
		// TODO Auto-generated method stub
		for (Ingredient ingredient : stockIngredient) {
			if (ingredient.getName().contains(name) || ingredient.getName().equals(name))
				return ingredient;
		}
		return null;
	}
}
