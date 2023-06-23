package A3;
import java.sql.*;
public class ConectaBanco {
    
    private String usuario = "root";
    private String senha = "root";
    private String host = "127.0.0.1";
    private String porta = "3306";
    //private String bd = "db_pessoas";
    private String bd = "modelo_fisico";    
    public Connection obtemConexao (){
        try{
            Connection c = DriverManager.getConnection(
                "jdbc:mysql://" + host + ":" + porta + "/" + bd,
                usuario,
                senha
            );
            return c;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
