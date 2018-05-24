<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL and JSTL Demo</title>
</head>
<body>
	<h1>EL and JSTL Demo</h1>
	<hr />
	<p>\${ 10+20 } is ${ 10+20 }</p>
	<p>\${ 10 > 20 } is ${ 10 > 20 }
	<div>
	<form>
		<input type="text" name="username" placeholder="Enter your name">
		<button>Submit</button>
	</form>
	<h3>Hello, ${param["username"]==null ? "Friend!" : param.username}</h3>
	
	
	</div>
	
	
</body>
</html>