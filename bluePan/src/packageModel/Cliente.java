package packageModel;

public class Cliente {

	private String id_cliente;
	private String Nome;
	private String CPF_CNPJ;
	private String Email;			//alt+shift+S
	private String Telefone;
	private String Data_nasc;
	private String Data_primComp;
	private String Endereco;
	private String TipoJur;
	
	
	
	public Cliente() {
		super();
	}



	public Cliente(String id_cliente, String nome, String cPF_CNPJ, String email, String telefone, String data_nasc,
			String data_primComp, String endereco, String tipoJur) {
		super();
		this.id_cliente = id_cliente;
		Nome = nome;
		CPF_CNPJ = cPF_CNPJ;
		Email = email;
		Telefone = telefone;
		Data_nasc = data_nasc;
		Data_primComp = data_primComp;
		Endereco = endereco;
		TipoJur = tipoJur;
	}



	public String getId_cliente() {
		return id_cliente;
	}



	public void setId_cliente(String id_cliente) {
		this.id_cliente = id_cliente;
	}



	public String getNome() {
		return Nome;
	}



	public void setNome(String nome) {
		Nome = nome;
	}



	public String getCPF_CNPJ() {
		return CPF_CNPJ;
	}



	public void setCPF_CNPJ(String cPF_CNPJ) {
		CPF_CNPJ = cPF_CNPJ;
	}



	public String getEmail() {
		return Email;
	}



	public void setEmail(String email) {
		Email = email;
	}



	public String getTelefone() {
		return Telefone;
	}



	public void setTelefone(String telefone) {
		Telefone = telefone;
	}



	public String getData_nasc() {
		return Data_nasc;
	}



	public void setData_nasc(String data_nasc) {
		Data_nasc = data_nasc;
	}



	public String getData_primComp() {
		return Data_primComp;
	}



	public void setData_primComp(String data_primComp) {
		Data_primComp = data_primComp;
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

	