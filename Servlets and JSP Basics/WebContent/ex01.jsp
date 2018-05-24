<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello, JSP!</title>
</head>
<body>
	<h1>Hello, JSP!</h1>
	<%
	int num = 99;
	for(int i=1; i<=10; i++){
		out.print(num);
		out.print(" X ");
		out.print(i);
		out.print(" = ");
		out.print(num*i);
		out.print("<br />");
	}
	%>
</body>
</html>