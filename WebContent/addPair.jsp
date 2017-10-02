<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
		$("tr").click(function() {
		    $(this).addClass('selected').siblings().removeClass("selected");
		});
		$("#createPair").click(function(){
			var trs= document.getElementsByClassName("selected");
			var menteeId=trs[0].childNodes[10].innerHTML;
			var mentorId=trs[1].childNodes[10].innerHTML;
			$.post("CreateNewPair",
			        {
			          menteeID: menteeId,
			          mentorID: mentorId
			        },
			        function(data,status){
			            alert("Big Love");
			        });
	});
	});
	</script>
	<script>
	function sort() {
	  var input, filter, table, tr, td, i;
	  input = document.getElementById("myInput");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("myTable");
	  tr = table.getElementsByTagName("tr");
	
	  var column;
	  switch(document.getElementById("drop").innerHTML){
	   case "Location":
		   column=6;
		   break;
	   case "University":
		   column=7;
		   break;
	   default:
		   column=0;
	  }
	  
	  for (i = 0; i < tr.length; i++) {
	    td = tr[i].getElementsByTagName("td")[column];
	    if (td) {
	      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
	        tr[i].style.display = "";
	      } else {
	        tr[i].style.display = "none";
	      }
	    }       
	  }
	}
	
	function sort1() {
		  var input, filter, table, tr, td, i;
		  input = document.getElementById("myInput1");
		  filter = input.value.toUpperCase();
		  table = document.getElementById("myTable1");
		  tr = table.getElementsByTagName("tr");
		 
		  var column;
		  switch(document.getElementById("drop1").innerHTML){
		   case "Location":
			   column=6;
			   break;
		   case "Company":
			   column=7;
			   break;
		   default:
			   column=0;
		  }
		  
		  for (i = 0; i < tr.length; i++) {
		    td = tr[i].getElementsByTagName("td")[column];
		    if (td) {
		      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
		        tr[i].style.display = "";
		      } else {
		        tr[i].style.display = "none";
		      }
		    }       
		  }
		}
</script>	

<script>
	function goBack() {
	    window.history.back();
	}
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
  text-align: left;
  font-weight: 500;
  font-size: 14px;
  color: #fff;
  text-transform: uppercase;
  word-wrap: break-word;
}
td{
  padding: 15px;
  text-align: left;
  vertical-align:middle;
  font-weight: 300;
  font-size: 14px;
  color: #fff;
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
a{

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
	margin-top:20px;
    background-color: #67d2bc !important;
	border-color: #67d2bc !important;
	outline: none !important;
	color: white !important;
	cursor: pointer !important;
}

tr.para:hover td{
	background-color:#f5f5f5;
	color: #69A489;
}

h5{
	color: #fff;;
}
.para.selected {
    background-color:#f5f5f5;
	color: #69A489;
}
tr.selected td{
	color: #69A489;
}

.navbar .navbar-search .dropdown-menu { min-width: 25px; }
.dropdown-menu .label-icon { margin-left: 5px;
	color: #1AD79E;
	font-weight: bold;
 }
.btn-outline {
    background-color: transparent;
    color: inherit;
    transition: all .5s;
}
.navbar{
	padding-right: 0px ; 
	padding-left: 0px;
}

#searchB{
	background-color: rgba(255,255,255,0.3);
	color: #fff;	
}

#dropdownM{
	background-color: #fff;
	opacity: 0.9;
	width: 105px;
}

#myInput,#myInput1{
	background-color: #fff;
	opacity: 0.9;
	
}
li:hover{
	background-color: #BDCFC9;
}

.label-icon:hover{
 	text-decoration: underline #BDCFC9;
}


#goBack{
	font-size: 50px;
	color: #555;
	margin-bottom: 20px;
}
</style>
<body>


<nav class="icon-bar">
	<div class="icon-bar">
		  <a href="#"><i class="fa fa-home"></i></a> 
		  <a href="#"><i class="fa fa-black-tie"></i></a> 
		  <a  href="mentees.jsp"><i class="fa fa-graduation-cap"></i></a> 
		  <a class="active" href="#"><i class="fa fa-group"></i></a>
		  <a href="#"><i class="fa fa-bell"></i></a>
		  <a href="#"><i class="fa fa-clipboard"></i></a>		  
	</div>
</nav>

	<h1>New Pairs</h1>
	<section>
<i class="fa fa-arrow-left" aria-hidden="true" onclick="goBack()" id="goBack"></i>	

	

<div class="container-fluid" >

  <div class="row">
    <div class="col-md-6" style= "padding-left: 0px;">
    <h5 id="mentee">MENTEE</h5>
<nav class="navbar navbar-default">
        <div class="">
 
            <form class="navbar-form navbar-search" role="search">
                <div class="input-group">
                
                    <div class="input-group-btn">
                        <button type="button" class="btn btn-search btn-default dropdown-toggle" data-toggle="dropdown" id="searchB">
                            <span class="glyphicon glyphicon-search" ></span>
                            <span class="label-icon" id="drop">Search</span>
                            <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu pull-left" role="menu" id="dropdownM">
                           <li>
                                <a href="#">
                                    <span class="glyphicon glyphicon-user"></span>
                                    <span class="label-icon" id="drop"  >Location</span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                <span class="glyphicon glyphicon-book"></span>
                                <span class="label-icon" id="drop">University</span>
                                </a>
                            </li>
                        </ul>
                    </div>
        
                    <input type="text" class="form-control" id="myInput" onkeyup="sort()" placeholder="Type here..">
                
                </div>  
            </form>   
         
        </div>
    </nav>
