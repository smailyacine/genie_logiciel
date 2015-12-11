<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Connexion</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/inc/style.css"/>" />
<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
<script>

function ChoisirDocteur(id) {
	if( id == "1"){
		document.getElementById("test").innerHTML ="Merci de choisir une specilaite dans la liste dérouante";
		return;
	}
  var xhttp;    
  xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (xhttp.readyState == 4 && xhttp.status == 200) {
    	
    	document.getElementById("test").innerHTML = xhttp.responseText;
    }
  };
  xhttp.open("GET", "http://localhost:8080/Clinique_Medicale/recuperermedcins?specialite="+id, true);
  xhttp.send();
}



function EmploiDuTemps(id){
	if( id == "1"){
		document.getElementById("test2").innerHTML ="Merci de choisir un medcin dans la liste déroulante";
		return;
	}
	else{	
		document.getElementById("test2").innerHTML ="Merci de specifier le jour, le mois et l'annee de rendez-vous";
		var year = document.getElementById("year");
		year.style.visibility = 'visible';
		var month = document.getElementById("month");
		month.style.visibility = 'visible';
		var day = document.getElementById("day");
		day.style.visibility = 'visible';
		var submit = document.getElementById("submit");
		submit.style.visibility = 'visible';
	}
	  var xhttp;    
	  xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (xhttp.readyState == 4 && xhttp.status == 200) {

	    }
	  };
	  xhttp.open("GET", "http://localhost:8080/Clinique_Medicale/recuperermedcins?specialite="+id, true);
	  xhttp.send();
}

function hide(id){
	var earrings = document.getElementById(id);
	earrings.style.visibility = 'hidden';
	}

	function show(id){
	var earrings = document.getElementById(id);
	earrings.style.visibility = 'visible';
	}

function checkDisponibilite(){
	var specialite, docteur, day, month, year;
	specialite = document.getElementById("specilaites");
	docteur = document.getElementById("docteurliste");
	year = document.getElementById("year");
	 month = document.getElementById("month");
   day = document.getElementById("day");
	
	if(specialite.options[specialite.selectedIndex].value == null || specialite.options[specialite.selectedIndex].value == "1"){
		alert("Veillez choisir une specialité");
	}
	else if(docteur.options[docteur.selectedIndex].value == null || docteur.options[docteur.selectedIndex].value == "1")
		{
		alert("Veillez choisir un docteur");
		}
	else if(year.options[year.selectedIndex].value == "1" || month.options[month.selectedIndex].value == "1" | day.options[day.selectedIndex].value == "1"){
		alert("Veillez choisir le jour, le mois et l'annee");
	}
	else{
		var ysate = year.options[year.selectedIndex].value;
		var mdate = month.options[month.selectedIndex].value;
		var ddate = day.options[day.selectedIndex].value;
		var identifiant = docteur.options[docteur.selectedIndex].value;
		 var xhttp; 
		  xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (xhttp.readyState == 4 && xhttp.status == 200) {
		    	document.getElementById("listeCreneaux").innerHTML = xhttp.responseText;
		    	loadjsp();
		    	//var table = document.getElementById("creneau");
		    	//table.style.visibility = 'visible';
		    }
		  };
		  xhttp.open("GET", "http://localhost:8080/Clinique_Medicale/recupererRdv?date="+ysate+"-"+mdate+"-"+ddate+"&identifiant="+identifiant, true);
		  xhttp.send();
	}
}
function loadjsp(){
	var tableCreneau = document.getElementById("tableCreneaux");
	tableCreneau.style.visibility = 'visible';
	$("#tableCreneaux").load("tableCreneaux.jsp");
}
	
</script>
</head>
<c:import url="/inc/inc_patient_menu.jsp" />
<div id="form_rdv">
<form name="formeSpecialite">
<div class= "select_prendre_rdv">
	<select name="specilaites" id="specilaites"size="1"
		onchange="ChoisirDocteur(this.options[this.selectedIndex].value)">
		<option value="1" >Veiullez choisir une
			specialite</option>
		<option value="2">Anesthésie – Réanimation</option>
		<option value="3">Angiologie</option>
		<option value="4">Cardiologie médicale et Interventionnelle</option>
		<option value="5">Dermatologie</option>
		<option value="6">Endocrinologie</option>
		<option value="7">Gastro-Entérologie</option>
		<option value="8">Gynécologie</option>
		<option value="9">Laboratoire d’Analyses médicales</option>
		<option value="10">Médecine Nucléaire</option>
		<option value="11">Neurologie</option>
		<option value="12">Oncologie</option>
		<option value="13">Ophtalmologie</option>
		<option value="14">Pneumologie</option>
		<option value="15">Radio/scanner/IRM</option>
		<option value="16">Traitement de la Douleur</option>
		<option value="Urgences">Urgences</option>
		<option value="Cardiologie">Cardiologie</option>

	</select>
	<p id="test">Merci de choisir une specilaite dans la liste
		dérouante</p>
</div>

	<!-- Month dropdown -->
	<div class= "select_prendre_rdv">
	<p id="test2"></p>
	<select name="month" id="month" onchange="" size="1"
		style="visibility: hidden">
		<option value="1">selecionner un mois</option>
		<option value="01">January</option>
		<option value="02">February</option>
		<option value="03">March</option>
		<option value="04">April</option>
		<option value="05">May</option>
		<option value="06">June</option>
		<option value="07">July</option>
		<option value="08">August</option>
		<option value="09">September</option>
		<option value="10">October</option>
		<option value="11">November</option>
		<option value="12">December</option>
	</select>
	

	<!-- Day dropdown -->
	<select name="day" id="day" onchange="" size="1"
		style="visibility: hidden">
		<option value="1">selecionner un jour</option>
		<option value="01">01</option>
		<option value="02">02</option>
		<option value="03">03</option>
		<option value="04">04</option>
		<option value="05">05</option>
		<option value="06">06</option>
		<option value="07">07</option>
		<option value="08">08</option>
		<option value="09">09</option>
		<option value="10">10</option>
		<option value="11">11</option>
		<option value="12">12</option>
		<option value="13">13</option>
		<option value="14">14</option>
		<option value="15">15</option>
		<option value="16">16</option>
		<option value="17">17</option>
		<option value="18">18</option>
		<option value="19">19</option>
		<option value="20">20</option>
		<option value="21">21</option>
		<option value="22">22</option>
		<option value="23">23</option>
		<option value="24">24</option>
		<option value="25">25</option>
		<option value="26">26</option>
		<option value="27">27</option>
		<option value="28">28</option>
		<option value="29">29</option>
		<option value="30">30</option>
		<option value="31">31</option>
	</select>
	 <select name="year" id="year" onchange="" size="1"
		style="visibility: hidden">
		<option value="1">selecionner une anneé</option>
		<option value="2015">2015</option>
		<option value="2016">2016</option>
		<option value="2017">2017</option>
		<option value="2018">2018</option>
		<option value="2019">2019</option>
	</select> 
	</div>
	<div class= "select_prendre_rdv">
	
	<input type="button" id="submit" value="verifier la disponibilité" style="visibility: hidden" onclick="checkDisponibilite()">
	</div>
</form>	
	<div id ="listeCreneaux"></div>
	<div id = "tableCreneaux" style="visibility: hidden"></div>
	</div>
</body>
</html>
