<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="entete.jsp"/>
<head>
        <title>Statuts</title>
</head>

<div class="container-fluid">
        
        <div class="row justify-content-center">
                <h1 class="display-4 text-center mt-5 text-uppercase">Liste des statuts</h1>
        </div>
        
        <div class="row justify-content-center m-auto pt-5">
                <div class="col-2 m-auto text-center ">
                        <ul class="list-group">
                                <%--TODO:Modification des user comme statut avec id--%>
                                <c:forEach items="${statuts}" var="statut">
                                        <a href="statut?ID=${statut.id}" class="list-group-item list-group-item-action">${statut.nom}</a>
                                </c:forEach>
                        </ul>
                </div>
        </div>
        
        
</div>



<jsp:include page="footer.jsp"/>