<script>

$(function(){
    
    $(".input-group-btn .dropdown-menu li a").click(function(){

        var selText = $(this).html();
    
        //working version - for single button //
       //$('.btn:first-child').html(selText+'<span class="caret"></span>');  
       
       //working version - for multiple buttons //
       $(this).parents('.input-group-btn').find('.btn-search').html(selText);

   });

});
</script>
		 <div class="tbl-header">
		 
    <table cellpadding="0" cellspacing="0" border="0">
      <thead>
        <tr>
          <th>Name</th>
          <th>Last Name</th>
          <th>Phone</th>
          <th>Email</th>
          <th>Gender</th>
        </tr>
      </thead>
    </table>
  </div>
  <div class="tbl-content">
    <table cellpadding="0" cellspacing="0" border="0" id="myTable">
      <tbody>
      <c:forEach var="mentee" items="${Mentees}" >
			<tr class="para" id="tabletest"><td><c:out value="${mentee.firstName}"></c:out></td>
			<td ><c:out value="${mentee.lastName}"></c:out></td>
			<td><c:out value="${mentee.phoneNumber}"></c:out></td>
			<td><c:out value="${mentee.email}"></c:out></td>
			<td><c:out value="${mentee.gender}"></c:out></td>
			<td style="display:none;" class="menteeId"><c:out value="${mentee.id}"></c:out></td>
			<td style="display:none;" class="menteeAddress"><c:out value="${mentee.address}"></c:out></td>
			<td style="display:none;" class="menteeUniversity"><c:out value="${mentee.academiclnstitution}"></c:out></td></tr>
		</c:forEach>
      </tbody>
    </table>
  </div>
	</div>
    <div class="col-md-6" style= "padding-right: 0px;" >
	<!--for demo wrap-->
	<h5>MENTOR</h5>
	 <nav class="navbar navbar-default">
        <div class="nav nav-justified navbar-nav">
 
            <form class="navbar-form navbar-search" role="search">
                <div class="input-group">
                
                    <div class="input-group-btn">
                        <button type="button" class="btn btn-search btn-default dropdown-toggle" data-toggle="dropdown" id="searchB">
                            <span class="glyphicon glyphicon-search"></span>
                            <span class="label-icon" id="drop1">Search</span>
                            <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu pull-left" role="menu" id="dropdownM">
                           <li>
                                <a href="#">
                                    <span class="glyphicon glyphicon-user"></span>
                                    <span class="label-icon" id="drop1">Location</span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                <span class="glyphicon glyphicon-book"></span>
                                <span class="label-icon" id="drop1">Company</span>
                                </a>
                            </li>
                        </ul>
                    </div>
        
                    <input type="text" class="form-control" id="myInput1" onkeyup="sort1()" placeholder="Type here..">
              
                </div>  
            </form>   
         
        </div>
    </nav>
<script>

$(function(){
    
    $(".input-group-btn .dropdown-menu li a").click(function(){

        var selText = $(this).html();
    
        //working version - for single button //
       //$('.btn:first-child').html(selText+'<span class="caret"></span>');  
       
       //working version - for multiple buttons //
       $(this).parents('.input-group-btn').find('.btn-search').html(selText);

   });

});
</script>
  <div class="tbl-header">
  
    <table cellpadding="0" cellspacing="0" border="0">
      <thead>
        <tr>
          <th>Name</th>
          <th>Last Name</th>
          <th>Phone</th>
          <th>Email</th>
          <th>Gender</th>
        </tr>
      </thead>
    </table>
  </div>
  <div class="tbl-content">
    <table cellpadding="0" cellspacing="0" border="0" id="myTable1">
      <tbody>
       <c:forEach items="${Mentors}" var="mentor">
			<tr class="para"><td><c:out value="${mentor.firstName}"></c:out></td>
			<td><c:out value="${mentor.lastName}"></c:out></td>
			<td><c:out value="${mentor.phoneNumber}"></c:out></td>
			<td><c:out value="${mentor.email}"></c:out></td>
			<td><c:out value="${mentor.gender}"></c:out></td>
			<td style="display:none;" class="mentorId"><c:out value="${mentor.id}"></c:out></td>
			<td style="display:none;" class="mentorAddress"><c:out value="${mentor.address}"></c:out></td>
			<td style="display:none;" class="mentorCompany"><c:out value="${mentor.company}"></c:out></td></tr>
		</c:forEach>
      </tbody>
    </table>
  </div>
	</div>
  </div>
</div>
     <a class="btn btn-block btn-primary" id="createPair"> <i class="fa fa-plus"></i><i class="fa fa-group"></i> Create Pair </a>
</section>
</body>

</html>
