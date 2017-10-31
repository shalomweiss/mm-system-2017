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
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<head>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style type="text/css"><%@include file="WEB-INF/css/styles.css" %>
</style>
	<script>
	$(document).ready(function(){
		$("tr").click(function() {
		    $(this).addClass('selected').siblings().removeClass("selected");
		});
		$("#createPair").click(function(){
			var trs= document.getElementsByClassName("selected");
			if(trs.length==2)
			{
				var menteeId=trs[0].getElementsByClassName("menteeId")[0].innerHTML;
				var mentorId=trs[1].getElementsByClassName("mentorId")[0].innerHTML;
				$.post("CreateNewPair",
				        {
				          menteeID: menteeId,
				          mentorID: mentorId
				        },
				        function(data,status){
				        	location.reload();
				        });
				var body=document.getElementsByTagName("body")[0];
				body.innerHTML='<div class="waiting"><div class="loader">Loading...</div><p class="sorry">Sorry, Please wait...<br>We are making the world a better place one pair at a time :)</p>';
				
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

<style>
div.inner--left1{
		width:40%;
       	left: 100px;
}
div.inner--right{
	left : calc( 100px + 50%);
}
th{
	font-size: 12px;
}
tr:nth-child(even) {
    background-color: #ccc !important;
}
</style>
<body>
<nav class="icon-bar">
	<div class="icon-bar">
			<a  href="GetAllPairs" title="Back"><i class="fa fa-arrow-circle-left"></i></a> 
		 <a  href="ForwardPath" title="Home"><i class="fa fa-home"></i></a> 
		  <a href="GetAllMentors" title="Mentors"><i class="fa fa-black-tie"></i></a> 
		  <a href="GetAllMentees"title="Mentees"><i class="fa fa-graduation-cap"></i></a> 
		  <a class="active" href="GetAllPairs" title="Pairs"><i class="fa fa-group"></i></a>
		 
		  <a href="GetAllAcademicInstitution" title="Reports"><i class="fa fa-clipboard"></i></a>	
		  <a href="#" title="Logout"><i class="fa glyphicon">&#xe163;</i></a>	  
		   
	</div>
</nav>
<div class="topPart"> </div>
	<div class="bottomPart"> </div>
	<div class="inner inner--left1">
	<section class="Pairs">
		<div class="container-fluid" >
			 <div style= "padding-left: 0px;">
    <h5 id="mentee">MENTEE</h5>
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
                                    <span class="label-icon" id="drop"  >Location</span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                	<span class="label-icon" id="drop">University</span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                <span class="label-icon" id="drop1">Search</span>
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
        <tr>
          <th width="18%">Name</th>
          <th width="18%">Phone</th>
          <th width="17%">Gender</th>
          <th width="18%">Area</th>
          <th width="21%">Academy</th>
          <th width="8%"><i class="fa fa-file-text-o"></i></th>
        </tr>
      </thead>
    </table>
  </div>
  <div class="tbl-content tbl-content-pair">
    <table cellpadding="0" cellspacing="0" border="0" id="myTable">
      <tbody>
      <c:forEach var="mentee" items="${Mentees}" >
			<tr class="mentee" id="tabletest">
			<td width="18%">${mentee.firstName} ${mentee.lastName}</td>
			<td width="18%">${mentee.phoneNumber}</td>
			<td width="16%">${mentee.gender}</td>
			<td width="18%">${mentee.address}</td>
			<td width="20%">${mentee.academiclnstitution}</td>
			<td width="8%"><i class="fa fa-file-text-o"></i></td>
			<td style="display:none;" class="menteeId"><c:out value="${mentee.id}"></c:out></td>
			<td style="display:none;" class="menteeAddress"><c:out value="${mentee.address}"></c:out></td>
			<td style="display:none;" class="menteeUniversity"><c:out value="${mentee.academiclnstitution}"></c:out></td></tr>
		</c:forEach>
      </tbody>
    </table>
  </div>
	</div>		
		</div>
	</section>
	
	
	
	
	
	</div>
	<h1>New Pairs</h1>
	<div class="topPart"> </div>
	<div class="bottomPart"> </div>
	<div class="inner inner--right">
	<section class="Pairs">

<div class="container-fluid" >

   
    <div style= "padding-right: 0px;" >
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
                        </button>
                        <ul class="dropdown-menu pull-left" role="menu" id="dropdownM">
                           <li>
                                <a href="#">
                                    
                                    <span class="label-icon" id="drop1">Location</span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                
                                <span class="label-icon" id="drop1">Company</span>
                                </a>
                            </li>
                             <li>
                                <a href="#">
                                <span class="label-icon" id="drop1">Search</span>
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
        <tr>
          <th width="18%">Name</th>
          <th width="18%">Phone</th>
          <th width="17%">Gender</th>
          <th width="18%">Area</th>
          <th width="21%">company</th>
        </tr>
      </thead>
    </table>
  </div>
  <div class="tbl-content tbl-content-pair">
    <table cellpadding="0" cellspacing="0" border="0" id="myTable1">
      <tbody >
       <c:forEach items="${Mentors}" var="mentor">
			<tr class="mentor">
				<td>${mentor.firstName} ${mentor.lastName}</td>
				<td>${mentor.phoneNumber}</td>
				<td>${mentor.gender}</td>
				<td>${mentor.address}</td>
				<td>${mentor.company}</td>
				<td style="display:none;" class="mentorId"><c:out value="${mentor.id}"></c:out></td>
				<td style="display:none;" class="mentorAddress"><c:out value="${mentor.address}"></c:out></td>
				<td style="display:none;" class="mentorCompany"><c:out value="${mentor.company}"></c:out></td>
			</tr>
		</c:forEach>
      </tbody>
    </table>
  </div>
	</div>
  </div>
    
</section>
</div>
 <a class="btn btn-block btn-primary createPairs" id="createPair">
  <i class="fa fa-plus"></i>
  <i class="fa fa-group"></i><br> 
  Create <br>Pair </a>
</body>

</html>