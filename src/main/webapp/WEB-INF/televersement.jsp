<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="entete.jsp"/>

<head>
    <title>Upload d'image</title>
</head>

    <div class="container-fluid">
        <div class="row justify-content-center">
            <h1 class="display-4 text-center mt-2 text-uppercase">Upload d'image</h1>
        </div>
    
        <div class="row justify-content-center">
            <form action="televersementImage?ID=${personne.id}" method="post" enctype="multipart/form-data">
                <input type="file" name="FICHIER" accept="image/png, image/jpeg, image/gif" />
                <input type="submit" value="Téléverser">
            </form>
        </div>
    </div>


<jsp:include page="footer.jsp"/>