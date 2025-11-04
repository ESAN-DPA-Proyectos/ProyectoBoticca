
package BEAN;

public class cab_venta {
    private int id_venta;
    private int id_cliente;
    private String empleado;
    private String fecha;
    private String sede;
    private int estado;
    private int id_empleado;
    private int id_sede;

    public cab_venta() {
    }
    
    public cab_venta(int id_venta, int id_cliente,String empleado, String fecha,
            String sede,int estado,int id_empleado) {
        this.id_venta = id_venta;
        this.id_cliente = id_cliente;
        this.empleado=empleado;
        this.sede=sede;
        this.fecha = fecha;
        this.estado = estado;
        this.id_empleado = id_empleado;
        this.id_sede = id_sede;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public int getId_sede() {
        return id_sede;
    }

    public void setId_sede(int id_sede) {
        this.id_sede = id_sede;
    }
    
    
    
}
