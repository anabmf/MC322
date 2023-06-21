import java.util.*;

public class Frota {
    // atributos
    private String code;
    private List<Veiculo> listaVeiculos = new ArrayList<Veiculo>();

    // construtor
    public Frota(String code) {
        this.code = code;
    }

    // getters e setters
    public String getCode() {
        return code;
    }
    public List<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public void setListaVeiculos(List<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

    // toString
    public String toString() {
        String imprimir = "Frota \ncode: " + code + "\nlista veiculos:";
        for (Veiculo veiculo : listaVeiculos) {
            imprimir +=  "\n" + veiculo;
        }
        return imprimir;
    }
    
    public boolean addVeiculo(Veiculo veiculo) {
        // adiciona um veiculo na frota. retorna false se esse veiculo já estiver na lista
        if (listaVeiculos.contains(veiculo)) {
            return false;
        } else {
            listaVeiculos.add(veiculo);
            return true;
        }    
    }

    public boolean removeVeiculo(Veiculo veiculo) {
        // remove um veiculo da frota. retorna false se esse veiculo nao estiver na frota
        if (listaVeiculos.contains(veiculo)) {
            listaVeiculos.remove(veiculo);
            return true;
        } else {
            return false;
        }  
    }
}
