import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Seguradora {
	
// Declarando atributos
	private final String cnpj;
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
	private List<Seguro> listaSeguros = new ArrayList<Seguro>();
	private List<Cliente> listaClientes = new ArrayList<Cliente>();
	
		
// Construtor
	public Seguradora(String cnpj, String nome, String telefone, String email, String endereco) {
		this.cnpj = cnpj;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
	}
	
	
// getters e setters
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
	public void setListaSinistros(List<Seguro> listaSeguros) {
		this.listaSeguros = listaSeguros;
	}
	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public String getCnpj() {
		return cnpj;
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
	public List<Seguro> getListaSeguros() {
		return listaSeguros;
	}
	public List<Cliente> getListaClientes() {
		return listaClientes;
	}


// toString
	public String toString() {
		String impressao = "cnpj = " + cnpj +  ", \nnome = " + nome + ", \ntelefone = " + telefone + ", \nemail = " + email + 
		", \nendereco = " + endereco + ", \nlistaSinistros:\n";
		for (Seguro seguro : listaSeguros) {
			impressao += seguro.toString();
		}
		impressao += ", \nlistaClientes:" ;
		for (Cliente cliente : listaClientes) {
			impressao += cliente.toString();
		}
		return impressao;
	}
	
	
	public boolean cadastrarCliente(Cliente novoCliente) {
		//retorna "true" e adiciona um cliente a listaClientes se não houver novoCliente na lista 
		//caso contrario, retorna "false"
		if (!(listaClientes.contains(novoCliente))){
			listaClientes.add(novoCliente);
			return true;
		} else {
			return false;
		}	
	}
	
	
	public boolean removerCliente(Cliente cliente) {
		//remove cliente e retorna "true" se cliente estiver em listaClientes
		//se nao estiver, retorna "false"
		if (listaClientes.contains(cliente)) {
			listaClientes.remove(cliente);
			return true;
		} else {
		return false;
		}
	}
	
	
	public void listarClientes(String tipoCliente) {
		//imprime os nomes dos clientes que satistizerem tipoCliente
		if ((tipoCliente.equals("cpf") || tipoCliente.equals("CPF"))) {
			for (Cliente cliente : listaClientes) {
				if (cliente instanceof ClientePF) {
					System.out.println(cliente.getNome());
				}
			}
		} else if ((tipoCliente.equals("cnpj") || tipoCliente.equals("CNPJ"))) {
			for (Cliente cliente : listaClientes) {
				if (cliente instanceof ClientePJ) {
					System.out.println(cliente.getNome());
				}
			}
		}
	}


	public boolean gerarSeguro(String dataInicio, String dataFim, Seguradora seguradora, Veiculo veiculo, ClientePF cliente) {
		LocalDate dataI = LocalDate.parse(dataInicio);
		LocalDate dataF = LocalDate.parse(dataFim);
		Seguro seguro = new SeguroPF(dataI, dataF, seguradora, veiculo, cliente);
        listaSeguros.add(seguro);
		return true;
    }

	public boolean gerarSeguro(String dataInicio, String dataFim, Seguradora seguradora, Frota frota, ClientePJ cliente) {
		LocalDate dataI = LocalDate.parse(dataInicio);
		LocalDate dataF = LocalDate.parse(dataFim);
		Seguro seguro = new SeguroPJ(dataI, dataF, seguradora, frota, cliente);
        listaSeguros.add(seguro);
		return true;
    }

	public boolean cancelarSeguro(Seguro seguro) {
       if (listaSeguros.contains(seguro)) {
            listaSeguros.remove(seguro);
            return true;
        } else {
            return false;
        }  
    }

	public ArrayList<Seguro> getSegurosPorCliente(Cliente cliente) {
		ArrayList<Seguro> seguros = new ArrayList<Seguro>();
		for (Seguro seguro : listaSeguros) {
			for (Condutor condutor : seguro.getListaCondutores()) {
				if (condutor.getNome() == cliente.getNome()) {
					seguros.add(seguro);
				}
			}
		}
		return seguros;
	}

	public ArrayList<Sinistro> getSinistrosPorCliente(Cliente cliente) {
		ArrayList<Sinistro> sinistros = new ArrayList<Sinistro>();
		for (Seguro seguro : listaSeguros) {
			for (Sinistro sinistro : seguro.getListaSinistros()) {
				if (sinistro.getCondutor().getNome() == cliente.getNome()) {
					sinistros.add(sinistro);
				}
			}
		}
		return sinistros;
	}


	public double calcularReceita() {
		double receita = 0;
		for (Seguro seguro : listaSeguros) {
			receita += seguro.getValorMensal();
		}
		System.out.println(receita);
		return receita;
	}

}
