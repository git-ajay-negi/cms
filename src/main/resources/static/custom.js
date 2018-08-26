var modal = document.getElementById('id01');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

var HOST_NAME="localhost:8080";
function loadCalendar(year){
	console.log("executing function")
	$.ajax({
		type:"GET",
		contentType:"application/json",
		url: "/calendar/"+year,
		dataType:"json",
		success: function(result){
			$.each(result.data, function (i) {
			    console.log("first data"+i);
			});
}
	
	});
}

loadCalendar("it");

function assingnCourse(courseId,tutorId,period){
	console.log("executing function")
	$.ajax({
		type:"POST",
		contentType:"application/json",
		url: "/tutors/"+tutorId+"/course/"+courseId,
		dataType:"json",
		success: function(result){
			var tBody="";
			
			$.each(result.data, function (i) {
				var tr="";
				tr='<tr>'+'<td>'+result.data[i].tutorName+'</td>'+'<td>'+result.data[i].courseName+'</td>'+'<td>'+result.data[i].period+'</td>'+'<tr>';
			    console.log("first data"+i);
			    tBody+=tBody+tr;
			});
}	$('#tBody').append(tBody);
	
	});
}