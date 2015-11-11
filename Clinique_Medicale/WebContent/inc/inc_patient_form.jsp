<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<label for="nomPatient">Nom <span class="requis">*</span></label>
<input type="text" id="nomPatient" name="nomPatient" value="<c:out value="${patient.nom}"/>" size="30" maxlength="30" />
<span class="erreur">${form.erreurs['nomPatient']}</span>
<br />

<label for="prenomPatient">Prénom </label>
<input type="text" id="prenomPatient" name="prenomPatient" value="<c:out value="${patient.prenom}"/>" size="30" maxlength="30" />
<span class="erreur">${form.erreurs['prenomPatient']}</span>
<br />

<label for="adressePatient">Adresse <span class="requis">*</span></label>
<input type="text" id="adressePatient" name="adressePatient" value="<c:out value="${patient.adresse}"/>" size="30" maxlength="60" />
<span class="erreur">${form.erreurs['adressePatient']}</span>
<br />

<label for="telephonePatient">Numéro de téléphone <span class="requis">*</span></label>
<input type="text" id="telephonePatient" name="telephonePatient" value="<c:out value="${patient.telephone}"/>" size="30" maxlength="30" />
<span class="erreur">${form.erreurs['telephonePatient']}</span>
<br />

<label for="emailPAtient">Adresse email</label>
<input type="email" id="emailPatient" name="emailPatient" value="<c:out value="${patient.email}"/>" size="30" maxlength="60" />
<span class="erreur">${form.erreurs['emailPatient']}</span>
<br />