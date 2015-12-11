<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/inc/style.css"/>" />
</head>
<body>
<c:import url="/inc/inc_patient_menu.jsp" />
<fieldset>
<legend>Les rendez-vous de patient: </legend>
<div id ="voireRdv">
<c:choose>
		<c:when test="${ empty sessionScope.ListeRdv }">
			<p class="erreur">Aucune rendez-vous n'a été trouvé pour ce nom !!.</p>
		</c:when>
		<%-- Sinon, affichage du tableau. --%>
		<c:otherwise>
			<table class="center">
				<tr>
					<th>Nom de patient</th>
					<th>Prenom de patient</th>
					<th>Nom de médecin</th>
					<th>Prénom de médecin</th>
					<th>spécialité de médecin</th>
					<th>Date</th>
					<th>créneau horaire</th>
					<th>Action de l'utilisateur</th>
				</tr>
				<c:forEach items="${sessionScope.ListeRdv }"
					var="mapRDV">
					
					<tr>
						<th>${mapRDV.nomPatient}</th>
						<th>${mapRDV.prenomPatient}</th>
						<th>${mapRDV.nomDocteur}</th>
						<th>${mapRDV.prenomDocteur}</th>
						<th>${mapRDV.specialite}</th>
						<th>${mapRDV.time}</th>
						<th>${mapRDV.creneau}</th>
						<th><a href="<c:url
value="/suppressionRdv"><c:param name="idRdv" value="${
mapRDV.id }" /></c:url>">
<img src="<c:url
value="/inc/supprimer.png"/>" alt="Supprimer" />
</a></th>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
	</div>
	</fieldset>
</body>
</html>