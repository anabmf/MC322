import java.time.*;
import java.util.*;


class ClientePJ extends Cliente {
	
	// Atributos
	private final String cnpj;
	private LocalDate dataFundacao;
	private int qtdFuncionarios;
	private List<Frota> listaFrotas = new ArrayList<Frota>();
	
	// Construtor
	public ClientePJ(String nome, String telefone, String endereco, String email, String cnpj, String dataFundacaoString, int qtdFuncionarios) {
		super(nome, telefone, endereco, email);
		this.cnpj = cnpj;
		LocalDate dataFundacao = LocalDate.parse(dataFundacaoString);
		this.dataFundacao = dataFundacao;
		this.qtdFuncionarios = qtdFuncionarios;
	}

	// Getter e Setters
	public String getCnpj() {
		return cnpj;
	}
	public LocalDate getDataFundacao() {
		return dataFundacao;
	}
	public int getQtdFuncionarios() {
		return qtdFuncionarios;
	}
	public List<Frota> getListaFrotas() {
        return listaFrotas;
    }
	public void setDataFundacao(LocalDate dataFundacao) {
		this.dataFundacao = dataFundacao;
	}
	public void setQtdFuncionarios(int qtdFuncionarios) {
		this.qtdFuncionarios = qtdFuncionarios;
	}
	public void setListaFrotas(List<Frota> listaFrotas) {
        this.listaFrotas = listaFrotas;
    }
	
	// toString 
	public String toString() {
		String imprimir = "ClientePJ [\n" + super.toString() + "cnpj: " + cnpj + ", \ndataFundacao: " + dataFundacao + ", \nqtdFuncionarios: " + qtdFuncionarios + ", \nlistaFrotas: \n";
		for (Frota frota : listaFrotas) {
			imprimir += frota.getCode() + "\n";
		}
		imprimir += "\n ]";
		return imprimir;
	}

	public boolean cadastrarFrota(Frota frota) {
        // adiciona uma frota na lista. retorna false se esse a frota já estiver na lista
        if (listaFrotas.contains(frota)) {
            return false;
        } else {
            listaFrotas.add(frota);
            return true;
        }    
    }

	public boolean atualizarFrota(Frota frota, Veiculo veiculo, String acao) {
		// Verifica se a frota já está na lista e se o veículo pertence à frota
		if (listaFrotas.contains(frota) && frota.getListaVeiculos().contains(veiculo)) {
			switch (acao) {
				case "adicionar":
					frota.getListaVeiculos().add(veiculo);
					break;
				case "remover":
					frota.getListaVeiculos().remove(veiculo);
					if (frota.getListaVeiculos().size() == 0) {
						listaFrotas.remove(frota);
					}
					break;
				default:
					return false; // Ação inválida, retorna false
			}
			return true; // Atualização da frota realizada com sucesso
		} else {
			return false; // Frota ou veículo não encontrados, retorna false
		}
	}

	public boolean getVeiculoPorFrota(String code, Veiculo veiculo) {
		for (Frota frota : listaFrotas) {
			if (frota.getCode().equals(code)) {
				System.out.println(frota.getListaVeiculos());
				return true;
			}
		}
		return false;
	}

	public int quantidadeVeiculos() {
		int quantidade = 0;
		for (Frota frota : listaFrotas) {
			quantidade += frota.getListaVeiculos().size();
		}
		return quantidade;
	}

	public int calculaIdade() {
		// retorna a idade baseado na data de fundacao
		LocalDate hoje = LocalDate.now();  
		Period idade = Period.between(dataFundacao, hoje);
		return idade.getYears();  
	}

}


