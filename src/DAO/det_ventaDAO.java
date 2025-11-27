package DAO;

import BEAN.det_venta;
import UTIL.DbBean;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Vector;

public class det_ventaDAO {
    public Vector<det_venta> listaItem(boolean sw, String str) {
        Vector<det_venta> item = new Vector<>();
        DbBean con = new DbBean();
        Connection cn = null;
        CallableStatement cst = null;
        ResultSet rs = null;

        try {
            cn = con.getConnection();
            // Llamamos al SP DetalleVenta_Listar(@VentaID)
            cst = cn.prepareCall("{call DetalleVenta_Listar(?)}");

            if (sw) {
                // str es el Id de la venta a filtrar
                cst.setInt(1, Integer.parseInt(str));
            } else {
                cst.setNull(1, Types.INTEGER);
            }

            rs = cst.executeQuery();

            while (rs.next()) {
                det_venta detVenta = new det_venta();
                detVenta.setId_detventa(rs.getInt("DetalleVentaID"));
                detVenta.setId_venta(rs.getInt("VentaID"));
                detVenta.setMedicamento(rs.getString("Medicamento"));
                detVenta.setCantidad(rs.getInt("Cantidad"));
                detVenta.setPreciounit(rs.getFloat("PrecioUnitario"));
                detVenta.setPreciototal(rs.getFloat("PrecioTotal"));
                detVenta.setId_medicamento(rs.getInt("MedicamentoID"));
                item.add(detVenta);
            }

        } catch (Exception e) {
            System.err.println("ERROR EN LISTAR DETALLE VENTA:");
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception ex) {}
            try { if (cst != null) cst.close(); } catch (Exception ex) {}
            try { con.desconecta(); } catch (Exception ex) {}
        }

        return item;
    }

    
    public void borraDeta(int idVe){
        int resultado = 0;
        String sql = "";
        DbBean con = new DbBean();

        // Usando el SP DetalleVenta_EliminarPorVenta @VentaID
        sql = "EXEC DetalleVenta_EliminarPorVenta " + idVe;
        System.out.println("Del dv (SP) " + sql);
        try {
            resultado = con.ejecutaSQL(sql);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        try {
            con.desconecta();
        } catch (SQLException e) {
    }
}

    
    public void borraDetaUnit(int idVe){
        int resultado = 0;
        String sql = "";
        DbBean con = new DbBean();

        // Usando el SP DetalleVenta_EliminarPorId @DetalleVentaID
        sql = "EXEC DetalleVenta_EliminarPorId " + idVe;
        System.out.println("Del dv unit (SP) " + sql);
        try {
            resultado = con.ejecutaSQL(sql);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        try {
            con.desconecta();
        } catch (SQLException e) {
        }
    }

    
    public int procesaItem(det_venta dv, String proc){
        int resultado = 0;
        String sql = "";
        DbBean con = new DbBean();

        if (proc.equals("insert")) {
            // SP DetalleVenta_Insertar
            sql = "EXEC DetalleVenta_Insertar "
                    + dv.getId_detventa() + ", "
                    + dv.getId_venta() + ", "
                    + dv.getId_medicamento() + ", "
                    + dv.getCantidad() + ", "
                    + dv.getPreciounit();
        }

        if (proc.equals("update")) {
            // SP DetalleVenta_Actualizar
            sql = "EXEC DetalleVenta_Actualizar "
                    + dv.getId_detventa() + ", "
                    + dv.getId_medicamento() + ", "
                    + dv.getCantidad() + ", "
                    + dv.getPreciounit();
        }

        System.out.println("Observando el estado de la sentencia sql (detalle venta): " + sql);

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

    
}
