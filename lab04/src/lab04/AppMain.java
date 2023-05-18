package lab04;

import java.time.*;  
import java.util.*;  

public class AppMain {

	public static void menu(){
		
        Scanner teclado = new Scanner(System.in);
		MenuOperacoes menuPrincipal = MenuOperacoes.CADASTRAR;
		MenuOperacoes.MenuCadastrar menuCadastrar = MenuOperacoes.MenuCadastrar.CLIENTEPF;
		MenuOperacoes.MenuListar menuListar = MenuOperacoes.MenuListar.CLIENTES;
		MenuOperacoes.MenuExcluir menuExcluir = MenuOperacoes.MenuExcluir.CLIENTE;
		String escolha, escolhaCadastro, escolhaListar, escolhaExcluir;


        System.out.println("\nBem-vinde! Selecione a operação pelo número correspondente:\n");
		do {
			try {
				menuPrincipal = null;
				System.out.println("============\n1 - Cadastros\n2 - Listar\n3 - Excluir\n4 - Gerar Sinistro\n5 - Transferir Seguro\n6 - Calcular Receita Seguradora\n0 - Sair \n============\n"); 
				escolha = teclado.nextLine(); 

				for (MenuOperacoes m : MenuOperacoes.values()) {
					if (escolha.equals(m.getMenuOperacoes())) {
						menuPrincipal = m;
					}
				}

				switch (menuPrincipal) {
						case CADASTRAR:
						System.out.println("============\n1.1 - Cadastrar Cliente PF \n1.2 - Cadastrar Cliente PJ \n1.3 - Cadastrar Seguradora \n0 - Voltar\n============\n"); 

							do {
								menuCadastrar = null;
								escolhaCadastro = teclado.nextLine();
								for (MenuOperacoes.MenuCadastrar m : MenuOperacoes.MenuCadastrar.values()) {
									if (escolhaCadastro.equals(m.getMenuCadastrar())) {
										menuCadastrar = m;
									}
								}
								switch (menuCadastrar) {
										case CLIENTEPF:
											System.out.println("Cadastrar um Cliente PF");
											break;
										case CLIENTEPJ:
											System.out.println("Cadastrar um Cliente PJ");
											break;
										case VEICULO:
											System.out.println("Cadastrar um Veiculo");
											break;
										case SEGURADORA:
											System.out.println("Cadastrar Seguradora");
											break;
										case VOLTAR:
											System.out.println("Voltar");
											break;
										default:
										System.out.println("Nao reconheco esse comando. Tente novamente\n");
											break;
									}
							} while (menuCadastrar != MenuOperacoes.MenuCadastrar.VOLTAR);
							break;

						case LISTAR:
						System.out.println("============\n2.1 - Listar Clientes de uma Seguradora \n2.2 - Listar Sinistros de uma Seguradora \n2.3 - Listar Sinistros de um Cliente \n2.4 - Listar Veículos de um Cliente \n2.5 - Listar Veículos de uma Seguradora \n0 - Voltar\n============\n"); 

							do {
								menuListar = null;
								escolhaListar = teclado.nextLine();
								for (MenuOperacoes.MenuListar m : MenuOperacoes.MenuListar.values()) {
									if (escolhaListar.equals(m.getMenuListar())) {
										menuListar = m;
									}
								}
								switch (menuListar) {
										case CLIENTES:
											System.out.println("Você escolheu Listar Clientes");
											break;
										case SINISTROS:
											System.out.println("Listar Sinistros de uma Seguradora");
											break;
										case SINISTRO_CLIENTE:
											System.out.println("Listar Sinistros de um Cliente");
											break;
										case VEICULO_CLIENTE:
											System.out.println("Listar Veiculos de um Cliente");
											break;
										case VEICULO_SEGURADORA:
											System.out.println("Listar Veiculos de uma Seguradora");
											break;
										case VOLTAR:
											System.out.println("Voltar");
											break;
										default:
										System.out.println("Nao reconheco esse comando. Tente novamente\n");
											break;
									}
							} while (menuListar != MenuOperacoes.MenuListar.VOLTAR);
							break;

						case EXCLUIR:
						System.out.println("============\n3.1 - Excluir Cliente \n3.2 - Excluir Veículo \n3.3 - Excluir Sinistro \n0 - Voltar\n============\n"); 

							do {
								menuExcluir = null;
								escolhaExcluir = teclado.nextLine();
								for (MenuOperacoes.MenuExcluir m : MenuOperacoes.MenuExcluir.values()) {
									if (escolhaExcluir.equals(m.getMenuExcluir())) {
										menuExcluir = m;
									}
								}
								switch (menuExcluir) {
										case CLIENTE:
											System.out.println("Excluir um cliente");
											break;
										case VEICULO:
											System.out.println("Excluir um veiculo");
											break;
										case SINISTRO:
											System.out.println("Excluir um sinistro");
											break;
										case VOLTAR:
											System.out.println("Voltar");
											break;
										default:
										System.out.println("Nao reconheco esse comando. Tente novamente\n");
											break;
									}
							} while (menuExcluir != MenuOperacoes.MenuExcluir.VOLTAR);
							break;

						case GERAR:
							System.out.println("Gerar Sinistro");
							break;
						case TRANSFERIR:
							System.out.println("Transferir Seguro");
							break;
						case CALCULAR:
							System.out.println("Calcular Receita Seguradora");
							break;
						case SAIR:
							break;
						default:
						System.out.println("Nao reconheco esse comando. Tente novamente\n");
							break;
				}	
			}
			catch (Exception e) {
				System.out.println("Nao reconheco esse comando. Tente novamente\n");
			}
		} while (menuPrincipal != MenuOperacoes.SAIR);

		teclado.close();
		
	}

