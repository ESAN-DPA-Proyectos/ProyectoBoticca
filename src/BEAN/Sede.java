
package BEAN;

public class Sede {
    private int id_sede;
    private int id_ubigeo;
    private String nombre;
    private String direccion;
    private String telefono;

    public Sede() {
    }

    public Sede(int id_sede,int id_ubigeo, String nombre, String direccion, String telefono) {
        this.id_sede = id_sede;
        this.id_ubigeo = id_ubigeo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public int getId_sede() {
        return id_sede;
    }

    public void setId_sede(int id_sede) {
        this.id_sede = id_sede;
    }

    public int getId_ubigeo() {
        return id_ubigeo;
    }

    public void setId_ubigeo(int id_ubigeo) {
        this.id_ubigeo = id_ubigeo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    
}
