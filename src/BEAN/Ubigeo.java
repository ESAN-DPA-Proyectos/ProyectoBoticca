
package BEAN;

public class Ubigeo {
    private int id_ubigeo;
    private String region;
    private String departamento;
    private String provincia;
    private String distrito;

    public Ubigeo() {
    }
    
    
    public Ubigeo(int id_ubigeo, String region, String departamento, String provincia, String distrito) {
        this.id_ubigeo = id_ubigeo;
        this.region = region;
        this.departamento = departamento;
        this.provincia = provincia;
        this.distrito = distrito;
    }

    public int getId_ubigeo() {
        return id_ubigeo;
    }

    public void setId_ubigeo(int id_ubigeo) {
        this.id_ubigeo = id_ubigeo;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }
    
    
}
