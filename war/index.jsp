<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.request.contextPath}/">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<script type="text/javascript" src="media/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
function myFunction() {
    document.getElementById("demo").innerHTML = Date();
}
</script>
<script>
$(document).ready(function() {
	$(".game-container").load("content/Game.jsp");
    $('#start').click(function(){

        $.ajax({
            type : "get",
            url : "game",

            success : function(responseText) {

                $(".game-container").load("content/Game.jsp");
                $('#start').html(responseText);
                $(".game-container").scrollView();
            },
            error : function(xhr, ajaxOptions, thrownError) {
                alert(xhr.status);
                alert(thrownError);
            }

        });
    });
    
    $.fn.scrollView = function () {
        return this.each(function () {
            $('html, body').animate({
                scrollTop: $(this).offset().top
            }, 1000);
        });
    };

});
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
			<div id ="start" class="btn-top color-green"><p id="demo">Hello</p></div>
			<div class="btn-top color-gray"></div>
			<div class="btn-top color-green"></div>
			<div class="btn-top color-gray"></div>
			</div>
			
			<div class="game-container">
				
			</div>
		</div>
	</div>
</div>
</body>
</html>