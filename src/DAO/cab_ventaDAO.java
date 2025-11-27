
package DAO;

import BEAN.Sede;
import BEAN.cab_venta;
import UTIL.DbBean;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Vector;

public class cab_ventaDAO {
    public Vector<cab_venta> listaItem(boolean sw, String str) {
        Vector<cab_venta> item = new Vector<>();
        DbBean con = new DbBean();
        Connection cn = null;
        CallableStatement cst = null;
        ResultSet rs = null;

        try {
            cn = con.getConnection();
            // Llamamos al SP Venta_Listar(@ClienteID)
            cst = cn.prepareCall("{call Venta_Listar(?)}");

            if (sw) {
                // str es el Id del cliente para filtrar
                cst.setInt(1, Integer.parseInt(str));
            } else {
                cst.setNull(1, Types.INTEGER);
            }

            rs = cst.executeQuery();

            while (rs.next()) {
                cab_venta cv = new cab_venta();
                cv.setId_venta(rs.getInt("VentaID"));
                cv.setEmpleado(rs.getString("Empleado"));
                cv.setFecha(rs.getString("FechaVenta"));
                cv.setSede(rs.getString("NombSede"));
                cv.setEstado(rs.getInt("Estado"));
                item.add(cv);
            }

        } catch (Exception e) {
            System.err.println("ERROR EN LISTAR VENTA:");
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception ex) {}
            try { if (cst != null) cst.close(); } catch (Exception ex) {}
            try { con.desconecta(); } catch (Exception ex) {}
        }

        return item;
    }

    
    public int borraCab(int idVe) {
        int r = 0;
        DbBean con = new DbBean();
        Connection cn = null;
        CallableStatement cst = null;

        try {
            cn = con.getConnection();
            cst = cn.prepareCall("{call Venta_Eliminar(?)}");
            cst.setInt(1, idVe);
            r = cst.executeUpdate();
        } catch (Exception e) {
            System.err.println("ERROR EN ELIMINAR CABECERA VENTA:");
            e.printStackTrace();
            r = 0;
        } finally {
            try { if (cst != null) cst.close(); } catch (Exception ex) {}
            try { con.desconecta(); } catch (Exception ex) {}
        }

        return r;
    }
    
    public int procesaItem(cab_venta cv, String proc){
        int resultado = 0;
        String sql = "";
        DbBean con = new DbBean();

        // Usamos SP Venta_Insertar y Venta_Actualizar
        if (proc.equals("insert")) {
            sql = "EXEC Venta_Insertar "
                    + cv.getId_venta() + ", "
                    + cv.getId_cliente() + ", "
                    + cv.getId_empleado() + ", '"
                    + cv.getFecha() + "', "
                    + cv.getId_sede() + ", "
                    + cv.getEstado();
            System.out.println("SQL INSERT (SP): " + sql);
        }

        if (proc.equals("update")) {
            sql = "EXEC Venta_Actualizar "
                    + cv.getId_venta() + ", "
                    + cv.getId_cliente() + ", "
                    + cv.getId_empleado() + ", '"
                    + cv.getFecha() + "', "
                    + cv.getId_sede() + ", "
                    + cv.getEstado();
            System.out.println("SQL UPDATE (SP): " + sql);
        }

        System.out.println("Observando el estado de la sentencia sql: " + sql);

        try {
            resultado = con.ejecutaSQL(sql);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }

        try {
            con.desconecta();
        } catch (SQLException e) {
        }

        return resultado;
    }
    
        // === OBTENER UNA VENTA POR ID (usado en pestaña Actualizar) ===
    public cab_venta obtenerPorId(int idVenta) {
        cab_venta cv = null;
        DbBean db = new DbBean();

        try {
            Connection cn = db.getConnection();
            CallableStatement cst =
                    cn.prepareCall("{call Venta_Obtener(?)}");
            cst.setInt(1, idVenta);

            ResultSet rs = cst.executeQuery();
            if (rs.next()) {
                cv = new cab_venta();
                cv.setId_venta(rs.getInt("VentaID"));
                cv.setId_cliente(rs.getInt("ClienteID"));
                cv.setId_empleado(rs.getInt("EmpleadoID"));
                cv.setFecha(rs.getString("FechaVenta"));
                cv.setId_sede(rs.getInt("SedeId"));
                cv.setEstado(rs.getInt("Estado"));
            }

            rs.close();
            cst.close();

        } catch (Exception e) {
            System.err.println("ERROR EN cab_ventaDAO.obtenerPorId (SP)");
            e.printStackTrace();
        } finally {
            try {
                db.desconecta();
            } catch (Exception e) {
                // opcional: registrar error de desconexión
            }
        }

        return cv;
    }
}
