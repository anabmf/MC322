package lab04;

import java.time.*;  


class ClientePF extends Cliente {
	
	// Atributos
	private final String cpf;
	private String genero;
	private LocalDate dataLicenca;
	private String educacao;
	private LocalDate dataNascimento;
	private String classeEconomica;
	
	
	// Construtor
	public ClientePF(String nome, String endereco, String cpf, String genero, LocalDate dataLicenca, String educacao, String classeEconomica, LocalDate dataNascimento) {
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

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public LocalDate getDataLicenca() {
		return dataLicenca;
	}

	public void setDataLicenca(LocalDate dataLicenca) {
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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	//toString ARRUMAR 
	public String toString() {
		return (super.toString() + "cpf = " + cpf + ", \ngenero = " + genero + ", \ndataLicenca = " + dataLicenca + ", \neducacao = "
				+ educacao + ", \nclasseEconomica = " + classeEconomica + ", \ndataNascimento = " + dataNascimento);
	}

	public int calculaIdade() {
		LocalDate hoje = LocalDate.now();  
		Period idade = Period.between(dataNascimento, hoje);
		return idade.getYears();  
	}

	public double calculaScore() {
		CalcSeguro base = CalcSeguro.VALOR_BASE;
		int idade = calculaIdade();
		double calculo = 0;
		if ((idade >= 18) && (idade <= 30)) {
			CalcSeguro fator = CalcSeguro.FATOR_18_30;
			calculo = (base.getFator() * fator.getFator() * getListaVeiculos().size());
		}
		if ((idade > 30) && (idade <= 60)) {
			CalcSeguro fator = CalcSeguro.FATOR_30_60;
			calculo = (base.getFator() * fator.getFator() * getListaVeiculos().size());
		}
		if ((idade > 60) && (idade <= 90)) {
			CalcSeguro fator = CalcSeguro.FATOR_60_90;
			calculo = (base.getFator() * fator.getFator() * getListaVeiculos().size());
		}
		return calculo;
	}

}

