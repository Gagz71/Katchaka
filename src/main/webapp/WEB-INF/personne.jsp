<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="entete.jsp"/>

<head>
    <title>Inscription</title>
    <style>
        .erreur{
            color: red;
        }
    </style>
</head>

<div class="container-fluid">
    <div class="row justify-content-center">
        <h1 class="display-4 text-center mt-5 text-uppercase">Ajouter un nouvel utilisateur</h1>
    </div>
    
    <div class="row justify-content-center m-auto pt-5 flex-column">
        
        <div class="col-6 m-auto">
            <%--                        Path => correspond aux attributs--%>
            <form:form action="personne" method="post" modelAttribute="personne">
                
                <div class="mb-3 row">
                    <form:label path="pseudo" cssClass="col-sm-2 col-form-label" >Pseudo</form:label>
                    <div class="col-sm-10">
                        <form:input type="text" path="pseudo" cssClass="form-control" placeholder="Pseudo"/>
                    </div>
                    <form:errors path="pseudo" cssClass="erreur"/>
                </div>
                
                <div class="mb-3 row">
                    <form:label path="dateDeNaissance" cssClass="col-sm-2 col-form-label" >Date de naissance</form:label>
                    <div class="col-sm-10">
                        <form:input type="date" path="dateDeNaissance" cssClass="form-control"/>
                    </div>
                    <form:errors path="dateDeNaissance" cssClass="erreur"/>
                </div>
                
                <div class="mb-3 row">
                    <form:label path="email" cssClass="col-sm-2 col-form-label">Email</form:label>
                    <div class="col-sm-10">
                        <form:input type="text" path="email" cssClass="form-control"  placeholder="exemple@exemple.com"/>
                    </div>
                    <form:errors path="email" cssClass="erreur"/>
                </div>
                
                <div class="mb-3 row">
                    <form:label path="motDePasse" cssClass="col-sm-2 col-form-label">Mot de passe</form:label>
                    <div class="col-sm-10">
                        <form:input type="text" path="motDePasse" cssClass="form-control"  placeholder="Saisissez un mot de passe"/>
                    </div>
                    <form:errors path="motDePasse" cssClass="erreur"/>
                </div>
                
                <div class="mb-3 row">
                    <form:label path="genre" cssClass="col-sm-2 col-form-label">Sexe</form:label>
                    <div class="col-sm-10">
                        <form:select path="genre" cssClass="form-control" >
                            <form:option value="" >Veuillez sélectionner votre sexe</form:option>
                            <form:options items="${genres}" itemLabel="nom" itemValue="id" />
                        </form:select>
                    </div>
                    <form:errors path="genre" cssClass="erreur"/>
                </div>
                
                <div class="mb-3 row">
                    <form:label path="ville" cssClass="col-sm-2 col-form-label">Ville</form:label>
                    <div class="col-sm-10">
                        <form:select path="ville" cssClass="form-control" >
                            <form:option value="">Veuillez sélectionner votre ville</form:option>
                            <form:options items="${villes}" itemLabel="nom" itemValue="id" />
                        </form:select>
                    </div>
                    <form:errors path="ville" cssClass="erreur"/>
                </div>
                
                <div class="mb-3 row">
                    <form:label path="genreRecherche" cssClass="col-sm-2 col-form-label">Genre recherché</form:label>
                    <div class="col-sm-10">
                        <form:select path="genreRecherche" cssClass="form-control" >
                            <form:option value="">Veuillez sélectionner le Genre recherché</form:option>
                            <form:options items="${genres}" itemLabel="nom" itemValue="id" />
                        </form:select>
                    </div>
                    <form:errors path="genreRecherche" cssClass="erreur"/>
                </div>
                
                <div class="mb-3 row">
                    <form:label path="statut" cssClass="col-sm-2 col-form-label">Statut</form:label>
                    <div class="col-sm-10">
                        <form:select path="statut" cssClass="form-control" >
                            <form:option value="">Veuillez sélectionner votre statut</form:option>
                            <form:options items="${statuts}" itemLabel="nom" itemValue="id" />
                        </form:select>
                    </div>
                    <form:errors path="statut" cssClass="erreur"/>
                </div>
                
                <div class="mb-3 row">
                    <form:label path="interets" cssClass="col-sm-2 col-form-label">Intérêt(s)</form:label>
                    <div class="col-sm-10">
                        <form:select path="interets" cssClass="form-control" multiple="true">
                            <form:option value="">Veuillez sélectionner vos intérêts</form:option>
                            <form:options items="${interets}" itemLabel="nom" itemValue="id" />
                        </form:select>
                    </div>
                    <form:errors path="interets" cssClass="erreur"/>
                </div>
                
                <div class="mb-3 row">
                    <form:label path="bio" cssClass="col-sm-2 col-form-label">Biographie</form:label>
                    <div class="col-sm-10">
                        <form:textarea  path="bio" cssClass="form-control"  placeholder="Présentez-vous en quelques lignes !"/>
                    </div>
                    <form:errors path="bio" cssClass="erreur"/>
                </div>
                
                <div class="mb-3 row">
                    <form:label path="estFumeur" cssClass="col-sm-2 col-form-label">Fumeur </form:label>
                    <div class="col-sm-10">
                        <form:checkbox  path="estFumeur" cssClass="form-control" />
                    </div>
                    <form:errors path="estFumeur" cssClass="erreur"/>
                </div>
                
                <%--permet de modifier sans réinsérer !! pr le update de personne--%>
                <form:hidden path="id" />
                
                <div class="row mt-5 mb-5">
                    <input type="submit" class="btn btn-outline-success m-auto " value="Inscrire"/>
                </div>
            
            
            </form:form>
        </div>
    </div>

</div>

<jsp:include page="footer.jsp"/>