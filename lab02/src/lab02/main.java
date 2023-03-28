package lab02;

public class Main {
	public static void main(String[] args){ 
		Cliente binho = new Cliente("binho", "029 371 361 84", "12/04/1999", 24, "Goiania");
		Seguradora segura = new Seguradora("segura", "62 999999999", "email@email.com", "Rua Josue de Castro, 100");
		Sinistro sinistro = new Sinistro("21/03/2020", "Aquidaban, 120");
		Sinistro sinistro2 = new Sinistro("21/03/2021", "Aquidauana, 121");
		Sinistro sinistro3 = new Sinistro("21/03/2022", "Aquidabananas, 122");
		Veiculo fuscaAzul = new Veiculo("ABC1234", "Volkswagen", "fusca"); 
		
		System.out.println(binho.toString());
		System.out.println(segura.toString());
		System.out.println(sinistro.toString());
		System.out.println(sinistro2.toString());
		System.out.println(sinistro3.toString());
		System.out.println(fuscaAzul.toString());
		
		System.out.println(binho.validarCPF());
		binho.setCpf("666.666.666-66");
		System.out.println(binho.validarCPF());
		binho.setCpf("029.371.361-24");
		System.out.println(binho.validarCPF());
	}
}
