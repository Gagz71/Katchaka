<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="entete.jsp"/>
<head>
        <title>${statut.nom}</title>
</head>

        <div class="container-fluid">
                <div class="row justify-content-center">
                        <h1 class="display-4 text-center mt-5 text-uppercase">Statut ${statut.nom}</h1>
                </div>
                
        
        
        </div>
<jsp:include page="footer.jsp"/>