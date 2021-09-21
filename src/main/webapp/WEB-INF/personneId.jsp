<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="entete.jsp"/>
<head>
    <title>Profil de ${personneId.pseudo}</title>
    <%--
          <link rel="stylesheet" type="text/css"  href="../css/bootstrap.min.css"/>
    --%>
</head>

    <div class="container-fluid">
    
        <div class="row justify-content-center">
            <h1 class="display-4 text-center mt-5 text-uppercase">Bienvenue sur le profil de ${personneId.pseudo}</h1>
        </div>
        
        <div class="row">
            <p>${personneId}</p>
        </div>
    
    
        <div class="row justify-content-center">
            <div class="col-6 m-auto">
                <div class="card ${personneId.genre.nom == 'Femme' ?'border-primary ' : 'border-info'} mb-3">
                    <h3 class="card-header text-capitalize">${personneId.statut.nom}</h3>
                    <div class="card-body">
                        <h5 class="card-title">${personneId.ville.nom}</h5>
                        <h6 class="card-subtitle text-muted">Né${personneId.genre.nom == 'Femme' ? 'e':' '} le: <fmt:formatDate pattern="dd/MM/YYY " value="${personneId.dateDeNaissance}"/></h6>
                    </div>
                    <div class="card-img text-center ">
                        <img src="../img/ico_user.png" class="img-fluid img-personne-id" alt="icone user">
                    </div>
                    
                    <div class="card-body">
                        <p class="card-text">${personneId.bio}</p>
                    </div>
                    <ul class="list-group list-group-flush">
                        <h5>Centre d'intérêts:</h5>
                        <c:forEach items="${personneId.interets}" var="interet">
                            <li class="list-group-item">${interet.nom}</li>
                        </c:forEach>
                    </ul>
                    <div class="card-body">
                        <a href="invitation?ID=${personneId.id}" class="card-link">Inviter</a>
                        <a href="#" class="card-link">Another link</a>
                    </div>
                    <div class="card-footer text-muted">
                        2 days ago
                    </div>
                </div>
            </div>
        </div>



    </div>

<jsp:include page="footer.jsp"/>