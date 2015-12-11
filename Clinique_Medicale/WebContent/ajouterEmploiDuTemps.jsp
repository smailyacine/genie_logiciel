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
function checkDisponibilite(){
	var day, month, year;
	year = document.getElementById("year");
	 month = document.getElementById("month");
   day = document.getElementById("day");
	
  if(year.options[year.selectedIndex].value == "1" || month.options[month.selectedIndex].value == "1" | day.options[day.selectedIndex].value == "1"){
		alert("Veillez choisir le jour, le mois et l'annee");
	}
	else{
		var ysate = year.options[year.selectedIndex].value;
		var mdate = month.options[month.selectedIndex].value;
		var ddate = day.options[day.selectedIndex].value;
		 var xhttp; 
		  xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (xhttp.readyState == 4 && xhttp.status == 200) {
		    	/* document.getElementById("listeCreneaux").innerHTML = xhttp.responseText; */
		    	loadjsp();
		    }
		  };
		  xhttp.open("GET", "http://localhost:8080/Clinique_Medicale/ajouterCreneau?date="+ysate+"-"+mdate+"-"+ddate, true);
		  xhttp.send();
	}
}
function loadjsp(){
	var creneau = document.getElementById("CreneauxDisponible");
	creneau.style.visibility = 'visible';
	$("#CreneauxDisponible").load("creneauxDocteur.jsp");
}

</script>
</head>
<body>
<div class= "select_prendre_rdv">
	<select name="month" id="month" onchange="" size="1">
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
	<select name="day" id="day" onchange="" size="1">
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
	 <select name="year" id="year" onchange="" size="1">
		<option value="1">selecionner une anneé</option>
		<option value="2015">2015</option>
		<option value="2016">2016</option>
		<option value="2017">2017</option>
		<option value="2018">2018</option>
		<option value="2019">2019</option>
	</select> 
	</div>
	<input type="button" id="submit" value="verifier la disponibilité"  onclick="checkDisponibilite()">
	<div id="CreneauxDisponible" style="visibility: hidden"></div>
</body>
</html>