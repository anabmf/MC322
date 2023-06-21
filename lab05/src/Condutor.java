import java.util.*;
import java.time.*;

public class Condutor {
    // Atributos
    private final String cpf;
    private String nome;
    private String telefone;
    private String endereco;
    private String email;
    private LocalDate dataNasc;
    private List<Sinistro> listaSinistros = new ArrayList<Sinistro>();

    // Costrutor
    public Condutor(String cpf, String nome, String telefone, String endereco, String email, String dataNascString) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
        LocalDate dataNasc = LocalDate.parse(dataNascString);
        this.dataNasc = dataNasc;
    }

    // Metodos
    public String getCpf() {
		return cpf;
	}
    public String getNome() {
		return nome;
	}
    public String getTelefone() {
		return telefone;
	}
    public String getEndereco() {
		return endereco;
	}
    public String getEmail() {
		return email;
	}
    public LocalDate getDataNasc() {
		return dataNasc;
	}
    public List<Sinistro> getListaSinistros() {
		return listaSinistros;
	}
    public void setNome(String nome) {
		this.nome = nome;
	}
    public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
    public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
    public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}
    public void setListaSinistros(List<Sinistro> listaSinistros) {
		this.listaSinistros = listaSinistros;
	}

  public void addSinistro(Sinistro sinistro) {
    // adiciona um sinistro na lista de sinistros
        listaSinistros.add(sinistro);
    }    
}
  

