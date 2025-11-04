package BEAN;

public class Empresa {
    private int EmpresaId;
    private String descEmpresa;
    private String RUC;
    private String contacto;
    private String tlfConta;
    private String web;

    public Empresa() {
    }

    public Empresa(int EmpresaId, String descEmpresa, String RUC, String contacto, String tlfConta, String web) {
        this.EmpresaId = EmpresaId;
        this.descEmpresa = descEmpresa;
        this.RUC = RUC;
        this.contacto = contacto;
        this.tlfConta = tlfConta;
        this.web = web;
    }

    public int getEmpresaId() {
        return EmpresaId;
    }

    public void setEmpresaId(int EmpresaId) {
        this.EmpresaId = EmpresaId;
    }

    public String getDescEmpresa() {
        return descEmpresa;
    }

    public void setDescEmpresa(String descEmpresa) {
        this.descEmpresa = descEmpresa;
    }

    public String getRUC() {
        return RUC;
    }

    public void setRUC(String RUC) {
        this.RUC = RUC;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getTlfConta() {
        return tlfConta;
    }

    public void setTlfConta(String tlfConta) {
        this.tlfConta = tlfConta;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }
    
    
}
