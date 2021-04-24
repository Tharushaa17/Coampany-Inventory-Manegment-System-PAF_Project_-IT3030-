<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Buyers Manegment</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
    <center>
        <h1>Byers Registration</h1>
        <h2>
            
            &nbsp;&nbsp;&nbsp;
            
            <a href="./ShowBuyer.jsp" class="w3-button w3-white w3-border w3-border-red w3-hover-blue w3-round">All List Buyers</a>
             
        </h2>
    </center>
    <div align="center">
        <c:if test="${buyer != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${buyer == null}">
            <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${buyer != null}">
                        Edit Buyer
                    </c:if>
                    <c:if test="${buyer == null}">
                        Fill the fallowing details to add a new buyer
                    </c:if>
                </h2>
            </caption>
                <c:if test="${buyer != null}">
                    <input type="hidden" name="id" value="<c:out value='${buyer.id}' />" />
                </c:if>           
            <tr>
                <th>Frist Name: </th>
                <td>
                    <input type="text" name="FristName" size="50"
                            value="<c:out value='${buyer.FristName}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Last Name: </th>
                <td>
                    <input type="text" name="LastName" size="50"
                            value="<c:out value='${buyer.LastName}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Username: </th>
                <td>
                    <input type="text" name="Username" size="50"
                            value="<c:out value='${buyer.Username}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Mobile Nu: </th>
                <td>
                    <input type="text" name="MobileNu" size="50"
                            value="<c:out value='${buyer.MobileNu}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Email: </th>
                <td>
                    <input type="text" name="Email" size="50"
                            value="<c:out value='${buyer.Email}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Address: </th>
                <td>
                    <input type="text" name="Address" size="50"
                            value="<c:out value='${buyer.Address}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Password: </th>
                <td>
                    <input type="password" name="Password" size="50"
                            value="<c:out value='${buyer.Password}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" class="button" value="Save" />
                </td>
            </tr>
        </table>
        </form>
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