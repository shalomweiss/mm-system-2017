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
</head>

<body>
<nav class="icon-bar">
	<div class="icon-bar">
		  <a href="ForwardPath" title="Home"><i class="fa fa-home"></i></a> 
		  <a href="GetAllMentors" title="Mentors"><i class="fa fa-black-tie"></i></a> 
		  <a href="GetAllMentees" title="Mentees"><i class="fa fa-graduation-cap"></i></a> 
		  <a href="GetAllPairs" title="Pairs"><i class="fa fa-group"></i></a>
		  
		  <a  class="active" href="GetAllAcademicInstitution" title="Reports"><i class="fa fa-clipboard"></i></a>	
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
	
</div>


</body>
</html> 