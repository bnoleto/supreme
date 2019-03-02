package codigo;

import java.sql.Connection;
import java.util.ArrayList;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.DriverManager;
import java.sql.Statement;

import org.apache.commons.codec.digest.DigestUtils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Conexao {
        
        private String endereco_ip = null;
        private String schema = "bdsupreme2";

	private Connection conn = null;
	private String status = "";
	public boolean conectado = false;
        private String usuario = null;
        private String nome = null;
        public String url = null;
        
	public int conectar(String usuario, String senha) {
		try {
                    // condição para fazer o acesso ao servidor remoto
                    Path file = Paths.get("servidor.cfg");
                    
                    String ip_servidor = Files.readAllLines(file).get(0);
                    
                    endereco_ip = ip_servidor+":3306";
                    
                    
                    url = endereco_ip+"/"+schema;
                    
                    this.conn = DriverManager.getConnection("jdbc:mariadb://"+endereco_ip+"/?user=user&password=user");
                    
                    this.usuario = usuario;
                    String sha1 = DigestUtils.sha1Hex(senha);
                    
                    comando_sql("USE "+schema+";");
                    ArrayList<ArrayList<String>> query = retornar_query("SELECT * FROM t_pessoas WHERE pes_login = '"+usuario+"';");
                    
                    if(query.isEmpty()){
                        this.status = "Usuário inexistente!";
                        
                    }
                    else{
                        System.out.println(sha1);

                        if(sha1.equals(query.get(0).get(4))){
                            this.status = "Conexão estabelecida como "+usuario+"!";
                            this.nome = query.get(0).get(1);
                            conectado = true;
                            return 1;    
                        }
                        this.status = "Senha incorreta!";
                    }

                    conn.close();
                    return 0;
                    
		} catch(SQLException e) {
                    this.status = "Não foi possível conectar-se ao servidor.";
		} catch(Exception e) {
                    this.status = e.getMessage();
		}
		return 0;
	}
	
	public Connection getConnection() {
		return this.conn;
	}
	
	public String getStatus() {
		return this.status;
	}
        
        public String getNome() {
		return this.nome;
	}
        
        public String getUsuario(){
            return this.usuario;
        }
	
	public void comando_sql(String str) {
		try {
			Statement stm = (Statement) conn.createStatement();
			stm.execute(str);
			//System.out.println(str);
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
        
        
        
	public String retornar_valor(int cod, String coluna, String coluna_cod, String tabela) {
		try {
			Statement stm = (Statement) conn.createStatement();
			try {
				ResultSet rs = (ResultSet) stm.executeQuery("SELECT "+coluna+" FROM "+tabela+" WHERE "+coluna_cod+" = "+cod);
				rs.absolute(1);
				return rs.getString(coluna);
				                    
			} catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return "0";
	}
	
	public String retornar_ultima_celula(String tabela, String coluna) throws SQLException {
			Statement stm = (Statement) conn.createStatement();
			ResultSet rs = (ResultSet) stm.executeQuery("SELECT "+coluna+" FROM "+tabela+";");
			rs.last();
			return rs.getString(1);
	}
	
        // retornará uma matriz organizada da query str inserida
        public ArrayList<ArrayList<String>> retornar_query(String str) {
            ArrayList<ArrayList<String>> tabela = new ArrayList();
		try {
                    Statement stm = (Statement) conn.createStatement();
                    try {
                        int i = 1;
                        ResultSet rs = (ResultSet) stm.executeQuery(str);
                        while(rs.next()) {
                                try {
                                    while(rs.getString(i) != null) {
                                        i++;
                                    }
                                } catch(SQLException e){

                                }
                                ArrayList<String> registro = new ArrayList();
                                for(int j = 1; j<i; j++) {
                                    registro.add(rs.getString(j));
                                    System.out.print(rs.getString(j)+" | ");
                                }
                                tabela.add(registro);
                                System.out.println("");
                        }
                    } catch(SQLException e) {
                        System.out.println(e.getMessage());
                    }
		} catch (SQLException e) {
                    System.out.println(e.getMessage());
		}
            return tabela;
	}
        
	public void mostrar_sql(String str) {
		try {
			Statement stm = (Statement) conn.createStatement();
			try {
				int i = 1;
				ResultSet rs = (ResultSet) stm.executeQuery(str);
				while(rs.next()) {
					try {
						while(rs.getString(i) != null) {
							i++;
						}
					} catch(SQLException e){
						
					}
					for(int j = 1; j<i; j++) {
						System.out.print(rs.getString(j)+" | ");
					}
					System.out.println("");
                    
				}
			} catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
