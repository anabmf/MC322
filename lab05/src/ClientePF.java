import java.time.*;  
import java.util.*;


class ClientePF extends Cliente {
	
	// Atributos
	private final String cpf;
	private String genero;
	private String educacao;
	private LocalDate dataNascimento;
	private List<Veiculo> listaVeiculos = new ArrayList<Veiculo>();
	
	
	// Construtor
	public ClientePF(String nome, String telefone, String endereco, String email, String cpf, String genero, String educacao, String dataNascimentoString) {
		super(nome, telefone, endereco, email);
		this.cpf = cpf;
		this.genero = genero;
		this.educacao = educacao;
		LocalDate dataNascimento = LocalDate.parse(dataNascimentoString);
		this.dataNascimento = dataNascimento;
	}
	
	// Getters e Setters
	public String getCpf() {
		return cpf;
	}
	public String getGenero() {
		return genero;
	}
	public String getEducacao() {
		return educacao;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public List<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public void setEducacao(String educacao) {
		this.educacao = educacao;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public void setListaVeiculos(List<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }
	
	//toString 
	public String toString() {
		String imprimir = "ClientePF [\n" + super.toString() + "cpf: " + cpf + ", \ngenero: " + genero + ", \neducacao: "
				+ educacao + ", \ndataNascimento: " + dataNascimento + ", \nlistaVeiculos: \n";
		for (Veiculo veiculo : listaVeiculos) {
			imprimir += veiculo.getPlaca() + "\n";
		}
		imprimir += "\n ]";
		return imprimir;
	}

	public boolean cadastrarVeiculo(Veiculo veiculo) {
        // adiciona um veiculo na lista. retorna false se esse veiculo já estiver na lista
        if (listaVeiculos.contains(veiculo)) {
            return false;
        } else {
            listaVeiculos.add(veiculo);
            return true;
        }    
    }

    public boolean removerVeiculo(Veiculo veiculo) {
        // remove um veiculo da lista. retorna false se esse veiculo nao estiver na frota
        if (listaVeiculos.contains(veiculo)) {
            listaVeiculos.remove(veiculo);
            return true;
        } else {
            return false;
        }  
    }

	public int calculaIdade() {
		// retorna a idade baseado na data de nascimento
		LocalDate hoje = LocalDate.now();  
		Period idade = Period.between(dataNascimento, hoje);
		return idade.getYears();  
	}


}

