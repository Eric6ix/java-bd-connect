package packageController;

import java.io.IOException;

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
    private Button btButtonRegistrarVenda;

    @FXML
    private Button btnButtonRelatorio;

    @FXML
    private Button btnButtonVendedor;

    
    @FXML
    void btButtonRegistrarVenda(ActionEvent event) throws IOException {
    	Main.changeScreen("Cvenda");
    }

    @FXML
    void btButtonVenda(ActionEvent event) {
    	Main.changeScreen("relatorio");
    }
    
    @FXML
    void btButtonProduto(ActionEvent event) {
    	Main.changeScreen("produto");
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
