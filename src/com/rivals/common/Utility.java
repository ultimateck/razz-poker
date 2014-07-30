package com.rivals.common;

import java.util.*;

import com.rivals.pokerengine.Player;
import com.rivals.razzpoker.*;

public class Utility {
	public static final int MAX_TABLES = 10;
	public static List<RazzTable> razzTables = new ArrayList<RazzTable>();
	public static int users = 0;
	public static int bots = 0;
	
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

}
