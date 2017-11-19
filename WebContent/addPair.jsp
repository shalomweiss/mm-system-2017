<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<head>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style type="text/css"><%@include file="WEB-INF/css/styles.css" %> v</style>
	<script>
	$(document).ready(function(){
		$("tr").click(function() {
		    $(this).addClass('selected').siblings().removeClass("selected");
		});
		$("#createPair").click(function(){
			var trs= document.getElementsByClassName("selected");
			if(trs.length==2)
			{
				var menteeId=trs[0].getElementsByClassName("menteeId")[0].innerHTML;
				var mentorId=trs[1].getElementsByClassName("mentorId")[0].innerHTML;
				$.post("CreateNewPair",
				        {
				          menteeID: menteeId,
				          mentorID: mentorId
				        },
				        function(data,status){
				        	location.reload();
				        });
				var body=document.getElementsByTagName("body")[0];
				body.innerHTML='<div class="waiting"><div class="loader">Loading...</div><p class="sorry">Sorry, Please wait...<br>We are making the world a better place one pair at a time :)</p>';
				
			}
			
	});
	});
var even=1;
function sortTable1(compare)
{
	colnum=compare;
	var rows=document.getElementsByClassName("stam");
	var args = Array.prototype.slice.call(rows);
	args.sort(compareRows);
	even=even*(-1);
	var tbody=document.getElementById("myTable").childNodes[1];
	for (var i = 0; i < args.length; i++) {
		tbody.appendChild(args[i]);
	}
}
function sortTable2(compare)
{
	colnum=compare;
	var rows=document.getElementsByClassName("stam1");
	var args = Array.prototype.slice.call(rows);
	args.sort(compareRows);
	even=even*(-1);
	var tbody=document.getElementById("myTable1").childNodes[1];
	for (var i = 0; i < args.length; i++) {
		tbody.appendChild(args[i]);
	}
}
function compareRows(tr1,tr2)
{
	var name1=tr1.childNodes[colnum].innerHTML;
	var name2=tr2.childNodes[colnum].innerHTML;
	if(even==1)
		return name1.localeCompare(name2);
	else
		return (name2.localeCompare(name1));
}
var sign=1;

function sigmed()
{
	if(sign==1)
		sign=2;
	else if(sign==2)
		sign=3
	else
		sign=1;
	dynamicSearch('');
}

function dynamicSearch(param)
{
	$(".nono").removeClass("nono");
	var search1=document.getElementById("searchkey1"+param).value.toUpperCase();
	var search2=document.getElementById("searchkey2"+param).value.toUpperCase();
	var search3=document.getElementById("searchkey3"+param).value.toUpperCase();
	var search4=document.getElementById("searchkey4"+param).value.toUpperCase();
	var search5=document.getElementById("searchkey5"+param).value.toUpperCase();
	$(".stam"+param).show();
	var rows=document.getElementsByClassName("stam"+param);
	if(sign==1)
	{
		$(".false").parent().hide();
		$(".true").parent().show();
	}
	else if(sign==2)
	{
		$(".false").parent().show();
		$(".true").parent().hide();
	}
	else
		{
		$(".false").parent().show();
		$(".true").parent().show();
		}
	for (var i = 0; i < rows.length; i++) {
		var val=rows[i].childNodes;
		if(val[1].innerHTML.toUpperCase().indexOf(search1)<=-1)
			val[1].className="nono"
		if(val[3].innerHTML.toUpperCase().indexOf(search2)<=-1)
			val[1].className="nono"

		else if(val[5].innerHTML.toUpperCase().indexOf(search3)<=-1)
			val[1].className="nono"
		
		else if(val[7].innerHTML.toUpperCase().indexOf(search4)<=-1)
			val[1].className="nono"
		
		else if(val[9].innerHTML.toUpperCase().indexOf(search5)<=-1)
			val[1].className="nono"
		$(".nono").parent().hide();
	}
}
	function goBack() {
	    window.history.back();
	}
</script>	
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
</head>

