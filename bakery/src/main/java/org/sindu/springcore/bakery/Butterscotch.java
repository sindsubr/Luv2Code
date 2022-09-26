package org.sindu.springcore.bakery;

public class Butterscotch implements Flavors {

	private String color;
	private String theme;
	private String printQuotes;

	String[] ingredients = { "Butterscotch Essence", "Egg", "Floar", "Yeast", "Milk" };

	public Butterscotch(String color, String theme, String printQuotes) {
		super();
		this.color = color;
		this.theme = theme;
		this.printQuotes = printQuotes;
	}

	@Override
	public void getFlavorIngredients() {
		System.out.println("Cake Theme :\nColor: " + color + "\nTheme:" + theme + "\nPrinting Quote:" + printQuotes+"\n");
		System.out.println("Your Ingrediants needed:");
		for (int i = 0; i < ingredients.length; i++)
			System.out.println(ingredients[i]);
	}

}
