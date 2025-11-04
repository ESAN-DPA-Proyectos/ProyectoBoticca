
package BEAN;

public class det_venta {
    private int id_detventa;
    private int id_venta;
    private int id_medicamento;
    private int cantidad;
    private float preciounit;
    private float preciototal;
    private String medicamento;

    public det_venta() {
    }
    
    public det_venta(int id_detventa,int id_venta, int id_medicamento,
            int cantidad,float preciounit, float preciototal,String medicamento) {
        this.id_detventa = id_detventa;
        this.id_venta = id_venta;
        this.id_medicamento=id_medicamento;
        this.cantidad=cantidad;
        this.preciounit = preciounit;
        this.preciototal = preciototal;
        this.medicamento = medicamento;
    }

    public int getId_detventa() {
        return id_detventa;
    }

    public void setId_detventa(int id_detventa) {
        this.id_detventa = id_detventa;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getId_medicamento() {
        return id_medicamento;
    }

    public void setId_medicamento(int id_medicamento) {
        this.id_medicamento = id_medicamento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPreciounit() {
        return preciounit;
    }

    public void setPreciounit(float preciounit) {
        this.preciounit = preciounit;
    }

    public float getPreciototal() {
        return preciototal;
    }

    public void setPreciototal(float preciototal) {
        this.preciototal = preciototal;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }
    
}
