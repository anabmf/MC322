package lab03;

import java.util.*;


class ClientePJ extends Cliente {
	
	// Atributos
	private String cnpj;
	private Date dataFundacao;
	
	// Construtor
	public ClientePJ(String nome, String endereco, String cnpj, Date dataFundacao) {
		super(nome, endereco);
		this.cnpj = cnpj;
		this.dataFundacao = dataFundacao;
	}

	// Getter e Setters
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Date getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(Date dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	// toString
	public String toString() {
		return "ClientePJ ["  + super.toString() + "cnpj=" + cnpj + ", dataFundacao=" + dataFundacao + "] ";
	}
	
	// Metodos
	public boolean validarCNPJ() {
		// verifica os dois ultimos digitos do cnpj (d1 e d2)
		cnpj = cnpj.replaceAll("[^\\d]", "");
		
		// testar se tem 14 caracteres
		if (cnpj.length() != 14) {
			return false;
		}
		
		// testar se os caracteres são iguais
		int j = 0;
		for (int i = 1; i < cnpj.length(); i++) {
			if (cnpj.charAt(i) == cnpj.charAt(i-1)) {
				j++;
			}
			if (j == 13) {
				return false;
			}
		}
		double cnpjVetor[] = new double[14];
		double d1 = 0;
		double d2 = 0;
		int k = 0;
		
		// separando os números
		for (int i = 13; i >= 0; i--) {
			cnpjVetor[k] = Character.getNumericValue((cnpj.charAt(i)));	
			k++;
		}
		
		// calculando d1
			for (int i = 2; i < 10; i++) {
				d1 += (cnpjVetor[i] * i);
			}
			for (int i = 10; i < cnpj.length(); i++) {
				d1 += (cnpjVetor[i] * (i-8));
			}
			d1 = d1 % 11;
			if (d1 < 2) {
				d2 = 0;
			} else {
				d1 = 11 - d1;
			}
			
			//calculando d2
			for (int i = 2; i < 9; i++) {
				d2 += (cnpjVetor[i] * (i+1));
			}
			for (int i = 9; i < cnpj.length(); i++) {
				d2 += (cnpjVetor[i] * (i-7));
			}
			d2 += 2 * d1;
			d2 = d2 % 11;
			if (d2 < 2) {
				d2 = 0;
			} else {
				d2 = 11 - d2;
			}
			
			// verificando cnpj
			if ((cnpjVetor[0] == d2) && (cnpjVetor[1] == d1)) {
				return true;
			} else {
				return false;
			}
	
	}
		
	
	
}

