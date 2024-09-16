package packageModel;

public class Compra {
	private String id_Compra;
	private String id_Cliente;
	private String id_Vendedor;
	private String id_Produto;
	private String Quantidade;
	private String preco_total;
	public Compra(String id_Compra, String id_Cliente, String id_Vendedor, String id_Produto, String quantidade,
			String preco_total) {
		super();
		this.id_Compra = id_Compra;
		this.id_Cliente = id_Cliente;
		this.id_Vendedor = id_Vendedor;
		this.id_Produto = id_Produto;
		Quantidade = quantidade;
		this.preco_total = preco_total;
	}
	public Compra() {
		// TODO Auto-generated constructor stub
	}
	public String getId_Compra() {
		return id_Compra;
	}
	public void setId_Compra(String id_Compra) {
		this.id_Compra = id_Compra;
	}
	public String getId_Cliente() {
		return id_Cliente;
	}
	public void setId_Cliente(String id_Cliente) {
		this.id_Cliente = id_Cliente;
	}
	public String getId_Vendedor() {
		return id_Vendedor;
	}
	public void setId_Vendedor(String id_Vendedor) {
		this.id_Vendedor = id_Vendedor;
	}
	public String getId_Produto() {
		return id_Produto;
	}
	public void setId_Produto(String id_Produto) {
		this.id_Produto = id_Produto;
	}
	public String getQuantidade() {
		return Quantidade;
	}
	public void setQuantidade(String quantidade) {
		Quantidade = quantidade;
	}
	public String getPreco_total() {
		return preco_total;
	}
	public void setPreco_total(String preco_total) {
		this.preco_total = preco_total;
	}
	
}
