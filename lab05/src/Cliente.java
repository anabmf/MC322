public abstract class Cliente {

// Atributos
	private String nome;
	private String telefone; 
	private String endereco; 
	private String email; 
	
// Costrutor
	public Cliente(String nome, String telefone, String endereco, String email) {
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.email = email;
	}
	
// Metodos
	public String getNome() {
		return nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String toString() {
		return "nome: " + nome + ", \nendereco: " + endereco + ", \ntelefone: " + telefone + "\nemail: " + email + "\n";
	}
	
}
