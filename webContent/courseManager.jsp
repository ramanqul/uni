<%@page import="java.util.*"%>
<%@page import="kz.edu.sdu.apps.uni.client.dto.CourseDTO"%>
<html>
<head>
<title>Course Manager</title>
</head>

<body>
	<form action="/uni/courses" method="post">
		<div>
			<span>Course Name:</span> <input type="text" name="courseName" />
		</div>
		<div>
			<input type="submit" value="Find">
		</div>
	</form>

	<table>
		<tr>
			<th>Course ID</th>
			<th>Course Name</th>
		</tr>
		<%
			List<CourseDTO> courses=(ArrayList<CourseDTO>)request.getAttribute("courses");
			if(courses!=null)	
				for(CourseDTO dto:courses) {
		%>
				<tr>
					<td><%=dto.getCourseId() %></td>
					<td><%=dto.getName() %></td>
				</tr>
			<%
				}
			%>

	</table>

</body>
</html>