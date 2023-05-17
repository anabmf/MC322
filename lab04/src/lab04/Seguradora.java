package lab04;

import java.util.ArrayList;
import java.util.List;

public class Seguradora {
	
// Declarando atributos
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
	private List<Sinistro> listaSinistros;
	private List<Cliente> listaClientes;
	
		
// Construtor
	public Seguradora(String nome, String telefone, String email, String endereco) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.listaSinistros = new ArrayList<Sinistro>();
		this.listaClientes = new ArrayList<Cliente>();
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
	public void setListaSinistros(List<Sinistro> listaSinistros) {
		this.listaSinistros = listaSinistros;
	}
	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
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
	public List<Sinistro> getListaSinistros() {
		return listaSinistros;
	}
	public List<Cliente> getListaClientes() {
		return listaClientes;
	}


// toString
	public String toString() {
		String impressao =  "nome = " + nome + ", \ntelefone = " + telefone + ", \nemail = " + email + 
		", \nendereco = " + endereco + ", \nlistaSinistros:\n";
		for (Sinistro sinistro : listaSinistros) {
			impressao += sinistro.toString();
		}
		impressao += ", \nlistaClientes:" ;
		for (Cliente cliente : listaClientes) {
			impressao += cliente.toString();
		}
		return impressao;
	}
	
// outros metodos
	
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
	
	
	public boolean gerarSinistro(Sinistro novoSinistro) {
		// retorna "true" e adiciona novoSinistro em listaSinistros caso novoSinistro nao esteja na lista
		// caso contrario, retorna "false"
		if (!(listaSinistros.contains(novoSinistro))){
			listaSinistros.add(novoSinistro);
			return true;
		} else {
			return false;
		}	
	}
	
	
	public boolean visualizarSinistro(String cliente) {
		//imprime os ids dos sinistros relacionados ao cliente
		//imprime "true" se houver sinistros relacionados ao cliente. caso contrario, retorna "false"
		int contador = 0;
		for (Sinistro sinistro : listaSinistros) {
			if (sinistro.getCliente().getNome() == cliente) {
				System.out.println(sinistro.getId());
			} else {
				contador++;
			}
		}
		if (contador == listaSinistros.size()) {
			return false;
		} else {
			return true;
		}	
	}
	
	
	public void listarSinistros() {
		//lista todos os sinistros registrados
		for (Sinistro sinistro : listaSinistros) {
			System.out.println(sinistro.toString());
		}
	}

	public void calcularPrecoSeguroCliente(Cliente cliente) {
		double precoSeguro = cliente.calculaScore() * (1 + listaSinistros.size());
		cliente.setValorSeguro(precoSeguro);
		System.out.println(precoSeguro);
	}


	public void calculaReceita() {
		double receita = 0;
		for (Cliente cliente : listaClientes) {
			receita += cliente.getValorSeguro();
		}
		System.out.println(receita);
	}

	public void transferirSeguro(Cliente transferindo, Cliente transferido) {
		for (Veiculo veiculo : transferindo.getListaVeiculos()) {
			transferido.getListaVeiculos().add(veiculo);
			transferindo.getListaVeiculos().remove(veiculo);
		}
	}

}
