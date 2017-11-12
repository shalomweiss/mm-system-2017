<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
	integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js"
	integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"
	integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"
	integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>


<script type="text/javascript" src="jquery.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<style type="text/css"><%@include file="/WEB-INF/css/styles.css"%></style>
<style type="text/css"><%@include file="/WEB-INF/css/styles1.css"%></style>

<script> 

$(document).ready(function(){
	$(".para").click(function() {
	    $(this).addClass('selected').siblings().removeClass("selected");
	});
	
	$(".female").click(function(){
		var female=document.getElementsByClassName("female")[0];
		female.id="clickedGender";
		var male=document.getElementsByClassName("male")[0];
		male.id="noclickedGender";
	});
	$( "form" ).submit(function( event ) {
		  alert( "Please wait for the data to loaded" );
		  console.log(this);
		  event.preventDefault();
		  var select=$(this).find( "Select:hidden" ).css('display','block');
		  for (var i = 0; i < select.length; i++) {
			  select[i].childNodes[1].selected= true;
		} 
		  this.submit();
		  var body=document.getElementsByTagName("body")[0];
			body.innerHTML='<div class="waiting"><div class="loader">Loading...</div><p class="sorry">Sorry, Please wait...<br>We are making the world a better place one pair at a time :)</p>';
		});
	$(".male").click(function(){
		var female=document.getElementsByClassName("female")[0];
		female.id="noclickedGender";
		var male=document.getElementsByClassName("male")[0];
		male.id="clickedGender";
	});
	
	
});
</script>
<script type="text/javascript">

var prevRow;

