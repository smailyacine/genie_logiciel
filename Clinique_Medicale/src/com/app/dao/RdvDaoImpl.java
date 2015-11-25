package com.app.dao;
import static com.app.dao.DAOUtilitaire.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import org.joda.time.DateTime;

import com.app.dao.DAOException;
import com.app.beans.Consultation;
import com.app.beans.Creneau;
import com.app.beans.Docteur;
import com.app.beans.Patient;
import com.app.beans.Rdv;

public class RdvDaoImpl implements RdvDao {
/* Implémentation de la méthode trouver() définie dans
l'interface UtilisateurDao */
	private static final String SQL_INSERT_DOCTEUR = "insert into p_cliniuqe.rdv (id_docteur,idslot) VALUES(?,?)";
	private static final String SQL_SELECT_RDV_PAR_DOCTEUR = "SELECT * FROM p_cliniuqe.rdv as R inner join p_cliniuqe.docteur as D "
			+ "on R.id_docteur = D.identifiant  inner join  p_cliniuqe.patient as P on R.id_patient = P.num_assurance "
			+ "inner join p_cliniuqe.slot as S on R.idslot = S.idslot "
			+ "where R.id_docteur = ? and date(rdvTime) =? and isreserved = 0;";
	private static final String SQL_INSERT_PATIENT = "update p_cliniuqe.rdv SET id_patient = ? , isreserved = 1 where id_docteur = ? and "
			+ "date(rdvTime) = ? and idslot = ?";
private DAOFactory daoFactory;
RdvDaoImpl( DAOFactory daoFactory ) {
this.daoFactory = daoFactory;
}

public ArrayList<Creneau> trouverRdv( String docteur_identifiant,String date) throws DAOException {
Connection connexion = null;
PreparedStatement preparedStatement = null;
ResultSet resultSet = null;
ArrayList<Creneau> slot = new ArrayList<Creneau>();
/* Récupération d'une connexion depuis la Factory */
try{
connexion = daoFactory.getConnection();
preparedStatement = initialisationRequetePreparee( connexion,SQL_SELECT_RDV_PAR_DOCTEUR, false, docteur_identifiant, date);
resultSet = preparedStatement.executeQuery();
/* Parcours de la ligne de données de l'éventuel ResulSet
retourné */
while ( resultSet.next() ) {
slot.add(map_slot( resultSet ));
}
} catch ( SQLException e ) {
throw new DAOException( e );
} finally {
fermeturesSilencieuses( resultSet, preparedStatement, connexion );
}
return slot;
}


/* Implémentation de la méthode définie dans l'interface
UtilisateurDao */
@Override
public void creerRdv_docteur(String identifiant_docteur,int  id_creneau) throws DAOException {
Connection connexion = null;
PreparedStatement preparedStatement = null;
ResultSet valeursAutoGenerees = null;
try {
/* Récupération d'une connexion depuis la Factory */
connexion = daoFactory.getConnection();
preparedStatement = initialisationRequetePreparee( connexion,SQL_INSERT_DOCTEUR, false ,identifiant_docteur,id_creneau);
int statut = preparedStatement.executeUpdate();
/* Analyse du statut retourné par la requête d'insertion */
if ( statut == 0 ) {
throw new DAOException( "Échec de la création de l'utilisateur, aucune ligne ajoutée dans la table." );
}
/* Récupération de l'id auto-généré par la requête
d'insertion */
//valeursAutoGenerees = preparedStatement.getGeneratedKeys();
//if ( valeursAutoGenerees.next() ) {
/*Puis initialisation de la propriété id du bean
Utilisateur avec sa valeur */
//consultation.setID(valeursAutoGenerees.getLong( 1 ) );}
// else {
//throw new DAOException( "Échec de la création de l'utilisateur en base, aucun ID auto-généré retourné." );
//}
} catch ( SQLException e ) {
throw new DAOException( e );
} finally {
fermeturesSilencieuses( valeursAutoGenerees, preparedStatement,
connexion );
}
}

@Override
public void updateRdv_patient(String id_patient,Creneau creneau,String date) throws DAOException {
Connection connexion = null;
PreparedStatement preparedStatement = null;
ResultSet valeursAutoGenerees = null;
try {
/* Récupération d'une connexion depuis la Factory */
connexion = daoFactory.getConnection();
preparedStatement = initialisationRequetePreparee( connexion,SQL_INSERT_PATIENT, false ,id_patient,creneau.getIdentifiantdocteur(),date,creneau.getId() );
int statut = preparedStatement.executeUpdate();
/* Analyse du statut retourné par la requête d'insertion */
if ( statut == 0 ) {
throw new DAOException( "Échec de la création de l'utilisateur, aucune ligne ajoutée dans la table." );
}
/* Récupération de l'id auto-généré par la requête
d'insertion */
//valeursAutoGenerees = preparedStatement.getGeneratedKeys();
//if ( valeursAutoGenerees.next() ) {
/*Puis initialisation de la propriété id du bean
Utilisateur avec sa valeur */
//consultation.setID(valeursAutoGenerees.getLong( 1 ) );}
// else {
//throw new DAOException( "Échec de la création de l'utilisateur en base, aucun ID auto-généré retourné." );
//}
} catch ( SQLException e ) {
throw new DAOException( e );
} finally {
fermeturesSilencieuses( valeursAutoGenerees, preparedStatement,
connexion );
}
}

}