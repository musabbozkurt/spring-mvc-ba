<%--
  Created by IntelliJ IDEA.
  User: DWARF
  Date: 7/26/2020
  Time: 2:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Person List</title>
</head>
<body>

<form action="<c:url value="/persons"/>">
    <table>
        <tr>
            <th width="80">Person ID</th>
            <th width="120">Person Name</th>
            <th width="120">Person Country</th>
            <th width="60">delete</th>
        </tr>
        <c:forEach items="${personList}" var="person">
            <tr>
                <td>${person.id}</td>
                <td>${person.name}</td>
                <td>${person.country}</td>
                <td> <a href="<c:url value='/deletePerson/${person.id}'/>">delete</a></td>
            </tr>
        </c:forEach>

    </table>
</form>

<form action="addPerson" method="post">
    <input type="text" name="id">
    <input type="text" name="name">
    <input type="text" name="country">
    <input type="submit" value="add or update person">
</form>


</body>
</html>
