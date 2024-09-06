package packageController;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ControllerMain {

    @FXML
    private Button btnButtonCliente;
    
    @FXML
    private Button btnPesquisar;

    @FXML
    private Button btnButtonFornecedor;

    @FXML
    private Button btnButtonProduto;

    @FXML
    private Button btnButtonRegistrarVenda;

    @FXML
    private Button btnButtonRelatorio;

    @FXML
    private Button btnButtonVendedor;

    @FXML
    void btButtonProduto(ActionEvent event) {
    	Main.changeScreen("produto");
    }

    @FXML
    void btButtonRegistrarVenda(ActionEvent event) {

    }

    @FXML
    void btButtonRelatoio(ActionEvent event) {

    }
   @FXML
    void btnPesquisarAction(ActionEvent event) {
    	
    }
	
	@FXML
	void btButtonVendedor(ActionEvent event) {
		Main.changeScreen("vendedor");
	}
	
	@FXML
	void btButtonCliente(ActionEvent event) {
		Main.changeScreen("cliente");
	}
	@FXML
	void btButtonFornecedor(ActionEvent event) {
		Main.changeScreen("fornecedor");
	}

}
