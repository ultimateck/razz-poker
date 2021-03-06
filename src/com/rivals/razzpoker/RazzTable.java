package com.rivals.razzpoker;

import java.util.ArrayList;
import java.util.List;

import com.rivals.pokerengine.*;

public class RazzTable implements PokerTable {
	
	private Deck deck;
	private List<Player> players;
	public double tableAmount = 0;
	public boolean isStarted = false;
	public String status = "";
	public List<String> statusList;
	public long actionStart;
	public long actionLength;
	public boolean isBet = false;
	public boolean showFullHand = false;
	
	public RazzTable(){
		deck = new Deck();
		players = new ArrayList<Player>();
		statusList = new ArrayList<String>();
	}
		
	/**
	 * @return the players
	 */
	public List<Player> getPlayers() {
		return players;
	}

	/**
	 * @param players the players to set
	 */
	public void setPlayers(List<Player> players) {
		this.players = players;
	}


	public int addPlayer(Player p){
		players.add(p);
		return players.lastIndexOf(p);
	}

	@Override
	public void deal() {
		for (Player p : players){
			p.addCardToHand(deck.getCard());
		}
		
	}

	@Override
	public void shuffel() {
		deck.shuffleDeck();
	}
	
	public int getNoOfPlayers(){
		return players.size();
	}
	
	public void Start(){
		System.out.println("Game Started");
		status = "ante";
		isStarted = true;
		statusList.add("Game Started");
		shuffel();
		statusList.add("Deck Shuffeled !");
		status = "ante";
		RazzPokerRules.Ante(this);
	}
	
	public void Switch_Actions(){
		switch (status) {
		case "ante": RazzPokerRules.Ante(this);
			break;
		case "thirdstreet": RazzPokerRules.ThirdStreet(this);
		break;
		
		case "fourthstreet": RazzPokerRules.FourthStreet(this);
		break;
		
		case "fifthstreet": RazzPokerRules.FifthStreet(this);
		break;
		
		case "sixthstreet": RazzPokerRules.SixthStreet(this);
		break;
		
		case "seventhstreet": RazzPokerRules.SeventhStreet(this);
		break;
		
		case "showdown": RazzPokerRules.ShowDown(this);
		break;

		default:
			break;
		}
	}

}
