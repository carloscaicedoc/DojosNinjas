<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dojo New</title>
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
            <div class="col-3 mx-5 offset-1 mt-5">
                <h1 class="text-center mt-3 mb-4">New Dojo</h1>
                <form:form action="/dojos" method="post" modelAttribute="dojo">
                <div>
                    <form:label path="location" class="mb-2 ms-1">Location:</form:label>
                    <form:input type="text" path="location" class="form-control"/>
                    <form:errors path="location" class="text-danger"/>
                </div>                              
                    <input type="submit" value="Create Dojo" class="btn btn-dark mt-3 mb-4 ms-1">
                </form:form>
                <a href="/ninjas/new" class="ninjabtn btn btn-light border border-secondary mt-4 ms-4 px-5" href="/dojos" role="button">New Ninja</a>
            </div>

        </div>
	</div>   
</body>
</html>