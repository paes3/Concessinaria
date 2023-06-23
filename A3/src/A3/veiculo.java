package A3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class veiculo {
	
	private String marca; 
	private String modelo;
	private String categoria;
	private double valor;
	private int codigo;
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public void novoVeiculo (){

        String sql = "INSERT INTO veiculo (VI_Marca, VI_Modelo, VI_categoria, VI_valor, VI_codigo) VALUES (?, ?, ?, ?, ?)";
        ConectaBanco factory = new ConectaBanco();
          try (Connection c = factory.obtemConexao()){
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setString(1, marca);
        ps.setString(2, modelo);
        ps.setString(3, categoria);
        ps.setDouble(4, valor);
        ps.setInt(5, codigo);
        ps.execute();
       }
    catch (Exception e){
        e.printStackTrace();
        }
    }
	   
	public void atualizaveiculo(){

	    String sql = "UPDATE veiculo SET VI_Marca = ?, VI_Modelo = ?, VI_categoria = ?, VI_valor = ? WHERE VI_codigo = ?";


	    ConectaBanco factory = new ConectaBanco();
	    try (Connection c = factory.obtemConexao()) {
	        PreparedStatement ps = c.prepareStatement(sql);

	         ps.setString(1, marca);
	         ps.setString(2, modelo);
	         ps.setString(3, categoria);
	         ps.setDouble(4, valor);
	         ps.setInt(5, codigo);


	        ps.execute();
	         }
	     catch (Exception e){
	         e.printStackTrace();
	         }

	    }
	
	public boolean deletaveiculo(){

        String sql = "DELETE FROM veiculo WHERE VI_codigo = ?";
        ConectaBanco factory = new ConectaBanco();
        try (Connection c = factory.obtemConexao()){
        PreparedStatement ps = c.prepareStatement(sql);

        ps.setInt(1, codigo);

        int linhasAfetadas = ps.executeUpdate();

        return linhasAfetadas > 0; // Retorna true se pelo menos uma linha foi afetada
        }catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}
	public void veiculocomprado() throws SQLException {
		
		String sql = "DELETE FROM veiculo WHERE VI_codigo = ?";
        ConectaBanco factory = new ConectaBanco();
        try (Connection c = factory.obtemConexao()){
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setInt(1, codigo);
        
        ps.executeUpdate();
        }
	}
	public void listarveiculo() throws SQLException{

		String sql = "SELECT * FROM veiculo";

        ConectaBanco factory = new ConectaBanco();
        try (Connection c = factory.obtemConexao()){

        PreparedStatement ps = c.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while (rs.next()){
        codigo = rs.getInt("VI_codigo");
        marca = rs.getString("VI_marca");
        modelo = rs.getString("VI_modelo");
        categoria = rs.getString("VI_categoria");
        valor = rs.getDouble("VI_valor");
       JOptionPane.showMessageDialog(null, "codigo do veiculo: " + codigo + "\nmarca do veiculo: " + marca +  "\nmodelo do veiculo: " + modelo + "\ncategoria do veiculo: " + categoria + "\nvalor da venda: " + valor );
        	}
        }
	}
}