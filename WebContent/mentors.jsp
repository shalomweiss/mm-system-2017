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
		
		for(var i=1;i<=12;i++)  //length of inputs
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

<body>



	<!-- welcome bar -->
	<nav class="icon-bar">
		<div class="icon-bar">
		  <a  href="ForwardPath" title="Home"><i class="fa fa-home"></i></a> 
		  <a class="active" href="GetAllMentors" title="Mentors"><i class="fa fa-black-tie"></i></a> 
		  <a href="GetAllMentees" title="Mentees"><i class="fa fa-graduation-cap"></i></a> 
		  <a href="GetAllPairs" title="Pairs"><i class="fa fa-group"></i></a>
		  <a href="GetAllAcademicInstitution" title="Reports"><i class="fa fa-clipboard"></i></a>	
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
							<tr class="stam"
								onclick="show_hide_row('hidden_row${ment.id}',${ment.id},'defultOpen${ment.id}');">
								<td style="display: none">${ment.id}</td>
								<td>${ment.firstName} ${ment.lastName}</td>
								<td>${ment.phoneNumber}</td>
								<td>${ment.company}</td>
								<td>
									<c:if test="${ment.gender == 1}"> male </c:if>
									<c:if test="${ment.gender == 0}"> female </c:if> 
								</td>
								<td>
									<a class="btn btn-block btn-primary topButton" href="" style="margin-top: 0px;" >
			 							Deactivate
    								</a><br>
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
									<form id="form${ment.id}" action="UpdateMentor" method="post">
										<div id="info${ment.id}" class="tabcontent"
											style="background-color: rgba(108,136,225,0.9);">



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
														<img src="DownloadFile?id=${ment.id}&type=img" alt="W3Schools.com">
													</td>
													<td width="10%"><input class="saveButton" id="submit${ment.id}" type="submit"
														value="Save"><br>
														<input id="submit${ment.id}" type="submit"
														value="Mail"></td>
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
															ondblclick="showStuff('div12${ment.id}','input12${ment.id}');">${ment.company}</div>
														<input name="uCompany" id="input12${ment.id}" type="text"
														value="${ment.company}" style="display: none;"
														required>
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
														<input id="submit${ment.id}" type="submit" value="Mail">
													</td>
												</tr>
											</table>

										</div>

										<div id="Notes${ment.id}" class="tabcontent"
											style="background-color: rgba(108,136,225,0.9);">
											<table>
												<tr>
													<th width="90%" class="inner">Notes</th>
													
												<th width="10%" class="inner">Actions</th>
													
												</tr>
												<tr>
													<td width="90%">
														<div id="div10${ment.id}"
															ondblclick="showStuff('div10${ment.id}','input10${ment.id}');">
															
															
															${ment.note}
															
															</div>

														<textarea id="input10${ment.id}" name="uNotes"
															value="${ment.note}"
															style="display: none; height: 100px;">${ment.note}</textarea>
													</td>
													<td width="10%"><input id="id:${ment.id}" name="uId" type="text"
														value="${ment.id}" style="display: none;"
														onblur="if(this.value==''){ this.value='id'; this.style.color='#BBB';}" 
							  							onfocus="if(this.value=='id'){this.value=''; this.style.color='#000';}">
														<input class="saveButton" type="submit" id="submit${ment.id}" style="float: center;" value="Save">
														<br>
														<input type="submit" id="submit${ment.id}" style="float: center;" value="Mail">

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
													<input type="submit" id="submit${ment.id}"
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
			<div>


				<div class="container">
					<a href="#close" title="Close" class="close"
						style="position: absolute; background-color: red;">X</a>

					<form action="AddNewMentor" method="post">
						<table class="addMentorForm">
							<tr>
								<td>First Name:</td>
								<td><input type="text" name="firstName" required></td>
								<td>Last Name:</td>
								<td><input type="text" name="lastName" required></td>
							</tr>
							<tr>
								<td>Email</td>
								<td><input type="text" name="email" required></td>
								<td>Phone number</td>
								<td><input type="number" name="phoneNumber" required></td>
							</tr>
							<tr>
								<td>Gender</td>
								<td>
								
								<input id="clickedGender" class="male" type="radio"
									name="gender" value="1" checked> Male <input
									id="noclickedGender" class="female" type="radio" name="gender"
									value="0"> Female
									
									
									</td>
								<td>Address</td>
								<td><input type="text" name="address" required></td>
							</tr>

							<tr>
								<td>Company</td>
								<td>
								<select name="company">
										<c:forEach var="item" items="${NewWorkPlace}">
											<option value="${item.id}">   ${item.company}</option>
										</c:forEach>
								</select>
								</td>
								<td>Role</td>
								<td><input type="text" name="role" required></td>
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
								<td colspan="2"><textarea name="notes"
										style="height: 50px"></textarea></td>
										<td><input class="saveButton" style="float:right" type="submit" value="Save"><br>
										<input style="float:right" type="submit" value="Mail"></td>
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
	</div>
</body>
</html>