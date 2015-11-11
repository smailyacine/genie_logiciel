package com.app.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.app.beans.Patient;

public class CreationPatientForm {
	
    private static final String CHAMP_CHOIX_PATIENT     = "choixNouveauPatient";
	private static final String CHAMP_NOM               = "nomPatient";
    private static final String CHAMP_PRENOM            = "prenomPatient";
    private static final String CHAMP_ADRESSE           = "adressePatient";
    private static final String CHAMP_TELEPHONE         = "telephonePatient";
    private static final String CHAMP_EMAIL             = "emailPatient";
    private static final String ANCIEN_PATIENT          = "ancienPatient";
    private static final String CHAMP_LISTE_PATIENTS    = "listePatients";
    private static final String SESSION_PATIENTS        = "patients";

    
    private String              resultat;
    private Map<String, String> erreurs        = new HashMap<String, String>();

    public Map<String, String> getErreurs() {
    return erreurs;
    										}
    
    public String getResultat() {
        return resultat;
    }
    
    
    
    public Patient creerPatient ( HttpServletRequest request ) {
    	
    	
        String choixNouveauPatient = getValeurChamp( request, CHAMP_CHOIX_PATIENT );
        
        if ( ANCIEN_PATIENT.equals( choixNouveauPatient ) ) {
            /* Récupération du nom du client choisi */
            String nomAncienPatient = getValeurChamp( request, CHAMP_LISTE_PATIENTS );
            /* Récupération de l'objet client correspondant dans la session */
            HttpSession session = request.getSession();
            Patient patient = ( (Map<String, Patient>) session.getAttribute( SESSION_PATIENTS ) ).get( nomAncienPatient ); 
            return patient;
        }
        
        else {
    	
        String nom = getValeurChamp( request, CHAMP_NOM );
        String prenom = getValeurChamp( request, CHAMP_PRENOM );
        String adresse = getValeurChamp( request, CHAMP_ADRESSE );
        String telephone = getValeurChamp( request, CHAMP_TELEPHONE );
        String email = getValeurChamp( request, CHAMP_EMAIL );
    
        
        Patient patient = new Patient();
        
        try {
            validationNom( nom );
        } catch ( Exception e ) {
            setErreur( CHAMP_NOM, e.getMessage() );
        }
        patient.setNom( nom );

        try {
            validationPrenom( prenom );
        } catch ( Exception e ) {
            setErreur( CHAMP_PRENOM, e.getMessage() );
        }
        patient.setPrenom( prenom );

        try {
            validationAdresse( adresse );
        } catch ( Exception e ) {
            setErreur( CHAMP_ADRESSE, e.getMessage() );
        }
        patient.setAdresse( adresse );

        try {
            validationTelephone( telephone );
        } catch ( Exception e ) {
            setErreur( CHAMP_TELEPHONE, e.getMessage() );
        }
        patient.setTelephone( telephone );

        try {
            validationEmail( email );
        } catch ( Exception e ) {
            setErreur( CHAMP_EMAIL, e.getMessage() );
        }
        patient.setEmail( email );

        if ( erreurs.isEmpty() ) {
            resultat = "Succès de la création du client.";
        } else {
            resultat = "Échec de la création du client.";
        }

        return patient; }
        
    }

    private void validationNom( String nom ) throws Exception {
        if ( nom != null ) {
            if ( nom.length() < 2 ) {
                throw new Exception( "Le nom d'utilisateur doit contenir au moins 2 caractères." );
            }
        } else {
            throw new Exception( "Merci d'entrer un nom d'utilisateur." );
        }
    }

    private void validationPrenom( String prenom ) throws Exception {
        if ( prenom != null && prenom.length() < 2 ) {
            throw new Exception( "Le prénom d'utilisateur doit contenir au moins 2 caractères." );
        }
    }

    private void validationAdresse( String adresse ) throws Exception {
        if ( adresse != null ) {
            if ( adresse.length() < 10 ) {
                throw new Exception( "L'adresse de livraison doit contenir au moins 10 caractères." );
            }
        } else {
            throw new Exception( "Merci d'entrer une adresse de livraison." );
        }
    }

    private void validationTelephone( String telephone ) throws Exception {
        if ( telephone != null ) {
            if ( !telephone.matches( "^\\d+$" ) ) {
                throw new Exception( "Le numéro de téléphone doit uniquement contenir des chiffres." );
            } else if ( telephone.length() < 4 ) {
                throw new Exception( "Le numéro de téléphone doit contenir au moins 4 chiffres." );
            }
        } else {
            throw new Exception( "Merci d'entrer un numéro de téléphone." );
        }
    }

    private void validationEmail( String email ) throws Exception {
        if ( email != null && !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
            throw new Exception( "Merci de saisir une adresse mail valide." );
        }
    }

    /*
     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
     */
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }
    
    
    
}
        

    
    
    
    


