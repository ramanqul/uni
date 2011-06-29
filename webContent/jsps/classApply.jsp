<%@page import="kz.edu.sdu.apps.uni.client.dto.ClassDTO"%>
<%
	ClassDTO foundClass = null;
	if (request.getAttribute("foundClass") != null)
		foundClass = (ClassDTO) request.getAttribute("foundClass");
%>
<html>
<head>
<title>Class Search</title>
<link href="http://localhost:8080/uni/static/css/base.css" type=text/css
	rel="stylesheet">
</head>
<body>
	<% if(request.getAttribute("error")!=null)  { %>
		<h2><%=request.getAttribute("error")%></h2>
	<% } %>
	<div class="row">
		<div class="title">Subject:</div>
		<div class="field">
			<%=foundClass.getSubject().getSubjectCode()+'-'+foundClass.getSubject().getTitle()%>
		</div>
	</div>
	<div class="row">
		<div class="title">Subject Description:</div>
		<div class="field">
			<%=foundClass.getSubject().getDescription()%>
		</div>
	</div>
	<div class="row">
		<div class="title">Term:</div>
		<div class="field">
			<%=foundClass.getTerm().getName()%>
		</div>
	</div>

	<div class="row">
		<div class="title">Total Seats:</div>
		<div class="field">
			<%=foundClass.getSeatNumber()%>
		</div>
	</div>
	<div class="row">
		<div class="title">Credits:</div>
		<div class="field">
			<%=foundClass.getCredits()%>
		</div>
	</div>

	<div class="row">
		<div class="title">Faculty:</div>
		<div class="field">
			<%=foundClass.getFaculty().getName()%>
		</div>
	</div>


	<div class="row">
		<div class="title">Comments:</div>
		<div class="field">
			<%=foundClass.getComments()%>
		</div>
	</div>
	<form method="post" action="/uni/class/apply">
		
		<input type="hidden" name="id" value="<%=foundClass.getClassId() %>">
		<div class="row">
			<input type="submit" value="Apply" /> 
			<input type="submit" value="Back" />
		</div>
	</form>

</body>
</html>