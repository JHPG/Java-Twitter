package dao;

import entidade.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
	public static void main (String[] args) throws SQLException{
		System.out.println(System.getProperty("java.home"));  
	}
	public static Usuario getPorLogin(String login, String senha) throws SQLException{

		//Conexao
		Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527//BD_MackTwitter","root","1234");
		String sql = "Select * from usuarios where login = ? and senha = ?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		
//		Conexao conn = new Conexao();
//		String sql = "Select * from usuarios where login = ? and senha = ?";
//		PreparedStatement stmt = conn.conectar(sql);


		stmt.setString(1, login);
		stmt.setString(2, senha);

		ResultSet rs = stmt.executeQuery();
		// stmt.close();
		boolean a = rs.next();
		String nomeX="",loginX="", senhaX="";
		if (a){
		 nomeX = rs.getString("nome");
		 loginX = rs.getString("login");
		 senhaX = rs.getString("senha");
		}
		rs.close();

		conexao.close();
		//conn.close();
		
		
		if(loginX.equals(login) && senhaX.equals(senha)){
			Usuario user = new Usuario();
			user.setLogin(loginX);
			user.setSenha(senhaX);
			user.setNome(nomeX);

			System.out.println(user.getLogin()+" "+user.getNome()+" "+ user.getSenha());
			return user;
		}
		else{
			return null;
		}
	}

	
}

