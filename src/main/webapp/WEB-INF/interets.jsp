<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="entete.jsp"/>
<head>
        <title>Intérêts</title>
</head>

        <div class="container-fluid">
                <div class="row justify-content-center">
                        <h1 class="display-4 text-center mt-5 text-uppercase">Liste des centres d'intérêts</h1>
                </div>
                
                <div class="row justify-content-center m-auto pt-5 flex-column">
                
                        <div class="col-2 pb-3 m-auto">
                                <form action="interets" method="get">
                                        <input type="text" name="FILTRE" >
                                        <input type="submit" value="Filtrer">
                                </form>
                        </div>
                        
                        <div class="col-3 m-auto">
                                <div class="list-group">
                                        <c:forEach items="${interets}" var="interet">
                                                <a href="#" class="list-group-item list-group-item-action list-group-item-info">${interet.nom}</a>
                                        </c:forEach>
                                </div>
                        </div>
        
                        <div class="col-1 pt-3 pb-5 m-auto">
                                <a href="ajouterInteret" class="list-group-item list-group-item-action list-group-item-primary">➕ intérêt</a>
                        </div>
                </div>
        </div>

<jsp:include page="footer.jsp"/>