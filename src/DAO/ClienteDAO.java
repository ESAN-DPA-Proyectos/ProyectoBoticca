package DAO;

import BEAN.Cliente;
import UTIL.DbBean;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

public class ClienteDAO {

    // LISTAR
    public Vector<Cliente> listaClientes(String cad){
        Vector<Cliente> listaClien = new Vector<>();
        DbBean db = new DbBean();

        try {
            Connection cn = db.getConnection();
            CallableStatement cst = cn.prepareCall("{call Cliente_Listar(?)}");
            cst.setString(1, cad);
            ResultSet rs = cst.executeQuery();

            while (rs.next()) {
                Cliente cl = new Cliente();
                cl.setId_cliente(rs.getInt("ClienteID"));
                cl.setNombre(rs.getString("Nombre"));
                cl.setApellido(rs.getString("Apellido"));
                cl.setDireccion(rs.getString("Direccion"));
                cl.setTelefono(rs.getString("Telefono"));
                cl.setDni(rs.getString("DNI"));
                cl.setGenero(rs.getInt("Genero"));
                cl.setEstcivil(rs.getInt("EstCivil"));
                cl.setEstado(rs.getInt("Estado"));

                listaClien.add(cl);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { db.desconecta(); } catch (Exception e) {}
        }

        return listaClien;
    }

    // INSERTAR
    public void insertaClientes(Cliente cl){
        DbBean db = new DbBean();

        try {
            Connection cn = db.getConnection();

            CallableStatement cst = cn.prepareCall("{call Cliente_Insertar(?,?,?,?,?,?,?,?,?)}");

            cst.setInt(1, cl.getId_cliente());
            cst.setString(2, cl.getNombre());
            cst.setString(3, cl.getApellido());
            cst.setString(4, cl.getDireccion());
            cst.setString(5, cl.getTelefono());
            cst.setString(6, cl.getDni());
            cst.setInt(7, cl.getGenero());
            cst.setInt(8, cl.getEstcivil());
            cst.setInt(9, cl.getEstado());

            cst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { db.desconecta(); } catch(Exception e) {}
        }
    }

    // ACTUALIZAR
    public void actualizaClientes(Cliente cl){
        DbBean db = new DbBean();

        try {
            Connection cn = db.getConnection();

            CallableStatement cst = cn.prepareCall("{call Cliente_Actualizar(?,?,?,?,?,?,?,?,?)}");

            cst.setInt(1, cl.getId_cliente());
            cst.setString(2, cl.getNombre());
            cst.setString(3, cl.getApellido());
            cst.setString(4, cl.getDireccion());
            cst.setString(5, cl.getTelefono());
            cst.setString(6, cl.getDni());
            cst.setInt(7, cl.getGenero());
            cst.setInt(8, cl.getEstcivil());
            cst.setInt(9, cl.getEstado());

            cst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { db.desconecta(); } catch (Exception e) {}
        }
    }

    // ELIMINAR
    public boolean eliminaClientes(int idCl){
        boolean sw = false;
        DbBean db = new DbBean();

        try {
            Connection cn = db.getConnection();

            CallableStatement cst = cn.prepareCall("{call Cliente_Eliminar(?)}");
            cst.setInt(1, idCl);

            int rows = cst.executeUpdate();
            if (rows > 0) sw = true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { db.desconecta(); } catch (Exception e) {}
        }

        return sw;
    }
}
