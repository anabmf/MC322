package lab04;

import java.time.*;


class ClientePJ extends Cliente {
	
	// Atributos
	private final String cnpj;
	private LocalDate dataFundacao;
	private int qtdFuncionarios;
	
	// Construtor
	public ClientePJ(String nome, String endereco, String cnpj, LocalDate dataFundacao, int qtdFuncionarios) {
		super(nome, endereco);
		this.cnpj = cnpj;
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

	public void setDataFundacao(LocalDate dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	public void setQtdFuncionarios(int qtdFuncionarios) {
		this.qtdFuncionarios = qtdFuncionarios;
	}
	
	// toString 
	public String toString() {
		return (super.toString() + "cnpj = " + cnpj + ", \ndataFundacao = " + dataFundacao + ", \nqtdFuncionarios = " + qtdFuncionarios);
	}
	
	public double calculaScore() {
		CalcSeguro base = CalcSeguro.VALOR_BASE;
		return (base.getFator() * (1 + (qtdFuncionarios/100)) * getListaVeiculos().size());
	}

	
}

