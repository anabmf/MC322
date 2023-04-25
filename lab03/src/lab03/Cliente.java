package lab03;

import java.util.*;

public class Cliente {

// Atributos
	private String nome;
	private String endereco;
	private List<Veiculo> listaVeiculos;
	
// Costrutor
	
	public Cliente(String nome, String endereco) {
		this.nome = nome;
		this.endereco = endereco;
		List <Veiculo> listaVeiculos = new ArrayList<>();
		this.listaVeiculos = listaVeiculos;
	}
	
// Metodos
	public String getNome() {
		return nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public List<Veiculo> getListaVeiculos() {
		return listaVeiculos;
	}
	public void setListaVeiculos(List<Veiculo> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String toString() {
		return "Cliente [nome=" + nome + ", endereco=" + endereco + ", listaVeiculos=" + getListaVeiculos() + "] ";
	}
	

	
}
