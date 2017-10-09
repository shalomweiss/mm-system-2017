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
<head>
<script>

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
</script>
<script>

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
</script>
<script type="text/javascript">

var prevRow;

	function show_hide_row(row,mentId,def) {
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
<style>


h1{
    font-size: 37px;
  letter-spacing: 8px;
  text-shadow: 2px 4px 4px #CCCCCC;
  color: #fff;
  text-transform: uppercase;
  font-weight: 300;
  text-align: center;
  margin-bottom: 15px;
  position: absolute;
	top:5%;
	right:0;
	left:90px;
}
h4{
  font-size: 40px;
  text-shadow: 2px 4px 4px #CCCCCC;
  color: #fff;
  text-transform: uppercase;
  font-weight: 100;
  text-align: center;
  margin-bottom: 10px;
}
table{
  width:100%;
  table-layout: fixed;
}
.tbl-header{
  background-color: rgba(255,255,255,0.3);
 }
.tbl-content{
  height:300px;
  overflow-x:auto;
  margin-top: 0px;
  border: 1px solid rgba(255,255,255,0.3);
}
th{
  padding: 20px 15px;
  text-align: center;
  font-weight: 500;
  font-size: 14px;
  color: black;
  text-transform: uppercase;
  word-wrap: break-word;
}
td{
  padding: 15px;
  text-align: center;
  vertical-align:middle;
  font-weight: 300;
  font-size: 14px;
  color: #black;
  border-bottom: solid 1px rgba(255,255,255,0.1);
  border-right: solid 1px rgba(255,255,255,0.3);
  word-wrap: break-word;
}


/* demo styles */

@import url(https://fonts.googleapis.com/css?family=Roboto:400,500,300,700);
body{
  background: -webkit-linear-gradient(left, #25c481, #25b7c4);
  background: linear-gradient(to right, #25c481, #25b7c4);
  font-family: 'Century Gothic', sans-serif;
}
section{
  top:0;
  margin-top: 150px; 
  margin-bottom: 50px;
  margin-left: 100px;
  margin-right: 10px;

}


/* follow me template */
.made-with-love {
  margin-top: 40px;
  padding: 10px;
  clear: left;
  text-align: center;
  font-size: 10px;
  font-family: arial;
  color: #fff;
}
.made-with-love i {
  font-style: normal;
  color: #F50057;
  font-size: 14px;
  position: relative;
  top: 2px;
}
.made-with-love a {
  color: #fff;
  text-decoration: none;
}
.made-with-love a:hover {
  text-decoration: underline;
}


/* for custom scrollbar for webkit browser*/

::-webkit-scrollbar {
    width: 6px;
} 
::-webkit-scrollbar-track {
    -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3); 
} 
::-webkit-scrollbar-thumb {
    -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3); 
}

body {
	top:0;
	margin:0
}

.icon-bar {
	top:30vh;
    width: 90px;
    background-color: #555;
}
.icon-bar a {
    display: block;
    text-align: center;
    padding: 16px;
    transition: all 0.3s ease;
    color: white;
    font-size: 36px;
}

.icon-bar a:hover {
    background-color: #000;
}

.active {
    background-color: #25c481 !important;
}
i{
margin-right:2px;
}
body{

	background-color: #cfd9df;
	height:100%;
}
html{
	
	height:100%;
}
nav.icon-bar{
	top:0;
	position:fixed;
	height:100%;
	background-color: #555;
}
div.icon-bar{
    margin-left: auto;
    margin-right: auto; 
	display: table-cell;
    vertical-align: middle;
	position:fixed;
	top: calc((100% - 490px) / 2);
	bottom:0;
}
h1{

	top:5%;
	right:0;
	left:90px;
}
button{
outline: none !important;
}
.btn-primary, .btn-primary:hover, .btn-primary:active, .btn-primary:visited,.btn-primary:focus {
    background-color: #67d2bc !important;
	border-color: #67d2bc !important;
	outline: none !important;
	color: white !important;
	cursor: pointer !important;
}

.button-fill {
  text-align: center;
  background: #ccc;
  display: inline-block;
  position: relative;
  text-transform: uppercase;
  margin: 0px;
}
.button-fill.grey {
  background: #445561;
  color: white;
  border-radius: 5px;
}

.button-text {
  padding: 0 25px;
  padding-right: 20px;
  padding-left: 20px;
  line-height: 56px;
  letter-spacing: .1em;
}
.button-inside {
  width: 0px;
  height: 54px;
  margin: 0;
  float: left;
  position: absolute;
  top: 1px;
  left: 50%;
  line-height: 54px;
  color: #fff;
  background: -webkit-linear-gradient(left, #25c481, #25b7c4);
  text-align: center;
  overflow: hidden;
  -webkit-transition: width 0.5s, left 0.5s, margin 0.5s;
  -moz-transition: width 0.5s, left 0.5s, margin 0.5s;
  -o-transition: width 0.5s, left 0.5s, margin 0.5s;
  transition: width 0.5s, left 0.5s, margin 0.5s;
}
.button-inside.full {
  width: 100%;
  left: 0%;
  top: 0;
  margin-right: -50px;
  border: 1px solid #445561;
  border-radius: 5px;
}
.inside-text {
  text-align: center;
  position: absolute;
  right: 50%;
  letter-spacing: .1em;
  -webkit-transform: translateX(50%);
  -moz-transform: translateX(50%);
  -ms-transform: translateX(50%);
  transform: translateX(50%);
}

#goBack{
	font-size: 50px;
	color: #fff;
	margin-bottom: 20px;
}
.modal-content{
	width:500px;
	height:500px;
	
	margin-left:200px;
}
.modal-header{
	border-bottom-width: 0px;
}
.close{
	position: absolute;
	right:0;
	top:0;
	margin-right:10px;
	margin-top:10px;
}
tr:hover td.inf{
	background-color:#f5f5f5;
	color: #69A489;
}

tr.selected td.inf{
	background-color:#f5f5f5;
	color: #69A489;
}
.hidden_row{
	display: none;
}

.tab {
 
  background: #fff;
  border-radius: 5px;

  position: relative;
  transition: all 2s ease-in-out;
}

</style>
<body>


<nav class="icon-bar">
	<div class="icon-bar">
		  <a href="#"><i class="fa fa-home"></i></a> 
		  <a href="#"><i class="fa fa-black-tie"></i></a> 
		  <a  href="#"><i class="fa fa-graduation-cap"></i></a> 
		  <a class="active" href="#"><i class="fa fa-group"></i></a>
		  <a href="#"><i class="fa fa-bell"></i></a>
		  <a href="#"><i class="fa fa-clipboard"></i></a>		  
	</div>
</nav>
	
	
<h1>
Mentor: 
 <c:out value="${Pair.getMentor().firstName}"></c:out>
		 <c:out value="${Pair.getMentor().lastName}"></c:out>, 
	 <c:out value="${Pair.getMentor().phoneNumber}"></c:out>
<br>
Mentee: 
		 <c:out value="${Pair.getMentee().firstName}"></c:out>
		  <c:out value="${Pair.getMentee().lastName}"></c:out>, 
	 <c:out  value="${Pair.getMentee().phoneNumber}"></c:out>
</h1>

<section>
<i class="fa fa-arrow-left" aria-hidden="true" onclick="goBack()" id="goBack"></i>	
  <!--for demo wrap--> 
  <div class="tbl-header">
    <table cellpadding="0" cellspacing="0" border="0">
      <thead>
        <tr>
          <th>Date</th>
          <th>Location</th>
          <th>Meeting Type</th>
          <th>Meeting subject</th>
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
        </tr>
        
	    <tr id="hidden_row${meeting.meetingId}" class="hidden_row">
	    <td colspan=4>
	    
        	<div class="tab">
      <button class="tablinks" style="float: right;"
											onclick="closeRow('hidden_row${meeting.meetingId}',${meeting.meetingId});">X</button>
		<table>
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
   </table>
        </div>
        </td>
        </tr>
        
        </c:forEach>
        
      </tbody>
    </table>
  </div>