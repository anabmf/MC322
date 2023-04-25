package lab03;

public class Sinistro {
	
// Declarando atributos
	private static int contador;
	private int id;
	private String data;
	private String endereco;
	private Seguradora seguradora;
	private Veiculo veiculo;
	private Cliente cliente;
	
// Construtor
	public Sinistro(String data, String endereco, Seguradora seguradora, Veiculo veiculo, Cliente cliente) {
		this.id = ++contador;
		this.data = data;
		this.endereco = endereco;
		this.cliente = cliente;
		this.veiculo = veiculo;
		this.seguradora = seguradora;
	}
	

// Getters e setters
	public int getId() {
		return id;
	}
	public String getData() {
		return data;
	}
	public String getEndereco() {
		return endereco;
	}
	public Seguradora getSeguradora() {
		return seguradora;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setData(String data) {
		this.data = data;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public void setSeguradora(Seguradora seguradora) {
		this.seguradora = seguradora;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	
	// toString
	public String toString() {
		return "Sinistro [id=" + id + ", data=" + data + ", endereco=" + endereco + ", seguradora=" + 
		seguradora.getNome() + ", veiculo=" + veiculo.toString() + ", cliente=" + cliente.toString() + "] ";
	}	
	

}
