<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="mm.model.Mentee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<
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



 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<style type="text/css"><%@include file="/WEB-INF/css/styles.css"%></style>
<style type="text/css"><%@include file="/WEB-INF/css/styles1.css"%></style>
<script type="text/javascript">
	
$(document).ready(function(){
	
	$(".female").click(function(){
		var female=document.getElementsByClassName("female")[0];
		female.id="clickedGender";
		var male=document.getElementsByClassName("male")[0];
		male.id="noclickedGender";
	});
	$(".male").click(function(){
		var female=document.getElementsByClassName("female")[0];
		female.id="noclickedGender";
		var male=document.getElementsByClassName("male")[0];
		male.id="clickedGender";
	});
	
	$(".Sign2").click(function(){
		var sign2=document.getElementsByClassName("Sign1")[0];
		sign2.id="clickedSign";
		var sign1=document.getElementsByClassName("Sign2")[0];
		sign1.id="noclickedclickedSign";
	});
	$(".Sign2").click(function(){
		var sign2=document.getElementsByClassName("Sign1")[0];
		sign2.id="noclickedclickedSign";
		var sign1=document.getElementsByClassName("Sign2")[0];
		sign1.id="clickedSign";
	});
	$(".stam1").click(function()
			{
		
			}
	
	);
	
	
	
	
	
	
});
	function goToEdit(firstName, lastName, phone, email, academicInstitution,
			note, courseOfStudy, remainingSemesters, average, id) {
		document.getElementById("fname").value = firstName;
		document.getElementById("lname").value = lastName;
		document.getElementById("phone").value = phone;
		document.getElementById("email").value = email;

		document.getElementById("academic").value = academicInstitution;
		document.getElementById("note").value = note;
		document.getElementById("course").value = courseOfStudy;
		document.getElementById("semesters").value = remainingSemesters;
		document.getElementById("average").value = average;
		document.getElementById("id").value = id;
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
			tablinks[i].className = tablinks[i].className
					.replace(" active", "");
		}

		// Show the current tab, and add an "active" class to the button that opened the tab
		document.getElementById(cityName).style.display = "block";
		evt.currentTarget.className += " active";
		foo();
	}
</script>
<script type="text/javascript" src="jquery.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<script type="text/javascript">

