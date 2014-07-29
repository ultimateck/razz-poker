package com.rivals.common;

import java.util.*;

import com.rivals.pokerengine.Player;
import com.rivals.razzpoker.*;

public class Utility {
	public static final int MAX_TABLES = 10;
	public static List<RazzTable> razzTables = new ArrayList<RazzTable>();
	public static int users = 0;
	
	public static int addTable(RazzTable rt){
		razzTables.add(rt);
		return razzTables.indexOf(rt);
	}
	
	public static String getPlayerDetails(RazzTable rt, int index){
		String out = null;
		try{
			Player p = rt.getPlayers().get(index);
			out = "<div class\"player\"><p>"+ p.getNickName() +"</p></div>";
		}catch(Exception ex){
			out = "<p>Empty</p>";
		}
		return out;
	}

}
