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
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
</head>
<style>


h1{
  font-size: 40px;
  letter-spacing: 8px;
  text-shadow: 2px 4px 4px #CCCCCC;
  color: #fff;
  text-transform: uppercase;
  font-weight: 300;
  text-align: center;
  margin-bottom: 15px;
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
  font-weight: bold;
  font-size: 16px;
  color: #fff;
  text-transform: uppercase;
  word-wrap: break-word;
}
td{
  padding: 15px;
  text-align: left;
  vertical-align:middle;
  font-weight: 600;
  font-size: 16px;
  color: #fff;
  border-bottom: solid 1px rgba(255,255,255,0.1);
  border-right: solid 1px rgba(255,255,255,0.3);
  word-wrap: break-word;
}
#colorMentee, #mentee{
	color: #B93A32;
}
#colorMentor, #mentor{
	color: #005960;
}


td.but{
	text-align: center;
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
	position: absolute;
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
  border-radius: 12px;
}

.button-text {
  padding: 0 25px;
  padding-right: 10px;
  padding-left: 10px;
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
  border-radius: 12px;
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
	<h1>Pairs</h1>
<section>
  <!--for demo wrap--> 
  <div class="tbl-header">
    <table cellpadding="0" cellspacing="0" border="0">
      <thead>
        <tr>
          <th>Mentor Name</th>
          <th>Mentee Name</th>
          <th>Notification</th>
          <th>Meetings </th>
          <th>Disconnect </th>
        </tr>
      </thead>
    </table>
  </div>
  <div class="tbl-content">
    <table cellpadding="0" cellspacing="0" border="0">
      <tbody>
      <c:forEach var="pair" items="${pairs}" >
        <tr>
          <td id="mentor"><c:out value="${pair.menteeName}"></c:out></td>
			<td id="mentee"><c:out value="${pair.mentorName}"></c:out></td>
			<td><c:out value="${pair.activeStatus}"></c:out></td>
			 <td class="but">   <a class="Meetings" href="GetMeetingByPairId?id=${pair.pairId}" >
  <div class="button-fill grey">
    <div class="button-text">Meetings</div>
    <div class="button-inside">
      <div class="inside-text">Meetings</div>
    </div>
    </div>
    </a>
    </td>
          <td class="but">   <a class="disB" href="#" id="${pair.pairId}">
  <div class="button-fill grey">
    <div class="button-text">Disconnect</div>
    <div class="button-inside">
      <div class="inside-text">Disconnect</div>
    </div>
    </div>
    </a>
    </td>
        </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>

 <a class="btn btn-block btn-primary" href="GetMentorsAndMentees"> <i class="fa fa-plus"></i><i class="fa fa-group"></i> New Pair </a>

</section>
</body>
</html> 

