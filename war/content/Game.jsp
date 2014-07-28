<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="true"%>
<!DOCTYPE html>
<html>
<base href="${pageContext.request.contextPath}/">
<link rel="stylesheet" href="media/css/reset.css" type="text/css">
<link rel="stylesheet" href="media/css/styles.css" type="text/css" />

<div class="game">
<%  String s = "";
	if(session.getAttribute("us") != null){
		for(int i = 0; i < 3; i++){
			s += "<div class=\"row"+ i +" row\">";
			for(int j = 0; j < 3; j++){
				s += "<div class=\"col"+ j +" cell\"></div>";
			}
			s += "</div>";
		}
	}
	else{
		s = "<div class=\"game-intro\"><span>Welcome to Razz-Poker</span></div>";
	}
	%>
	
<%= s %>
</div>
<% if(session.getAttribute("us") != null){ %>
<div class="game-controller">
<button>Start Game</button>
<button>Add Bot</button>
<input type="text"><button>Bet</button>
</div>
<%} %>
</html>