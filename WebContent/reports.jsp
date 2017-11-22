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
	<script type="text/javascript"><%@include file="/WEB-INF/scripts/index.js"%></script>
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
	var forms=document.getElementsByTagName("table").getElementsByClassName("reports");;
	for(i=0;i<forms.length;i++)
	{
		forms[i].style.display="none";
		if(forms[i].id==id)
			forms[i].style.display="";
	}
}
function showMentorTable() {
	 t1 = document.getElementById('Mentee');
	 t2 = document.getElementById('Mentor');
	 t3 = document.getElementById('Pair');
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
	
$(".choose").click(function() {
	$(this).siblings().removeClass("activated");
	$(this).addClass("activated");
});
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
th{
padding: 10px 15px !important;
}
.btn-print {
    position: absolute;
    left: 2% !important;
    margin-top: 1.8% !important;
    max-width: 90px !important;
    margin-bottom: 2vh;
    bottom: 0;
    background-color: #ccc !important;
    color: black;
    border-radius: 18px;
    box-shadow: 2px 3px 4px #888888;
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
	<header style="width:100%; height:35%; background-color: #6599FF;">
		<div class="choose">Mentees</div>
		<div class="choose activated">Mentors</div>
		<div class="choose">Pairs</div>
	</header >
	<main style="width: 80%;
    position: absolute;
    height: 65%;
    top: 37%;
    left: 5%;">
	<table style="padding:10px;">
		<tbody>
			<tr>
				<td>Area</td>
				<td><input id="searchkey1" onkeyup="dynamicSearch()" placeholder="search by name..." class="serchInput" type="text" ></td>
				<td></td>
				<td>Gender</td>
				<td><input id="searchkey1" onkeyup="dynamicSearch()" placeholder="search by name..." class="serchInput" type="text" ></td>
				<td></td>
			</tr>
			<tr>
				<td>Company</td>
				<td><input id="searchkey1" onkeyup="dynamicSearch()" placeholder="search by name..." class="serchInput" type="text" ></td>
				<td></td>
				<td>In a pair?</td>
				<td><input id="searchkey1" onkeyup="dynamicSearch()" placeholder="search by name..." class="serchInput" type="text" ></td>
				<td></td>
			</tr>
		</tbody>
	</table>
	
	</main>
			<a href="#openModal3" class="btn btn-block btn-primary btn-addClick" style="    width: 10% !important; ">Send</a>
</div>	
<div class="topPart"> </div>
<div class="bottomPart"> </div>
<div class="inner inner--right">
<c:choose>
    <c:when test="${tableType=='1'}">
		<section class="Pairs">
		<!--for demo wrap-->
		<table id="table_detail" >
		<thead class="tbl-header-mentee">
					<tr>
						<th class="smaller" onclick="sortTable(3)">Name</th>
						<th class="smaller" onclick="sortTable(5)">Phone</th>
						<th class="smaller" onclick="sortTable(7)">Academy</th>
						<th class="smaller" onclick="sortTable(9)">Gender</th>
						<th class="smaller" style="cursor: pointer;padding-bottom: 4px !important;padding-top: 15px !important;" id="activeStuff" onclick="activeOrNot(this)" class="odin" >Actions</th>
					</tr>
					<tr>
						<td class="searchtab"> <input id="searchkey1" onkeyup="dynamicSearch()" placeholder="search by name..." class="serchInput" type="text" ></td>
						<td class="searchtab"> <input id="searchkey2" onkeyup="dynamicSearch()" placeholder="search by phone..." class="serchInput" name="eeee" type="text"></td>
						<td class="searchtab"> <input id="searchkey3" onkeyup="dynamicSearch()" placeholder="search by academy..." class="serchInput" name="eeee" type="text"></td>
						<td class="searchtab"> <input id="searchkey4" onkeyup="dynamicSearch()" placeholder="search by gender..." class="serchInput" name="eeee" type="text"></td>
						<td class="searchtab"></td>
					</tr>
				</thead>
		</table>
		<div class="tbl-header" >

			<table class="rightTable" id="table_detail">
				<tbody>
				
					<c:forEach items="${Mentees}" var="ment">
					
						<tr id="row${ment.id}" class="stam1" onclick="show_hide_row1('hidden_row${ment.id}',${ment.id},'defultOpen${ment.id}');">
							    <td style="display: none">${ment.id}</td>
						    	<td id="${ment.resume}">${ment.firstName} ${ment.lastName}</td>
								<td>${ment.phoneNumber}<c:if test="${empty ment.phoneNumber}">No Data</c:if></td>
								<td>${ment.academiclnstitutionName}<c:if test="${empty ment.academiclnstitutionName}">No Data</c:if></td>
								<td><c:if test="${ment.gender == 0}">fe</c:if>male</td>
								<td class="${ment.active}">
								<c:if test="${ment.active}">
									<button onclick="areYouSure(this,'de')" class="btn btn-block btn-primary" style="margin-top: 0px;" >
			 							Deactivate
    								</button>
								</c:if>
								<c:if test="${!ment.active}">
									<button onclick="areYouSure(this,'ac')" class="btn btn-block btn-primary" style="margin-top: 0px;" >
			 							Activate
    								</button>
								</c:if>	
								</td>
						</tr>
						<tr id="hidden_row${ment.id}" class="hidden_row"  >
							    <td colspan=5>
								<div class="tab tabMentee">

									<button class="tablinks tablinks1 tablinks2" id="defultOpen${ment.id}" onclick="showDetails(event, 'info${ment.id}')" style="z-index:5; margin-left: 0px;">Info</button>
									<button class="tablinks tablinks1 tablinks2" onclick="showDetails(event, 'Academic${ment.id}')" style="z-index:4;">Academic</button>
									<button class="tablinks tablinks2 tablinks1"
										onclick="showDetails(event, 'Notes${ment.id}')" style="z-index:3;">Notes</button>
									<button class="tablinks tablinks2 tablinks1"
										onclick="getMentorOfMentee(this);showDetails(event, 'Mentor${ment.id}');" style="z-index:2;">Mentor</button>
									<button class="tablinks tablinks2 tablinks1" style="float:right;" onclick="closeRow('hidden_row${ment.id}',${ment.id});">close</button>

								</div>
								<form id="form${ment.id}" action="UpdateMentee" method="post">
								<div id="info${ment.id}" class="tabcontent"style="background-color: rgba(250,178,58,0.8);">
											<table class="w3-table-all w3-card-4">
												<tr >
													<th width="14%" class="inner">First name</th>
													<th width="14%" class="inner">Last name</th>
													<th width="10%" class="inner">Gender</th>
													<th width="12%" class="inner">ID(il)</th>
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
															ondblclick="showStuff('div3${ment.id}','input3${ment.id}');"><c:if test="${ment.gender == 0}">fe</c:if>male</div>
														<select id="input3${ment.id}" style="display: none;" name="uGender" class="selectpicker reports" >
							     							<option value="${ment.gender}"></option>
							     							<option value="0">Male</option>
							     		 					<option value="1">Female</option>
					      								</select>							
													</td>
													<td width="12%">
														<div id="div17${ment.id}"
															ondblclick="showStuff('div17${ment.id}','input17${ment.id}');">${ment.personalId}<c:if test="${empty ment.personalId}">No Data</c:if></div>
														<input id="input17${ment.id}" name="personalId" type="text"
														value="${ment.personalId}" style="display: none;"
														onblur="if(this.value==''){ this.value='address'; this.style.color='#BBB';}" 
							  							onfocus="if(this.value=='address'){this.value=''; this.style.color='#000';}">
													</td>
													<td width="12%">
														<div id="div5${ment.id}"
															ondblclick="showStuff('div5${ment.id}','input5${ment.id}');">${ment.phoneNumber}<c:if test="${empty ment.phoneNumber}">No Data</c:if></div>
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
													<td width="10%">
														<input class="saveButton" id="submit${ment.id}" type="submit" value="Save">
														<input onclick="sendAPK(this)" id="submit${ment.id}" type="button" value="Mail">
													</td>
													
														
													
												</tr>
											</table>


										</div>

										<div id="Academic${ment.id}" class="tabcontent"
											style="background-color: rgba(250,178,58,0.8);">

											<table class="w3-table-all w3-card-4">
												<tr>
													<th width="10%" class="inner">CV</th>
													<th width="10%" class="inner">Grades</th>
													<th width="10%" class="inner">Remaining semesters</th>
													<th width="10%" class="inner">Graduation status</th>
													<th width="15%" class="inner">Academic institution</th>
													<th width="10%" class="inner">average</th>
													<th width="12.5%" class="inner">Major</th>
													<th width="12.5%" class="inner">Second major</th>
													<th width="10%" class="inner">Actions</th>
												</tr>
												<tr>
												<td width="10%">
													<c:if test="${empty ment.resume}">No CV</c:if>
													<c:if test="${not empty ment.resume}"><a href="${ment.resume}" target="_blank"><img class="icon icons8-Profile" width="50px" height="50px" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADIAAAAyCAYAAAAeP4ixAAAAAXNSR0IArs4c6QAABTBJREFUaAXtmHuon3Mcx2djx1y2uf5BMUPkbsScOBllpImVlKaJWi6R5A8ltSVMhvwhd/vDcvlrmctGhlAsl2kKq7WzOWtDzC7YMI7X63e+33r2eJ7v73mO8+zs5LzrdZ7v5fO9fL733xkxYljDI9DICOxRs9ajsJ8eOKxm2armOzB8BR6FnqqF6jjSRaVvw16h8tf5/hnCA/mx/gthOXQOZMXWpRNbYS0sgF4YD01pLhXbxtiqDYysYKgTjv5GOB9WQdPaHhqo0r+WaTvDvBPdTXvQ3/pTjgwZJ3S+zJEh5USZI0POiSJHvCcWQdzYRXvC02S30565Ht1NfBy8BjNzeUZHw/XgybUZdlutpGeOeIqPyB/wiyo3IrNDHyrfVfkZccS9M2ZAkf4mcUtRxmCn5R2xPz47Ng12x+q2X3b81q1n0O2LZqSsUz4w58EFZQa5dA8Dl+g6mAOXgXL/3QHvGBko1XHENn+FqsvOvfSXhVC2nI780Upt8E83dS9ssP6qVc/GUIf7fWqlGnJp3QlnpYwK8t4jzR9JKXla+kPNmfspZViWV2dpeTAcA6eVVVaS/i3pDoIjnJUdnwaXwxToALUN4hFvuX5pVyytyfTMu8o7yb3yOTwFt8EDsAQ2gI6/AWOhtpp25GJ6pANr4SGYCGXyKfQ7LIP9y4zK0pt2xNF3qe1b1oFc+hXEd8BLufS20ZQj/lNgKTjlVdiE3SSI8jFqOZePuhZsz2V1BJTJg8Jy55YZmF5nszsyL8AKC1bQb9j0ZOwODOH1fM+Ep8H868Bl5HL7JvAj31XgK/wAUFfCh61QwZ86jjgqzxbUUTUpXo6jKHAs2NlOcM+cB12BqXxHwmr4Aa4B23a/VJZTXXYh2gEd0aaMD8g7BIo0hkQ7fV/I9O4o0t4kHgraO4s+Yh+D5FFcZ0bshNMdlwjBf+l7UspGbnqwjm169BZpO4mivFO+gqvgCfgSKik1I5UqKDE6nHQ754mV3LQF5W8mzdt+BSRnJVu2KUe8P3rhhmxjNcIvhvIuu0K5qXaFltGIp158ytdp0ztnCngHxSXXtnxTM2LDD4OzMtdIRe2D3VtguVqD0KQjbvKXwWP4SKiiGRjpxK1VjLM2TTpiOzrgadXuWa+ty/4L+DqE+VRX047YEzeuzkwyktAt5DkbNyVsSrOadMTZ8C7wnrGDK6EDinQCiT5xtPPNdg+k7i+yd1YTjkygiSdBBzy5fK95DBteDtMg3g8er+6HDfAdeInGzb6Z8L1wELRV1pFZWPvfjqi7CMyMEb6PwKUhbkfmwzkh7mcC+DB0GdnpBXA8RF1EwJdAL6yBV+FnMP4pHA1RnQSWgHlb4H5IOtSNQXxrvUvYEYty0y2OEb42Oj/EHUkbsQF1CdigDjwPx0GRDibRNiwbeY6wPxmKNJlE+6BtD5wKLaUuxPVYSFQq7sPOl6o2p8BCWAMngq9X90ORfAGPAd9QN4LLz7qkSB+T6CB1wSh4Ewofqd1k2AllA/u1Qn1//LnpyEeNJxAfgKY51Q7MM+BymgjtNBYD75UHg+EnfKWKpmLkzNyucWpGtpH/i0ZBW/lmnwieJi6dKB92vpAdoXWwGtrpdAzsw2fB0O/JMDrEU5/3Q2ZrRvKO2BFn4r/IOuIp1K6eM4JB1pEO0k5qV5D82Ibt7bQ0jHvUzYKl4Gbtj86m0DiISzRVh/tJzQM7FNf744Tdbym5R1TLkehVX1JfB7xJr4bs/oj5Vb9uWke2aS2igTmwsemGhuv/347AP28HPrB11U7wAAAAAElFTkSuQmCC"></a></c:if>
												</td>
												<td width="10%">
														<a href="https://drive.google.com/open?id=0B_QS8uk1BPLYSkxxTWpRSDd0eDg" target="_blank"><img class="icon icons8-Profile" width="50px" height="50px" src="https://i.pinimg.com/originals/fd/d9/db/fdd9db5ba55e78edf31e62b2a175eb3a.png"></a>

												</td>
													<td width="10%">
														<div id="div7${ment.id}"
															ondblclick="showStuff('div7${ment.id}','input7${ment.id}');">${ment.remainingSemesters}<c:if test="${empty ment.remainingSemesters}">No Data</c:if></div>
														<input id="input7${ment.id}" name="uRemSemesters"
														type="number" value="${ment.remainingSemesters}"
														style="display: none;" min="0" required>
													</td>
													<td width="10%">
														<div id="div8${ment.id}"
															ondblclick="showStuff('div8${ment.id}','input8${ment.id}');">${ment.graduationStatus}<c:if test="${empty ment.graduationStatus}">No Data</c:if></div>
														<input id="input8${ment.id}" name="uGraduationStatus"
														type="text" value="${ment.graduationStatus}"
														style="display: none;"
														required>
													</td>
													<td width="15%">
														 <div id="div13${ment.id}" ondblclick="showStuff('div13${ment.id}','input13${ment.id}');">${ment.academiclnstitutionName}<c:if test="${empty ment.academiclnstitutionName}">No Data</c:if></div>
													 	<select name="uAcademicInstitution" id="input13${ment.id}" value="${ment.academiclnstitution}" style="display :none;">
																<option value="${ment.academiclnstitution}"></option>
																<c:forEach var="item" items="${AcadimicIn}">
																	<option value="${item.id}">  ${item.name}</option>
																</c:forEach>
														</select>   												</td>
													<td width="10%">
														<div id="div9${ment.id}"
															ondblclick="showStuff('div9${ment.id}','input9${ment.id}');">${ment.average}<c:if test="${empty ment.average}">No Data</c:if></div>
														<input id="input9${ment.id}" name="uAverage" type="number"
														value="${ment.average}" style="display: none;" min="0" max="100"
														required>
													</td>
													<td width="12.5%">
														<div id="div10${ment.id}"
															ondblclick="showStuff('div10${ment.id}','input10${ment.id}');">${ment.academicDicipline}<c:if test="${empty ment.academicDicipline}">No Data</c:if></div>
														<input id="input10${ment.id}" name="uAcademicDicipline"
														type="text" value="${ment.academicDicipline}"
														style="display: none;"
														required>
													</td>
													<td width="12.5%">
														<div id="div11${ment.id}"
															ondblclick="showStuff('div11${ment.id}','input11${ment.id}');"><c:if test="${empty ment.academicDicipline2}">No Data</c:if>${ment.academicDicipline2}</div>
														<input id="input11${ment.id}" name="uAcademicDicipline2" type="text" value="${ment.academicDicipline2}" style="display: none;">
													</td>
													<td width="10%">
														<input class="saveButton" type="submit" value="Save">
														<input type="button" value="Mail">
													</td>
												</tr>
											</table>

										</div>

										<div id="Notes${ment.id}" class="tabcontent"
											style="background-color: rgba(250,178,58,0.8);">
											<table>
											<tr>
												<th width="30%" class="inner">Notes</th>
												<th width="15%" class="inner">Address</th>	
												<th width="15%" class="inner">City</th>	
												<th width="15%" class="inner">Area</th>	
												<th width="15%" class="inner">Join Date</th>			
												<th width="10%" class="inner">Actions</th>	
											</tr>
											<tr>
												<td width="30%">
													<div id="div12${ment.id}" ondblclick="showStuff('div12${ment.id}','input12${ment.id}');">${ment.note}<c:if test="${empty ment.note}">No Data</c:if></div>
													<textarea id="input12${ment.id}" name="uNotes"
														style="display: none; ">${ment.note}</textarea>
												</td>
												<td width="15%">
														<div id="div4${ment.id}"
															ondblclick="showStuff('div4${ment.id}','input4${ment.id}');">${ment.address}<c:if test="${empty ment.address}">No Data</c:if></div>
														<input id="input4${ment.id}" name="uIlID" type="text"
														value="${ment.address}" style="display: none;"
														onblur="if(this.value==''){ this.value='address'; this.style.color='#BBB';}" 
							  							onfocus="if(this.value=='address'){this.value=''; this.style.color='#000';}">
													</td>
												<td width="15%">
														<div id="div15${ment.id}"
															ondblclick="showStuff('div15${ment.id}','input15${ment.id}');">${ment.city}<c:if test="${empty ment.city}">No Data</c:if></div>
														<select name="cityId" id="input15${ment.id}" style="display: none;" required >
																<option value="${ment.cityId}"></option>
																<c:forEach var="item" items="${cities}">
																	<option value="${item.id}">   ${item.name}</option>
																</c:forEach>
														</select>						
													</td>
													<td width="15%">
														<div id="div16${ment.id}"
															ondblclick="showStuff('div16${ment.id}','input16${ment.id}');">${ment.area}<c:if test="${empty ment.area}">No Data</c:if></div>
														<select name="areaId" id="input16${ment.id}" style="display: none;" required >
																<option value="${ment.areaId}"></option>
																<c:forEach var="item" items="${areas}">
																	<option value="${item.id}">   ${item.name}</option>
																</c:forEach>
														</select>										
													</td>
												<td width="20%">${ment.joinDate}<c:if test="${empty ment.joinDate}">No Data</c:if></td>
												
												<td width="10%">
													<input id="id:${ment.id}" name="uId" type="text"
														value="${ment.id}" style="display: none;"
														>
													<input class="saveButton" type="submit" style="float: right;" value="Save">
													<input type="button" style="float: right;" value="Mail">
											</td>
												</tr>


											</table>
										</div>
										<div id="Mentor${ment.id}" class="tabcontent"
											style="background-color: rgba(250,178,58,0.8);">
											<table>
												<tr>
													<th width="60%" class="inner">Name</th>	
													<th width="30%" class="inner"></th>	
													<th width="10%" class="inner">Actions</th>	
												</tr>
												<tr>
													<!--<td width="90%">${ment.note}</td>  --> 
													<td width="60%"></td>
													<td width="30%"></td>
													<td width="10%">
														<input class="saveButton" type="submit" style="float: right;" value="Save">
														<input type="button" style="float: right;" value="Mail">
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
		<a onclick="menteeTableToArray(this)" href="#" class="btn-print btn btn-block" >
			<i class="fa fa-print"></i> print</a>
		
		<div id="openModal3" class="modalDialog">			
				<div class="container" >
					<a href="#close" title="Close" class="close"
						style="position: absolute;">X</a>
					<form action="AddMentee" method="post">
						<table class="addMenteeForm">
							<tbody style="background-color:#ccc">
							<tr>
								<td class="form">First name*</td>
								<td class="form"><input type="text" name="uFirstName" 
								 required></td>
								<td width="5%" class="form"> </td>
								<td class="form">Last name*</td>
								<td class="form"><input type="text" name="uLastName" 
							  	 required></td>
							  	 <td width="5%" class="form"> </td>
							  	 <td class="form">Email*</td>
								<td class="form"><input type="text" name="uEmail" 
								 required></td>
							</tr>
							<tr>
								<td class="form">Phone number*</td>
								<td class="form"><input type="number" name="uPhoneNumber" required></td>
								<td width="5%" class="form"> </td>
							 <td class="form">Gender*</td>
								<td class="form">
									<select name="uGender" class="selectpicker" id="gender1" required>
		     							<option value="1">Male</option>
		     		 					<option value="0">Female</option>
	      							</select>
							  	</td>
							  	<td width="5%" class="form"> </td>
								<td class="form">Address</td>
								<td class="form"><input type="text" name="uAddress">
								
							</tr>
							<tr>
								<td class="form">Graduation status</td>
								<td class="form"><input type="text" name="uGraduationStatus"></td>
								<td width="5%" class="form"> </td>
								<td class="form">Academic institution*</td>
								<td>
								<select name="uAcademicInstitution" required>
										<c:forEach var="item" items="${AcadimicIn}">
											<option value="${item.id}">  ${item.name}</option>
										</c:forEach>
								</select>   
								</td>
								<td width="5%" class="form"> </td>
								<td class="form">Average</td>			
								<td class="form"><input type="number" name="uAverage" min="0" max="100" 
								style="color:#BBB;"></td>	
															
								
							</tr>
							<tr>
								<td class="form">Remaining semesters</td>
								<td class="form"><input type="number" name="uRemSemesters"></td>
								<td width="5%" class="form"> </td>
								<td class="form">Dicipline</td>
								<td class="form"><input type="text" name="uAcademicDicipline"></td>
								<td width="5%" class="form"> </td>
								<td class="form">Dicipline 2</td>
								<td class="form"><input type="text" name="uAcademicDicipline2">
								</td>
							</tr>
							<tr>
								<td class="form">ID</td>			
								<td class="form"><input type="number" name="personalId" min="0" max="999999999" 
								style="color:#BBB;"></td>
							  	<td width="5%" class="form"> </td>
							  	<td>City</td>
								<td class="form">
									<select name="cityId">
											<option value="1"></option>
											<c:forEach var="item" items="${cities}">
												<option value="${item.id}">   ${item.name}</option>
											</c:forEach>
									</select>
								</td>
								<td width="5%" class="form"> </td>
								<td>Area*</td>
								<td class="form">
									<select name="areaId" required>
											<c:forEach var="item" items="${areas}">
												<option value="${item.id}">   ${item.name}</option>
											</c:forEach>
									</select>
								</td>
							</tr>
							<tr >
								<td class="form">CV</td>
								<td class="form"><input type="file" name="uCV" ></td>
								<td width="5%" class="form"> </td>
								<td class="form">Grades</td>
								<td class="form"><input type="file" name="uGrades"></td>
								<td width="5%" class="form"> </td>
								<td class="form">Signed</td>
								<td class="form">
									<select name="uSignedEULA" class="selectpicker" id="gender1" >
		     							<option value="true">YES</option>
		     		 					<option value="false">NO</option>
	      							</select>
							  	</td>
								
								
							</tr>
							<tr >
								
								<td class="form">note</td>
								<td class="form" colspan="4"><textarea name="uNotes" style="height: 50px"></textarea></td>
								<td class="form">
									<input type="text" name="id" style="display: none"
									onblur="if(this.value==''){ this.value='id'; this.style.color='#BBB';}" 
									onfocus="if(this.value=='id'){this.value=''; this.style.color='#000';}">
								</td>
							  	 <td width="5%" class="form"> </td>
								<td class="form" >
									<input style="float:center" type="submit" value="Add">
								</td>
								
							</tr>
							</tbody>
							
							
						</table>
						
					</form>
				</div>


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
    	<style type="text/css">tr:nth-child(even){background-color: #ccc !important}</style>
       <section id="PairsTable" class="Pairs">
   <div class="paddDiv"></div> 
  <div>
    <table cellpadding="0" cellspacing="0" border="0">
      <thead>
       <tr style="background-color: rgb(60,78,176);">
          <th width="15.2%">Mentor</th>
          <th width="12.7%"></th>
          <th width="10%"></th>
          <th width="15.2%">Mentee</th>
          <th width="12.7%"></th>
          <th width="10%"></th>
          <th width="5%"></th>
          <th width="5%"></th>
          <th width="14.2%"></th>
          <th width="1%" ></th>
        </tr>
        <tr>
          <th width="15.2%" class="mentor smaller" onclick="sortTable(1)">Name</th>
          <th width="12.7%" class="mentor smaller" onclick="sortTable(3)">Phone</th>
          <th width="10%" class="mentor smaller" onclick="sortTable(5)">Company</th>
          <th width="15.2%" class="mentee smaller" onclick="sortTable(7)">Name</th>
          <th width="12.7%" class="mentee smaller" onclick="sortTable(9)">Phone</th>
          <th width="10%" class="mentee smaller" onclick="sortTable(11)">Academy</th>
          <th width="5%"  style="background-color: #ccc"><i class="fa fa-handshake-o"></i></th>
          <th width="5%" style="background-color: #ccc" ><i class="fa fa-flag-o"></i></th>
          <th width="14.2%" style="background-color: #ccc">Actions</th>
          <th width="1" style="background-color: #ccc"></th>
        </tr>
        <tr>
			<td class="searchtab mentor"> <input id="searchkey1" onkeyup="dynamicSearch()" placeholder="name..." class="serchInput" type="text" ></td>
			<td class="searchtab mentor"> <input id="searchkey2" onkeyup="dynamicSearch()" placeholder="phone..." class="serchInput" name="eeee" type="text"></td>
			<td class="searchtab mentor"> <input id="searchkey3" onkeyup="dynamicSearch()" placeholder="company..." class="serchInput" name="eeee" type="text"></td>
			<td class="searchtab mentee"> <input id="searchkey4" onkeyup="dynamicSearch()" placeholder="name..." class="serchInput" type="text" ></td>
			<td class="searchtab mentee"> <input id="searchkey5" onkeyup="dynamicSearch()" placeholder="phone..." class="serchInput" name="eeee" type="text"></td>
			<td class="searchtab mentee"> <input id="searchkey6" onkeyup="dynamicSearch()" placeholder="academy..." class="serchInput" name="eeee" type="text"></td>
			<td class="searchtab" style="background-color: #ccc"></td>
			<td class="searchtab" style="background-color: #ccc"></td>
			<td class="searchtab" style="background-color: #ccc"></td>
			<td class="searchtab" style="background-color: #ccc"></td>
		</tr>
      </thead>
    </table>
  </div>

  <div class="tbl-content">
    <table class="rightTable">
      <tbody>
   <c:forEach var="pair" items="${pairs}" >
        <tr class="stam">
        	<td width="15.2%" id="mentor">${pair.mentor.firstName} ${pair.mentor.lastName}</td>
        	<td width="12.7%" id="mentorPhone">${pair.mentor.phoneNumber}</td>
			<td width="10%" id="mentee"><c:out value="${pair.mentor.companyName}"></c:out></td>
			<td width="15.2%" id="mentor">${pair.mentee.firstName} ${pair.mentee.lastName}</td>
        	<td width="12.7%" id="mentorPhone">${pair.mentee.phoneNumber}</td>
			<td width="10%" id="mentee"><c:out value="${pair.mentee.academiclnstitutionName}"></c:out></td>
			<td width="5%" class="but"> <i title="Is Scheduled Meeting" class="fa fa-handshake-o"></i></td> 
			<td width="5%" class="but"> <i title="Has Finished" class="fa fa-flag-o"></i></td> 
          	<td width="14.2%" class="but"> 
          		<a class="btn btn-block btn-primary topButton" href="GetMeetingByPairId?id=${pair.pairId}" style="margin-top: 0px;" >
			 		Meetings
    			</a>  <br>
          		<a class="btn btn-block btn-primary disB" id="${pair.pairId}" style="margin-top: 0px;" >
  					Disconnect
   				</a>
    		</td>
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