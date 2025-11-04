
package DAO;

import BEAN.Area;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.util.Vector;

public class AreaDAO {
    public Vector<Area> listaArea(String cad){
        DbBean db=new DbBean();
               
        Vector<Area> listaArea = new Vector<Area>();
        
        String sql;
        sql= "select * from area ";
        if(!cad.isEmpty()){ //con este if se agrega el where en el query sql
            sql=sql+" where descArea like '%"+ cad +"%'";
        }
        try{
            ResultSet rstAreas = db.resultadoSQL(sql);
            while(rstAreas.next()){
                Area area = new Area();
                area.setId_area(rstAreas.getInt(1));
                area.setDescripcion(rstAreas.getString(2));
                area.setSubArea(rstAreas.getString(3));
                area.setCentCosto(rstAreas.getInt(4));
                listaArea.addElement(area);
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
    public void insertaAreas(Area area){
        DbBean db=new DbBean();
        String sql;
        try{
            sql="insert into area values (";
            sql=sql+" "+ area.getId_area() +", ";
            sql=sql+" '"+ area.getDescripcion() +"', ";
            sql=sql+" '"+ area.getSubArea() +"', ";
            sql=sql+" "+ area.getCentCosto() +") ";
            
            
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
    public void actualizaAreas(Area area){
        DbBean db=new DbBean();
        String sql;
        try{
            sql="update area set ";
            sql=sql+" descArea = '"+area.getDescripcion()+"', ";
            sql=sql+" subArea = '"+area.getSubArea()+"', ";
            sql=sql+" centCosto = '"+area.getCentCosto()+"' ";
            sql=sql+"where areaID = "+area.getId_area()+"";
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
    public boolean eliminaAreas(int idArea){
        //verificando la no dependencia de la tabla det_venta
        boolean sw = false;
        DbBean db=new DbBean();       
        Vector<Area> listaArea = new Vector<Area>();
        
        String sql;
        sql= "select * from contrato where AreaID= "+ idArea +"";

        try{
            ResultSet rstContrato = db.resultadoSQL(sql);

            if (!rstContrato.next()){
                sql="delete from Area where areaID="+idArea+"";
                db.ejecutaSQL(sql);
                sw=true;
            }
        }catch(java.sql.SQLException e){
            
        }
        return sw;
    }
}
