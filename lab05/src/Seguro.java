import java.time.*;
import java.util.*;

public abstract class Seguro {

    //Atributos
	private static int contador;
	private final int id;
	private LocalDate dataInicio;
    private LocalDate dataFim;
	private Seguradora seguradora;
	private List<Sinistro> listaSinistros = new ArrayList<Sinistro>();
	private List<Condutor> listaCondutores = new ArrayList<Condutor>();
    private double valorMensal;

    
    //construtor
    public Seguro(LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora) {
        this.id = contador++;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.seguradora = seguradora;
        this.valorMensal = 0;
    }
	
    // métodos
    public int getId() {
        return id;
    }
    public LocalDate getDataInicio() {
        return dataInicio;
    }
    public LocalDate getDataFim() {
        return dataFim;
    }
    public Seguradora getSeguradora() {
        return seguradora;
    }
    public List<Sinistro> getListaSinistros() {
        return listaSinistros;
    }    
    public List<Condutor> getListaCondutores() {
        return listaCondutores;
    }    
    public double getValorMensal() {
        return valorMensal;
    }
    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }
    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }
    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }
    public void setListaSeguros(List<Sinistro> listaSinistros) {
        this.listaSinistros = listaSinistros;
    }
    public void setListaCondutores(List<Condutor> listaCondutores) {
        this.listaCondutores = listaCondutores;
    }
    public void setValorMensal(double valorMensal) {
        this.valorMensal = valorMensal;
    }

    public boolean desautorizarCondutor(Condutor condutor) {
        if (listaCondutores.contains(condutor)) {
            listaCondutores.remove(condutor);
            System.out.println("Condutor " + condutor.getNome() + " desautorizado.");
            return true;
        } else {
            System.out.println("Este condutor nao esta autorizado");
            return false;
        }
    }

    public boolean autorizarCondutor(Condutor condutor) {
        if (listaCondutores.contains(condutor)) {
            System.out.println("Este condutor ja esta autorizado.");
            return false;
        } else {
            listaCondutores.add(condutor);
            System.out.println("Condutor " + condutor.getNome() + " autorizado.");
            return true;
        }
    }

    public double calcularValor() {
        return 0;
    }

    public void gerarSinistro(String data, String endereco, Condutor condutor, Seguro seguro) {
        Sinistro sinistro = new Sinistro(data, endereco, condutor, seguro);
        condutor.getListaSinistros().add(sinistro);
    }

    public int quantidadeSinistrosCondutor() {
        int quantidade = 0;
        for (Condutor condutor : listaCondutores) { 
            quantidade += condutor.getListaSinistros().size();
        }
        return quantidade;
    }


}