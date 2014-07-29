package com.rivals.razzpoker;

import com.rivals.pokerengine.Card;
import com.rivals.pokerengine.Player;
import com.rivals.pokerengine.PokerRules;

public class RazzPokerRules implements PokerRules{

	public static String[] ShowHand(Player p){
		String s[] = new String[p.getHand().size()];
		for(Card c : p.getHand()){
			int i = p.getHand().indexOf(c);
			if(i==0 || i==1 || i==5 || i==6)
				s[i] = "back";
			else
				s[i] = c.getFace().toString() + c.getSuit().toString();
		}
		
		return s;
	}
	
	public static String[] ShowFullHand(Player p){
		String s[] = new String[p.getHand().size()];
		for(Card c : p.getHand()){
			int i = p.getHand().indexOf(c);
			s[i] = c.getFace().toString() + c.getSuit().toString();
		}
		
		return s;
	}
}
