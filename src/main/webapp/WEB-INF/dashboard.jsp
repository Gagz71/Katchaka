<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="entete.jsp"/>

<head>
    <title>Tableau de bord</title>
</head>

<div class="container-fluid">
    
    <div class="row justify-content-center">
        <h1 class="display-4 text-center mt-2 text-uppercase">Tableau de bord de ${sessionScope.personne.pseudo}</h1>
    </div>
    
    
    
    
    
    <ul class="nav nav-tabs">
        <li class="nav-item">
            <a class="nav-link active" data-bs-toggle="tab" href="#profile">Profile</a>
        </li>
        
        <%--          <li class="nav-item dropdown">--%>
        <%--               <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Invitations</a>--%>
        <%--               <div class="dropdown-menu" style="">--%>
        <%--                    &lt;%&ndash;TODO:compter nombre d'invits&ndash;%&gt;--%>
        <%--                    <a class="dropdown-item" href="#dropdown1">Invitation reçues<span class="badge bg-primary rounded-pill">15</span></a>--%>
        <%--                    <a class="dropdown-item" href="#">Invitation envoyées<span class="badge bg-primary rounded-pill">3</span></a>--%>
        <%--               </div>--%>
        <%--          </li>--%>
        
        <li class="nav-item">
            <a class="nav-link" data-bs-toggle="tab" href="#invitationsEnvoyes">Invitations Envoyés</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" data-bs-toggle="tab" href="#invitationsRecues">Invitations Reçues</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="logout">Déconnexion</a>
        </li>
    </ul>
    <div id="myTabContent" class="tab-content">
        
        
        <div class="tab-pane fade active show" id="profile">
            <div class="card mb-3 col-6 m-auto mt-3">
                <h3 class="card-header d-flex align-items-center justify-content-between ${sessionScope.personne.genre.nom == 'Femme' ?'border-primary ' : 'border-info'}">${sessionScope.personne.pseudo}
                    
                    <div class="col-2 d-flex">
                        <a href="personne?ID=${personne.id}" class="nav-link" title="Modifier le profil"> ✏️</a>
                        <a href="supprimerPersonne?ID=${personne.id}" class="nav-link" title="Supprimer le compte">❌</a>
                    </div>
                </h3>
                
                <div class="card-body">
                    <h6 class="card-subtitle text-muted">Crédits restants</h6>
                    <h5 class="card-title"><span class="badge ${sessionScope.personne.genre.nom == 'Femme' ?'bg-primary ' : 'bg-info'} rounded-pill">${sessionScope.personne.nbCredits}</span></h5>
                
                </div>
                <svg xmlns="http://www.w3.org/2000/svg" class="d-block user-select-none" width="100%" height="200" aria-label="Placeholder: Image cap" focusable="false" role="img" preserveAspectRatio="xMidYMid slice" viewBox="0 0 318 180" style="font-size:1.125rem;text-anchor:middle">
                    <rect width="100%" height="100%" fill="#868e96"></rect>
                    <text x="50%" y="50%" fill="#dee2e6" dy=".3em">Image cap</text>
                </svg>
                <div class="card-body">
                    <h6 class="card-subtitle  ${sessionScope.personne.genre.nom == 'Femme' ?'text-primary ' : 'text-info'}">Biographie</h6>
                    <p class="card-text ">${sessionScope.personne.bio}</p>
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">
                        <h6 class="card-subtitle  ${sessionScope.personne.genre.nom == 'Femme' ?'text-primary ' : 'text-info'}">Statut</h6>
                        ${sessionScope.personne.statut.nom}
                    </li>
                    <li class="list-group-item">
                        <h6 class="card-subtitle  ${sessionScope.personne.genre.nom == 'Femme' ?'text-primary ' : 'text-info'}">Genre</h6>
                        ${sessionScope.personne.genre.nom}
                    </li>
                    <li class="list-group-item">
                        <h6 class="card-subtitle  ${sessionScope.personne.genre.nom == 'Femme' ?'text-primary ' : 'text-info'}">Email</h6>
                        ${sessionScope.personne.email}
                    </li>
                    <li class="list-group-item">
                        <h6 class="card-subtitle  ${sessionScope.personne.genre.nom == 'Femme' ?'text-primary ' : 'text-info'}">Date de naissance</h6>
                        <fmt:formatDate pattern="dd/MM/YYY " value="${sessionScope.personne.dateDeNaissance}"/>
                    
                    </li>
                    <li class="list-group-item">
                        <h6 class="card-subtitle  ${sessionScope.personne.genre.nom == 'Femme' ?'text-primary ' : 'text-info'}">Ville</h6>
                        ${sessionScope.personne.ville.nom}
                    </li>
                    <li class="list-group-item">
                        <h6 class="card-subtitle  ${sessionScope.personne.genre.nom == 'Femme' ?'text-primary ' : 'text-info'}">Genre recherché</h6>
                        ${sessionScope.personne.genreRecherche.nom}
                    </li>
                    <li class="list-group-item">
                        <c:if test="${sessionScope.personne.genre.nom == 'Femme'}">
                            ${sessionScope.personne.estFumeur ? 'Fumeuse':'Non-fumeuse'}
                        </c:if>
                        <c:if test="${sessionScope.personne.genre.nom == 'Homme'}">
                            ${sessionScope.personne.estFumeur ? 'Fumeur':'Non-fumeur'}
                        </c:if>
                    </li>
                
                </ul>
                <div class="card-body">
                    <a href="#" class="card-link">Card link</a>
                    <a href="#" class="card-link">Another link</a>
                </div>
                <div class="card-footer text-muted ${sessionScope.personne.genre.nom == 'Femme' ?'border-primary ' : 'border-info'}">
                    Dernière connexion le xx/xx/xx à xx/xx/xx
                </div>
            </div>
        
        
        </div>
        
        <div class="tab-pane fade" id="invitationsEnvoyes">
            
            <c:forEach items="${invitationsEnvoyes}" var="invitationEnvoye">
                
                ${invitationEnvoye}
                
                <div class="card border-secondary mb-3" style="max-width: 20rem;">
                    <div class="card-header">Envoyé le <fmt:formatDate pattern="dd/MM/YYY " value="${invitationEnvoye.dateEnvoi}"/> </div>
                    <h4 class="card-title">
                        <a href="personneId?ID=${invitationEnvoye.expediteur.id}" class="nav-link">A ${invitationEnvoye.expediteur.pseudo}</a>
                    </h4>
                    <div class="card-body">
                        
                        <p class="card-text">Statut de l'invitation :
                            <c:if test="${invitationEnvoye.isEstAccepte() == true}">
                                ✅ <br>Vous et ${invitationEnvoye.destinataire.pseudo} êtes désormais amis. <br>
                                <a href="personneId?ID=${invitationEnvoye.destinataire.id}" class="nav-link">Jeter un coup d'oeil à son profil 👀</a>
                            
                            </c:if>
                            
                            <c:if test="${invitationEnvoye.isEstAccepte() == false}">
                                Invitation pas encore accepté
                            </c:if>
                        </p>
                    </div>
                </div>
                
                <a href="invitation?ID=${invitationEnvoye.id}">
                        ${invitationEnvoye}
                </a>
            
            
            </c:forEach>
        </div>
        
        <div class="tab-pane fade" id="invitationsRecues">
            ${invitationsRecues}</>
            
    
    
            <div class="accepter">
                <a href="responseInvitation?ID=${invitation.id}&EST_ACCEPTE=true">Accepter</a>
                <a href="responseInvitation?ID=${invitation.id}&EST_ACCEPTE=false">Décliner</a>
            </div>
    
    
    
    </div>





</div>


<jsp:include page="footer.jsp"/>