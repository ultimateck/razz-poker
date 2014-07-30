<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.request.contextPath}/">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="media/css/jquery.toastmessage.css" type="text/css">
<script type="text/javascript" src="media/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="media/js/jquery.toastmessage.js"></script>
<script type="text/javascript">
function Load_Content()
{
	//$(".game").load("content/Game.jsp #game-body");
    $("#ghead").load("content/Game.jsp #game-control-head").hide().fadeIn(3000);
}
setInterval('Load_Content()', 10000);
function Select_Table(id){
	$.ajax({
		type : "get",
		url : "game?table=" + id,
				
		 success : function(responseText) {
			 $(".game-container").load("content/Game.jsp");
             $(".game-container").scrollView();
             $().toastmessage('showSuccessToast', responseText);
		 },
		 error : function(xhr, ajaxOptions, thrownError) {
			 $().toastmessage('showErrorToast', thrownError);
		 }
	});
}
function Add_Bot(){
        $.ajax({
            type : "get",
            url : "game?bot=true",

            success : function(responseText) {

                $(".game-container").load("content/Game.jsp");
                $().toastmessage('showSuccessToast', responseText);
            },
            error : function(xhr, ajaxOptions, thrownError) {
            	$().toastmessage('showErrorToast', thrownError);
            }

        });
}
function Start(){
    $.ajax({
        type : "get",
        url : "game?start=true",

        success : function(responseText) {

            $(".game-container").load("content/Game.jsp");
            $().toastmessage('showSuccessToast', responseText);
            $('#start').attr("disabled", true);
            $('#start').html("Started");
        },
        error : function(xhr, ajaxOptions, thrownError) {
        	$().toastmessage('showErrorToast', thrownError);
        }

    });
}

function Make_Bet(){
	alert($("#txtBet").val());
    $.ajax({
        type : "get",
        url : "game?bet=" + $("#txtBet").val(),

        success : function(responseText) {

            $(".game-container").load("content/Game.jsp");
            $().toastmessage('showSuccessToast', responseText);
            $("#txtBet").val("");
        },
        error : function(xhr, ajaxOptions, thrownError) {
        	$().toastmessage('showErrorToast', thrownError);
        }

    });
}

</script>
<script>
$(document).ready(function() {
	$(".game-container").load("content/Game.jsp");
    $('#new').click(function(){

        $.ajax({
            type : "get",
            url : "game?mode=new",

            success : function(responseText) {

                $(".game-container").load("content/Game.jsp");
                $('#start').html(responseText);
                $(".game-container").scrollView();
                $().toastmessage('showSuccessToast', responseText);
            },
            error : function(xhr, ajaxOptions, thrownError) {
                alert(xhr.status);
                alert(thrownError);
            }

        });
    });
    
    $('#join').click(function(){

        $.ajax({
            type : "get",
            url : "game?mode=join",

            success : function(responseText) {

                $(".game-container").load("content/Game.jsp");
                $().toastmessage('showSuccessToast', responseText);
            },
            error : function(xhr, ajaxOptions, thrownError) {
            	$().toastmessage('showErrorToast', thrownError);
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
			<div id ="new" class="btn-top color-green"><span class="icon-new-w"></span><span>New</span></div>
			<div id="join" class="btn-top color-gray"><span class="icon-join-w"></span><span>Join</span></div>
			<div class="btn-top color-green"><span class="icon-leave-w"></span><span>Leave</span></div>
			<div class="btn-top color-gray"><span class="icon-more-w"></span><span>More</span></div>
			</div>
			
			<div class="game-container">
				
			</div>
		</div>
	</div>
</div>
</body>
</html>