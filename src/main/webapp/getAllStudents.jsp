<%@ page import="java.util.List" %>
<%@ page import="com.owaissalam.Hibernate.entities.Student" %>

<html>
<head>
    <title>Students</title>
</head>
<body>

<h2>Student List</h2>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
    </tr>

<%
    List<Student> students =
        (List<Student>) request.getAttribute("students");

    for (Student s : students) {
%>
    <tr>
        <td><%= s.getId() %></td>
        <td><%= s.getName() %></td>
        <td><%= s.getEmail() %></td>
    </tr>
<%
    }
%>

</table>

</body>
</html>
