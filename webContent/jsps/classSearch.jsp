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
	</head>
	<body>
		<form method="post" action="/uni/class/search">
			<dl>
				<dt>
					<span>Term:</span>
					<select name="termId">
						<option >None</option>											
						<% for(TermDTO term:terms) { %>
							<option value="<%=term.getTermId() %>" <% if(selectedTermId==term.getTermId()) out.print("selected"); %> >
								<%=term.getName() %>
							</option>
						<% } %>						
					</select>
				</dt>
				<dt>
					<span>Faculty:</span>
					<select name="facultyId">
						<option >None</option>						
						<% for(FacultyDTO faculty:faculties) { %>
							<option value="<%=faculty.getFacultyId() %>" <% if(selectedFacultyId==faculty.getFacultyId()) out.print("selected"); %>>
								<%=faculty.getName() %>
							</option>
						<% } %>						
					</select>
				</dt>
				<dt>
					<span>Subject:</span>
					<select name="subjectId">
						<option >None</option>						
						<% for(SubjectDTO subject:subjects) { %>
							<option value="<%= subject.getSubjectId() %>" <% if(selectedSubjectId==subject.getSubjectId()) out.print("selected"); %>>
								<%=subject.getTitle() %>
							</option>
						<% } %>						
					</select>
				</dt>
				<dt>
					<input type="submit" value="Search" />
					<input type="reset" value="Reset" />
				</dt>
			</dl>
		</form>
		
		<% if(classes!=null) { %>
			<form method="post" action="">
			<table border="1">
				<tr>
					<th><input type="checkbox"></th>
					<th><p>Subject Code</p></th>
					<th><p>Subject Title</p></th>
					<th><p>Credits</p></th>
					<th><p>Total Seats</p></th>									
				</tr>
				<% for(ClassDTO clazz:classes) { %>		
					<tr>
						<td><input type="checkbox" name="selectedClass" value="<%=clazz.getClassId() %>"/></td>
						<td><%= clazz.getSubject().getSubjectCode() %></td>
						<td><%= clazz.getSubject().getTitle() %></td>
						<td><%= clazz.getCredits() %></td>
						<td><%= clazz.getSeatNumber() %></td>
					</tr>
				<% } %>
					<tr>
						<td colspan="5"><input type="submit" value="Submit" /></td>						
					</tr>
			</table>		
			</form>
		<% } %>
	</body>
</html>