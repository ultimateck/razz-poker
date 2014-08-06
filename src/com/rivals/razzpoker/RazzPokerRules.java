package com.rivals.razzpoker;

import java.util.List;
import java.util.Random;

import com.rivals.pokerengine.Card;
import com.rivals.pokerengine.Player;
import com.rivals.pokerengine.PokerRules;

public class RazzPokerRules implements PokerRules{
	
	public static double ante = 1.00;
	
	
	public static void Ante(RazzTable rt){
		System.out.print("Ante Started\n");
		
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
		
		if(flag == true) {
			rt.status = "thirdstreet";
			System.out.println("Ante Completed");
			resetPlayerBet(rt);
		}
		
	}
	
	public static void ThirdStreet(RazzTable rt){
		if(!rt.isBet){
			System.out.print("ThirdStreet Started\n");
			for (int i = 0; i < 3; i++) {
				rt.deal();
			}
			rt.isBet = true;
		}
		
		Bet(rt, "fourthstreet", "Third Street");
	}
	
	public static void FourthStreet(RazzTable rt){
		if(!rt.isBet){
			System.out.print("FourthStreet Started\n");
			for (int i = 0; i < 1; i++) {
				rt.deal();
			}
			rt.isBet = true;
		}
		
		Bet(rt, "fifthstreet", "Fourth Street");
	}
	
	public static void FifthStreet(RazzTable rt){
		if(!rt.isBet){
			System.out.print("FifthStreet Started\n");
			for (int i = 0; i < 1; i++) {
				rt.deal();
			}
			rt.isBet = true;
		}
		
		Bet(rt, "sixthstreet", "Fifth Street");
	}
	
	public static void SixthStreet(RazzTable rt){
		if(!rt.isBet){
			System.out.print("SixthStreet Started\n");
			for (int i = 0; i < 1; i++) {
				rt.deal();
			}
			rt.isBet = true;
		}
		
		Bet(rt, "seventhstreet", "Sixth Street");
	}
	
	public static void SeventhStreet(RazzTable rt){
		if(!rt.isBet){
			System.out.print("SeventhStreet Started\n");
			for (int i = 0; i < 1; i++) {
				rt.deal();
			}
			rt.isBet = true;
		}
		
		Bet(rt, "showdown", "Seventhth Street");
	}
	
	public static void ShowDown(RazzTable rt){
		for(Player p : rt.getPlayers()){
			SortHand(p);
		}
		
		Player win = rt.getPlayers().get(0);
		for(int i = 1; i < rt.getPlayers().size(); i++){
			if(rt.getPlayers().get(i).getHand().get(4).getUval() < win.getHand().get(4).getUval()){
				win = rt.getPlayers().get(i);
			}
		}
		rt.showFullHand = true;
		
		rt.statusList.add("Winner is: " + win.getNickName());
		for(Player p : rt.getPlayers()){p.notifications.add("Winner is: " + win.getNickName());}
		rt.status = "Winner is: " + win.getNickName();
		win.cash += rt.tableAmount;
	}
	
	public static void Bet(RazzTable rt, String nStatus, String cStatus){
		boolean flag = true;
		for(Player p : rt.getPlayers()){
			
			if(p.bet == -1) continue;
			if (p.isBot){
				int amt = new Random().nextInt(5) +1;
				rt.tableAmount += amt;
				p.cash -= amt;
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
		
		if(flag == true) {
			rt.status = nStatus;
			System.out.println(cStatus + " Completed");
			resetPlayerBet(rt);
			rt.isBet = false;
		}
	}
	
	
	public static String[] ShowHand(Player p){
		String s[] = new String[p.getHand().size()];
		for(Card c : p.getHand()){
			int i = p.getHand().indexOf(c);
			if(i==0 || i==1 || i==6)
				s[i] = "back";
			else
				s[i] = c.toString();
		}
		
		return s;
	}
	
	public static String[] ShowFullHand(Player p){
		String s[] = new String[p.getHand().size()];
		for(Card c : p.getHand()){
			int i = p.getHand().indexOf(c);
			s[i] = c.toString();
		}
		
		return s;
	}
	
	public static void resetPlayerBet(RazzTable rt){
		for (Player p : rt.getPlayers()){
			p.bet = 0;
		}
	}
	
	public static void SortHand(Player p){
		List<Card> list = p.getHand();
		for(int i = list.size()-1; i >= 0; i--) {
	        for(int j = 0; j < i; j++) {
	            if(list.get(j).getUval() > list.get(j + 1).getUval()) {
	                Card temp = list.get(j);
	                list.set(j, list.get(j + 1));
	                list.set(j + 1, temp);
	            }
	        }
	    }
	}
}
