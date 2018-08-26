<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
     
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
        rel="stylesheet">
          
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Courseware Managemenent System</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="/welcome">Calendar</a></li>
      <!-- <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Page 1-1</a></li>
          <li><a href="#">Page 1-2</a></li>
          <li><a href="#">Page 1-3</a></li>
        </ul>
      </li> -->
      <li><a href="#" onclick="loadCourses()">View Courses</a></li>
       <li><a href="#" onClick="loadTutors()">View Tutors</a></li>
              <li><a href="#" onClick="loadTutorsWithCourses()">View Tutors-Courses</a></li>
       
       
      
    </ul>
    <ul class="nav navbar-nav navbar-right">
<!--       <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
 -->      <li><a class="" href="/"><span class="glyphicon glyphicon-log-in btn btn-danger "></span> Logout</a></li>
    </ul>
  </div>
</nav>
Training Calendar for Year 2018
<table class="table">
    <thead id="tHead">
      <tr>
        <th>Tutor</th>
        <th>Course</th>
        <th>Date from -Date To </th>
      </tr>
    </thead>
    <tbody id="tBody">
      
    </tbody>
  </table>
  <script type="text/javascript">
  
  function loadCalendar(year){
		console.log("executing function")
		$.ajax({
			type:"GET",
			contentType:"application/json",
			url: "/calendar/"+year,
			dataType:"json",
			success: function(result){

				var tBody="";
				
				$.each(result.data, function (i) {
					var tr="";
					tr='<tr>'+'<td>'+result.data[i].tutorName+'</td>'+'<td>'+result.data[i].courseName+'</td>'+'<td>'+result.data[i].period+'</td>'+'<tr>';
				    console.log("first data"+i);
				    tBody+=tBody+tr;
				});
				$('#tBody').append(tBody);
	}	
			
		
		});
	}

	loadCalendar("it");
	
	
	 function loadCourses(){
			console.log("executing function")
			$.ajax({
				type:"GET",
				contentType:"application/json",
				url: "/courses/",
				dataType:"json",
				success: function(result){

					var tHead='<tr>     <th>Course</th><th>Code</th><th>Topics </th>  </tr>';
					var tBody="";
					
					$.each(result.data, function (i) {
						var tr="";
						tr='<tr>'+'<td>'+result.data[i].courseName+'</td>'+'<td>'+result.data[i].courseCode+'</td>'+'<td><ul>';
						var li="";
						$.each(result.data[i].topics, function (j) {
							li='<li>'+result.data[i].topics[j].topicName+'</li>';
						});
						tr=tr+li+'</ul></td>'+'<tr>';
					    console.log("first data"+i);
					    tBody+=tBody+tr;
					});
					$('#tHead').html(tHead);

					$('#tBody').html(tBody);
		}	
				
			
			});
		}

	 function loadTutors(){
			console.log("executing function")
			$.ajax({
				type:"GET",
				contentType:"application/json",
				url: "/tutors/",
				dataType:"json",
				success: function(result){
	
					var tHead='<tr>     <th>Tutor Id</th><th>Tutor Name</th><th>Tutor UserName </th>  </tr>';
					var tBody="";
					
					$.each(result.data, function (i) {
						var tr="";
						tr='<tr>'+'<td>'+result.data[i].id+'</td>'+'<td>'+result.data[i].name+'</td>'+'<td>'+result.data[i].userName+'</td>'+'<tr>';
					    console.log("first data"+i);
					    tBody+=tBody+tr;
					});
					$('#tHead').html(tHead);

					$('#tBody').html(tBody);
		}	
				
			
			});
		}

	/*  function assingnCourseToTutors(courseId,tutorId,period){
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

   */
	function loadTutorsWithCourses(){
		
		var courses;
		$.ajax({
			type:"GET",
			contentType:"application/json",
			url: "/courses/",
			dataType:"json",
			success: function(result){

				courses=result.data;
	}	
			
		
		});
		
		setTimeout(function(){
			
			$.ajax({
				type:"GET",
				contentType:"application/json",
				url: "/tutors/",
				dataType:"json",
				success: function(result){

					var tHead='<tr>     <th>Tutor Id</th><th>Tutor Name</th><th>Tutor UserName </th><th>Courses</th>  </tr>';
					var tBody="";
					console.log("courses ------>");
					console.log("courses ------>"+courses.length)
					$.each(result.data, function (i) {
						
						console.log("inside courses ------>"+result.data.length);

						var tr="";
						tr='<tr>'+'<td>'+result.data[i].id+'</td>'+'<td>'+result.data[i].name+'</td>'+'<td>'+result.data[i].userName+'</td>'+'<td><ul>';
						var li="";
						$.each(courses, function (j) {
							li+='<li><input type="checkbox" class="courseList" value="'+result.data[i].id+"-"+courses[j].id+'"> '+courses[j].courseName+'</li>';
							console.log("inside inner loop");
						});
						
					    console.log("first data"+i);
					    tBody+=tBody+tr+li+'</ul></td>'+'<tr>';;
						
						
						
						/* var tr="";
						tr='<tr>'+'<td>'+result.data[i].id+'</td>'+'<td>'+result.data[i].name+'</td>'+'<td>'+result.data[i].userName+'</td>'+'<tr>';
					    console.log("first data"+i);
					    tBody+=tBody+tr;
					     */
					    
					});
					$('#tHead').html(tHead);

					$('#tBody').html(tBody);
		}	
				
			
			});
		
			}, 1000);
		

	
	}
  </script>
</body>
</html>