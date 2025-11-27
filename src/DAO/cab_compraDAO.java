package DAO;

import BEAN.cab_compra;
import UTIL.DbBean;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.Vector;

public class cab_compraDAO {

    // === LISTAR (usado por FrmCompras.llenaTblCabCompra y llenaTblActCabCompra) ===
    public Vector<cab_compra> listaItem(boolean sw, String str) {
        // sw = true → filtra por proveedor
        // sw = false → lista todo (no usa str)
        Vector<cab_compra> lista = new Vector<>();
        DbBean db = new DbBean();

        try {
            Connection cn = db.getConnection();
            CallableStatement cst = cn.prepareCall("{call Compra_Listar(?)}");

            if (sw && str != null && !str.trim().isEmpty()) {
                // filtro por ProveedorID
                cst.setInt(1, Integer.parseInt(str));
            } else {
                // sin filtro → NULL
                cst.setNull(1, Types.INTEGER);
            }

            ResultSet rs = cst.executeQuery();
            while (rs.next()) {
                cab_compra cab = new cab_compra();
                cab.setId_compra(rs.getInt("CompraID"));
                cab.setProveedor(rs.getString("Proveedor"));          // alias del SP
                cab.setEmpleado(rs.getString("Empleado"));            // alias del SP
                cab.setFecha(rs.getString("FechaCompra"));
                cab.setEstado(rs.getInt("Estado"));
                lista.add(cab);
            }

        } catch (Exception e) {
            System.err.println("ERROR EN LISTAR CAB_COMPRA:");
            e.printStackTrace();
        } finally {
            try { db.desconecta(); } catch (Exception e) {}
        }

        return lista;
    }

    // === ELIMINAR CABECERA (usado por FrmCompras.btnBorrarVenta y btnBorrarDetalle) ===
    public int borraCab(int idCompra) {
    DbBean db = new DbBean();
    int r = 0;

    try {
        Connection cn = db.getConnection();
        CallableStatement cst = cn.prepareCall("{call Compra_Eliminar(?)}");
        cst.setInt(1, idCompra);

        // El SP tiene SET NOCOUNT ON, por eso no usamos el valor devuelto
        cst.executeUpdate();   // si no lanza excepción, asumimos éxito
        r = 1;

    } catch (Exception e) {
        System.err.println("ERROR EN ELIMINAR CAB_COMPRA:");
        e.printStackTrace();
        r = 0;
    } finally {
        try { db.desconecta(); } catch (Exception e) {}
    }

    return r;
}


    // === INSERTAR CABECERA ===
    public int insertarCab_compra(cab_compra cc) {
        DbBean db = new DbBean();
        int r = 0;

        try {
            Connection cn = db.getConnection();
            CallableStatement cst = cn.prepareCall("{call Compra_Insertar(?,?,?,?,?)}");
            cst.setInt(1, cc.getId_compra());
            cst.setInt(2, cc.getId_proveedor());
            cst.setInt(3, cc.getId_empleado());
            cst.setString(4, cc.getFecha()); // si el SP usa DATE puedes usar setDate
            cst.setInt(5, cc.getEstado());

            r = cst.executeUpdate();
        } catch (Exception e) {
            System.err.println("ERROR EN INSERTAR CAB_COMPRA:");
            e.printStackTrace();
            r = 0;
        } finally {
            try { db.desconecta(); } catch (Exception e) {}
        }

        return r;
    }

    // === ACTUALIZAR CABECERA ===
    public int actualizarCab_compra(cab_compra cc) {
        DbBean db = new DbBean();
        int r = 0;

        try {
            Connection cn = db.getConnection();
            CallableStatement cst = cn.prepareCall("{call Compra_Actualizar(?,?,?,?,?)}");
            cst.setInt(1, cc.getId_compra());
            cst.setInt(2, cc.getId_proveedor());
            cst.setInt(3, cc.getId_empleado());
            cst.setString(4, cc.getFecha());
            cst.setInt(5, cc.getEstado());

            r = cst.executeUpdate();
        } catch (Exception e) {
            System.err.println("ERROR EN ACTUALIZAR CAB_COMPRA:");
            e.printStackTrace();
            r = 0;
        } finally {
            try { db.desconecta(); } catch (Exception e) {}
        }

        return r;
    }

    // === MÉTODO PUENTE para no cambiar FrmCompras ===
    public int procesaItem(cab_compra cc, String proc) {
        if ("insert".equalsIgnoreCase(proc)) {
            return insertarCab_compra(cc);
        } else if ("update".equalsIgnoreCase(proc)) {
            return actualizarCab_compra(cc);
        } else {
            System.err.println("PROC NO RECONOCIDO EN cab_compraDAO.procesaItem: " + proc);
            return 0;
        }
    }
    
        // Obtiene una cabecera de compra por su ID
    public cab_compra obtenerPorId(int idCompra) {
        cab_compra cc = null;
        DbBean db = new DbBean();

        try {
            Connection cn = db.getConnection();
            CallableStatement cst = cn.prepareCall("{call Compra_Obtener(?)}");
            cst.setInt(1, idCompra);

            ResultSet rs = cst.executeQuery();
            if (rs.next()) {
                cc = new cab_compra();
                cc.setId_compra(rs.getInt("CompraID"));
                cc.setId_proveedor(rs.getInt("ProveedorID"));
                cc.setId_empleado(rs.getInt("EmpleadoID"));
                cc.setFecha(rs.getString("FechaCompra"));
                cc.setEstado(rs.getInt("Estado"));
            }

        } catch (Exception e) {
            System.err.println("ERROR EN cab_compraDAO.obtenerPorId (SP)");
            e.printStackTrace();
        } finally {
            try {
                db.desconecta();
            } catch (Exception e) {
                // puede registrarse el error si se desea
            }
        }

        return cc;
    }

}
