package servlet;

import dao.MensagensDAO;
import controller.Command;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "EscreveMensagem", urlPatterns = {"/EscreveMensagem"})
public class EscreveMensagem extends HttpServlet implements Command{
	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	 * methods.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException,SQLException {
		
	} 
	
        @Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
            try {
                response.setContentType("text/html;charset=UTF-8");
                
                HttpSession session = request.getSession(true);
                
                String login = (String)session.getAttribute("login");
                String nome = (String)session.getAttribute("nome");
                String mensagem = request.getParameter("txtMensagem");;
                
                if(mensagem.trim() != ""){
                    mensagem = mensagem.replace("\n", "<br/>");      // Quebra de linha na TextArea

                    MensagensDAO dao = new MensagensDAO();
                    dao.inserirMensagem(login, nome, mensagem);
                }
                
                response.sendRedirect("Mensagens.jsp");
                       
            } catch (SQLException ex) {
                Logger.getLogger(EscreveMensagem.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            try {
                processRequest(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(EscreveMensagem.class.getName()).log(Level.SEVERE, null, ex);
            }
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            try {
                processRequest(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(EscreveMensagem.class.getName()).log(Level.SEVERE, null, ex);
            }
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
