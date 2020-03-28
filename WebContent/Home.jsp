<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Grocery List</title>
</head>
<body>
    <sql:setDataSource
        var="myDS"
        driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/waste"
        user="root" password="root"
    />
    <sql:query var="list_groceries" dataSource="${myDS}">
    	SELECT * FROM food;
	</sql:query>
	
	<div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of groceries</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Quantity</th>
                <th>Calories</th>
                <th>Purchase date</th>
                <th>Expiration date</th>
                <th>Consumption date</th>
            </tr>
            
            <c:forEach var="item" items="${list_groceries.rows}">
                <tr>
                    <td><c:out value="${item.id}" /></td>
                    <td><c:out value="${item.name}" /></td>
                    <td><c:out value="${item.quantity}" /></td>
                    <td><c:out value="${item.calorie_value}" /></td>
                    <td><c:out value="${item.purchase_date}" /></td>
                    <td><c:out value="${item.expiration_date}" /></td>
                    <td><c:out value="${item.consumption_date}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>