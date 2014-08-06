package com.rivals.common;

import java.util.*;

import com.rivals.pokerengine.Card;
import com.rivals.pokerengine.Player;
import com.rivals.razzpoker.*;

public class Utility {
	public static final int MAX_TABLES = 10;
	public static List<RazzTable> razzTables = new ArrayList<RazzTable>();
	public static int users = 0;
	public static int bots = 0;
	
	public static Map<String,String> cardsMap = new HashMap<String,String>();
	static{
		cardsMap.put("ACE-Club", "ac.gif"); cardsMap.put("ACE-Diamond", "ad.gif"); cardsMap.put("ACE-Heart", "ah.gif"); cardsMap.put("ACE-Spade", "as.gif");
		cardsMap.put("TWO-Club", "2c.gif"); cardsMap.put("TWO-Diamond", "2d.gif"); cardsMap.put("TWO-Heart", "2h.gif"); cardsMap.put("TWO-Spade", "2s.gif");
		cardsMap.put("THREE-Club", "3c.gif"); cardsMap.put("THREE-Diamond", "3d.gif"); cardsMap.put("THREE-Heart", "3h.gif"); cardsMap.put("THREE-Spade", "3s.gif");
		cardsMap.put("FOUR-Club", "4c.gif"); cardsMap.put("FOUR-Diamond", "4d.gif"); cardsMap.put("FOUR-Heart", "4h.gif"); cardsMap.put("FOUR-Spade", "4s.gif");
		cardsMap.put("FIVE-Club", "5c.gif"); cardsMap.put("FIVE-Diamond", "5d.gif"); cardsMap.put("FIVE-Heart", "5h.gif"); cardsMap.put("FIVE-Spade", "5s.gif");
		cardsMap.put("SIX-Club", "6c.gif"); cardsMap.put("SIX-Diamond", "6d.gif"); cardsMap.put("SIX-Heart", "6h.gif"); cardsMap.put("SIX-Spade", "6s.gif");
		cardsMap.put("SEVEN-Club", "7c.gif"); cardsMap.put("SEVEN-Diamond", "7d.gif"); cardsMap.put("SEVEN-Heart", "7h.gif"); cardsMap.put("SEVEN-Spade", "7s.gif");
		cardsMap.put("EIGHT-Club", "8c.gif"); cardsMap.put("EIGHT-Diamond", "8d.gif"); cardsMap.put("EIGHT-Heart", "8h.gif"); cardsMap.put("EIGHT-Spade", "8s.gif");
		cardsMap.put("NINE-Club", "9c.gif"); cardsMap.put("NINE-Diamond", "9d.gif"); cardsMap.put("NINE-Heart", "9h.gif"); cardsMap.put("NINE-Spade", "9s.gif");
		cardsMap.put("TEN-Club", "tc.gif"); cardsMap.put("TEN-Diamond", "td.gif"); cardsMap.put("TEN-Heart", "th.gif"); cardsMap.put("TEN-Spade", "ts.gif");
		cardsMap.put("JACK-Club", "jc.gif"); cardsMap.put("JACK-Diamond", "jd.gif"); cardsMap.put("JACK-Heart", "jh.gif"); cardsMap.put("JACK-Spade", "js.gif");
		cardsMap.put("QUEEN-Club", "qc.gif"); cardsMap.put("QUEEN-Diamond", "qd.gif"); cardsMap.put("QUEEN-Heart", "qh.gif"); cardsMap.put("QUEEN-Spade", "qs.gif");
		cardsMap.put("KING-Club", "kc.gif"); cardsMap.put("KING-Diamond", "kd.gif"); cardsMap.put("KING-Heart", "kh.gif"); cardsMap.put("KING-Spade", "ks.gif");
		cardsMap.put("back", "back.png");
	}
	
	public static int addTable(RazzTable rt){
		razzTables.add(rt);
		return razzTables.indexOf(rt);
	}
	
	public static String getPlayerDetails(RazzTable rt, int index){
		String out = null;
		try{
			Player p = rt.getPlayers().get(index);
			out = "<div class=\"player player"+ index +"\"><p>"+ p.getNickName() +" <span> Cash: " + p.cash +"</span></p>";
			out += "<div>";
			if(p.isBot){out += "<img src=\"media/images/players/bot1.png\">";}
			else{out += "<img src=\"media/images/players/player" + (index + 1)+".png\">";}
			if(!rt.showFullHand){
				for(String c : RazzPokerRules.ShowHand(p)){
					out += "<div class=\"cards\"><img src=\"media/images/cards/" + cardsMap.get(c) + "\"></div>";
				}
			}
			else{
				for(String c : RazzPokerRules.ShowFullHand(p)){
					out += "<div class=\"cards\"><img src=\"media/images/cards/" + cardsMap.get(c) + "\"></div>";
				}
			}
			out += "</div></div>";
		}catch(Exception ex){
			out = "<div class=\"player\"><p>Empty</p></div>";
		}
		return out;
	}
	
	public static String getTableStatus(RazzTable rt){
		String out = null;
		out = "<div class=\"table-state\">";
		out += rt.status + "</div>";
		return out;
	}
	
	public static void addPlayerNotifications(RazzTable rt, String note){
		for(Player p : rt.getPlayers()){
			p.notifications.add(note);
		}
	}
	
	
	public static String getPlayerNotifications(Player p){
		String out = "";
		for(String note : p.notifications){
			out += note;
			if(!(p.notifications.indexOf(note) == p.notifications.size()-1)) out += "\n";
		}
		p.notifications.clear();
		return out;
	}

}
