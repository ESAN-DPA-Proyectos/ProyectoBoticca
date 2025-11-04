
package BEAN;

public class cab_compra {
    private int id_compra;
    private String proveedor;
    private int id_proveedor;
    private String empleado;
    private int id_empleado;
    private String contacto;
    private String fecha;
    private int estado;


    public cab_compra() {
    }
    
    public cab_compra(int id_compra, String proveedor,int id_proveedor, String empleado,
            int id_empleado,String contacto,String fecha,int estado) {
        this.id_compra = id_compra;
        this.proveedor = proveedor;
        this.id_proveedor=id_proveedor;
        this.empleado=empleado;
        this.id_empleado = id_empleado;
        this.contacto = contacto;
        this.fecha = fecha;
        this.estado = estado;
    }

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    
}
