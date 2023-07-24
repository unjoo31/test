<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <form action="/seller/writer" method="post" enctype="application/x-www-form-urlencoded">
        <div class="mb-3 mt-3">
            <input type="text" class="form-control" placeholder="Enter 판매자 이름" value="언주" name="name">
        </div>
        <div class="mb-3">
            <input type="text" class="form-control" placeholder="Enter 판매자 이메일" value="unjoo@nate.com" name="email">
        </div>
        <button type="submit" class="btn btn-primary">판매자등록</button>
    </form>
</div>

</body>
</html>