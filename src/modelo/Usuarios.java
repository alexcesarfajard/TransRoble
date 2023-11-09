
package modelo;

public class Usuarios {
private int uid;
private String codigo;
private String clave;

    public Usuarios() {
    }

    public Usuarios(int uid, String codigo, String clave) {
        this.uid = uid;
        this.codigo = codigo;
        this.clave = clave;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "uid:" + uid + "codigo:" + codigo + "clave:" + clave;
    }


}
