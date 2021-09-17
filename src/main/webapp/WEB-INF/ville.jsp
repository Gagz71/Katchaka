<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="entete.jsp"/>
<head>
        <title>Ajouter une ville</title>
</head>

<div class="container-fluid">
        <div class="row justify-content-center">
                <h1 class="display-4 text-center mt-5 text-uppercase">Ajout d'une ville</h1>
        </div>
        
        <div class="row justify-content-center m-auto pt-5 flex-column">
                <div class="ccol-2 pt-3 pb-5 m-auto">
                        <form action="ville" method="post">
                                <label class="form-label">Nom de la ville à ajouter</label>
                                <input type="text" name="NOM" class="form-control">
                                <div class="row mt-3 mb-5">
                                        <input type="submit" class="btn btn-outline-primary m-auto " value="➕ ">
                                </div>
                                
                        </form>
                </div>
        </div>
        
</div>



<jsp:include page="footer.jsp"/>