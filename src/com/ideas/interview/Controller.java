package com.ideas.interview;

public class Controller {
	private final Display display;
	private final Barista barista;
	private CoffeeType coffeeType;

	public Controller(Display display, Barista barista) {
		this.display = display;
		this.barista = barista;
		display.show("Please select a coffee type");
	}

	public void userWants(CoffeeType coffeeType) {
		this.coffeeType = coffeeType;
		display.show("Great Choice!");
	}

	public void dispense() {
		barista.serve(coffeeType);
		display.show("Please collect your delicious coffee");
	}
}
