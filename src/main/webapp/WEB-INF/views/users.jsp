<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page session="false" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>
    Hello world!
</h1>

<P>  User Count is  ${count}</P>

<table border="1">
    <thead>
    <tr>
        <th>#</th>
        <th>User Name</th>
        <th>User Id </th>
        <th>FirstName</th>
        <th>Last Name</th>
    </tr>
    </thead>
    <tbody>
    <c:set var="i" value="1" />
    <c:forEach items="${allUsers}" var="user">
        <tr>
            <td>${i}</td>
            <td>${user.userName}</td>
            <td>${user.id}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
        </tr>
        <c:set var="i" value="${i+1}" />
    </c:forEach>
    </tbody>
</table>

<br><P><a href="users/newUser">Add New User </a>



</body>
</html>