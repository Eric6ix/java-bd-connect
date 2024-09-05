package packageController;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import packageControler.VendedorDAO;
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
		TableVendedor.setItems(ArrayVendedor);
	}
	
	

}
