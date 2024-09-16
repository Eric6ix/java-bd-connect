package packageController;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import packageControler.ProdutoDAO;
import packageModel.Produto;

public class ControllerCadastroProduto implements Initializable {

	@FXML
	private Button btnCancelar;

	@FXML
	private Button btnSalvar;

	@FXML
	private DatePicker txtDataFab;

	@FXML
	private DatePicker txtDataVal;

	@FXML
	private Text txt;

	@FXML
	private TextField txtCodigo;

	@FXML
	private TextField txtEstoque;

	@FXML
	private TextField txtFornecedor;

	@FXML
	private TextField txtNome;

	@FXML
	private TextField txtPrecoUn;

	@FXML
	private TextField txtTipoUn;

	@FXML
	private Text txtfEstoque;

	@FXML
	void btnDeletarProduto(ActionEvent event) {
		txtNome.setText("");
		txtCodigo.setText("");
		txtfEstoque.setText("");
		txtPrecoUn.setText("");
		txtTipoUn.setText("");
		txtDataFab.setValue(null);
		txtDataVal.setValue(null);
		ControllerProduto.produtoEditar = null;

		Stage stage = (Stage) btnCancelar.getScene().getWindow();
		stage.close();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

		if (ControllerProduto.produtoEditar != null) {
			txtNome.setText(ControllerProduto.produtoEditar.getNome());
			txtCodigo.setText(ControllerProduto.produtoEditar.getCodigo());
			txtEstoque.setText(ControllerProduto.produtoEditar.getEstoque());
			txtPrecoUn.setText(ControllerProduto.produtoEditar.getPreco_un());
			txtTipoUn.setText(ControllerProduto.produtoEditar.getTipo_un());
		}
	}

	@FXML
	void btnCadastrarProduto(ActionEvent event) {
		if (ControllerProduto.produtoEditar == null) {
			Produto produto = new Produto();
			produto.setNome(txtNome.getText());
			produto.setCodigo(txtCodigo.getText());
			produto.setTipo_un(txtTipoUn.getText());
			produto.setData_fab(txtDataFab.getValue().toString());
			produto.setData_val(txtDataVal.getValue().toString());
			produto.setPreco_un(txtPrecoUn.getText());
			produto.setEstoque(txtEstoque.getText());
			ProdutoDAO prod = new ProdutoDAO();
			prod.create(produto);
			Stage stage = (Stage) btnCancelar.getScene().getWindow();
			stage.close();
		} else {
			Produto produto = new Produto();
			produto.setNome(txtNome.getText());
			produto.setCodigo(txtCodigo.getText());
			produto.setTipo_un(txtTipoUn.getText());
			produto.setData_fab(txtDataFab.getValue().toString());
			produto.setData_val(txtDataVal.getValue().toString());
			produto.setPreco_un(txtPrecoUn.getText());
			produto.setEstoque(txtEstoque.getText());
			ProdutoDAO prod = new ProdutoDAO();
			prod.update(produto);
			Stage stage = (Stage) btnCancelar.getScene().getWindow();
			stage.close();
		}
	}
}
