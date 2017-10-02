<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="mm.model.Mentee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<  
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>


<script type="text/javascript">

function goToEdit(firstName,lastName,phone,email,academicInstitution,note,academicDicipline,remainingSemesters,average,id)
{
	 document.getElementById("fname").value=firstName;
	 document.getElementById("lname").value=lastName;
	 document.getElementById("phone").value=phone;
	 document.getElementById("email").value=email;
	 
	 document.getElementById("academic").value=academiclnstitution;
	 document.getElementById("note").value=note;
	 document.getElementById("course").value=academicDicipline;
	 document.getElementById("semesters").value=remainingSemesters;
	 document.getElementById("average").value=average;
	 document.getElementById("id").value=id;
}

function openCity(evt, cityName) {
    // Declare all variables
    
    var i, tabcontent, tablinks;

    // Get all elements with class="tabcontent" and hide them
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }

    // Get all elements with class="tablinks" and remove the class "active"
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }

    // Show the current tab, and add an "active" class to the button that opened the tab
    document.getElementById(cityName).style.display = "block";
    evt.currentTarget.className += " active";
    foo();
}

 
</script>
<style>
/* Style inputs with type="text", select elements and textareas */
input[type=text], select, textarea {
    width: 100%; /* Full width */
    padding: 12px; /* Some padding */  
    border: 1px solid #ccc; /* Gray border */
    border-radius: 4px; /* Rounded borders */
    box-sizing: border-box; /* Make sure that padding and width stays in place */
    margin-top: 6px; /* Add a top margin */
    margin-bottom: 16px; /* Bottom margin */
    resize: vertical /* Allow the user to vertically resize the textarea (not horizontally) */
}

