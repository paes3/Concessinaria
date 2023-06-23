package A3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JOptionPane;;

public class venda {
	
	private int qnt = 1; 
	private String nome_cli;
	private String telefone_cli;
	private String marca;
	private String modelo;
	private String categoria;
	private double valor;
	private String  nome_fun;
	
	
	public int codigo_venda;
	
	public int getQnt() {
		return qnt;
	}

	public void setQnt(int qnt) {
		this.qnt = qnt;
	}

	public String getNome_cli() {
		return nome_cli;
	}

	public void setNome_cli(String nome_cli) {
		this.nome_cli = nome_cli;
	}

	public String getTelefone_cli() {
		return telefone_cli;
	}

	public void setTelefone_cli(String telefone_cli) {
		this.telefone_cli = telefone_cli;
	}

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

	public String getNome_fun() {
		return nome_fun;
	}

	public void setNome_fun(String nome_fun) {
		this.nome_fun = nome_fun;
	}

	public boolean fazerLogin(String cpf, String senha) {
		String sql = "SELECT * FROM funcionario WHERE fun_CPF = ? AND fun_senha = ?";
		ConectaBanco factory = new ConectaBanco();
		
		try (Connection c = factory.obtemConexao()){
			PreparedStatement ps = c.prepareStatement(sql);
            
            ps.setString(1, cpf);
            ps.setString(2, senha);
            ResultSet resultSet = ps.executeQuery();

            boolean loginSucesso = resultSet.next();           

            return loginSucesso;

            }catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
	
	public void verificar_veiculo(int VI_codigo ) throws SQLException {
		String sql = "SELECT * FROM veiculo WHERE VI_codigo = ?";
		ConectaBanco factory = new ConectaBanco();
		try (Connection c = factory.obtemConexao()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt   (1, VI_codigo);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				marca = rs.getString("VI_marca");
				modelo = rs.getString("VI_modelo");
				categoria = rs.getString("VI_categoria");
				valor = rs.getDouble("VI_valor");
			}
		}
	}
	

	public void verificar_funcionario(int fun_codigo ) throws SQLException {
		String sql = "SELECT * FROM funcionario WHERE fun_codigo = ?";
		ConectaBanco factory = new ConectaBanco();
		try (Connection c = factory.obtemConexao()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt   (1, fun_codigo);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				nome_fun = rs.getString("fun_nome");
				
			}
		}
	}
	
	public void compra_realizada(){
		String sql = "INSERT INTO venda (VEN_data, VEN_qnt, VEN_nome_cli, VEN_telefone_cli, VEN_marca, VEN_modelo, VEN_categoria, VEN_valor, VEN_nome_fun) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		ConectaBanco factory = new ConectaBanco();
		try (Connection c = factory.obtemConexao()){
	        PreparedStatement ps = c.prepareStatement(sql);
	        LocalDate dataatual = LocalDate.now();
	        ps.setObject(1, dataatual);
	        ps.setInt(2, qnt);
	        ps.setString(3, nome_cli);
	        ps.setString(4, telefone_cli);
	        ps.setString(5, marca);
	        ps.setString(6, modelo);
	        ps.setString(7, categoria);
	        ps.setDouble(8, valor);
	        ps.setString(9, nome_fun);

	        ps.execute();
		}
        catch (Exception e){
        e.printStackTrace();
        }
	}
	public void historico_vendas() throws SQLException{
		String sql = "SELECT * FROM venda";

        ConectaBanco factory = new ConectaBanco();
        try (Connection c = factory.obtemConexao()){

        PreparedStatement ps = c.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while (rs.next()){

        int codigo_venda = rs.getInt("VEN_codigo");
        qnt = rs.getInt("VEN_qnt");
        nome_cli = rs.getString("VEN_nome_cli");
        telefone_cli = rs.getString("VEN_telefone_cli");
        marca = rs.getString("VEN_marca");
        modelo = rs.getString("VEN_modelo");
        categoria = rs.getString("VEN_categoria");
        valor = rs.getDouble("VEN_valor");
        nome_fun = rs.getString("VEN_nome_fun");
        JOptionPane.showMessageDialog(null, "Codigo venda: "+ codigo_venda + "\nQuantidade: "+  qnt + "\nNome do cliente: "+ nome_cli + "\nMarca do carro: "+ marca + "\nModelo do carro: "+ modelo + "\nCategoria do carro: "+ categoria +"\nValor do carro: R$"+  valor + "\n\nNome do funcionario: "+ nome_fun);
			}
        }
	}
}

