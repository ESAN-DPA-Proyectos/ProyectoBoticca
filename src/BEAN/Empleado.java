
package BEAN;

public class Empleado {
    private int id_empleado;
    private String nombre;
    private String apellido;
    private String cargo;
    private String fecContrato;
    private String telefono;
    private int estado;

    public Empleado() {
    }

    public Empleado(int id_empleado, String nombre, String apellido, String cargo, String fecha, String telefono, int estado) {
        this.id_empleado = id_empleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.fecContrato = fecha;
        this.telefono = telefono;
        this.estado = estado;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getFecContrato() {
        return fecContrato;
    }

    public void setFecContrato(String fecContrato) {
        this.fecContrato = fecContrato;
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
