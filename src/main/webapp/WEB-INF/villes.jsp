<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="entete.jsp"/>
<head>
        <title>Villes</title>
</head>

<div class="container-fluid">
        
        <div class="row justify-content-center">
                <h1 class="display-4 text-center mt-5 text-uppercase">Liste des villes</h1>
        </div>
        
        <div class="row justify-content-center m-auto pt-5 flex-column">
                
                <div class="col-6 m-auto text-center pb-3">
                        <form action="villes" method="get">
                                <input type="text" name="FILTRE">
                                <input type="submit" value="Filter">
                        </form>
                </div>
                
                <div class="col-2 m-auto text-center ">
                        <ul class="list-group">
                                <c:forEach items="${villes}" var="ville">
                                        <li class="list-group-item">${ville.nom}</li>
                                </c:forEach>
                        </ul>
                        <a href="ajouterVille" class="btn btn-outline-primary mt-5">Ajouter une ville</a>
                </div>
                
        </div>
        
</div>



<jsp:include page="footer.jsp"/>