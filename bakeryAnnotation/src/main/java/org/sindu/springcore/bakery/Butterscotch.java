package org.sindu.springcore.bakery;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component("butterscotch")
@PropertySource("classpath:theme.properties")
public class Butterscotch implements Flavors {

	@Value("${color}")
	private String color;
	@Value("${theme}")
	private String theme;
	@Value("${printQuote}")
	private String printQuotes;

	String[] ingredients = { "Butterscotch Essence", "Egg", "Floar", "Yeast", "Milk" };

	@Override
	public void getFlavorIngredients() {
		System.out.println(
				"Cake Theme :\nColor: " + color + "\nTheme:" + theme + "\nPrinting Quote:" + printQuotes + "\n");
		System.out.println("Your Ingrediants needed:");
		for (int i = 0; i < ingredients.length; i++)
			System.out.println(ingredients[i]);
	}

}
