package org.sindu.springcore.bakery;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("butterscotchCake")
@Scope("prototype")
public class Cake implements BakeryCook {

	@Autowired
	private Flavors flavors;

	@PostConstruct
	public void init() {
		System.out.println("Init : Ticket raised -> cake preparation starts...!");
	}
	@PreDestroy
	public void destroy() {
		System.out.println("cake is ready to taste :) -> Ticket destroyed");
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
