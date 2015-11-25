<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Affichage d'un patient</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/inc/style.css"/>" />
</head>
<body>
	<c:import url="/inc/inc_patient_menu.jsp" />
	<br>
	<c:choose>
		<c:when test="${ empty sessionScope.consultationListe }">
			<p class="erreur">Aucun consultation trouvée.</p>
		</c:when>
		<%-- Sinon, affichage du tableau. --%>
		<c:otherwise>
			<table class="center">
				<tr>
					<th>Nom de patient</th>
					<th>Prenom de Patient</th>
					<th>Nom de médecin</th>
					<th>Prénom de médecin</th>
					<th>Date</th>
					<th>diagnostique</th>
					<th>teste</th>
				</tr>
				<c:forEach items="${sessionScope.consultationListe }"
					var="mapConsultation">
					
					<tr>
						<th>${mapConsultation.nomPatient}</th>
						<th>${mapConsultation.prenomPatient}</th>
						<th>${mapConsultation.nomDocteur}</th>
						<th>${mapConsultation.prenomDocteur}</th>
						<th>${mapConsultation.date}</th>
						<th>${mapConsultation.diagnostique}</th>
						<th>${mapConsultation.test}</th>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>
