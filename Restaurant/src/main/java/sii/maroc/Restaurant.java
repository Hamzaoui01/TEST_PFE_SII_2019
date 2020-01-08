package sii.maroc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

public class Restaurant {

	private List<Ingredient> stockIngredient = new ArrayList<Ingredient>();
	static List<Dishe> dishes=new ArrayList<Dishe>();
	
	static {
		Dishe dishe=new Dishe("Tomato Mozzarella Salad",6);
		dishe.addIngredientToRecipe("balls Mozzarella",1 );
		dishe.addIngredientToRecipe("tomatoes",2 );
		dishe.addIngredientToRecipe("olive oil",-1 );		
		dishes.add(dishe);
		Dishe pizza=new Dishe("Pizza",10);
		dishe.addIngredientToRecipe("balls Mozzarella",1 );
		dishe.addIngredientToRecipe("tomatoes",4 );
		dishe.addIngredientToRecipe("olive oil",-1 );
		dishe.addIngredientToRecipe("water",100 );
		dishe.addIngredientToRecipe("Flour",300 );
		dishe.addIngredientToRecipe("sea salt",-1 );
		dishes.add(pizza);							
	}
	
	public Restaurant(String... ingredientsWithQuantity) {
		// TODO Auto-generated constructor stub
		fillStock(ingredientsWithQuantity);

	}

	private void fillStock(String[] ingredientsWithQuantity) {
		// TODO Auto-generated method stub
		for (String ingredientWithQuantity : ingredientsWithQuantity) {
			stockIngredient.add(createIngredient(ingredientWithQuantity));
		}
	}

	private Ingredient createIngredient(String ingredientWithQuantity) {
		
		// TODO Auto-generated method stub
		String[] ingredientWithQuantityArray = ingredientWithQuantity.split(" ");
		
		if (isNumber(ingredientWithQuantityArray[0])) {			
			String name = ingredientWithQuantity.substring(ingredientWithQuantity.indexOf(" ") + 1);
			int quantity = Integer.parseInt(ingredientWithQuantityArray[0]);
			Ingredient ingredient = new Ingredient(name, quantity, false);
			return ingredient;
		}	
		return new Ingredient(ingredientWithQuantity, -1, true);

	}

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
		Ticket ticket=new Ticket();	
		return ticket.and(disheWithQuantity);
	}
	
	public static Dishe getDisheByName(String name){
		for(Dishe dishe:dishes) {
			if(dishe.getName().contains(name))return dishe;
		}		
		return null;
	}

	public Meal retrieve(Ticket ticket) {
		// TODO Auto-generated method stub
		Meal meal=new Meal();
		for(Entry<Dishe, Integer>  dishe:ticket.getDishesOrdred().entrySet()) {
			consumeIngredient(dishe);
			meal.addDishe(dishe.getKey(), dishe.getValue());
		}
		return meal;
	}

	private void consumeIngredient(Entry<Dishe, Integer> dishe) {
		// TODO Auto-generated method stub
		for(Entry<String,Integer> ingredientEntry:dishe.getKey().getRecipe().entrySet()) {
			Ingredient ingredient=	getIngredientByNameFromStock(ingredientEntry.getKey());
			if(ingredient!=null)
			ingredient.consume(ingredientEntry.getValue());
		}
		
	}

	private Ingredient getIngredientByNameFromStock(String name) {
		// TODO Auto-generated method stub
		System.out.println("**********");
		for(Ingredient ingredient:stockIngredient) {
			System.out.println(ingredient.getName());
			if(ingredient.getName().contains(name)||ingredient.getName().equals(name))return ingredient;
		}
		return null;
	}

}
