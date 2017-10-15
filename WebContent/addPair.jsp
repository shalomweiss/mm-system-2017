<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<head>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<style type="text/css"><%@include file="WEB-INF/css/styles.css" %>
</style>
	<script>
	$(document).ready(function(){
		$("tr").click(function() {
		    $(this).addClass('selected').siblings().removeClass("selected");
		});
		$("#createPair").click(function(){
			var trs= document.getElementsByClassName("selected");
			if(trs.length>1)
			{
				
				var menteeId=trs[0].childNodes[10].innerHTML;
				var mentorId=trs[1].childNodes[10].innerHTML;
				$.post("CreateNewPair",
				        {
				          menteeID: menteeId,
				          mentorID: mentorId
				        },
				        function(data,status){
				        	
				            alert(data);
				        });
			}
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


<body>


<nav class="icon-bar">
	<div class="icon-bar">
		 <a  href="ForwardPath" title="Home"><i class="fa fa-home"></i></a> 
		  <a href="GetAllMentors" title="Mentors"><i class="fa fa-black-tie"></i></a> 
		  <a href="GetAllMentees"title="Mentees"><i class="fa fa-graduation-cap"></i></a> 
		  <a class="active" href="GetAllPairs" title="Pairs"><i class="fa fa-group"></i></a>
		  <a href="#"><i class="fa fa-bell" title="Notifications"></i></a>
		  <a href="#" title="Reports"><i class="fa fa-clipboard"></i></a>	
		  <a href="#" title="Logout"><i class="fa glyphicon">&#xe163;</i></a>  
	</div>
</nav>

	<h1>New Pairs</h1>
	<section class="Pairs">
<div class="container-fluid" >

  <div class="row">
    <div class="col-md-4" style= " margin-top: 70px;background-color:white;padding-left: 0px;">
    <h3 id="mentee">MENTEES</h3>
<nav class="navbar navbar-default">
        <div class="">
 
            <form class="navbar-form navbar-search" role="search">
                <div class="input-group">
                
                    <div class="input-group-btn">
                        <button type="button" class="btn btn-search btn-default dropdown-toggle" data-toggle="dropdown" id="searchB">
                            <span class="glyphicon glyphicon-search" ></span>
                            <span class="label-icon" id="drop">Search</span>
                          
                        </button>
                        <ul class="dropdown-menu pull-left" role="menu" id="dropdownM">
                           <li>
                                <a href="#">
                                    
                                    <span class="label-icon" id="drop"  style="color:black;" >Location</span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                
                                <span class="label-icon" id="drop" style="color:black;">University</span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                
                                <span class="label-icon" id="drop1" style="color:black;">Name</span>
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
		 <div class="tbl-header-mentee">
		 
    <table cellpadding="0" cellspacing="0" border="0">
      <thead>
        <tr class="MenteeTR">
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
      <tbody class="mentee">
      <c:forEach var="mentee" items="${Mentees}" >
			<tr class="para AllMent" id="tabletest"><td><c:out value="${mentee.firstName}"></c:out></td>
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
	
	 <div class="col-md-2" style= "margin-top: 250px;">
	 
	 
	 <a id="createPair" class="btn btn-block btn-primary">
	 <i  class="fa fa-handshake-o" style="color:white;font-size:100px;text-align: center;"></i><br>
	 <h5>Create Pair</h5>
	 </a>
	 
	</div>
	
	
    <div class="col-md-4" style="margin-top:70px;background-color:white;padding-right:0px;">
	<!--for demo wrap-->
	<h3>MENTORS</h3>
	 <nav class="navbar navbar-default">
        <div class="nav nav-justified navbar-nav">
            <form class="navbar-form navbar-search" role="search">
                <div class="input-group">
                    <div class="input-group-btn">
                        <button type="button" class="btn btn-search btn-default dropdown-toggle" data-toggle="dropdown" id="searchB">
                            <span class="glyphicon glyphicon-search"></span>
                            <span class="label-icon" id="drop1">Search</span>   
                        </button>
                        <ul class="dropdown-menu pull-left" role="menu" id="dropdownM">
                           <li>
                                <a href="#">
                                    <span class="label-icon" id="drop1" style="color:black;">Location</span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                               
                                <span class="label-icon " id="drop1"   style="color:black;">Company</span>
                                </a>
                            </li>
                             <li>
                                <a href="#">
                                
                                <span class="label-icon" id="drop1" style="color:black;">Name</span>
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
  <div class="tbl-header-mentor">
  
    <table cellpadding="0" cellspacing="0" border="0">
      <thead>
        <tr class="MentorTR">
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
      <tbody class="mentoR">
       <c:forEach items="${Mentors}" var="mentor">
			<tr class="para mentor AllMent"><td><c:out value="${mentor.firstName}"></c:out></td>
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
<!--  
     <a class="btn btn-block btn-primary" id="createPair"> <i class="fa fa-plus"></i><i class="fa fa-group"></i> Create Pair </a>-->
</section>
</body>

</html>
