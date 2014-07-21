package com.rivals.pokerengine;

public class Card {
	 private String face;
	 private String suit;
	 private int uval;
	 
	 public Card(){
		 this.face = null;
		 this.suit = null;
	 }
	 
	 public Card(String face, String suit){
		 this.face = face;
		 this.suit = suit;
	 }

	public String getFace() {
		return face;
	}

	public String getSuit() {
		return suit;
	}

	public int getUval() {
		return uval;
	}

	public void setFace(String face) {
		this.face = face;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	public void setUval(int uval) {
		this.uval = uval;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	 
	 

}
