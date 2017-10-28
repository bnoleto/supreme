package telas;

import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.*;

import codigo.Conexao;
import codigo.Menus;

import java.awt.*;
import java.awt.event.*;
import java.awt.Window.Type;
public class LoginAntigo extends javax.swing.JFrame {
	
	private JFrame tela_login;
	private JTextField campo_usuario;
	private JPasswordField campo_senha;

	public static void main(String[] args) {
            
                /* Set the System look and feel */
                //<editor-fold defaultstate="collapsed" desc=" Configurações do design do botão (design do sistema) ">
                /* For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
                 */
                try {
                    javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
                    java.util.logging.Logger.getLogger(LoginAntigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                //</editor-fold>
		LoginAntigo autenticacao = new LoginAntigo();
		autenticacao.tela_login.setVisible(true);
	}
	
	public int execucao(String usuario, char[] senha) throws NumberFormatException, SQLException {
		Conexao conn = new Conexao();
		conn.conectar(usuario, senha);
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println(conn.getStatus());
		Scanner entrada = new Scanner(System.in);
		
		if(conn.conectado) {
			Menus menu = new Menus();
			int opcao = 0;
			tela_login.dispose();
			
			conn.comando_sql("USE bdsupreme2;");
			
			do {
				System.out.println("\n=== S U P R E M E (versão console de teste) ===\n");
				System.out.println("  1 - Novo pedido");
				System.out.println("  2 - Cadastrar cliente");
				System.out.println("  3 - Cadastrar produto");
				System.out.println("  8 - Trocar de usuário");
				System.out.println("  9 - Sair");
				System.out.print("> ");
				opcao = entrada.nextInt();
				switch(opcao) {
					case(1):
						menu.novoPedido(conn);
						break;
					case(8):
						try {
							conn.getConnection().close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
						System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
						System.out.println("-- Conexão ao banco de dados encerrada! --");
						LoginAntigo autenticacao = new LoginAntigo();
						autenticacao.tela_login.setVisible(true);
						return 1;
				}
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			} while(opcao != 9);
			try {	// encerramento da conexão
				conn.getConnection().close();
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				System.out.println("-- Conexão ao banco de dados encerrada! --");
				System.out.println("Seu computador já pode ser desligado com segurança.");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 1;
		}
		
		return 0;
		
	}
	
	public LoginAntigo(){
		Dimension resolucao = Toolkit.getDefaultToolkit().getScreenSize();
		int altura = (int)resolucao.getHeight();
		int largura = (int)resolucao.getWidth();
		int tamanhoX = 311;
		int tamanhoY = 200;
		
		tela_login = new JFrame();
		tela_login.setResizable(false);
		tela_login.setType(Type.POPUP);
		tela_login.setTitle("SUPREME v0.1-alpha");
		tela_login.setBounds((largura-tamanhoX)/2,(altura-tamanhoY)/2 , tamanhoX, tamanhoY);
		tela_login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel titulo = new JPanel();
		titulo.setForeground(new Color(255, 255, 255));
		titulo.setBackground(new Color(0, 0, 128));
		tela_login.getContentPane().add(titulo, BorderLayout.NORTH);
		
		Label label = new Label("Autentica\u00E7\u00E3o de Usu\u00E1rio");
		label.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		label.setAlignment(Label.CENTER);
		titulo.add(label);
		
		Panel conteudo = new Panel();
		tela_login.getContentPane().add(conteudo, BorderLayout.CENTER);
		conteudo.setLayout(new BorderLayout(0, 0));
		
		Component verticalStrut = Box.createVerticalStrut(20);
		conteudo.add(verticalStrut, BorderLayout.NORTH);
		
		Panel panel = new Panel();
		conteudo.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio");
		lblUsurio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsurio.setBounds(34, 14, 86, 14);
		panel.add(lblUsurio);
		
		campo_usuario = new JTextField();
		campo_usuario.setBounds(124, 11, 86, 20);
		panel.add(campo_usuario);
		campo_usuario.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSenha.setBounds(34, 40, 86, 14);
		panel.add(lblSenha);
		
		JLabel caixa_msg = new JLabel("");
		caixa_msg.setHorizontalAlignment(SwingConstants.CENTER);
		conteudo.add(caixa_msg, BorderLayout.SOUTH);
		
		campo_senha = new JPasswordField();
		campo_senha.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						if(execucao(campo_usuario.getText(), campo_senha.getPassword()) == 0) {
							caixa_msg.setForeground(Color.RED);
							caixa_msg.setText("Usuário/senha incorretos!");
						}
					} catch (NumberFormatException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}					
				}
			}
		});
		campo_senha.setBounds(124, 37, 86, 20);
		panel.add(campo_senha);
		
		
		Panel botoes = new Panel();
		botoes.setBackground(new Color(0, 0, 128));
		tela_login.getContentPane().add(botoes, BorderLayout.SOUTH);
		
		JButton bt_login = new JButton("Realizar login");
		bt_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					execucao(campo_usuario.getText(), campo_senha.getPassword());
				} catch (NumberFormatException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		botoes.add(bt_login);
		
		JButton bt_cancelar = new JButton("Cancelar");
		bt_cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tela_login.dispose();
			}
		});
		botoes.add(bt_cancelar);
	}
}
