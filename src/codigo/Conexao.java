package codigo;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSetInternalMethods;
import com.mysql.jdbc.Statement;
public class Conexao {
	private Connection conn = null;
	private String status = "";
	public boolean conectado = false;
	public int conectar(String usuario, String senha) {
		try {
			this.conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/?user="+usuario+"&password="+senha+"&useSSL=false");
			conectado = true;
			this.status = "-- Conexão estabelecida como "+usuario+"! --";
			return 1;
		} catch(SQLException e) {
			this.status = e.getMessage();
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
				ResultSetInternalMethods rs = (ResultSetInternalMethods) stm.executeQuery("SELECT "+coluna+" FROM "+tabela+" WHERE "+coluna_cod+" = "+cod);
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
			ResultSetInternalMethods rs = (ResultSetInternalMethods) stm.executeQuery("SELECT "+coluna+" FROM "+tabela+";");
			rs.last();
			return rs.getString(1);
	}
	
	public void mostrar_sql(String str) {
		try {
			Statement stm = (Statement) conn.createStatement();
			try {
				int i = 1;
				ResultSetInternalMethods rs = (ResultSetInternalMethods) stm.executeQuery(str);
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
