<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/inc/style.css"/>" />
<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
<script>
/* /* var target = event.target || event.srcElement;
if (target = "ajouter des créneaux"){
	loadjsp()
}
} */ 

function redirectpage(){
	var e = document.getElementById("chooseETpage");
	var choix = e.options[e.selectedIndex].value;
	if(choix == "2"){
		loadjsp1();
	}
	else if(choix == "3"){
		loadjsp2();
	}

}

function loadjsp1(){
	var creneau = document.getElementById("AjouterCreneau");
	var creneau1 = document.getElementById("SupprimerCreneau");
	creneau1.innerHTML = "";
	creneau.style.visibility = 'visible';
	creneau1.style.visibility = 'hidden';
	$("#AjouterCreneau").load("ajouterEmploiDuTemps.jsp");
}
function loadjsp2(){
	var creneau = document.getElementById("SupprimerCreneau");
	var creneau1 = document.getElementById("AjouterCreneau");
	creneau1.innerHTML = "";
	creneau.style.visibility = 'visible';
	creneau1.style.visibility = 'hidden';
	$("#SupprimerCreneau").load("supprimerEmploiDuTemps.jsp");
}
</script>
</head>
<body>
<c:import url="/inc/inc_docteur_menu.jsp" />
<div id="form_rdv">
<div class= "select_prendre_rdv">
<select name="sdfsdfsdfs" id="chooseETpage" size="1"
		onclick="redirectpage()">
		<option value="1" >Vueillez choisir votre action</option>
		<option value="2">Ajouter un Créneau</option>
		<option value="3">supprimer un Créneau</option>
	</select>
</div>
  <div id = "AjouterCreneau" style="visibility: hidden"></div>
  <div id = "SupprimerCreneau" style="visibility: hidden"></div>
  </div>
</body>
</html>