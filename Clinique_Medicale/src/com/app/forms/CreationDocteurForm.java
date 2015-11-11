package com.app.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.app.beans.Docteur;

public class CreationDocteurForm {
	
    private static final String CHAMP_CHOIX_DOCTEUR     = "choixNouveauDocteur";
	private static final String CHAMP_NOM               = "nomDocteur";
    private static final String CHAMP_PRENOM            = "prenomDocteur";
    private static final String CHAMP_ADRESSE           = "adresseDocteur";
    private static final String CHAMP_TELEPHONE         = "telephoneDocteur";
    private static final String CHAMP_EMAIL             = "emailDocteur";
    private static final String ANCIEN_DOCTEUR         = "ancienDocteur";
    private static final String CHAMP_LISTE_DOCTEURS    = "listeDocteurs";
    private static final String SESSION_DOCTEURS        = "docteurs";
    private static final String CHAMP_IDENTIFIANT      = "identifiantDocteur";


 
    private String              resultat;
    private Map<String, String> erreurs        = new HashMap<String, String>();

    public Map<String, String> getErreurs() {
    return erreurs;
    										}
    
    public String getResultat() {
        return resultat;
    }
    
    
    
    public Docteur creerDocteur ( HttpServletRequest request ) {
    	
    	
        String choixNouveauDocteur = getValeurChamp( request, CHAMP_CHOIX_DOCTEUR );
        
        if ( ANCIEN_DOCTEUR.equals( choixNouveauDocteur ) ) {
            /* Récupération du nom du client choisi */
            String nomAncienDocteur = getValeurChamp( request, CHAMP_LISTE_DOCTEURS );
            /* Récupération de l'objet client correspondant dans la session */
            HttpSession session = request.getSession();
            Docteur docteur = ( (Map<String, Docteur>) session.getAttribute( SESSION_DOCTEURS ) ).get( nomAncienDocteur ); 
            
            return docteur;
        }
        
        else {
    	
        String nom = getValeurChamp( request, CHAMP_NOM );
        String prenom = getValeurChamp( request, CHAMP_PRENOM );
        String adresse = getValeurChamp( request, CHAMP_ADRESSE );
        String telephone = getValeurChamp( request, CHAMP_TELEPHONE );
        String email = getValeurChamp( request, CHAMP_EMAIL );
        String identifiant = getValeurChamp( request, CHAMP_IDENTIFIANT );
    
        
        Docteur docteur = new Docteur();
        
        try {
            validationNom( nom );
        } catch ( Exception e ) {
            setErreur( CHAMP_NOM, e.getMessage() );
        }
        docteur.setNom( nom );

        try {
            validationPrenom( prenom );
        } catch ( Exception e ) {
            setErreur( CHAMP_PRENOM, e.getMessage() );
        }
        docteur.setPrenom( prenom );

        try {
            validationAdresse( adresse );
        } catch ( Exception e ) {
            setErreur( CHAMP_ADRESSE, e.getMessage() );
        }
        docteur.setAdresse( adresse );

        try {
            validationTelephone( telephone );
        } catch ( Exception e ) {
            setErreur( CHAMP_TELEPHONE, e.getMessage() );
        }
        docteur.setTelephone( telephone );

        try {
            validationEmail( email );
        } catch ( Exception e ) {
            setErreur( CHAMP_EMAIL, e.getMessage() );
        }
        docteur.setEmail( email );
        
        try {
            validationIdentifiant( identifiant );
        } catch ( Exception e ) {
            setErreur( CHAMP_IDENTIFIANT, e.getMessage() );
        }
        docteur.setEmail( email );
        
      
        

        if ( erreurs.isEmpty() ) {
            resultat = "Succès de la création du client.";
        } else {
            resultat = "Échec de la création du client.";
        }

        return docteur; }
        
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

    
    private void validationIdentifiant( String identifiant ) throws Exception {
        if ( identifiant != null ) {
            if ( !identifiant.matches( "^\\d+$" ) ) {
                throw new Exception( "Le numéro RPPS doit uniquement contenir des chiffres." );
            } else if ( identifiant.length() != 11 ) {
                throw new Exception( "Le numéro RPPS doit contenir 11 chiffres." );
            }
        } else {
            throw new Exception( "Merci d'entrer un identifiant." );
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
        

    
   