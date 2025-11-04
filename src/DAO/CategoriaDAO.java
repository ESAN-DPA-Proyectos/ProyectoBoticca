
package DAO;

import BEAN.Categoria;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.util.Vector;

public class CategoriaDAO {
    public Vector<Categoria> listaCategorias(String cad){
        DbBean db=new DbBean();
               
        Vector<Categoria> listaCat = new Vector<Categoria>();
        
        String sql;
        sql= "select * from categoria ";
        if(!cad.isEmpty()){ //con este if se agrega el where en el query sql
            sql=sql+" where desccategoria like '%"+ cad +"%'";
        }
        try{
            ResultSet rstCategoria = db.resultadoSQL(sql);
            while(rstCategoria.next()){
                Categoria cat = new Categoria();
                cat.setId_categoria(rstCategoria.getInt(1));
                cat.setDescripcion(rstCategoria.getString(2));
                cat.setObs(rstCategoria.getString(3));

                listaCat.addElement(cat);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            db.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
                
        return listaCat;
    }
    public void insertaCategorias(Categoria cat){
        DbBean db=new DbBean();
        String sql;
        try{
            sql="insert into categoria values (";
            sql=sql+" "+ cat.getId_categoria() +", ";
            sql=sql+" '"+ cat.getDescripcion() +"', ";
            sql=sql+" '"+ cat.getObs() +"') ";
            
            
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
    public void actualizaCategorias(Categoria cat){
        DbBean db=new DbBean();
        String sql;
        try{
            sql="update categoria set ";
            sql=sql+" DescCategoria = '"+cat.getDescripcion()+"', ";
            sql=sql+" obs = '"+cat.getObs()+"' ";
            sql=sql+"where categoriaID = "+cat.getId_categoria()+"";
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
    public boolean eliminaCategorias(int idCat){
        //verificando la no dependencia de la tabla det_venta
        boolean sw = false;
        DbBean db=new DbBean();       
        Vector<Categoria> listaCat = new Vector<Categoria>();
        
        String sql;
        sql= "select * from medicamentos where categotiaID= "+ idCat +"";

        try{
            ResultSet rstMedicamentos = db.resultadoSQL(sql);

            if (!rstMedicamentos.next()){
                sql="delete from categoria where categoriaID="+idCat+"";
                db.ejecutaSQL(sql);
                sw=true;
            }
        }catch(java.sql.SQLException e){
            
        }
        return sw;
    }
}
