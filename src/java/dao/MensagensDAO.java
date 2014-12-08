package dao;

import entidade.Mensagem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MensagensDAO {
	
	public List getMensagens(String order) throws SQLException{
		try{
                        String orderF = order;
			Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527//BD_MackTwitter","root","1234");
                        
                        if( "".equals(order) || "null".equals(order) || order == null){
                            orderF = "ID";
                        }
                        if(! "ID".equals(order)){   //Diferente de ID
                            orderF += ", ID";
                        }
                        String sql= "select * from Mensagens order by " + orderF + " ASC ";
                        
                                
			if("influ".equals(order)){
                            sql= "select * from Mensagens order by " + "ID" + " ASC ";  //Para n dar erro até implantar
                            
                            //select count(login) from mensagens where login = logindomaluco
                            
                        }
                        
			PreparedStatement stmt2 = conexao.prepareStatement(sql);

//			Conexao conn = new Conexao();
//			String sql= "select * from Mensagens";
//			PreparedStatement stmt = conn.conectar(sql);

			ResultSet rs = stmt2.executeQuery();
			List <Mensagem> msgLista = new ArrayList();

			while(rs.next()){
				//Cria objeto mensagem
				String hora = rs.getString("hora");
				String login = rs.getString("login");
				String mensagem = rs.getString("texto");
                                int id = rs.getInt("id");
                                
				Mensagem msg = new Mensagem(id, login, mensagem, hora);
				msgLista.add(msg);
			}
			return msgLista;
			
		} catch(SQLException e){
			return null;
		}
	}
        
        public void inserirMensagem(String login, String nome, String mensagem) throws SQLException{
            
                Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527//BD_MackTwitter","root","1234");
                String sql = "insert into mensagens ( login  , nome , texto  ,hora) Values(?,?,?,?)";
                PreparedStatement stmt = conexao.prepareStatement(sql);
                
                String hora = new Date().toString();
                
                stmt.setString(1, login);
                stmt.setString(2, nome);
                stmt.setString(3, mensagem);
                stmt.setString(4, hora);
                
                try{
                    stmt.execute(); 
                }finally{
                    stmt.close();
                }
        }
        
        public void editarMensagem(String id) throws SQLException{
            
            //qdo gera lista, armazena a id. No botao editar, mandará para cá
            
        }
        
	public void excluirMensagem(String id) throws SQLException{
            
            //qdo gera lista, armazena a id. No botao editar, mandará para cá
            
        }
}
