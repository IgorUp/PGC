<%--
  Created by IntelliJ IDEA.
  User: igor
  Date: 7.12.16
  Time: 17.03
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<style>
    html,body,h1,h2,h3,h4 {font-family:"Lato", sans-serif}
    .mySlides {display:none}
    .w3-tag, .fa {cursor:pointer}
    .w3-tag {height:15px;width:15px;padding:0;margin-top:6px}
</style>
<body ng-app="myApp" class="ng-cloak">

<!-- Links (sit on top) -->
<div class="w3-top">
    <div class="w3-row w3-large">
        <div class="w3-col s3">
            <a href="#" class="w3-btn-block w3-light-grey">Home</a>
        </div>
        <div class="w3-col s3">
            <a href="#roles" class="w3-btn-block w3-light-grey">Plans</a>
        </div>
        <div class="w3-col s3">
            <a href="#clients" class="w3-btn-block w3-light-grey">About</a>
        </div>
        <div class="w3-col s3">
            <a href="#contact" class="w3-btn-block w3-light-grey">Contact</a>
        </div>
    </div>
</div>

<div class="w3-content" style="max-width:1100px;margin-top:80px;margin-bottom:80px" ><%--ng-controller="RoleController as ctrl">--%>

    <div ng-view>

    </div>

</div>


<!-- Footer -->

<footer class="w3-container w3-padding-32 w3-light-grey w3-center">
    <h4>Footer</h4>
    <a href="#" class="w3-btn w3-padding w3-black w3-margin"><i class="fa fa-arrow-up w3-margin-right"></i>To the top</a>
    <div class="w3-xlarge w3-section">
        <i class="fa fa-facebook-official w3-hover-text-indigo"></i>
        <i class="fa fa-instagram w3-hover-text-purple"></i>
        <i class="fa fa-snapchat w3-hover-text-yellow"></i>
        <i class="fa fa-pinterest-p w3-hover-text-red"></i>
        <i class="fa fa-twitter w3-hover-text-light-blue"></i>
        <i class="fa fa-linkedin w3-hover-text-indigo"></i>
    </div>
    <p>Powered by <a href="http://www.w3schools.com/w3css/default.asp" title="W3.CSS" target="_blank" class="w3-hover-text-green">w3.css</a></p>
</footer>


<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
<script type="text/javascript" src="https://code.angularjs.org/1.4.7/angular-route.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-messages.min.js"></script>

<!-- Angular Material Library -->
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/angular_material/1.1.0/angular-material.min.js"></script>
<script src="<c:url value='/js/app.js' />"></script>

<!-- Controllers -->
<script src="<c:url value='/js/controller/pgc.controllers.js' />"></script>
<script src="<c:url value='/js/controller/client_controller.js' />"></script>
<script src="<c:url value='/js/controller/role_controller.js' />"></script>
<script src="<c:url value='/js/controller/product_controller.js' />"></script>
<script src="<c:url value='/js/controller/typeStock_controller.js' />"></script>
<script src="<c:url value='/js/controller/stock_controller.js' />"></script>
<%--<script src="<c:url value='/js/route.js' />"></script>--%>

<!-- Services -->
<script src="<c:url value='/js/service/pgc.services.js' />"></script>
<script src="<c:url value='/js/service/client_service.js' />"></script>
<script src="<c:url value='/js/service/role_service.js' />"></script>
<script src="<c:url value='/js/service/product_service.js' />"></script>
<script src="<c:url value='/js/service/typeStock_service.js' />"></script>
<script src="<c:url value='/js/service/stock_service.js' />"></script>

</body>
</html>
