<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<base href="${pageContext.request.contextPath}/">
<link rel="stylesheet" href="media/css/reset.css" type="text/css">
<link rel="stylesheet" href="media/css/styles.css" type="text/css" />

<div class="game">
<%  String s = "";
	for(int i = 0; i < 3; i++){
		s += "<div class=\"row"+ i +"\">";
		for(int j = 0; j < 4; j++){
			s += "<div class=\"col"+ j +" cell\"></div>";
		}
		s += "</div>";
	}
	%>
	
<%= s %>
</div>
</html>