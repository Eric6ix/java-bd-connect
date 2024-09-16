package packageController;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import packageControler.FornecedorDAO;
import packageModel.Fornecedor;

public class ControllerCadastroFornecedor implements Initializable{

	@FXML
	private Button btnCancelar;

	@FXML
	private Button btnSalvar;

	@FXML
	private TextField txtCpfCnpj;

	@FXML
	private TextField txtEmail;

	@FXML
	private TextField txtEndereco;

	@FXML
	private TextField txtFone;

	@FXML
	private Text txtFornecedor;

	@FXML
	private TextField txtNome;

	@FXML
	private TextField txtTipoJ;
	
		@FXML
		void btnDeletarFornecedor(ActionEvent event) {
			txtNome.setText("");
			txtEmail.setText("");
			txtCpfCnpj.setText("");
			txtEmail.setText("");
			txtEndereco.setText("");
			txtFone.setText("");
			txtTipoJ.setText("");
			ControllerFornecedor.fornecedorEditar = null;

			Stage stage = (Stage) btnCancelar.getScene().getWindow();
			stage.close();
		}

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub

			if (ControllerFornecedor.fornecedorEditar != null) {
				txtNome.setText(ControllerFornecedor.fornecedorEditar.getNome());
				txtCpfCnpj.setText(ControllerFornecedor.fornecedorEditar.getCNPJ());
				txtEmail.setText(ControllerFornecedor.fornecedorEditar.getEmail());
				txtEndereco.setText(ControllerFornecedor.fornecedorEditar.getEndereco());
				txtFone.setText(ControllerFornecedor.fornecedorEditar.getTElefone());
				txtTipoJ.setText(ControllerFornecedor.fornecedorEditar.getTipoJur());
			}
		}

		@FXML
		void btnCadastrar(ActionEvent event) {
			if (ControllerFornecedor.fornecedorEditar == null) {
				Fornecedor fornecedor = new Fornecedor();
				fornecedor.setNome(txtNome.getText());
				fornecedor.setCNPJ(txtCpfCnpj.getText());
				fornecedor.setEmail(txtEmail.getText());
				fornecedor.setEndereco(txtEndereco.getText());
				fornecedor.setTElefone(txtFone.getText());
				fornecedor.setTipoJur(txtTipoJ.getText());
				FornecedorDAO prod = new FornecedorDAO();
				prod.create(fornecedor);
				Stage stage = (Stage) btnCancelar.getScene().getWindow();
				stage.close();
			} else {
				Fornecedor fornecedor = new Fornecedor();
				fornecedor.setNome(txtNome.getText());
				fornecedor.setCNPJ(txtCpfCnpj.getText());
				fornecedor.setEmail(txtEmail.getText());
				fornecedor.setEndereco(txtEndereco.getText());
				fornecedor.setTElefone(txtFone.getText());
				fornecedor.setTipoJur(txtTipoJ.getText());
				FornecedorDAO prod = new FornecedorDAO();
				prod.update(fornecedor);
				Stage stage = (Stage) btnCancelar.getScene().getWindow();
				stage.close();
			}
	}

}
