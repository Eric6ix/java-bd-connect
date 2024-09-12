package packageControler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import packageConnectionFactory.ConnectionDataBase;
import packageModel.Cliente;
import packageModel.Fornecedor;

public class FornecedorDAO {

	public ArrayList<Fornecedor> read() {

		Connection con = ConnectionDataBase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Fornecedor> fornecedor = new ArrayList<>();

		try {
			stmt = con.prepareStatement("SELECT * FROM Fornecedor");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Fornecedor c = new Fornecedor();
				c.setId_Fornecedor(rs.getString(1));
				c.setNome(rs.getString(2));
				c.setCNPJ(rs.getString(3));
				c.setEmail(rs.getString(4)); // select manual
				c.setTElefone(rs.getString(5));
				c.setEndereco(rs.getString(6));
				c.setTipoJur(rs.getString(7));

				fornecedor.add(c);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDataBase.closeConnection(con, stmt, rs);
		}
		return fornecedor;

	}

	public void create(Fornecedor c) {
		Connection con = ConnectionDataBase.getConnection();
		PreparedStatement stmt = null;

		try {

			stmt = con.prepareStatement("INSERT INTO fornecedor VALUES(?,?,?,?,?,?)");
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getCNPJ());
			stmt.setString(3, c.getEmail());
			stmt.setString(4, c.getTElefone());
			stmt.setString(5, c.getEndereco());
			stmt.setString(6, c.getTipoJur());

			stmt.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDataBase.closeConnection(con, stmt);
		}
	}

	public void update(Fornecedor cl) {
		Connection con = ConnectionDataBase.getConnection();
		PreparedStatement stmt = null;

		try {

			stmt = con.prepareStatement("UPDATE fornecedor SET nome = ?, CNPJ = ?, email = ?, telefone =?, endereco = ?, tipo_juridico = ? WHERE CNPJ = ?");
			stmt.setString(1, cl.getNome());
			stmt.setString(2, cl.getCNPJ());
			stmt.setString(3, cl.getEmail());
			stmt.setString(4, cl.getTElefone());
			stmt.setString(5, cl.getEndereco());
			stmt.setString(6, cl.getTipoJur());
			stmt.setString(7, cl.getCNPJ());
			

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDataBase.closeConnection(con, stmt);
		}
	}

	public void delete(String cnpj) {
		Connection con = ConnectionDataBase.getConnection();
		PreparedStatement stmt = null;

		try {

			stmt = con.prepareStatement("DELETE FROM fornecedor where CNPJ = ?");
			stmt.setString(1, cnpj);
			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDataBase.closeConnection(con, stmt);
		}
	}
	
	
	
	
	
	public ArrayList<Fornecedor> search(String search) {
		search = "%"+search+"%";
		Connection con = ConnectionDataBase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Fornecedor> fornecedor = new ArrayList<>();

		try {																	//no search não colocar "="
			stmt = con.prepareStatement("SELECT * FROM Fornecedor where Nome like ? or CNPJ like ?");
			stmt.setString(1, search);
			stmt.setString(2, search);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Fornecedor c = new Fornecedor();
				c.setId_Fornecedor(rs.getString(1));
				c.setNome(rs.getString(2));
				c.setCNPJ(rs.getString(3));
				c.setEmail(rs.getString(4)); // select manual
				c.setTElefone(rs.getString(5));
				c.setEndereco(rs.getString(6));
				c.setTipoJur(rs.getString(7));

				fornecedor.add(c);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDataBase.closeConnection(con, stmt, rs);
		}
		return fornecedor;

	}

}

