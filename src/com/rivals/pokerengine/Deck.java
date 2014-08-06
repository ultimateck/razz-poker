package com.rivals.pokerengine;

import java.util.*;

public class Deck {
	private List<Card> cards = new ArrayList<Card>();
	private final int TOTAL_CARDS=52;
	
	public Deck(){
		int i = 1;
		for (Faces face : Faces.values()){
			for (Suits suit : Suits.values()){
				Card card = new Card(face, suit, i++);
				if(cards.size() <= TOTAL_CARDS) cards.add(card);
			}
	    }
	}
	
	public void shuffleDeck(){
	    Collections.shuffle(cards);
	}
	
	public Card getCard(){
		return cards.remove(0);
	}
	
	public Card getCard(int index){
        return cards.remove(index);
    }
	
	public List<Card> getCards(){
		return cards;
	}

}
