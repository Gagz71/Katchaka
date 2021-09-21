<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="entete.jsp"/>
<head>
      <title>Connexion</title>
</head>

<div class="container-fluid">
      
      <div class="row justify-content-center">
            <h1 class="display-3 text-center mt-5 text-uppercase">Bienvenue sur Katchaka</h1>
            <h3 class="text-center display-4">L'appli qui s'occupe de trouver votre âme-soeur pour vous</h3>
      </div>
            <div class="row justify-content-center">
                  <h1 class="display-4 text-center mt-5 text-uppercase">Connexion</h1>
            </div>
      
            <div class="row justify-content-center m-auto pt-5 flex-column">
                  <div class="col-6 m-auto">
                        <form action="login" method="post">
                        
                              <div class="form-group">
                                    <label for="exampleInputEmail1" class="form-label mt-4">Email</label>
                                    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Saisissez votre email" name="EMAIL">
                                    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                              </div>
                              <div class="form-group">
                                    <label for="exampleInputPassword1" class="form-label mt-4">Mot de passe</label>
                                    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Saisissez votre mot de passe" name="PASSWORD">
                              </div>
                        
                              <div class="text-center mt-3">
                                    <input type="submit" class="btn btn-outline-info m-auto " value="Se connecter"/>
                              </div>
                        </form>
                        <div class="row justify-content-center mt-2">
                              <div class="col-6 d-flex flex-column text-center">
                              
                                    <small id="registerHelp" class="form-text text-muted">Pas encore inscrit ?</small>
                                    <a href="personne" class="btn btn-outline-secondary m-auto " aria-describedby="registerHelp">S'inscrire</a>
                              </div>
                  
                  
                        </div>
                  </div>
            </div>
     
</div>





<jsp:include page="footer.jsp"/>