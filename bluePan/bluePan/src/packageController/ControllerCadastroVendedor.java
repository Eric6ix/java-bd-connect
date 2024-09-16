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
import packageControler.VendedorDAO;
import packageModel.Vendedor;

public class ControllerCadastroVendedor implements Initializable{

	
	@FXML
    private Button btnCancelar;

    @FXML
    private Button btnSalvar;

    @FXML
    private TextField txtCpf;

    @FXML
    private TextField txtDataContr;

    @FXML
    private TextField txtDataNasc;

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
    private TextField txtTotalVendido;

    @FXML
    private Text Vendedor;
    
    @FXML
	void btnDeletarVendedor(ActionEvent event) {
		txtNome.setText("");
		txtCpf.setText("");
		txtFone.setText("");
		txtEmail.setText("");
		txtDataNasc.setText("");
		txtTotalVendido.setText("");
		txtEndereco.setText("");
		ControllerVendedor.vendedorEditar = null;

		Stage stage = (Stage) btnCancelar.getScene().getWindow();
		stage.close();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

		if (ControllerVendedor.vendedorEditar != null) {
			txtNome.setText(ControllerVendedor.vendedorEditar.getNome());
			txtCpf.setText(ControllerVendedor.vendedorEditar.getCPF());
			txtFone.setText(ControllerVendedor.vendedorEditar.getTelefone());
			txtEmail.setText(ControllerVendedor.vendedorEditar.getEmail());
			txtDataContr.setText(ControllerVendedor.vendedorEditar.getData_cont());
			txtDataNasc.setText(ControllerVendedor.vendedorEditar.getData_nasc());
			txtTotalVendido.setText(ControllerVendedor.vendedorEditar.getTotal_vend());
			txtEndereco.setText(ControllerVendedor.vendedorEditar.getEndereco());
		}
	}

	@FXML
	void btnCadastrar(ActionEvent event) {
		if (ControllerVendedor.vendedorEditar == null) {
			Vendedor vendedor = new Vendedor();
			vendedor.setNome(txtNome.getText());
			vendedor.setCPF(txtCpf.getText());
			vendedor.setData_nasc(txtDataNasc.getText());
			vendedor.setData_cont(txtDataContr.getText());
			vendedor.setEmail(txtEmail.getText());
			vendedor.setEndereco(txtEndereco.getText());
			vendedor.setTelefone(txtFone.getText());
			vendedor.setTotal_vend(txtTotalVendido.getText());
			VendedorDAO prod = new VendedorDAO();
			prod.create(vendedor);
			Stage stage = (Stage) btnCancelar.getScene().getWindow();
			stage.close();
		} else {
			Vendedor vendedor = new Vendedor();
			vendedor.setNome(txtNome.getText());
			vendedor.setCPF(txtCpf.getText());
			vendedor.setData_nasc(txtDataNasc.getText());
			vendedor.setData_cont(txtDataContr.getText());
			vendedor.setEmail(txtEmail.getText());
			vendedor.setEndereco(txtEndereco.getText());
			vendedor.setTelefone(txtFone.getText());
			vendedor.setTotal_vend(txtTotalVendido.getText());
			VendedorDAO prod = new VendedorDAO();
			prod.update(vendedor);
			Stage stage = (Stage) btnCancelar.getScene().getWindow();
			stage.close();
		}
		

	}
}
