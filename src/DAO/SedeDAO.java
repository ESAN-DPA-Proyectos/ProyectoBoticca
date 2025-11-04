
package DAO;

import BEAN.Sede;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.util.Vector;

public class SedeDAO {
    public Vector<Sede> listaSede(String cad){
        DbBean db=new DbBean();
               
        Vector<Sede> listaSede = new Vector<Sede>();
        
        String sql;
        sql= "select * from sede ";
        if(!cad.isEmpty()){ //con este if se agrega el where en el query sql
            sql=sql+" where nombsede like '%"+ cad +"%'";
        }
        try{
            ResultSet rstSedes = db.resultadoSQL(sql);
            while(rstSedes.next()){
                Sede sede = new Sede();
                sede.setId_sede(rstSedes.getInt(1));
                sede.setId_ubigeo(rstSedes.getInt(2));
                sede.setNombre(rstSedes.getString(3));
                sede.setDireccion(rstSedes.getString(4));
                sede.setTelefono(rstSedes.getString(5));
                listaSede.addElement(sede);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            db.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
                
        return listaSede;
    }
    public void insertaSedes(Sede sede){
        DbBean db=new DbBean();
        String sql;
        try{
            sql="insert into sede values (";
            sql=sql+" "+ sede.getId_sede() +", ";
            sql=sql+" "+ sede.getId_ubigeo() +", ";
            sql=sql+" '"+ sede.getNombre() +"', ";
            sql=sql+" '"+ sede.getDireccion() +"', ";
            sql=sql+" '"+ sede.getTelefono() +"') ";
            
            
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
    public void actualizaSedes(Sede sede){
        DbBean db=new DbBean();
        String sql;
        try{
            sql="update sede set ";
            sql=sql+" ubigeoid = "+sede.getId_ubigeo()+", ";
            sql=sql+" nombsede = '"+sede.getNombre()+"', ";
            sql=sql+" direccion = '"+sede.getDireccion()+"', ";
            sql=sql+" tlf = '"+sede.getTelefono()+"' ";
            sql=sql+"where sedeID = "+sede.getId_sede()+"";
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
    public boolean eliminaSedes(int idSede){
        //verificando la no dependencia de la tabla det_venta
        boolean sw = false;
        DbBean db=new DbBean();       
        Vector<Sede> listaArea = new Vector<Sede>();
        
        String sql;
        sql= "select * from ventas where sedeID= "+ idSede +"";

        try{
            ResultSet rstContrato = db.resultadoSQL(sql);

            if (!rstContrato.next()){
                sql="delete from sede where sedeID="+idSede+"";
                db.ejecutaSQL(sql);
                sw=true;
            }
        }catch(java.sql.SQLException e){
            
        }
        return sw;
    }
}
