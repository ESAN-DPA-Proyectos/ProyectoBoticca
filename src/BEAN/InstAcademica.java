
package BEAN;

public class InstAcademica {
    private int id_institucion;
    private String nombre_institucion;
    private String tipo;
    private String web;
    private String contacto;
    private String telefono;
    private int estado;

    public InstAcademica() {
    }

    public InstAcademica(int id_proveedor, String nombre, String tipo, String web, String contacto, String telefono, int estado) {
        this.id_institucion = id_proveedor;
        this.nombre_institucion = nombre;
        this.tipo = tipo;
        this.web = web;
        this.contacto = contacto;
        this.telefono = telefono;
        this.estado = estado;
    }

    public int getId_institucion() {
        return id_institucion;
    }

    public void setId_institucion(int id_institucion) {
        this.id_institucion = id_institucion;
    }

    public String getNombre_institucion() {
        return nombre_institucion;
    }

    public void setNombre_institucion(String nombre_institucion) {
        this.nombre_institucion = nombre_institucion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
}
