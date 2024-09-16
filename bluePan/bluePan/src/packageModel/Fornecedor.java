package packageModel;

public class Fornecedor {
	
	private String id_Fornecedor;
	private String Nome;
	private String CNPJ;
	private String Email;
	private String TElefone;
	private String Endereco;
	private String TipoJur;
	public Fornecedor() {
		super();
	}
	public Fornecedor(String id_Fornecedor, String nome, String cNPJ, String email, String tElefone, String endereco,
			String tipoJur) {
		super();
		this.id_Fornecedor = id_Fornecedor;
		Nome = nome;
		CNPJ = cNPJ;
		Email = email;
		TElefone = tElefone;
		Endereco = endereco;
		TipoJur = tipoJur;
	}
	public String getId_Fornecedor() {
		return id_Fornecedor;
	}
	public void setId_Fornecedor(String id_Fornecedor) {
		this.id_Fornecedor = id_Fornecedor;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getTElefone() {
		return TElefone;
	}
	public void setTElefone(String tElefone) {
		TElefone = tElefone;
	}
	public String getEndereco() {
		return Endereco;
	}
	public void setEndereco(String endereco) {
		Endereco = endereco;
	}
	public String getTipoJur() {
		return TipoJur;
	}
	public void setTipoJur(String tipoJur) {
		TipoJur = tipoJur;
	}
	
	

}