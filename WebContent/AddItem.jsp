<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<br>
	<h2 align ="center">Input grocery details: </h2>
		<form name="form" action="AddItemServlet" method="post" onsubmit="return validate()">
			<table style="margin: 0 auto;">
 				<tr>
 					<td>Name</td>
 					<td><input type="text" name="name" /></td>
 				</tr>
 				<tr>
 					<td>Quantity</td>
 					<td><input type="text" name="quantity" /></td>
 				</tr>
 				<tr>
 					<td>Calories</td>
 					<td><input type="text" name="calorie_value" /></td>
 				</tr>
 				<tr>
 					<td>Purchase date</td>
 					<td><input type="text" name="purchase_date" /></td>
 				</tr>
 				<tr>
 					<td>Expiration date</td>
 					<td><input type="text" name="expiration_date" /></td>
 				</tr>
 				<tr>
 					<td>Consumption date</td>
 					<td><input type="text" name="consumption_date" /></td>
 				</tr>
 				
 				<tr>
 					<td><%=(request.getAttribute("errMessage") == null) ? ""
 					: request.getAttribute("errMessage")%></td>
 				</tr>
 				<tr>
 					<td></td>
 					<td><input type="submit" value="Add"></input><input
 					type="reset" value="Reset"></input></td>
 				</tr>
			</table>
		</form>
</body>
</html>