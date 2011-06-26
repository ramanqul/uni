<%@ page import="java.util.*" %>
<%@ page import="kz.edu.sdu.apps.uni.client.dto.SubjectDTO" %>
<%@ page import="kz.edu.sdu.apps.uni.client.dto.FacultyDTO" %>
<%@ page import="kz.edu.sdu.apps.uni.client.dto.TermDTO" %>
<%@ page import="kz.edu.sdu.apps.uni.client.dto.ClassDTO" %>

<%
	List<TermDTO> terms=(List<TermDTO>)request.getAttribute("terms");	
	List<SubjectDTO> subjects=(List<SubjectDTO>)request.getAttribute("subjects");
	List<FacultyDTO> faculties=(List<FacultyDTO>)request.getAttribute("faculties");
	List<ClassDTO> classes=null;
	
	if(request.getAttribute("classes")!=null)
		classes=(List<ClassDTO>)request.getAttribute("classes");
	
	long selectedTermId=0L;
	long selectedFacultyId=0L;
	long selectedSubjectId=0L;
	
	if(request.getAttribute("selectedTermId")!=null)
		selectedTermId=(Long)request.getAttribute("selectedTermId");

	if(request.getAttribute("selectedSubjectId")!=null)
		selectedSubjectId=(Long)request.getAttribute("selectedSubjectId");

	if(request.getAttribute("selectedFacultyId")!=null)
		selectedFacultyId=(Long)request.getAttribute("selectedFacultyId");		
%>
<html>
	<head>
		<title>Class Search</title>
		<link href="http://localhost:8080/uni/static/css/base.css" type=text/css rel="stylesheet">
	</head>
	<body>
		<form method="post" action="/uni/class/search">
			<div class="row">
				<div class="title">
					Term:
				</div>
				<div class="field">
					<select name="termId">
						<option value="null">None</option>											
						<% for(TermDTO term:terms) { %>
							<option value="<%=term.getTermId() %>" <% if(selectedTermId==term.getTermId()) out.print("selected"); %> >
								<%=term.getName() %>
							</option>
						<% } %>						
					</select>
				</div>
			</div>
			<div class="row">
				<div class="title">
					Faculty:				
				</div>
				<div class="field">
					<select name="facultyId">
						<option value="null">None</option>						
						<% for(FacultyDTO faculty:faculties) { %>
							<option value="<%=faculty.getFacultyId() %>" <% if(selectedFacultyId==faculty.getFacultyId()) out.print("selected"); %>>
								<%=faculty.getName() %>
							</option>
						<% } %>						
					</select>
				</div>
			</div>
			<div class="row">
				<div class="title">
					Subject:				
				</div>
				<div class="field">
					<select name="subjectId">
						<option value="null">None</option>						
						<% for(SubjectDTO subject:subjects) { %>
							<option value="<%= subject.getSubjectId() %>" <% if(selectedSubjectId==subject.getSubjectId()) out.print("selected"); %>>
								<%= subject.getSubjectCode()+'-'+subject.getTitle() %>
							</option>
						<% } %>						
					</select>
				</div>
			</div>
			<div class="row">
				<input type="submit" value="Search" />
			</div>
		</form>
		
		<% if(classes!=null) { %>
		<table border="1">
			<tr>
				<th width="70%">Subject</th>
				<th>Credits</th>
				<th>Total Seats</th>
				<th>Status</th>		
				<th>Action</th>											
			</tr>
			<% for(ClassDTO clazz:classes) { %>		
				<tr>
					<td>
						<%= clazz.getSubject().getSubjectCode()+'-'+clazz.getSubject().getTitle() %>
					</td>
					<td><%= clazz.getCredits() %></td>
					<td><%= clazz.getSeatNumber() %></td>
					<td><%= clazz.getClassStatus() %></td>
					<td>
						<a href="apply">Apply</a>
					</td>
				</tr>
			<% } %>
		</table>		
		<% } %>
	</body>
</html>