
package modelo;

public class Personas {
private int nid;
private String nombre;
private int telefono;
private String correo;

public Personas() {
    }

    public Personas(int nid, String nombre, int telefono, String correo) {
        this.nid = nid;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }


    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getNid() {
        return nid;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "nid:" + nid + "nombre:" + nombre + "telefono:" + telefono + "correo:" + correo;
    }

}
