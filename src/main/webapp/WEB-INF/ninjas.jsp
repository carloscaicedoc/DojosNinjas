<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ninja New</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<style>

    .wrapper {
        background-color: rgb(246, 243, 247);
    }

    .custom-column {
        background-color: rgb(218, 218, 228);
        border-radius: 6px;
    }
  
</style>
<body class="wrapper">
    <div class="container">
        <div class="row justify-content-start">
            <div class="col-4 mx-5 offset-1 mt-3">
                <h1 class="mt-3 mb-4">New Ninja</h1>
                <form:form action="/ninjas/new" method="post" modelAttribute="ninja">
                
                <div>
                    <form:label path="firstName" class="mb-2 ms-1">First Name:</form:label>
                    <form:input type="text" path="firstName" class="form-control"/>
                    <form:errors path="firstName"/>
                </div>
                <div>
                    <form:label path="lastName" class="mb-2 ms-1">Last Name:</form:label>
                    <form:input type="text" path="lastName" class="form-control"/>
                    <form:errors path="lastName"/>
                </div>
                <div>
                    <form:label path="age" class="mb-2 ms-1">Age:</form:label>
                    <form:input type="text" path="age" class="form-control"/>
                    <form:errors path="age"/>
                </div>
                <div>
                	<p class="mt-2">Choose a Location</p>
                    <form:select path="dojo" class="mb-2 ms-1">
                    	<c:forEach var="dojo" items="${dojos}">
                            <form:option value="${dojo.id}" path="dojo" class="form-control">
                                     <c:out value="${dojo.location}"/>
                            </form:option>
                        </c:forEach>
                    </form:select>
                </div>
                <div class="justify-content-center">
                    <input type="submit" value="Submit" class="btn btn-outline-info btn-dark text-light mt-3 mb-4 px-5"/>
                </div>
                </form:form>
            </div>                
        </div>
	</div>

    
</body>
</html>