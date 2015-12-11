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
    <c:import url="/inc/inc_patient_menu.jsp" />
    <fieldset>
    <legend>Le dossier de patient: </legend>
          <div id="corps">
        <c:choose>
            <%-- Si aucun client n'existe en session, affichage d'un message par défaut. --%>
            <c:when test="${ empty sessionScope.sessionPatient }">
                <p class="erreur"> Pas de d'informations disponibles </p>
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
                    <th>Le groupe sanguin</th>
                    <th>Sex</th>
                    <th>Le numéro d'assurance</th>
                                       
                </tr>
                 <tr>
                    <td><c:out value="${ sessionScope.sessionPatient.nom }"/></td>
                    <td><c:out value="${ sessionScope.sessionPatient.prenom }"/></td>
                    <td><c:out value="${ sessionScope.sessionPatient.adresse }"/></td>
                    <td><c:out value="${ sessionScope.sessionPatient.telephone }"/></td>
                    <td><c:out value="${ sessionScope.sessionPatient.email }"/></td>
                    <td><c:out value="${ sessionScope.sessionPatient.groupeSanguin }"/></td>
                    <td><c:out value="${ sessionScope.sessionPatient.sexe }"/></td>
                    <td><c:out value="${ sessionScope.sessionPatient.num_assurance }"/></td>
                    </tr>
                    <%-- Lien vers la servlet de suppression, avec passage du nom du médecin - c'est-à-dire la clé de la Map - en paramètre grâce à la balise <c:param/>. --%>

            </table>
            </c:otherwise>
        </c:choose>
        </div>  
        </fieldset>     
    </body>
</html>