package packageController;

import java.io.IOException;
import java.net.URL;

import java.util.Optional;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import packageControler.ClienteDAO;
import packageModel.Cliente;
import packageModel.Produto;

public class ControlleCliente implements Initializable{

	
	
    @FXML
    private TableView<Cliente> TableCliente;

    @FXML
    private TextField TxtFieldPsquisar;

    @FXML
    private Button btnCliente;

    @FXML
    private Button btnExcluir;

    @FXML
    private Button btnFornecedor;

    @FXML
    private Button btnInicio;

    @FXML
    private Button btnPesquisar;

    @FXML
    private Button btnProduto;

    @FXML
    private Button btnRegistrarVenda;

    @FXML
    private Button btnVendedor;

    @FXML
    private Button btnVoltra;

    @FXML
    private TableColumn<Cliente, String> columnCPF;

    @FXML
    private TableColumn<Cliente, String> columnEMAIL;

    @FXML
    private TableColumn<Cliente, String> columnENDERECO;

    @FXML
    private TableColumn<Cliente, String> columnID;

    @FXML
    private TableColumn<Cliente, String> columnNASCIMENRO;

    @FXML
    private TableColumn<Cliente, String> columnNOME;

    @FXML
    private TableColumn<Cliente, String> columnPRIMEIRACOMP;

    @FXML
    private TableColumn<Cliente, String> columnTELEFONE;

    @FXML
    private TableColumn<Cliente, String> columnTipJuri;

    @FXML
    private Text txtCliente;

    
    private ObservableList<Cliente> ArrayCliente;
	private ClienteDAO cliente = new ClienteDAO();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		CarregarTableCliente();
	}

	public void CarregarTableCliente() {
		ArrayCliente = FXCollections.observableArrayList(cliente.read());
		columnID.setCellValueFactory(new PropertyValueFactory<>("id_cliente"));
		columnNOME.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		columnCPF.setCellValueFactory(new PropertyValueFactory<>("CPF_CNPJ"));
		columnEMAIL.setCellValueFactory(new PropertyValueFactory<>("Email"));
		columnTELEFONE.setCellValueFactory(new PropertyValueFactory<>("Telefone"));
		columnNASCIMENRO.setCellValueFactory(new PropertyValueFactory<>("Data_nasc"));
		columnPRIMEIRACOMP.setCellValueFactory(new PropertyValueFactory<>("Data_primComp"));
		columnENDERECO.setCellValueFactory(new PropertyValueFactory<>("Endereco"));
		columnTipJuri.setCellValueFactory(new PropertyValueFactory<>("TipoJur"));
		TableCliente.setItems(ArrayCliente);
	}
	
	@FXML
	public void btnDeletar(ActionEvent event) {
		int i = TableCliente.getSelectionModel().getSelectedIndex();
		if(i == -1) {
			Alert menssagemDeErro = new Alert(Alert.AlertType.INFORMATION);
			menssagemDeErro.setContentText("Selecione um cliente primeiro");
			menssagemDeErro.show();
		}
		else {
			Cliente cliente = new Cliente();
			cliente = TableCliente.getItems().get(i);
			
			Alert menssagemDeAviso = new Alert(Alert.AlertType.CONFIRMATION);
			menssagemDeAviso = new Alert(Alert.AlertType.CONFIRMATION);
			menssagemDeAviso.setContentText("Deseja realmente excluir o cliente: "+ cliente.getNome());
			
			Optional<ButtonType> resultado = menssagemDeAviso.showAndWait();
			
			if(resultado.isPresent() && resultado.get() == ButtonType.OK) {
				ClienteDAO c = new ClienteDAO();
				c.delete(cliente.getCPF_CNPJ());
				
				Alert menssagemDeExclusao = new Alert(Alert.AlertType.INFORMATION);
				menssagemDeExclusao.setContentText("Cliente exluido com sucesso! ");
				CarregarTableCliente();
			}
		}
	} 
	@FXML
	void btnPesquisarAction(ActionEvent event) {
		
			ArrayCliente = FXCollections.observableArrayList(cliente.read());
			columnID.setCellValueFactory(new PropertyValueFactory<>("id_cliente"));
			columnNOME.setCellValueFactory(new PropertyValueFactory<>("Nome"));
			columnCPF.setCellValueFactory(new PropertyValueFactory<>("CPF_CNPJ"));
			columnEMAIL.setCellValueFactory(new PropertyValueFactory<>("Email"));
			columnTELEFONE.setCellValueFactory(new PropertyValueFactory<>("Telefone"));
			columnNASCIMENRO.setCellValueFactory(new PropertyValueFactory<>("Data_nasc"));
			columnPRIMEIRACOMP.setCellValueFactory(new PropertyValueFactory<>("Data_primComp"));
			columnENDERECO.setCellValueFactory(new PropertyValueFactory<>("Endereco"));
			columnTipJuri.setCellValueFactory(new PropertyValueFactory<>("TipoJur"));
			TableCliente.setItems(ArrayCliente);
			TableCliente.refresh();
			
		
	}
	
	@FXML
	void btnCadastrarACTION(ActionEvent event) throws IOException{    
		
		clienteEditar = null;
		Main.TelaCadastroCliente();
	}
	
	public static Cliente clienteEditar = new Cliente();
	
	@FXML
	void btnEditarACTION(ActionEvent event) throws IOException {
		if(TableCliente.getSelectionModel().getSelectedIndex() == -1) { 
			Alert menssagemDeErro = new Alert(Alert.AlertType.INFORMATION);
			menssagemDeErro.setContentText("Selecione um Cliente para editat primeiro!");
			menssagemDeErro.show();
		}else {
			int i = TableCliente.getSelectionModel().getSelectedIndex();
			clienteEditar = TableCliente.getItems().get(i);
			Main.TelaCadastroCliente();
		}
    }
}
