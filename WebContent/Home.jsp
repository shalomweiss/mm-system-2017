<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style type="text/css"><%@include file="/WEB-INF/css/styles.css"%></style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">

<script>
	function logout(){
		localStorage.removeItem("TsofenKey");
		window.location.replace("/LoginWeb");
	}
</script>
<style type="text/css">
.icon-bar a {
    display: block;
    text-align: center;
    padding: 19px;
    transition: all 0.3s ease;
    color: white;
    font-size: 36px;
}

</style>
</head>
<body>
<!-- 
<c:choose>
    <c:when test="${empty isNotEntered}">
         <script>
         	if (localStorage.getItem("TsofenKey") === null) {
					window.location.replace("/LoginWeb");
				}
         </script>
    </c:when   > 
    <c:when test="${isNotEntered=='0'}">
    		<script>
    		if (localStorage.getItem("TsofenKey") === null) {
					window.location.replace("/LoginWeb");
				}
    		</script>
    </c:when>
    <c:otherwise>
    	<script>
    		localStorage.setItem("TsofenKey", "TsofenKey");
    	</script>
    </c:otherwise>
</c:choose>
 -->

<nav class="icon-bar">
	<div class="icon-bar">
		  <a class="active" title="Home" href="ForwardPath"><i class="fa fa-home"></i></a> 
		  <a href="GetAllMentors" title="Mentors"><i class="fa fa-black-tie"></i></a> 
		  <a href="GetAllMentees" title="Mentees"><i class="fa fa-graduation-cap"></i></a> 
		  <a href="GetAllPairs" title="Pairs"><i class="fa fa-group"></i></a>
		  <a href="GetAllAcademicInstitution" title="Reports"><i class="fa fa-clipboard"></i></a>
		  <a href="AddingDataServlet" title="AddingStuff"><i class="fa fa-cogs"></i></a>
		  <a onclick="logout()" href="#" title="Logout"><i class="fa glyphicon">&#xe163;</i></a>	  
	</div>
</nav>
	<div class="topPart"> </div>
	<div class="bottomPart"> </div>
	<img class="tsofen" src="DownloadFile?logo=MP-LOGO-10.png" alt="W3Schools.com">
</body>
</html> 
