package lab04;
 
import java.util.*;  

public class Cliente {

// Atributos
	private String nome;
	private String endereco; 
	private List<Veiculo> listaVeiculos;
	private double valorSeguro;
	
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
	public double getValorSeguro() {
		return valorSeguro;
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
	public void setValorSeguro(double valorSeguro) {
		this.valorSeguro = valorSeguro;
	}
	

	public String toString() { //ARRUMAR
		return "\nnome = " + nome + ", \nendereco = " + endereco + ", \nlistaVeiculos: \n" + getListaVeiculos() + "\n";
	}
	
	public double calculaScore() {
		CalcSeguro base = CalcSeguro.VALOR_BASE;
		return base.getFator();

	}
	
}
