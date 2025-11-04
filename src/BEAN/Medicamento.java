
package BEAN;

public class Medicamento {
    private int id_medicamento;
    private int id_categoria;
    private int id_proveedor;
    private String nombre;
    private String descripcion;
    private Float precio;
    private int stock;
    private String fecha_vencimiento;

    public Medicamento() {
    }

    public Medicamento(int id_medicamento, int id_categoria, int id_proveedor, 
            String nombre, String descripcion, Float precio, int stock, String fecha_vencimiento) {
        this.id_medicamento = id_medicamento;
        this.id_categoria = id_categoria;
        this.id_proveedor = id_proveedor;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.fecha_vencimiento = fecha_vencimiento;

    }

    public int getId_medicamento() {
        return id_medicamento;
    }

    public void setId_medicamento(int id_medicamento) {
        this.id_medicamento = id_medicamento;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(String fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    
    
}
