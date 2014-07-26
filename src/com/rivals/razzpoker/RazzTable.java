package com.rivals.razzpoker;

import java.util.ArrayList;
import java.util.List;

import com.rivals.pokerengine.*;

public class RazzTable implements PokerTable {
	
	private Deck deck;
	private List<Player> players;
	
	public RazzTable(){
		deck = new Deck();
		players = new ArrayList<Player>();
	}
	

	@Override
	public void deal() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void shuffel() {
		deck.shuffleDeck();
	}

}
