package application;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;


public class Main extends Application {
	private static Stage stage;
	private static Scene login;
	private static Scene main;
	private static Scene vendedor;
	private static Scene cliente;
	private static Scene fornecedor;

	@Override
	public void start(Stage primaryStage) {
		try {

			stage = primaryStage;

			primaryStage.setTitle("Blue Pan");

			Parent fxmlLogin = FXMLLoader.load(getClass().getResource("/packageview/ViewLogin.fxml"));
			login = new Scene(fxmlLogin);

			Parent fxmlMain = FXMLLoader.load(getClass().getResource("/packageview/ViewMain.fxml"));
			main = new Scene(fxmlMain);
			
			Parent fxmlFornecedor = FXMLLoader.load(getClass().getResource("/packageview/ViewFornecedor.fxml"));
			fornecedor = new Scene(fxmlFornecedor );

			Parent fxmlVendedor = FXMLLoader.load(getClass().getResource("/packageview/ViewVendedor.fxml"));
			vendedor = new Scene(fxmlVendedor);

			Parent fxmlCliente = FXMLLoader.load(getClass().getResource("/packageview/ViewCliente.fxml"));
			cliente = new Scene(fxmlCliente);
			
			primaryStage.setScene(login);
			primaryStage.show();
/*
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();*/

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//126543459
	public static void changeScreen(String tela) {
		if (tela.equals("login")) {
			stage.setScene(login);
		}else if (tela.equals("main")) {
			stage.setScene(main);
			}else if(tela.equals("vendedor")) {
				stage.setScene(vendedor);
			}else if(tela.equals("fornecedor")) {
				stage.setScene(fornecedor);
			}else if(tela.equals("cliente")) {
				stage.setScene(cliente);
			}
		}

	
	public static void main(String[] args) {
/*
		// verificar uma linha de uma tabela manualmente
		ClienteDAO c = new ClienteDAO();

		ArrayList<Cliente> cliente = new ArrayList<>(); // só é ultilizado com o read"metodo"
		cliente = c.read();
		for (int i = 0; i < cliente.size(); i++) {
			Cliente clt = cliente.get(i);
			System.out.println();
			System.out.print(clt.getId_cliente() + "| ");
			System.out.print(clt.getNome() + "| ");
			System.out.print(clt.getCPF_CNPJ() + "| ");
			System.out.print(clt.getEmail() + "| ");
			System.out.print(clt.getTelefone() + "| ");
			System.out.print(clt.getData_nasc() + "| ");
			System.out.print(clt.getData_primComp() + "| ");
			System.out.print(clt.getEndereco() + "| ");
			System.out.print(clt.getTipoJur() + "| ");

		}

		// create manual :

		Cliente cl = new Cliente();
		cl.setNome("pedro");
		cl.setCPF_CNPJ("126345569"); // quando é coluna de tipo unico repete o update no final || e também para
		cl.setData_nasc("1970-04-21");
		cl.setData_primComp("2024-05-09");// identificar a coluna ãncora
		cl.setEmail("poop@teste.com");
		cl.setEndereco("Rua xTudo, numero 363");
		cl.setTelefone("63 9976545-6765"); // quando fizer o update, tem que dar outro select no banco para atualizar|
		cl.setTipoJur("Pj");
		//c.create(cl);
		//c.update(cl);
		// delete manual:
		// c.delete("126543459");
*/
	/*	// =======================================
		CompraDAO c = new CompraDAO();
		ArrayList<Compra> compra = new ArrayList<>(); // só é ultilizado com o read"metodo"
		compra = c.read();
		for (int i = 0; i < compra.size(); i++) {
			Compra clt = compra.get(i);
			System.out.println();
			System.out.print(clt.getId_Compra() + "| ");
			System.out.print(clt.getId_Compra() + "| ");
			System.out.print(clt.getId_Vendedor() + "| ");
			System.out.print(clt.getId_Produto() + "| ");
			System.out.print(clt.getQuantidade() + "| ");
			System.out.print(clt.getPreco_total() + "| ");
		}


		Compra cl = new Compra();            // identificar a coluna ãncora
		cl.setId_Compra("");
		cl.setId_Cliente(""); // quando é coluna de tipo unico repete o update no final || e também para
		cl.setId_Vendedor("");
		cl.setId_Produto("");
		cl.setQuantidade("20");
		cl.setPreco_total("90");
		// c.update(cl);
		 c.create(cl);
		//c.delete("1");																											//ta faltando compra
*/		

		// =================================================

		// verificar uma linha de uma tabela manualmente
/*
		VendedorDAO c = new VendedorDAO();

		ArrayList<Vendedor> vendedor = new ArrayList<>(); // só é ultilizado com o read"metodo"
		vendedor = c.read();
		for (int i = 0; i < vendedor.size(); i++) {
			Vendedor clt = vendedor.get(i);
			System.out.println();
			System.out.print(clt.getId_Vendedor() + "| ");
			System.out.print(clt.getNome() + "| ");
			System.out.print(clt.getCPF() + "| ");
			System.out.print(clt.getEmail() + "| ");
			System.out.print(clt.getTelefone() + "| ");
			System.out.print(clt.getData_nasc() + "| ");
			System.out.print(clt.getData_cont() + "| ");
			System.out.print(clt.getTotal_vend() + "| ");
			System.out.print(clt.getEndereco() + "| ");

		}

		// create manual :

		Vendedor cl = new Vendedor();
		cl.setNome("Ronaldo");
		cl.setCPF("126543459"); // quando é coluna de tipo unico repete o update no final || e também para
								// identificar a coluna ãncora
		cl.setEmail("nopeonamao@teste.com");
		cl.setTelefone("639976545-6765"); // quando fizer o update, tem que dar outro select no banco para atualizar|
		cl.setData_nasc("1970-04-21");
		cl.setData_cont("2024-05-09");
		cl.setTotal_vend("2024");
		cl.setEndereco("Rua xTudo, numero 363");
		c.create(cl);

		// update manual:

		// para poder usar update é obrigatório usar o cpf para a máquina saber o ID
		// certo

		Vendedor cl = new Vendedor();
		cl.setNome("Rogerio");
		cl.setCPF("126543459");
		cl.setEmail("teste@gmail");
		cl.setTelefone("63 9920005-6225");
		cl.setData_nasc("2024-05-09");
		cl.setData_cont("2000-07-08");
		cl.setTotal_vend("293");
		cl.setEndereco("Rua br 153, numero 1");
		c.update(cl);

		/// delete manual:
		// c.delete("458483455");*/
		
		
		
		
		
		// =======================================================
/*
		FornecedorDAO c = new FornecedorDAO();

		ArrayList<Fornecedor> fornecedor = new ArrayList<>(); // só é ultilizado com o read"metodo"
		fornecedor = c.read();
		for (int i = 0; i < fornecedor.size(); i++) {
			Fornecedor clt = fornecedor.get(i);
			System.out.println();
			System.out.print(clt.getId_Fornecedor() + "| ");
			System.out.print(clt.getNome() + "| ");
			System.out.print(clt.getCNPJ() + "| ");
			System.out.print(clt.getEmail() + "| ");
			System.out.print(clt.getTElefone() + "| ");
			System.out.print(clt.getEndreco() + "| ");
			System.out.print(clt.getTipo_un() + "| ");
			System.out.print(clt.getTipoJur() + "| ");

		}


		// para poder usar update é obrigatório usar o cpf para a máquina saber o ID
		// certo

		Fornecedor clo = new Fornecedor();
		clo.setNome("Clovis");
		clo.setCNPJ("126543459"); // quando é coluna de tipo unico repete o update no final || e também para
		clo.setEmail("nopeonamao@teste.com");
		clo.setTElefone("639976545-6765"); // quando fizer o update, tem que dar outro select no banco para atualizar|
		clo.setEndreco("Rua xTudo, numero 363");
		clo.setTipo_un("p");
		clo.setTipoJur("pj");
		c.update(clo);
		c.create(clo);
		/// delete manual:
		// c.delete("126543459");
*/
		// ===============================================================
/*
		ProdutoDAO c = new ProdutoDAO();

		ArrayList<Produto> produto = new ArrayList<>(); // só é ultilizado com o read"metodo"
		produto = c.read();
		for (int i = 0; i < produto.size(); i++) {
			Produto clt = produto.get(i);
			System.out.println();
			System.out.print(clt.getCodigo() + "| ");
			System.out.print(clt.getNome() + "| ");
			System.out.print(clt.getEstoque() + "| ");
			System.out.print(clt.getPreco_un() + "| ");
			System.out.print(clt.getData_fab() + "| ");
			System.out.print(clt.getData_val() + "| ");

		}

		Produto cl = new Produto();            // identificar a coluna ãncora
		cl.setNome("Arroz");
		cl.setCodigo("001001"); // quando é coluna de tipo unico repete o update no final || e também para
		cl.setEstoque("67");
		cl.setPreco_un("13");
		cl.setData_fab("03-02-2022");
		cl.setData_val("02-09-2023");
		// c.update(cl);
		// c.create(cl);
		c.delete("001001");
*/
		launch(args);

	}
}
