package listeners;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.SendResult;

import model.Usuario;

import dao.DAOUsuario;

/**
 * Application Lifecycle Listener implementation class AdicionaAdministrador
 *
 */
@WebListener
public class AdicionaAdministrador implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public AdicionaAdministrador() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event) {
     
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("condominio");
    	DAOUsuario dao = new DAOUsuario();
    	   	
    	List<Usuario> usuarios = new ArrayList<Usuario>();
    	usuarios = dao.findAll();
    	
    	if(usuarios.isEmpty())System.out.println("Nenhum usuário");
    	
      	/*Usuario usuario = usuarios.get(0);
    	int id = usuario.getId();
    	
    	dao.findById(id);
    	dao.close();*/
    	
    }

		
		
      	
    	
    	
    	
   

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent event) {
        // TODO Auto-generated method stub
    }
	
}
