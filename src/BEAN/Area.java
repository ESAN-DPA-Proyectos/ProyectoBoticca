
package BEAN;

public class Area {
    private int id_area;
    private String descripcion;
    private String subArea;
    private int centCosto;

    public Area() {
    }

    public Area(int id_area, String descripcion, String subArea, int centCosto) {
        this.id_area = id_area;
        this.descripcion = descripcion;
        this.subArea = subArea;
        this.centCosto = centCosto;
    }

    public int getId_area() {
        return id_area;
    }

    public void setId_area(int id_area) {
        this.id_area = id_area;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSubArea() {
        return subArea;
    }

    public void setSubArea(String subArea) {
        this.subArea = subArea;
    }

    public int getCentCosto() {
        return centCosto;
    }

    public void setCentCosto(int centCosto) {
        this.centCosto = centCosto;
    }

    
    
}
