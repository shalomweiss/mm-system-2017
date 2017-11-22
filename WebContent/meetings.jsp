<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
<style type="text/css"><%@include file="/WEB-INF/css/styles1.css"%></style>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style type="text/css">
.tbl-content {
    max-height: 50vh;
    height: 50vh;
    overflow-y: auto;
    overflow-x: hidden;
    margin-top: 0px;
    border: 1px solid rgba(255,255,255,0.3);
}
tr.selected td{
	background-color: rgba(123,31,162,0.7) !important;
	color:white !important;
} 
table tr:nth-child(4n-1), table tr:nth-child(4n)  {
    background: #ccc;
}
tr:hover td.inf{
	background-color:rgba(123,31,162,0.4);
	color: black;
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
img.mentee
{
	right:50%;
}
img.mentor
{
	right:35%;
}
.icon-bar a {
    padding: 8px;
}
td {
    padding: 8px !important;
    padding-left: 4px !important;
    height: 20%;
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
});
var prevRow;

	function show_hide_row(row,mentId,def) {
		$("#" + prevRow).toggle();
		$("#" + row).toggle();
		document.getElementById(def).click();
		prevRow=row;		
		var row1=document.getElementById(row);
		var childrenOfTheTbody=document.getElementById(row).parentNode.children;
		var numOfStams=0;
		for(i=0;i<childrenOfTheTbody.length;i++)
		{
			if(childrenOfTheTbody[i].id==row)
				break;
			if(childrenOfTheTbody[i].className=="stam")
				numOfStams++;
		}
		var heightPX=(numOfStams-1)*(childrenOfTheTbody[0].clientHeight+1);
		$( "div.tbl-content" ).scrollTop(heightPX);
	}
	function showDetails(evt, Detail) {

		var i, tabcontent, tablinks;
		tabcontent = document.getElementsByClassName("tabcontent");
		for (i = 0; i < tabcontent.length; i++) {
			tabcontent[i].style.display = "none";
		}
		tablinks = document.getElementsByClassName("tablinks");
		for (i = 0; i < tablinks.length; i++) {
			tablinks[i].className = tablinks[i].className
					.replace(" active", "");
		}
		document.getElementById(Detail).style.display = "block";
		evt.currentTarget.className += " active";
	}
	function closeRow(row,mentId) {
		//hide the row
		$("#" + row).toggle();
		prevRow=null;		
	}
	</script>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
</head>
<body>
<nav class="icon-bar">
	<div class="icon-bar">
	 <a  href="GetAllPairs" title="Back"><i class="fa fa-arrow-circle-left"></i></a> 
		  <a title="Home" href="ForwardPath"><i class="fa fa-home"></i></a> 
		  <a href="GetAllMentors" title="Mentors"><i class="fa fa-black-tie"></i></a> 
		  <a href="GetAllMentees" title="Mentees"><i class="fa fa-graduation-cap"></i></a> 
		  <a class="active" href="GetAllPairs" title="Pairs"><i class="fa fa-group"></i></a>
		  <a href="GetAllAcademicInstitution" title="Reports"><i class="fa fa-clipboard"></i></a>
		  <a href="AddingDataServlet" title="AddingStuff"><i class="fa fa-cogs"></i></a>
		  <a onclick="logout()" href="#" title="Logout"><i class="fa glyphicon">&#xe163;</i></a>	  
	</div>
</nav>

<div class="menteeMeetings nameTags">
	<h2>mentee</h2>
	<img class="nameTag" src="DownloadFile?img=${Pairs.getPair().getMentee().id}" alt="profilePic">
	<p class="nameTag"> 
		${Pairs.getPair().getMentee().firstName} ${Pairs.getPair().getMentee().lastName} <br>
	 	${Pairs.getPair().getMentee().phoneNumber}
	 </p>
</div>
<div class="mentorMeetings nameTags">
	<h2 class="mentor">mentor</h2>
	<img class="nameTag" alt="profilePic" src="DownloadFile?img=${Pairs.getPair().getMentor().id}">
	<p class="nameTag"> 
		${Pairs.getPair().getMentor().firstName} ${Pairs.getPair().getMentor().lastName} <br>
	 	${Pairs.getPair().getMentor().phoneNumber}
	 </p>
</div>



<div class="topPart"> </div>
	<div class="bottomPart"> </div><div class="inner">
<section>
  <!--for demo wrap--> 
  <div class="tbl-header-meeting">
    <table cellpadding="0" cellspacing="0" border="0">
      <thead>
        <tr>
          <th>Meeting Date</th>
          <th>Location</th>
          <th>Type</th>
          <th>subject</th>
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
          <td class="inf">
          	<fmt:formatDate value="${meeting.dateMeeting}" var="formattedDate" 
                type="date" pattern="MM-dd-yyyy" />
				${formattedDate}
          </td>
			<td class="inf">${meeting.location}</td>
			<td class="inf">${meeting.meetingType}</td>
			<td class="inf"><c:out value="${meeting.subject}"></c:out></td>	
			<td class="inf"><c:out value="${meeting.status}"></c:out></td>	
        </tr>
	    <tr id="hidden_row${meeting.meetingId}" class="hidden_row">
			<td colspan=5>
				<div class="tab tabMeeting">
					<button class="tablinks1 tablinks " id="defultOpen${meeting.meetingId}"
						onclick="showDetails(event, 'info${meeting.meetingId}')" style="z-index:5; margin-left: 0px;">Info</button>
					<button class="tablinks tablinks1" style="float: right; background-color: rgba(133,41,172,0.9);"
						onclick="closeRow('hidden_row${meeting.meetingId}',${meeting.meetingId});" >Close</button>
				</div>
				<div id="info${meeting.meetingId}" class="tabcontent" style="background-color: rgba(123,31,162,0.7);">
				<table>
					<tbody class="meeting">
						<tr >									
							<th style="color:black;">Mentor's Review:</th> 
							<th style="color:black;">Mentee's Review:</th>  
							<th style="color:black;">Mentor's Review to Tsofen member:</th>  
							<th style="color:black;">Mentee's Review to Tsofen member:</th>
							<th style="color:black; min-height:77px;">Location</th>
						 </tr>
						 <tr>
							 <td style="padding-bottom: 17px !important;"><c:out value="${meeting.mentorReport}"></c:out></td>
							 <td style="padding-bottom: 17px !important;"><c:out value="${meeting.menteeReport}"></c:out></td>
							 <td style="padding-bottom: 17px !important;"><c:out value="${meeting.mentorPrivateReport}"></c:out></td>
							 <td style="padding-bottom: 17px !important;"><c:out value="${meeting.menteePrivateReport}"></c:out></td>
							 <td style="padding-bottom: 17px !important;"><c:out value="${meeting.location}"></c:out></td>
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
  