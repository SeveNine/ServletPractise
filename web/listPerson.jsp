<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%-- 引入jquery，顺序不能乱 --%>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"  rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>

<h1>JSP实现</h1>
<table class="table table-bordered">
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
            <td><a class="btn btn-default" href='editPerson?id=${person.id}'>edit</a></td>
            <td><a class="btn btn-default" href='deletePerson?id=${person.id}'>delete</a>
        </tr>

    </c:forEach>
    <tr>
        <td colspan="9" align="center">
            <a class="btn btn-primary" href="?start=0">首页</a>
            <a class="btn btn-primary" href="?start=${pre}">上一页</a>
            <a class="btn btn-primary" href="?start=${next}">下一页</a>
            <a class="btn btn-primary" href="?start=${last}">末页</a>
        </td>
    </tr>
</table>
<a class="btn btn-success" href="add/addPerson.html">新增</a>
