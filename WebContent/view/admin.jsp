<%-- 
    Document   : admin
    Created on : Dec 26, 2022, 8:25:44 PM
    Author     : haodeptrai
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
	<title>List Song</title>
	<style>
	    html, body{
		margin-left:15px;
		margin-right:15px;
		padding:0px;
		font-family:Verdana, Arial, Helvetica, sans-serif;
	    }
	    table {
		border-collapse:collapse;
		border-bottom:1px solid gray;
		font-family: Tahoma,Verdana,Segoe,sans-serif;
		width:100%;
	    }

	    th {
		border-bottom:1px solid gray;
		background:none repeat scroll 0 0 #0775d3;
		padding:10px;
		color: #FFFFFF;
	    }

	    tr {
		border-top:1px solid gray;
		text-align:center;
	    }

	    tr:nth-child(even) {
		background: #FFFFFF
	    }
	    tr:nth-child(odd) {
		background: #BBBBBB
	    }

	    #wrapper {
		width: 100%;
		margin-top: 0px;
	    }
	    #header {
		width: 100%;
		background: #0775d3;
		margin-top: 0px;
		padding:15px 0px 15px 0px;
	    }
	    #header h2 {
		width: 100%;
		margin:auto;
		color: #FFFFFF;
	    }
	    #container {
		width: 100%;
		margin:auto
	    }
	    #container h3 {
		color: #000;
	    }
	    #container #content {
		margin-top: 20px;
	    }

	    .add-student-button {
		border: 1px solid #666;
		border-radius: 5px;
		padding: 4px;
		font-size: 12px;
		font-weight: bold;
		width: 120px;
		padding: 5px 10px;

		margin-bottom: 15px;
		background: #cccccc;
	    }
	</style>
    </head>

    <body>

	<div id="wrapper">
	    <div id="header">
		<h2>List Song</h2>
	    </div>
	</div>

	<div id="container">

	    <div id="content">

		<input type="button" value="Add Song"
		       onclick="window.location.href = 'view/add-song.jsp';return false;"
		       class="add-student-button"
		       />

		<table>

		    <tr>
			<th>ID</th>
			<th>Name Song</th>
			<th>Audio</th>
			<th>Image</th>
			<th>Singer</th>
			<th>Action</th>
		    </tr>

		    <c:forEach var="item" items="${listMusic}">

			<c:url var="tempLink" value="admin">
			    <c:param name="command" value="LOAD"/>
			    <c:param name="musicID" value="${item.id}"/>
			</c:url>

			<c:url var="deleteLink" value="admin">
			    <c:param name="command" value="DELETE"/>
			    <c:param name="musicID" value="${item.id}"/>
			</c:url>

			<tr>
			    <td>  ${item.id}  </td>	
			    <td>  ${item.name}  </td>
			    <td> <audio controls style="height: 50px; width: 150px;">
				    <source src="${item.path}" type="audio/mpeg">
				    Your browser does not support the audio tag.
				</audio>   </td>	
			    <td> <img src="${item.image}" alt="alt" style="height: 100px; width: 200px;"/>   </td>
			    <td>  ${item.singer}  </td>

			    <td> 
				<a href="${tempLink}">Update</a>
				|
				<a href="${deleteLink}"
				   onclick="if (!(confirm('are you sure you want to delete this music?')))
					       return false"
				   >Delete</a>

			    </td>
			</tr>

		    </c:forEach>


		</table>

	    </div>

	</div>
	<div>
	    <div style="clear:both;"></div>
	    <p>
		<a href="Logout">Back To Home</a>
	    </p>
	</div>
    </body>


</html>
