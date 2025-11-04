
package BEAN;

public class det_compra {
    private int id_compra;
    private int id_medicamento;
    private String medicamento;
    private int cantidad;
    private float preciounit;
    private float preciototal;

    public det_compra() {
    }
    
    public det_compra(int id_compra,int id_medicamento, String medicamento,
            int cantidad,float preciounit, float preciototal) {
        this.id_compra = id_compra;
        this.id_medicamento = id_medicamento;
        this.medicamento=medicamento;
        this.cantidad=cantidad;
        this.preciounit = preciounit;
        this.preciototal = preciototal;

    }

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public int getId_medicamento() {
        return id_medicamento;
    }

    public void setId_medicamento(int id_medicamento) {
        this.id_medicamento = id_medicamento;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
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

    
    
}
