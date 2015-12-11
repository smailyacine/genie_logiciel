<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<form name ="creneau" action="<c:url value="/ValiderSuppressionCreneau" />" method="POST" id="creneau" style="visibility: visible">
<c:if test="${!empty sessionScope.listeAsupprimer }">
<table>
<tr>
<c:forEach items="${sessionScope.listeAsupprimer}" var ="mapCreneauHeurs">
<th><c:out value="${mapCreneauHeurs.hours}"></c:out></th>
</c:forEach>
</tr>
<tr>
<c:forEach items="${sessionScope.listeAsupprimer}" var ="mapCreneau">
<th><input type="radio" name="creneauId" value="${mapCreneau.id}"></th>
</c:forEach>
</tr>
</table>
<br>
<input type="submit" value="valider la suppression" />
</c:if>
</form>