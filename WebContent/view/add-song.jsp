<%-- 
    Document   : add-song
    Created on : Dec 26, 2022, 9:02:44 PM
    Author     : haodeptrai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
	<title>Add song</title>
	<link type="text/css" rel="stylesheet" href="addsong.css">
	
    </head>
    <body>

	<div>

	    <div class="container">
		<div class="title">Add song</div>
		<form action="${pageContext.request.contextPath}/admin" method ="GET">
		    <input type="hidden" name="command" value="ADD">

		    <div class="user__details">
			<div class="input__box">
			    <span class="details">Name song</span>
			    <input type="text" name="name" placeholder="Name song" required>
			</div>

			<div class="input__box">
			    <span class="details">Path</span>
			    <input type="text" name="path" placeholder="Path song" required>
			</div>

			<div class="input__box">
			    <span class="details">Image</span>
			    <input type="text" name="image" placeholder="Image" required>
			</div>

			<div class="input__box">
			    <span class="details">Singer</span>
			    <input type="text" name="singer" placeholder="Singer" required>
			</div>

		    </div>

		    <div class="button">
			<input type="submit" value="Save">
		    </div>

		</form>
	    </div>
	    <div style="clear:both;"></div>
	    <p>
		<a href="${pageContext.request.contextPath}/admin">Back To List</a>
	    </p>
	</div>

    </body>
</html>