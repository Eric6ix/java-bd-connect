package packageModel;

public class Produto {

	private String id_produto;
	private String Codigo;
	private String Nome;
	private String Estoque;
	private String Preco_un;
	private String Data_fab;
	private String Data_val;
	private String Tipo_un;
	
	public Produto() {
		super();
	}
	public String getTipo_un() {
		return Tipo_un;
	}
	public void setTipo_un(String tipo_un) {
		this.Tipo_un = tipo_un;
	}
	public Produto(String id_produto, String codigo, String nome, String estoque, String preco_un, String data_fab,
			String data_val) {
		super();
		this.id_produto = id_produto;
		Codigo = codigo;
		Nome = nome;
		Estoque = estoque;
		Preco_un = preco_un;
		Data_fab = data_fab;
		Data_val = data_val;
	}
	public String getId_produto() {
		return id_produto;
	}
	public void setId_produto(String id_produto) {
		this.id_produto = id_produto;
	}
	public String getCodigo() {
		return Codigo;
	}
	public void setCodigo(String codigo) {
		Codigo = codigo;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getEstoque() {
		return Estoque;
	}
	public void setEstoque(String estoque) {
		Estoque = estoque;
	}
	public String getPreco_un() {
		return Preco_un;
	}
	public void setPreco_un(String preco_un) {
		Preco_un = preco_un;
	}
	public String getData_fab() {
		return Data_fab;
	}
	public void setData_fab(String data_fab) {
		Data_fab = data_fab;
	}
	public String getData_val() {
		return Data_val;
	}
	public void setData_val(String data_val) {
		Data_val = data_val;
	}
	
	
	
}	