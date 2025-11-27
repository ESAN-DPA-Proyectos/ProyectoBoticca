package DAO;

import BEAN.det_compra;
import UTIL.DbBean;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.Vector;

public class det_compraDAO {

    // LISTAR (usa DetalleCompra_Listar)
    public Vector<det_compra> listaItem(boolean sw, String str) {
        Vector<det_compra> lista = new Vector<>();
        DbBean db = new DbBean();
        try {
            Connection cn = db.getConnection();
            CallableStatement cst =
                    cn.prepareCall("{call DetalleCompra_Listar(?)}");

            if (sw && str != null && !str.trim().isEmpty()) {
                cst.setInt(1, Integer.parseInt(str));
            } else {
                cst.setNull(1, Types.INTEGER); // lista todo
            }

            ResultSet rs = cst.executeQuery();
            while (rs.next()) {
                det_compra det = new det_compra();
                det.setId_compra(rs.getInt("CompraID"));
                det.setMedicamento(rs.getString("Medicamento"));
                det.setCantidad(rs.getInt("Cantidad"));
                det.setPreciounit(rs.getFloat("PrecioUnitario"));
                det.setPreciototal(rs.getFloat("PrecioTotal"));
                det.setId_medicamento(rs.getInt("MedicamentoID"));
                lista.add(det);
            }
        } catch (Exception e) {
            System.err.println("ERROR EN LISTAR DETALLECOMPRA:");
            e.printStackTrace();
        } finally {
            try { db.desconecta(); } catch (Exception e) {}
        }
        return lista;
    }

    // INSERTAR (usa DetalleCompra_Insertar)
    public int insertar(det_compra dc) {
        int r = 0;
        DbBean db = new DbBean();
        try {
            Connection cn = db.getConnection();
            CallableStatement cst =
                    cn.prepareCall("{call DetalleCompra_Insertar(?,?,?,?)}");
            cst.setInt(1, dc.getId_compra());
            cst.setInt(2, dc.getId_medicamento());
            cst.setInt(3, dc.getCantidad());
            cst.setFloat(4, dc.getPreciounit());
            r = cst.executeUpdate();
        } catch (Exception e) {
            System.err.println("ERROR EN INSERTAR DETALLECOMPRA:");
            e.printStackTrace();
            r = 0;
        } finally {
            try { db.desconecta(); } catch (Exception e) {}
        }
        return r;
    }

    // ACTUALIZAR (usa DetalleCompra_Actualizar)
    public int actualizar(det_compra dc) {
        int r = 0;
        DbBean db = new DbBean();
        try {
            Connection cn = db.getConnection();
            CallableStatement cst =
                    cn.prepareCall("{call DetalleCompra_Actualizar(?,?,?,?)}");
            cst.setInt(1, dc.getId_compra());
            cst.setInt(2, dc.getId_medicamento());
            cst.setInt(3, dc.getCantidad());
            cst.setFloat(4, dc.getPreciounit());
            r = cst.executeUpdate();
        } catch (Exception e) {
            System.err.println("ERROR EN ACTUALIZAR DETALLECOMPRA:");
            e.printStackTrace();
            r = 0;
        } finally {
            try { db.desconecta(); } catch (Exception e) {}
        }
        return r;
    }

    // ELIMINAR TODOS LOS DETALLES DE UNA COMPRA (usa DetalleCompra_EliminarPorCompra)
    public int eliminarPorCompra(int compraId) {
        int r = 0;
        DbBean db = new DbBean();
        try {
            Connection cn = db.getConnection();
            CallableStatement cst =
                    cn.prepareCall("{call DetalleCompra_EliminarPorCompra(?)}");
            cst.setInt(1, compraId);

            cst.executeUpdate();  // con NOCOUNT ON el rowcount será 0
            r = 1;                // si no hubo excepción, consideramos éxito

        } catch (Exception e) {
            System.err.println("ERROR EN ELIMINAR DETALLECOMPRA POR COMPRA:");
            e.printStackTrace();
            r = 0;
        } finally {
            try { db.desconecta(); } catch (Exception e) {}
        }
        return r;
    }

    // ELIMINAR SOLO UN MEDICAMENTO DE UNA COMPRA (usa DetalleCompra_EliminarUnit)
    public int eliminarUnit(int compraId, int medicamentoId) {
        int r = 0;
        DbBean db = new DbBean();
        try {
            Connection cn = db.getConnection();
            CallableStatement cst =
                    cn.prepareCall("{call DetalleCompra_EliminarUnit(?,?)}");
            cst.setInt(1, compraId);
            cst.setInt(2, medicamentoId);

            // Como el SP tiene SET NOCOUNT ON, no confiamos en el rowcount
            cst.executeUpdate();  // si no lanza excepción, asumimos éxito
            r = 1;

        } catch (Exception e) {
            System.err.println("ERROR EN ELIMINAR DETALLECOMPRA UNITARIO:");
            e.printStackTrace();
            r = 0;
        } finally {
            try { db.desconecta(); } catch (Exception e) {}
        }
        return r;
    }


    // Método de compatibilidad con el formulario
    public int procesaItem(det_compra dc, String proc) {
        if ("insert".equalsIgnoreCase(proc)) {
            return insertar(dc);
        } else if ("update".equalsIgnoreCase(proc)) {
            return actualizar(dc);
        } else {
            return 0;
        }
    }

    // Métodos con el nombre antiguo que usa FrmCompras
    public void borraDeta(int idVe) {
        eliminarPorCompra(idVe);
    }

    // Si luego quieres borrar sólo una fila del detalle:
    public void borraDetaUnit(int compraId, int medicamentoId) {
        eliminarUnit(compraId, medicamentoId);
    }
}
