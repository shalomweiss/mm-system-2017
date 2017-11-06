$(document).ready(function(){
	
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
	
	$(".Sign2").click(function(){
		var sign2=document.getElementsByClassName("Sign1")[0];
		sign2.id="clickedSign";
		var sign1=document.getElementsByClassName("Sign2")[0];
		sign1.id="noclickedclickedSign";
	});
	$(".Sign2").click(function(){
		var sign2=document.getElementsByClassName("Sign1")[0];
		sign2.id="noclickedclickedSign";
		var sign1=document.getElementsByClassName("Sign2")[0];
		sign1.id="clickedSign";
	});
	$(".stam1").click(function()
			{
		
			}
	
	);
});
	function deactivate(param)
	{
		var row=param.parentNode.parentNode;
		$.post("DeactivateUser",{
			'userId':row.firstChild.nextSibling.innerHTML,
		},
		        function(data,status){
		        	alert(data);
		        });
		row.parentNode.removeChild(row.nextSibling.nextSibling);
		row.parentNode.removeChild(row);
		
	}
	function getMentorOfMentee(param) {
		//.childNodes[1].childNodes[1].childNodes[1]
		var mentId=param.parentNode.nextSibling.nextSibling.id.substr(4);
		console.log(mentId);
		var sendData={id1:mentId};
		console.log(sendData);
		$.post("GetMentorOfMentee",{
			'id':mentId,
		},
		        function(data,status){
		        	alert(data);
		        });
	}
	function sendAPK(param)
	{
		var thisForm=param.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode;
		var rowColumns=thisForm.childNodes[1].childNodes[1].childNodes[1].childNodes[2].childNodes;
		var fname=rowColumns[1].childNodes[1].innerHTML;
		var lname=rowColumns[3].childNodes[1].innerHTML;
		var email=rowColumns[11].childNodes[1].innerHTML;
		console.log(fname+" "+lname+" "+email);
		$.post("SendAPK",
		        {
					uFirstName: fname,
					uLastName: lname,
					uEmail:email
		        },
		        function(data,status){
		        	alert(data);
		        });
	}
	function goToEdit(firstName, lastName, phone, email, academicInstitution,
			note, courseOfStudy, remainingSemesters, average, id) {
		document.getElementById("fname").value = firstName;
		document.getElementById("lname").value = lastName;
		document.getElementById("phone").value = phone;
		document.getElementById("email").value = email;

		document.getElementById("academic").value = academicInstitution;
		document.getElementById("note").value = note;
		document.getElementById("course").value = courseOfStudy;
		document.getElementById("semesters").value = remainingSemesters;
		document.getElementById("average").value = average;
		document.getElementById("id").value = id;
	}

	function openCity(evt, cityName) {
		// Declare all variables

		var i, tabcontent, tablinks;

		// Get all elements with class="tabcontent" and hide them
		tabcontent = document.getElementsByClassName("tabcontent");
		for (i = 0; i < tabcontent.length; i++) {
			tabcontent[i].style.display = "none";
		}

		// Get all elements with class="tablinks" and remove the class "active"
		tablinks = document.getElementsByClassName("tablinks");
		for (i = 0; i < tablinks.length; i++) {
			tablinks[i].className = tablinks[i].className
					.replace(" active", "");
		}

		// Show the current tab, and add an "active" class to the button that opened the tab
		document.getElementById(cityName).style.display = "block";
		evt.currentTarget.className += " active";
		foo();
	}

var prevRow;

	function show_hide_row1(row,mentId,def) {
		$("#" + prevRow).toggle();
		$("#" + row).toggle();
		
		//window.location.hash = '#'+row;
		document.getElementById(def).click();
		prevRow=row;
		
		for(var i=1;i<=13;i++)  //length of inputs
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
			if(childrenOfTheTbody[i].className=="stam1")
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
		
		for(var i=1;i<=13;i++)  //length of inputs
			{
			showStuff("input"+i+mentId,"div"+i+mentId);
			}
		backUpInputs(mentId);
		
	}
	function backUpInputs(mentId){
		
		for(var i=1;i<=13;i++)  //length of inputs
		{
			document.getElementById("input"+i+mentId).value =document.getElementById("div"+i+mentId).innerHTML;
		}
		
		
	}
	
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

        var csvFile = '';
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
function menteeTableToArray(param)
{
	var matrix=[['id','name','phone','academy','Gender']];
	var tbody=document.getElementsByTagName("tbody")[0];
	console.log(tbody.getElementsByClassName("stam1")[0].getElementsByTagName("td")[4].innerHTML);
	var rows=tbody.getElementsByClassName("stam1");
	for (var i = 0; i < rows.length; i++) {
		var row=[];
		var columns=rows[i].getElementsByTagName("td");
		for (var j = 0; j < columns.length; j++) {
			row.push(columns[j].innerHTML);
		}
		matrix.push(row);
	}
	console.log(matrix);
	var thead=document.getElementsByTagName("thead")[0];
	console.log(thead.getElementsByTagName("tr")[0]);
	
	exportToCsv('Mentees.csv',matrix);
}
	function showStuff(hide, show) {
		
	     document.getElementById(show).style.display  = 'block';
	    document.getElementById(hide).style.display  = 'none';
	    
	}
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
	
	