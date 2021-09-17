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
                                          <div class="card-body ">
                                                <h5 class="card-title"><strong>${personne.pseudo}</strong>
                                                      <a href="personne?ID=${personne.id}">🖋️</a>
                                                </h5>
                                                <p class="card-text">Né${personne.genre.nom == 'Femme' ? 'e':' '} le: <strong>${personne.dateDeNaissance}</strong></p>
                                                <p class="card-text">Sexe: <strong>${personne.genre.nom}</strong></p>
                                                <p class="card-text">Recherche:  <strong>${personne.genreRecherche.nom}</strong></p>
                                                <p class="card-text">Intérêts:  <c:forEach items="${personne.interets}" var="interet"><strong>${interet.nom},</strong></c:forEach></p>
                                                <p class="card-text">Description: <strong>${personne.bio}</strong></p>
                                                <p class="card-text"><strong>${personne.estFumeur ? 'Fumeur' : 'Non-fumeur'}</strong></p>
                                          </div>
                                          <div class="card-footer ${personne.genre.nom == 'Femme' ?'bg-outline-primary border-primary' : 'bg-outline-info border-info'} ">Statut: <strong>${personne.statut.nom}</strong></div>
                                    </div>
                              </div>
                             
                        </c:forEach>
                  </div>
            
                  <div class="row">
                        <div class="col-2">
                              <c:if test="${!pageDePersonnes.first}">
                                    <a href="?page=0&sort=${pageDePersonnes.sort.iterator().next().property},${pageDePersonnes.sort.iterator().next().direction}&utilisateurs_page=${pageDUtilisateurs.number}&utilisateurs_sort=${pageDUtilisateurs.sort.iterator().next().property},${pageDUtilisateurs.sort.iterator().next().direction}">&#x23EE;</a>
                                    <a href="?page=${pageDePersonnes.number-1}&sort=${pageDePersonnes.sort.iterator().next().property},${pageDePersonnes.sort.iterator().next().direction}&utilisateurs_page=${pageDUtilisateurs.number}&utilisateurs_sort=${pageDUtilisateurs.sort.iterator().next().property},${pageDUtilisateurs.sort.iterator().next().direction}">&#x23EA;</a>
                              </c:if>
                              Page ${pageDePersonnes.number+1}
                              <!-- On teste si la page de personnes est la dernière page -->
                              <c:if test="${!pageDePersonnes.last}">
                                    <a href="?page=${pageDePersonnes.number+1}&sort=${pageDePersonnes.sort.iterator().next().property},${pageDePersonnes.sort.iterator().next().direction}&utilisateurs_page=${pageDUtilisateurs.number}&utilisateurs_sort=${pageDUtilisateurs.sort.iterator().next().property},${pageDUtilisateurs.sort.iterator().next().direction}">&#x23E9;</a>
                                    <a href="?page=${pageDePersonnes.totalPages - 1}&sort=${pageDePersonnes.sort.iterator().next().property},${pageDePersonnes.sort.iterator().next().direction}&utilisateurs_page=${pageDUtilisateurs.number}&utilisateurs_sort=${pageDUtilisateurs.sort.iterator().next().property},${pageDUtilisateurs.sort.iterator().next().direction}">&#x23ED;</a>
                              </c:if>
                        </div>
                  </div>
            </div>

      </div>

<jsp:include page="footer.jsp"/>

