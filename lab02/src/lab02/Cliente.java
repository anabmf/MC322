package lab02;

import java.lang.Math;

public class Cliente {

// Atributos
	private String nome;
	private String cpf;
	private String dataNascimento;
	private int idade;
	private String endereco;
	
// Costrutor
	public Cliente(String nome, String cpf, String dataNascimento, int idade, String endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.idade = idade;
		this.endereco = endereco;
	}
	
// Metodos
	public String getNome() {
		return nome;
	}
	public String getCpf() {
		return cpf;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public int getIdade() {
		return idade;
	}
	public String detEndereco() {
		return endereco;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String toString() {
		return "Cliente [nome=" + nome + ", cpf=" + cpf + ", dataNascimento=" + dataNascimento + ", idade=" + idade
				+ ", endereco=" + endereco + "]";
	}
	
	public boolean validarCPF() {
		cpf = cpf.replaceAll("[^\\d]", "");
		
		// testar se tem 11 caracteres
		if (cpf.length() != 11) {
			return false;
		}
		
		// testar se os caracteres são iguais
		int j = 0;
		for (int i = 1; i < cpf.length(); i++) {
			if (cpf.charAt(i) == cpf.charAt(i-1)) {
				j++;
			}
			if (j == 10) {
				return false;
			}
		
		}
		double cpfVetor[] = new double[11];
		double d1 = 0;
		double d2 = 0;
		
		// separando os números com o vetor invertido
		for (int i = 10; i >= 0; i--) {
			cpfVetor[i] = Character.getNumericValue((cpf.charAt(i)));	
		}
		
		// calculando d1
		for (int i = 2; i < cpf.length(); i++) {
			d1 += (cpfVetor[i] * i);
			// d1 = ((cpfInt % Math.pow(10, i)) * i) + d1;
		}
		d1 = d1 % 11;
		if ((d1 == 1) || (d1 == 0)) {
			d1 = 0;
		} else {
			d1 = 11 - d1;
		}
		
		
		//calculando d2
		for (int i = 2; i < cpf.length()-1; i++) {
			d2 += (cpfVetor[i] * (i+1));
		}
		d2 += 2 * d1;
		d2 = d2 % 11;
		if ((d2 == 1) || (d2 == 0)) {
			d2 = 0;
		} else {
			d2 = 11 - d2;
		}
		
		// verificando cpf
		if ((cpfVetor[0] == d2) && (cpfVetor[1] == d1)) {
			return true;
		} else {
			return false;
		}
	}

	
}
