<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Mall</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">쇼핑몰</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="/">상품목록</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/write">상품등록</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/seller">판매자목록</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/seller/write">판매자등록</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="container mt-3">
    <table class="table">
        <thead>
        <tr>
            <th>판매자번호</th>
            <th>판매자이름</th>
            <th>판매자이메일</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="s" items="${sellerList}">
            <tr>
                <td>${s.id}</td>
                <td><a href="/seller/${s.id}">${s.name}</a></td>
                <td>${s.email}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>