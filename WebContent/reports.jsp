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
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">

<script>
function showMentor() {
    div = document.getElementById('search1'); //mentor
    div2 = document.getElementById('search2'); //mentee
    div3 = document.getElementById('search3'); //pair

    div.style.display = "";
    div2.style.display = "none";
    div3.style.display = "none";
}

function showMentee() {
    div = document.getElementById('search1');
    div2 = document.getElementById('search2');
    div3 = document.getElementById('search3');
  
    div.style.display = "none";
    div2.style.display = "";
    div3.style.display = "none";
}
function showPair() {
    div = document.getElementById('search1');
    div2 = document.getElementById('search2');
    div3 = document.getElementById('search3');
    
    div.style.display = "none";
    div2.style.display = "none";
    div3.style.display = "";
}


function showMentorTable() {


	 t1 = document.getElementById('mentee');
	 t2 = document.getElementById('mentor');
	 t3 = document.getElementById('pair');



    t1.style.display = "none";
    t2.style.display = "";
    t3.style.display = "none";


}
function showMenteeTable() {
	
    t1 = document.getElementById('mentee');
    t2 = document.getElementById('mentor');
    t3 = document.getElementById('pair');
  

    t1.style.display = "";
    t2.style.display = "none";
    t3.style.display = "none";
}
function showPairTable() {
	t1 = document.getElementById('mentee');
    t2 = document.getElementById('mentor');
    t3 = document.getElementById('pair');

   
    t1.style.display = "none";
    t2.style.display = "none";
    t3.style.display = "";
}

$(document).ready(function(){
$("#submit1").click(function() {
	var type="mentor";
    var city = $("#city1").val();
    var work = $("#work").val();
    var gender = $("#gender1").val();
    var pair=$('input[name=pair1]:checked', '#formP1').serialize();
  
    $.post("Reports",
            {
        	type: type,
            city: city,
            work: work,
            gender: gender,
            pair: pair
        },
    function(data,status){
    	var table=document.getElementsByClassName("table1")[0];
    	while (table.firstChild) {
    		table.removeChild(table.firstChild);
    	}
    	for(i=0;i<data.length;i++)
    		{
    			var tr=document.createElement("TR");
    			var td1=document.createElement("TD");
    			td1.innerHTML=data[i].firstName;
    			var td2=document.createElement("TD");
    			td2.innerHTML=data[i].lastName;
    			var td3=document.createElement("TD");
    			td3.innerHTML=data[i].phoneNumber;
    			var td4=document.createElement("TD");
    			td4.innerHTML=data[i].email;
    			var td5=document.createElement("TD");
    			td5.innerHTML=data[i].gender;
    			tr.appendChild(td1);
    			tr.appendChild(td2);
    			tr.appendChild(td3);
    			tr.appendChild(td4);
    			tr.appendChild(td5);
    			table.appendChild(tr);
    		}
    });
});
$("#submit2").click(function() {
	var type="mentee";
    var city = $("#city2").val();
    var institution = $("#institution").val();
    var academic = $("#academic").val();
    var gender = $("#gender2").val();
    var pair=$('input[name=pair2]:checked', '#formP2').serialize();
    
    $.post("Reports",
            {
        	type: type,
            city: city,
            institution: institution,
            academic: academic,
            gender: gender,
            pair: pair
        },
        function(data,status){
        	var table=document.getElementsByClassName("table2")[0];
        	while (table.firstChild) {
        		table.removeChild(table.firstChild);
        	}
        	for(i=0;i<data.length;i++)
        		{
        			var tr=document.createElement("TR");
        			var td1=document.createElement("TD");
        			td1.innerHTML=data[i].firstName;
        			var td2=document.createElement("TD");
        			td2.innerHTML=data[i].lastName;
        			var td3=document.createElement("TD");
        			td3.innerHTML=data[i].phoneNumber;
        			var td4=document.createElement("TD");
        			td4.innerHTML=data[i].email;
        			var td5=document.createElement("TD");
        			td5.innerHTML=data[i].gender;
        			tr.appendChild(td1);
        			tr.appendChild(td2);
        			tr.appendChild(td3);
        			tr.appendChild(td4);
        			tr.appendChild(td5);
        			table.appendChild(tr);
        		}
        });
});
$("#submit3").click(function() {
	var type="pair";
    var mentee = $("#menteeN").val();
    var mentor = $("#mentorN").val();
   
    $.post("Reports",
            {
        	type: type,
            mentee: mentee,
            mentor: mentor
        },
        function(data,status){
        	var table=document.getElementsByClassName("table3")[0];
        	while (table.firstChild) {
        		table.removeChild(table.firstChild);
        	}
        	for(i=0;i<data.length;i++)
        		{
        			var tr=document.createElement("TR");
        			var td1=document.createElement("TD");
        			td1.innerHTML=data[i].mentor.firstName;
        			var td2=document.createElement("TD");
        			td2.innerHTML=data[i].mentee.firstName;
        			var td3=document.createElement("TD");
        			td3.innerHTML=data[i].activeStatus;
        			var td4=document.createElement("TD");
        			td4.innerHTML=data[i].starDate;
        			var td5=document.createElement("TD");
        			td5.innerHTML=data[i].endDate;
        			tr.appendChild(td1);
        			tr.appendChild(td2);
        			tr.appendChild(td3);
        			tr.appendChild(td4);
        			tr.appendChild(td5);
        			table.appendChild(tr);
               		}
});
});
});
</script>
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
  text-align: left;
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


