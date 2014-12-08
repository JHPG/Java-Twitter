package entidade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;


public class Mensagem {
    
    int id;
    String login, mensagem, hora;
    
    public Mensagem(int id, String login, String mensagem, String hora) {
        this.id = id;
        this.login = login;
        this.mensagem = mensagem;
        this.hora = hora;
    }

    //Por classe dá para adicionar a opção de "editar mensagem" depois, se necessário (Setters)
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    public String insereEmoticons(){
        String dir = "emoticons/";
        String res = this.mensagem;
        
        //Substitui para exibir
        res = res.replace(".v.", "<img src='"+ dir + "deOlho.gif' alt='' />");
        res = res.replace(":D", "<img src='"+ dir + "sorriso.gif' alt='' />");
        res = res.replace(":(", "<img src='"+ dir + "triste.gif' alt='' />");
        res = res.replace("^D", "<img src='"+ dir + "img2.gif' alt='' />");     

        return res;
    }
}
