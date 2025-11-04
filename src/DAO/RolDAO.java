
package DAO;


import BEAN.Rol;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.util.Vector;

public class RolDAO {
    public Vector<Rol> listaRol(String cad){
        DbBean db=new DbBean();
               
        Vector<Rol> listaArea = new Vector<Rol>();
        
        String sql;
        sql= "select * from rol ";
        if(!cad.isEmpty()){ //con este if se agrega el where en el query sql
            sql=sql+" where descRol like '%"+ cad +"%'";
        }
        try{
            ResultSet rstAreas = db.resultadoSQL(sql);
            while(rstAreas.next()){
                Rol rol = new Rol();
                rol.setId_rol(rstAreas.getInt(1));
                rol.setDescripcion(rstAreas.getString(2));
                rol.setRequisito(rstAreas.getString(3));
                rol.setAniosexp(rstAreas.getInt(4));
                rol.setSueldo(rstAreas.getInt(5));
                listaArea.addElement(rol);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            db.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
                
        return listaArea;
    }
    public void insertaRols(Rol rol){
        DbBean db=new DbBean();
        String sql;
        try{
            sql="insert into rol values (";
            sql=sql+" "+ rol.getId_rol() +", ";
            sql=sql+" '"+ rol.getDescripcion() +"', ";
            sql=sql+" '"+ rol.getRequisito() +"', ";
            sql=sql+" '"+ rol.getAniosexp() +"', ";
            sql=sql+" "+ rol.getSueldo() +") ";
            
            
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
    public void actualizaRols(Rol rol){
        DbBean db=new DbBean();
        String sql;
        try{
            sql="update rol set ";
            sql=sql+" descRol = '"+rol.getDescripcion()+"', ";
            sql=sql+" requisito = '"+rol.getRequisito()+"', ";
            sql=sql+" anioexpreq = '"+rol.getAniosexp()+"' ";
            sql=sql+" sueldo = '"+rol.getSueldo()+"' ";
            sql=sql+"where RolID = "+rol.getId_rol()+"";
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
    public boolean eliminaRols(int idRol){
        //verificando la no dependencia de la tabla det_venta
        boolean sw = false;
        DbBean db=new DbBean();       
        Vector<Rol> listaRol = new Vector<Rol>();
        
        String sql;
        sql= "select * from contrato where rolID= "+ idRol +"";

        try{
            ResultSet rstContrato = db.resultadoSQL(sql);

            if (!rstContrato.next()){
                sql="delete from rol where rolID="+idRol+"";
                db.ejecutaSQL(sql);
                sw=true;
            }
        }catch(java.sql.SQLException e){
            
        }
        return sw;
    }
}
