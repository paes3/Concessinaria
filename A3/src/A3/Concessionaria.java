package A3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.*;



public class Concessionaria extends JFrame {
	public int confirmacaovenda;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Concessionaria frame = new Concessionaria();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Concessionaria() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Novo");
		menuBar.add(mnNewMenu);
		
		JMenuItem meunuFun = new JMenuItem("Funcionario");
		meunuFun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//REGISTRO DE FUNCIONARIO definir informações "CASO 1"
	             String nome = JOptionPane.showInputDialog("Nome?");
	             String senha = JOptionPane.showInputDialog("senha?");
	             String cpf = JOptionPane.showInputDialog("CPF?");
	             funcionario f = new funcionario ();

	             //aplicar informações e chamar função novofuncionario
	             f.setNome(nome);
	             f.setSenha(senha);
	             f.setCPF(cpf);
	             f.novofuncionario();
	             JOptionPane.showMessageDialog(null, "Funcionario: " + nome + "\nCPF: " + cpf + "\nSenha: " + senha + "\n O FUNCIONARIO FOI CADASTRADO COM SUCESSO!! "); {
			}
			}});
		mnNewMenu.add(meunuFun);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Veiculo");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//caso 1

				String marca = JOptionPane.showInputDialog("Marca?");
				String modelo = JOptionPane.showInputDialog("Modelo?");
				String categoria = JOptionPane.showInputDialog("Categoria?");
				double valor = Double.parseDouble(JOptionPane.showInputDialog("valor?"));            
	
				veiculo v1 = new veiculo();

				v1.setMarca(marca);
				v1.setModelo(modelo);
				v1.setCategoria(categoria);		
				v1.setValor(valor);
				v1.novoVeiculo();
				JOptionPane.showMessageDialog(null, "O Veiculo foi cadastrado com sucesso!" + "\nMarca:" + marca + "\nModelo: " + modelo + "\nCategoria: " + categoria + "\nValor: " + valor + "R$" );
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("Editar");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Funcionario");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//caso 2 

				int    codigo = Integer.parseInt(JOptionPane.showInputDialog("Codigo?"));
				String nome = JOptionPane.showInputDialog("Nome?");
				String senha = JOptionPane.showInputDialog("Senha?");
				String cpf = JOptionPane.showInputDialog("CPF?");
				funcionario f = new funcionario();

				f.setNome(nome);
				f.setCPF(cpf);
				f.setSenha(senha);
				f.setCodigo(codigo);
				f.atualizafuncionario();
			    JOptionPane.showMessageDialog(null, "Funcionario: " + nome + "\nCPF: " + cpf + "\nSenha: " + senha  + "\n O FUNCIONARIO FOI EDITADO COM SUCESSO!! ");
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Veiculo");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				int codigo = Integer.parseInt(JOptionPane.showInputDialog("codigo?"));
				String marca = JOptionPane.showInputDialog("Marca?");
				String modelo = JOptionPane.showInputDialog("Modelo?");
				String categoria = JOptionPane.showInputDialog("Categoria?");
				double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor?"));


				veiculo v2 = new veiculo();

				v2.setMarca(marca);
				v2.setModelo(modelo);
				v2.setCategoria(categoria);
				v2.setCodigo(codigo);
				v2.setValor(valor);
				v2.atualizaveiculo();
				JOptionPane.showMessageDialog(null, "O Veiculo foi editado com sucesso!" + "\nMarca:" + marca + "\nModelo: " + modelo + "\nCategoria: " + categoria + "\nValor: " + valor + "R$" ); 

			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_2 = new JMenu("Deletar");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Funcionario");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Caso 3

		        funcionario f3 = new funcionario();
		        f3.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Código?")));
		        boolean deletado = f3.deletafuncionario();

		        if (deletado) {
		            JOptionPane.showMessageDialog(null, "O FUNCIONARIO FOI DELETADO COM SUCESSO!");
		        } else {
		            JOptionPane.showMessageDialog(null, "FUNCIONARIO NÃO EXISTE OU O CÓDIGO ESTÁ INCORRETO!!");
		        }
		    }
		});
		
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Veiculo");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				veiculo v3 = new veiculo ();
				v3.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Código?")));
		        boolean deletado = v3.deletaveiculo();

		        if (deletado) {
		            JOptionPane.showMessageDialog(null, "O VEICULO FOI DELETADO COM SUCESSO!");
		        }else {
		            JOptionPane.showMessageDialog(null, "O VEICULO NÃO EXISTE OU O CÓDIGO ESTÁ INCORRETO!!");
			}
		}});
		mnNewMenu_2.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_3 = new JMenu("Listar");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Funcionario");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				 
				funcionario f4 = new funcionario ();
				try {
					f4.listarfuncionarios();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Veiculo");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				veiculo v4 = new veiculo ();
				try {
					v4.listarveiculo();
				} catch (SQLException e1) {				
					e1.printStackTrace();
				}
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_7);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Vender");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				venda v = new venda();
				
				String cpf = JOptionPane.showInputDialog("Digite o CPF:");
				funcionario f = new funcionario();
				f.setCPF(cpf);
		        String senha = JOptionPane.showInputDialog("Digite a senha:");
		        
		        boolean loginSucesso = v.fazerLogin(cpf, senha);
		        
		        if (loginSucesso) {
		            JOptionPane.showMessageDialog(null, "Login bem-sucedido!");
		            int codigo_veiculo = Integer.parseInt(JOptionPane.showInputDialog("Codigo do veiculo"));
		            try {
						v.verificar_veiculo(codigo_veiculo);
					}catch (SQLException e1) {		
						e1.printStackTrace();
					}
		            
		            try {
						f.determinafuncionario();
					}catch (SQLException e1){
						e1.printStackTrace();
					}
		            int codigo_funcionario = f.getCodigo();          
		            try {
						v.verificar_funcionario(codigo_funcionario);
					}catch (SQLException e1) {		
						e1.printStackTrace();
					}
		            v.setNome_cli(JOptionPane.showInputDialog("Nome do Cliente"));
		            v.setTelefone_cli(JOptionPane.showInputDialog("Telefone do Cliente"));
		            confirmacaovenda = JOptionPane.showConfirmDialog(null,"confirme a venda" + "\nNome do Comprador: " + v.getNome_cli() + "\nTelefone do Comprador: " + v.getTelefone_cli() + "\nMarca do Veiculo: " + v.getMarca() + "\nModelo do carro: " + v.getModelo() + "\nCateforia do carro: "  + v.getCategoria() + "\nValor: R$" + v.getValor() + "\n\nNome do Funcionario" + v.getNome_fun());
	                  if (confirmacaovenda == 0) {
	                  v.compra_realizada();
	                  veiculo vei = new veiculo() ;
	                  try {
	                	  vei.setCodigo(codigo_veiculo);
	                	  vei.veiculocomprado();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
	                  JOptionPane.showMessageDialog(null, "Venda Realizada 🙂 obrigado pela compra" + "\n\nNome do Comprador: " + v.getNome_cli() + "\nTelefone do Comprador: " + v.getTelefone_cli() + "\nMarca do Veiculo: " + v.getMarca() + "\nModelo do carro: " + v.getModelo() + "\nCateforia do carro: "  + v.getCategoria() + "\nValor: R$" + v.getValor() + "\n\nNome do Funcionario" + v.getNome_fun());
	                  }else{
	                  JOptionPane.showMessageDialog(null, "VENDA CANCELADA");
	                  } 
		        	  }else{
		              JOptionPane.showMessageDialog(null, "Credenciais incorretas.");
		        }
			}
		});
		
		JButton btnNewButton_1 = new JButton("Histórico");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				venda v = new venda();
				try {
					v.historico_vendas();
				}catch (SQLException e1){
					e1.printStackTrace();
				}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton)
					.addGap(18)
					.addComponent(btnNewButton_1)
					.addContainerGap(240, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(185, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(21))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
