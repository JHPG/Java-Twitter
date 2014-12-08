package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Conexao {
        
        Connection conexao;
    
	public PreparedStatement conectar(String sql) throws SQLException
        {
            conexao = DriverManager.getConnection("jdbc:derby://localhost:1527//BD_MackTwitter","root","1234");

            PreparedStatement stmt = conexao.prepareStatement(sql);
            return stmt;
	}

	public void close() throws SQLException
        {
            conexao.close();		
	}

}
