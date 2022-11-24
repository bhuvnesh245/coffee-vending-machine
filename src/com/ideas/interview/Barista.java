package com.ideas.interview;

public class Barista {

	private CoffeeType servedCoffee;
	private int waterQuantity;
	private int milkQuantity;
	private int coffeePowderQuantity;

	public Barista(int waterQuantity, int milkQuantity, int coffeePowderQuantity){
		this.waterQuantity = waterQuantity;
		this.milkQuantity = milkQuantity;
		this.coffeePowderQuantity = coffeePowderQuantity;
	}

	public void serve(CoffeeType coffeeType) {
		servedCoffee = coffeeType;
		prepareCoffee(coffeeType);
	}

	public CoffeeType servedCoffee() {
		return servedCoffee;
	}


	private void prepareCoffee(CoffeeType coffeeType){
		int quantity = 50;
		int temp = 100;

		switch (coffeeType){
			case BLACK : prepareBlackCoffee(quantity,temp);
			break;
			case MILK: prepareMilkCoffee(quantity,temp);
			break;
		}

	}

	private void prepareMilkCoffee(int quantity, int temp) {
		int waterQuantity = quantity/2;
		int milkQuantity = quantity/2;
		int coffeePowderQuantity = quantity/5;

		if(addWater(waterQuantity)
				&& addMilk(milkQuantity)
				&&  addCoffee(coffeePowderQuantity)) {
			heat(temp);
		}else {
			this.servedCoffee = CoffeeType.EXCEPTION;
		}
	}


	private void prepareBlackCoffee(int quantity,int temp) {
		int waterQuantity = quantity;
		int coffeePowderQuantity = quantity/5;

		if(addWater(waterQuantity) && addCoffee(coffeePowderQuantity)) {
			heat(temp);
		}else {
			this.servedCoffee = CoffeeType.EXCEPTION;
		}
	}

	private boolean validateWaterQuantity(int quantity){

		if( (this.waterQuantity - quantity) >= 0 ){
			this.waterQuantity = this.waterQuantity - quantity;
			return true;

		}
		return false;
	}

	private boolean validateMilkQuantity(int quantity){
		if((this.milkQuantity - quantity) >= 0){
			this.milkQuantity = this.milkQuantity - quantity;
			return true;

		}
		return false;
	}

	private boolean validateCoffeePowderQuantity(int quantity){

		if((this.coffeePowderQuantity - quantity) >= 0 ){
			this.coffeePowderQuantity = this.coffeePowderQuantity - quantity;
			return true;

		}

		return false;
	}

	private void heat(int temp) {
	}

	private boolean addCoffee(int quantity) {
		return validateCoffeePowderQuantity(quantity);
	}

	private boolean addWater(int quantity) {
		return validateWaterQuantity(quantity);
	}

	private boolean addMilk(int quantity) {
		return validateMilkQuantity(quantity);
	}

	public int getMilkQuantity() {
		return milkQuantity;
	}

	public int getWaterQuantity() {
		return waterQuantity;
	}

	public int getCoffeePowderQuantity() {
		return coffeePowderQuantity;
	}

}
