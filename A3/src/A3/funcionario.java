package A3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class funcionario {

	private String senha;
	private String cpf;
	private String nome;
	private int codigo;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getCPF() {
		return cpf;
	}
	public void setCPF(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
		public void novofuncionario (){

			String sql = "INSERT INTO funcionario (fun_nome, fun_senha, fun_cpf) VALUES (?, ?, ?)";
            ConectaBanco factory = new ConectaBanco();
        try (Connection c = factory.obtemConexao()){
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setString(1, nome);
        ps.setString(2, senha);
        ps.setString(3, cpf);

        ps.execute();
        }
        catch (Exception e){
        e.printStackTrace();
        	}
       } 
	
		public void atualizafuncionario(){

			 String sql = "UPDATE funcionario SET fun_senha = ?, fun_cpf = ?, fun_nome = ? WHERE fun_codigo = ?";


			    ConectaBanco factory = new ConectaBanco();
			    try (Connection c = factory.obtemConexao()) {
			        PreparedStatement ps = c.prepareStatement(sql);

			         ps.setString(1, senha);
			         ps.setString(2, cpf);
			         ps.setString(3, nome);
			         ps.setInt(4, codigo);


			        ps.execute();
			         }
			     catch (Exception e){
			         e.printStackTrace();
			         }
			    } 

		public boolean deletafuncionario() {
		    String sql = "DELETE FROM funcionario WHERE fun_codigo = ?;";
		    ConectaBanco factory = new ConectaBanco();

		    try (Connection c = factory.obtemConexao()) {
		        PreparedStatement ps = c.prepareStatement(sql);
		        ps.setInt(1, codigo);
		        int linhasAfetadas = ps.executeUpdate();

		        return linhasAfetadas > 0; // Retorna true se pelo menos uma linha foi afetada
		        }catch (Exception e) {
		        e.printStackTrace();
		        return false;
		    }
		}
		public void listarfuncionarios() throws SQLException{
			
		         String sql = "SELECT * FROM funcionario";

		         ConectaBanco factory = new ConectaBanco();
		         try (Connection c = factory.obtemConexao()){

		         PreparedStatement ps = c.prepareStatement(sql);

		         ResultSet rs = ps.executeQuery();

		         while (rs.next()){
		         int codigo = rs.getInt("fun_codigo");
		         nome = rs.getString("fun_nome");
		         cpf = rs.getString("fun_cpf");
		         senha = rs.getString("fun_senha");
		         JOptionPane.showMessageDialog(null, "codigo: " + codigo + "\nnome: " + nome + "\nCPF: " + cpf + "\nsenha: " + senha);
            } 
		 }
	}
		public void determinafuncionario() throws SQLException {
			String sql = "SELECT * FROM funcionario WHERE fun_CPF = ?";

	         ConectaBanco factory = new ConectaBanco();
	         try (Connection c = factory.obtemConexao()){

	         PreparedStatement ps = c.prepareStatement(sql);
	         ps.setString(1, cpf);
	         ResultSet rs = ps.executeQuery();

	         while (rs.next()){
	         codigo = rs.getInt("fun_codigo");
	         nome = rs.getString("fun_nome");
	         cpf = rs.getString("fun_CPF");
	         senha = rs.getString("fun_senha");
	         	}
	         }
	     }
	}