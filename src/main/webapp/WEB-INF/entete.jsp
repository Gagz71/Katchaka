<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="fr">
<head>
      <meta charset="UTF-8">
      <meta name="viewport"
            content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
      <meta http-equiv="X-UA-Compatible" content="ie=edge">
<%--      <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">--%>
      <link rel="stylesheet" type="text/css"  href="../css/bootstrap.min.css"/>
      <link rel="stylesheet" href="../css/style.css">
</head>

<body>

      <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
      <div class="container-fluid">
            
            <a class="navbar-brand" href="index">Katchaka</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDarkDropdown" aria-controls="navbarNavDarkDropdown" aria-expanded="false" aria-label="Toggle navigation">
                  <span class="navbar-toggler-icon"></span>
            </button>
            
            <div class="collapse navbar-collapse" id="navbarNavDarkDropdown">
                  <ul class="navbar-nav">
                        <li class="nav-item dropdown">
                              <a class="nav-link dropdown-toggle" href="#" id="navbarDarkDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false"> Utilisateurs</a>
                              <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDarkDropdownMenuLink">
                                    <li><a class="dropdown-item" href="personnes">Voir  la liste des utilisateurs</a></li>
                                    <li><a class="dropdown-item" href="personne">Ajouter un utilisateur</a></li>
                              </ul>
                        </li>
                        
                        <li class="nav-item dropdown">
                              <a class="nav-link dropdown-toggle" href="#" id="navbarDarkDropdownMenuLink2" role="button" data-bs-toggle="dropdown" aria-expanded="false">Villes</a>
                              <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDarkDropdownMenuLink2">
                                    <li><a class="dropdown-item" href="villes">Voir  la liste des villes</a></li>
                                    <li><a class="dropdown-item" href="ajouterVille">Ajouter une ville</a></li>
                              </ul>
                        </li>
                        
                        <li class="nav-item dropdown">
                              <a class="nav-link dropdown-toggle" href="#" id="navbarDarkDropdownMenuLink3" role="button" data-bs-toggle="dropdown" aria-expanded="false">Intérêts</a>
                              <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDarkDropdownMenuLink3">
                                    <li><a class="dropdown-item" href="interets">Voir  la liste des intérêts</a></li>
                                    <li><a class="dropdown-item" href="ajouterInteret">Ajouter un intérêt</a></li>
                              </ul>
                        </li>
                        
                        <li class="nav-item dropdown">
                              <a class="nav-link dropdown-toggle" href="#" id="navbarDarkDropdownMenuLink4" role="button" data-bs-toggle="dropdown" aria-expanded="false">Statuts</a>
                              <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDarkDropdownMenuLink4">
                                    <li><a class="dropdown-item" href="statuts">Voir  la liste des statuts</a></li>
                                    <li><a class="dropdown-item" href="statut">Ajouter un statut</a></li>
                              </ul>
                        </li>
                  
                  </ul>
            </div>
      </div>
</nav>


<%--
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
      <div class="container-fluid">
            
            <a class="navbar-brand" href="index">Katchaka</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDarkDropdown" aria-controls="navbarNavDarkDropdown" aria-expanded="false" aria-label="Toggle navigation">
                  <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavDarkDropdown">
                  <ul class="navbar-nav">
                        <li class="nav-item dropdown">
                              <a class="nav-link dropdown-toggle" href="#" id="navbarDarkDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    Utilisateurs
                              </a>
                              <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDarkDropdownMenuLink">
                                    <li><a class="dropdown-item" href="personnes">Voir  la liste des utilisateurs</a></li>
                                    <li><a class="dropdown-item" href="personne">Ajouter un utilisateur</a></li>
                              </ul>
                        </li>
                        
                        <li class="nav-item dropdown">
                              <a class="nav-link dropdown-toggle" href="#" id="navbarDarkDropdownMenuLink2" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    Villes
                              </a>
                              <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDarkDropdownMenuLink2">
                                    <li><a class="dropdown-item" href="villes">Voir  la liste des villes</a></li>
                                    <li><a class="dropdown-item" href="ajouterVille">Ajouter une ville</a></li>
                              </ul>
                        </li>
                        
                        <li class="nav-item dropdown">
                              <a class="nav-link dropdown-toggle" href="#" id="navbarDarkDropdownMenuLink3" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    Intérêts
                              </a>
                              <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDarkDropdownMenuLink3">
                                    <li><a class="dropdown-item" href="interets">Voir  la liste des intérêts</a></li>
                                    <li><a class="dropdown-item" href="ajouterInteret">Ajouter un intérêt</a></li>
                              </ul>
                        </li>
                        <li class="nav-item dropdown">
                              <a class="nav-link dropdown-toggle" href="#" id="navbarDarkDropdownMenuLink4" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    Statuts
                              </a>
                              <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDarkDropdownMenuLink4">
                                    <li><a class="dropdown-item" href="statuts">Voir  la liste des statuts</a></li>
                                    <li><a class="dropdown-item" href="statut">Ajouter un statut</a></li>
                              </ul>
                        </li>
                  </ul>
            </div>
      
      
      </div>
</nav>--%>
