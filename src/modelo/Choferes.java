
package modelo;

public class Choferes {
private int cid;
private String licencia;

    public Choferes() {
    }

    public Choferes(int cid, String licencia) {
        this.cid = cid;
        this.licencia = licencia;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "cid:" + cid + "licencia:" + licencia;
    }


}
