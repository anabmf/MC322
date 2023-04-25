package lab03;

import java.util.*;


class ClientePF extends Cliente {
	
	// Atributos
	private String cpf;
	private String genero;
	private Date dataLicenca;
	private String educacao;
	private String classeEconomica;
	private Date dataNascimento;
	
	// Construtor
	public ClientePF(String nome, String endereco, String cpf, String genero, Date dataLicenca, String educacao, String classeEconomica, Date dataNascimento) {
		super(nome, endereco);
		this.cpf = cpf;
		this.genero = genero;
		this.dataLicenca = dataLicenca;
		this.educacao = educacao;
		this.classeEconomica = classeEconomica;
		this.dataNascimento = dataNascimento;
	}
	
	// Getters e Setters
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Date getDataLicenca() {
		return dataLicenca;
	}

	public void setDataLicenca(Date dataLicenca) {
		this.dataLicenca = dataLicenca;
	}

	public String getEducacao() {
		return educacao;
	}

	public void setEducacao(String educacao) {
		this.educacao = educacao;
	}

	public String getClasseEconomica() {
		return classeEconomica;
	}

	public void setClasseEconomica(String classeEconomica) {
		this.classeEconomica = classeEconomica;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	//toString
	public String toString() {
		return "ClientePF [" + super.toString() + "cpf=" + cpf + ", genero=" + genero + ", dataLicenca=" + dataLicenca + ", educacao="
				+ educacao + ", classeEconomica=" + classeEconomica + ", dataNascimento=" + dataNascimento + "] ";
	}
	
	
	// Metodos
	public boolean validarCPF() {
		//verifica os dois ultimos digitos do cpf (d1 e d2)
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

