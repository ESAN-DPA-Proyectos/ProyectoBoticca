package DAO;

import BEAN.Contrato;
import UTIL.DbBean;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

public class ContratoDAO {

    /** LISTAR CONTRATOS (usa SP Contrato_Listar) **/
    public Vector<Contrato> listaItem(boolean sw, String str) {

        Vector<Contrato> lista = new Vector<>();
        DbBean db = new DbBean();

        try {
            Connection cn = db.getConnection();
            CallableStatement cst = cn.prepareCall("{call Contrato_Listar(?)}");

            // si sw es true se manda el filtro, si no, se manda cadena vacía
            if (sw && str != null) {
                cst.setString(1, str);
            } else {
                cst.setString(1, "");
            }

            ResultSet rs = cst.executeQuery();

            while (rs.next()) {
                Contrato ct = new Contrato();

                ct.setId_contrato(rs.getInt("ContratoID"));
                ct.setEmpleado(rs.getString("Empleado"));
                ct.setFecini(rs.getString("Fech_Ini"));
                ct.setFecfin(rs.getString("Fech_Fin"));
                ct.setArea(rs.getString("DescArea"));
                ct.setRol(rs.getString("DescRol"));
                ct.setSueldo(rs.getFloat("Sueldo"));
                ct.setId_empleado(rs.getInt("EmpleadoID"));
                ct.setId_area(rs.getInt("AreaID"));
                ct.setId_rol(rs.getInt("RolID"));
                ct.setEstado(rs.getInt("Estado"));

                lista.add(ct);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { db.desconecta(); } catch (Exception e) {}
        }

        return lista;
    }

    /*--------------------------------------------------------------------------*/

    /** INSERTAR CONTRATO (Contrato_Insertar) **/
    public int insertarContrato(Contrato ct) {

        DbBean db = new DbBean();
        int resultado = 0;

        try {
            Connection cn = db.getConnection();
            CallableStatement cst = cn.prepareCall("{call Contrato_Insertar(?,?,?,?,?,?,?,?)}");

            cst.setInt(1, ct.getId_contrato());
            cst.setInt(2, ct.getId_empleado());
            cst.setString(3, ct.getFecini());   // formato 'YYYY-MM-DD'
            cst.setString(4, ct.getFecfin());
            cst.setInt(5, ct.getId_area());
            cst.setInt(6, ct.getId_rol());
            cst.setFloat(7, ct.getSueldo());
            cst.setInt(8, ct.getEstado());

            cst.executeUpdate();   // si no lanza excepción, asumimos éxito
            resultado = 1;

        } catch (Exception e) {
            e.printStackTrace();
            resultado = 0;
        } finally {
            try { db.desconecta(); } catch (Exception e) {}
        }

        return resultado;
    }

    /** ACTUALIZAR CONTRATO (Contrato_Actualizar) **/
    public int actualizarContrato(Contrato ct) {

        DbBean db = new DbBean();
        int resultado = 0;

        try {
            Connection cn = db.getConnection();
            CallableStatement cst = cn.prepareCall("{call Contrato_Actualizar(?,?,?,?,?,?,?,?)}");

            cst.setInt(1, ct.getId_contrato());
            cst.setInt(2, ct.getId_empleado());
            cst.setString(3, ct.getFecini());
            cst.setString(4, ct.getFecfin());
            cst.setInt(5, ct.getId_area());
            cst.setInt(6, ct.getId_rol());
            cst.setFloat(7, ct.getSueldo());
            cst.setInt(8, ct.getEstado());

            cst.executeUpdate();
            resultado = 1;

        } catch (Exception e) {
            e.printStackTrace();
            resultado = 0;
        } finally {
            try { db.desconecta(); } catch (Exception e) {}
        }

        return resultado;
    }

    /** ELIMINAR CONTRATO (Contrato_Eliminar) **/
    public int eliminarContrato(int idContrato) {

        DbBean db = new DbBean();
        int resultado = 0;

        try {
            Connection cn = db.getConnection();
            CallableStatement cst = cn.prepareCall("{call Contrato_Eliminar(?)}");
            cst.setInt(1, idContrato);

            cst.executeUpdate();
            resultado = 1;

        } catch (Exception e) {
            e.printStackTrace();
            resultado = 0;
        } finally {
            try { db.desconecta(); } catch (Exception e) {}
        }

        return resultado;
    }
}