var prevRow;

	function show_hide_row1(row,mentId,def) {
		$("#" + prevRow).toggle();
		$("#" + row).toggle();
		
		//window.location.hash = '#'+row;
		document.getElementById(def).click();
		prevRow=row;
		
		for(var i=1;i<=13;i++)  //length of inputs
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
			if(childrenOfTheTbody[i].className=="stam1")
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
	function showStuff(hide, show) {
		
	     document.getElementById(show).style.display  = 'block';
	    document.getElementById(hide).style.display  = 'none';
	    
	}
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
		
	     document.getElementById(show).style.display  = 'block';
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
	<!-- add successfully alert -->
	<c:if test="${AddedSuc =='1'}">
		<script>
        alert("Mentee added successfully");
        //alert("${AddedSuc}");
       
    </script>
		<c:set var="AddedSuc" value="0" scope="request" />

	</c:if>

	<!-- welcome bar -->
	<nav class="icon-bar">
			<div class="icon-bar">
			
		  <a  href="ForwardPath" title="Home"><i class="fa fa-home"></i></a> 
		  <a href="GetAllMentors" title="Mentors"><i class="fa fa-black-tie"></i></a> 
		  <a class="active" href="GetAllMentees" title="Mentees"><i class="fa fa-graduation-cap"></i></a> 
		  <a href="GetAllPairs" title="Pairs"><i class="fa fa-group"></i></a>
		  <a href="GetAllAcademicInstitution" title="Reports"><i class="fa fa-clipboard"></i></a>	
		  <a href="AddingDataServlet" title="AddingStuff"><i class="fa fa-cogs"></i></a>
		  <a href="#" title="Logout"><i class="fa glyphicon">&#xe163;</i></a>
	</div>
	</nav>
	<h1>Mentees</h1>
	<div class="topPart"> </div>
	<div class="bottomPart"> </div>
	<div class="inner">
	<section class="Pairs">
		<!--for demo wrap-->
		<table id="table_detail" cellpadding="0" cellspacing="0" border="0">
		<thead class="tbl-header-mentee">
					<tr>
						<th>Name</th>
						<th>Phone</th>
						<th>Academy</th>
						<th>Gender</th>
						<th>Actions</th>
					</tr>

				</thead>
		</table>
		<div class="tbl-header" >

			<table id="table_detail" cellpadding="0" cellspacing="0"  border="0">
			<div class="tbl-content" style="height: 100%">
				<tbody >
					<c:forEach items="${Mentees}" var="ment">
					
						<tr class="stam1" onclick="show_hide_row1('hidden_row${ment.id}',${ment.id},'defultOpen${ment.id}');">
							    <td style="display: none">${ment.id}</td>
						    	<td>${ment.firstName} ${ment.lastName}</td>
								<td>${ment.phoneNumber}</td>
								<td>${ment.academiclnstitution}</td>
								<td>
									<c:if test="${ment.gender == 1}"> male </c:if>
									<c:if test="${ment.gender == 0}"> female </c:if> 
								</td>
								<td>
									<a class="btn btn-block btn-primary" href="" style="margin-top: 0px;" >
			 							Deactivate
    								</a><br>
								</td>
						</tr>
						<tr id="hidden_row${ment.id}" class="hidden_row"  >
							    <td colspan=5>
								<div class="tab tabMentee">

								<button class="tablinks" id="defultOpen${ment.id}" onclick="showDetails(event, 'info${ment.id}')">Info</button>
								<button class="tablinks" onclick="showDetails(event, 'Academic${ment.id}')">Academic</button>
										<button class="tablinks"
											onclick="showDetails(event, 'Notes${ment.id}')">Notes</button>
										<button class="tablinks"
											onclick="showDetails(event, 'Mentor${ment.id}')">Mentor</button>
										<button class="tablinks" style="float:right;" onclick="closeRow('hidden_row${ment.id}',${ment.id});">close</button>

								</div>
								<form id="form${ment.id}" action="UpdateMentee" method="post">
								<div id="info${ment.id}" class="tabcontent"style="background-color: rgba(250,178,58,0.8);">
											<table class="w3-table-all w3-card-4">
												<tr>
													<th width="14%" class="inner">First name</th>
													<th width="14%" class="inner">Last name</th>
													<th width="10%" class="inner">Gender</th>
													<th width="12%" class="inner">Address</th>
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
														value="${ment.firstName}" style="display: none;" required>
													</td>

													<td width="14%">
														<div id="div2${ment.id}"
															ondblclick="showStuff('div2${ment.id}','input2${ment.id}');">${ment.lastName}</div>
														<input id="input2${ment.id}" name="uLastName" type="text"
														value="${ment.lastName}" style="display: none;" required>
													</td>
													<td width="10%">
														<div id="div3${ment.id}"
															ondblclick="showStuff('div3${ment.id}','input3${ment.id}');">
															
															<c:if test="${ment.gender == 1}"> male </c:if> 
															<c:if test="${ment.gender == 0}"> female </c:if> 
															
															</div>
														
<c:if test="${ment.gender == 1}">  
										<div id="input3${ment.id}" style="display: none;">
												<input id="clickedGender" class="male" type="radio"
															name="uGender" value="1"  checked > Male
															<br>
										<input id="noclickedGender" class="female" type="radio" name="uGender"
														value="0" > female
												
												</div></c:if>
												
												<c:if test="${ment.gender == 0}">  
										<div id="input3${ment.id}" style="display: none;">
												<input id="clickedGender" class="male" type="radio"
															name="uGender" value="1"   > male
													<br>		
										<input id="noclickedGender" class="female" type="radio" name="uGender"
														value="0" checked> female
												
												</div></c:if>
													</td>
													<td width="12%">
														<div id="div4${ment.id}"
															ondblclick="showStuff('div4${ment.id}','input4${ment.id}');">${ment.address}</div>
														<input id="input4${ment.id}" name="uAddres" type="text"
														value="${ment.address}" style="display: none;"
														onblur="if(this.value==''){ this.value='address'; this.style.color='#BBB';}" 
							  							onfocus="if(this.value=='address'){this.value=''; this.style.color='#000';}">
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
														<img src="DownloadFile?id=${ment.id}&type=img">
													</td>
													<td width="10%">
														<input class="saveButton" id="submit${ment.id}" type="submit" value="Save">
														<input id="submit${ment.id}" type="submit" value="Mail"></td>
													</td>
														
													
												</tr>
											</table>


										</div>

										<div id="Academic${ment.id}" class="tabcontent"
											style="background-color: rgba(250,178,58,0.8);">

											<table class="w3-table-all w3-card-4">
												<tr>
													<th width="10%" class="inner">CV</th>
													<th width="10%" class="inner">Remaining semesters</th>
													<th width="10%" class="inner">Graduation status</th>
													<th width="20%" class="inner">Academic institution</th>
													<th width="10%" class="inner">average</th>
													<th width="15%" class="inner">Major</th>
													<th width="15%" class="inner">Second major</th>
													<th width="10%" class="inner">Actions</th>
												</tr>
												<tr>
												<td width="10%">
												
														<a href="https://drive.google.com/open?id=0B_QS8uk1BPLYSkxxTWpRSDd0eDg"><img class="icon icons8-Profile" width="50" height="50" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADIAAAAyCAYAAAAeP4ixAAAAAXNSR0IArs4c6QAABTBJREFUaAXtmHuon3Mcx2djx1y2uf5BMUPkbsScOBllpImVlKaJWi6R5A8ltSVMhvwhd/vDcvlrmctGhlAsl2kKq7WzOWtDzC7YMI7X63e+33r2eJ7v73mO8+zs5LzrdZ7v5fO9fL733xkxYljDI9DICOxRs9ajsJ8eOKxm2armOzB8BR6FnqqF6jjSRaVvw16h8tf5/hnCA/mx/gthOXQOZMXWpRNbYS0sgF4YD01pLhXbxtiqDYysYKgTjv5GOB9WQdPaHhqo0r+WaTvDvBPdTXvQ3/pTjgwZJ3S+zJEh5USZI0POiSJHvCcWQdzYRXvC02S30565Ht1NfBy8BjNzeUZHw/XgybUZdlutpGeOeIqPyB/wiyo3IrNDHyrfVfkZccS9M2ZAkf4mcUtRxmCn5R2xPz47Ng12x+q2X3b81q1n0O2LZqSsUz4w58EFZQa5dA8Dl+g6mAOXgXL/3QHvGBko1XHENn+FqsvOvfSXhVC2nI780Upt8E83dS9ssP6qVc/GUIf7fWqlGnJp3QlnpYwK8t4jzR9JKXla+kPNmfspZViWV2dpeTAcA6eVVVaS/i3pDoIjnJUdnwaXwxToALUN4hFvuX5pVyytyfTMu8o7yb3yOTwFt8EDsAQ2gI6/AWOhtpp25GJ6pANr4SGYCGXyKfQ7LIP9y4zK0pt2xNF3qe1b1oFc+hXEd8BLufS20ZQj/lNgKTjlVdiE3SSI8jFqOZePuhZsz2V1BJTJg8Jy55YZmF5nszsyL8AKC1bQb9j0ZOwODOH1fM+Ep8H868Bl5HL7JvAj31XgK/wAUFfCh61QwZ86jjgqzxbUUTUpXo6jKHAs2NlOcM+cB12BqXxHwmr4Aa4B23a/VJZTXXYh2gEd0aaMD8g7BIo0hkQ7fV/I9O4o0t4kHgraO4s+Yh+D5FFcZ0bshNMdlwjBf+l7UspGbnqwjm169BZpO4mivFO+gqvgCfgSKik1I5UqKDE6nHQ754mV3LQF5W8mzdt+BSRnJVu2KUe8P3rhhmxjNcIvhvIuu0K5qXaFltGIp158ytdp0ztnCngHxSXXtnxTM2LDD4OzMtdIRe2D3VtguVqD0KQjbvKXwWP4SKiiGRjpxK1VjLM2TTpiOzrgadXuWa+ty/4L+DqE+VRX047YEzeuzkwyktAt5DkbNyVsSrOadMTZ8C7wnrGDK6EDinQCiT5xtPPNdg+k7i+yd1YTjkygiSdBBzy5fK95DBteDtMg3g8er+6HDfAdeInGzb6Z8L1wELRV1pFZWPvfjqi7CMyMEb6PwKUhbkfmwzkh7mcC+DB0GdnpBXA8RF1EwJdAL6yBV+FnMP4pHA1RnQSWgHlb4H5IOtSNQXxrvUvYEYty0y2OEb42Oj/EHUkbsQF1CdigDjwPx0GRDibRNiwbeY6wPxmKNJlE+6BtD5wKLaUuxPVYSFQq7sPOl6o2p8BCWAMngq9X90ORfAGPAd9QN4LLz7qkSB+T6CB1wSh4Ewofqd1k2AllA/u1Qn1//LnpyEeNJxAfgKY51Q7MM+BymgjtNBYD75UHg+EnfKWKpmLkzNyucWpGtpH/i0ZBW/lmnwieJi6dKB92vpAdoXWwGtrpdAzsw2fB0O/JMDrEU5/3Q2ZrRvKO2BFn4r/IOuIp1K6eM4JB1pEO0k5qV5D82Ibt7bQ0jHvUzYKl4Gbtj86m0DiISzRVh/tJzQM7FNf744Tdbym5R1TLkehVX1JfB7xJr4bs/oj5Vb9uWke2aS2igTmwsemGhuv/347AP28HPrB11U7wAAAAAElFTkSuQmCC"></a>

												
												
												</td>
													<td width="10%">
														<div id="div7${ment.id}"
															ondblclick="showStuff('div7${ment.id}','input7${ment.id}');">${ment.remainingSemesters}</div>
														<input id="input7${ment.id}" name="uRemSemesters"
														type="number" value="${ment.remainingSemesters}"
														style="display: none;" min="0" required
														>
													</td>
													<td width="10%">
														<div id="div8${ment.id}"
															ondblclick="showStuff('div8${ment.id}','input8${ment.id}');">${ment.graduationStatus}</div>
														<input id="input8${ment.id}" name="uGraduationStatus"
														type="text" value="${ment.graduationStatus}"
														style="display: none;"
														required>
													</td>
													<td width="20%">
														 <div id="div13${ment.id}" ondblclick="showStuff('div13${ment.id}','input13${ment.id}');">${ment.academiclnstitution}</div>
												 		<input name="uAcademicInstitution" id="input13${ment.id}" type="text" value="${ment.academiclnstitution}"   style="display :none;"
													 	required >													</td>
													<td width="10%">
														<div id="div9${ment.id}"
															ondblclick="showStuff('div9${ment.id}','input9${ment.id}');">${ment.average}</div>
														<input id="input9${ment.id}" name="uAverage" type="number"
														value="${ment.average}" style="display: none;" min="0" max="100"
														required>
													</td>
													<td width="15%">
														<div id="div10${ment.id}"
															ondblclick="showStuff('div10${ment.id}','input10${ment.id}');">${ment.academicDicipline}</div>
														<input id="input10${ment.id}" name="uAcademicDicipline"
														type="text" value="${ment.academicDicipline}"
														style="display: none;"
														required>
													</td>
													<td width="15%">
														<div id="div11${ment.id}"
															ondblclick="showStuff('div11${ment.id}','input11${ment.id}');">
															
															
															
															<c:if test="${empty ment.academicDicipline2}">
															NO VALUE
															</c:if>
																<c:if test="${not empty ment.academicDicipline2}">
															${ment.academicDicipline2}
															
															</c:if>
															</div>
														<input id="input11${ment.id}" name="uAcademicDicipline2"
														type="text" value="${ment.academicDicipline2}"
														style="display: none;"
														>
													</td>
													<td width="10%">
														<input class="saveButton" type="submit" value="Save">
														<input type="submit" value="Mail">
													</td>
												</tr>
											</table>

										</div>

										<div id="Notes${ment.id}" class="tabcontent"
											style="background-color: rgba(250,178,58,0.8);">
											<table>
											<tr>
												<th width="90%" class="inner">Notes</th>	
												<th width="10%" class="inner">Actions</th>	
											</tr>
											<tr>
												<td width="90%">
													<div id="div12${ment.id}" ondblclick="showStuff('div12${ment.id}','input12${ment.id}');">
															${ment.note}
													</div>
													<textarea id="input12${ment.id}" name="uNotes"
														style="display: none; height: 100px;">${ment.note}</textarea>
												</td>
												<td width="10%">
													<input id="id:${ment.id}" name="uId" type="text"
														value="${ment.id}" style="display: none;"
														>
													<input class="saveButton" type="submit" style="float: right;" value="Save">
													<input type="submit" style="float: right;" value="Mail">
											</td>
												</tr>


											</table>
										</div>
										<div id="Mentor${ment.id}" class="tabcontent"
											style="background-color: rgba(250,178,58,0.8);">
											<table>
												<tr>
													<td width="90%">${ment.note}</td>
													<td width="10%">
														<input class="saveButton" type="submit" style="float: right;" value="Save">
														<input type="submit" style="float: right;" value="Mail">
													</td>	
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




		<a href="#openModal3" class="btn btn-block btn-primary btn-addClick"> <i
			class="fa fa-plus"></i><i class="fa fa-graduation-cap"></i> Add
			Mentee
		</a>
	
		
		<div id="openModal3" class="modalDialog">
			<div>
				<div class="container" >
					<a href="#close" title="Close" class="close"
						style="position: absolute;">X</a>
					<form action="AddMentee" method="post">
						<table class="addMenteeForm">
							<tbody style="background-color:#ccc">
							<tr>
								<td class="form">First name</td>
								<td class="form"><input type="text" name="uFirstName" 
								 required></td>
								<td class="form">Last name</td>
								<td class="form"><input type="text" name="uLastName" 
							  	 required></td>
							  	 <td class="form">Email</td>
								<td class="form"><input type="text" name="uEmail" 
								 required></td>
							</tr>
							<tr>
								<td class="form">Phone number</td>
								<td class="form"><input type="number" name="uPhoneNumber" 
							 required></td>
							 <td class="form">Gender</td>
								<td class="form">
								
								
								<input id="clickedGender" class="male" type="radio"
									name="uGender" value="1" checked> Male <input
									id="noclickedGender" class="female" type="radio" name="uGender"
									value="0"> Female
						
							  	
							  	</td>
								<td class="form">Address</td>
								<td class="form"><input type="text" name="uAddress"
								required>
								
							</tr>
							<tr>
								<td class="form">Graduation status</td>
								<td class="form"><input type="text" name="uGraduationStatus"
								required></td>
								<td class="form">Academic institution</td>
								<td>
								
								<select name="uAcademicInstitution">
										<c:forEach var="item" items="${AcadimicIn}">
											<option value="${item.id}">  ${item.name}</option>
										</c:forEach>
								</select>   
								</td>
								<td class="form">Average</td>			
								<td class="form"><input type="number" name="uAverage" min="0" max="100" 
								style="color:#BBB;" required></td>	
															
								
							</tr>
							<tr>
								<td class="form">Remaining semesters</td>
								<td class="form"><input type="number" name="uRemSemesters" required></td>
								<td class="form">Dicipline</td>
								<td class="form"><input type="text" name="uAcademicDicipline" required ></td>

								<td class="form">Dicipline 2</td>
								<td class="form"><input type="text" name="uAcademicDicipline2">
								</td>
							</tr>
							<tr>


								<td class="form">Signed</td>
								<td class="form">
								
								<input id="clickedSign" class="Sign1" type="radio"
									name="uSignedEULA" value="true" checked> YES <input
									id="noclickedclickedSign" class="Sign2" type="radio" name="uSignedEULA"
									value="false"> NO
									
								
							  	
							  	</td>
								<td class="form">note</td>
								<td class="form" colspan="3"><textarea name="uNotes" style="height: 50px"></textarea></td>
							</tr>
							<tr >
							<td colspan="4"></td>
							<td class="form">
								<input type="text" name="id" style="display: none"
								onblur="if(this.value==''){ this.value='id'; this.style.color='#BBB';}" 
								onfocus="if(this.value=='id'){this.value=''; this.style.color='#000';}">
							</td>
							<td class="form" ><input style="float:center" type="submit" value="Add">
							</td>
							
							
							</tbody>
							
							</tr>
						</table>
						
					</form>
				</div>


			</div>
		</div>
	</section>
</div>
</body>
</html>

