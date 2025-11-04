
package BEAN;

public class Rol {
    private int id_rol;
    private String descripcion;
    private String requisito;
    private int aniosexp;
    private float sueldo;

    public Rol() {
    }

    public Rol(int id_rol, String descripcion, String requisito, int aniosexp, float sueldo) {
        this.id_rol = id_rol;
        this.descripcion = descripcion;
        this.requisito = requisito;
        this.aniosexp = aniosexp;
        this.sueldo = sueldo;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRequisito() {
        return requisito;
    }

    public void setRequisito(String requisito) {
        this.requisito = requisito;
    }

    public int getAniosexp() {
        return aniosexp;
    }

    public void setAniosexp(int aniosexp) {
        this.aniosexp = aniosexp;
    }

    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }

    
}
