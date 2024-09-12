package packageController;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ControllerCadastroVenda implements Initializable{

    @FXML
    private TableView<?> TableVenda;

    @FXML
    private TextField TxtFieldPsquisa;

    @FXML
    private TextField TxtFieldPsquisa1;

    @FXML
    private TextField TxtFieldPsquisa11;

    @FXML
    private TextField TxtFieldPsquisa111;

    @FXML
    private TextField TxtFieldPsquisa112;

    @FXML
    private TextField TxtFieldPsquisa1121;

    @FXML
    private TextField TxtFieldPsquisa1122;

    @FXML
    private TextField TxtFieldPsquisa12;

    @FXML
    private TextField TxtFieldPsquisa121;

    @FXML
    private TextField TxtFieldPsquisa13;

    @FXML
    private TextField TxtFieldPsquisa14;

    @FXML
    private Button btnEditar;

    @FXML
    private Button btnExcluir;

    @FXML
    private Button btnPesquisar;

    @FXML
    private TableColumn<?, ?> columnCNPJ;

    @FXML
    private TableColumn<?, ?> columnID;

    @FXML
    private TableColumn<?, ?> columnNOME;

    @FXML
    private Text txtFornecedor;

    @FXML
    void btnDeletarFornecedor(ActionEvent event) {

    }

    @FXML
    void btnEditarACTION(ActionEvent event) {

    }

    @FXML
    void btnPesquisarAction(ActionEvent event) {

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}

