package com.rivals.pokerengine;

public enum Suits {
	Club(1), Diamond(2), Heart(3), Spade(4);
	
	private int suitValue;
	
	private Suits (int suitValue){
	    this.suitValue = suitValue;
	}
	
	public int getSuitValue(){
		return suitValue;
	}
	
}
