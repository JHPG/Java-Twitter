/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controller.Command;
import dao.UsuarioDAO;
import entidade.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 31386210
 */
@WebServlet(name = "LogarUser", urlPatterns = {"/LogarUser"})
public class LogarUser extends HttpServlet implements Command{

	/**
	 * Processes requests for both HTTP
	 * <code>GET</code> and
	 * <code>POST</code> methods.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
				
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
                        throws ServletException, IOException {
		
            try {
                String usuario = request.getParameter("usuario");
                String senha = request.getParameter("senha");
                String checkbox = request.getParameter("lembrar");
                
                UsuarioDAO dao = new UsuarioDAO();
                
                Usuario resultado = dao.getPorLogin(usuario,senha);
                
                if((checkbox != null)){
                    Cookie login = new Cookie("lembrarUsuario", usuario);
                    login.setMaxAge(60*60);
                    response.addCookie(login);
                }
                
                
                if(resultado == null){
                    response.sendRedirect("Login.jsp");
                }
                else if(resultado.getSenha().equals(senha)){
                    
                    HttpSession session = request.getSession(true);
                    session.setAttribute("login", resultado.getLogin());
                    session.setAttribute("nome", resultado.getNome());
                    session.setAttribute("senha", resultado.getSenha());
                    try{
                        //ServletContext context = getServletContext();
                        ServletContext context = request.getSession().getServletContext();
                        
                        if(context != null){
                            if (context.getAttribute("nUsers") == null){
                                context.setAttribute("nUsers", 1);
                            } else {
                                int nUsers = (int) context.getAttribute("nUsers");
                                context.setAttribute("nUsers", (nUsers+1) );
                            }
                        }else{
                            context.setAttribute("nUsers", 1);
                        }
                    }catch(Exception e){
                        //e.getMessage();
                    }
                    response.sendRedirect("Home.jsp");
                    
                }else{
                    response.sendRedirect("Login.jsp");
                }
            } catch (SQLException ex) {
                Logger.getLogger(LogarUser.class.getName()).log(Level.SEVERE, null, ex);
            }
		
	}





	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	/**
	 * Handles the HTTP
	 * <code>GET</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP
	 * <code>POST</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>


}
