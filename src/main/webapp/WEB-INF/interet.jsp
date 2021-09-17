<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="entete.jsp"/>
<head>
        <title>Ajouter un centre d'intérêt</title>
</head>


        <div class="container-fluid">
                <div class="row justify-content-center">
                        <h1 class="display-4 text-center mt-5 text-uppercase">Ajout d'un nouveau centre intérêt</h1>
                </div>
                
                <div class="row justify-content-center m-auto pt-5 flex-column">
        
                        <div class="col-2 pt-3 pb-5 m-auto ">
                                <form action="interet" method="post">
                                        <label class="form-label">Nom du centre d'intérêt à ajouter</label>
                                        <input type="text" name="NOMINT" class="form-control">
                                        <div class="col m-auto text-center">
                                                <input type="submit" class="btn btn-outline-primary mt-3 text-center" value="➕ ">
                                        </div>
                                        
                                </form>
                                
                                
                        </div>
                     
                
                </div>
        </div>


<jsp:include page="footer.jsp"/>