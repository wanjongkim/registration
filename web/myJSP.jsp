<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
</head>

<%@ page import="java.lang.reflect.*" %>
<jsp:useBean id="formBean" class="com.servlet.FormBean" scope="session" />

<body>
	<%@ taglib prefix="t" uri="/WEB-INF/tlds/example.tld" %>
	<h2>Custom Tag Bean Properties</h2>
	<table>
	<t:formBeanTag formBean="${formBean}">
		<tr><td>${name}</td><td>${value}</td></tr>
	</t:formBeanTag>
	</table>
        <h2>Session Object</h2>
        <table>
		<tr>
                    <td>Session Key</td>
                    <td>Session Value</td>
		</tr>
		<c:forEach var="a" items="${sessionScope}">
			<tr>
				<td> <c:out value="${a.key}"/> </td>
				<td> <c:out value="${a.value}"/> </td>
			</tr>
		</c:forEach>
	</table>
        <h2>Request Objects</h2>
	<table>
		<tr>
			<th>Request Key</th>
			<th>Request Value</th>
		</tr>
		<c:forEach var="c" items="${requestScope}">
			<tr>
				<td> <c:out value="${c.key}"/> </td>
				<td> <c:out value="${c.value}"/> </td>
			</tr>
		</c:forEach>
	</table>
        <h2>Request Parameters</h2>
	<table>
		<tr>
			<th>Request Parameter Key</th>
			<th>Request Parameter Value</th>
		</tr>
		<c:forEach var="p" items="${param}">
		<tr>
			<td><c:out value="${p.key}"/> </td>
			<td><c:out value="${p.value}"/> </td>
		</tr>
		</c:forEach>
	</table>
        <h2>Http Headers</h2>
	<table>
		<tr>
			<th>Header Name</th>
			<th>Header Value</th>
		</tr>
		<c:forEach var="h" items="${header}">
		<tr>
			<td><c:out value="${h.key}"/> </td>
			<td><c:out value="${h.value}"/> </td>
		</tr>
		</c:forEach>
	</table>
        <h2>Bean Property using reflection</h2>
        <table>
		<tr>
			<th>Name of Bean Property</th>
			<th>Value of Bean Property</th>
		</tr>
	</table>
	<%
		Class b = Class.forName("com.servlet.FormBean");
		Field[] fields = b.getDeclaredFields();
		for (Field f : fields) {
			String name = f.getName();
			out.println("<p>");
			String camelName = "get" +
			(name.substring(0,1).toUpperCase() + name.substring(1));
			Method m = b.getMethod(camelName);
			out.println("Bean instance variable - " + name + ":");
			out.println(m.invoke(formBean));
			out.println("</p>");
		}
	%>
        <h2>ServletContext Object</h2>
	<table>
		<tr>
			<td>ServletContext Key</td>
			<td>ServletContext Value</td>
		</tr>
		<c:forEach var="b" items="${application}">
			<tr>
				<td> <c:out value="${b.key}"/> </td>
				<td> <c:out value="${b.value}"/> </td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>