<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1">

<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style type="text/css"><%@include file="/WEB-INF/css/styles.css"%></style>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<style type="text/css">tr:nth-child(even){background-color: #ccc !important}</style>
<script>
$(document).ready(function(){
	$(".disB").click(function(){
		console.log($(this).attr('id'));
		$.post("DisconnectPair",
		        {
		          pairId: $(this).attr('id'),
		        },
		        function(data,status){
		        	//if data is -1 something is wrong
		            $("#"+data).parent().parent().remove();
		        });
	});
	 $(".button-fill").hover(
   		  function() {
   			    $(this).children(".button-inside").addClass("full");
   			  },
   			  function() {
   			    $(this).children(".button-inside").removeClass("full");
   			  }
   			);
});
</script>
<style>
.icon-bar a {
       padding: 8px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
</head>
<body>
<nav class="icon-bar">
	<div class="icon-bar">
		  <a title="Home" href="ForwardPath"><i class="fa fa-home"></i></a> 
		  <a href="GetAllMentors" title="Mentors"><i class="fa fa-black-tie"></i></a> 
		  <a href="GetAllMentees" title="Mentees"><i class="fa fa-graduation-cap"></i></a> 
		  <a class="active" href="GetAllPairs" title="Pairs"><i class="fa fa-group"></i></a>
		  <a href="GetAllAcademicInstitution" title="Reports"><i class="fa fa-clipboard"></i></a>
		  <a href="AddingDataServlet" title="AddingStuff"><i class="fa fa-cogs"></i></a>
		  <a onclick="logout()" href="#" title="Logout"><i class="fa glyphicon">&#xe163;</i></a>	  
	</div>
</nav>
	<h1>Pairs</h1>
	<div class="topPart"> </div>
	<div class="bottomPart"> </div>
	<div class="inner">
		<section class="Pairs">
  <!--for demo wrap--> 
  <div class="tbl-header">
    <table cellpadding="0" cellspacing="0" border="0">
      <thead>
       <tr>
          <th>Mentor</th>
          <th></th>
          <th></th>
          <th>Mentee</th>
        </tr>
        <tr>
          <th class="mentor">Name</th>
          <th class="mentor">Phone</th>
          <th class="mentor">Workplace</th>
          <th class="mentee">Name</th>
          <th class="mentee">Phone</th>
          <th class="mentee">Academy</th>
          <th >Actions</th>
        </tr>
      </thead>
    </table>
  </div>
  <div class="tbl-content">
    <table cellpadding="0" cellspacing="0" border="0">
      <tbody>
   <c:forEach var="pair" items="${pairs}" >
        <tr>
        	<td id="mentor">${pair.mentor.firstName} ${pair.mentor.lastName}</td>
        	<td id="mentorPhone">${pair.mentor.phoneNumber}</td>
			<td id="mentee"><c:out value="${pair.mentor.company}"></c:out></td>
			<td id="mentor">${pair.mentee.firstName} ${pair.mentee.lastName}</td>
        	<td id="mentorPhone">${pair.mentee.phoneNumber}</td>
			<td id="mentee"><c:out value="${pair.mentee.academiclnstitution}"></c:out></td>
          	<td class="but"> 
          		<a class="btn btn-block btn-primary topButton" href="GetMeetingByPairId?id=${pair.pairId}" style="margin-top: 0px;" >
			 		Meetings
    			</a>  <br>
          		<a class="btn btn-block btn-primary disB" id="${pair.pairId}" style="margin-top: 0px;" >
  					Disconnect
   				</a>
    		</td>
        </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>
</section>
<a class="btn btn-block btn-primary .btn-click btn-addClick" href="GetMentorsAndMentees"> <i class="fa fa-plus"></i><i class="fa fa-group"></i> New Pair </a>
 </div>

 </body>
</html> 