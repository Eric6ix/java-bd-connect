package packageController;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import packageControler.VendedorDAO;
import packageModel.Vendedor;

public class ControllerLogin {

    @FXML
    private ToggleButton VerSenha;

    @FXML
    private Button btnButton;

    @FXML
    private Button btnButton1;

    @FXML
    private Button btnButton11;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtSenha;

    @FXML
    private TextField txtUser;
    
    
    @FXML
    void btnButtonTeste(ActionEvent event) {
    	VendedorDAO v = new VendedorDAO();
        Vendedor vendedor = new Vendedor();
        
        vendedor = v.altenticarUser(txtUser.getText(), txtPassword.getText());
        
        if(vendedor.getPassword()!=null && vendedor.getCPF()!=null) { 
        	Alert saudacao = new Alert(Alert.AlertType.CONFIRMATION);
        saudacao.setHeaderText("Saudação");
        saudacao.setContentText("Seja bem vindo de volta"+ vendedor.getNome()+"!");
        saudacao.show();
        	Main.changeScreen("main");
        }
        else {
        	Alert erro = new Alert(Alert.AlertType.ERROR);
        	erro.setTitle("Falha no login!");
        	erro.setHeaderText("ERRO");
        	erro.setContentText("Usuário ou senha inválido!");
        	erro.show();
        }
        	
    }
    
    @FXML
    void visualizarSenha(ActionEvent event) {
    	if(VerSenha.isSelected()){
    		txtSenha.setText(txtPassword.getText());
    		txtPassword.setVisible(false);
    		txtSenha.setVisible(true);
    	}
    	else {
    		txtPassword.setText(txtSenha.getText());
    		txtPassword.setVisible(true);
    		txtSenha.setVisible(false);
    	}
    	}
    
    @FXML
    void btnButtonLogin(ActionEvent event) {
    	
    }
    
}
   