<style>
div.inner{
	    bottom: 12%;
}
div.inner--left1{
		width: calc( 44% - 15px);
       	left: 100px;
}
div.inner--right{
	left : calc( 0px + 56%);
}
th{
	font-size: 12px;
	padding: 20px 4px !important;
}
tr:nth-child(even) {
    background-color: #ccc !important;
}
h4{
	font-size: 18px;
	color:black;
	text-align:left;
	text-shadow: 0px 0px 0px #CCCCCC;
}
.serchInput{
	width:100%;
}
</style>
<body>
<nav class="icon-bar">
	<div class="icon-bar">
			<a  href="GetAllPairs" title="Back"><i class="fa fa-arrow-circle-left"></i></a> 
		 <a  title="Home" href="ForwardPath"><i class="fa fa-home"></i></a> 
		  <a href="GetAllMentors" title="Mentors"><i class="fa fa-black-tie"></i></a> 
		  <a href="GetAllMentees" title="Mentees"><i class="fa fa-graduation-cap"></i></a> 
		  <a class="active" href="GetAllPairs" title="Pairs"><i class="fa fa-group"></i></a>
		  <a href="GetAllAcademicInstitution" title="Reports"><i class="fa fa-clipboard"></i></a>
		  <a href="AddingDataServlet" title="AddingStuff"><i class="fa fa-cogs"></i></a>
		  <a onclick="logout()" href="#" title="Logout"><i class="fa glyphicon">&#xe163;</i></a>	  
		   
	</div>
</nav>
<div class="topPart"> </div>
	<div class="bottomPart"> </div>
	<div class="inner inner--left1">
	<section class="Pairs" style="width: 100% !important;">
		<div class="container-fluid" >
			 <div style= "padding-left: 0px;">
    	<h4 id="mentee">MENTEES</h4>
    	<br>
		 <div class="tbl-header-mentee">
		 
    <table cellpadding="0" cellspacing="0" border="0">
      <thead>
        <tr>
          <th width="18%" class="smaller" onclick="sortTable1(1)">Name</th>
	      <th width="16%" class="smaller" onclick="sortTable1(3)">Phone</th>
	      <th width="16%" class="smaller" onclick="sortTable1(5)">Gender</th>
	      <th width="16%" class="smaller" onclick="sortTable1(7)">Area</th>
		  <th width="18%" class="smaller" onclick="sortTable1(9)">Academy</th>
          <th width="8%"  class="smaller" title="Does have CV?"><i class="fa fa-file-text-o"></i></th>
          <th width="8%"  class="smaller" onclick="sigmed()" title="Did signed?"><i class="fa fa-pencil-square-o"></i></th>
        </tr>
        <tr style="background-color: #FFC107 !important;">
			<td width="18%" class="searchtab"> <input id="searchkey1" onkeyup="dynamicSearch('')" placeholder="name..." class="serchInput" type="text" ></td>
			<td width="16%" class="searchtab"> <input id="searchkey2" onkeyup="dynamicSearch('')" placeholder="phone..." class="serchInput" name="eeee" type="text"></td>
			<td width="16%" class="searchtab"> <input id="searchkey3" onkeyup="dynamicSearch('')" placeholder="gender" class="serchInput" name="eeee" type="text"></td>
			<td width="16%" class="searchtab"> <input id="searchkey4" onkeyup="dynamicSearch('')" placeholder="area..." class="serchInput" name="eeee" type="text"></td>
			<td width="18%" class="searchtab"> <input id="searchkey5" onkeyup="dynamicSearch('')" placeholder="Academy..." class="serchInput" name="eeee" type="text"></td>
			<td width="8%" class="searchtab"></td>
			<td width="8%" class="searchtab"></td>
		</tr>
      </thead>
    </table>
  </div>
  <div class="tbl-content tbl-content-pair">
    <table cellpadding="0" cellspacing="0" border="0" id="myTable">
      <tbody>
      <c:forEach var="mentee" items="${Mentees}" >
			<tr class="mentee stam" id="tabletest">
			<td width="18%">${mentee.firstName} ${mentee.lastName}</td>
			<td width="16%">${mentee.phoneNumber}</td>
			<td width="16%"><c:if test="${ment.gender == 0}">fe</c:if>male</td>
			<td width="16%">${mentee.area}</td>
			<td width="18%">${mentee.academiclnstitutionName}</td>
			<td width="8%" ><i class="fa fa-file-text-o"></i></td>
			<td width="8%" class="${mentee.signedEULA}">
				<c:if test="${mentee.signedEULA}"> <i class="fa fa-pencil-square-o"></i></c:if>
				<c:if test="${!mentee.signedEULA}"> <i class="fa fa-ban"></i></c:if>
			</td>
			<td style="display:none;" class="menteeId"><c:out value="${mentee.id}"></c:out></td>
			<td style="display:none;" class="menteeAddress"><c:out value="${mentee.address}"></c:out></td>
			<td style="display:none;" class="menteeUniversity"><c:out value="${mentee.academiclnstitution}"></c:out></td></tr>
		</c:forEach>
      </tbody>
    </table>
  </div>
	</div>		
		</div>
	</section>
	</div>
	<h1>New Pairs</h1>
	<div class="topPart"> </div>
	<div class="bottomPart"> </div>
	<div class="inner inner--right">
	<section class="Pairs" style="width: 100% !important;">
