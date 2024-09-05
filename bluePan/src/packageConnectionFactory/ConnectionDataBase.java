package packageConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionDataBase {
	private final static String Driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private final static String URL = "jdbc:sqlserver://localhost:59566;encrypt=false;databaseName=teste";
	private final static String User = "sa";
	private final static String password = "senailab05";
	
	public static Connection getConnection() { 
		try {
			Class.forName(Driver);
			System.out.println("Conexão Estabelecida");
			return DriverManager.getConnection(URL, User, password); 
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Erro de conexão!",e);
		}
	}
	public static void closeConnection(Connection con) {
		try {
			if(con != null) {
			con.close();
			}
		}catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}												///PreparedStatement comando pra sql
	public static void closeConnection(Connection con, PreparedStatement stmt) {
		closeConnection(con);
		try {
			if(stmt != null) {
				stmt.close();		//seleciona e aperta "alt+shit+Z" try catch
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}																		//ResultSet recebe o resultado do banco
	public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
		closeConnection(con, stmt);
		try {
			if(rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
