import java.time.LocalDate;

public class SeguroPJ extends Seguro {
    
    private Frota frota;
    private ClientePJ cliente;


    public SeguroPJ(LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora, Frota frota, ClientePJ cliente) {
        super(dataInicio, dataFim, seguradora);
        this.frota = frota;
        this.cliente = cliente;
        super.setValorMensal(calcularValor());
    }


    public Frota getFrota() {
        return this.frota;
    }
    public void setFrota(Frota frota) {
        this.frota = frota;
    }
    public ClientePJ getCliente() {
        return this.cliente;
    }
    public void setCliente(ClientePJ cliente) {
        this.cliente = cliente;
    }

    
    @Override
    public double calcularValor() {
        double base = CalcSeguro.VALOR_BASE.getFator();
        int qtdVeiculos = cliente.quantidadeVeiculos();
        int AnosFundacao = cliente.calculaIdade();

        double calculo = (base * 
                        (10 + (cliente.getQtdFuncionarios()) /10) *
                        (1 + 1/(qtdVeiculos + 2) ) *
                        (1 + 1/( AnosFundacao +2) ) * 
                        (2 + super.getSeguradora().getSinistrosPorCliente(cliente).size()/10) *
                        (5 + quantidadeSinistrosCondutor()/10));
        return calculo;
    }


}
