package DAO;

import BEAN.Empresa;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;

public class EmpresaDAO {
    public Vector<Empresa> listaEmpresas(String cad) {
        DbBean db;
        db = new DbBean();
        
        Vector<Empresa> listaEmp;
        
        listaEmp = new Vector<Empresa>();
        String sql;
        sql = "Select * from empresa";
        if (!cad.isEmpty()){
            sql = sql + " where descEmpresa like '" + cad + "%'";
        }
        // System.out.println(sql);
        try{
            ResultSet rstEmpresas = db.resultadoSQL(sql);
            while (rstEmpresas.next()) {
               Empresa emp = new Empresa();
               emp.setEmpresaId(rstEmpresas.getInt(1));
               emp.setDescEmpresa(rstEmpresas.getString(2));
               emp.setRUC(rstEmpresas.getString(3));
               emp.setContacto(rstEmpresas.getString(4));
               emp.setTlfConta(rstEmpresas.getString(5));
               emp.setWeb(rstEmpresas.getString(6));
               listaEmp.addElement(emp);
           }
        } catch(java.sql.SQLException e) {
            e.printStackTrace();
        }
        try{
            db.desconecta();
        } catch(java.sql.SQLException e) {
            e.printStackTrace();
        }
       
        return listaEmp;
    }
    
    public void insertaEmpresas(Empresa emp) {
        DbBean db;
        db = new DbBean();
        String sql;
        
        try{
            sql = "Insert into empresa values (";
            sql = sql + emp.getEmpresaId() + ", '";
            sql = sql + emp.getDescEmpresa() + "', '";
            sql = sql + emp.getRUC() + "', '";
            sql = sql + emp.getContacto() + "', '";
            sql = sql + emp.getTlfConta() + "', '";
            sql = sql + emp.getWeb() + "')";
            db.ejecutaSQL(sql);
        } catch(java.sql.SQLException e) {
            e.printStackTrace();
        }
        try{
            db.desconecta();
        } catch(java.sql.SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void actualizaEmpresas(Empresa emp) {
        DbBean db;
        db = new DbBean();
        String sql;
        
        try{
            sql = "Update empresa set ";
            sql = sql + " descEmpresa = '" + emp.getDescEmpresa() + "', ";
            sql = sql + " RUC = '" + emp.getRUC() + "', ";
            sql = sql + " contacto = '" + emp.getContacto()+ "', ";
            sql = sql + " tlfConta = '" + emp.getTlfConta() + "', ";
            sql = sql + " web = '" + emp.getWeb() + "' ";
            sql = sql + " where EmpresaId = " + emp.getEmpresaId();
            // System.out.println(sql);
            db.ejecutaSQL(sql);
        } catch(java.sql.SQLException e) {
            e.printStackTrace();
        }
        try{
            db.desconecta();
        } catch(java.sql.SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean eliminaEmpresas(int idEmp) {
        // Verificando la no dependencia de la tabla Det_CV_ExpLab
        boolean sw = false;
        DbBean db;
        db = new DbBean();
        String sql;
        sql = "Select * from Det_CV_ExpLab where EmpresaID = " + idEmp + "";
        
        try{
            ResultSet rstEmpresas = db.resultadoSQL(sql);
            if (!rstEmpresas.next()) {
                sql = "Delete from empresa where EmpresaId = " + idEmp + "";
                db.ejecutaSQL(sql);
                sw = true;
           }
        } catch(java.sql.SQLException e) {
            e.printStackTrace();
        }
        try{
            db.desconecta();
        } catch(java.sql.SQLException e) {
            e.printStackTrace();
        }
        return sw;
    }

}
