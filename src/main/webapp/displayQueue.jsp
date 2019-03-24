<%@page import="java.util.ArrayList"%>
<%@page import="com.test.token.system.model.CounterTokenListDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="header.jsp" />
<jsp:include page="footer.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<div class="container">
			<h2>Please find Counter Queue Below</h2>
			<br>
			<table class="table table-bordered">
				<tbody>

					<%
						ArrayList<CounterTokenListDto> list = (ArrayList<CounterTokenListDto>) request.getAttribute("list");

						for (CounterTokenListDto queueDto : list) {
					%>
					<th style="text-align: center;">
					<p style="color: blue;"><%=queueDto.getCounterName()%></p>
						<hr>
						<%
							ArrayList<String> arrayList = (ArrayList<String>) queueDto.getTokenList();

								for (String token : arrayList) {
						%>
						<p style="color: green"><%=token%></p>
						<%
							}
						%></th>
					<%
						}
					%>
					</tr>
				</tbody>
			</table>
		</div>
	</center>
</body>
</html>