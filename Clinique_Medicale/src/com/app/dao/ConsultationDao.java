package com.app.dao;

import com.app.beans.Consultation;
public interface ConsultationDao {
void creer( Consultation consutation ) throws DAOException;
Consultation trouver( Long ID ) throws DAOException;
void supprimer(Consultation consultation)throws DAOException;
}