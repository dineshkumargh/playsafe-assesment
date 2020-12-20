package com.assessment;

public class Betting {

	private Object betValue;
	private int value;

	public Betting(Object betValue, int value) {
		super();
		this.betValue = betValue;
		this.value = value;
	}

	public Object getBetValue() {
		return betValue;
	}

	public void setBetValue(Object betValue) {
		this.betValue = betValue;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
