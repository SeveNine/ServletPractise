<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>JSP实现</h1>
<table align='center' border='1' cellspacing='0'>
    <tr>
        <td>id</td>
        <td>name</td>
        <td>age</td>
        <td>gender</td>
        <td>birthday</td>
        <td>mobile</td>
        <td>home</td>
        <td>edit</td>
        <td>delete</td>
    </tr>

    <c:forEach items="${persons}" var="person" varStatus="st">
        <tr>
            <td>${person.id}</td>
            <td>${person.name}</td>
            <td>${person.age}</td>
            <td>${person.gender eq 1 ? "男": "女"}</td>
            <td>${person.birthday}</td>
            <td>${person.mobile}</td>
            <td>${person.home}</td>
            <td><a href='editPerson?id=${person.id}'>edit</a></td>
            <td><a href='deletePerson?id=${person.id}'>delete</a>
        </tr>

    </c:forEach>
</table>
<a href="add/addPerson.html">新增</a>
