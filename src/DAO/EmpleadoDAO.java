package DAO;

import BEAN.Empleado;
import UTIL.DbBean;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

public class EmpleadoDAO {

    /** LISTAR EMPLEADOS **/
    public Vector<Empleado> listaEmpleados(String cad){
        Vector<Empleado> lista = new Vector<>();
        DbBean db = new DbBean();

        try {
            Connection cn = db.getConnection();
            CallableStatement cst = cn.prepareCall("{call Empleado_Listar(?)}");
            cst.setString(1, cad);

            ResultSet rs = cst.executeQuery();
            while(rs.next()){
                Empleado emp = new Empleado();

                emp.setId_empleado(rs.getInt("EmpleadoID"));
                emp.setNombre(rs.getString("Nombre"));
                emp.setApellido(rs.getString("Apellido"));
                emp.setCargo(rs.getString("Cargo"));
                emp.setFecContrato(rs.getString("FechaContratacion"));
                emp.setTelefono(rs.getString("Telefono"));
                emp.setEstado(rs.getInt("Estado"));

                lista.add(emp);
            }
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            try { db.desconecta(); } catch(Exception ex){}
        }

        return lista;
    }

    /** INSERTAR EMPLEADO **/
    public void insertaEmpleados(Empleado emp){
        DbBean db = new DbBean();

        try {
            Connection cn = db.getConnection();
            CallableStatement cst = cn.prepareCall("{call Empleado_Insertar(?,?,?,?,?,?,?)}");

            cst.setInt(1, emp.getId_empleado());
            cst.setString(2, emp.getNombre());
            cst.setString(3, emp.getApellido());
            cst.setString(4, emp.getCargo());
            cst.setString(5, emp.getFecContrato());
            cst.setString(6, emp.getTelefono());
            cst.setInt(7, emp.getEstado());

            cst.executeUpdate();

        } catch(Exception e){
            e.printStackTrace();
        } finally {
            try { db.desconecta(); } catch(Exception ex){}
        }
    }

    /** ACTUALIZAR EMPLEADO **/
    public void actualizaEmpleados(Empleado emp){
        DbBean db = new DbBean();

        try {
            Connection cn = db.getConnection();
            CallableStatement cst = cn.prepareCall("{call Empleado_Actualizar(?,?,?,?,?,?,?)}");

            cst.setInt(1, emp.getId_empleado());
            cst.setString(2, emp.getNombre());
            cst.setString(3, emp.getApellido());
            cst.setString(4, emp.getCargo());
            cst.setString(5, emp.getFecContrato());
            cst.setString(6, emp.getTelefono());
            cst.setInt(7, emp.getEstado());

            cst.executeUpdate();

        } catch(Exception e){
            e.printStackTrace();
        } finally {
            try { db.desconecta(); } catch(Exception ex){}
        }
    }

    /** ELIMINAR EMPLEADO **/
    public boolean eliminaEmpleados(int idEmpl){
        DbBean db = new DbBean();
        boolean sw = false;

        try {
            Connection cn = db.getConnection();
            CallableStatement cst = cn.prepareCall("{call Empleado_Eliminar(?)}");
            cst.setInt(1, idEmpl);

            cst.executeUpdate();   // si no lanza excepción, asumimos éxito
            sw = true;

        } catch(Exception e){
            e.printStackTrace();
            sw = false;
        } finally {
            try { db.desconecta(); } catch(Exception ex){}
        }

        return sw;
    }

}
