<%@page import="java.util.Optional"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	float message1 = (float)request.getAttribute("message1");
	float message2 = (float)request.getAttribute("message2");
	float message3 = (float)request.getAttribute("message3");
	Optional<String> string = 
	Optional.ofNullable((String) request.getAttribute("string"));

%>

<body>
<H1>Sentiment</H1>
<H3>文章：<%= string.orElse("ERROR") %></H3>
<H3>結果：<br>positive:<%= message1 %><br>
						nertral:<%= message2 %><br>
						negative:<%= message3 %></H3>
</body>
</html>