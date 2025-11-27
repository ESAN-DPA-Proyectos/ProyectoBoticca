package DAO;

import BEAN.Ubigeo;
import UTIL.DbBean;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

public class UbigeoDAO {

    // LISTAR (SP: Ubigeo_Listar)
    public Vector<Ubigeo> listarUbigeo(String cad) {
        DbBean db = new DbBean();
        Vector<Ubigeo> listaUbigeo = new Vector<>();

        try {
            Connection cn = db.getConnection();
            CallableStatement cst = cn.prepareCall("{call Ubigeo_Listar(?)}");
            cst.setString(1, cad); // puede ir vacío o distrito a buscar

            ResultSet rstUbigeos = cst.executeQuery();
            while (rstUbigeos.next()) {
                Ubigeo ubi = new Ubigeo();
                ubi.setId_ubigeo(rstUbigeos.getInt("UbigeoId"));
                ubi.setRegion(rstUbigeos.getString("Region"));
                ubi.setDepartamento(rstUbigeos.getString("Departamento"));
                ubi.setProvincia(rstUbigeos.getString("Provincia"));
                ubi.setDistrito(rstUbigeos.getString("Distrito"));
                listaUbigeo.addElement(ubi);
            }
        } catch (Exception e) {
            System.err.println("ERROR EN LISTAR UBIGEO:");
            e.printStackTrace();
        } finally {
            try { db.desconecta(); } catch (Exception e) {}
        }

        return listaUbigeo;
    }

    // INSERTAR (SP: Ubigeo_Insertar)
    public int insertarUbigeo(Ubigeo ubi) {
        DbBean db = new DbBean();
        int r = 0;

        try {
            Connection cn = db.getConnection();
            CallableStatement cst = cn.prepareCall("{call Ubigeo_Insertar(?,?,?,?,?)}");

            cst.setInt(1, ubi.getId_ubigeo());
            cst.setString(2, ubi.getRegion());
            cst.setString(3, ubi.getDepartamento());
            cst.setString(4, ubi.getProvincia());
            cst.setString(5, ubi.getDistrito());

            cst.executeUpdate();
            r = 1;

        } catch (Exception e) {
            System.err.println("ERROR EN INSERTAR UBIGEO:");
            e.printStackTrace();
            r = 0;
        } finally {
            try { db.desconecta(); } catch (Exception e) {}
        }

        return r;
    }

    // ACTUALIZAR (SP: Ubigeo_Actualizar)
    public int actualizarUbigeo(Ubigeo ubi) {
        DbBean db = new DbBean();
        int r = 0;

        try {
            Connection cn = db.getConnection();
            CallableStatement cst = cn.prepareCall("{call Ubigeo_Actualizar(?,?,?,?,?)}");

            cst.setInt(1, ubi.getId_ubigeo());
            cst.setString(2, ubi.getRegion());
            cst.setString(3, ubi.getDepartamento());
            cst.setString(4, ubi.getProvincia());
            cst.setString(5, ubi.getDistrito());

            cst.executeUpdate();
            r = 1;

        } catch (Exception e) {
            System.err.println("ERROR EN ACTUALIZAR UBIGEO:");
            e.printStackTrace();
            r = 0;
        } finally {
            try { db.desconecta(); } catch (Exception e) {}
        }

        return r;
    }

    // ELIMINAR (SP: Ubigeo_Eliminar)
    public int eliminarUbigeo(int idUbi) {
        DbBean db = new DbBean();
        int r = 0;

        try {
            Connection cn = db.getConnection();
            CallableStatement cst = cn.prepareCall("{call Ubigeo_Eliminar(?)}");
            cst.setInt(1, idUbi);

            cst.executeUpdate();
            r = 1;

        } catch (Exception e) {
            System.err.println("ERROR EN ELIMINAR UBIGEO:");
            e.printStackTrace();
            r = 0;
        } finally {
            try { db.desconecta(); } catch (Exception e) {}
        }

        return r;
    }
}
