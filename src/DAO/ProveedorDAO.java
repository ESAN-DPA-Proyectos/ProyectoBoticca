
package DAO;

import BEAN.Proveedor;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.util.Vector;

public class ProveedorDAO {
    public Vector<Proveedor> listaProveedores(String cad){
        DbBean db=new DbBean();
               
        Vector<Proveedor> listaProv = new Vector<Proveedor>();
        
        String sql;
        sql= "select * from proveedores ";
        if(!cad.isEmpty()){ //con este if se agrega el where en el query sql
            sql=sql+" where nombre like '%"+ cad +"%'";
        }
        try{
            ResultSet rstProveedores = db.resultadoSQL(sql);
            while(rstProveedores.next()){
                Proveedor prov = new Proveedor();
                prov.setId_proveedor(rstProveedores.getInt(1));
                prov.setNombre(rstProveedores.getString(2));
                prov.setNombreContacto(rstProveedores.getString(3));
                prov.setDireccion(rstProveedores.getString(4));
                prov.setCiudad(rstProveedores.getString(5));
                prov.setTelefono(rstProveedores.getString(6));
                prov.setEstado(rstProveedores.getInt(7));
                listaProv.addElement(prov);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            db.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
                
        return listaProv;
    }
    public void insertaProveedores(Proveedor prov){
        DbBean db=new DbBean();
        String sql;
        try{
            sql="insert into proveedores values (";
            sql=sql+" "+ prov.getId_proveedor() +", ";
            sql=sql+" '"+ prov.getNombre() +"', ";
            sql=sql+" '"+ prov.getNombreContacto() +"', ";
            sql=sql+" '"+ prov.getDireccion() +"', ";
            sql=sql+" '"+ prov.getCiudad() +"', ";
            sql=sql+" '"+ prov.getTelefono() +"', ";
            sql=sql+" "+ prov.getEstado() +") ";
            
            
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
    public void actualizaProveedores(Proveedor prov){
        DbBean db=new DbBean();
        String sql;
        try{
            sql="update proveedores set ";
            sql=sql+" nombre = '"+prov.getNombre()+"', ";
            sql=sql+" nombrecontacto = '"+prov.getNombreContacto()+"', ";
            sql=sql+" direccion = '"+prov.getDireccion()+"', ";
            sql=sql+" ciudad = '"+prov.getCiudad()+"', ";
            sql=sql+" telefono = '"+prov.getTelefono()+"', ";
            sql=sql+" estado = '"+prov.getEstado()+"' ";
            sql=sql+"where proveedorID = "+prov.getId_proveedor()+"";
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
    public boolean eliminaProveedores(int idProv){
        //verificando la no dependencia de la tabla det_venta
        boolean sw = false;
        DbBean db=new DbBean();       
        Vector<Proveedor> listaProv = new Vector<Proveedor>();
        
        String sql;
        sql= "select * from Compras where ProveedorID= "+ idProv +"";
        String sql2;
        sql2= "select * from Medicamentos where ProveedorID= "+ idProv +"";
        try{
            ResultSet rstCompras = db.resultadoSQL(sql);
            ResultSet rstMedicamentos = db.resultadoSQL(sql2);
            if (!rstCompras.next() && !rstMedicamentos.next()){
                sql="delete from Proveedores where ProveedorID="+idProv+"";
                db.ejecutaSQL(sql);
                sw=true;
            }
        }catch(java.sql.SQLException e){
            
        }
        return sw;
    }
}
