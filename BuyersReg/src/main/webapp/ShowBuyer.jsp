<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Buyer Manegement</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
    <center>
        <h1>Buyers List</h1>
        <h2>
            <a href="./index.jsp" class="w3-button w3-white w3-border w3-border-red w3-hover-blue w3-round">Add New Buyers</a>
            &nbsp;&nbsp;&nbsp;
            
             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of All Registed Buyers</h2></caption>
            <tr>
                <th>ID</th>
                <th>Frist Name</th>
                <th>Last Name</th>
                <th>Username</th>
                <th>Email</th>
                <th>Mobile Nu</th>
                <th>Address</th>
                <th>Password</th>
            </tr>
            <c:forEach var="buyer" items="${listBuyer}">
                <tr>
                    <td><c:out value="${buyer.id}" /></td>
                    <td><c:out value="${buyer.FristName}" /></td>
                    <td><c:out value="${buyer.LastName}" /></td>
                    <td><c:out value="${buyer.Username}" /></td>
                    <td><c:out value="${buyer.Email}" /></td>
                    <td><c:out value="${buyer.MobileNu}" /></td>
                    <td><c:out value="${buyer.Address}" /></td>
                    <td><c:out value="${buyer.Password}" /></td>
                    <td>

                        <a href="/showEditForm?id=<c:out value='${buyer.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/deleteBuyer?id=<c:out value='${buyer.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
    
    <style>
    	h1{
    		font-family: sans-serif;
    		font-weight: bold;
    		font-size: xx-large;
    	}
    	h2{
    		font-size: medium;
    	}
    	.button {
		  background-color:#1aa3ff; /* blue */
		  border: none;
		  color: white;
		  padding: 15px 32px;
		  text-align: center;
		  text-decoration: none;
		  display: inline-block;
		  font-size: 16px;
		}
    	a{
    		text-decoration: none;
    		font-family: sans-serif;
    	}
    </style> 
</body>
</html>