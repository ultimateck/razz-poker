package com.rivals.razzpoker;

import com.rivals.pokerengine.Card;
import com.rivals.pokerengine.Player;
import com.rivals.pokerengine.PokerRules;

public class RazzPokerRules implements PokerRules{
	
	public static double ante = 1.00;
	
	
	public static void Ante(RazzTable rt){
		System.out.print("Ante Started");
		while (true){
			boolean flag = true;
			for(Player p : rt.getPlayers()){
				
				if(p.bet == -1) continue;
				if (p.isBot){
					rt.tableAmount += ante;
					p.cash -= ante;
					p.bet = -1;
				}
				
				if(p.bet > 0){
					rt.tableAmount += p.bet;
					p.cash -= p.bet;
					p.bet = -1;
				}
			}
			
			for(Player p : rt.getPlayers()){
				if (p.bet != -1) {flag = false;}
			}
			
			if(flag == true) break;
		}
	}
	
	public static void ThirdStreet(){
		
	}
	
	public static void FourthStreet(){
		
	}
	
	public static void FifthStreet(){
		
	}
	
	public static void SixthStreet(){
		
	}
	
	public static void SeventhStreet(){
		
	}
	
	public static void ShowDown(){
		
	}
	
	
	public static String[] ShowHand(Player p){
		String s[] = new String[p.getHand().size()];
		for(Card c : p.getHand()){
			int i = p.getHand().indexOf(c);
			if(i==0 || i==1 || i==6)
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
	
	public static void resetPlayerBet(RazzTable rt){
		for (Player p : rt.getPlayers()){
			p.bet = 0;
		}
	}
}
