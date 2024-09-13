package packageController;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.print.DocFlavor.URL;

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
import javafx.stage.Stage;
import packageControler.ClienteDAO;
import packageControler.CompraDAO;
import packageControler.ProdutoDAO;
import packageModel.Cliente;
import packageModel.Compra;
import packageModel.Produto;
import packageModel.Vendedor;


	public class ControllerCadastroVenda implements Initializable{

		@FXML
	    private TableColumn<Produto, String> ColumnPreco;

	    @FXML
	    private TableView<Produto> TableProduto;

	    @FXML
	    private Button btnCancelar;

	    @FXML
	    private Button btnPesquisar;

	    @FXML
	    private Button btnSalvar;

	    @FXML
	    private TableColumn<Produto, String> columnID;

	    @FXML
	    private TableColumn<Produto, String> columnNome;

	    @FXML
	    private TextField txtCPFCliente;

	    @FXML
	    private TextField txtCPFVendedor;

	    @FXML
	    private TextField txtCodigoProduto;

	    @FXML
	    private TextField txtDesconto;

	    @FXML
	    private TextField txtIDCliente;

	    @FXML
	    private TextField txtIDVendedor;

	    @FXML
	    private TextField txtNomeCliente;

	    @FXML
	    private TextField txtNomeProduto;

	    @FXML
	    private TextField txtNomeVendedor;

	    @FXML
	    private TextField txtPrecoUn;

	    @FXML
	    private TextField txtPreçoTotal;

	    @FXML
	    private TextField txtQuantidade;
	    
	    
		Produto produto = new Produto();
		ArrayList<Cliente> cliente1 = new ArrayList<>();
		Cliente cliente2 = new Cliente();
		private ObservableList<Produto> ArrayProduto;
		private ProdutoDAO produtoDAO = new ProdutoDAO();
		private ClienteDAO clienteDAO = new ClienteDAO();


	    @FXML
	    void btnCancelar(ActionEvent event) {
	    	Stage stage = (Stage) btnCancelar.getScene().getWindow();
			stage.close();
	    }

	    @FXML
	    void btnPesquisarProduto(ActionEvent event) {
	    	ArrayProduto = FXCollections.observableArrayList(produtoDAO.search(txtNomeProduto.getText()));
			
			columnID.setCellValueFactory(new PropertyValueFactory<>("Codigo"));
			columnNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
			ColumnPreco.setCellValueFactory(new PropertyValueFactory<>("PrecoUn"));

		
			TableProduto.setItems(ArrayProduto);
			TableProduto.refresh();
	    }

	    @FXML
	    void btnSalvar(ActionEvent event) {
	    	if( cliente2 != null && produto != null && txtIDVendedor != null) {
	    	Alert mensagemDeAviso = new Alert(Alert.AlertType.CONFIRMATION);
	    	mensagemDeAviso.setContentText("Deseja realmente Salvar a venda para o vendedor : "+ txtNomeVendedor.getText());
	 
	    	Optional<ButtonType> resultado = mensagemDeAviso.showAndWait();
			
	 		if( resultado.isPresent() && resultado.get() == ButtonType.OK) {
	 	    	Alert mensagemDeExclusao = new Alert(Alert.AlertType.INFORMATION);
	 	    	mensagemDeExclusao.setContentText("Venda realizada com sucesso!");
	 	    	mensagemDeExclusao.show();
	 	    	CompraDAO compraDAO = new CompraDAO();
	 	    	Compra compra = new Compra();
	 	    	compra.setId_Cliente(cliente2.getId_cliente());
	 	    	compra.setId_Vendedor(txtIDVendedor.getText());
	 	    	compra.setId_Produto(produto.getId_produto());
	 	    	compra.setQuantidade(txtQuantidade.getText());
	 	    	compra.setPreco_total(txtPreçoTotal.getText());
	 	    	compraDAO.create(compra);
	 	    	txtIDCliente.setText("");
	 	    	txtNomeCliente.setText("");
	 	    	txtCPFCliente.setText("");
	 	    	txtCodigoProduto.setText("");
	 	    	txtNomeProduto.setText("");
	 	    	txtQuantidade.setText("");
	 	    	txtPrecoUn.setText("");
	 	    	txtPreçoTotal.setText("");
	 	    	txtDesconto.setText("");
	 	    	cliente2 = null;
	 			}
	    	}else {
	    		Alert mensagemDeExclusao = new Alert(Alert.AlertType.ERROR);
	 	    	mensagemDeExclusao.setContentText("Error ao salvar. Informações incompletas");
	 	    	mensagemDeExclusao.show();
	    	}
	    
	    }
	    Vendedor vendedor = new Vendedor();
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			CarregarTableProduto();
			cliente2 = null;
			//Parte do código responsável por carregar de forma automática as informações do vendedor para preencher os campos ID, CPF e Nome 
			//do vendedor na tela de Registrar venda, de acordo com o usuário que realizou Login.
			// 
			txtCPFVendedor.setText(ControllerLogin.vendedor.getCPF());
			txtNomeVendedor.setText(ControllerLogin.vendedor.getNome());
			txtIDVendedor.setText(ControllerLogin.vendedor.getId_Vendedor());
			txtQuantidade.setText("0");
			
			
			/**
			 * Método responsável por adicionar automaticamento o nome, código e preço unitário do produto nos camps da tela Registrar venda
			 * Este método será ativado quando o usuário der 2 CLIQUES em uma linha da tabela. As informações dessa linha irão prenncher 
			 * os campos respectivios do produto a ser vendido.
			 */
			TableProduto.setOnMouseClicked((MouseEvent clique) -> {
				if(clique.getClickCount() == 2) {
					int i = TableProduto.getSelectionModel().getSelectedIndex();
					produto = TableProduto.getItems().get(i);
					txtCodigoProduto.setText(produto.getCodigo());
					txtPrecoUn.setText(produto.getPrecoUn());
					txtNomeProduto.setText(produto.getNome());
				}
			});
			
		}
		
		 
		 
		/**
		 * Método responsável por carregar os produtos que serão exibidos na tabela Produto da tela Registrar venda
		 */
		public  void CarregarTableProduto() {
	    	ArrayProduto = FXCollections.observableArrayList(produtoDAO.read());
			
			columnID.setCellValueFactory(new PropertyValueFactory<>("Codigo"));
			columnNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
			ColumnPreco.setCellValueFactory(new PropertyValueFactory<>("PrecoUn"));
			
			TableProduto.setItems(ArrayProduto);
			}
		
		/**
		 * Método responsável por definir de forma automática o preço total e o desconto da compra com base no preço unitario do 
		 * produto e na quantidade que está sendo vendida. Se a quantidade for maior que 30, será aplicado um desconto de 15% a venda
		 * @param event
		 * Para funcionar, este método tem que estar presente dentro do action "On Key typed" do TextField de quantidade da tela de registro de venda.
		 */
	    @FXML
	    void definirPrecoTotal(KeyEvent event) {
	    	if(txtQuantidade.getText() != "" && txtQuantidade.getText()!= null) {
	   
	    	double quantidade = Double.parseDouble(txtQuantidade.getText());
	    	
	    	if(quantidade < 30) {
	    	txtDesconto.setText("");
	    	double precoTotal = Double.parseDouble(txtPrecoUn.getText())* Double.parseDouble(txtQuantidade.getText());
	    	txtPreçoTotal.setText(Double.toString(precoTotal));
	    	
	    	}else {
	    		
	    		double precoTotal = (Double.parseDouble(txtPrecoUn.getText())* Double.parseDouble(txtQuantidade.getText()));
	    		precoTotal = precoTotal * 0.85;
	        	txtPreçoTotal.setText(Double.toString(precoTotal));
	    		Double desconto = precoTotal * 0.15;
	    		txtDesconto.setText(Double.toString(desconto));
	    		
	    		}
	    	}
	    }
	    
	    /**
	     * Método responsável por definir de forma automática as informações do cliente(Nome, id) de acordo com o CPF digitado no textField CPF do cliente
	     * @param evente
	     * Para funcionar, este método tem que estar presente dentro do action "On Key typed" do TextField de CPF do cliente da classe registrar venda
	     */
	    @FXML
	    void definirCliente(KeyEvent evente) {
	    	if(clienteDAO.search(txtCPFCliente.getText()) != null) {
	    		cliente1 = clienteDAO.search(txtCPFCliente.getText());
	    		cliente2 = cliente1.get(0);
	    		txtIDCliente.setText(cliente2.getId_cliente());
	    		txtNomeCliente.setText(cliente2.getNome());
	    	} 
	    		
	    	
	    	
	    }

		@Override
		public void initialize(java.net.URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			
		}
	}

	
	