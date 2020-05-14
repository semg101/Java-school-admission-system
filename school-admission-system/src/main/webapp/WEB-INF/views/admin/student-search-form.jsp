<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="java.util.List"%>
<%@ page import="roseindia.tutorial.application.util.JdbcConnectioClass"%>

<html>
	<head>
		<title>School Addmission System</title>
		  <script src="http://code.jquery.com/jquery-latest.js"></script>
		  <script type="text/javascript" src="http://jzaefferer.github.com/jquery-validation/jquery.validate.js"></script>
	<style type="text/css">
		label.error { float: none; color: red; padding-left: .5em; vertical-align: top; }
		p { clear: both; }
		.submit { margin-left: 12em; }
		td { font-weight: bold; padding-right: 1em; vertical-align: top; }
	</style>
		<script>
			  $(document).ready(function(){
				$("#studentSearchForm").validate({
					rules: {
						phoneNumber:{
							minlength: 10,
							maxlength: 16,
							number:true
						}
					},
					messages: {
						phoneNumber:"<br>Please specify correct phone number"
					}
				
			  });
		});
	  </script>
	</head>
	<body>
		<%!			
			private JdbcConnectioClass jdbc = new JdbcConnectioClass();
		%>
	<br>
	<hr color="#FF3300">
		<a style="padding-left:200px;" href="load-home-page">Home</a>
	<hr color="#FFD699">
	<h2 align="center" bgcolor="#FFD699">Student Search Form</h2><hr color="#FFD699">
	<center>
		<form:form id="studentSearchForm" name="studentSearchForm" action="search" method="POST" commandName="studentSearchForm">
			<br>
			<table cellspacing="5" cellpadding="5" bgcolor="#F0FFC2">

				<tr>
					<td><b>Roll Number</b></td>
					<td><form:input path="rollNo" style="width: 300px;"/></td>
				</tr>

				<tr>
					<td><b>Name</b></td>
					<td><form:input path="name" style="width: 300px;"/></td>
				</tr>
				
				<tr>
					<td><b>Course</b></td>
					<td>
						<form:select path="course" style="width: 300px;">
							<form:option value="0" label="Please Select"/>
							<form:options items="${courseList}" itemLabel="name" itemValue="id"/>
						</form:select>
					</td>
				</tr>		
				
				<tr>
					<td><b>Phone Number</b></td>
					<td><form:input path="phoneNumber" style="width: 300px;"/></td>
				</tr>

				<tr>
					<td colspan="2" align="center"><input type="submit" value="Search Record"/></td>
				</tr>

			</table>
			</form:form>	
			<%
				if(request.getAttribute("studentList") != null){
					List sList = (List) request.getAttribute("studentList");
					if(sList.size() > 0){	
			%>
			<br>
			<hr color="#66FF33">
			<br>
				<table cellspacing="5" cellpadding="5" bgcolor="#F0FFC2" width="700">
				<tr bgcolor="#FFAD99">
					<td>Roll No</td>
					<td>Name</td>
					<td>Course</td>
					<td>Phone</td>
					<td>Address</td>
				<tr>
				
				<c:forEach var="student" items="${studentList}">
					<tr>
						<td><a style="text-decoration: none; color: black;" href="load-student-form?id=${student.rollNo}">${student.rollNo}</a></td>
						<td><a style="text-decoration: none; color: black;" href="load-student-form?id=${student.rollNo}">${student.name}</a></td>
						<td>
							<c:set scope="session" var="courseId" value="${student.course}" />
							<%
								int cId = (Integer)session.getAttribute("courseId");
							%>
							<a style="text-decoration: none; color: black;" href="../view-cources?id=${student.course}"><%= jdbc.getCourseTitle(cId)%></a>
						</td>
						<td>${student.phoneNo}</td>
						<td>${student.address}</td>
						<td bgcolor="#F0F0FF" align="center"><a style="text-decoration: none; color: black;" href="delete-student?id=${student.rollNo}">Delete</a></td>
					</tr>
				</c:forEach>			
				</table>
			<%
				}
			}
			%>
	</center>
<body>
</html>