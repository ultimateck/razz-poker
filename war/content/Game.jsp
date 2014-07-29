<%@page import="com.rivals.razzpoker.RazzTable"%>
<%@page import="com.rivals.common.UserSession"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="true"%>
<%@ page import="com.rivals.common.Utility" %>
<!DOCTYPE html>
<html>
<base href="${pageContext.request.contextPath}/">
<link rel="stylesheet" href="media/css/reset.css" type="text/css">
<link rel="stylesheet" href="media/css/styles.css" type="text/css" />

<div class="game">
<div id="game-body">
<%  String s = "";
	UserSession us = (UserSession)session.getAttribute("us");
	if(us != null && us.table != null){
		int c = 0;
		for(int i = 0; i < 3; i++){
			s += "<div class=\"row"+ i +" row\">";
			for(int j = 0; j < 3; j++){
				s += "<div class=\"col"+ j +" cell\">";
				if(c == us.table.getPlayers().indexOf(us.player)){
					s += Utility.getPlayerDetails(us.table, c+1);
					c+=2;
					} 
				else if(i==2 && j==1){
					s += Utility.getPlayerDetails(us.table, us.table.getPlayers().indexOf(us.player));
				}
				else if(!(i==1 && (j==1 || j==2)) && !(i==2 && j==1)){
					s += Utility.getPlayerDetails(us.table, c);
					c++;
				}
				s += "</div>";
				
			}
			s += "</div>";
		}
	}
	else{
		boolean test=false;
		if(session.getAttribute("showList") != null)
			test = Boolean.parseBoolean(session.getAttribute("showList").toString());
		if(us != null && test){
			s = "<div class=\"game-list\"><ul><p>List of availabe Tables</p>";
			for(RazzTable rt : Utility.razzTables){
				s+= "<li><a href=\"javascript:Select_Table("+ Utility.razzTables.indexOf(rt) +")\">Table#" + Utility.razzTables.indexOf(rt) + "</a></li>";
			}
			s += "<ul></div>";
		}
		else{
			s = "<div class=\"game-intro\"><span>Welcome to Razz-Poker</span>" +
			"<p>Click New to Create New Game</p><p>Click Join to join Ongoing Table</p></div>";
		}
	}
	%>
	
<%= s %>
</div>
</div>
<% if(us != null && us.table != null){ %>
<div id="game-controller" class="game-controller">
<div id="ghead">
<div id="game-control-head" class="game-control-head">
	<% s = us.getUserName() + " - " + "Table#"+ us.getTableId() + " Player#"+ (us.getPlayerId()+1)+"/" + us.table.getNoOfPlayers(); %>
	<%= s %>
</div>
</div>
<div class="game-control-body">
<div class="game-control-tools">
<% if(us.isTableCreator){ %>
<button id="start" onclick="Start()">Start Game</button>
<button id="bot" onclick="Add_Bot()">Add Bot</button>
<% } %>
<input type="text"><button>Bet</button>
</div>
	<div class="game-control-status">
		<textarea rows="6" cols="50" disabled></textarea>
	</div>
</div>
</div>
<%} %>
</html>