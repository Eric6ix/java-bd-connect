package packageController;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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
    private DatePicker datePCompra;

    @FXML
    private DatePicker datePNascimento;

    @FXML
    private Text txt;

    @FXML
    private TextField txtfCodigo;

    @FXML
    private Text txtfEstoque;

    @FXML
    private TextField txtfFone;

    @FXML
    private ChoiceBox<?> txtfFornecedor;

    @FXML
    private TextField txtfNome;

    @FXML
    private TextField txtfPrecoUn;

    @FXML
    private TextField txtfTipoUn;
    
    void btnCadastrarProduto(ActionEvent event) {
    	Produto produto = new Produto();
    	produto.setNome(txtfNome.getText());
    	produto.setCodigo(txtfCodigo.getText());
    	produto.setPreco_un(txtfPrecoUn.getText());
    	produto.setNome(datePCompra.getValue().toString());
    	produto.setNome(datePNascimento.getValue().toString());
    	produto.setNome(txtfTipoUn.getText());
    ProdutoDAO prod = new ProdutoDAO();
    prod.create(produto);
    ControllerProduto.Carregar
    }
    
    
    void btnDeletarProduto(ActionEvent event) {
    	txtfNome.setText("");
		txtfCodigo.setText("");
		txtfEstoque.setText("");
		txtfPrecoUn.setText("");
		txtfTipoUn.setText("");
		datePCompra.setValue(null);
		datePNascimento.setValue(null);
		ControllerProduto.produtoEdtar = null;
		
		Stage stage = (Stage) btnCancelar.getScene().getWindow();
		stage.close();
    }
    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		
		if(ControllerProduto.produtoEdtar!=null) {
			txtfNome.setText(ControllerProduto.produtoEdtar.getNome());
			txtfCodigo.setText(ControllerProduto.produtoEdtar.getCodigo());
			txtfEstoque.setText(ControllerProduto.produtoEdtar.getEstoque());
			txtfPrecoUn.setText(ControllerProduto.produtoEdtar.getPreco_un());
			txtfTipoUn.setText(ControllerProduto.produtoEdtar.getTipo_un());
		}
	}

}
