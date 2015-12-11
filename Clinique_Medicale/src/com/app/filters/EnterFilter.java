package com.app.filters;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.app.beans.Patient;
import com.app.dao.DAOException;
import com.app.dao.DAOFactory;
import com.app.dao.PatientDao;
public class EnterFilter implements Filter {
	
public static final String ATT_SESSION_CLIENTS = "clients";
public static final String CONF_DAO_FACTORY= "daofactory";
public static final String COOKIE_ID_USER = "idpatient";
public static final String ATT_SESSION_USER = "sessionPatient";
public static final String VUE_CONNEXION = "/connexionPatient";
private PatientDao patientDao;
@Override
public void init(FilterConfig config) throws ServletException {
	this.patientDao = ( (DAOFactory) config.getServletContext().getAttribute( CONF_DAO_FACTORY )).getPatientDao();
	
}

public void doFilter( ServletRequest req, ServletResponse res,
FilterChain chain ) throws IOException,
ServletException {
	
Patient patient = new Patient();
HttpSession session = ((HttpServletRequest) req).getSession();

if(getCookieValue(req,COOKIE_ID_USER) != null && session.getAttribute(ATT_SESSION_USER) != null){
	chain.doFilter( req, res );
}
else{
	req.getRequestDispatcher( VUE_CONNEXION ).forward(req, res );
}
	
/* Pour terminer, poursuite de la requête en cours */
}
public void destroy() {
}

private static String getCookieValue(ServletRequest request, String nom) {
	Cookie[] cookies = ((HttpServletRequest) request).getCookies();
	if (cookies != null) {
		for (Cookie cookie : cookies) {
			if (cookie != null && nom.equals(cookie.getName())) {
				return cookie.getValue();
			}
		}
	}
	return null;
}

}