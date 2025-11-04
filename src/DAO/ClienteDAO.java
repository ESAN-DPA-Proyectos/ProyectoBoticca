
package DAO;

import BEAN.Cliente;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.util.Vector;

public class ClienteDAO {
    public Vector<Cliente> listaClientes(String cad){
        DbBean db=new DbBean();
               
        Vector<Cliente> listaClien = new Vector<Cliente>();
        
        String sql;
        sql= "select * from clientes ";
        if(!cad.isEmpty()){ //con este if se agrega el where en el query sql
            sql=sql+" where nombre like '%"+ cad +"%'";
        }
        try{
            ResultSet rstClientes = db.resultadoSQL(sql);
            while(rstClientes.next()){
                Cliente clien = new Cliente();
                clien.setId_cliente(rstClientes.getInt(1));
                clien.setNombre(rstClientes.getString(2));
                clien.setApellido(rstClientes.getString(3));
                clien.setDireccion(rstClientes.getString(4));
                clien.setTelefono(rstClientes.getString(5));
                clien.setDni(rstClientes.getString(6));
                clien.setGenero(rstClientes.getInt(7));
                clien.setEstcivil(rstClientes.getInt(8));
                clien.setEstado(rstClientes.getInt(9));
                listaClien.addElement(clien);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            db.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
                
        return listaClien;
    }
    public void insertaClientes(Cliente clien){
        DbBean db=new DbBean();
        String sql;
        try{
            sql="insert into clientes values (";
            sql=sql+" "+ clien.getId_cliente() +", ";
            sql=sql+" '"+ clien.getNombre() +"', ";
            sql=sql+" '"+ clien.getApellido() +"', ";
            sql=sql+" '"+ clien.getDireccion() +"', ";
            sql=sql+" '"+ clien.getTelefono() +"', ";
            sql=sql+" '"+ clien.getDni() +"', ";
            sql=sql+" '"+ clien.getGenero() +"', ";
            sql=sql+" '"+ clien.getEstcivil() +"', ";
            sql=sql+" "+ clien.getEstado() +") ";
            
            
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
    public void actualizaClientes(Cliente clien){
        DbBean db=new DbBean();
        String sql;
        try{
            sql="update clientes set ";
            sql=sql+" nombre = '"+clien.getNombre()+"', ";
            sql=sql+" apellido = '"+clien.getApellido()+"', ";
            sql=sql+" direccion = '"+clien.getDireccion()+"', ";
            sql=sql+" telefono = '"+clien.getTelefono()+"', ";
            sql=sql+" dni = '"+clien.getDni()+"', ";
            sql=sql+" genero = '"+clien.getGenero()+"', ";
            sql=sql+" estcivil = '"+clien.getEstcivil()+"', ";
            sql=sql+" estado = '"+clien.getEstado()+"' ";
            sql=sql+"where clienteID = "+clien.getId_cliente()+"";
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
    public boolean eliminaClientes(int idClien){
        //verificando la no dependencia de la tabla det_venta
        boolean sw = false;
        DbBean db=new DbBean();       
        Vector<Cliente> listaClien = new Vector<Cliente>();
        
        String sql;
        sql= "select * from ventas where ClienteID= "+ idClien +"";

        try{
            ResultSet rstClientes = db.resultadoSQL(sql);

            if (!rstClientes.next()){
                sql="delete from clientes where clienteID="+idClien+"";
                db.ejecutaSQL(sql);
                sw=true;
            }
        }catch(java.sql.SQLException e){
            
        }
        return sw;
    }
}
