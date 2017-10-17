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
function showMentor() {
    div = document.getElementById('search1'); //mentor
    div2 = document.getElementById('search2'); //mentee
    div3 = document.getElementById('search3'); //pair

    div.style.display = "";
    div2.style.display = "none";
    div3.style.display = "none";
}

function showMentee() {
    div = document.getElementById('search1');
    div2 = document.getElementById('search2');
    div3 = document.getElementById('search3');
  
    div.style.display = "none";
    div2.style.display = "";
    div3.style.display = "none";
}
function showPair() {
    div = document.getElementById('search1');
    div2 = document.getElementById('search2');
    div3 = document.getElementById('search3');
    
    div.style.display = "none";
    div2.style.display = "none";
    div3.style.display = "";
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
  
    $.post("MentorReports",
            {
            uAddress: city,
            uCompany: work,
            uGender: gender,
            inpair: pair
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
		  <a href="#"><i class="fa fa-bell" title="Notifications"></i></a>
		  <a  class="active" href="GetAllAcademicInstitution" title="Reports"><i class="fa fa-clipboard"></i></a>	
		  <a href="#" title="Logout"><i class="fa glyphicon">&#xe163;</i></a> 
	</div>
</nav>
	
	

<h1>Reports</h1>
<div class="topPart"> </div>
	<div class="bottomPart"> </div>
	<div class="inner inner--left">
	
<section>

		
				<div class="container-fluid" >
	
  <div class="searchMentor" id="search1">

    <form class="well form-horizontal" method="post"  id="contact_form" style="background-color:transparent;border: transparent;">
<fieldset>

<!-- Form Name -->
<legend>
<ul>
	<li><a class="activeS" onclick="showMentor()">Mentor</a></li>
  <li><a onclick="showMentee()">Mentee</a></li>
  <li><a onclick="showPair()">Pair</a></li>
</ul>
</legend>




<div class="form-group">
  <label class="col-md-5 control-label">Address</label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
  <input name="uAddress"  class="form-control"  type="text" id="city1"
  	onblur="if(this.value==''){ this.value='city'; this.style.color='#BBB';}" 
	onfocus="if(this.value=='city'){this.value=''; this.style.color='#000';}">
    </div>
  </div>
</div>

<!-- Select Basic -->
   
<div class="form-group"> 
  <label class="col-md-5 control-label" >Gender</label>
    <div class="col-md-4 selectContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
    <select name="uGender" class="form-control selectpicker" id="gender1" >
      <option></option>
      <option value="male">male</option>
      <option value="female">female</option>
      <option value="other">other</option>
    </select>
  </div>
</div>
</div>



<!-- Text input-->
<div class="form-group">
  <label class="col-md-5 control-label">Company</label>  
   <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
    <select name="uCompany" class="form-control selectpicker">
		<c:forEach var="item" items="${AllWorkPlaces}">
			<option value="${item.id}">${item.company}</option>
		</c:forEach>
	</select>
								
    <!-- 
    
        <span class="input-group-addon"><i class="glyphicon glyphicon-globe"></i></span>
  <input name="work" class="form-control" type="text" id="work"
  onblur="if(this.value==''){ this.value='work'; this.style.color='#BBB';}" 
	onfocus="if(this.value=='work'){this.value=''; this.style.color='#000';}"> -->
    </div>
  </div>
</div>

<!-- radio checks -->
 <div class="form-group" id="formP1" >
                        <label class="col-md-5 control-label">In a pair?</label>
                        <div class="col-md-4">
                            <div class="radio">
                                <label>
                                    <input type="radio" name="pair1" id="pair1" value="yes" /> Yes
                                </label>
                            </div>
                            <div class="radio">
                                <label>
                                    <input type="radio" name="pair1" id="pair1" value="no" /> No
                                </label>
                            </div>
                        </div>
                    </div>

  



<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label"></label>
  <div class="col-md-4">
    <a class="btn" onclick="showMentorTable()"  id="submit1">Search <span class="glyphicon glyphicon-send"></span></a>
  </div>
</div>

</fieldset>
</form>
</div>
    
    
<div class="searchMentee" id="search2"  style=" display: none">

    <form class="well form-horizontal" action=" " method="post"  id="contact_form" style="background-color:transparent;border: transparent;">
<fieldset>

<!-- Form Name -->
<legend>
<ul>
	<li><a  onclick="showMentor()">Mentor</a></li>
  <li><a class="activeS" onclick="showMentee()">Mentee</a></li>
  <li><a onclick="showPair()">Pair</a></li>
</ul>
</legend>
<div class="form-group">
  <label class="col-md-5 control-label">Address</label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
  <input name="uAddress"  class="form-control"  type="text" id="city2"
  onblur="if(this.value==''){ this.value='city'; this.style.color='#BBB';}" 
	onfocus="if(this.value=='city'){this.value=''; this.style.color='#000';}">
    </div>
  </div>
</div>

<!-- Select Basic -->
   
<div class="form-group"> 
  <label class="col-md-5 control-label">Gender</label>
    <div class="col-md-4 selectContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
    <select name="uGender" class="form-control selectpicker" id="gender2">
      <option value=" " ></option>
      <option>male</option>
      <option>female</option>
      <option>other</option>
    </select>
  </div>
</div>
</div>



<!-- Text input-->
<div class="form-group">
  <label class="col-md-5 control-label">Institution</label>  
   <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
       
        
       <select name="uAcademicInstitution" class="form-control selectpicker">
		<c:forEach var="item" items="${AllAcademicInstitutes}">
				<option value="${item.id}">  ${item.name}</option>
		</c:forEach>
		</select>  
   <!--      
  <input name="website" class="form-control" type="text" id="institution"
  onblur="if(this.value==''){ this.value='institution'; this.style.color='#BBB';}" 
	onfocus="if(this.value=='institution'){this.value=''; this.style.color='#000';}">--> 
    </div>
  </div>
</div>

<div class="form-group">
  <label class="col-md-5 control-label">Academic discipline</label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
  <input name="academic"  class="form-control"  type="text" id="academic"
  onblur="if(this.value==''){ this.value='acDic'; this.style.color='#BBB';}" 
	onfocus="if(this.value=='acDic'){this.value=''; this.style.color='#000';}">
    </div>
  </div>
</div>

<!-- radio checks -->
 <div class="form-group" id="formP2">
                        <label class="col-md-4 control-label">In a pair?</label>
                        <div class="col-md-4">
                            <div class="radio">
                                <label>
                                    <input type="radio" name="pair2" id="pair2" value="yes" /> Yes
                                </label>
                            </div>
                            <div class="radio">
                                <label>
                                    <input type="radio" name="pair2" id="pair2" value="no" /> No
                                </label>
                            </div>
                        </div>
                    </div>

  



<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label"></label>
  <div class="col-md-4">
    <a class="btn " onclick="showMenteeTable()" id="submit2">Search <span class="glyphicon glyphicon-send"></span></a>
    
  </div>
</div>

</fieldset>
</form>
</div>
    
    
<div class="searchPair" id="search3" style=" display: none" >

    <form class="well form-horizontal" action=" " method="post"  id="contact_form" style="background-color:transparent;border: transparent;">
<fieldset>

<!-- Form Name -->
<legend>
<ul>
	<li><a onclick="showMentor()">Mentor</a></li>
  <li><a onclick="showMentee()">Mentee</a></li>
  <li><a class="activeS" onclick="showPair()">Pair</a></li>
</ul>
</legend>





<div class="form-group">
  <label class="col-md-5 control-label">Mentor First Name </label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
       
  <input name="MentorName"  class="form-control" id="mentorN"  type="text"
  onblur="if(this.value==''){ this.value='name'; this.style.color='#BBB';}" 
	onfocus="if(this.value=='name'){this.value=''; this.style.color='#000';}">
    </div>
  </div>
</div>



<!-- Text input-->
<div class="form-group">
  <label class="col-md-5 control-label">Mentor Last Name</label>  
   <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
       
  <input name="MentorLast" class="form-control" id="mentorLast" type="text"
  onblur="if(this.value==''){ this.value='name'; this.style.color='#BBB';}" 
	onfocus="if(this.value=='name'){this.value=''; this.style.color='#000';}">
    </div>
  </div>
</div>

<!-- number input-->
<div class="form-group">
  <label class="col-md-5 control-label">Number of meetings</label>  
   <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
       
  <input name="" class="form-control" id="" type="number" min="1"
  onblur="if(this.value==''){ this.value='0'; this.style.color='#BBB';}" 
	onfocus="if(this.value=='0'){this.value=''; this.style.color='#000';}">
    </div>
  </div>
</div>



<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label"></label>
  <div class="col-md-4">
    <a class="btn " onclick="showPairTable()" id="submit3">Search <span class="glyphicon glyphicon-send"></span></a>
  </div>
</div>

</fieldset>
</form>
</div>
    
	</div>
			</section>
			</div>
			
			
			
			
			
	<div class="topPart"> </div>
	<div class="bottomPart"> </div>
	<div class="inner inner--right">
	
	<section class="Pairs">
	<div class=mentorT style=" display: none" id="mentor">
			<div class="tbl-header" style="margin-left: 4%; margin-right: 4%;margin-bottom: 4%; margin-top: 4%;">
  
    <table cellpadding="0" cellspacing="0" border="0">
      <thead>
        <tr>
          <th>Name Mentor</th>
          <th>Last Name</th>
          <th>Phone</th>
          <th>Email</th>
          <th>Gender</th>
        </tr>
      </thead>
    </table>
  </div>
  <div class="tbl-content">
    <table cellpadding="0" cellspacing="0" border="0" id="myTable1" class="table1">
      <tbody>
       
			<tr class="para"><td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td></tr>
			
	
      </tbody>
    </table>
    </div>
    </div>
    
    
    <div class="menteeT" style=" display: none" id="mentee">
    	<div class="tbl-header" style="margin-left: 4%; margin-right: 4%;margin-bottom: 4%; margin-top: 4%;">
    <table  cellpadding="0" cellspacing="0" border="0">
      <thead>
        <tr>
          <th>Name Mentee</th>
          <th>Last Name</th>
          <th>Phone</th>
          <th>Email</th>
          <th>Gender</th>
        </tr>
      </thead>
    </table>
  </div>
  <div class="tbl-content">
    <table cellpadding="0" cellspacing="0" border="0" id="myTable1" class="table2">
      <tbody>
       
			<tr class="para"><td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td></tr>
			
		
      </tbody>
    </table>
    </div>
    </div>
    
    <div class="pairT" style=" display: none" id="pair">
    <div class="tbl-header" style="margin-left: 4%; margin-right: 4%;margin-bottom: 4%; margin-top: 4%;">
    <table cellpadding="0" cellspacing="0" border="0" >
      <thead>
        <tr>
          <th>Mentor Name</th>
          <th>Mentee Name</th>
          <th>Active</th>
          <th>start date</th>
          <th>end date</th>
        </tr>
      </thead>
    </table>
  </div>
  <div class="tbl-content">
    <table cellpadding="0" cellspacing="0" border="0" id="myTable1" class="table3">
      <tbody>
       
			<tr class="para"><td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td></tr>
      </tbody>
    </table>
  </div>
	</div>

</section>
</div>


</body>
</html> 