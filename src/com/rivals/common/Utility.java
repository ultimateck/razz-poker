package com.rivals.common;

import java.util.*;
import com.rivals.razzpoker.*;

public class Utility {
	public static final int MAX_TABLES = 10;
	public static List<RazzTable> razzTables = new ArrayList<RazzTable>();
	public static int users = 0;
	
	public static int addTable(RazzTable rt){
		razzTables.add(rt);
		return razzTables.indexOf(rt);
	}

}