<div class="container-fluid" >
    <div style= "padding-right: 0px;" >
	<!--for demo wrap-->
	<h4>MENTORS</h4>
	<br>
  <div class="tbl-header-mentor">
  
    <table cellpadding="0" cellspacing="0" border="0">
      <thead>
        <tr>
		  <th width="18%" class="smaller" onclick="sortTable2(1)">Name</th>
	      <th width="18%" class="smaller" onclick="sortTable2(3)">Phone</th>
	      <th width="17%" class="smaller" onclick="sortTable2(5)">Gender</th>
	      <th width="18%" class="smaller" onclick="sortTable2(7)">Area</th>
		  <th width="21%" class="smaller" onclick="sortTable2(9)">company</th>
        </tr>
        <tr style="background-color: rgba(108,136,225,0.9) !important;">
			<td width="18%" class="searchtab"> <input id="searchkey11" onkeyup="dynamicSearch('1')" placeholder="name..." class="serchInput" type="text" ></td>
			<td width="18%" class="searchtab"> <input id="searchkey21" onkeyup="dynamicSearch('1')" placeholder="phone..." class="serchInput" name="eeee" type="text"></td>
			<td width="17%" class="searchtab"> <input id="searchkey31" onkeyup="dynamicSearch('1')" placeholder="gender" class="serchInput" name="eeee" type="text"></td>
			<td width="18%" class="searchtab"> <input id="searchkey41" onkeyup="dynamicSearch('1')" placeholder="area..." class="serchInput" name="eeee" type="text"></td>
			<td width="21%" class="searchtab"> <input id="searchkey51" onkeyup="dynamicSearch('1')" placeholder="Academy..." class="serchInput" name="eeee" type="text"></td>
		</tr>
      </thead>
    </table>
  </div>
  <div class="tbl-content tbl-content-pair">
    <table cellpadding="0" cellspacing="0" border="0" id="myTable1">
      <tbody >
       <c:forEach items="${Mentors}" var="mentor">
			<tr class="mentor stam1">
				<td  width="18%">${mentor.firstName} ${mentor.lastName}</td>
				<td  width="18%">${mentor.phoneNumber}</td>
				<td  width="17%"><c:if test="${ment.gender == 0}">fe</c:if>male</td>
				<td  width="18%">${mentor.area}</td>
				<td  width="21%">${mentor.companyName}</td>
				<td style="display:none;" class="mentorId"><c:out value="${mentor.id}"></c:out></td>
				<td style="display:none;" class="mentorAddress"><c:out value="${mentor.address}"></c:out></td>
				<td style="display:none;" class="mentorCompany"><c:out value="${mentor.company}"></c:out></td>
			</tr>
		</c:forEach>
      </tbody>
    </table>
  </div>
	</div>
  </div>
    
</section>
</div>
 <a class="btn btn-block btn-primary createPairs" id="createPair">
  <i class="fa fa-plus"></i>
  <i class="fa fa-group"></i>
  Create Pair </a>
</body>

</html>