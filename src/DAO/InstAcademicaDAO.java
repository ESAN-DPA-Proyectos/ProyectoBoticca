
package DAO;

import BEAN.InstAcademica;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.util.Vector;

public class InstAcademicaDAO {
    public Vector<InstAcademica> listaInstAcademica(String cad){
        DbBean db=new DbBean();
               
        Vector<InstAcademica> listaInst = new Vector<InstAcademica>();
        
        String sql;
        sql= "select * from InstAcademica ";
        if(!cad.isEmpty()){ //con este if se agrega el where en el query sql
            sql=sql+" where NombInstitucio like '%"+ cad +"%'";
        }
        try{
            ResultSet rstInstitucion = db.resultadoSQL(sql);
            while(rstInstitucion.next()){
                InstAcademica inst = new InstAcademica();
                inst.setId_institucion(rstInstitucion.getInt(1));
                inst.setNombre_institucion(rstInstitucion.getString(2));
                inst.setTipo(rstInstitucion.getString(3));
                inst.setWeb(rstInstitucion.getString(4));
                inst.setContacto(rstInstitucion.getString(5));
                inst.setTelefono(rstInstitucion.getString(6));
                inst.setEstado(rstInstitucion.getInt(7));
                listaInst.addElement(inst);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            db.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
                
        return listaInst;
    }
    public void insertaInstAcademica(InstAcademica inst){
        DbBean db=new DbBean();
        String sql;
        try{
            sql="insert into InstAcademica values (";
            sql=sql+" "+ inst.getId_institucion() +", ";
            sql=sql+" '"+ inst.getNombre_institucion() +"', ";
            sql=sql+" '"+ inst.getTipo() +"', ";
            sql=sql+" '"+ inst.getWeb() +"', ";
            sql=sql+" '"+ inst.getContacto() +"', ";
            sql=sql+" '"+ inst.getTelefono() +"', ";
            sql=sql+" "+ inst.getEstado() +") ";
            
            
            System.out.println("\nDPA"+sql);
            
            db.ejecutaSQL(sql);
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            db.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
                
    }
    public void actualizaInstAcademica(InstAcademica inst){
        DbBean db=new DbBean();
        String sql;
        try{
            sql="update InstAcademica set ";
            sql=sql+" NombInstitucio = '"+inst.getNombre_institucion()+"', ";
            sql=sql+" TipoInst = '"+inst.getTipo()+"', ";
            sql=sql+" web = '"+inst.getWeb()+"', ";
            sql=sql+" Contacto = '"+inst.getContacto()+"', ";
            sql=sql+" tlf = '"+inst.getTelefono()+"', ";
            sql=sql+" estado = '"+inst.getEstado()+"' ";
            sql=sql+"where institucionID = "+inst.getId_institucion()+"";
            db.ejecutaSQL(sql);
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            db.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
    }
    public boolean eliminaInstAcademica(int idInst){
        //verificando la no dependencia de la tabla det_venta
        boolean sw = false;
        DbBean db=new DbBean();       
        Vector<InstAcademica> listaInst = new Vector<InstAcademica>();
        
        String sql;
        sql= "select * from Det_CV_Acad where institucionID= "+ idInst +"";

        try{
            ResultSet rstDetalle = db.resultadoSQL(sql);

            if (!rstDetalle.next()){
                sql="delete from InstAcademica where institucionID="+idInst+"";
                db.ejecutaSQL(sql);
                sw=true;
            }
        }catch(java.sql.SQLException e){
            
        }
        return sw;
    }
}