/* Style the submit button with a specific background color etc */
input[type=submit] {
    background-color: #4CAF50;
    color: white;
    padding: 12px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

/* When moving the mouse over the submit button, add a darker green color */
input[type=submit]:hover {
    background-color: #45a049;
}

/* Add a background color and some padding around the form */
.container {
    border-radius: 5px;
    background-color: #f2f2f2;
    padding: 20px;
}
/* Style the tab */
div.tab {
    overflow: hidden;
    border: 1px solid #ccc;
    background-color: #f1f1f1;
}

/* Style the buttons inside the tab */
div.tab button {
    background-color: inherit;
    float: left;
    border: none;
    outline: none;
    cursor: pointer;
    padding: 14px 16px;
    transition: 0.3s;
}

/* Change background color of buttons on hover */
div.tab button:hover {
    background-color: #ddd;
}

/* Create an active/current tablink class */
div.tab button.active {
    background-color: #ccc;
}

/* Style the tab content */
.tabcontent {
    display: none;
    padding: 6px 12px;
    border: 1px solid #ccc;
    border-top: none;
}
.close {
	background: #606061;
	color: #FFFFFF;
	line-height: 25px;
	position: absolute;
	right: -12px;
	text-align: center;
	top: -10px;
	width: 24px;
	text-decoration: none;
	font-weight: bold;
	-webkit-border-radius: 12px;
	-moz-border-radius: 12px;
	border-radius: 12px;
	-moz-box-shadow: 1px 1px 3px #000;
	-webkit-box-shadow: 1px 1px 3px #000;
	box-shadow: 1px 1px 3px #000;
}

.close:hover { background: #00d9ff; }
.modalDialog:target {
 opacity:1;
 pointer-events: auto;
}

.modalDialog > div {
 width: 800px;
 margin:  auto;
 border-radius: 10px;
 background: #fff;
 background: -moz-linear-gradient(#fff, #999);
 background: -webkit-linear-gradient(#fff, #999);
 background: -o-linear-gradient(#fff, #999);
}
.modalDialog {
 position: fixed;
 font-family: Arial, Helvetica, sans-serif;
 top: 0;
 right: 0;
 left: 0;
 buttom:0;
 background: rgba(0,0,0,0.3);
 z-index: 99999;
 opacity:0;
 -webkit-transition: opacity 400ms ease-in;
 -moz-transition: opacity 400ms ease-in;
 transition: opacity 400ms ease-in;
 pointer-events: none;
}


.button:hover {
    background-color: #4CAF50; /* Green */
    color: white;
}

h1{
  font-size: 30px;
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
  font-weight: 500;
  font-size: 12px;
  color: #000;
  text-transform: uppercase;
}

td{
  text-align: center;
  vertical-align:middle;
  font-weight: 700;
  font-size: 14px;
  color: #000;
  border-bottom: solid 1px rgba(255,255,255,0.1);
}


/* demo styles */

@import url(https://fonts.googleapis.com/css?family=Roboto:400,500,300,700);
body{
  background: -webkit-linear-gradient(left, #25c481, #25b7c4);
  background: linear-gradient(to right, #25c481, #25b7c4);
  font-family: 'Roboto', sans-serif;
}
section{
  top:0;
  margin-top: 90px; 
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
    background-color: #4CAF50 !important;
}
i{
margin-right:2px;
}
body{

	background-color: #cfd9df;
	height:100%;
}
html{
	overflow-y: hidden;
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
.button {
    background-color: #4CAF50;
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
}
.btn-primary, .btn-primary:hover, .btn-primary:active, .btn-primary:visited,.btn-primary:focus {
    background-color: #67d2bc !important;
	border-color: #67d2bc !important;
	outline: none !important;
	color: white !important;
	cursor: pointer !important;
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

* {
  font-family: 'Open Sans', sans-serif;
}
.button-fill {
  text-align: center;
  background: #ccc;
  display: inline-block;
  position: relative;
  text-transform: uppercase;
  margin: 25px;
}
.button-fill.grey {
  background: #445561;
  color: white;
  text-align: center;
}

.button-text {
  padding: 0 25px;
  line-height: 56px;
  letter-spacing: .1em;
   text-align: center;
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
  text-align: center;
  left: 0%;
  top: 0;
  margin-right: -50px;
  border: 1px solid #445561;
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
tr.stam:hover{
	background-color: #f5f5f5;
	opacity: 0.9;
	

}
td{
height: 20%;
	}
</style>
<body>
<nav class="icon-bar">
	<div class="icon-bar">
		  <a href="welcome"><i class="fa fa-home"></i></a> 
		  <a href="GetAllMentors"><i class="fa fa-black-tie"></i></a> 
		  <a class="active" href="GetAllMentees"><i class="fa fa-graduation-cap"></i></a> 
		  <a href="GetAllPairs"><i class="fa fa-group"></i></a>
		  <a href="#"><i class="fa fa-bell"></i></a>
		  <a href="#"><i class="fa fa-clipboard"></i></a>		  
	</div>
</nav>
	<h1>Mentees</h1>
<section>
  <!--for demo wrap-->
  <div class="tbl-header">
    <table cellpadding="0" cellspacing="0" border="0">
      <thead>
        <tr>
          <th>Name</th>
          <th>Last Name</th>
          <th>Phone</th>
          <th>Email</th>
          <th>Edit </th>
        </tr>
      </thead>
    </table>
  </div>
  <div class="tbl-content" style="height:100% "  >
    <table cellpadding="0" cellspacing="0" border="0" >
    
    
      <tbody>
    <c:forEach items="${Mentees}" var="ment">
        <tr class="stam">
        
         <td style="display: none">
        	${ment.id}
            </td>
            <td>
        	${ment.firstName}
            </td>
            <td>
            ${ment.lastName}
            </td>
            <td>
            ${ment.phoneNumber}
            </td>
            <td>
            ${ment.email}
            </td>
            <td>
            
            
<a href="#openModal2" onclick="goToEdit('${ment.firstName}','${ment.lastName}','${ment.phoneNumber}'
,'${ment.email}','${ment.academiclnstitution}','${ment.note}','${ment.academicDicipline}','${ment.remainingSemesters}','${ment.average}','${ment.id}');" >
  <div class="button-fill grey" >
    <div class="button-text"  >Edit</div>
    <div class="button-inside" >
      <div class="inside-text"  >Edit</div>
    </div>
    </div>
     </a>
    <script>$(".button-fill").hover(
    		  function() {
    			    $(this).children(".button-inside").addClass("full");
    			  },
    			  function() {
    			    $(this).children(".button-inside").removeClass("full");
    			  }
    			);</script>

 <!--   <a href="#openModal2" ><button class="button">Edit</button>
  </a>-->



<div id="openModal2" class="modalDialog">
	<div>
		<a href="#close" title="Close" class="close" style=" position:absolute;">X</a>
	
<div class="container" style="overflow-y ">
  <form action="AddMentee">
    <input type="text" id="fname" name="uFirstName" >
    <input type="text" id="lname" name="uLastName" >
    <input type="text" id="phone" name="uPhoneNumber" >
    <input type="text" id="email" name="uEmail" >
    <input type="text" id="gender" name="uGender" >
    <input type="text" id="address" name="uAddress" >
    <input type="text" id="graduationStatus" name="uGraduationStatus" >
    <input type="text" id="courseOfStudy" name="uCourseOfStudy" >
    <input type="text" id="academic" name="uAcademicDicipline" >
    <input type="text" id="academic2" name="uAcademicDicipline2" >
    <textarea id="note" name="uNotes"  style="height:50px"></textarea>
    <input type="text" id="course" name="course">
    <input type="text" id="semesters" name="uRemSemesters">
    <input type="text" id="average" name="uAverage" >
    <input type="text" id="id" name="id" style="display:none" >
    <input type="submit" value="Done">

  </form>
</div>

	
	</div>
</div>

<script type="text/javascript">
 
 
function  getId(id,name,lastName,phone,email,gender,address,semesters,status,academy,average,course,course2,note) {

	 document.getElementById("name").innerHTML=name;
	 document.getElementById("gender").innerHTML=gender;
	 document.getElementById("address").innerHTML=address;
	 document.getElementById("phonel").innerHTML=phone;
	 document.getElementById("emaill").innerHTML=email;
	 document.getElementById("location").innerHTML=id;
	 
	 document.getElementById("semesterss").innerHTML=semesters;
	 document.getElementById("statuss").innerHTML=status;
	 document.getElementById("academys").innerHTML=academy;
	 document.getElementById("averages").innerHTML=average;
	 document.getElementById("courses").innerHTML=course;
	 document.getElementById("coursess").innerHTML=course2;
	}
 
 
</script>


<a href="#openModal" onclick="getId('${ment.id}','${ment.firstName}','${ment.lastName}',
  '${ment.phoneNumber}','${ment.email}','${ment.gender}','${ment.address}'
  ,'${ment.remainingSemesters}','${ment.graduationStatus}',
  '${ment.academiclnstitution}','${ment.average}',
  '${ment.academicDicipline}','${ment.academicDicipline2}',
  '${ment.note}');" >
  
  <div class="button-fill grey" >
    <div class="button-text"  >Info</div>
    <div class="button-inside" >
      <div class="inside-text"  >Info</div>
    </div>
    </div>
    </a>
    <script>$(".button-fill").hover(
    		  function() {
    			    $(this).children(".button-inside").addClass("full");
    			  },
    			  function() {
    			    $(this).children(".button-inside").removeClass("full");
    			  }
    			);</script>
 <!--   <a href="#openModal" onclick="getId(this)" ><button class="button">Info</button>
  </a>
-->
<div id="openModal" class="modalDialog">
	<div>
		<a href="#close" title="Close" class="close" style=" position:absolute;">X</a>
		
		<div class="tab">
		  <button class="tablinks" onclick="openCity(event, 'Info')">Info</button>
		  <button class="tablinks" onclick="openCity(event, 'Academic')">Academic</button>
		  <button class="tablinks" onclick="openCity(event, 'Tsofen')">Tsofen</button>
		  <button class="tablinks" onclick="openCity(event, 'Mentor')">Mentor</button>
		  <button class="tablinks" onclick="openCity(event, 'Note')">Note</button>
		</div>
		
		<div id="Info" class="tabcontent">

<div class="w3-container">

  <table class="w3-table-all w3-card-4">
    <tr>
      <th>Name</th>
      <th>Gender</th>
      <th>Address</th>
      <th>Phone</th>
      <th>Email</th>
      <th>Location</th>
    </tr>
    <tr>
      <td id="name"></td>
      <td id="gender"></td>
      <td id="address"></td>
      <td id="phonel"></td>
      <td id="emaill"></td>
      <td id="location"></td>
    </tr>
  </table>
</div>

</div>
<div id="Academic" class="tabcontent">
<div class="w3-container">
  <table class="w3-table-all w3-card-4">
    <tr>
      <th>Semesters left</th>
      <th>Graduation status</th>
      <th>Academic institute</th>
      <th>Average</th>
      <th>Major</th>
      <th>Second major</th>
    </tr>
    <tr>
      <td id="semesterss"></td>
      <td id="statuss"></td>
      <td id="academys"></td>
      <td id="averages"></td>
      <td id="courses"></td>
      <td id="coursess"></td>
    </tr>
  </table>
</div>
</div>
		
<div id="Info" class="tabcontent" >
</div>
<div id="Academic" class="tabcontent">
</div>
<div id="Tsofen" class="tabcontent">
</div>
<div id="Mentor" class="tabcontent">
</div>
<div id="Note" class="tabcontent">
</div>
	</div>
</div>
          
            </td> 
        </tr>
        
    </c:forEach>
     
      </tbody>
    </table>
  </div>
  
  
  
   <a href="#openModal3" class="btn btn-block btn-primary" > <i class="fa fa-plus"></i><i class="fa fa-graduation-cap"></i> Add Mentee </a>
    </div>
    <div id="openModal3" class="modalDialog">
	<div>
		<a href="#close" title="Close" class="close" style=" position:absolute;">X</a>
	
<div class="container" style="overflow-y ">
  <form action="UpdateMentee">
	<table>
	<td>
	<tr>
    <input type="text" name="uFirstName" >
    </tr><tr>
    <input type="text" name="uLastName" >
      </tr><tr>
    <input type="text" name="uPhoneNumber" >
      </tr><td>
    <input type="text" name="uEmail" >
      </tr><tr>
    <input type="text"  name="uGender" >
      </tr><tr>
    <textarea name="uNotes"  style="height:50px"></textarea>
      </tr><tr>
    <input type="text"  name="uAddress">
    </td><td>  </tr><tr>
    <input type="text" name="uGraduationStatus">
      </tr><tr>
    <input type="text"  name="uCourseOfStudy" >
      </tr><tr>
        <input type="text"  name="uAcademicInstitution" >
      </tr><tr>
        <input type="text"  name="uRemSemesters" >
      </tr><tr>
        <input type="text"  name="uAverage" >
      </tr><tr>
        <input type="text"  name="uAcademicDicipline" >
      </tr><tr>
        <input type="text"  name="uAcademicDicipline2" >
      </tr><tr>
         <input type="text"  name="uIsGraduate" >
      </tr><tr>
      
      
      
      
      
      <input type="text"  name="id" style="display:none" >
      </tr>
    </td>
    </table>
    <input type="submit" value="Done">

  </form>
</div>

	
	</div>
</div>
</section>
</body>
</html> 

