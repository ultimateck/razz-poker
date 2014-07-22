package com.rivals.pokerengine;

public class Card {
	 private Faces face;
	 private Suits suit;
	 private int uval;
	 
	 public Card(){
		 this.face = null;
		 this.suit = null;
	 }
	 
	 public Card(Faces face, Suits suit){
		 this.face = face;
		 this.suit = suit;
	 }

	public Faces getFace() {
		return face;
	}

	public Suits getSuit() {
		return suit;
	}

	public int getUval() {
		return uval;
	}

	public void setFace(Faces face) {
		this.face = face;
	}

	public void setSuit(Suits suit) {
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
