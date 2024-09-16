package packageModel;



public class Vendedor {
	
	private String id_Vendedor;
	private String Nome;
	private String CPF;
	private String Email;
	private String Telefone;
	private String Data_nasc;
	private String Data_cont;
	private String Total_vend;
	private String Endereco;
	private String Password;
	public Vendedor() {
		super();
	}
	public Vendedor(String id_Vendedor, String nome, String cPF, String email, String telefone, String data_nasc,
			String data_cont, String total_vend, String endereco, String password) {
		super();
		this.id_Vendedor = id_Vendedor;
		Nome = nome;
		CPF = cPF;
		Email = email;
		Telefone = telefone;
		Data_nasc = data_nasc;
		Data_cont = data_cont;
		Total_vend = total_vend;
		Endereco = endereco;
		Password = password;
	}
	public String getId_Vendedor() {
		return id_Vendedor;
	}
	public void setId_Vendedor(String id_Vendedor) {
		this.id_Vendedor = id_Vendedor;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
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
	public String getData_cont() {
		return Data_cont;
	}
	public void setData_cont(String data_cont) {
		Data_cont = data_cont;
	}
	public String getTotal_vend() {
		return Total_vend;
	}
	public void setTotal_vend(String total_vend) {
		Total_vend = total_vend;
	}
	public String getEndereco() {
		return Endereco;
	}
	public void setEndereco(String endereco) {
		Endereco = endereco;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
}