
package DAO;

import BEAN.Empleado;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.util.Vector;

public class EmpleadoDAO {
    public Vector<Empleado> listaEmpleados(String cad){
        DbBean db=new DbBean();
               
        Vector<Empleado> listaEmpl = new Vector<Empleado>();
        
        String sql;
        sql= "select * from empleados ";
        if(!cad.isEmpty()){ //con este if se agrega el where en el query sql
            sql=sql+" where nombre like '%"+ cad +"%'";
        }
        try{
            ResultSet rstEmpleados = db.resultadoSQL(sql);
            while(rstEmpleados.next()){
                Empleado prov = new Empleado();
                prov.setId_empleado(rstEmpleados.getInt(1));
                prov.setNombre(rstEmpleados.getString(2));
                prov.setApellido(rstEmpleados.getString(3));
                prov.setCargo(rstEmpleados.getString(4));
                prov.setFecContrato(rstEmpleados.getString(5));
                prov.setTelefono(rstEmpleados.getString(6));
                prov.setEstado(rstEmpleados.getInt(7));
                listaEmpl.addElement(prov);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            db.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
                
        return listaEmpl;
    }
    public void insertaEmpleados(Empleado empl){
        DbBean db=new DbBean();
        String sql;
        try{
            sql="insert into empleados values (";
            sql=sql+" "+ empl.getId_empleado() +", ";
            sql=sql+" '"+ empl.getNombre() +"', ";
            sql=sql+" '"+ empl.getApellido() +"', ";
            sql=sql+" '"+ empl.getCargo() +"', ";
            sql=sql+" '"+ empl.getFecContrato() +"', ";
            sql=sql+" '"+ empl.getTelefono() +"', ";
            sql=sql+" "+ empl.getEstado() +") ";
            
            
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
    public void actualizaEmpleados(Empleado empl){
        DbBean db=new DbBean();
        String sql;
        try{
            sql="update empleados set ";
            sql=sql+" nombre = '"+empl.getNombre()+"', ";
            sql=sql+" apellido = '"+empl.getApellido()+"', ";
            sql=sql+" cargo = '"+empl.getCargo()+"', ";
            sql=sql+" FechaContratacion = '"+empl.getFecContrato()+"', ";
            sql=sql+" telefono = '"+empl.getTelefono()+"', ";
            sql=sql+" estado = '"+empl.getEstado()+"' ";
            sql=sql+"where empleadoID = "+empl.getId_empleado()+"";
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
    public boolean eliminaEmpleados(int idEmpl){
        //verificando la no dependencia de la tabla det_venta
        boolean sw = false;
        DbBean db=new DbBean();       
        Vector<Empleado> listaEmpl = new Vector<Empleado>();
        
        String sql;
        sql= "select * from Compras where EmpleadoID= "+ idEmpl +"";
        String sql2;
        sql2= "select * from Usuario where EmpleadoID= "+ idEmpl +"";
        String sql3;
        sql3= "select * from Curricullum where EmpleadoID= "+ idEmpl +"";
        String sql4;
        sql4= "select * from Contrato where EmpleadoID= "+ idEmpl +"";
        try{
            ResultSet rstCompras = db.resultadoSQL(sql);
            ResultSet rstUsuario = db.resultadoSQL(sql2);
            ResultSet rstCurricullum = db.resultadoSQL(sql3);
            ResultSet rstContrato = db.resultadoSQL(sql4);
            if (!rstCompras.next() && !rstUsuario.next() && !rstCurricullum.next() && !rstContrato.next()){
                sql="delete from Empleados where EmpleadoID="+idEmpl+"";
                db.ejecutaSQL(sql);
                sw=true;
            }
        }catch(java.sql.SQLException e){
            
        }
        return sw;
    }
}
