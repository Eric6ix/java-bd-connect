
package packageControler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import packageConnectionFactory.ConnectionDataBase;
import packageModel.Compra;

public class CompraDAO {

	public ArrayList<Compra> read() {

		Connection con = ConnectionDataBase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Compra> compra = new ArrayList<>();

		try {
			stmt = con.prepareStatement("SELECT * FROM Compra");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Compra c = new Compra();
				c.setId_Compra(rs.getString(1));
				c.setId_Cliente(rs.getString(2));
				c.setId_Vendedor(rs.getString(3));
				c.setId_Produto(rs.getString(4)); 
				c.setQuantidade(rs.getString(5));
				c.setPreco_total(rs.getString(6));
				

				compra.add(c);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDataBase.closeConnection(con, stmt, rs);
		}
		return compra;

	}

	public void create(Compra c) {
		Connection con = ConnectionDataBase.getConnection();
		PreparedStatement stmt = null;

		try {

			stmt = con.prepareStatement("INSERT INTO compra VALUES(?,?,?,?,?,?)");
			stmt.setString(1, c.getId_Compra());
			stmt.setString(2, c.getId_Cliente());
			stmt.setString(3, c.getId_Vendedor());
			stmt.setString(4, c.getId_Produto());
			stmt.setString(5, c.getQuantidade());
			stmt.setString(6, c.getPreco_total());
		
			stmt.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDataBase.closeConnection(con, stmt);
		}
	}

	public void update(Compra cl) {
		Connection con = ConnectionDataBase.getConnection();
		PreparedStatement stmt = null;

		try {

			stmt = con.prepareStatement("UPDATE compra SET Id_Compra = ?, Id_Cliente = ?, Id_Vendedor = ?, Id_Produto =?, Quantidade = ?, Preco_tota = ?");
			stmt.setString(1, cl.getId_Compra());
			stmt.setString(2, cl.getId_Cliente());
			stmt.setString(3, cl.getId_Vendedor());
			stmt.setString(4, cl.getId_Produto());
			stmt.setString(5, cl.getQuantidade());
			stmt.setString(6, cl.getPreco_total());


			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDataBase.closeConnection(con, stmt);
		}
	}

	public void delete(String id) {
		Connection con = ConnectionDataBase.getConnection();
		PreparedStatement stmt = null;

		try {

			stmt = con.prepareStatement("DELETE FROM compra where id = ?");
			stmt.setString(1, id);
			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDataBase.closeConnection(con, stmt);
		}
	}

}
