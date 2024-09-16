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
import packageControler.ProdutoDAO;
import packageModel.Produto;

public class ControllerProduto implements Initializable{



    @FXML
    private Button btnCadastrar;
	
	@FXML
    private TableView<Produto> TableProduto;
	
	@FXML
	private Text txtProduto;

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
    private Button btnEdidtar;


    @FXML
    private TableColumn<Produto, String> columnCODIGO;

    @FXML
    private TableColumn<Produto, String> columnDATAFAB;

    @FXML
    private TableColumn<Produto, String> columnDATAVAL;

    @FXML
    private TableColumn<Produto, String> columnESTOQUE;

    @FXML
    private TableColumn<Produto, String> columnID;

    @FXML
    private TableColumn<Produto, String> columnNOME;

    @FXML
    private TableColumn<Produto, String> columnPRECOUNITA;

    @FXML
    private TableView<Produto> TableProduto1;

    private ObservableList<Produto> ArrayProduto;
	private ProdutoDAO produto = new ProdutoDAO();
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		CarregarTableProduto();
	}
   

	public void CarregarTableProduto() {
		ArrayProduto= FXCollections.observableArrayList(produto.read());
		columnID.setCellValueFactory(new PropertyValueFactory<>("id_Compra"));
		columnCODIGO.setCellValueFactory(new PropertyValueFactory<>("Codigo"));
		columnNOME.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		columnESTOQUE.setCellValueFactory(new PropertyValueFactory<>("Estoque"));
		columnPRECOUNITA.setCellValueFactory(new PropertyValueFactory<>("Preco_un"));
		columnDATAFAB.setCellValueFactory(new PropertyValueFactory<>("Data_fab"));
		columnDATAVAL.setCellValueFactory(new PropertyValueFactory<>("Data_val"));
		TableProduto.setItems(ArrayProduto);
	}
	
	
	
	@FXML
	public void btnDeletar(ActionEvent event) {
		int i = TableProduto.getSelectionModel().getSelectedIndex();
		if(i == -1) {
			Alert menssagemDeErro = new Alert(Alert.AlertType.INFORMATION);
			menssagemDeErro.setContentText("Selecione um produto primeiro");
			menssagemDeErro.show();
		}
		else {
			Produto produto = new Produto();
			produto = TableProduto.getItems().get(i);
			
			Alert menssagemDeAviso = new Alert(Alert.AlertType.CONFIRMATION);
			menssagemDeAviso = new Alert(Alert.AlertType.CONFIRMATION);
			menssagemDeAviso.setContentText("Deseja realmente excluir o produto: "+ produto.getNome());
			
			Optional<ButtonType> resultado = menssagemDeAviso.showAndWait();
			
			if(resultado.isPresent() && resultado.get() == ButtonType.OK) {
				ProdutoDAO c = new ProdutoDAO();
				c.delete(produto.getCodigo());
				
				Alert menssagemDeExclusao = new Alert(Alert.AlertType.INFORMATION);
				menssagemDeExclusao.setContentText("Produto exluido com sucesso! ");
				CarregarTableProduto();
			}
		}
	} 
	@FXML
	void btnPesquisarAction(ActionEvent event) {
		
		ArrayProduto= FXCollections.observableArrayList(produto.search(TxtFieldPsquisar.getText()));
		columnID.setCellValueFactory(new PropertyValueFactory<>("id_produto"));
		columnCODIGO.setCellValueFactory(new PropertyValueFactory<>("Codigo"));
		columnNOME.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		columnESTOQUE.setCellValueFactory(new PropertyValueFactory<>("Estoque"));
		columnPRECOUNITA.setCellValueFactory(new PropertyValueFactory<>("Preco_un"));
		columnDATAFAB.setCellValueFactory(new PropertyValueFactory<>("Data_fab"));
		columnDATAVAL.setCellValueFactory(new PropertyValueFactory<>("Data_val"));
		TableProduto.setItems(ArrayProduto);
		TableProduto.refresh();
		
	}
	@FXML
	void btnCadastrarACTION(ActionEvent event) throws IOException{    
		
		produtoEditar = null;
		Main.TelaCadastroProd();
		CarregarTableProduto();
	}
	
	public static Produto produtoEditar = new Produto();
	
	@FXML
	void btnEditarACTION(ActionEvent event) throws IOException {
		if(TableProduto.getSelectionModel().getSelectedIndex() == -1) { 
			Alert menssagemDeErro = new Alert(Alert.AlertType.INFORMATION);
			menssagemDeErro.setContentText("Selecione um Produto para editat primeiro!");
			menssagemDeErro.show();
		}else {
			int i = TableProduto.getSelectionModel().getSelectedIndex();
			produtoEditar = TableProduto.getItems().get(i);
			Main.TelaCadastroProd();
		}
				CarregarTableProduto();
		
		
	}
	
}

