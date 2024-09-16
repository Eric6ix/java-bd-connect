package packageControler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import packageConnectionFactory.ConnectionDataBase;
import packageModel.Cliente;



public class ClienteDAO {

	public ArrayList<Cliente> read() {

		Connection con = ConnectionDataBase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Cliente> cliente = new ArrayList<>();

		try {
			stmt = con.prepareStatement("SELECT * FROM Cliente");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Cliente c = new Cliente();
				c.setId_cliente(rs.getString(1));
				c.setNome(rs.getString(2));
				c.setCPF_CNPJ(rs.getString(3));
				c.setEmail(rs.getString(4)); // select manual
				c.setTelefone(rs.getString(5));
				c.setData_nasc(rs.getString(6));
				c.setData_primComp(rs.getString(7));
				c.setEndereco(rs.getString(8));
				c.setTipoJur(rs.getString(9));

				cliente.add(c);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDataBase.closeConnection(con, stmt, rs);
		}
		return cliente;

	}

	public void create(Cliente c) {
		Connection con = ConnectionDataBase.getConnection();
		PreparedStatement stmt = null;

		try {

			stmt = con.prepareStatement("INSERT INTO cliente VALUES(?,?,?,?,?,?,?,?)");
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getCPF_CNPJ());
			stmt.setString(3, c.getEmail());
			stmt.setString(4, c.getTelefone());
			stmt.setString(5, c.getData_nasc());
			stmt.setString(6, c.getData_primComp());
			stmt.setString(7, c.getEndereco());
			stmt.setString(8, c.getTipoJur());

			stmt.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDataBase.closeConnection(con, stmt);
		}
	}

	public void update(Cliente cl) {
		Connection con = ConnectionDataBase.getConnection();
		PreparedStatement stmt = null;

		try {

			stmt = con.prepareStatement("UPDATE cliente SET nome = ?, CPF_CNPJ = ?, email = ?, telefone =?, data_nasc = ?, data_primComp = ?, endereco = ?, tipo_juridico = ? WHERE CPF_CNPJ = ?");
			stmt.setString(1, cl.getNome());
			stmt.setString(2, cl.getCPF_CNPJ());
			stmt.setString(3, cl.getEmail());
			stmt.setString(4, cl.getTelefone());
			stmt.setString(5, cl.getData_nasc());
			stmt.setString(6, cl.getData_primComp());
			stmt.setString(7, cl.getEndereco());
			stmt.setString(8, cl.getTipoJur());
			stmt.setString(9, cl.getCPF_CNPJ());

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDataBase.closeConnection(con, stmt);
		}
	}

	public void delete(String cpf_cnpj) {
		Connection con = ConnectionDataBase.getConnection();
		PreparedStatement stmt = null;

		try {

			stmt = con.prepareStatement("DELETE FROM cliente where CPF_CNPJ = ?");
			stmt.setString(1, cpf_cnpj);
			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDataBase.closeConnection(con, stmt);
		}
	}
	
	
	
	
	public ArrayList<Cliente> search(String search) {
		search = "%"+search+"%";
		Connection con = ConnectionDataBase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Cliente> cliente = new ArrayList<>();

		try {
			stmt = con.prepareStatement("SELECT * FROM Cliente where Nome like ? or CPF_CNPJ like ? ");
			stmt.setString(1, search);
			stmt.setString(2, search);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Cliente c = new Cliente();
				c.setId_cliente(rs.getString(1));
				c.setNome(rs.getString(2));
				c.setCPF_CNPJ(rs.getString(3));
				c.setEmail(rs.getString(4)); // select manual
				c.setTelefone(rs.getString(5));
				c.setData_nasc(rs.getString(6));
				c.setData_primComp(rs.getString(7));
				c.setEndereco(rs.getString(8));
				c.setTipoJur(rs.getString(9));

				cliente.add(c);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDataBase.closeConnection(con, stmt, rs);
		}
		return cliente;

	}

}
