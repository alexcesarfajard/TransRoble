package modelo;

public class Ticketes {
    
    private int idviaje;
    private int cantidad;
    private double precioventa;
    private String fechaventa;
    private double totalventa;
    private double totaliva;
    private double totalventatotal;
    
    //constructores

    public Ticketes() {
    }

    public Ticketes(int idviaje, int cantidad, double precioventa, String fechaventa, double totalventa, double totaliva, double totalventatotal) {
        this.idviaje = idviaje;
        this.cantidad = cantidad;
        this.precioventa = precioventa;
        this.fechaventa = fechaventa;
        this.totalventa = totalventa;
        this.totaliva = totaliva;
        this.totalventatotal = totalventatotal;
    }
    
    //get y set

    public int getIdviaje() {
        return idviaje;
    }

    public void setIdviaje(int idviaje) {
        this.idviaje = idviaje;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(double precioventa) {
        this.precioventa = precioventa;
    }

    public String getFechaventa() {
        return fechaventa;
    }

    public void setFechaventa(String fechaventa) {
        this.fechaventa = fechaventa;
    }

    public double getTotalventa() {
        return totalventa;
    }

    public void setTotalventa(double totalventa) {
        this.totalventa = totalventa;
    }

    public double getTotaliva() {
        return totaliva;
    }

    public void setTotaliva(double totaliva) {
        this.totaliva = totaliva;
    }

    public double getTotalventatotal() {
        return totalventatotal;
    }

    public void setTotalventatotal(double totalventatotal) {
        this.totalventatotal = totalventatotal;
    }
    
    //to string

    @Override
    public String toString() {
        return "Ticketes{" + "idviaje=" + idviaje + ", cantidad=" + cantidad + ", precioventa=" + precioventa + ", fechaventa=" + fechaventa + ", totalventa=" + totalventa + ", totaliva=" + totaliva + ", totalventatotal=" + totalventatotal + '}';
    }

}
