package DAO;

import BEAN.Sede;
import UTIL.DbBean;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

public class SedeDAO {

    // LISTAR (usa SP Sede_Listar)
    public Vector<Sede> listarSede(String cad) {
        DbBean db = new DbBean();
        Vector<Sede> lista = new Vector<>();

        try {
            Connection cn = db.getConnection();
            CallableStatement cst = cn.prepareCall("{call Sede_Listar(?)}");
            cst.setString(1, cad);  // puede ser vacío o nombre a buscar

            ResultSet rs = cst.executeQuery();

            while (rs.next()) {
                Sede s = new Sede();
                s.setId_sede(rs.getInt("SedeID"));
                s.setId_ubigeo(rs.getInt("UbigeoId"));
                s.setNombre(rs.getString("NombSede"));
                s.setDireccion(rs.getString("Direccion"));
                s.setTelefono(rs.getString("Tlf"));
                lista.add(s);
            }

        } catch (Exception e) {
            System.err.println("ERROR EN LISTAR SEDES:");
            e.printStackTrace();
        } finally {
            try { db.desconecta(); } catch (Exception e) {}
        }

        return lista;
    }

    // INSERTAR (usa SP Sede_Insertar)
    public int insertarSede(Sede sede) {
        DbBean db = new DbBean();
        int r = 0;

        try {
            Connection cn = db.getConnection();
            CallableStatement cst = cn.prepareCall("{call Sede_Insertar(?,?,?,?,?)}");

            cst.setInt(1, sede.getId_sede());
            cst.setInt(2, sede.getId_ubigeo());
            cst.setString(3, sede.getNombre());
            cst.setString(4, sede.getDireccion());
            cst.setString(5, sede.getTelefono());

            cst.executeUpdate();
            r = 1;   // Éxito

        } catch (Exception e) {
            System.err.println("ERROR EN INSERTAR SEDE:");
            e.printStackTrace();
            r = 0;
        } finally {
            try { db.desconecta(); } catch (Exception e) {}
        }

        return r;
    }

    // ACTUALIZAR (usa SP Sede_Actualizar)
    public int actualizarSede(Sede sede) {
        DbBean db = new DbBean();
        int r = 0;

        try {
            Connection cn = db.getConnection();
            CallableStatement cst = cn.prepareCall("{call Sede_Actualizar(?,?,?,?,?)}");

            cst.setInt(1, sede.getId_sede());
            cst.setInt(2, sede.getId_ubigeo());
            cst.setString(3, sede.getNombre());
            cst.setString(4, sede.getDireccion());
            cst.setString(5, sede.getTelefono());

            cst.executeUpdate();
            r = 1;

        } catch (Exception e) {
            System.err.println("ERROR EN ACTUALIZAR SEDE:");
            e.printStackTrace();
            r = 0;
        } finally {
            try { db.desconecta(); } catch (Exception e) {}
        }

        return r;
    }

    // ELIMINAR (usa SP Sede_Eliminar)
    public int eliminarSede(int idSede) {
        DbBean db = new DbBean();
        int r = 0;

        try {
            Connection cn = db.getConnection();
            CallableStatement cst = cn.prepareCall("{call Sede_Eliminar(?)}");
            cst.setInt(1, idSede);

            cst.executeUpdate();
            r = 1;

        } catch (Exception e) {
            System.err.println("ERROR EN ELIMINAR SEDE:");
            e.printStackTrace();
            r = 0;
        } finally {
            try { db.desconecta(); } catch (Exception e) {}
        }

        return r;
    }
}
