public class Sinistro {
	
// Declarando atributos
	private static int contador;
	private final int id;
	private String data;
	private String endereco;
	private Condutor condutor;
	private Seguro seguro;
	
// Construtor
	public Sinistro(String data, String endereco, Condutor condutor, Seguro seguro) {
		this.id = ++contador;
		this.data = data;
		this.endereco = endereco;
		this.condutor = condutor;
		this.seguro = seguro;
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
	public Condutor getCondutor() {
		return condutor;
	}
	public Seguro getSeguro() {
		return seguro;
	}
	public void setData(String data) {
		this.data = data;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public void setCondutor(Condutor condutor) {
		this.condutor = condutor;
	}
	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}

	
	// toString ARRUMAR!!!!!!!!!
	public String toString() {
		return ("Sinistro \nid: " + id + " \ndata: " + data + " \nendereco: " + endereco + " \ncondutor: " + 
		condutor.getNome() + ", \nseguro: " + seguro.getId() +"\n");
	}	
	

}
