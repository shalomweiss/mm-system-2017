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
<style type="text/css"><%@include file="/WEB-INF/css/styles.css"%></style>


<c:if test="${tableType=='1'}">
	<style type="text/css"><%@include file="/WEB-INF/css/styles1.css"%></style>
</c:if>
<c:if test="${tableType=='2'}">
	<style type="text/css"><%@include file="/WEB-INF/css/styles1.css"%></style>
</c:if>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">

<script>
function changeSearch(param)
{
	var list=document.getElementsByTagName("ul")[0].getElementsByTagName("li");
	for(i=0;i<list.length;i++)
		{
			list[i].className="reports";
			if(list[i]==param)
				list[i].className+=" clicked";	
		}
	var id=param.childNodes[0].innerHTML;
	var forms=document.getElementsByTagName("form");
	for(i=0;i<forms.length;i++)
	{
		forms[i].style.display="none";
		if(forms[i].id==id)
			forms[i].style.display="";
	}
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
    var city = $("#city1").val();
    var work = $("#work").val();
    var gender = $("#gender1").val();
    var pair=$('input[name=pair1]:checked', '#formP1').serialize();
    pair=pair[6];
  	console.log(pair);
    $.post("MentorReports",
            {
            uAddress: city,
            uCompany: work,
            uGender: gender,
            inPair: pair
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
    var city = $("#city2").val();
    var institution = $("#institution").val();
    var academic = $("#academic").val();
    var gender = $("#gender2").val();
    var pair=$('input[name=pair2]:checked', '#formP2').serialize();
    pair=pair[6];
    $.post("MenteeReports",
            {
            uAddress: city,
            uAcademicInstitution: institution,
            uAcademicDicipline1: academic,
            uGender: gender,
            inPair: pair
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
    var mentee = $("#mentorLast").val();
    var mentor = $("#mentorN").val();
   
    $.post("PairReports",
            {
            MentorName: mentee,
            MentorLast: mentor
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
<style type="text/css">
.icon-bar a {
    padding: 8px;
}
</style>
</head>

<body>
<nav class="icon-bar">
	<div class="icon-bar">
		  <a href="ForwardPath" title="Home"><i class="fa fa-home"></i></a> 
		  <a href="GetAllMentors" title="Mentors"><i class="fa fa-black-tie"></i></a> 
		  <a href="GetAllMentees" title="Mentees"><i class="fa fa-graduation-cap"></i></a> 
		  <a href="GetAllPairs" title="Pairs"><i class="fa fa-group"></i></a>
		  <a  class="active" href="GetAllAcademicInstitution" title="Reports"><i class="fa fa-clipboard"></i></a>
		  <a href="AddingDataServlet" title="AddingStuff"><i class="fa fa-cogs"></i></a>	
		  <a href="#" title="Logout"><i class="fa glyphicon">&#xe163;</i></a> 
	</div>
</nav>
	

<div class="topPart"> </div>
<div class="bottomPart"> </div>
<div class="inner inner--left">
	<ul>
		<li id="mentorLI" class="reports clicked" onclick="changeSearch(this)"><a class="" >Mentors</a></li>
	  	<li id="menteeLI" class="reports" onclick="changeSearch(this)"><a class="" >Mentees</a></li>
	  	<li id="pairLI" class="reports" onclick="changeSearch(this)"><a class="" >Pairs</a></li>	
	</ul>
	<form class="reports" id="Mentors" style="display: none;">
	  	<label class="control-label reports">Address: </label>  
	  	<input name="uAddress"  class="reports"  type="text" id="city1"
	  				onblur="if(this.value==''){ this.value='city'; this.style.color='#BBB';}" 
					onfocus="if(this.value=='city'){this.value=''; this.style.color='#000';}"/>
		<label class="control-label reports">Gender: </label>  
    	<select name="uGender" class="selectpicker reports" id="gender1" >
    	 	 <option></option>
     		 <option value="0">Male</option>
     		 <option value="1">Female</option>
      	</select>
      	<label class="control-label reports">Company: </label>  
      	<select name="uCompany" class="selectpicker reports">
      		<option></option>
			<c:forEach var="item" items="${AllWorkPlaces}">
				<option id="work" value="${item.id}">${item.company}</option>
			</c:forEach>
		</select>
		<br>
		<label class="control-label reports">Is in a pair: </label> 
		<select name="uGender" class="selectpicker reports" id="gender1" >
    	 	 <option></option>
     		 <option value="0">No</option>
     		 <option value="1">Yes</option>
      	</select>
      	<br>
      	<a class="reportsSendButton btn"  onclick="showMentorTable()"  id="submit1">Search <span class="glyphicon glyphicon-send"></span></a>
  	
  	</form>
	<form class="reports" id="Mentees" style="display: none;">
	  	<label class="control-label reports">Address: </label>  
	  	<input name="uAddress"  class="reports"  type="text" id="city1"
	  				onblur="if(this.value==''){ this.value='city'; this.style.color='#BBB';}" 
					onfocus="if(this.value=='city'){this.value=''; this.style.color='#000';}"/>
		<label class="control-label reports">Gender: </label>  
    	<select name="uGender" class="selectpicker reports" id="gender1" >
    	 	 <option></option>
     		 <option value="0">Male</option>
     		 <option value="1">Female</option>
      	</select>
      	<label class="control-label reports">Academy: </label>  
      	<select name="uAcademicInstitution" class="selectpicker reports">
      		<option></option>
			<c:forEach var="item" items="${AllAcademicInstitutes}">
				<option id="institution" value="${item.id}">  ${item.name}</option>
			</c:forEach>
		</select>
		<br>
		<label class="control-label reports">Is in a pair: </label> 
		<select name="uGender" class="selectpicker reports" id="gender1" >
    	 	 <option></option>
     		 <option value="0">No</option>
     		 <option value="1">Yes</option>
      	</select>
      	<br>
      	<a class="reportsSendButton btn"  onclick="showMentorTable()"  id="submit1">Search <span class="glyphicon glyphicon-send"></span></a>
  	
  	</form>
	<form class="reports" id="Pairs">
	  	<label class="control-label reports">Mentor First Name: </label>  
	  	<input name="MentorName"  class="reports" id="mentorN"  type="text"
  				onblur="if(this.value==''){ this.value='name'; this.style.color='#BBB';}" 
				onfocus="if(this.value=='name'){this.value=''; this.style.color='#000';}">
				
	  	<label class="control-label reports">Mentor Last Name: </label>  
	  	<input name="MentorLast"  class="reports" id="mentorLast"  type="text"
  				onblur="if(this.value==''){ this.value='name'; this.style.color='#BBB';}" 
				onfocus="if(this.value=='name'){this.value=''; this.style.color='#000';}">
				
		<label class="control-label reports">Number of meetings: </label>  
    	 <input name="" class="reports" id="numberOfMeets" type="number" min="1"
  				onblur="if(this.value==''){ this.value='0'; this.style.color='#BBB';}" 
				onfocus="if(this.value=='0'){this.value=''; this.style.color='#000';}">
				<br>
      	<a class="reportsSendButton btn"  onclick="showMentorTable()"  id="submit1">Search <span class="glyphicon glyphicon-send"></span></a>
  	
  	</form>
</div>	
<div class="topPart"> </div>
<div class="bottomPart"> </div>
<div class="inner inner--right">
<c:choose>
    <c:when test="${tableType=='1'}">
			<section id="menteesTable" style="display: none;" class="Pairs">
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
					
						<tr class="stam" onclick="show_hide_row('hidden_row${ment.id}',${ment.id},'defultOpen${ment.id}');">
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
								<div class="tab">

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
	</section>
    </c:when>
    <c:when test="${tableType=='2'}">
		<section id="mentorsTable" style="display: none;" class="Pairs">
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
	</section>
    </c:when>      
    <c:otherwise>
       <section id="PairsTable" class="Pairs">
  <!--for demo wrap--> 
  <div class="tbl-header">
    <table cellpadding="0" cellspacing="0" border="0">
      <thead>
       <tr>
          <th>Mentor</th>
          <th></th>
          <th></th>
          <th>Mentee</th>
        </tr>
        <tr>
          <th class="mentor">Name</th>
          <th class="mentor">Phone</th>
          <th class="mentor">Workplace</th>
          <th class="mentee">Name</th>
          <th class="mentee">Phone</th>
          <th class="mentee">Academy</th>
        </tr>
      </thead>
    </table>
  </div>
  <div class="tbl-content">
    <table cellpadding="0" cellspacing="0" border="0">
      <tbody>
   <c:forEach var="pair" items="${pairs}" >
        <tr>
        	<td id="mentor">${pair.mentor.firstName} ${pair.mentor.lastName}</td>
        	<td id="mentorPhone">${pair.mentor.phoneNumber}</td>
			<td id="mentee"><c:out value="${pair.mentor.company}"></c:out></td>
			<td id="mentor">${pair.mentee.firstName} ${pair.mentee.lastName}</td>
        	<td id="mentorPhone">${pair.mentee.phoneNumber}</td>
			<td id="mentee"><c:out value="${pair.mentee.academiclnstitution}"></c:out></td>
        </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>
</section>
    </c:otherwise>
</c:choose>
</div>
</body>
</html> 