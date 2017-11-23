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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style type="text/css"><%@include file="/WEB-INF/css/styles.css"%></style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>Add work place academy or city</title>
<style type="text/css">
	td{
		padding-left: 20px !important;
		padding-top: 6px !important;
    padding-bottom: 6px !important;
	}
	.btn-primary
	{
		width:100%;
	    margin-top: 2px;
    	margin-bottom: 2px;
   	    padding-top: 4px;
    	padding-bottom: 4px;
	}
	td.in1{
		border: 1px solid #ddd;
		text-align: left;
		padding: 8px;
	}
	td.in{
		width:100%;
		text-align: left;
		 border: 1px solid #ddd;
		 padding: 8px;
	}
	input{
		padding:3px !important;
		float: right;
	}
	th.in{
	padding-top: 6px !important;
    padding-bottom: 6px !important;
    text-align: left;
    background-color: rgb(46,61,154);
    color: white;
	}
	tbody.in{
	
    overflow-y: auto;
    height:200px;
	}
	table.in{
	overflow: scroll;
	}
	tr.in:nth-child(even){background-color: #f2f2f2;}
 	tr.in:hover {background-color: #ddd;}
	div.in{
		border-left: 1px solid #ddd;
		height: calc( 25vh );
	    overflow-y: scroll;
	    overflow-x: hidden;
	    background-color: rgba(255, 255, 255, 0.3);
	}
	footer {
    width: 80%;
    position: absolute;
    bottom: 0;
    /* height: 30%; */
    right: 0;
    top: 20%;
    left: 8%;
}
	.DannyModalIn {
    border-radius: 12px !important;
    position: absolute;
    margin: auto;
    top: 0;
    right: 0;
    bottom: 0;
    left: 0;
    width: 35%;
    height: 40%;
    background-color: white;
}
h5{
	font-size: 3vh;

}
</style>
<script type="text/javascript">
$(document).ready(function(){
	$(".addB").click(function(){
		$("#danAcad").show();
		$("#addSend").parent().attr('id',this.id);
		$("#nameInput").val($(this).parent().parent().find("input").val());
	});
	$(".cancel").click(function(){
		$("#danAcad").hide();
	});
	$("#addSend").click(function(){
		var inputs=$(this).parent().parent().parent().find("input");
		var selects=$(this).parent().parent().parent().find("select");
		console.log(inputs);
		console.log(selects[0].value);
		if(!selects[0].value||!selects[1].value||!inputs[0].value)
			alert("please insert all the fields");
		else
		{
			if($(this).parent().attr('id')=="addWork"){
				$.post("AddWorkingPlace",
				        {
						  name: inputs[0].value,
						  cityId: selects[1].value,
						  areaId: selects[0].value,
						  address:""
				        },
				        function(data,status){
				        	location.reload();
				        });
			}
			else{
				$.post("AddAcademicInstitute",
				        {
						  name: inputs[0].value,
						  cityId: selects[1].value,
						  areaId: selects[0].value
				        },
				        function(data,status){
				        	location.reload();
				        });
			}
			
		}
		
		
	});
});
function sendAdded(param)
{
	var xmlhttp = new XMLHttpRequest();   // new HttpRequest instance 
	console.log(param.id);
	xmlhttp.open("POST", ""+param.id);
	xmlhttp.setRequestHeader("Content-Type", "application/json");
	console.log(param.parentNode.parentNode.getElementsByTagName("input")[0]); 
	console.log(param.parentNode.parentNode.getElementsByTagName("input")[0].value); 
	console.log(param.parentNode.parentNode.getElementsByTagName("input")[0].id); 
	xmlhttp.send(JSON.stringify({data: param.parentNode.parentNode.getElementByName}));	
}
function changeTable(param)
{
	var ps=document.getElementsByTagName("p");
	for(i=0;i<ps.length;i++)
		ps[i].className="add";
	param.className+=" clicked";
	$(".opTable").hide();
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
		  <a  title="Home" href="ForwardPath"><i class="fa fa-home"></i></a> 
		  <a href="GetAllMentors" title="Mentors"><i class="fa fa-black-tie"></i></a> 
		  <a href="GetAllMentees" title="Mentees"><i class="fa fa-graduation-cap"></i></a> 
		  <a href="GetAllPairs" title="Pairs"><i class="fa fa-group"></i></a>
		  <a href="GetAllAcademicInstitution" title="Reports"><i class="fa fa-clipboard"></i></a>
		  <a class="active" href="AddingDataServlet" title="AddingStuff"><i class="fa fa-cogs"></i></a>
		  <a onclick="logout()" href="#" title="Logout"><i class="fa glyphicon">&#xe163;</i></a>	  
	</div>
</nav>
	<div class="topPart"> </div>
	<div class="bottomPart"> </div>
	<h1>Data Attribute</h1>
	<div class="inner" style="bottom: 22%;">
		<section class="Pairs">
		<!--
			<table id="mainTable" cellpadding="0" cellspacing="0" border="0">
				<tr>
					<td><p onclick="changeTable(this)" class="add clicked">City</p></td>
					<td><p onclick="changeTable(this)" class="add">Workplace</p></td>
					<td><p onclick="changeTable(this)" class="add">Area</p></td>
					<td><p onclick="changeTable(this)" class="add">Academy</p></td>
				</tr>
			</table>
		  -->
		<table style=" margin-top: 2vh;" class="opTable" id="City" cellpadding="0" cellspacing="0" border="0">
				<tr>
					<td width="25%">
						<table><tr class="in"><th class="in">Existing Cities</th></tr></table>
					<div class="in">
						<table class="in" >
							<tbody class="in">
								<c:forEach var="item" items="${cities}">
									<tr class="in"><td class="in">${item.name}</td></tr>
								</c:forEach>		
							</tbody>
						</table>
					</div>
					<table class="in"> 
							<tr>
									<td class="in1" width="70%" style=" border-right-width: 0px;">
										<input id="textfield" name="textfield" type="text" placeholder="Add city..">
									</td>
									<td class="in1" style=" border-left-width: 0px;" width="30%">
										<a id="addCity" class="btn btn-primary" href="#">Add</a>
									</td>
							</tr>
						</table>	
					</td>
					<td width="25%">
						<table><tr class="in"><th class="in">Existing Companies</th></tr></table>
					<div class="in">
						<table class="in" >
							<tbody class="in">
								<c:forEach var="item" items="${workplaces}">
									<tr class="in"><td class="in">${item.company}</td></tr>
								</c:forEach>		
							</tbody>
						</table>
					</div>
					<table class="in"> 
							<tr>
									<td class="in1" width="70%" style=" border-right-width: 0px;">
										<input id="textfield" name="textfield" type="text" placeholder="Add Company..">
									</td>
									<td class="in1" style=" border-left-width: 0px;" width="30%">
										<a id="addWork" class="btn btn-primary addB" href="#">Add</a>
									</td>
							</tr>
						</table>	
					</td>
					<td width="25%">
						<table><tr class="in"><th class="in">Existing Areas</th></tr></table>
					<div class="in">
						<table class="in" >
							<tbody class="in">
							<c:forEach var="item" items="${areas}">
								<tr class="in"><td class="in">${item.name}</td></tr>
							</c:forEach>
							</tbody>
						</table>
					</div>
					<table class="in"> 
							<tr>
									<td class="in1" width="70%" style=" border-right-width: 0px;">
										<input id="textfield" name="textfield" type="text" placeholder="Add area..">
									</td>
									<td class="in1" style=" border-left-width: 0px;" width="30%">
										<a id="addCity" class="btn btn-primary" href="#">Add</a>
									</td>
							</tr>
						</table>	
					</td>
					<td width="25%">
						<table><tr class="in"><th class="in">Existing Academies</th></tr></table>
					<div class="in">
						<table class="in" >
							<tbody class="in">
								<c:forEach var="item" items="${AcadimicIn}">
									<tr class="in"><td class="in">${item.name}</td></tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<table class="in"> 
							<tr>
									<td class="in1" width="70%" style=" border-right-width: 0px;">
										<input id="textfield" name="textfield" type="text" placeholder="Add academy..">
									</td>
									<td class="in1" style=" border-left-width: 0px;" width="30%">
										<a id="addAcad" class="btn btn-primary addB" href="#">Add</a>
									</td>
							</tr>
						</table>	
					</td>
				</tr>		
		</table>
	</section>
	
	</div>
	<div id="danAcad" class="DannyModal" style="display: none;">
		<div class="DannyModalIn" style="height: 50%;">
			<header><h5>Please Fill The Form</h5></header>
			<footer>
				<table>
					<tr>
						<td width="20%">Name</td>
						<td width="80%"><input type="text" id="nameInput"></td>
					</tr>
					<tr>
						<td>Area</td>
						<td>
							<select class="reports" style="width:100%" name="areaId" id="input16${ment.id}" required >
								<option value="${ment.areaId}"></option>
								<c:forEach var="item" items="${areas}">
									<option value="${item.id}">   ${item.name}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td>City</td>
						<td>
							<select class="reports" id="input15${ment.id}" style="width:100%">
									<option value="${ment.cityId}"></option>
									<c:forEach var="item" items="${cities}">
										<option value="${item.id}">   ${item.name}</option>
									</c:forEach>
							</select>	
						</td>
					</tr>
					<tr>
						<td colspan=2>
							<br>
							<a id="addSend" class="btn btn-primary" href="#">Add</a>
					</tr>
					<tr>
						<td colspan=2>
							<br>
							<a id="addCity" class="btn btn-primary cancel" href="#" style="background-color: darkgrey !important; border-color: darkgrey !important;">Cancel</a>
						</td>
					</tr>
				</table>
				
			</footer>
			
		</div>
	</div>
</body>
</html>