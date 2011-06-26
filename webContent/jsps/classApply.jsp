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
		
		
	</body>
</html>