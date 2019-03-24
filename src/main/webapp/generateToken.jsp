<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="header.jsp" />
<jsp:include page="footer.jsp" />
<title>Generate Token</title>
</head>
<body>
	<marquee behavior="scroll" direction="left" style="color: green">Note: If you are
		new customer please enter 0 in Text box</marquee>
	<br>
	<br>
	<div class="container"
		style="padding-left: 20%; padding-right: 20%; padding-top: 5%">




		<form action="tokenGenerator" method="POST">

			<label for="uname">Enter Your Acc Number</label> <input
				class="form-control" type="text" name="accNum"
				placeholder="Enter Account Number" name="uname" required> <br>
			<center>
				<input type="Submit" value="Submit" class="btn btn-info">
				<center>
		</form>

	</div>


</body>
</html>