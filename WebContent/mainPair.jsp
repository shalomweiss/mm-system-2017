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
		console.log($(this).attr('id'));
		$.post("DisconnectPair",
		        {
		          pairId: $(this).attr('id'),
		        },
		        function(data,status){
		        	//if data is -1 something is wrong
		            $("#"+data).parent().parent().remove();
		        });
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
</script>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
</head>
<body>
<nav class="icon-bar">
	<div class="icon-bar">
		  <a href="ForwardPath" title="Home"><i class="fa fa-home"></i></a> 
		  <a href="GetAllMentors" title="Mentors"><i class="fa fa-black-tie"></i></a> 
		  <a href="GetAllMentees" title="Mentees"><i class="fa fa-graduation-cap"></i></a> 
		  <a class="active" href="GetAllPairs" title="Pairs"><i class="fa fa-group"></i></a>
		 
		  <a href="GetAllAcademicInstitution" title="Reports"><i class="fa fa-clipboard"></i></a>	
		  <a href="#" title="Logout"><i class="fa glyphicon"></i></a>  
	</div>
</nav>
	<h1>Pairs</h1>
	<div class="topPart"> </div>
	<div class="bottomPart"> </div>
	<div class="inner">
		<section>
  <!--for demo wrap--> 
  <div class="tbl-header">
    <table cellpadding="0" cellspacing="0" border="0">
      <thead>
        <tr>
          <th>Mentor Name</th>
          <th>Mentee Name</th>
          <th>Notification</th>
          <th>Meetings </th>
          <th>Disconnect </th>
        </tr>
      </thead>
    </table>
  </div>
  <div class="tbl-content">
    <table cellpadding="0" cellspacing="0" border="0">
      <tbody>
      
        <tr>
        	<td id="mentor">EDITED</td>
			<td id="mentee">Severus</td>
			<td>1</td>
			<td class="but">   
			 	<a class="btn btn-block btn-primary" href="GetMeetingByPairId?id=76" style="margin-top: 0px;">
			 		Meetings
    			</a>
    		</td>
          	<td class="but">   
          		<a class="btn btn-block btn-primary disB" id="76" style="margin-top: 0px;">
  					Disconnect
   				</a>
    		</td>
        </tr>
        
        <tr>
        	<td id="mentor">Harry</td>
			<td id="mentee">Severus</td>
			<td>1</td>
			<td class="but">   
			 	<a class="btn btn-block btn-primary" href="GetMeetingByPairId?id=80" style="margin-top: 0px;">
			 		Meetings
    			</a>
    		</td>
          	<td class="but">   
          		<a class="btn btn-block btn-primary disB" id="80" style="margin-top: 0px;">
  					Disconnect
   				</a>
    		</td>
        </tr>
        
        <tr>
        	<td id="mentor">created</td>
			<td id="mentee">updatementorr</td>
			<td>1</td>
			<td class="but">   
			 	<a class="btn btn-block btn-primary" href="GetMeetingByPairId?id=81" style="margin-top: 0px;">
			 		Meetings
    			</a>
    		</td>
          	<td class="but">   
          		<a class="btn btn-block btn-primary disB" id="81" style="margin-top: 0px;">
  					Disconnect
   				</a>
    		</td>
        </tr>
        
        <tr>
        	<td id="mentor">newwww</td>
			<td id="mentee">updatementorr</td>
			<td>1</td>
			<td class="but">   
			 	<a class="btn btn-block btn-primary" href="GetMeetingByPairId?id=84" style="margin-top: 0px;">
			 		Meetings
    			</a>
    		</td>
          	<td class="but">   
          		<a class="btn btn-block btn-primary disB" id="84" style="margin-top: 0px;">
  					Disconnect
   				</a>
    		</td>
        </tr>
        
        <tr>
        	<td id="mentor">55</td>
			<td id="mentee">updatementorr</td>
			<td>1</td>
			<td class="but">   
			 	<a class="btn btn-block btn-primary" href="GetMeetingByPairId?id=85" style="margin-top: 0px;">
			 		Meetings
    			</a>
    		</td>
          	<td class="but">   
          		<a class="btn btn-block btn-primary disB" id="85" style="margin-top: 0px;">
  					Disconnect
   				</a>
    		</td>
        </tr>
        
        <tr>
        	<td id="mentor">jojo</td>
			<td id="mentee">Severus</td>
			<td>1</td>
			<td class="but">   
			 	<a class="btn btn-block btn-primary" href="GetMeetingByPairId?id=86" style="margin-top: 0px;">
			 		Meetings
    			</a>
    		</td>
          	<td class="but">   
          		<a class="btn btn-block btn-primary disB" id="86" style="margin-top: 0px;">
  					Disconnect
   				</a>
    		</td>
        </tr>
        
        <tr>
        	<td id="mentor"> newmentee</td>
			<td id="mentee">updatementorr</td>
			<td>1</td>
			<td class="but">   
			 	<a class="btn btn-block btn-primary" href="GetMeetingByPairId?id=88" style="margin-top: 0px;">
			 		Meetings
    			</a>
    		</td>
          	<td class="but">   
          		<a class="btn btn-block btn-primary disB" id="88" style="margin-top: 0px;">
  					Disconnect
   				</a>
    		</td>
        </tr>
        
        <tr>
        	<td id="mentor">99</td>
			<td id="mentee">updatementorr</td>
			<td>1</td>
			<td class="but">   
			 	<a class="btn btn-block btn-primary" href="GetMeetingByPairId?id=89" style="margin-top: 0px;">
			 		Meetings
    			</a>
    		</td>
          	<td class="but">   
          		<a class="btn btn-block btn-primary disB" id="89" style="margin-top: 0px;">
  					Disconnect
   				</a>
    		</td>
        </tr>
        
        <tr>
        	<td id="mentor">kanaane</td>
			<td id="mentee">mentorname</td>
			<td>1</td>
			<td class="but">   
			 	<a class="btn btn-block btn-primary" href="GetMeetingByPairId?id=92" style="margin-top: 0px;">
			 		Meetings
    			</a>
    		</td>
          	<td class="but">   
          		<a class="btn btn-block btn-primary disB" id="92" style="margin-top: 0px;">
  					Disconnect
   				</a>
    		</td>
        </tr>
        
        <tr>
        	<td id="mentor">req1</td>
			<td id="mentee">ll</td>
			<td>1</td>
			<td class="but">   
			 	<a class="btn btn-block btn-primary" href="GetMeetingByPairId?id=93" style="margin-top: 0px;">
			 		Meetings
    			</a>
    		</td>
          	<td class="but">   
          		<a class="btn btn-block btn-primary disB" id="93" style="margin-top: 0px;">
  					Disconnect
   				</a>
    		</td>
        </tr>
        
        <tr>
        	<td id="mentor">local</td>
			<td id="mentee">new</td>
			<td>1</td>
			<td class="but">   
			 	<a class="btn btn-block btn-primary" href="GetMeetingByPairId?id=94" style="margin-top: 0px;">
			 		Meetings
    			</a>
    		</td>
          	<td class="but">   
          		<a class="btn btn-block btn-primary disB" id="94" style="margin-top: 0px;">
  					Disconnect
   				</a>
    		</td>
        </tr>
        
        <tr>
        	<td id="mentor">77</td>
			<td id="mentee">ll</td>
			<td>1</td>
			<td class="but">   
			 	<a class="btn btn-block btn-primary" href="GetMeetingByPairId?id=95" style="margin-top: 0px;">
			 		Meetings
    			</a>
    		</td>
          	<td class="but">   
          		<a class="btn btn-block btn-primary disB" id="95" style="margin-top: 0px;">
  					Disconnect
   				</a>
    		</td>
        </tr>
        
        <tr>
        	<td id="mentor">kk</td>
			<td id="mentee">Severus</td>
			<td>1</td>
			<td class="but">   
			 	<a class="btn btn-block btn-primary" href="GetMeetingByPairId?id=96" style="margin-top: 0px;">
			 		Meetings
    			</a>
    		</td>
          	<td class="but">   
          		<a class="btn btn-block btn-primary disB" id="96" style="margin-top: 0px;">
  					Disconnect
   				</a>
    		</td>
        </tr>
        
        <tr>
        	<td id="mentor">tony</td>
			<td id="mentee">muhamad</td>
			<td>1</td>
			<td class="but">   
			 	<a class="btn btn-block btn-primary" href="GetMeetingByPairId?id=97" style="margin-top: 0px;">
			 		Meetings
    			</a>
    		</td>
          	<td class="but">   
          		<a class="btn btn-block btn-primary disB" id="97" style="margin-top: 0px;">
  					Disconnect
   				</a>
    		</td>
        </tr>
        
        <tr>
        	<td id="mentor">mente</td>
			<td id="mentee">mentorname</td>
			<td>1</td>
			<td class="but">   
			 	<a class="btn btn-block btn-primary" href="GetMeetingByPairId?id=98" style="margin-top: 0px;">
			 		Meetings
    			</a>
    		</td>
          	<td class="but">   
          		<a class="btn btn-block btn-primary disB" id="98" style="margin-top: 0px;">
  					Disconnect
   				</a>
    		</td>
        </tr>
        
        <tr>
        	<td id="mentor">kkrr</td>
			<td id="mentee">mentorname</td>
			<td>1</td>
			<td class="but">   
			 	<a class="btn btn-block btn-primary" href="GetMeetingByPairId?id=99" style="margin-top: 0px;">
			 		Meetings
    			</a>
    		</td>
          	<td class="but">   
          		<a class="btn btn-block btn-primary disB" id="99" style="margin-top: 0px;">
  					Disconnect
   				</a>
    		</td>
        </tr>
        
        <tr>
        	<td id="mentor">firdos</td>
			<td id="mentee">muhamad</td>
			<td>1</td>
			<td class="but">   
			 	<a class="btn btn-block btn-primary" href="GetMeetingByPairId?id=100" style="margin-top: 0px;">
			 		Meetings
    			</a>
    		</td>
          	<td class="but">   
          		<a class="btn btn-block btn-primary disB" id="100" style="margin-top: 0px;">
  					Disconnect
   				</a>
    		</td>
        </tr>
        
        <tr>
        	<td id="mentor">dani</td>
			<td id="mentee">TONY</td>
			<td>1</td>
			<td class="but">   
			 	<a class="btn btn-block btn-primary" href="GetMeetingByPairId?id=101" style="margin-top: 0px;">
			 		Meetings
    			</a>
    		</td>
          	<td class="but">   
          		<a class="btn btn-block btn-primary disB" id="101" style="margin-top: 0px;">
  					Disconnect
   				</a>
    		</td>
        </tr>
        
        <tr>
        	<td id="mentor">0</td>
			<td id="mentee">Severus</td>
			<td>1</td>
			<td class="but">   
			 	<a class="btn btn-block btn-primary" href="GetMeetingByPairId?id=102" style="margin-top: 0px;">
			 		Meetings
    			</a>
    		</td>
          	<td class="but">   
          		<a class="btn btn-block btn-primary disB" id="102" style="margin-top: 0px;">
  					Disconnect
   				</a>
    		</td>
        </tr>
        
        <tr>
        	<td id="mentor">m</td>
			<td id="mentee">updatementorr</td>
			<td>1</td>
			<td class="but">   
			 	<a class="btn btn-block btn-primary" href="GetMeetingByPairId?id=103" style="margin-top: 0px;">
			 		Meetings
    			</a>
    		</td>
          	<td class="but">   
          		<a class="btn btn-block btn-primary disB" id="103" style="margin-top: 0px;">
  					Disconnect
   				</a>
    		</td>
        </tr>
        
      </tbody>
    </table>
  </div>

 <a class="btn btn-block btn-primary .btn-click btn-addClick" href="GetMentorsAndMentees"> <i class="fa fa-plus"></i><i class="fa fa-group"></i> New Pair </a>
</section>
 </div>

 </body>
</html> 