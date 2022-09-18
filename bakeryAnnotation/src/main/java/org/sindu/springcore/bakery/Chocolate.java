package org.sindu.springcore.bakery;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("chocolate")
@Primary
public class Chocolate implements Flavors {

	private String color;
	private String theme;
	private String printQuotes;

	String[] ingredients = { "Chocolate powder", "Egg", "Floar", "Yeast", "Milk" };

	@Override
	public void getFlavorIngredients() {
		System.out.println(
				"Cake Theme :\nColor: " + color + "\nTheme:" + theme + "\nPrinting Quote:" + printQuotes + "\n");
		System.out.println("Your Ingrediants needed:");
		for (int i = 0; i < ingredients.length; i++)
			System.out.println(ingredients[i]);

	}

}
