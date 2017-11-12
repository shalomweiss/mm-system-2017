<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1">

<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style type="text/css"><%@include file="/WEB-INF/css/styles.css"%></style>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<style type="text/css">tr:nth-child(even){background-color: #ccc !important}</style>
<script>
$(document).ready(function(){
	$(".disB").click(function(){
		var areYouSure=document.getElementById("dannyZ");
		areYouSure.getElementsByTagName("H5")[0].innerHTML="Are you sure yo want to delete the pair ?";
		areYouSure.style.display="";
		areYouSure.getElementsByTagName("FOOTER")[0].id=""+$(this).attr('id');
	});
	 $(".button-fill").hover(
   		  function() {
   			    $(this).children(".button-inside").addClass("full");
   			  },
   			  function() {
   			    $(this).children(".button-inside").removeClass("full");
   			  }
   			);
});
function exportToCsv(filename, rows) {
    var processRow = function (row) {
        var finalVal = '';
        for (var j = 0; j < row.length; j++) {
            var innerValue = row[j] === null ? '' : row[j].toString();
            if (row[j] instanceof Date) {
                innerValue = row[j].toLocaleString();
            };
            var result = innerValue.replace(/"/g, '""');
            if (result.search(/("|,|\n)/g) >= 0)
                result = '"' + result + '"';
            if (j > 0)
                finalVal += ',';
            finalVal += result;
        }
        return finalVal + '\n';
    };

    var csvFile = "\ufeff"+'';
    for (var i = 0; i < rows.length; i++) {
        csvFile += processRow(rows[i]);
    }
    var blob = new Blob([csvFile], { type: 'text/csv;charset=utf-8;' });
    if (navigator.msSaveBlob) { // IE 10+
        navigator.msSaveBlob(blob, filename);
    } else {
        var link = document.createElement("a");
        if (link.download !== undefined) { // feature detection
            // Browsers that support HTML5 download attribute
            var url = URL.createObjectURL(blob);
            link.setAttribute("href", url);
            link.setAttribute("download", filename);
            link.style.visibility = 'hidden';
            document.body.appendChild(link);
            link.click();
            document.body.removeChild(link);
        }
    }
}
function pairTableToArray(param)
{
	var matrix=[['Mentor Name','Phone Number','Workplace','Mentee Name','Phone Number','Academy']];
	var tbody=document.getElementsByTagName("tbody")[0];
	var rows=tbody.getElementsByTagName("TR");
	for (var i = 0; i < rows.length; i++) {
		var row=[];
		var columns=rows[i].getElementsByTagName("td");
		for (var j = 0; j < columns.length-1; j++) {
			row.push(columns[j].innerHTML);
		}
		matrix.push(row);
	}
	console.log(matrix);
	var thead=document.getElementsByTagName("thead")[0];
	console.log(thead.getElementsByTagName("tr")[0]);
	exportToCsv('Pairs.csv',matrix);
}
function da(param)
{
	disconnect(param.parentNode.id);
	nyet(param);
}
function nyet(param){
	param.parentNode.parentNode.parentNode.style.display="none";
}
function disconnect(param)
{
	$.post("DisconnectPair",
	        {
	          pairId: param,
	        },
	        function(data,status){
	        	//if data is -1 something is wrong
	            $("#"+data).parent().parent().remove();
	        });
}
</script>
<style>
.icon-bar a {
       padding: 8px;
}
.btn-print
{
	border-radius:18px;
	bottom: 2vh;
}
h5{
	color:#8f9cb5;
	margin-top: 8vh !important;
	display: block;
    margin: auto;
	text-align:center;
	font-size:4vh;
	margin-top: 20px;
	
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
</head>
<body>
<nav class="icon-bar">
	<div class="icon-bar">
		  <a title="Home" href="ForwardPath"><i class="fa fa-home"></i></a> 
		  <a href="GetAllMentors" title="Mentors"><i class="fa fa-black-tie"></i></a> 
		  <a href="GetAllMentees" title="Mentees"><i class="fa fa-graduation-cap"></i></a> 
		  <a class="active" href="GetAllPairs" title="Pairs"><i class="fa fa-group"></i></a>
		  <a href="GetAllAcademicInstitution" title="Reports"><i class="fa fa-clipboard"></i></a>
		  <a href="AddingDataServlet" title="AddingStuff"><i class="fa fa-cogs"></i></a>
		  <a onclick="logout()" href="#" title="Logout"><i class="fa glyphicon">&#xe163;</i></a>	  
	</div>
</nav>
	<h1>Pairs</h1>
	<div class="topPart"> </div>
	<div class="bottomPart"> </div>
	<div class="inner">
		<section class="Pairs">
  <!--for demo wrap--> 
  <div class="tbl-header">
    <table cellpadding="0" cellspacing="0" border="0">
      <thead>
       <tr>
          <th width="15.2%">Mentor</th>
          <th width="12.7%"></th>
          <th width="10%"></th>
          <th width="15.2%">Mentee</th>
          <th width="12.7%"></th>
          <th width="10%"></th>
          <th width="5%"></th>
          <th width="5%"></th>
          <th width="14.2%"></th>
        </tr>
        <tr>
          <th width="15.2%" class="mentor">Name</th>
          <th width="12.7%" class="mentor">Phone</th>
          <th width="10%" class="mentor">Company</th>
          <th width="15.2%" class="mentee">Name</th>
          <th width="12.7%" class="mentee">Phone</th>
          <th width="10%" class="mentee">Academy</th>
          <th width="5%" ><i class="fa fa-handshake-o"></i></th>
          <th width="5%" ><i class="fa fa-flag-o"></i></th>
          <th width="14.2%">Actions</th>
        </tr>
      </thead>
    </table>
  </div>
  <div class="tbl-content">
    <table cellpadding="0" cellspacing="0" border="0">
      <tbody>
   <c:forEach var="pair" items="${pairs}" >
        <tr>
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
<a class="btn btn-block btn-primary .btn-click btn-addClick" href="GetMentorsAndMentees"> <i class="fa fa-plus"></i><i class="fa fa-group"></i> New Pair </a>
 <a onclick="pairTableToArray(this)" href="#" class="btn-print btn btn-block" >
			<i class="fa fa-print"></i> print</a>
 </div>
 	<div id="dannyZ" class="DannyModal" style="display:none;">
	<div class="DannyModalIn">
		<header><h5>Are you Sure you want to deactivate</h5></header>
		<footer>
			<div onclick="da(this)" class="decision yes">YES</div>
			<div onclick="nyet(this)" class="decision no">NO</div>
		</footer>
	</div>
</div>

 </body>
</html> 