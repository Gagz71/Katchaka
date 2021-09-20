<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="entete.jsp"/>
<head>
      <title>Personnes</title>
<%--
      <link rel="stylesheet" type="text/css"  href="../css/bootstrap.min.css"/>
--%>
</head>




      <div class="container-fluid">
            
            <div class="row justify-content-center">
                  <a href="personnes?sort=dateDeNaissance,DESC" class="btn">🔻</a>
                  <h1 class="display-4 text-center mt-5 text-uppercase">Liste des utilisateurs</h1>
                  <a href="personnes?sort=dateDeNaissance" class="btn">🔺</a>
            </div>
            
            <div class="row justify-content-center m-auto pt-5 flex-column">
            
                  <div class="col-2 pb-3 m-auto">
                        <form action="personnes" method="get">
                              <input type="text" name="FILTRE" value="${filtre}">
                              <input type="submit" value="Filtrer" class="btn btn-outline-warning">
                              <a href="/personnes" class="btn">Enlever le filtre</a>
                        </form>
                  </div>
                  
                  <div class="row m-auto">
                      
                        <c:forEach items="${pageDePersonnes.content}" var="personne">
                              <div class="col-4">
                                    <div class="card ${personne.genre.nom == 'Femme' ?'border-primary ' : 'border-info'} mb-3 ml-5" >
                                          <div class="card-header bg-transparent ${personne.genre.nom == 'Femme' ?'border-primary ' : 'border-info'}">Ville: <strong>${personne.ville.nom}</strong></div>
                                          <div class="card-body d-flex flex-column ">
                                                <h5 class="card-title d-flex align-items-center justify-content-between">
                                                      <strong>${personne.pseudo}</strong>
                                                      <div class="col-2 d-flex">
                                                            <a href="personne?ID=${personne.id}" class="nav-link"> ✏️</a>
                                                            <a href="supprimerPersonne?ID=${personne.id}" class="nav-link">❌</a>
                                                      </div>
                                                </h5>
                                                <p class="card-text">Né${personne.genre.nom == 'Femme' ? 'e':' '} le: <strong>${personne.dateDeNaissance}</strong></p>
                                                <p class="card-text">Sexe: <strong>${personne.genre.nom}</strong></p>
                                                <p class="card-text">Recherche:  <strong>${personne.genreRecherche.nom}</strong></p>
                                                <p class="card-text">Intérêts:  <c:forEach items="${personne.interets}" var="interet"><strong>${interet.nom},</strong></c:forEach></p>
                                                <p class="card-text">Description: <strong>${personne.bio}</strong></p>
                                                <p class="card-text"><strong>${personne.estFumeur ? 'Fumeur' : 'Non-fumeur'}</strong></p>
                                          </div>
                                          <div class="card-footer ${personne.genre.nom == 'Femme' ?'bg-outline-primary border-primary' : 'bg-outline-info border-info'} ">
                                                Statut: <strong>${personne.statut.nom}</strong>
                                              <a href="invitation?ID=${personne.id}">Inviter</a>
                                          </div>
                                    </div>
                              </div>
                             
                        </c:forEach>
                  </div>
            
                  <div class="row">
                        <div class="col-2">
      
                              <div>
                                    <ul class="pagination">
<%--                                                Si c'est pas la première page--%>
                                          <c:if test="${!pageDePersonnes.first}">
                                                <li class="page-item ">
                                                      <%--Lien vers la première page--%>
                                                      <a class="page-link" href="?page=0&sort=${pageDePersonnes.sort.iterator().next().property},${pageDePersonnes.sort.iterator().next().direction}&utilisateurs_page=${pageDUtilisateurs.number}&utilisateurs_sort=${pageDUtilisateurs.sort.iterator().next().property},${pageDUtilisateurs.sort.iterator().next().direction}"><<<</a>
                                                </li>
                                                <li class="page-item">
                                                      <a class="page-link" href="?page=${pageDePersonnes.number-1}&sort=${pageDePersonnes.sort.iterator().next().property},${pageDePersonnes.sort.iterator().next().direction}&utilisateurs_page=${pageDUtilisateurs.number}&utilisateurs_sort=${pageDUtilisateurs.sort.iterator().next().property},${pageDUtilisateurs.sort.iterator().next().direction}" >&laquo;</a>
                                                </li>
                                          </c:if>
<%--                                          si c'est la première page--%>
                                          <c:if test="${pageDePersonnes.first}">
                                                <li class="page-item disabled ">
                                                      <a class="page-link" href="#">&laquo;</a>
                                                </li>
                                          </c:if>
                                          <li class="page-item active">
                                                <a class="page-link" href="#">${pageDePersonnes.number+1}</a>
                                          </li>
                                          <li class="page-item">
                                                <a class="page-link" href="#">${pageDePersonnes.number+2}</a>
                                          </li>
                                          <li class="page-item">
                                                <a class="page-link" href="#">${pageDePersonnes.number+3}</a>
                                          </li>
                                          <li class="page-item">
                                                <a class="page-link" href="#">${pageDePersonnes.number+4}</a>
                                          </li>
                                          <li class="page-item">
                                                <a class="page-link" href="#">${pageDePersonnes.number+5}</a>
                                          </li>
<%--                                          Si c'est la dernière page--%>
                                          <c:if test="${pageDePersonnes.last}">
                                          <li class="page-item disabled">
                                                <a class="page-link" >&raquo;</a>
                                          </li>
                                          </c:if>
                                          <%--Si c'est pas la dernière page--%>
                                          <c:if test="${!pageDePersonnes.last}">
                                                <li class="page-item">
                                                      <a class="page-link" href="?page=${pageDePersonnes.number+1}&sort=${pageDePersonnes.sort.iterator().next().property},${pageDePersonnes.sort.iterator().next().direction}&utilisateurs_page=${pageDUtilisateurs.number}&utilisateurs_sort=${pageDUtilisateurs.sort.iterator().next().property},${pageDUtilisateurs.sort.iterator().next().direction}">&raquo;</a>
                                                </li>
                                                <li class="page-item">
                                                      <a href="?page=${pageDePersonnes.totalPages - 1}&sort=${pageDePersonnes.sort.iterator().next().property},${pageDePersonnes.sort.iterator().next().direction}&utilisateurs_page=${pageDUtilisateurs.number}&utilisateurs_sort=${pageDUtilisateurs.sort.iterator().next().property},${pageDUtilisateurs.sort.iterator().next().direction}" class="page-link">>>></a>
                                                </li>
                                          </c:if>
                                    </ul>
                              </div>
                        </div>
                  </div>
            </div>

      </div>



<jsp:include page="footer.jsp"/>

