package lab02;

public class Seguradora {
	
// Declarando atributos
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
	
		
// Costrutor
	public Seguradora(String iniNome, String iniTelefone, String iniEmail, String iniEndereco) {
		nome = iniNome;
		telefone = iniTelefone;
		email = iniEmail;
		endereco = iniEndereco;
	}
	
	
// Metodos (getters e setters)
	public void setNome(String novoNome) {
		nome = novoNome;
	}
	public void setTelefone(String novoTelefone) {
		telefone = novoTelefone;
	}
	public void setEmail(String novoEmail) {
		email = novoEmail;
	}
	public void setEndereco(String novoEndereco) {
		endereco = novoEndereco;
	}
	
	public String getNome() {
		return nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public String getEmail() {
		return email;
	}
	public String getEndereco() {
		return endereco;
	}
	public String toString() {
		return "Seguradora [nome=" + nome + ", telefone=" + telefone + ", email=" + email + ", endereco=" + endereco
				+ "]";
	}
	
}
