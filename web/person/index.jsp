<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hadian
  Date: 3/11/2023
  Time: 1:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/person/save.do">
    <input type="text" placeholder="Enter Your Name" class="form-control" name="name"/>
    <br/>
    <input type="text" placeholder="Enter Your Family" class="form-control" name="family"/>
    <br/>
    <input type="submit" class="btn btn-primary" value="SAVE" style="width: 100%"/>
</form>
<table class="table table-striped table-hover table-responsive" style="width: 100%">
    <tr>
        <td>ID</td>
        <td>NAME</td>
        <td>FAMILY</td>
        <td>OPER</td>
        <td>OPER</td>
    </tr>
    <c:forEach items="${requestScope.list}" var="person">
        <form action="/person/update.do">
            <tr>
                <td><input type="text" class="form-control" name="id" value="${person.id}" readonly/></td>
                <td><input type="text" class="form-control" name="name" value="${person.name}"/></td>
                <td><input type="text" class="form-control" name="family" value="${person.family}"/></td>
                <td><input type="submit" class="btn btn-danger" value="UPDATE" style="width: 100%"/></td>
                <td><input type="button" class="btn btn-danger" value="REMOVE" style="width: 100%"
                           onclick="removePersonFunc(${person.id})"></td>
            </tr>
        </form>
    </c:forEach>
</table>
</body>
</html>
