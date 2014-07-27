<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<script type="text/javascript">
function myFunction() {
    document.getElementById("demo").innerHTML = Date();
}
</script>
</head>
<body>
<jsp:include page="content/Head.jsp"></jsp:include>
<div class="space"></div>
<jsp:include page="content/Banner.jsp"></jsp:include>

<div class="body">
	<div class="wrap">
		<div class="content">
			<div class="btn-top-container">
			<div class="btn-top color-green" onclick="myFunction()"><p id="demo">Hello</p></div>
			<div class="btn-top color-gray"></div>
			<div class="btn-top color-green"></div>
			<div class="btn-top color-gray"></div>
			</div>
			<p>Hello World Test !</p>
			<p>Servlet to JSP Dispatcher</p>
			<div class="game-container">
				<jsp:include page="content/Game.jsp"></jsp:include>
			</div>
		</div>
	</div>
</div>
</body>
</html>