.buttons{
 	position:relative;
	margin-top:10px;
	margin-left: 190px;
  	
}

button{
	margin-right: 10px;
}
.searchMentor, .searchMentee, .searchPair {
position: relative;
left: 0;
}
.menteeT, .mentorT, .pairT {
position: absolute;
left: 0;
}

button {
	-moz-box-shadow:inset 0px 1px 0px 0px #ffffff;
	-webkit-box-shadow:inset 0px 1px 0px 0px #ffffff;
	box-shadow:inset 0px 1px 0px 0px #ffffff;
	background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #ffffff), color-stop(1, #f6f6f6));
	background:-moz-linear-gradient(top, #ffffff 5%, #f6f6f6 100%);
	background:-webkit-linear-gradient(top, #ffffff 5%, #f6f6f6 100%);
	background:-o-linear-gradient(top, #ffffff 5%, #f6f6f6 100%);
	background:-ms-linear-gradient(top, #ffffff 5%, #f6f6f6 100%);
	background:linear-gradient(to bottom, #ffffff 5%, #f6f6f6 100%);
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffffff', endColorstr='#f6f6f6',GradientType=0);
	background-color:#ffffff;
	-moz-border-radius:6px;
	-webkit-border-radius:6px;
	border-radius:6px;
	border:1px solid #dcdcdc;
	display:inline-block;
	cursor:pointer;
	color:#666666;
	font-family:Arial;
	font-size:15px;
	font-weight:bold;
	padding:6px 24px;
	text-decoration:none;
	text-shadow:0px 1px 0px #ffffff;
}
button:hover {
	background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #f6f6f6), color-stop(1, #ffffff));
	background:-moz-linear-gradient(top, #f6f6f6 5%, #ffffff 100%);
	background:-webkit-linear-gradient(top, #f6f6f6 5%, #ffffff 100%);
	background:-o-linear-gradient(top, #f6f6f6 5%, #ffffff 100%);
	background:-ms-linear-gradient(top, #f6f6f6 5%, #ffffff 100%);
	background:linear-gradient(to bottom, #f6f6f6 5%, #ffffff 100%);
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#f6f6f6', endColorstr='#ffffff',GradientType=0);
	background-color:#f6f6f6;
}
button:active {
	position:relative;
	top:1px;
}

ul {
    list-style-type: none;
    padding-left: 90px;
    overflow: hidden;

}

li {
    float: left;
    border-radius: 10px;
}

li a {
    display: block;
    color: black;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}
li a:hover:not(.active) {
    background-color: #eca1a6;
    text-color: #fff;
    border-radius: 5px;
}

.activeS{
	background-color: #eca1a6;
	border-radius: 5px;
	
}

.btn{
	background-color: #bdcebe;

}

#gender1,#gender2{
	height: 36px;
}
</style>
<body>


<nav class="icon-bar">
	<div class="icon-bar">
		  <a href="ForwardPath" title="Home"><i class="fa fa-home"></i></a> 
		  <a href="GetAllMentors" title="Mentors"><i class="fa fa-black-tie"></i></a> 
		  <a href="GetAllMentees" title="Mentees"><i class="fa fa-graduation-cap"></i></a> 
		  <a href="GetAllPairs" title="Pairs"><i class="fa fa-group"></i></a>
		  <a href="#"><i class="fa fa-bell" title="Notifications"></i></a>
		  <a  class="active" href="#" title="Reports"><i class="fa fa-clipboard"></i></a>	
		  <a href="#" title="Logout"><i class="fa glyphicon">&#xe163;</i></a> 
	</div>
</nav>
	
	

<h1>Reports</h1>
<section>
  <div class="container">
		<div class="row">
			<div class="col-md-6">
				<div class="container-fluid" >
	
  <div class="searchMentor" id="search1"  >

    <form class="well form-horizontal" method="post"  id="contact_form">
<fieldset>

<!-- Form Name -->
<legend>
<ul>
	<li><a class="activeS" onclick="showMentor()">Mentor</a></li>
  <li><a onclick="showMentee()">Mentee</a></li>
  <li><a onclick="showPair()">Pair</a></li>
</ul>
</legend>




<div class="form-group">
  <label class="col-md-4 control-label">City</label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
  <input name="city"  class="form-control"  type="text" id="city1"
  	onblur="if(this.value==''){ this.value='city'; this.style.color='#BBB';}" 
	onfocus="if(this.value=='city'){this.value=''; this.style.color='#000';}">
    </div>
  </div>
</div>

<!-- Select Basic -->
   
<div class="form-group"> 
  <label class="col-md-4 control-label" >Gender</label>
    <div class="col-md-4 selectContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
    <select name="gender" class="form-control selectpicker" id="gender1" >
      <option></option>
      <option value="male">male</option>
      <option value="female">female</option>
      <option value="other">other</option>
    </select>
  </div>
</div>
</div>



<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label">Work place</label>  
   <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-globe"></i></span>
  <input name="work" class="form-control" type="text" id="work"
  onblur="if(this.value==''){ this.value='work'; this.style.color='#BBB';}" 
	onfocus="if(this.value=='work'){this.value=''; this.style.color='#000';}">
    </div>
  </div>
</div>

<!-- radio checks -->
 <div class="form-group" id="formP1" >
                        <label class="col-md-4 control-label">In a pair?</label>
                        <div class="col-md-4">
                            <div class="radio">
                                <label>
                                    <input type="radio" name="pair1" id="pair1" value="yes" /> Yes
                                </label>
                            </div>
                            <div class="radio">
                                <label>
                                    <input type="radio" name="pair1" id="pair1" value="no" /> No
                                </label>
                            </div>
                        </div>
                    </div>

  



<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label"></label>
  <div class="col-md-4">
    <a class="btn" onclick="showMentorTable()"  id="submit1">Search <span class="glyphicon glyphicon-send"></span></a>
  </div>
</div>

</fieldset>
</form>
</div>
    
    
<div class="searchMentee" id="search2"  style=" display: none">

    <form class="well form-horizontal" action=" " method="post"  id="contact_form">
<fieldset>

<!-- Form Name -->
<legend>
<ul>
	<li><a  onclick="showMentor()">Mentor</a></li>
  <li><a class="activeS" onclick="showMentee()">Mentee</a></li>
  <li><a onclick="showPair()">Pair</a></li>
</ul>
</legend>





<div class="form-group">
  <label class="col-md-4 control-label">City</label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
  <input name="city"  class="form-control"  type="text" id="city2"
  onblur="if(this.value==''){ this.value='city'; this.style.color='#BBB';}" 
	onfocus="if(this.value=='city'){this.value=''; this.style.color='#000';}">
    </div>
  </div>
</div>

<!-- Select Basic -->
   
<div class="form-group"> 
  <label class="col-md-4 control-label">Gender</label>
    <div class="col-md-4 selectContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
    <select name="state" class="form-control selectpicker" id="gender2">
      <option value=" " ></option>
      <option>male</option>
      <option>female</option>
      <option>other</option>
    </select>
  </div>
</div>
</div>



<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label">Institution</label>  
   <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-globe"></i></span>
  <input name="website" class="form-control" type="text" id="institution"
  onblur="if(this.value==''){ this.value='institution'; this.style.color='#BBB';}" 
	onfocus="if(this.value=='institution'){this.value=''; this.style.color='#000';}">
    </div>
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label">Academic discipline</label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
  <input name="academic"  class="form-control"  type="text" id="academic"
  onblur="if(this.value==''){ this.value='acDic'; this.style.color='#BBB';}" 
	onfocus="if(this.value=='acDic'){this.value=''; this.style.color='#000';}">
    </div>
  </div>
</div>

<!-- radio checks -->
 <div class="form-group" id="formP2">
                        <label class="col-md-4 control-label">In a pair?</label>
                        <div class="col-md-4">
                            <div class="radio">
                                <label>
                                    <input type="radio" name="pair2" id="pair2" value="yes" /> Yes
                                </label>
                            </div>
                            <div class="radio">
                                <label>
                                    <input type="radio" name="pair2" id="pair2" value="no" /> No
                                </label>
                            </div>
                        </div>
                    </div>

  



<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label"></label>
  <div class="col-md-4">
    <a class="btn " onclick="showMenteeTable()" id="submit2">Search <span class="glyphicon glyphicon-send"></span></a>
    
  </div>
</div>

</fieldset>
</form>
</div>
    
    
<div class="searchPair" id="search3" style=" display: none" >

    <form class="well form-horizontal" action=" " method="post"  id="contact_form">
<fieldset>

<!-- Form Name -->
<legend>
<ul>
	<li><a onclick="showMentor()">Mentor</a></li>
  <li><a onclick="showMentee()">Mentee</a></li>
  <li><a class="activeS" onclick="showPair()">Pair</a></li>
</ul>
</legend>





<div class="form-group">
  <label class="col-md-4 control-label">Mentor name</label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
  <input name="mentorN"  class="form-control" id="mentorN"  type="text"
  onblur="if(this.value==''){ this.value='name'; this.style.color='#BBB';}" 
	onfocus="if(this.value=='name'){this.value=''; this.style.color='#000';}">
    </div>
  </div>
</div>



   




<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label">Mentee name</label>  
   <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-globe"></i></span>
  <input name="menteeN" class="form-control" id="menteeN" type="text"
  onblur="if(this.value==''){ this.value='name'; this.style.color='#BBB';}" 
	onfocus="if(this.value=='name'){this.value=''; this.style.color='#000';}">
    </div>
  </div>
</div>





<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label"></label>
  <div class="col-md-4">
    <a class="btn " onclick="showPairTable()" id="submit3">Search <span class="glyphicon glyphicon-send"></span></a>
  </div>
</div>

</fieldset>
</form>
</div>
    
	</div>
			</div>
			
			
			<div class="col-md-6" >
	<div class=mentorT style=" display: none" id="mentor">
			<div class="tbl-header">
  
    <table cellpadding="0" cellspacing="0" border="0">
      <thead>
        <tr>
          <th>Name Mentor</th>
          <th>Last Name</th>
          <th>Phone</th>
          <th>Email</th>
          <th>Gender</th>
        </tr>
      </thead>
    </table>
  </div>
  <div class="tbl-content">
    <table cellpadding="0" cellspacing="0" border="0" id="myTable1" class="table1">
      <tbody>
       
			<tr class="para"><td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td></tr>
			
	
      </tbody>
    </table>
    </div>
    </div>
    
    
    <div class="menteeT" style=" display: none" id="mentee">
    	<div class="tbl-header">
    <table  cellpadding="0" cellspacing="0" border="0">
      <thead>
        <tr>
          <th>Name Mentee</th>
          <th>Last Name</th>
          <th>Phone</th>
          <th>Email</th>
          <th>Gender</th>
        </tr>
      </thead>
    </table>
  </div>
  <div class="tbl-content">
    <table cellpadding="0" cellspacing="0" border="0" id="myTable1" class="table2">
      <tbody>
       
			<tr class="para"><td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td></tr>
			
		
      </tbody>
    </table>
    </div>
    </div>
    
    <div class="pairT" style=" display: none" id="pair">
    <div class="tbl-header">
    <table cellpadding="0" cellspacing="0" border="0" >
      <thead>
        <tr>
          <th>Mentor Name</th>
          <th>Mentee Name</th>
          <th>Active</th>
          <th>start date</th>
          <th>end date</th>
        </tr>
      </thead>
    </table>
  </div>
  <div class="tbl-content">
    <table cellpadding="0" cellspacing="0" border="0" id="myTable1" class="table3">
      <tbody>
       
			<tr class="para"><td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td></tr>
			
	
      </tbody>
    </table>
  </div>
	</div>
 
  </div>
  </div>
</div>
	

</section>
</body>
</html> 