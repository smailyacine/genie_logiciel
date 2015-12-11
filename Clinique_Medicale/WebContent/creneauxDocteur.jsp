<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<form name ="creneau" action="<c:url value="/validerNouveauCreneau" />" method="POST" id="creneau" style="visibility: visible">
<c:if test="${!empty sessionScope.listeDisponible }">
<table>
<tr>
<c:forEach items="${sessionScope.listeDisponible}" var ="mapCreneauHeurs">
<th><c:out value="${mapCreneauHeurs.key}"></c:out></th>
</c:forEach>
</tr>
<tr>
<c:forEach items="${sessionScope.listeDisponible}" var ="mapCreneau">
<th><input type="radio" name="creneauId" value="${mapCreneau.value}"></th>
</c:forEach>
</tr>
</table>
<br>
<input type="submit" value="valider le rendez-vous" />
</c:if>
</form>
