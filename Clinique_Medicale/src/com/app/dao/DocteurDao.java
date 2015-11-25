package com.app.dao;

import java.util.ArrayList;
import java.util.List;

import com.app.beans.Docteur;
public interface DocteurDao {
void creer( Docteur docteur ) throws DAOException;
void supprimer(Docteur docteur)throws DAOException;
ArrayList<Docteur> lister_docteurs() throws DAOException;
Docteur trouverID( String identifiant ) throws DAOException;
Docteur trouverEmail( String email ) throws DAOException;
Docteur trouverEmailPasse(String email, String motDePasse)throws DAOException;
ArrayList<Docteur> trouverSpecialite(String specialite) throws DAOException;

// penser à mettre Lister()
}