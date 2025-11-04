
package BEAN;

public class Cliente {
    private int id_cliente;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String dni;
    private int genero;
    private int estcivil;
    private int estado;

    public Cliente() {
    }

    public Cliente(int id_cliente, String nombre, String apellido, String direccion, String telefono, String dni, int genero, int estcivil, int estado) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.dni = dni;
        this.genero = genero;
        this.estcivil = estcivil;
        this.estado = estado;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public int getEstcivil() {
        return estcivil;
    }

    public void setEstcivil(int estcivil) {
        this.estcivil = estcivil;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

        
    
}
