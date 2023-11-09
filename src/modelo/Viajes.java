package modelo;

public class Viajes {
    
    private String numplaca;
    private int idchofer;
    private String fechaviaje;
    private String destino;
    private int capacidadpasajeros;
    private double preciotickete;
    
    //constructores

    public Viajes() {
    }

    public Viajes(String numplaca, int idchofer, String fechaviaje, String destino, int capacidadpasajeros, double preciotickete) {
        this.numplaca = numplaca;
        this.idchofer = idchofer;
        this.fechaviaje = fechaviaje;
        this.destino = destino;
        this.capacidadpasajeros = capacidadpasajeros;
        this.preciotickete = preciotickete;
    }
    
    //metodos get y set
    public String getNumplaca() {
        return numplaca;
    }

    public void setNumplaca(String numplaca) {
        this.numplaca = numplaca;
    }

    public int getIdchofer() {
        return idchofer;
    }

    public void setIdchofer(int idchofer) {
        this.idchofer = idchofer;
    }

    public String getFechaviaje() {
        return fechaviaje;
    }

    public void setFechaviaje(String fechaviaje) {
        this.fechaviaje = fechaviaje;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getCapacidadpasajeros() {
        return capacidadpasajeros;
    }

    public void setCapacidadpasajeros(int capacidadpasajeros) {
        this.capacidadpasajeros = capacidadpasajeros;
    }

    public double getPreciotickete() {
        return preciotickete;
    }

    public void setPreciotickete(double preciotickete) {
        this.preciotickete = preciotickete;
    }
    
    //to string
    @Override
    public String toString() {
        return "Viajes{" + "numplaca=" + numplaca + ", idchofer=" + idchofer + ", fechaviaje=" + fechaviaje + ", destino=" + destino + ", capacidadpasajeros=" + capacidadpasajeros + ", preciotickete=" + preciotickete + '}';
    }
    
    
}
