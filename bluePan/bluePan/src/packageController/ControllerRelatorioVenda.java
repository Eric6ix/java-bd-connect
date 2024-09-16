package packageController;

import java.net.URL;

import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import packageControler.CompraDAO;
import packageModel.Compra;

public class ControllerRelatorioVenda implements Initializable {

	@FXML
	private TableView<Compra> TableCompra;

	@FXML
	private Button btnCadastrar;

	@FXML
	private Button btnPesquisar;

	@FXML
	private Button btnVoltar;

	@FXML
	private TextField TxtFieldPsquisa;

	@FXML
	private TableColumn<Compra, String> columnCLIENTE;

	@FXML
	private TableColumn<Compra, String> columnID;

	@FXML
	private TableColumn<Compra, String> columnPRODUTO;

	@FXML
	private TableColumn<Compra, String> columnQUANTIDADE;

	@FXML
	private TableColumn<Compra, String> columnVENDEDOR;

	@FXML
	private TableColumn<Compra, String> columnPRECOTOTAL;

	private ObservableList<Compra> ArrayCompra;
	private CompraDAO compra = new CompraDAO();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		CarregarRelatorio();
	}

	private void CarregarRelatorio() {
		ArrayCompra = FXCollections.observableArrayList(compra.read());

		columnID.setCellValueFactory(new PropertyValueFactory<>("id_Compra"));
		columnVENDEDOR.setCellValueFactory(new PropertyValueFactory<>("id_Cliente"));
		columnCLIENTE.setCellValueFactory(new PropertyValueFactory<>("id_Vendedor"));
		columnPRODUTO.setCellValueFactory(new PropertyValueFactory<>("id_Produto"));
		columnQUANTIDADE.setCellValueFactory(new PropertyValueFactory<>("Quantidade"));
		columnPRECOTOTAL.setCellValueFactory(new PropertyValueFactory<>("preco_total"));
		TableCompra.setItems(ArrayCompra);
		TableCompra.refresh();
	}

	@FXML
	void btnPesquisarAction(ActionEvent event) {

		ArrayCompra = FXCollections.observableArrayList(compra.search(TxtFieldPsquisa.getText()));

		columnID.setCellValueFactory(new PropertyValueFactory<>("id_Compra"));
		columnVENDEDOR.setCellValueFactory(new PropertyValueFactory<>("id_Cliente"));
		columnCLIENTE.setCellValueFactory(new PropertyValueFactory<>("id_Vendedor"));
		columnPRODUTO.setCellValueFactory(new PropertyValueFactory<>("id_Produto"));
		columnQUANTIDADE.setCellValueFactory(new PropertyValueFactory<>("Quantidade"));
		columnPRECOTOTAL.setCellValueFactory(new PropertyValueFactory<>("preco_total"));

		TableCompra.setItems(ArrayCompra);
		TableCompra.refresh();
	}

}
