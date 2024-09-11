package packageControler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import packageConnectionFactory.ConnectionDataBase;
import packageModel.Vendedor;




public class VendedorDAO {

	public ArrayList<Vendedor> read() {

		Connection con = ConnectionDataBase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Vendedor> vendedor = new ArrayList<>();

		try {
			stmt = con.prepareStatement("SELECT * FROM vendedor");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Vendedor c = new Vendedor();
				c.setId_Vendedor(rs.getString(1));
				c.setNome(rs.getString(2));
				c.setCPF(rs.getString(3));
				c.setEmail(rs.getString(4)); // select manual
				c.setTelefone(rs.getString(5));
				c.setData_nasc(rs.getString(6));
				c.setData_cont(rs.getString(7));
				c.setTotal_vend(rs.getString(8));
				c.setEndereco(rs.getString(9));

				vendedor.add(c);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDataBase.closeConnection(con, stmt, rs);
		}
		return vendedor;

	}

	public void create(Vendedor c) {
		Connection con = ConnectionDataBase.getConnection();
		PreparedStatement stmt = null;

		try {
																//Password não pode passar
			stmt = con.prepareStatement("INSERT INTO vendedor(nome,CPF, email, telefone, data_nasc, data_cont, total_vend, endereco) VALUES(?,?,?,?,?,?,?,?)");
			
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getCPF());
			stmt.setString(3, c.getEmail());
			stmt.setString(4, c.getTelefone());
			stmt.setString(5, c.getData_nasc());
			stmt.setString(6, c.getData_cont());
			stmt.setString(7, c.getTotal_vend());
			stmt.setString(8, c.getEndereco());
		
			

			stmt.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDataBase.closeConnection(con, stmt);
		}
	}

	public void update(Vendedor cl) {
		Connection con = ConnectionDataBase.getConnection();
		PreparedStatement stmt = null;

		try {

			stmt = con.prepareStatement("UPDATE vendedor SET nome = ?, CPF = ?, email = ?, telefone =?, data_nasc = ?, data_cont = ?, total_vend = ?, endereco = ? WHERE CPF = ?");
			stmt.setString(1, cl.getNome());
			stmt.setString(2, cl.getCPF());
			stmt.setString(3, cl.getEmail());
			stmt.setString(4, cl.getTelefone());
			stmt.setString(5, cl.getData_nasc());
			stmt.setString(6, cl.getData_cont());
			stmt.setString(7, cl.getTotal_vend());
			stmt.setString(8, cl.getEndereco());
			stmt.setString(9, cl.getCPF());
			

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDataBase.closeConnection(con, stmt);
		}
	}

	public void delete(String cpf) {
		Connection con = ConnectionDataBase.getConnection();
		PreparedStatement stmt = null;

		try {

			stmt = con.prepareStatement("DELETE FROM vendedor where CPF = ?");
			stmt.setString(1, cpf);
			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDataBase.closeConnection(con, stmt);
		}
	}
	public Vendedor altenticarUser(String User, String password) {
		
		
		Connection con = ConnectionDataBase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		Vendedor vendedor = new Vendedor();

		try {
			stmt = con.prepareStatement("SELECT * FROM vendedor WHERE Password = ? AND CPF = ? or email = ?");
			stmt.setString(1, password);
			stmt.setString(2, User);
			stmt.setString(3, User);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Vendedor c = new Vendedor();
				c.setId_Vendedor(rs.getString(1));
				c.setNome(rs.getString(2));
				c.setCPF(rs.getString(3));
				c.setEmail(rs.getString(4)); // select manual
				c.setTelefone(rs.getString(5));
				c.setData_nasc(rs.getString(6));
				c.setData_cont(rs.getString(7));
				c.setTotal_vend(rs.getString(8));
				c.setEndereco(rs.getString(9));
				c.setPassword(rs.getString(10));
				
				vendedor = c;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDataBase.closeConnection(con, stmt, rs);
		}
		return vendedor;
		
		
		
	}

}

