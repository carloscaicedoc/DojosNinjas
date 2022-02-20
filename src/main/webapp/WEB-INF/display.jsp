<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Display Ninjas</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body class="bg-light">
	<div class="col-6 mx-auto my-5">
		<div class="justify-content-center text-dark">
		    <h1 class="ms-1 ps-1">${dojo.location} Location Ninjas</h1>
		</div>
        <table class="table table-hover bg-light" class="table_box">
            <thead>
            <tr class="bg-secondary text-dark">
                <th>First Name</th>
                <th>Last Name</th>
                <th>Age</th>
            </tr>            
            </thead>
            <tbody>
            	<c:forEach var="ninja" items="${dojo.ninjas}">
            		<tr class="names">
                		<td>${ninja.firstName}</td>
                		<td>${ninja.lastName}</td>
                		<td>${ninja.age}</td>                		
            		</tr>          
            	</c:forEach>
            </tbody>                   
        </table>
    </div>



</body>
</html>