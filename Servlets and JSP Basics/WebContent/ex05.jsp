<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Session Management Example</title>
</head>
<body>
	<h1>Session Management Example</h1>
	<hr />
	<form action="add-name" method="POST">
		<input type="text" placeholder="Enter a name" name="name" id="name">
		<button>Submit</button>
	</form>
	<script>document.getElementById("name").focus();</script>
	
	<div>
	<jsp:include page="./view-names.jsp" />
	</div>
</body>
</html>








