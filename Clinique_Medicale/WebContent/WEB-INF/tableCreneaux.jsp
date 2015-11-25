<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<form name ="creneau" action="<c:url value="/validerRDV" />" method="POST" id="creneau" style="visibility: visible">
<c:if test="${!empty sessionScope.sessionCreneau }">
<table>
<tr>
<c:forEach items="${sessionScope.sessionCreneau}" var ="mapCreneauHeurs">
<th><c:out value="${mapCreneauHeurs.hours}"></c:out></th>
</c:forEach>
</tr>
<tr>
<c:forEach items="${sessionScope.sessionCreneau}" var ="mapCreneau">
<th><input type="radio" name="creneauId" value="${mapCreneau.id}"></th>
</c:forEach>
</tr>
</table>
<br>
<input type="submit" value="valider le rendez-vous" class="sansLabel" />
</c:if>
</form>