function areYouSure(param)
{
	console.log(param.parentNode.parentNode.childNodes[1].innerHTML);
	var row=param.parentNode.parentNode;
	console.log(document.getElementById("dannyZ").getElementsByTagName("H5")[0]);
	var areYouSure=document.getElementById("dannyZ");
	areYouSure.getElementsByTagName("H5")[0].innerHTML="Are you sure yo want to delete: <br>"+row.childNodes[3].innerHTML+" ?";
	areYouSure.style.display="";
	areYouSure.getElementsByTagName("FOOTER")[0].id=""+row.childNodes[1].innerHTML;
}
function da(param)
{
	var row=document.getElementById("row"+param.parentNode.id);
	deactivate(row);
	nyet(param);
}
function nyet(param){
	param.parentNode.parentNode.parentNode.style.display="none";
}
function deactivate(row)
{
	$.post("DeactivateUser",{
		'userId':row.firstChild.nextSibling.innerHTML,
	},
	        function(data,status){
	        	alert(data);
	        });
	row.parentNode.removeChild(row.nextSibling.nextSibling);
	row.parentNode.removeChild(row);
	
}
function sendAPK(param)
{
	var thisForm=param.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode;
	var rowColumns=thisForm.childNodes[1].childNodes[1].childNodes[1].childNodes[2].childNodes;
	var fname=rowColumns[1].childNodes[1].innerHTML;
	var lname=rowColumns[3].childNodes[1].innerHTML;
	var email=rowColumns[11].childNodes[1].innerHTML;
	console.log(fname+" "+lname+" "+email);
	$.post("SendAPK",
	        {
				uFirstName: fname,
				uLastName: lname,
				uEmail:email
	        },
	        function(data,status){
	        	alert(data);
	        });
}
	function show_hide_row(row,mentId,def) {
		$("#" + prevRow).toggle();
		$("#" + row).toggle();
		document.getElementById(def).click();
		prevRow=row;
		
		for(var i=1;i<=12;i++)  //length of inputs
		{
		showStuff("input"+i+mentId,"div"+i+mentId);
		}
		
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
		$( "div.tbl-header" ).scrollTop(heightPX);
		
	backUpInputs(mentId);

	}
	function closeRow(row,mentId) {
		//hide the row
		$("#" + row).toggle();
		prevRow=null;
		
		for(var i=1;i<=14;i++)  //length of inputs
			{
			showStuff("input"+i+mentId,"div"+i+mentId);
			}
		backUpInputs(mentId);
		
	}
	function backUpInputs(mentId){
		for(var i=1;i<=12;i++)  //length of inputs
		{
			document.getElementById("input"+i+mentId).value =document.getElementById("div"+i+mentId).innerHTML;
		}
	}
	 function exportToCsv(filename, rows) {
	        var processRow = function (row) {
	            var finalVal = '';
	            for (var j = 0; j < row.length; j++) {
	                var innerValue = row[j] === null ? '' : row[j].toString();
	                if (row[j] instanceof Date) {
	                    innerValue = row[j].toLocaleString();
	                };
	                var result = innerValue.replace(/"/g, '""');
	                if (result.search(/("|,|\n)/g) >= 0)
	                    result = '"' + result + '"';
	                if (j > 0)
	                    finalVal += ',';
	                finalVal += result;
	            }
	            return finalVal + '\n';
	        };

	        var csvFile = "\ufeff"+'';
	        for (var i = 0; i < rows.length; i++) {
	            csvFile += processRow(rows[i]);
	        }
	        var blob = new Blob([csvFile], { type: 'text/csv;charset=utf-8;' });
	        if (navigator.msSaveBlob) { // IE 10+
	            navigator.msSaveBlob(blob, filename);
	        } else {
	            var link = document.createElement("a");
	            if (link.download !== undefined) { // feature detection
	                // Browsers that support HTML5 download attribute
	                var url = URL.createObjectURL(blob);
	                link.setAttribute("href", url);
	                link.setAttribute("download", filename);
	                link.style.visibility = 'hidden';
	                document.body.appendChild(link);
	                link.click();
	                document.body.removeChild(link);
	            }
	        }
	    }
	function mentorTableToArray(param)
	{
		
		var matrix=[['First Name','Last Name','Gender','ID','Phone Number','Email','Experience','Role','Company','Work History','Volunteering','Notes','Address','City','Area','Joining Date',]];
		var tbody=document.getElementsByTagName("tbody")[0];
		var rows=tbody.getElementsByClassName("hidden_row");
		for (var i = 0; i < rows.length; i++) {
			var columns=rows[i].childNodes[1].getElementsByTagName("td");
			var row=[];
			for (var j = 0; j < columns.length; j++) {
				var ob= columns[j].childNodes[1];
				console.log(ob);
				if(typeof ob=="object")
					if(ob.tagName=="DIV")
						row.push(columns[j].childNodes[1].innerHTML);
			}
			row.push(columns[17].innerHTML)
			matrix.push(row);
		}
		//console.log(matrix);
		exportToCsv('Mentors.csv',matrix);
	}
</script>

<script>
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
	function showStuff(hide, show) {
		if(document.getElementById(show).tagName=='SELECT')
			document.getElementById(show).childNodes[1].selected = "true";
	    document.getElementById(show).style.display  = '';
	    document.getElementById(hide).style.display  = 'none'; 
	}
	
	
</script>
<style>
	input[type=text], select, textarea {
		width: 100%; /* Full width */
		padding: 12px; /* Some padding */
		border: 1px solid #ccc; /* Gray border */
		border-radius: 4px; /* Rounded borders */
		box-sizing: border-box;
		/* Make sure that padding and width stays in place */
		margin-top: 6px; /* Add a top margin */
		margin-bottom: 16px; /* Bottom margin */
		resize: vertical
			/* Allow the user to vertically resize the textarea (not horizontally) */
	}


</style>
<body>



	<!-- welcome bar -->
	<nav class="icon-bar">
		<div class="icon-bar">
		  <a  href="ForwardPath" title="Home"><i class="fa fa-home"></i></a> 
		  <a class="active" href="GetAllMentors" title="Mentors"><i class="fa fa-black-tie"></i></a> 
		  <a href="GetAllMentees" title="Mentees"><i class="fa fa-graduation-cap"></i></a> 
		  <a href="GetAllPairs" title="Pairs"><i class="fa fa-group"></i></a>
		  <a href="GetAllAcademicInstitution" title="Reports"><i class="fa fa-clipboard"></i></a>
		  <a href="AddingDataServlet" title="AddingStuff"><i class="fa fa-cogs"></i></a>	
		  <a href="#" title="Logout"><i class="fa glyphicon">&#xe163;</i></a>  		  
	</div>
	</nav>
	<h1>Mentors</h1>

	<div class="topPart"> </div>
	<div class="bottomPart"> </div>
	<div class="inner">
	
	<section class="Pairs">
		<table id="table_detail" cellpadding="0" cellspacing="0" border="0">
			<thead class="tbl-header-mentor">
					<tr>
						<th>Name</th>
						<th>Phone</th>
						<th>Workplace</th>
						<th>Gender</th>
						<th>Actions</th>
					</tr>

				</thead>
				</table>
		<!--for demo wrap-->
		<div class="tbl-header">

			<table id="table_detail" cellpadding="0" cellspacing="0" border="0">
				
				

				<div class="tbl-content" style="height: 100%">
					<tbody>
						<c:forEach items="${Mentors}" var="ment">
							<tr id="row${ment.id}" class="stam"
								onclick="show_hide_row('hidden_row${ment.id}',${ment.id},'defultOpen${ment.id}');">
								<td style="display:none">${ment.id}</td>
								<td>${ment.firstName} ${ment.lastName}</td>
								<td>${ment.phoneNumber}</td>
								<td>${ment.companyName}</td>
								<td><c:if test="${ment.gender == 0}">fe</c:if>male</td><td>
									<button onclick="areYouSure(this)" class="btn btn-block btn-primary"  style="margin-top: 0px;" >
			 							Deactivate
    								</button><br>
								</td>
							</tr>

							<tr id="hidden_row${ment.id}" class="hidden_row">
								<td colspan=5>
									<div class="tab tabMentor">

										<button class="tablinks" id="defultOpen${ment.id}"
											onclick="showDetails(event, 'info${ment.id}')">Info</button>
										<button class="tablinks"
											onclick="showDetails(event, 'Experience${ment.id}')">Experience</button>
										<button class="tablinks"
											onclick="showDetails(event, 'Volunteering${ment.id}')">Volunteering</button>
										<button class="tablinks"
											onclick="showDetails(event, 'Notes${ment.id}')">Notes</button>
										<button class="tablinks" style="float: right;"
											onclick="closeRow('hidden_row${ment.id}',${ment.id});">Close</button>
									</div>
									<form id="form${ment.id}" action="UpdateMentor" method="post" novalidate>
										<div id="info${ment.id}" class="tabcontent"
											style="background-color: rgba(108,136,225,0.9);">



											<table class="w3-table-all w3-card-4">
												<tr>
													<th width="14%" class="inner">First name</th>
													<th width="14%" class="inner">Last name</th>
													<th width="10%" class="inner">Gender</th>
													<th width="12%" class="inner">ID</th>
													<th width="12%" class="inner">Phone</th>
													<th width="18%" class="inner">Email</th>
													<th width="10%" class="inner">Picture</th>
													<th width="10%" class="inner">Actions</th>
													
												</tr>
												<tr>
													<td width="14%">
														<div id="div1${ment.id}"
															ondblclick="showStuff('div1${ment.id}','input1${ment.id}');">${ment.firstName}</div>
														<input id="input1${ment.id}" name="uFirstName" type="text"
														value="${ment.firstName}" style="display: none;"
														required>
													</td>

													<td width="14%">
														<div id="div2${ment.id}"
															ondblclick="showStuff('div2${ment.id}','input2${ment.id}');">${ment.lastName}</div>
														<input id="input2${ment.id}" name="uLastName" type="text"
														value="${ment.lastName}" style="display: none;"
														required>
													</td>
													<td width="10%">
														<div id="div3${ment.id}" ondblclick="showStuff('div3${ment.id}','input3${ment.id}');"><c:if test="${ment.gender == 0}">fe</c:if>male</div>
														<select name="uGender" id="input3${ment.id}">
							     							<option selected value="${ment.gender}"></option>
							     							<option  value="0">Male</option>
							     		 					<option value="1">Female</option>
					      								</select>					

													</td>
													<td width="12%">
														<div id="div4${ment.id}"
															ondblclick="showStuff('div4${ment.id}','input4${ment.id}');">${ment.address}</div>
														<input id="input4${ment.id}" name="uAddress" type="text"
														value="${ment.address}" style="display: none;"
														required>
													</td>
													<td width="12%">
														<div id="div5${ment.id}"
															ondblclick="showStuff('div5${ment.id}','input5${ment.id}');">${ment.phoneNumber}</div>
														<input id="input5${ment.id}" name="uPhoneNumber"
														type="text" value="${ment.phoneNumber}"
														style="display: none;"
														required>
													</td>
													<td width="18%">
														<div id="div6${ment.id}"
															ondblclick="showStuff('div6${ment.id}','input6${ment.id}');">${ment.email}</div>
														<input id="input6${ment.id}" name="uEmail" type="text"
														value="${ment.email}" style="display: none;"
														required>
													</td>
													<td width="10%">
														<img src="DownloadFile?img=${ment.id}" alt="profilePic">
													</td>
													<td width="10%"><input class="saveButton" id="submit${ment.id}" type="submit"
														value="Save"><br>
														<input onclick="sendAPK(this)" id="submit${ment.id}" type="button"
														value="Mail">
													</td>
												</tr>
											</table>


										</div>

										<div id="Experience${ment.id}" class="tabcontent"
											style="background-color: rgba(108,136,225,0.9);">

											<table class="w3-table-all w3-card-4">
												<tr>
													<th width="30%" class="inner">Experience</th>
													<th width="15%" class="inner">Role</th>
													<th width="15%" class="inner">company</th>
													<th width="30%" class="inner">workHistory</th>
													<th width="10%" class="inner">Actions</th>
												</tr>
												<tr>
													<td>
														<div id="div7${ment.id}"
															ondblclick="showStuff('div7${ment.id}','input7${ment.id}');">${ment.experience}</div>
														<input id="input7${ment.id}" name="uExperience"
														type="text" value="${ment.experience}"
														style="display: none;"
														required>
													</td>
													<td>
														<div id="div8${ment.id}"
															ondblclick="showStuff('div8${ment.id}','input8${ment.id}');">${ment.role}</div>
														<input id="input8${ment.id}" name="uRole" type="text"
														value="${ment.role}" style="display: none;"
														required>
													</td>
													<td>
														<div id="div12${ment.id}"
															ondblclick="showStuff('div12${ment.id}','input12${ment.id}');">${ment.companyName}</div>
														<select name="uCompany" id="input12${ment.id}" style="display: none;" required >
																<option value="${ment.company}" selected="selected"></option>
																<c:forEach var="item" items="${NewWorkPlace}">
																	<option value="${item.id}">   ${item.company}</option>
																</c:forEach>
														</select>

													</td>
													<td>
														<div id="div9${ment.id}"
															ondblclick="showStuff('div9${ment.id}','input9${ment.id}');">${ment.workHistory}</div>
														<input id="input9${ment.id}" name="uWorkHistory"
														type="text" value="${ment.workHistory}"
														style="display: none;"
														required>
													</td>


													<td>
														<input class="saveButton" id="submit${ment.id}" type="submit" value="Save"><br>
														<input onclick="sendAPK(this)" id="submit${ment.id}" type="button" value="Mail">
													</td>
												</tr>
											</table>

										</div>

										<div id="Notes${ment.id}" class="tabcontent"
											style="background-color: rgba(108,136,225,0.9);">
											<table>
												<tr>
												<th width="30%" class="inner">Notes</th>
												<th width="15%" class="inner">Address</th>	
												<th width="15%" class="inner">City</th>	
												<th width="15%" class="inner">Area</th>	
												<th width="15%" class="inner">Date</th>	
												<th width="10%" class="inner">Actions</th>
													
												</tr>
												<tr>
													<td width="30%">
														<div id="div10${ment.id}"
															ondblclick="showStuff('div10${ment.id}','input10${ment.id}');">${ment.note}</div>
														<textarea id="input10${ment.id}" name="uNotes"
															style="display: none; ">${ment.note}</textarea>
													</td>
													<td width="15%">
														<div id="div15${ment.id}"
															ondblclick="showStuff('div15${ment.id}','input15${ment.id}');">${ment.address}</div>
														<input id="input15${ment.id}" name="uAddress" type="text"
														value="${ment.address}" style="display: none;"
														required>		
													</td>
													<td width="15%">
														<div id="div13${ment.id}"
															ondblclick="showStuff('div13${ment.id}','input13${ment.id}');">${ment.city}</div>
														<select name="cityId" id="input13${ment.id}" style="display: none;" required >
																<option value="${ment.cityId}"></option>
																<c:forEach var="item" items="${cities}">
																	<option value="${item.id}">   ${item.name}</option>
																</c:forEach>
														</select>						
													</td>
													<td width="15%">
														<div id="div14${ment.id}"
															ondblclick="showStuff('div14${ment.id}','input14${ment.id}');">${ment.area}</div>
														<select name="areaId" id="input14${ment.id}" style="display: none;" required >
																<option value="${ment.areaId}"></option>
																<c:forEach var="item" items="${areas}">
																	<option value="${item.id}">   ${item.name}</option>
																</c:forEach>
														</select>										
													</td>
													<td width="20%">${ment.joinDate}</td>
													<td width="10%"><input id="id:${ment.id}" name="uId" type="text"
														value="${ment.id}" style="display: none;"
														onblur="if(this.value==''){ this.value='id'; this.style.color='#BBB';}" 
							  							onfocus="if(this.value=='id'){this.value=''; this.style.color='#000';}">
														<input class="saveButton" type="submit" id="submit${ment.id}" style="float: center;" value="Save">
														<br>
														<input onclick="sendAPK(this)" type="button" id="submit${ment.id}" style="float: center;" value="Mail">

													</td>
												
												</tr>

											

											</table>
										</div>


										<div id="Volunteering${ment.id}" class="tabcontent"
											style="background-color: rgba(108,136,225,0.9);">
											<table>


												<tr>
													<th width="90%" class="inner">Volunteering</th>
													<th width="10%" class="inner">Actions</th>
													
												</tr>
												
												<tr>
													<td width="90%">
														<div id="div11${ment.id}"
															ondblclick="showStuff('div11${ment.id}','input11${ment.id}');">${ment.volunteering}</div>

														<textarea id="input11${ment.id}" name="uVolunteering"
															value="${ment.volunteering}"
															style="display: none; height: 100px;">${ment.volunteering}</textarea>
													</td>
													<td width="10%">
													<input type="submit" id="submit${ment.id}"
													class="saveButton"
														style="float: center;" value="Save">
														<br>
													<input onclick="sendAPK(this)" type="button" id="submit${ment.id}"
														style="float: center;" value="Mail"></td>
												</tr>
												
													
											</table>
										</div>
										</form>
								</td>
							</tr>



							
						</c:forEach>

					</tbody>
				
			</table>
		</div>




		<div id="openModal3" class="modalDialog">
				<div class="container">
					<a href="#close" title="Close" class="close"
						style="position: absolute; background-color: red;">X</a>

					<form action="AddNewMentor" method="post" novalidate>
						<table class="addMentorForm">
							<tr>
								<td class="form">First Name:</td>
								<td class="form"><input type="text" name="firstName" required></td>
								<td class="form">Last Name:</td>
								<td class="form"><input type="text" name="lastName" required></td>
								<td class="form">Email</td>
								<td class="form"><input type="text" name="email" required></td>
							</tr>
							<tr>
								<td class="form">Phone number</td>
								<td class="form"><input type="number" name="phoneNumber" required></td>
								<td class="form">Gender</td>
								<td class="form">
									
									<select name="gender" class="selectpicker reports" id="gender1" >
		    	 	 					<option></option>
		     							<option value="1">Male</option>
		     		 					<option value="0">Female</option>
	      							</select>
									
									
								</td>
								<td class="form">Address</td>
								<td class="form"><input type="text" name="address" required></td>
									
							</tr>
							<tr>
								
								<td>Role</td>
								<td class="form"><input type="text" name="role" required></td>
								<td class="form">Experience</td>
								<td class="form" colspan="3"><textarea name="experience"
										style="height: 50px"></textarea></td>
							</tr>
							<tr>
							<td class="form">Company</td>
								<td class="form">
								<select name="company">
										<option value=""></option>
										<c:forEach var="item" items="${NewWorkPlace}">
											<option value="${item.id}">   ${item.company}</option>
										</c:forEach>
								</select>
								</td>
								
								<td class="form">volunteering</td>
								<td class="form" colspan="3"><textarea name="volunteering"
										style="height: 50px"></textarea></td>
							</tr>
							<tr>
								
							</tr>
							<tr>
								<td>City</td>
								<td class="form">
									<select name="cityId">
											<option value="1"></option>
											<c:forEach var="item" items="${cities}">
												<option value="${item.id}">   ${item.name}</option>
											</c:forEach>
									</select>
								</td>
								<td class="form">Work History</td>
								<td class="form" colspan="3"><textarea name="history"
										style="height: 50px"></textarea></td>
							</tr>
							<tr>
								<td>Area</td>
								<td class="form">
									<select name="areaId">
										<option value="1"></option>
											<c:forEach var="item" items="${areas}">
												<option value="${item.id}">   ${item.name}</option>
											</c:forEach>
									</select>
								</td>
								<td class="form">note</td>
								<td class="form" colspan="2"><textarea name="notes"
										style="height: 50px"></textarea></td>
										<td><input class="saveButton" style="padding: 10px 20px;" type="submit" value="Add"><br>
							</tr>
						</table>
					</form>
				</div>
			</div>
	</section>
	<a href="#openModal3" class="btn btn-block btn-primary btn-addClick"> <i
			class="fa fa-plus"></i><i class="fa fa-graduation-cap"></i> Add
			Mentor
		</a>
		<a onclick="mentorTableToArray(this)" href="#" class="btn-print btn btn-block" >
			<i class="fa fa-print"></i> print</a>
	</div>
	<div id="dannyZ" class="DannyModal" style="display:none;">
	<div class="DannyModalIn">
		<header><h5>Are you Sure you want to deactivate</h5></header>
		<footer>
			<div onclick="da(this)" class="decision yes">YES</div>
			<div onclick="nyet(this)" class="decision no">NO</div>
		</footer>
		
	</div>
</div>
</body>
</html>