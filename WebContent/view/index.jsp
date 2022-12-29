<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"
	      integrity="sha512-HK5fgLBL+xu6dm/Ii3z4xhlSUyZgTT9tuc/hSrtw6uzJOvgRr2a9jyxxT1ely+B+xFAmJKVSTbpM/CuL7qxO8w=="
	      crossorigin="anonymous" />
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="style.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
	      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<!-- font awesome cdn link  -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

	<!-- custom css file link  -->
	<link rel="stylesheet" href="css/style.css">

	<!-- custom js file link  -->
	<script src="jss/script.js" defer></script>
    </head>
    <body>

	<nav class="navbar navbar-expand-lg bg-body-tertiary">
	    <div class="container-fluid">
		<a class="navbar-brand" href="index.jsp">Home</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
		    <ul class="navbar-nav me-auto mb-2 mb-lg-0">

			<c:if test = "${sessionScope.user_session == null}">
			    <li class="nav-item">
				<a class="nav-link active" aria-current="page" href="view/login.jsp">Đăng Nhập</a>
			    </li>

			    <li class="nav-item">
				<a class="nav-link" href="Register">Đăng Ký</a>
			    </li>
			</c:if>
			<c:if test = "${sessionScope.user_session ne null}">
			    <li class="nav-item">
				<a class="nav-link active" aria-current="page" href="">${sessionScope.user_session.email}</a>
			    </li>
			</c:if>

			<li class="nav-item">
			    <a class="nav-link active" aria-current="page" href="Logout">Đăng Xuất</a>
			</li>





		    </ul>
		    <form class="d-flex" role="search" action="SearchController" METHOD="post">
			<input class="form-control me-2" id="searchInput" name="search" placeholder="Search" aria-label="Search">
			<button class="btn btn-outline-success" type="submit" onclick=" return SumbitJudge()"/>>Search</button>
		    </form>

		    <script type="text/javascript">
			function SumbitJudge() {
			    var input = document.getElementById("searchInput").value;
			    if (!input) {
				alert("Nhập nội dung tìm kiếm !");
				return false;
			    }
			    return true;
			}
		    </script>
		</div>
	    </div>
	</nav>


	<div class="container">

	    <h1 class="heading"> music playlist </h1>

	    <div class="box-container">

		<c:forEach var="item" items="${listMusic}">
		    <div class="box" data-src="${item.path}">
			<div class="image">
			    <div class="play">
				<i class="fas fa-play"></i>
			    </div>
			    <img src="${item.image}" alt="">
			</div>
			<div class="content">
			    <h3>${item.name}</h3>
			    <h4 style="color:red;"> ${item.singer}</h4>
			</div>
		    </div>
		</c:forEach>
	    </div>

	    <div class="music-player">
		<div id="close-player" class="fas fa-angle-up"></div>
		<h3 class="music-title">(play your song)</h3>
		<audio src="" controls></audio>
	    </div>





    </body>
</html>
