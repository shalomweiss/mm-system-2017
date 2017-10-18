<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<style type="text/css"><%@include file="/WEB-INF/css/styles.css"%></style>

<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style type="text/css">
tr.selected td{
	background-color: rgba(123,31,162,0.7) !important;
	color:white !important;
} 
table tr:nth-child(4n-1), table tr:nth-child(4n)  {
    background: #ccc;
}
tr:hover td.inf{
	background-color:rgba(123,31,162,0.7);
	color: white;
}
h1.left
{
	left:8%;
	width:40%;
	right: 55% !important;
	
}
h1.right
{
	    width: 40%;
    /* right: 5% !important; */
    left: 60%;
}
img{
	width:10%;
	height:16%;
	z-index: 9;
	position: fixed;
	top:7%;
	border-radius: 50%;
}
img.mentee
{
	right:50%;
}
img.mentor
{
	right:35%;
}
</style>
<script type="text/javascript">
$(document).ready(function(){

	 $(".button-fill").hover(
  		  function() {
  			    $(this).children(".button-inside").addClass("full");
  			  },
  			  function() {
  			    $(this).children(".button-inside").removeClass("full");
  			  }
  			);
	
});
function goBack() {
   window.history.back();
}
function  getId(note1,note2,note3,note4) {

	document.getElementById("note1").innerHTML=note1;
	document.getElementById("note2").innerHTML=note2;
	document.getElementById("note3").innerHTML=note3;
	document.getElementById("note4").innerHTML=note4;
}
$(document).ready(function(){
	$(".stam").click(function() {
	    $(this).addClass('selected').siblings().removeClass("selected");
	});
});
var prevRow;

	function show_hide_row(row,mentId,def) {
		console.log(def);
		$("#" + prevRow).toggle();
		$("#" + row).toggle();
		document.getElementById(def).click();
		prevRow=row;
		
		for(var i=1;i<=13;i++)  //length of inputs
		{
		showStuff("input"+i+mentId,"div"+i+mentId);
		}
	backUpInputs(mentId);

	}
	function closeRow(row,mentId) {
		//hide the row
		$("#" + row).toggle();
		prevRow=null;
		
		for(var i=1;i<=13;i++)  //length of inputs
			{
			showStuff("input"+i+mentId,"div"+i+mentId);
			}
		backUpInputs(mentId);
		
	}
	function backUpInputs(mentId){
		
		for(var i=1;i<=13;i++)  //length of inputs
		{
			document.getElementById("input"+i+mentId).value =document.getElementById("div"+i+mentId).innerHTML;
		}
		
		
	}
	</script>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
</head>
<body>
<nav class="icon-bar">
<div class="icon-bar">
		  <a  href="GetAllPairs" title="Back"><i class="fa fa-arrow-circle-left"></i></a> 
		  <a  href="ForwardPath" title="Home"><i class="fa fa-home"></i></a> 
		  <a href="GetAllMentors" title="Mentors"><i class="fa fa-black-tie"></i></a> 
		  <a href="GetAllMentees"title="Mentees"><i class="fa fa-graduation-cap"></i></a> 
		  <a class="active" href="GetAllPairs" title="Pairs"><i class="fa fa-group"></i></a>
		  <a href="#"><i class="fa fa-bell" title="Notifications"></i></a>
		  <a href="#" title="Reports"><i class="fa fa-clipboard"></i></a>	
		  <a href="#" title="Logout"><i class="fa glyphicon">&#xe163;</i></a>
	</div>
</nav>
<h1 class="right">
Mentor: <br>
 <c:out value="${Pairs.getPair().getMentor().firstName}"></c:out>
		 <c:out value="${Pairs.getPair().getMentor().lastName}"></c:out><br> 
	 <c:out value="${Pairs.getPair().getMentor().phoneNumber}"></c:out>
	 </h1>
	 <img class="mentee" alt="harry" src="https://images.pottermore.com/bxd3o8b291gf/3SQ3X2km8wkQIsQWa02yOY/25f258f21bdbe5f552a4419bb775f4f0/HarryPotter_WB_F4_HarryPotterMidshot_Promo_080615_Port.jpg?w=1200">
	<img class="mentor" alt="harry" src="https://typeset-beta.imgix.net/rehost%2F2016%2F9%2F13%2Fbf4612d7-e76a-4f3c-8cb8-f2486b5d15b4.jpg">
<h1 class="left">
Mentee: <br>
		 <c:out value="${Pairs.getPair().getMentee().firstName}"></c:out>
		  <c:out value="${Pairs.getPair().getMentee().lastName}"></c:out><br>
	 <c:out  value="${Pairs.getPair().getMentee().phoneNumber}"></c:out>
</h1>
<div class="topPart"> </div>
	<div class="bottomPart"> </div><div class="inner">
<section>
  <!--for demo wrap--> 
  <div class="tbl-header-meeting">
    <table cellpadding="0" cellspacing="0" border="0">
      <thead>
        <tr>
          <th>Date</th>
          <th>Location</th>
          <th>Meeting Type</th>
          <th>Meeting subject</th>
          <th>Active Status</th>
        </tr>
      </thead>
    </table>
  </div>
  <div class="tbl-content">
    <table cellpadding="0" cellspacing="0" border="0">
      <tbody>
      <c:forEach var="meeting" items="${meetings}" >
        <tr class="stam" onclick="show_hide_row('hidden_row${meeting.meetingId}',${meeting.meetingId},'defultOpen${meeting.meetingId}');">
          <td class="inf"><c:out value="${meeting.date}"></c:out></td>
			<td class="inf"><c:out value="${meeting.location}"></c:out></td>
			<td class="inf"><c:out value="${meeting.meetingType}"></c:out></td>
			<td class="inf"><c:out value="${meeting.subject}"></c:out></td>	
			<td class="inf"><c:out value="${meeting.status}"></c:out></td>	
        </tr>
        
	    <tr id="hidden_row${meeting.meetingId}" class="hidden_row">
	    <td colspan=5>
	    
        	<div class="tab">
		<table>
		<tbody class="meeting">
			<tr>									
		        <th>Mentor's Review:</th> 
		        <th>Mentee's Review:</th>  
		        <th>Mentor's Review to Tsofen member:</th>  
		        <th>Mentee's Review to Tsofen member:</th>
	         </tr>
	         <tr>
		         <td><c:out value="${meeting.mentorReport}"></c:out></td>
		         <td><c:out value="${meeting.menteeReport}"></c:out></td>
		         <td><c:out value="${meeting.mentorPrivateReport}"></c:out></td>
		         <td><c:out value="${meeting.menteePrivateReport}"></c:out></td>
	         </tr>
			</tbody>
		
   </table>
        </div>
        </td>
        </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>
  
  </section>
  </div>
  </body>
  </html>
  