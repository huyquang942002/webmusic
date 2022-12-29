<%-- 
    Document   : edit-song
    Created on : Dec 26, 2022, 9:43:08 PM
    Author     : haodeptrai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
	<title>Update Song</title>

	<link type="text/css" rel="stylesheet" href="stylesAdmin.css">
	<link type="text/css" rel="stylesheet" href="addsong.css">
	<style>

	    @import url("https://fonts.googleapis.com/css2?family=Poppins:wght@400;500&display=swap");

	    * {
		margin: 0;
		padding: 0;
		box-sizing: border-box;
		font-family: "Poppins", sans-serif;
	    }

	    :root {
		--main-blue: #71b7e6;
		--main-purple: #009688;
		--main-grey: #ccc;
		--sub-grey: #d9d9d9;
	    }

	    body {
		display: flex;
		height: 100vh;
		justify-content: center; /*center vertically */
		align-items: center; /* center horizontally */
		background: linear-gradient(135deg, var(--main-blue), var(--main-purple));
		padding: 10px;
	    }
	    /* container and form */
	    .container {
		max-width: 600px;
		width: 100%;
		background: #fff;
		padding: 25px 30px;
		border-radius: 25px;
	    }
	    .container .title {
		font-size: 25px;
		font-weight: 500;
		position: relative;
	    }

	    .container .title::before {
		content: "";
		position: absolute;
		height: 3.5px;
		width: 30px;
		background: linear-gradient(135deg, var(--main-blue), var(--main-purple));
		left: 0;
		bottom: 0;
	    }

	    .container form .user__details {
		display: flex;
		flex-wrap: wrap;
		justify-content: space-between;
		margin: 20px 0 12px 0;
	    }
	    /* inside the form user details */
	    form .user__details .input__box {
		width: calc(100% / 2 - 20px);
		margin-bottom: 15px;
	    }

	    .user__details .input__box .details {
		font-weight: 500;
		margin-bottom: 5px;
		display: block;
	    }
	    .user__details .input__box input {
		height: 45px;
		width: 100%;
		outline: none;
		border-radius: 15px;
		border: 1px solid var(--main-grey);
		padding-left: 15px;
		font-size: 16px;
		border-bottom-width: 2px;
		transition: all 0.3s ease;
	    }

	    .user__details .input__box input:focus,
	    .user__details .input__box input:valid {
		border-color: var(--main-purple);
	    }

	    /* inside the form gender details */

	    form .gender__details .gender__title {
		font-size: 20px;
		font-weight: 500;
	    }

	    form .gender__details .category {
		display: flex;
		width: 80%;
		margin: 15px 0;
		justify-content: space-between;
	    }

	    .gender__details .category label {
		display: flex;
		align-items: center;
	    }

	    .gender__details .category .dot {
		height: 18px;
		width: 18px;
		background: var(--sub-grey);
		border-radius: 50%;
		margin: 10px;
		border: 5px solid transparent;
		transition: all 0.3s ease;
	    }

	    #dot-1:checked ~ .category .one,
	    #dot-2:checked ~ .category .two,
	    #dot-3:checked ~ .category .three {
		border-color: var(--sub-grey);
		background: var(--main-purple);
	    }

	    form input[type="radio"] {
		display: none;
	    }

	    /* submit button */
	    form .button {
		height: 45px;
		margin: 45px 0;
	    }

	    form .button input {
		height: 100%;
		width: 100%;
		outline: none;
		color: #fff;
		border: none;
		font-size: 18px;
		font-weight: 500;
		border-radius: 25px;
		background: linear-gradient(135deg, var(--main-blue), var(--main-purple));
		transition: all 0.3s ease;
	    }

	    form .button input:hover {
		background: linear-gradient(-135deg, var(--main-blue), var(--main-purple));
	    }

	    @media only screen and (max-width: 584px) {
		.container {
		    max-width: 100%;
		}

		form .user__details .input__box {
		    margin-bottom: 15px;
		    width: 100%;
		}

		form .gender__details .category {
		    width: 100%;
		}

		.container form .user__details {
		    max-height: 300px;
		    overflow-y: scroll;
		}

		.user__details::-webkit-scrollbar {
		    width: 0;
		}
	    }

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
		width:72%;
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
		width: 72%;
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

	<div>

	    <div class="container">
		<div class="title">Edit song</div>
		<form action="admin" method ="GET">
		    <input type="hidden" name="command" value="UPDATE" />
		    <input type="hidden" name="musicId" value="${item.id}" />

		    <div class="user__details">
			<div class="input__box">
			    <span class="details">Name</span>
			    <input type="text" name="name" value="${item.name}"  required>
			</div>

			<div class="input__box">
			    <span class="details">Path</span>
			    <input type="text" name="path" value="${item.path}"  required>
			</div>

			<div class="input__box">
			    <span class="details">Image</span>
			    <input type="text" name="image" value="${item.image}"  required>
			</div>


			<div class="input__box">
			    <span class="details">Singer</span>
			    <input type="text" name="singer" value="${item.singer}" required>
			</div>

		    </div>

		    <div class="button">
			<input type="submit" value="Save">
		    </div>

		</form>
	    </div>
	    <div style="clear:both;"></div>
	    <p>
		<a href="admin">Back To List</a>
	    </p>
	</div>

    </body>

</html>











