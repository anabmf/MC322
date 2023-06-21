public class Validacao {
    
    public static boolean validarCPF(String cpf) {
        //verifica os dois ultimos digitos do cpf (d1 e d2)
        String verCpf;
		verCpf = cpf.replaceAll("[^\\d]", "");
		
		// testar se tem 11 caracteres
		if (verCpf.length() != 11) {
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


    public static boolean validarCNPJ(String cnpj) {
        // verifica os dois ultimos digitos do cnpj (d1 e d2)
		String verCnpj;
		verCnpj = cnpj.replaceAll("[^\\d]", "");
		
		// testar se tem 14 caracteres
		if (verCnpj.length() != 14) {
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


    public static boolean validarNome(String nome) {
        for (int i = 0; i < nome.length(); i++) {
            if (Character.isLetter(nome.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }
}
