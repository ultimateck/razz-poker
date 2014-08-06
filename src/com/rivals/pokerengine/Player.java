package com.rivals.pokerengine;

import java.util.*;

public class Player {
	private int id;
	private String nickName;
	private List<Card> hand;
	public boolean isBot = false;
	public double cash = 50.00;
	public double bet = 0;
	public List<String> notifications;
	
	public Player(){
		hand = new ArrayList<Card>();
		notifications = new ArrayList<String>();
	}
	
	public Player(String name, int id){
		this();
		this.nickName = name;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public List<Card> getHand() {
		return hand;
	}

	public void setHand(List<Card> hand) {
		this.hand = hand;
	}
	
	public void addCardToHand(Card card){
		hand.add(card);
	}
	
	public Card getCardAt(int index) throws IndexOutOfBoundsException{
		return hand.get(index);
	}

}
