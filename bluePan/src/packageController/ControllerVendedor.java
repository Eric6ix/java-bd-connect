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
import packageControler.VendedorDAO;
import packageModel.Cliente;
import packageModel.Vendedor;

public class ControllerVendedor implements Initializable {


	
	@FXML
    private Button btnCliente;
	
	@FXML
	private Button btnFornecdor;
	
	
	@FXML
	private Button btnProduto;

	@FXML
	private Button btnInicio;
	

	@FXML
	private Button btnVendedor;
	

	@FXML
	private Button btnRegistrarVenda;

	
	@FXML
	private Text txtVendedor;
	
	@FXML
	private Button BtnCriar;

	@FXML
	private Button BtnEditar;
	
	@FXML
	private TextField TxtFieldPsquisa;

	@FXML
	private Button btnExcluir;

	@FXML
	private Button btnPesquisar;

	@FXML
	private Button btnVoltra;

	@FXML
	private TableView<Vendedor> TableVendedor;
	@FXML
	private TableColumn<Vendedor, String> columnCONTRADACAO;
//o import sempre tem que ser JAVAFX
	
	@FXML
	private TableColumn<Vendedor, String> columnCPF;
	@FXML
	private TableColumn<Vendedor, String> columnPassword;

	@FXML
	private TableColumn<Vendedor, String> columnEMAIL;

	@FXML
	private TableColumn<Vendedor, String> columnENDERECO;

	@FXML
	private TableColumn<Vendedor, String> columnID;

	@FXML
	private TableColumn<Vendedor, String> columnNASCIMENRO;

	@FXML
	private TableColumn<Vendedor, String> columnNOME;

	@FXML
	private TableColumn<Vendedor, String> columnTELEFONE;

	@FXML
	private TableColumn<Vendedor, String> columnVENDIDOS;

	private ObservableList<Vendedor> ArrayVendedor;
	private VendedorDAO vendedor = new VendedorDAO();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		CarregarTableVendedor();
	}
	@FXML
	public void CarregarTableVendedor() {
		ArrayVendedor = FXCollections.observableArrayList(vendedor.read());
		columnID.setCellValueFactory(new PropertyValueFactory<>("id_Vendedor"));
		columnNOME.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		columnCPF.setCellValueFactory(new PropertyValueFactory<>("CPF"));
		columnEMAIL.setCellValueFactory(new PropertyValueFactory<>("Email"));
		columnTELEFONE.setCellValueFactory(new PropertyValueFactory<>("Telefone"));
		columnNASCIMENRO.setCellValueFactory(new PropertyValueFactory<>("Data_nasc"));
		columnCONTRADACAO.setCellValueFactory(new PropertyValueFactory<>("Data_cont"));
		columnVENDIDOS.setCellValueFactory(new PropertyValueFactory<>("Total_vend"));
		columnENDERECO.setCellValueFactory(new PropertyValueFactory<>("Endereco"));
		columnPassword.setCellValueFactory(new PropertyValueFactory<>("Password"));
		TableVendedor.setItems(ArrayVendedor);
	}
	
	@FXML
	public void btnDeletarVendedor(ActionEvent event) {
		int i = TableVendedor.getSelectionModel().getSelectedIndex();
		if(i == -1) {
			Alert menssagemDeErro = new Alert(Alert.AlertType.INFORMATION);
			menssagemDeErro.setContentText("Selecione um Vendedor primeiro");
			menssagemDeErro.show();
		}
		else {
			Vendedor vendedor = new Vendedor();
			vendedor = TableVendedor.getItems().get(i);
			
			Alert menssagemDeAviso = new Alert(Alert.AlertType.CONFIRMATION);
			menssagemDeAviso = new Alert(Alert.AlertType.CONFIRMATION);
			menssagemDeAviso.setContentText("Deseja realmente excluir o Vendedor: "+ vendedor.getNome());
			
			Optional<ButtonType> resultado = menssagemDeAviso.showAndWait();
			
			if(resultado.isPresent() && resultado.get() == ButtonType.OK) {
				ClienteDAO c = new ClienteDAO();
				c.delete(vendedor.getCPF());
				
				Alert menssagemDeExclusao = new Alert(Alert.AlertType.INFORMATION);
				menssagemDeExclusao.setContentText("Vendedor exluido com sucesso! ");
				CarregarTableVendedor();
			}
		}
	} 
	@FXML
	void btnPesquisarAction(ActionEvent event) {
		
		ArrayVendedor = FXCollections.observableArrayList(vendedor.read());
		columnID.setCellValueFactory(new PropertyValueFactory<>("id_Vendedor"));
		columnNOME.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		columnCPF.setCellValueFactory(new PropertyValueFactory<>("CPF"));
		columnEMAIL.setCellValueFactory(new PropertyValueFactory<>("Email"));
		columnTELEFONE.setCellValueFactory(new PropertyValueFactory<>("Telefone"));
		columnNASCIMENRO.setCellValueFactory(new PropertyValueFactory<>("Data_nasc"));
		columnCONTRADACAO.setCellValueFactory(new PropertyValueFactory<>("Data_cont"));
		columnVENDIDOS.setCellValueFactory(new PropertyValueFactory<>("Total_vend"));
		columnENDERECO.setCellValueFactory(new PropertyValueFactory<>("Endereco"));
		columnPassword.setCellValueFactory(new PropertyValueFactory<>("Password"));
		TableVendedor.setItems(ArrayVendedor);
			TableVendedor.refresh();
	}
	
	
	@FXML
	void btnCadastrarACTION(ActionEvent event) throws IOException {

		vendedorEditar = null;
		Main.TelaCadastroVendedor();
	}

	public static Vendedor vendedorEditar = new Vendedor();

	@FXML
	void btnEditarACTION(ActionEvent event) throws IOException {
		if (TableVendedor.getSelectionModel().getSelectedIndex() == -1) {
			Alert menssagemDeErro = new Alert(Alert.AlertType.INFORMATION);
			menssagemDeErro.setContentText("Selecione um Vendedor para editat primeiro!");
			menssagemDeErro.show();
		} else {
			int i = TableVendedor.getSelectionModel().getSelectedIndex();
			vendedorEditar = TableVendedor.getItems().get(i);
			Main.TelaCadastroVendedor();
		}
	}
	

}
