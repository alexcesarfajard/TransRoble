package modelo;

public class Vehiculos {

    private int placa;
    private String marca;
    private String estilo;
    private String modelo;
    private int capacidad;

    public Vehiculos() {
    }

    public Vehiculos(int placa, String marca, String estilo, String modelo, int capacidad) {
        this.placa = placa;
        this.marca = marca;
        this.estilo = estilo;
        this.modelo = modelo;
        this.capacidad = capacidad;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getPlaca() {
        return placa;
    }

    public void setPlaca(int placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String Modelo) {
        this.modelo = Modelo;
    }

    @Override
    public String toString() {
        return "placa:" + placa + "marca:" + marca + "estilo:" + estilo + "Modelo:" + modelo + "capacidad:" + capacidad;
    }

}
