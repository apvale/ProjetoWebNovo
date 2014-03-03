package controller;

import java.io.IOException;
import java.util.Date;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Administrador;
import model.Condomino;
import model.Veiculo;
import dao.DAOAdministrador;
import dao.DAOCondomino;


@WebServlet("/AdministradorCadastroServlet")
public class AdministradorCadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AdministradorCadastroServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("condominio");
		DAOAdministrador dao = new DAOAdministrador();
		int type = 1;
		String message = "";
		
		// Condominio
		String nome = request.getParameter("nome").trim();
		String inquilino = request.getParameter("inquilino").trim();
		String email = request.getParameter("email").trim();
		Integer apto = Integer.parseInt(request.getParameter("apto"));
		Integer telefone = Integer.parseInt(request.getParameter("telefone").replace("-", ""));
		Integer moradores = Integer.parseInt(request.getParameter("moradores"));
		
		// Veiculo
		String placa = request.getParameter("placa").trim();
		String modelo = request.getParameter("modelo").trim();
		String cor = request.getParameter("cor").trim();
		String marca = request.getParameter("marca").trim();
		
		if (dao.findByEmail(email) != null) {
			message = "E-mail em uso";
		} else {
			type = 0;
			message = "Seu cadastro foi concluido com sucesso, aguarde um email com a validação da sua conta!";
			
			Veiculo v = new Veiculo();
			v.setPlaca(placa);
			v.setMarca(marca);
			v.setCor(cor);
			v.setModelo(modelo);
			
			Administrador a = new Administrador();
			a.setUsuario("apto" + apto);
			a.setData(new Date());
			a.setNome(nome);
			a.setInquilino(inquilino);
			a.setApto(apto);
			a.setTelefone(telefone);
			a.setEmail(email);
			a.setMoradores(moradores);
			a.setVeiculo(v);
			v.setVeiculo(a);
			
			dao.begin();
			dao.persist(a);
			dao.commit();
			dao.close();
		}
		
		request.setAttribute("type", type);
		request.setAttribute("message", message);
		request.getRequestDispatcher("/inicio.jsp").forward(request, response);
	}
	}


