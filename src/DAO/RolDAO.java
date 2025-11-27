package DAO;

import BEAN.Rol;
import UTIL.DbBean;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

public class RolDAO {

    // LISTAR (usa SP Rol_Listar)
    public Vector<Rol> listarRoles(String cad) {
        DbBean db = new DbBean();
        Vector<Rol> lista = new Vector<>();

        try {
            Connection cn = db.getConnection();
            CallableStatement cst = cn.prepareCall("{call Rol_Listar(?)}");
            cst.setString(1, cad);  // puede ser vacío o texto a buscar

            ResultSet rs = cst.executeQuery();

            while (rs.next()) {
                Rol r = new Rol();
                r.setId_rol(rs.getInt("RolID"));
                r.setDescripcion(rs.getString("descRol"));
                r.setRequisito(rs.getString("requisito"));
                r.setAniosexp(rs.getInt("anioExpReq"));
                r.setSueldo(rs.getFloat("sueldo"));
                lista.add(r);
            }

        } catch (Exception e) {
            System.err.println("ERROR EN LISTAR ROLES:");
            e.printStackTrace();
        } finally {
            try { db.desconecta(); } catch (Exception e) {}
        }

        return lista;
    }

    // INSERTAR (usa SP Rol_Insertar)
    public int insertarRol(Rol rol) {
        DbBean db = new DbBean();
        int r = 0;

        try {
            Connection cn = db.getConnection();
            CallableStatement cst = cn.prepareCall("{call Rol_Insertar(?,?,?,?,?)}");

            cst.setInt(1, rol.getId_rol());
            cst.setString(2, rol.getDescripcion());
            cst.setString(3, rol.getRequisito());
            cst.setInt(4, rol.getAniosexp());
            cst.setFloat(5, rol.getSueldo());

            cst.executeUpdate();
            r = 1; // éxito

        } catch (Exception e) {
            System.err.println("ERROR EN INSERTAR ROL:");
            e.printStackTrace();
            r = 0;
        } finally {
            try { db.desconecta(); } catch (Exception e) {}
        }

        return r;
    }

    // ACTUALIZAR (usa SP Rol_Actualizar)
    public int actualizarRol(Rol rol) {
        DbBean db = new DbBean();
        int r = 0;

        try {
            Connection cn = db.getConnection();
            CallableStatement cst = cn.prepareCall("{call Rol_Actualizar(?,?,?,?,?)}");

            cst.setInt(1, rol.getId_rol());
            cst.setString(2, rol.getDescripcion());
            cst.setString(3, rol.getRequisito());
            cst.setInt(4, rol.getAniosexp());
            cst.setFloat(5, rol.getSueldo());

            cst.executeUpdate();
            r = 1;

        } catch (Exception e) {
            System.err.println("ERROR EN ACTUALIZAR ROL:");
            e.printStackTrace();
            r = 0;
        } finally {
            try { db.desconecta(); } catch (Exception e) {}
        }

        return r;
    }

    // ELIMINAR (usa SP Rol_Eliminar)
    public int eliminarRol(int idRol) {
        DbBean db = new DbBean();
        int r = 0;

        try {
            Connection cn = db.getConnection();
            CallableStatement cst = cn.prepareCall("{call Rol_Eliminar(?)}");
            cst.setInt(1, idRol);

            cst.executeUpdate();
            r = 1;

        } catch (Exception e) {
            System.err.println("ERROR EN ELIMINAR ROL:");
            e.printStackTrace();
            r = 0;
        } finally {
            try { db.desconecta(); } catch (Exception e) {}
        }

        return r;
    }
}
