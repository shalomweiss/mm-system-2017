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
$(".search").click(function() {
	var numOfDays=$("#days").val();
	console.log(numOfDays);
	if(numOfDays>=0)
	$.post("PairReport1",
	        {
	          numOfDays: numOfDays,
	        },
	        function(data,status){
	        	//TODO: fill here, look for other function below for reference (will need to expand)
	        });
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
	<header>
		<h5 style="font-size: 20px; font-weight: bold;">Reports</h5>
	</header>
	<main style="width: 80%;
    position: absolute;
    height: 65%;
    top: 37%;
    left: 5%;">
	<table style="padding:10px;">
		<tbody>
			<tr>
				<td>Get all the pairs that have not met in: <input style="width:50px;"  placeholder="type a number..." type="number" id="days" name="daysWithoutMeeting"> days</td>
			</tr>
		</tbody>
	</table>
	
	</main>
			<a href="#openModal3" class="btn btn-block btn-primary btn-addClick search" style="width: 10% !important; ">Search</a>
</div>	
<div class="topPart"> </div>
<div class="bottomPart"> </div>
<div class="inner inner--right">
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
</div>
</body>
</html> 