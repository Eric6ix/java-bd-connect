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
import packageControler.ClienteDAO;
import packageModel.Cliente;

public class ControllerCadastroCliente implements Initializable {

	@FXML
	private Button btnCancelar;

	@FXML
	private Button btnSalvar;

	@FXML
	private Text txtCliente;

	@FXML
	private TextField txtCpfCnpj;

	@FXML
	private TextField txtDataNasc;

	@FXML
	private TextField txtDataPCom;

	@FXML
	private TextField txtEmail;

	@FXML
	private TextField txtEndereco;

	@FXML
	private TextField txtFone;

	@FXML
	private TextField txtNome;

	@FXML
	private TextField txtTipoJ;

	@FXML
	private Button btnCadastrar;

	@FXML
	private Button btnEditar;

	@FXML
	void btnDeletarCliente(ActionEvent event) {
		txtNome.setText("");
		txtCliente.setText("");
		txtCpfCnpj.setText("");
		txtEmail.setText("");
		txtDataPCom.setText("");
		txtDataNasc.setText("");
		txtEndereco.setText("");
		txtFone.setText("");
		txtTipoJ.setText("");
		ControllerCliente.clienteEditar = null;

		Stage stage = (Stage) btnCancelar.getScene().getWindow();
		stage.close();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

		if (ControllerCliente.clienteEditar != null) {
			txtNome.setText(ControllerCliente.clienteEditar.getNome());
			txtCpfCnpj.setText(ControllerCliente.clienteEditar.getCPF_CNPJ());
			txtDataNasc.setText(ControllerCliente.clienteEditar.getData_nasc());
			txtDataPCom.setText(ControllerCliente.clienteEditar.getData_primComp());
			txtEmail.setText(ControllerCliente.clienteEditar.getEmail());
			txtEndereco.setText(ControllerCliente.clienteEditar.getEndereco());
			txtFone.setText(ControllerCliente.clienteEditar.getTelefone());
			txtTipoJ.setText(ControllerCliente.clienteEditar.getTipoJur());
		}
	}

	@FXML
	void btnCadastrar(ActionEvent event) {
		if (ControllerCliente.clienteEditar == null) {
			Cliente cliente = new Cliente();
			cliente.setNome(txtNome.getText());
			cliente.setCPF_CNPJ(txtCpfCnpj.getText());
			cliente.setData_nasc(txtDataNasc.getText());
			cliente.setData_primComp(txtDataPCom.getText());
			cliente.setEmail(txtEmail.getText());
			cliente.setEndereco(txtEndereco.getText());
			cliente.setTelefone(txtFone.getText());
			cliente.setTipoJur(txtTipoJ.getText());
			ClienteDAO prod = new ClienteDAO();
			prod.create(cliente);
			Stage stage = (Stage) btnCancelar.getScene().getWindow();
			stage.close();
		} else {
			Cliente cliente = new Cliente();
			cliente.setNome(txtNome.getText());
			cliente.setCPF_CNPJ(txtCpfCnpj.getText());
			cliente.setData_nasc(txtDataNasc.getText());
			cliente.setData_primComp(txtDataPCom.getText());
			cliente.setEmail(txtEmail.getText());
			cliente.setEndereco(txtEndereco.getText());
			cliente.setTelefone(txtFone.getText());
			cliente.setTipoJur(txtTipoJ.getText());
			ClienteDAO prod = new ClienteDAO();
			prod.update(cliente);
			Stage stage = (Stage) btnCancelar.getScene().getWindow();
			stage.close();
		}

	}
}
