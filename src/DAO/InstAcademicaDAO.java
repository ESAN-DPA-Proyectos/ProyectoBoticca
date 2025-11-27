package DAO;

import BEAN.InstAcademica;
import UTIL.DbBean;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

public class InstAcademicaDAO {

    /** LISTAR (SP: InstAcademica_Listar) **/
    public Vector<InstAcademica> listaInstAcademica(String busqueda) {

        Vector<InstAcademica> lista = new Vector<>();
        DbBean db = new DbBean();

        try {
            Connection cn = db.getConnection();
            CallableStatement cst = cn.prepareCall("{call InstAcademica_Listar(?)}");

            if (busqueda == null || busqueda.trim().isEmpty()) {
                cst.setString(1, "");
            } else {
                cst.setString(1, busqueda);
            }

            ResultSet rs = cst.executeQuery();

            while (rs.next()) {
                InstAcademica inst = new InstAcademica();

                inst.setId_institucion(rs.getInt("InstitucionID"));
                inst.setNombre_institucion(rs.getString("NombInstitucio"));
                inst.setTipo(rs.getString("TipoInst"));
                inst.setWeb(rs.getString("Web"));
                inst.setContacto(rs.getString("Contacto"));
                inst.setTelefono(rs.getString("Tlf"));
                inst.setEstado(rs.getInt("Estado"));

                lista.add(inst);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { db.desconecta(); } catch (Exception ex) {}
        }

        return lista;
    }

    /** INSERTAR (SP: InstAcademica_Insertar) **/
    public int insertaInstAcademica(InstAcademica inst) {

        DbBean db = new DbBean();
        int resultado = 0;

        try {
            Connection cn = db.getConnection();

            CallableStatement cst = cn.prepareCall("{call InstAcademica_Insertar(?,?,?,?,?,?,?)}");
            cst.setInt(1, inst.getId_institucion());
            cst.setString(2, inst.getNombre_institucion());
            cst.setString(3, inst.getTipo());
            cst.setString(4, inst.getWeb());
            cst.setString(5, inst.getContacto());
            cst.setString(6, inst.getTelefono());
            cst.setInt(7, inst.getEstado());

            cst.execute();
            resultado = 1;

        } catch (Exception e) {
            e.printStackTrace();
            resultado = 0;

        } finally {
            try { db.desconecta(); } catch (Exception e) {}
        }

        return resultado;
    }

    /** ACTUALIZAR (SP: InstAcademica_Actualizar) **/
    public int actualizaInstAcademica(InstAcademica inst) {

        DbBean db = new DbBean();
        int resultado = 0;

        try {
            Connection cn = db.getConnection();

            CallableStatement cst = cn.prepareCall("{call InstAcademica_Actualizar(?,?,?,?,?,?,?)}");
            cst.setInt(1, inst.getId_institucion());
            cst.setString(2, inst.getNombre_institucion());
            cst.setString(3, inst.getTipo());
            cst.setString(4, inst.getWeb());
            cst.setString(5, inst.getContacto());
            cst.setString(6, inst.getTelefono());
            cst.setInt(7, inst.getEstado());

            cst.execute();
            resultado = 1;

        } catch (Exception e) {
            e.printStackTrace();
            resultado = 0;

        } finally {
            try { db.desconecta(); } catch (Exception ex) {}
        }

        return resultado;
    }

    /** ELIMINAR (SP: InstAcademica_Eliminar) **/
    public int eliminaInstAcademica(int idInst) {

        DbBean db = new DbBean();
        int resultado = 0;

        try {
            Connection cn = db.getConnection();
            CallableStatement cst = cn.prepareCall("{call InstAcademica_Eliminar(?)}");
            cst.setInt(1, idInst);

            resultado = cst.executeUpdate();  // se espera 1 si elimina

        } catch (Exception e) {
            e.printStackTrace();
            resultado = 0;

        } finally {
            try { db.desconecta(); } catch (Exception e) {}
        }

        return resultado;
    }
}