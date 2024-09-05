package packageControler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import packageConnectionFactory.ConnectionDataBase;
import packageModel.Produto;

public class ProdutoDAO {


		public ArrayList<Produto> read() {

			Connection con = ConnectionDataBase.getConnection();
			PreparedStatement stmt = null;
			ResultSet rs = null;
			ArrayList<Produto> produto = new ArrayList<>();

			try {
				stmt = con.prepareStatement("SELECT * FROM Produto");
				rs = stmt.executeQuery();
				while (rs.next()) {
					Produto c = new Produto();
					c.setId_produto(rs.getString(1));
					c.setCodigo(rs.getString(2));
					c.setNome(rs.getString(3));
					c.setEstoque(rs.getString(4)); // select manual
					c.setPreco_un(rs.getString(5));
					c.setData_fab(rs.getString(6));
					c.setData_val(rs.getString(7));

					produto.add(c);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				ConnectionDataBase.closeConnection(con, stmt, rs);
			}
			return produto;

		}

		public void create(Produto c) {
			Connection con = ConnectionDataBase.getConnection();
			PreparedStatement stmt = null;

			try {

				stmt = con.prepareStatement("INSERT INTO produto VALUES(?,?,?,?,?,?)");
				stmt.setString(1, c.getCodigo());
				stmt.setString(2, c.getNome());
				stmt.setString(3, c.getEstoque());
				stmt.setString(4, c.getPreco_un());
				stmt.setString(5, c.getData_fab());
				stmt.setString(6, c.getData_val());

				stmt.executeUpdate();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				ConnectionDataBase.closeConnection(con, stmt);
			}
		}

		public void update(Produto cl) {
			Connection con = ConnectionDataBase.getConnection();
			PreparedStatement stmt = null;

			try {

				stmt = con.prepareStatement("UPDATE produto SET codigo = ?, nome = ?, estoque = ?, preco_un =?, data_fab = ?, data_val = ? WHERE codigo = ?");
				stmt.setString(1, cl.getCodigo());
				stmt.setString(2, cl.getNome());
				stmt.setString(3, cl.getEstoque());
				stmt.setString(4, cl.getPreco_un());
				stmt.setString(5, cl.getData_fab());
				stmt.setString(6, cl.getData_val());
				stmt.setString(7, cl.getCodigo());

				stmt.executeUpdate();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				ConnectionDataBase.closeConnection(con, stmt);
			}
		}

		public void delete(String codigo) {
			Connection con = ConnectionDataBase.getConnection();
			PreparedStatement stmt = null;

			try {

				stmt = con.prepareStatement("DELETE FROM produto where codigo = ?");
				stmt.setString(1, codigo);
				stmt.executeUpdate();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				ConnectionDataBase.closeConnection(con, stmt);
			}
		}

	}


