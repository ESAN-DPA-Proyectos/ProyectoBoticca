package DAO;

import BEAN.Proveedor;
import UTIL.DbBean;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class ProveedorDAO {

    // INSERTAR
    public int insertarProveedor(Proveedor p) {
        DbBean db = new DbBean();
        int r = 0;

        try {
            Connection cn = db.getConnection();
            CallableStatement cst = cn.prepareCall("{call Proveedor_Insertar(?,?,?,?,?,?,?)}");

            cst.setInt(1, p.getId_proveedor());
            cst.setString(2, p.getNombre());
            cst.setString(3, p.getNombreContacto());
            cst.setString(4, p.getDireccion());
            cst.setString(5, p.getCiudad());
            cst.setString(6, p.getTelefono());
            cst.setInt(7, p.getEstado());

            r = cst.executeUpdate();

        } catch (Exception e) {
            System.err.println("ERROR EN INSERTAR PROVEEDOR:");
            e.printStackTrace();
            r = 0;
        } finally {
            try { db.desconecta(); } catch (Exception e) {}
        }
        return r;
    }

    // ACTUALIZAR
    public int actualizarProveedor(Proveedor p) {
        DbBean db = new DbBean();
        int r = 0;

        try {
            Connection cn = db.getConnection();
            CallableStatement cst = cn.prepareCall("{call Proveedor_Actualizar(?,?,?,?,?,?,?)}");

            cst.setInt(1, p.getId_proveedor());
            cst.setString(2, p.getNombre());
            cst.setString(3, p.getNombreContacto());
            cst.setString(4, p.getDireccion());
            cst.setString(5, p.getCiudad());
            cst.setString(6, p.getTelefono());
            cst.setInt(7, p.getEstado());

            r = cst.executeUpdate();

        } catch (Exception e) {
            System.err.println("ERROR EN ACTUALIZAR PROVEEDOR:");
            e.printStackTrace();
            r = 0;
        } finally {
            try { db.desconecta(); } catch (Exception e) {}
        }
        return r;
    }

    // ELIMINAR
    public int eliminarProveedor(int id) {
        DbBean db = new DbBean();
        int r = 0;

        try {
            Connection cn = db.getConnection();
            CallableStatement cst = cn.prepareCall("{call Proveedor_Eliminar(?)}");
            cst.setInt(1, id);

            // Ejecutamos, pero NO usamos el valor de retorno de executeUpdate
            cst.executeUpdate();

            // Si llegó hasta aquí, consideramos que fue OK
            r = 1;

        } catch (Exception e) {
            System.err.println("ERROR EN ELIMINAR PROVEEDOR:");
            e.printStackTrace();
            r = 0;  // error
        } finally {
            try { db.desconecta(); } catch (Exception e) {}
        }
        return r;
}


    // LISTAR
    public Vector<Proveedor> listarProveedores(String cad) {
        DbBean db = new DbBean();
        Vector<Proveedor> lista = new Vector<>();

        try {
            Connection cn = db.getConnection();
            CallableStatement cst = cn.prepareCall("{call Proveedor_Listar(?)}");
            cst.setString(1, cad);

            ResultSet rs = cst.executeQuery();

            while (rs.next()) {
                Proveedor p = new Proveedor();

                p.setId_proveedor(rs.getInt("ProveedorID"));
                p.setNombre(rs.getString("Nombre"));
                p.setNombreContacto(rs.getString("NombreContacto"));
                p.setDireccion(rs.getString("Direccion"));
                p.setCiudad(rs.getString("Ciudad"));
                p.setTelefono(rs.getString("Telefono"));
                p.setEstado(rs.getInt("Estado"));

                lista.add(p);
            }

        } catch (SQLException e) {
            System.err.println("ERROR EN LISTAR PROVEEDORES:");
            e.printStackTrace();
        } finally {
            try { db.desconecta(); } catch (Exception e) {}
        }

        return lista;
    }
}
