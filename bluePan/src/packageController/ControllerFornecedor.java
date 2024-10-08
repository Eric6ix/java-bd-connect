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
import packageControler.FornecedorDAO;
import packageModel.Fornecedor;

public class ControllerFornecedor  implements Initializable{


    @FXML
    private TableView<Fornecedor> TableFornecedor;

    @FXML
    private TextField TxtFieldPsquisa;

    @FXML
    private Button btnCliente;

    @FXML
    private Button btnExcluir;

    @FXML
    private Button btnFornecedor;

    @FXML
    private Button btnCadastrar;
    
    @FXML
    private Button btnEditar;
    
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
    private TableColumn<Fornecedor, String> columnCNPJ;

    @FXML
    private TableColumn<Fornecedor, String> columnEMAIL;

    @FXML
    private TableColumn<Fornecedor, String> columnENDERECO;

    @FXML
    private TableColumn<Fornecedor, String> columnID;

    @FXML
    private TableColumn<Fornecedor, String> columnNOME;

    @FXML
    private TableColumn<Fornecedor, String> columnTELEFONE;

    @FXML
    private TableColumn<Fornecedor, String> columnTIPJURID;


    @FXML
    private Text txtFornecedor;

    
    private ObservableList<Fornecedor> ArrayFornecedor;
   	private FornecedorDAO fornecedor= new FornecedorDAO();
    
   	public void initialize(URL arg0, ResourceBundle arg1) {
		CarregarTableFornecedor();
	}
    
    @FXML
    public void CarregarTableFornecedor() {
		ArrayFornecedor = FXCollections.observableArrayList(fornecedor.read());
		columnID.setCellValueFactory(new PropertyValueFactory<>("id_Fornecedor"));
		columnNOME.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		columnCNPJ.setCellValueFactory(new PropertyValueFactory<>("CNPJ"));
		columnEMAIL.setCellValueFactory(new PropertyValueFactory<>("Email"));
		columnTELEFONE.setCellValueFactory(new PropertyValueFactory<>("TElefone"));
		columnENDERECO.setCellValueFactory(new PropertyValueFactory<>("Endereco"));
		columnTIPJURID.setCellValueFactory(new PropertyValueFactory<>("TipoJur"));
		TableFornecedor.setItems(ArrayFornecedor);
    }
    
    
    
    
    
   
	@FXML
    public void btnDeletarFornecedor(ActionEvent event) {
		int i = TableFornecedor.getSelectionModel().getSelectedIndex();
		if(i == -1) {
			Alert menssagemDeErro = new Alert(Alert.AlertType.INFORMATION);
			menssagemDeErro.setContentText("Selecione um cliente primeiro");
			menssagemDeErro.show();
		}
		else {
			Fornecedor fornecedor = new Fornecedor();
			fornecedor = TableFornecedor.getItems().get(i);
			
			Alert menssagemDeAviso = new Alert(Alert.AlertType.CONFIRMATION);
			menssagemDeAviso = new Alert(Alert.AlertType.CONFIRMATION);
			menssagemDeAviso.setContentText("Deseja realmente excluir o Fornecedor: "+ fornecedor.getNome());
			
			Optional<ButtonType> resultado = menssagemDeAviso.showAndWait();
			
			if(resultado.isPresent() && resultado.get() == ButtonType.OK) {
				FornecedorDAO c = new FornecedorDAO();
				c.delete(fornecedor.getCNPJ());
				
				Alert menssagemDeExclusao = new Alert(Alert.AlertType.INFORMATION);
				menssagemDeExclusao.setContentText("Fornecedor exluido com sucesso! ");
				CarregarTableFornecedor();
			}
		}
	}
	@FXML
	void btnPesquisarAction(ActionEvent event) {
		
		ArrayFornecedor = FXCollections.observableArrayList(fornecedor.search(TxtFieldPsquisa.getText()));
		columnID.setCellValueFactory(new PropertyValueFactory<>("id_Fornecedor"));
		columnNOME.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		columnCNPJ.setCellValueFactory(new PropertyValueFactory<>("CNPJ"));
		columnEMAIL.setCellValueFactory(new PropertyValueFactory<>("Email"));
		columnTELEFONE.setCellValueFactory(new PropertyValueFactory<>("TElefone"));
		columnENDERECO.setCellValueFactory(new PropertyValueFactory<>("Endereco"));
		columnTIPJURID.setCellValueFactory(new PropertyValueFactory<>("TipoJur"));
		TableFornecedor.setItems(ArrayFornecedor);
		TableFornecedor.refresh();

	}

	@FXML
	void btnCadastrarACTION(ActionEvent event) throws IOException {

		fornecedorEditar = null;
		Main.TelaCadastroFornecedor();
		CarregarTableFornecedor();
	}

	public static Fornecedor fornecedorEditar = new Fornecedor();

	@FXML
	void btnEditarACTION(ActionEvent event) throws IOException {
		if (TableFornecedor.getSelectionModel().getSelectedIndex() == -1) {
			Alert menssagemDeErro = new Alert(Alert.AlertType.INFORMATION);
			menssagemDeErro.setContentText("Selecione um Fornecedor para editat primeiro!");
			menssagemDeErro.show();
		} else {
			int i = TableFornecedor.getSelectionModel().getSelectedIndex();
			fornecedorEditar = TableFornecedor.getItems().get(i);
			Main.TelaCadastroFornecedor();
			CarregarTableFornecedor();
		}
	}
}
	
	


