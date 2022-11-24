package com.ideas.interview;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AcceptanceTest {

	private Controller controller;
	private Display display;
	private Barista barista;

	@Test
	public void dispenseBlackCoffeeForFree() {
		display = new Display();
		barista = new Barista(100,0, 500);
		controller = new Controller(display, barista);
		assertEquals("Please select a coffee type", display.currentMessage());
		userWants(CoffeeType.BLACK);
		assertEquals("Great Choice!", display.currentMessage());
		controller.dispense();
		assertEquals(CoffeeType.BLACK, barista.servedCoffee());
		assertEquals("Please collect your delicious coffee", display.currentMessage());
	}


	@Test
	public void dispenseBlackCoffeeFails() {
		display = new Display();
		barista = new Barista(0,0, 500);
		controller = new Controller(display, barista);

		assertEquals("Please select a coffee type", display.currentMessage());
		userWants(CoffeeType.BLACK);
		assertEquals("Great Choice!", display.currentMessage());
		controller.dispense();
		assertEquals(CoffeeType.EXCEPTION, barista.servedCoffee());
		assertEquals("Please collect your delicious coffee", display.currentMessage());
	}

	private AcceptanceTest userWants(CoffeeType coffeeType) {
		controller.userWants(coffeeType);
		return this;
	}

	private void powerUp() {
		display = new Display();
		barista = new Barista(0,0, 500);
		controller = new Controller(display, barista);
	}
}
