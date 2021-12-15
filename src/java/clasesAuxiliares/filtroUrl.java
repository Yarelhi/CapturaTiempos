/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesAuxiliares;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ROMERO0
 */
public class filtroUrl implements PhaseListener {

    @Override
    public void afterPhase(PhaseEvent event) {
        FacesContext facesContext = event.getFacesContext();
        
        //Capturamos el nombre de la pagina actual
        String currentPage= facesContext.getViewRoot().getViewId();
        
        //creamos una variable boleana para si es la pagina del login la que se capturo
        boolean isPageLogin= currentPage.lastIndexOf("Login.xhtml") > -1 ? true  : false;
        
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        //recuperamos un object del String que se guardo, para ello de toma se la sesion al usuario que se definio en el login bean
        Object usuario = session.getAttribute("usuario");
        
        if (!isPageLogin && usuario==null) {//si no es la pagina de login y el usuario es nulo , lo dirigimos a la pagina
            NavigationHandler nHandler = facesContext.getApplication().getNavigationHandler();
            nHandler.handleNavigation(facesContext,null,"/Login");
            
            
        }
    }

    @Override
    public void beforePhase(PhaseEvent event) {
        
    }

    @Override
    public PhaseId getPhaseId() {
       return PhaseId.RESTORE_VIEW;
    }
    
}
