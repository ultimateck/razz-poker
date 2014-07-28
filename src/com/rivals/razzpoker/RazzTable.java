package com.rivals.razzpoker;

import java.util.ArrayList;
import java.util.List;

import com.rivals.pokerengine.*;

public class RazzTable implements PokerTable {
	
	private Deck deck;
	private List<Player> players;
	public String status = "";
	
	public RazzTable(){
		deck = new Deck();
		players = new ArrayList<Player>();
	}
	
	
	public int addPlayer(Player p){
		players.add(p);
		return players.lastIndexOf(p);
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
