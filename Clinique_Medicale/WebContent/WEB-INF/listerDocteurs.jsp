<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Liste des médecins inscris</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/inc/style.css"/>" />
    </head>
    <body>
    <c:import url="/inc/inc_patient_menu.jsp" />
        <div id="corps">
        <c:choose>
            <%-- Si aucun client n'existe en session, affichage d'un message par défaut. --%>
            <c:when test="${ empty sessionScope.sessionDocteurListe }">
                <p class="erreur">"${sessionScope.resultat_liste_docteur}"</p>
            </c:when>
            <%-- Sinon, affichage du tableau. --%>
            <c:otherwise>
            <table class="center">
                <tr>
                    <th>Nom</th>
                    <th>Prénom</th>
                    <th>Adresse</th>
                    <th>Téléphone</th>
                    <th>Email</th>                   
                </tr>
                <%-- Parcours de la Map des mdecins en session, et utilisation de l'objet varStatus. --%>
                <c:forEach items="${ sessionScope.sessionDocteurListe }" var="docteurs" varStatus="boucle">
                <%-- Simple test de parité sur l'index de parcours, pour alterner la couleur de fond de chaque ligne du tableau. --%>
                    <%-- Affichage des propriétés du bean medecin, qui est stocké en tant que valeur de l'entrée courante de la map --%>
                    <tr>
                    <td><c:out value="${ docteurs.nom }"/></td>
                    <td><c:out value="${ docteurs.prenom }"/></td>
                    <td><c:out value="${ docteurs.adresse }"/></td>
                    <td><c:out value="${ docteurs.telephone }"/></td>
                    <td><c:out value="${ docteurs.email }"/></td>
                    </tr>
                    <%-- Lien vers la servlet de suppression, avec passage du nom du médecin - c'est-à-dire la clé de la Map - en paramètre grâce à la balise <c:param/>. --%>

                </c:forEach>
            </table>
            </c:otherwise>
        </c:choose>
        </div>
    </body>
</html>