<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style type="text/css"><%@include file="/WEB-INF/css/styles.css"%></style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>Add work place academy or city</title>
<style type="text/css">
	td{
		text-align: center;
	}
	input{
		width:100%;
	}
</style>
<script type="text/javascript">
function sendAdded(param)
{
	var xmlhttp = new XMLHttpRequest();   // new HttpRequest instance 
	//xmlhttp.open("POST", "/"+param.id);
	//xmlhttp.setRequestHeader("Content-Type", "application/json");
	console.log(param.parentNode.parentNode.getElementsByTagName("input")[0]); 
	console.log(param.parentNode.parentNode.getElementsByTagName("input")[0].value); 
	console.log(param.parentNode.parentNode.getElementsByTagName("input")[0].id); 
	//xmlhttp.send(JSON.stringify({data: param.parentNode.parentNode.getElementByName}));	
}

function changeTable(param)
{
	var ps=document.getElementsByTagName("p");
	for(i=0;i<ps.length;i++)
		ps[i].className="add";
	param.className+=" clicked";
	var tables=document.getElementsByTagName("table");
	for(i=0;i<tables.length;i++)
		tables[i].style.display="none";
	var chosenTable=document.getElementById(param.innerHTML);
	chosenTable.style.display="";
	var chosenTable1=document.getElementById("mainTable");
	chosenTable1.style.display="";
	var section=document.getElementsByTagName("section")[0];
	section.removeChild(chosenTable);
	section.removeChild(chosenTable1);
	section.insertBefore(chosenTable,section.firstChild);
	section.insertBefore(chosenTable1,section.firstChild);
}
</script>
</head>
<body>
	<nav class="icon-bar">
	<div class="icon-bar">
		  <a class="active" title="Home" href="ForwardPath"><i class="fa fa-home"></i></a> 
		  <a href="GetAllMentors" title="Mentors"><i class="fa fa-black-tie"></i></a> 
		  <a href="GetAllMentees" title="Mentees"><i class="fa fa-graduation-cap"></i></a> 
		  <a href="GetAllPairs" title="Pairs"><i class="fa fa-group"></i></a>
		  <a href="GetAllAcademicInstitution" title="Reports"><i class="fa fa-clipboard"></i></a>
		  <a href="AddingDataServlet" title="AddingStuff"><i class="fa fa-cogs"></i></a>
		  <a onclick="logout()" href="#" title="Logout"><i class="fa glyphicon">&#xe163;</i></a>	  
	</div>
</nav>
	<div class="topPart"> </div>
	<div class="bottomPart"> </div>
	<h1>Data Attribute</h1>
	<div class="inner" style="bottom: 42%;">
		<section class="Pairs">
		<table id="mainTable" cellpadding="0" cellspacing="0" border="0">
				<tr colspan="3">
					<td><p onclick="changeTable(this)" class="add clicked">City</p></td>
					<td><p onclick="changeTable(this)" class="add">Workplace</p></td>
					<td><p onclick="changeTable(this)" class="add">Area</p></td>
					<td><p onclick="changeTable(this)" class="add">Academy</p></td>
				</tr>
		</table>
		<table id="City" cellpadding="0" cellspacing="0" border="0">
				<tr>
					<td width="15%">Existing Cities:</td>
					<td width="25%">
						<select class="selectpicker reports" style="width:100%"  >
							<c:forEach var="item" items="${Cities}">
									<option>${item.name}</option>
							</c:forEach>
      					</select>
					</td>
					<td width="15%">Add Cities:</td>
					<td width="25%">
							<input name="uAddress"  class="reports"  type="text" id="city1"
				  				onblur="if(this.value==''){ this.value='city'; this.style.color='#BBB';}" 
								onfocus="if(this.value=='city'){this.value=''; this.style.color='#000';}"/>
					</td>
					<td width="20%">
						<a id="addCity" onclick="sendAdded(this)" style="width:80%" class="btn btn-primary" href="#">Add</a>
					</td>
				</tr>		
		</table>
		<table style="display:none" id="Workplace" cellpadding="0" cellspacing="0" border="0">
				<br>
				<tr colspan="4">
					<td width="15%">Existing Workplaces:</td>
					<td width="25%">
						<select class="selectpicker reports" style="width:100%"  >
							<c:forEach var="item" items="${Workplaces}">
									<option>${item.name}</option>
							</c:forEach>
      					</select>
					</td>
					<td width="15%">Add Workplace:</td>
					<td width="25%">
							<input name="uCompany"  class="reports"  type="text" id="city1"
				  				onblur="if(this.value==''){ this.value='city'; this.style.color='#BBB';}" 
								onfocus="if(this.value=='city'){this.value=''; this.style.color='#000';}"/>
					</td>
					<td width="20%">
						<a id="addWorkplace" onclick="sendAdded(this)" style="width:80%" class="btn btn-primary" href="#">Add</a>
					</td>
				</tr>		
		</table>
		<table style="display:none" id="Area" cellpadding="0" cellspacing="0" border="0">
				<br>
				<tr colspan="4">
					<td width="15%">Existing Areas:</td>
					<td width="25%">
						<select class="selectpicker reports" style="width:100%"  >
							<c:forEach var="item" items="${Workplaces}">
									<option>${item.name}</option>
							</c:forEach>
      					</select>
					</td>
					<td width="15%">Add Area:</td>
					<td width="25%">
							<input name="uArea"  class="reports"  type="text" id="city1"
				  				onblur="if(this.value==''){ this.value='city'; this.style.color='#BBB';}" 
								onfocus="if(this.value=='city'){this.value=''; this.style.color='#000';}"/>
					</td>
					<td width="20%">
						<a id="addArea" onclick="sendAdded(this)" style="width:80%" class="btn btn-primary" href="#">Add</a>
					</td>
				</tr>		
		</table>
		<table style="display:none" id="Academy" cellpadding="0" cellspacing="0" border="0">
				<br>
				<tr colspan="4">
					<td width="15%">Existing Academies:</td>
					<td width="25%">
						<select class="selectpicker reports" style="width:100%"  >
							<c:forEach var="item" items="${Workplaces}">
									<option>${item.name}</option>
							</c:forEach>
      					</select>
					</td>
					<td width="15%">Add Academy:</td>
					<td width="25%">
							<input name="uAcademy"  class="reports"  type="text" id="city1"
				  				onblur="if(this.value==''){ this.value='city'; this.style.color='#BBB';}" 
								onfocus="if(this.value=='city'){this.value=''; this.style.color='#000';}"/>
					</td>
					<td width="20%">
						<a id="addAcademy" onclick="sendAdded(this)" style="width:80%" class="btn btn-primary" href="#">Add</a>
					</td>
				</tr>		
		</table>
	</section>
	
	</div>
</body>
</html>