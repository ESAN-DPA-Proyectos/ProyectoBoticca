package DAO;

import BEAN.Categoria;
import UTIL.DbBean;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

/**
 * DAO de Categoria basado SOLO en Stored Procedures
 */
public class CategoriaDAO {

    // LISTAR
    public Vector<Categoria> listaCategorias(String cad) {
        Vector<Categoria> listaCat = new Vector<>();
        DbBean db = new DbBean();

        try {
            Connection cn = db.getConnection();
            CallableStatement cst = cn.prepareCall("{call Categoria_Listar(?)}");
            cst.setString(1, cad);
            ResultSet rs = cst.executeQuery();

            while (rs.next()) {
                Categoria cat = new Categoria();
                cat.setId_categoria(rs.getInt("CategoriaID"));
                cat.setDescripcion(rs.getString("DescCategoria"));
                cat.setObs(rs.getString("Obs"));
                listaCat.add(cat);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { db.desconecta(); } catch (Exception e) {}
        }

        return listaCat;
    }

    // INSERTAR
    public void insertaCategorias(Categoria cat) {
        DbBean db = new DbBean();

        try {
            Connection cn = db.getConnection();
            CallableStatement cst = cn.prepareCall("{call Categoria_Insertar(?,?,?)}");
            cst.setInt(1, cat.getId_categoria());
            cst.setString(2, cat.getDescripcion());
            cst.setString(3, cat.getObs());

            cst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { db.desconecta(); } catch (Exception e) {}
        }
    }

    // ACTUALIZAR
    public void actualizaCategorias(Categoria cat) {
        DbBean db = new DbBean();

        try {
            Connection cn = db.getConnection();
            CallableStatement cst = cn.prepareCall("{call Categoria_Actualizar(?,?,?)}");
            cst.setInt(1, cat.getId_categoria());
            cst.setString(2, cat.getDescripcion());
            cst.setString(3, cat.getObs());

            cst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { db.desconecta(); } catch (Exception e) {}
        }
    }

    // ELIMINAR
    public boolean eliminaCategorias(int idCat) {
        boolean sw = false;
        DbBean db = new DbBean();

        try {
            Connection cn = db.getConnection();
            CallableStatement cst = cn.prepareCall("{call Categoria_Eliminar(?)}");
            cst.setInt(1, idCat);

            int filas = cst.executeUpdate();
            if (filas > 0) sw = true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { db.desconecta(); } catch (Exception e) {}
        }

        return sw;
    }
}
