<!DOCTYPE html>
<%@taglib uri="vinod-custom-tags" prefix="x" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Custom Tags Demo</title>
</head>
<body>
	<h1>Custom Tags Demo</h1>
	<hr />
	
	<p><x:today pattern="EEEE MMMM d, yyyy" /></p>
	<p><x:today pattern="d/M/yyyy" /></p>
	<p><x:today pattern="yyyy-MM-dd hh:mm:ss" /></p>
	<p><x:today /></p>

	<p><x:author-info /></p>
</body>
</html>