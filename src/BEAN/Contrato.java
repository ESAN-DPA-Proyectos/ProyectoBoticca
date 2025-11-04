
package BEAN;

public class Contrato {
    private int id_contrato;
    private int id_empleado;
    private String empleado;
    private String fecini;
    private String fecfin;
    private int id_area;
    private String area;
    private int id_rol;
    private String rol;
    private Float sueldo;
    private int estado;

    public Contrato() {
    }

    public Contrato(int id_contrato, int id_empleado, String empleado,
            String fecini,String fecfin,int id_area,String area,int id_rol, 
            Float sueldo, int estado) {
        this.id_contrato = id_contrato;
        this.id_empleado = id_empleado;
        this.empleado = empleado;
        this.fecini = fecini;
        this.fecfin = fecfin;
        this.id_area = id_area;
        this.area = area;
        this.id_rol = id_rol;
        this.sueldo = sueldo;
        this.estado = estado;

    }

    public int getId_contrato() {
        return id_contrato;
    }

    public void setId_contrato(int id_contrato) {
        this.id_contrato = id_contrato;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public String getFecini() {
        return fecini;
    }

    public void setFecini(String fecini) {
        this.fecini = fecini;
    }

    public String getFecfin() {
        return fecfin;
    }

    public void setFecfin(String fecfin) {
        this.fecfin = fecfin;
    }

    public int getId_area() {
        return id_area;
    }

    public void setId_area(int id_area) {
        this.id_area = id_area;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Float getSueldo() {
        return sueldo;
    }

    public void setSueldo(Float sueldo) {
        this.sueldo = sueldo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    
    
}
