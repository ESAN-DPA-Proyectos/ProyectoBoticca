
package DAO;

import BEAN.Ubigeo;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.util.Vector;

public class UbigeoDAO {
    public Vector<Ubigeo> listaUbigeo(String cad){
        DbBean db=new DbBean();
               
        Vector<Ubigeo> listaUbigeo = new Vector<Ubigeo>();
        
        String sql;
        sql= "select * from ubigeo ";
        if(!cad.isEmpty()){ //con este if se agrega el where en el query sql
            sql=sql+" where distrito like '%"+ cad +"%'";
        }
        try{
            ResultSet rstUbigeos = db.resultadoSQL(sql);
            while(rstUbigeos.next()){
                Ubigeo ubi = new Ubigeo();
                ubi.setId_ubigeo(rstUbigeos.getInt(1));
                ubi.setRegion(rstUbigeos.getString(2));
                ubi.setDepartamento(rstUbigeos.getString(3));
                ubi.setProvincia(rstUbigeos.getString(4));
                ubi.setDistrito(rstUbigeos.getString(5));
                listaUbigeo.addElement(ubi);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            db.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
                
        return listaUbigeo;
    }
    
    public void insertaUbigeos(Ubigeo ubi){
        DbBean db=new DbBean();
        String sql;
        try{
            sql="insert into ubigeo values (";
            sql=sql+" "+ ubi.getId_ubigeo() +", ";
            sql=sql+" '"+ ubi.getRegion() +"', ";
            sql=sql+" '"+ ubi.getDepartamento() +"', ";
            sql=sql+" '"+ ubi.getProvincia() +"', ";
            sql=sql+" '"+ ubi.getDistrito() +"') ";
            
            
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
    
    public void actualizaUbigeos(Ubigeo ubi){
        DbBean db=new DbBean();
        String sql;
        try{
            sql="update ubigeo set ";
            sql=sql+" region = '"+ubi.getRegion()+"', ";
            sql=sql+" departamento = '"+ubi.getDepartamento()+"', ";
            sql=sql+" provincia = '"+ubi.getProvincia()+"', ";
            sql=sql+" distrito = '"+ubi.getDistrito()+"' ";
            sql=sql+"where ubigeoID = "+ubi.getId_ubigeo()+"";
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
    
    public boolean eliminaUbigeos(int idUbi){
        //verificando la no dependencia de la tabla det_venta
        boolean sw = false;
        DbBean db=new DbBean();       
        Vector<Ubigeo> listaArea = new Vector<Ubigeo>();
        
        String sql;
        sql= "select * from sede where UbigeoID= "+ idUbi +"";

        try{
            ResultSet rstContrato = db.resultadoSQL(sql);

            if (!rstContrato.next()){
                sql="delete from Ubigeo where UbigeoID="+idUbi+"";
                db.ejecutaSQL(sql);
                sw=true;
            }
        }catch(java.sql.SQLException e){
            
        }
        return sw;
    }
}
