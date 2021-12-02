<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Blood Bank</title>
    <style>
        tr:first-child{
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>
</head>
<body>
    <form:form method="POST" modelAttribute="donar">
	    <label for="bg">Blood Group: </label>
	    <input type="text" name="bg"/>
	    <input type="submit" formaction="/mail" value="Send Mail"/>
	    <input type="submit" formaction="/list" value="Search"/>
    </form:form>
    <form:form method="POST" action="/display" modelAttribute="donar">
	    <label for="id">Donar ID: </label>
	    <input type="text" name="id"/>
	    <input type="submit" value="Check"/>
    </form:form>
    <table>
        <tr>
            <td>Donar ID</td><td>Name</td><td>Gender</td><td>Mail ID</td><td>Edit</td><td>Delete</td>
        </tr>
        <c:forEach items="${donars}" var="donar">
            <tr>
            <td>${donar.donarid}</td>
            <td>${donar.name}</td>
            <td>${donar.gender}</td>
            <td>${donar.email}</td>
            <td><a href="<c:url value='/edit-${donar.donarid}-donar' />">${donar.donarid}</a></td>
            <td><a href="<c:url value='/delete-${donar.donarid}-donar' />">delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <a href="<c:url value='/new' />">Add New Donar</a>
</body>
</html>