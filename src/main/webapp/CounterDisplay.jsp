<%@page import="com.test.token.system.model.CounterQueueDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="header.jsp" />
<jsp:include page="footer.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Counter Display</title>
</head>
<body>

<div class="container">
<center><h3>List of Tokens in Queue for <%=request.getAttribute("counterName") %></h3></center>

<table class="table table-bordered">
<thead>
	<tr>
		<th>Id</th>
		<th>Token</th>
		<th>Status</th>
		<th>Customer Type</th>
		<th>Change Status</th>
		
	</tr>
	
</thead>
	<%
	
		ArrayList<CounterQueueDto> list=(ArrayList<CounterQueueDto>)request.getAttribute("list");
		
		for(CounterQueueDto queueDto: list){
			%>
			
			<tbody>
				<tr>
					<td><%=queueDto.getId() %></td>
					<td><%=queueDto.getToken() %></td>
					<td><%= queueDto.getStatus()%></td>
					<td><%= queueDto.getCustomerType()%></td>
					<td><a href="<%=request.getContextPath()%>/editTokenStatus?id=<%= queueDto.getId()%>&
					counterName=<%= request.getAttribute("counterName")%>">Completed</a></td>
				</tr>
			
			</tbody>
			<%	
		}
	
	%>

</table>
</div>

</body>
</html>