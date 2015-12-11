<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Affichage d'un patient</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/inc/style.css"/>" />
    </head>
    <body>
        <div id="corps">
            <p class="info">${ message }</p>
            <c:if test="${ !erreur }">
            <c:import url="/inc/inc_docteur_menu.jsp" />
             
                <c:if test="${!empty sessionScope.docteurs}">
                
                    <%-- Si l'utilisateur existe en session, alors on affiche son adresse email. --%>
                	<p class="succes">Vous êtes connecté(e) avec l'adresse : ${docteur.email}</p>
                </c:if>
            </c:if>
            
        </div>
    </body>
</html>