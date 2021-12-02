<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Donar Registration Form</title>
 
<style>
 
    .error {
        color: #ff0000;
    }
</style>
 
</head>
 
<body>
 
    <h2>Registration Form</h2>
  
    <form:form method="POST" modelAttribute="donar">
        <table>
            <tr>
                <td><label for="donarid">Donar ID: </label> </td>
                <td><form:input path="donarid" id="donarid"/></td>
                <td><form:errors path="donarid" cssClass="error"/></td>
            </tr>
         
            <tr>
                <td><label for="name">Name: </label> </td>
                <td><form:input path="name" id="name"/></td>
                <td><form:errors path="name" cssClass="error"/></td>
            </tr>
     
            <tr>
                <td><label for="gender">Gender: </label> </td>
                <td><form:input path="gender" id="gender"/></td>
                <td><form:errors path="gender" cssClass="error"/></td>
            </tr>
     
            <tr>
                <td><label for="dob">DOB: </label> </td>
                <td><form:input path="dob" id="dob"/></td>
                <td><form:errors path="dob" cssClass="error"/></td>
            </tr>
            
            <tr>
                <td><label for="email">Email: </label> </td>
                <td><form:input path="email" id="email"/></td>
                <td><form:errors path="email" cssClass="error"/></td>
            </tr>
            
            <tr>
                <td><label for="bloodgroup">Blood Group: </label> </td>
                <td><form:input path="bloodgroup" id="bloodgroup"/></td>
                <td><form:errors path="bloodgroup" cssClass="error"/></td>
            </tr>
            
            <tr>
                <td><label for="lastdonatedon">Last Donated On: </label> </td>
                <td><form:input path="lastdonatedon" id="lastdonatedon"/></td>
                <td><form:errors path="lastdonatedon" cssClass="error"/></td>
            </tr>
            
            <tr>
                <td colspan="3">
                    <c:choose>
                        <c:when test="${edit}">
                            <input type="submit" value="Update"/>
                        </c:when>
                        <c:otherwise>
                            <input type="submit" value="Register"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </table>
    </form:form>
    <br/>
    <br/>
    Go back to <a href="<c:url value='/' />">Home</a>
</body>
</html>