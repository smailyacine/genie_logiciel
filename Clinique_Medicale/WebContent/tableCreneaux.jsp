<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

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
</body>
</html>