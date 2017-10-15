<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

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


<script type="text/javascript" src="jquery.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

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

	function show_hide_row(row,mentId,def) {
		$("#" + prevRow).toggle();
		$("#" + row).toggle();
		document.getElementById(def).click();
		prevRow=row;
		
		for(var i=1;i<=13;i++)  //length of inputs
		{
		showStuff("input"+i+mentId,"div"+i+mentId);
		}
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
		
	     document.getElementById(show).style.display  = 'block';
	    document.getElementById(hide).style.display  = 'none';
	    
	}
	
	
</script>


<style>
/* Style inputs with type="text", select elements and textareas */
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
	background-color: white !important;
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

.close:hover {
	background: #00d9ff;
}

.modalDialog:target {
	opacity: 1;
	pointer-events: auto;
}

.modalDialog>div {
	width: 800px;
	
	margin: auto;
	border-radius: 10px;
	background: #fff;
	background: -moz-linear-gradient(#fff, #999);
	background: -webkit-linear-gradient(#fff, #999);
	background: -o-linear-gradient(#fff, #999);
}

.modalDialog {
	position: fixed;
	font-family: Arial, Helvetica, sans-serif;
	top: 20px;
	right: 0;
	left: 0;
	buttom: 0;
	background: rgba(0, 0, 0, 0.3);
	z-index: 99999;
	opacity: 0;
	-webkit-transition: opacity 400ms ease-in;
	-moz-transition: opacity 400ms ease-in;
	transition: opacity 400ms ease-in;
	pointer-events: none;
}

.button:hover {
	background-color: #4CAF50; /* Green */
	color: white;
}

h1 {
	font-size: 40px;
	letter-spacing: 8px;
	text-shadow: 2px 4px 4px #CCCCCC;
	color: #fff;
	text-transform: uppercase;
	font-weight: 300;
	text-align: center;
	margin-bottom: 15px;
}

table {
	width: 100%;
	table-layout: fixed;
}

.tbl-header {
	background-color: rgba(255, 255, 255, 0.3);
}

.tbl-content {
	height: 300px;
	overflow-x: auto;
	margin-top: 0px;
	border: 1px solid rgba(255, 255, 255, 0.3);
}

th {
	padding: 20px 15px;
	text-align: center;
	font-weight: 500;
	font-size: 14px;
	color: black;
	text-transform: uppercase;
	word-wrap: break-word;
}

td {
	padding: 5px;
	text-align: center;
	vertical-align: middle;
	font-weight: 700;
	font-size: 14px;
	color: black;
	border-bottom: solid 1px rgba(255, 255, 255, 0.1);
	border-right: solid 1px rgba(255, 255, 255, 0.3);
	word-wrap: break-word;
}

/* demo styles */
@import
	url(https://fonts.googleapis.com/css?family=Roboto:400,500,300,700);

body {
	background: -webkit-linear-gradient(left, #25c481, #25b7c4);
	background: linear-gradient(to right, #25c481, #25b7c4);
	font-family: 'Century Gothic', sans-serif;
}

section {
	top: 0;
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
	-webkit-box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.3);
}

::-webkit-scrollbar-thumb {
	-webkit-box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.3);
}

body {
	top: 0;
	margin: 0
}

.icon-bar {
	top: 30vh;
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

i {
	margin-right: 2px;
}

body {
	background-color: #cfd9df;
	height: 100%;
}

html {
	overflow-y: hidden;
	height: 100%;
}

nav.icon-bar {
	top: 0;
	position: fixed;
	height: 100%;
	background-color: #555;
}

div.icon-bar {
	margin-left: auto;
	margin-right: auto;
	display: table-cell;
	vertical-align: middle;
	position: fixed;
	top: calc(( 100% - 490px)/2);
	bottom: 0;
}

h1 {
	position: absolute;
	top: 5%;
	right: 0;
	left: 90px;
}

button {
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

.btn-primary, .btn-primary:hover, .btn-primary:active, .btn-primary:visited,
	.btn-primary:focus {
	background-color: #67d2bc !important;
	border-color: #67d2bc !important;
	outline: none !important;
	color: white !important;
	cursor: pointer !important;
}

button {
	outline: none !important;
}

.btn-primary, .btn-primary:hover, .btn-primary:active, .btn-primary:visited,
	.btn-primary:focus {
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

tr.stam:hover {
	background-color: #f5f5f5;
	opacity: 0.9;
	cursor: pointer;
}

td {
	height: 20%;
}

#table_detail tr:hover {
	background-color: #F2F2F2;
}

#table_detail .hidden_row {
	display: none;
}

.para.selected {
	background-color: #f5f5f5;
	color: black;
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
		  <a href="#"><i class="fa fa-bell" title="Notifications"></i></a>
		  <a href="#" title="Reports"><i class="fa fa-clipboard"></i></a>	
		  <a href="#" title="Logout"><i class="fa glyphicon">&#xe163;</i></a>  		  
	</div>
	</nav>
	<h1>Mentors</h1>


	<section>
		<!--for demo wrap-->
		<div class="tbl-header">

			<table id="table_detail" cellpadding="0" cellspacing="0" border="0">
				<thead>
					<tr>
						<th>Name</th>
						<th>Last Name</th>
						<th>Phone</th>
						<th>Email</th>
					</tr>

				</thead>
				</div>

				<div class="tbl-content" style="height: 100%">
					<tbody>
						<c:forEach items="${Mentors}" var="ment">
							<tr class="stam para"
								onclick="show_hide_row('hidden_row${ment.id}',${ment.id},'defultOpen${ment.id}');">
								<td style="display: none">${ment.id}</td>
								<td>${ment.firstName}</td>
								<td>${ment.lastName}</td>
								<td>${ment.phoneNumber}</td>
								<td>${ment.email}</td>
							</tr>

							<tr id="hidden_row${ment.id}" class="hidden_row"
								onclick="fun(this)">
								<td colspan=4>
									<div class="tab">

										<button class="tablinks" id="defultOpen${ment.id}"
											onclick="showDetails(event, 'info${ment.id}')">Info</button>
										<button class="tablinks"
											onclick="showDetails(event, 'Experience${ment.id}')">Experience</button>
										<button class="tablinks"
											onclick="showDetails(event, 'Volunteering${ment.id}')">Volunteering</button>
										<button class="tablinks"
											onclick="showDetails(event, 'Notes${ment.id}')">Notes</button>
										<button class="tablinks" style="float: right;"
											onclick="closeRow('hidden_row${ment.id}',${ment.id});">X</button>

									</div>
									<form id="form${ment.id}" action="UpdateMentor" method="post">
										<div id="info${ment.id}" class="tabcontent"
											style="background-color: #f1f1f1;">



											<table class="w3-table-all w3-card-4">

												<tr>
													<th>First name</th>
													<th>Last name</th>
													<th>Gender</th>
													<th>Address</th>
													<th>Phone</th>
													<th>Email</th>
												</tr>
												<tr>
													<td>
														<div id="div1${ment.id}"
															ondblclick="showStuff('div1${ment.id}','input1${ment.id}');">${ment.firstName}</div>
														<input id="input1${ment.id}" name="uFirstName" type="text"
														value="${ment.firstName}" style="display: none;"
														onblur="if(this.value==''){ this.value='name'; this.style.color='#BBB';}" 
							  							onfocus="if(this.value=='name'){this.value=''; this.style.color='#000';}">
													</td>

													<td>
														<div id="div2${ment.id}"
															ondblclick="showStuff('div2${ment.id}','input2${ment.id}');">${ment.lastName}</div>
														<input id="input2${ment.id}" name="uLastName" type="text"
														value="${ment.lastName}" style="display: none;"
														onblur="if(this.value==''){ this.value='lastname'; this.style.color='#BBB';}" 
							  							onfocus="if(this.value=='lastname'){this.value=''; this.style.color='#000';}">
													</td>
													<td>
														<div id="div3${ment.id}"
															ondblclick="showStuff('div3${ment.id}','input3${ment.id}');">${ment.gender}</div>
														<input id="input3${ment.id}" name="uGender" type="text"
														value="${ment.gender}" style="display: none;"
														onblur="if(this.value==''){ this.value='gender'; this.style.color='#BBB';}" 
							  							onfocus="if(this.value=='gender'){this.value=''; this.style.color='#000';}">

													</td>
													<td>
														<div id="div4${ment.id}"
															ondblclick="showStuff('div4${ment.id}','input4${ment.id}');">${ment.address}</div>
														<input id="input4${ment.id}" name="uAddress" type="text"
														value="${ment.address}" style="display: none;"
														onblur="if(this.value==''){ this.value='address'; this.style.color='#BBB';}" 
							  							onfocus="if(this.value=='address'){this.value=''; this.style.color='#000';}">
													</td>
													<td>
														<div id="div5${ment.id}"
															ondblclick="showStuff('div5${ment.id}','input5${ment.id}');">${ment.phoneNumber}</div>
														<input id="input5${ment.id}" name="uPhoneNumber"
														type="text" value="${ment.phoneNumber}"
														style="display: none;"
														onblur="if(this.value==''){ this.value='number'; this.style.color='#BBB';}" 
							  							onfocus="if(this.value=='number'){this.value=''; this.style.color='#000';}">
													</td>
													<td>
														<div id="div6${ment.id}"
															ondblclick="showStuff('div6${ment.id}','input6${ment.id}');">${ment.email}</div>
														<input id="input6${ment.id}" name="uEmail" type="text"
														value="${ment.email}" style="display: none;"
														onblur="if(this.value==''){ this.value='example@example.com'; this.style.color='#BBB';}" 
							  							onfocus="if(this.value=='example@example.com'){this.value=''; this.style.color='#000';}">
													</td>
													<td><input id="submit${ment.id}" type="submit"
														value="Done"></td>
												</tr>
											</table>


										</div>

										<div id="Experience${ment.id}" class="tabcontent"
											style="background-color: #f1f1f1;">

											<table class="w3-table-all w3-card-4">
												<tr>
													<th>Experience</th>
													<th>Role</th>
													<th>company</th>
													<th>workHistory</th>

												</tr>
												<tr>
													<td>
														<div id="div7${ment.id}"
															ondblclick="showStuff('div7${ment.id}','input7${ment.id}');">${ment.experience}</div>
														<input id="input7${ment.id}" name="uExperience"
														type="text" value="${ment.experience}"
														style="display: none;"
														onblur="if(this.value==''){ this.value='exp'; this.style.color='#BBB';}" 
							  							onfocus="if(this.value=='exp'){this.value=''; this.style.color='#000';}">
													</td>
													<td>
														<div id="div8${ment.id}"
															ondblclick="showStuff('div8${ment.id}','input8${ment.id}');">${ment.role}</div>
														<input id="input8${ment.id}" name="uRole" type="text"
														value="${ment.role}" style="display: none;"
														onblur="if(this.value==''){ this.value='role'; this.style.color='#BBB';}" 
							  							onfocus="if(this.value=='role'){this.value=''; this.style.color='#000';}">
													</td>
													<td>
														<div id="div12${ment.id}"
															ondblclick="showStuff('div12${ment.id}','input12${ment.id}');">${ment.company}</div>
														<input name="uCompany" id="input12${ment.id}" type="text"
														value="${ment.company}" style="display: none;"
														onblur="if(this.value==''){ this.value='company'; this.style.color='#BBB';}" 
							  							onfocus="if(this.value=='company'){this.value=''; this.style.color='#000';}">
													</td>
													<td>
														<div id="div9${ment.id}"
															ondblclick="showStuff('div9${ment.id}','input9${ment.id}');">${ment.workHistory}</div>
														<input id="input9${ment.id}" name="uWorkHistory"
														type="text" value="${ment.workHistory}"
														style="display: none;"
														onblur="if(this.value==''){ this.value='workHis'; this.style.color='#BBB';}" 
							  							onfocus="if(this.value=='workHis'){this.value=''; this.style.color='#000';}">
													</td>


													<td><input id="submit${ment.id}" type="submit" value="Done"></td>
												</tr>
											</table>

										</div>

										<div id="Notes${ment.id}" class="tabcontent"
											style="background-color: #f1f1f1;">
											<table>
												<tr>
													<th>Notes</th>
												</tr>
												<tr>
													<td>
														<div id="div10${ment.id}"
															ondblclick="showStuff('div10${ment.id}','input10${ment.id}');">${ment.note}</div>

														<textarea id="input10${ment.id}" name="uNotes"
															value="${ment.note}"
															style="display: none; height: 100px;">${ment.note}</textarea>
													</td>
												</tr>

												<tr>
													<td><input id="id:${ment.id}" name="uId" type="text"
														value="${ment.id}" style="display: none;"
														onblur="if(this.value==''){ this.value='id'; this.style.color='#BBB';}" 
							  							onfocus="if(this.value=='id'){this.value=''; this.style.color='#000';}">
														<input type="submit" id="submit${ment.id}" style="float: right;" value="Done">

													</td>
												</tr>

											</table>
										</div>


										<div id="Volunteering${ment.id}" class="tabcontent"
											style="background-color: #f1f1f1;">
											<table>


												<tr>
													<th>Volunteering</th>
												</tr>
												<tr>
													<td>
														<div id="div11${ment.id}"
															ondblclick="showStuff('div11${ment.id}','input11${ment.id}');">${ment.volunteering}</div>

														<textarea id="input11${ment.id}" name="uVolunteering"
															value="${ment.volunteering}"
															style="display: none; height: 100px;">${ment.volunteering}</textarea>
													</td>
												</tr>
												<tr>
													<td><input type="submit" id="submit${ment.id}"
														style="float: right;" value="Done"></td>
											</table>
										</div>
										</form>
								</td>
							</tr>



							
						</c:forEach>

					</tbody>
				</div>
			</table>
		</div>




		<a href="#openModal3" class="btn btn-block btn-primary"> <i
			class="fa fa-plus"></i><i class="fa fa-graduation-cap"></i> Add
			Mentor
		</a>
		


		<div id="openModal3" class="modalDialog">
			<div>


				<div class="container">
					<a href="#close" title="Close" class="close"
						style="position: absolute;">X</a>

					<form action="AddNewMentor" method="post">
						<table>
							<tr>
								<td>First Name:</td>
								<td><input type="text" name="firstName"></td>
								<td>Last Name:</td>
								<td><input type="text" name="lastName"></td>
							</tr>
							<tr>
								<td>Email</td>
								<td><input type="text" name="email"></td>
								<td>Phone number</td>
								<td><input type="text" name="phoneNumber"></td>
							</tr>
							<tr>
								<td>Gender</td>
								<td><input id="clickedGender" class="male" type="radio"
									name="gender" value="1" checked> Male <input
									id="noclickedGender" class="female" type="radio" name="gender"
									value="0"> Female</td>
								<td>Address</td>
								<td><input type="text" name="address"></td>
							</tr>

							<tr>
								<td>Company</td>
								<td><input type="text" name="company"></td>
								<td>Role</td>
								<td><input type="text" name="role"></td>
							</tr>

							<tr>
								<td>Experience</td>
								<td colspan="3"><textarea name="experience"
										style="height: 50px"></textarea></td>

							</tr>
							<tr>
								<td>volunteering</td>
								<td colspan="3"><textarea name="volunteering"
										style="height: 50px"></textarea></td>
							</tr>
							<tr>
								<td>Work History</td>
								<td colspan="3"><textarea name="history"
										style="height: 50px"></textarea></td>

							</tr>
							<tr>
								<td>note</td>
								<td colspan="3"><textarea name="notes"
										style="height: 50px"></textarea></td>
							</tr>
							<tr>
								<td colspan="3"><input type="submit" value="Done"></td>
							</tr>

						</table>
					</form>


				</div>


			</div>
		</div>




	</section>


</body>
</html>