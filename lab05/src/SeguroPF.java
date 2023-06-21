import java.time.LocalDate;

public class SeguroPF extends Seguro {

    private Veiculo veiculo;
    private ClientePF cliente;


    public SeguroPF(LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora, Veiculo veiculo, ClientePF cliente) {
        super(dataInicio, dataFim, seguradora);
        this.veiculo = veiculo;
        this.cliente = cliente;
        super.setValorMensal(calcularValor());
    }


    public Veiculo getVeiculo() {
        return this.veiculo;
    }
    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
    public ClientePF getCliente() {
        return this.cliente;
    }
    public void setCliente(ClientePF cliente) {
        this.cliente = cliente;
    }
    

    @Override
    public double calcularValor() {
    CalcSeguro base = CalcSeguro.VALOR_BASE;
    int idade = cliente.calculaIdade();
    double calculo = ((1 + 1/(cliente.getListaVeiculos().size() + 2)) * 
                      (2 + super.getSeguradora().getSinistrosPorCliente(cliente).size() /10) *
                      (5 + quantidadeSinistrosCondutor() /10));
    if ((idade >= 18) && (idade <= 30)) {
        CalcSeguro fator = CalcSeguro.FATOR_18_30;
        calculo = (base.getFator() * fator.getFator() * calculo);
    }
    if ((idade > 30) && (idade <= 60)) {
        CalcSeguro fator = CalcSeguro.FATOR_30_60;
        calculo = (base.getFator() * fator.getFator() * calculo);
    }
    if ((idade > 60) && (idade <= 90)) {
        CalcSeguro fator = CalcSeguro.FATOR_60_90;
        calculo = (base.getFator() * fator.getFator() * calculo);
    }
    return calculo;
    }

}
