<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Tokens</title>
<jsp:include page="header.jsp" />
<jsp:include page="footer.jsp" />
</head>
<body>
<center>
	<div class="container" style="width: 40%; margin: 10%">
		<form action="#">
			
				<h2>Please find Ticket Info Below</h2><br>
				<table class="table table-bordered">
					<tbody>
						<tr>
							<th>Counter Number</th>
							<th><%=request.getAttribute("counterNum")%></th>
						</tr>
					</tbody>

					<tbody>
						<tr>
							<th>Token Number</th>
							<th><%=request.getAttribute("token")%></th>
						</tr>
					</tbody>
				</table>
				<input type="Submit" name="PRINT" value="PRINT" class="btn btn-info">

			

		</form>
	</div>
	</center>
</body>
</html>