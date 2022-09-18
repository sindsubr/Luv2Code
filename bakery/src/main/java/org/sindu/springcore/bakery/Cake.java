package org.sindu.springcore.bakery;

public class Cake implements BakeryCook {

	private Flavors flavors;

	public void init() {
		System.out.println("cake preparation starts...!");
	}
	public void destroy() {
		System.out.println("cake is ready to taste :)");
	}
	public void setFlavors(Flavors flavors) {
		this.flavors = flavors;
	}

	public void getFlavor() {
		flavors.getFlavorIngredients();
	}

	@Override
	public void bake() {
		System.out.println("Your Cake is ready to bake :)");
	}

}