	public static void main(String[] args){ 

		
		LocalDate dataNascimento = LocalDate.of(2000, 12, 12);  
		LocalDate dataLicenca = LocalDate.of(2020, 12, 12);  
		LocalDate dataFundacao = LocalDate.of(2010, 12, 12);

		ClientePF ana = new ClientePF("ana", "ceu do oeste", "02937136184", "F", dataLicenca, "superior", "media", dataNascimento);
		ClientePJ conpec = new ClientePJ("conpec", "josue de castro, 100", "66070178000117", dataFundacao, 300);
		Seguradora fachada = new Seguradora("fachada", "40028922", "email@email.com", "rua dos bobos, 0");
		Seguradora segura = new Seguradora("segura", "32324040", "email1@email.com", "rua da praca, 1");
		Veiculo fuscaAzul = new Veiculo("PDP3456", "volkswagen", "fusca", 1989);
		Veiculo celtaPreto = new Veiculo("SOS5678", "chevrolet", "celta", 2000);
		Veiculo hb20Branco = new Veiculo("SLK1234", "hyndai", "hb20", 2012);
		Veiculo unoVermelho = new Veiculo("SQN7890", "fiat", "uno", 2010);
		Sinistro batida = new Sinistro("03/03/2003", "aquidaban, 400", fachada, fuscaAzul, conpec);
		Sinistro acidente = new Sinistro("04/04/2004", "aquidaban, 400", fachada, celtaPreto, ana);
		Sinistro atropelamento = new Sinistro("04/04/2004", "aquidaban, 400", segura, celtaPreto, ana);

		System.out.println(Validacao.validarCPF(ana.getCpf())); 
		System.out.println(Validacao.validarCNPJ(conpec.getCnpj())); 
		System.out.println(Validacao.validarNome(ana.getNome()));
		
		System.out.println(fachada.cadastrarCliente(conpec)); 
		System.out.println(fachada.cadastrarCliente(conpec)); 
		System.out.println(fachada.cadastrarCliente(ana));  

		ana.getListaVeiculos().add(fuscaAzul);
		ana.getListaVeiculos().add(celtaPreto);
		conpec.getListaVeiculos().add(hb20Branco);
		conpec.getListaVeiculos().add(unoVermelho);

        fachada.gerarSinistro(acidente);
        fachada.gerarSinistro(batida);
		segura.gerarSinistro(atropelamento);

		//Métodos de Seguradora
		fachada.listarClientes("cpf");
    	fachada.listarClientes("cnpj");
		fachada.listarSinistros();
        fachada.visualizarSinistro("ana");
        fachada.visualizarSinistro("conpec");
		fachada.calcularPrecoSeguroCliente(conpec);
		fachada.calcularPrecoSeguroCliente(ana);
		fachada.calculaReceita();
		fachada.transferirSeguro(ana, conpec);
		System.out.println(conpec.getListaVeiculos());

		menu();
	}
}
