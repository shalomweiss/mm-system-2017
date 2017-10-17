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
function showCompanyForm() {
    div1 = document.getElementById('academic'); 
    div2 = document.getElementById('company'); 
    div1.style.display = "none";
    div2.style.display = "";
}

function showAcademicForm() {
	console.log("aaaaaaaaaaaaaaaaaaaaaaaa");
	 div1 = document.getElementById('academic'); 
	 div2 = document.getElementById('company'); 
	 console.log(div1);
	 console.log(div2);
	 div1.style.display = "";
	 div2.style.display = "none";
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
	
	

<h1>Adding New Company or Academic Institution</h1>
<div class="topPart"> </div>
	<div class="bottomPart"> </div>
	<div class="inner" style="right: 15%; width: 65%;">
	
<section>

		
<div class="container-fluid" >
	
  <div class="searchMentor" id="company">

    <form class="well form-horizontal" method="post"  id="contact_form" style="background-color:transparent;border: transparent;">
<fieldset>

<!-- Form Name -->
<legend>
<ul>
	<li><a class="activeS" id="c1" onclick="showCompanyForm()">Add New Company</a></li>
  <li><a onclick="showAcademicForm()" id="c2">Add New Academic Institution</a></li>
</ul>
</legend>




<div class="form-group">
  <label class="col-md-5 control-label">Company Name</label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
  <input name="uAddress"  class="form-control"  type="text" id="city1"
  	onblur="if(this.value==''){ this.value='city'; this.style.color='#BBB';}" 
	onfocus="if(this.value=='city'){this.value=''; this.style.color='#000';}">
    </div>
  </div>
</div>

<div class="form-group">
  <label class="col-md-5 control-label">Area</label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
  <input name="uAddress"  class="form-control"  type="text" id="city1"
  	onblur="if(this.value==''){ this.value='city'; this.style.color='#BBB';}" 
	onfocus="if(this.value=='city'){this.value=''; this.style.color='#000';}">
    </div>
  </div>
</div>

<div class="form-group">
  <label class="col-md-5 control-label">City</label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
  <input name="uAddress"  class="form-control"  type="text" id="city1"
  	onblur="if(this.value==''){ this.value='city'; this.style.color='#BBB';}" 
	onfocus="if(this.value=='city'){this.value=''; this.style.color='#000';}">
    </div>
  </div>
</div>

  



<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label"></label>
  <div class="col-md-4">
    <a class="btn" onclick="showMentorTable()"  id="submit1">Submit <span class="glyphicon glyphicon-send"></span></a>
  </div>
</div>

</fieldset>
</form>
</div>
    
    
<div class="searchMentee" id="academic"  style=" display: none">

    <form class="well form-horizontal" action=" " method="post"  id="contact_form" style="background-color:transparent;border: transparent;">
<fieldset>

<!-- Form Name -->
<legend>
<ul>
	<li><a id="c3" onclick="showCompanyForm()">Add New Company</a></li>
  <li><a onclick="showAcademicForm()" class="activeS" id="c4">Add New Academic Institution</a></li>

</ul>
</legend>
<div class="form-group">
  <label class="col-md-5 control-label">Institution Name</label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
  <input name="uAddress"  class="form-control"  type="text" id="city2"
  onblur="if(this.value==''){ this.value='city'; this.style.color='#BBB';}" 
	onfocus="if(this.value=='city'){this.value=''; this.style.color='#000';}">
    </div>
  </div>
</div>


<div class="form-group">
  <label class="col-md-5 control-label">Area</label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
  <input name="academic"  class="form-control"  type="text" id="academic"
  onblur="if(this.value==''){ this.value='acDic'; this.style.color='#BBB';}" 
	onfocus="if(this.value=='acDic'){this.value=''; this.style.color='#000';}">
    </div>
  </div>
</div>
  
 <div class="form-group">
  <label class="col-md-5 control-label">City</label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
  <input name="academic"  class="form-control"  type="text" id="academic"
  onblur="if(this.value==''){ this.value='acDic'; this.style.color='#BBB';}" 
	onfocus="if(this.value=='acDic'){this.value=''; this.style.color='#000';}">
    </div>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label"></label>
  <div class="col-md-4">
    <a class="btn " onclick="showMenteeTable()" id="submit2">Submit <span class="glyphicon glyphicon-send"></span></a>
    
  </div>
</div>

</fieldset>
</form>
</div>
    </div>
    
</section>
			
</div>


</body>
</html> 