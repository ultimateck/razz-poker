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
<%  String s = "";
	UserSession us = (UserSession)session.getAttribute("us");
	if(us != null && us.table != null){
		for(int i = 0; i < 3; i++){
			s += "<div class=\"row"+ i +" row\">";
			for(int j = 0; j < 3; j++){
				s += "<div class=\"col"+ j +" cell\"></div>";
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
				s+= "<li><a href=\"javascript:\">Table#" + Utility.razzTables.indexOf(rt) + "</a></li>";
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
<% if(us != null && us.table != null){ %>
<div id="game-controller" class="game-controller">
<div class="game-control-head"></div>
<div class="game-control-body">
<div class="game-control-tools">
<button>Start Game</button>
<button>Add Bot</button>
<input type="text"><button>Bet</button>
</div>
	<div class="game-control-status">
		<datalist></datalist>
	</div>
</div>
</div>
<%} %>
</html>