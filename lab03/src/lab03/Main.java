package lab03;

import java.util.*;

public class Main {
	public static void main(String[] args){ 
		Date dataLicenca = new Date(99, 9, 19);
		Date dataNascimento = new Date(100, 10, 10);
		Date dataFundacao = new Date();
		

		ClientePF ana = new ClientePF("ana", "ceu do oeste", "02937136184", "F", dataLicenca, "superior", "media", dataNascimento);
		ClientePJ conpec = new ClientePJ("conpec", "josue de castro, 100", "66070178000117", dataFundacao);
		Seguradora fachada = new Seguradora("fachada", "40028922", "email@email.com", "rua dos bobos, 0");
		Veiculo fuscaAzul = new Veiculo("PDP3456", "volkswagen", "fusca", 1989);
		Veiculo celtaPreto = new Veiculo("SOS5678", "chevrolet", "celta", 2000);
		Sinistro batida = new Sinistro("03/03/2003", "aquidaban, 400", fachada, fuscaAzul, conpec);
		Sinistro acidente = new Sinistro("04/04/2004", "aquidaban, 400", fachada, celtaPreto, ana);

		
		System.out.println(ana.validarCPF()); //true
		System.out.println(conpec.validarCNPJ()); //true !!!!!!!!
		
		System.out.println(fachada.cadastrarCliente(conpec)); //true
		System.out.println(fachada.cadastrarCliente(conpec)); //false
		System.out.println(fachada.cadastrarCliente(ana));  //true

		
		ana.getListaVeiculos().add(fuscaAzul);
		ana.getListaVeiculos().add(celtaPreto);
		conpec.getListaVeiculos().add(celtaPreto);
		conpec.getListaVeiculos().add(fuscaAzul);

        fachada.gerarSinistro(acidente);
        fachada.gerarSinistro(batida);

		System.out.println(ana.toString()); 
		System.out.println(conpec.toString());
		System.out.println(fachada.toString());
		System.out.println(fuscaAzul.toString());
		System.out.println(batida.toString());


		// opcoes

        Scanner menu = new Scanner(System.in);
        System.out.println ("Digite o que deseja visualizar? \n Clientes \n Sinistros"); 
        String escolha = menu.nextLine(); 

        if (escolha.equals("Clientes")) {
            System.out.println ("Escolha 'cpf' ou 'cnpj'");
            String escolha2 = menu.nextLine(); 
            if (escolha2.equals("cpf")) {
                fachada.listarClientes("cpf"); //ana
            } else if  (escolha2.equals("cnpj")) {
                fachada.listarClientes("cnpj"); //conpec
            }
        }

        if (escolha.equals("Sinistros")) {
            System.out.println ("Escolha 'Clientes', 'ClientesPF' ou 'ClientesPJ'");
            String escolha2 = menu.nextLine(); 
            if (escolha2.equals("Clientes")) {
                fachada.listarSinistros(); //batida, acidente
            } else if  (escolha2.equals("ClientesPF")) {
                fachada.visualizarSinistro("ana"); //acidente 
            } else if  (escolha2.equals("ClientesPJ")) {
                fachada.visualizarSinistro("conpec"); //batida 
            }
        }
		
		
		System.out.println(fachada.removerCliente(ana));
		System.out.println(fachada.removerCliente(ana));	
             
	}
}
