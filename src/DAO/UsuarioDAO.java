package DAO;

import BEAN.Usuario;
import UTIL.DbBean;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public class UsuarioDAO {

    public Usuario validarLogin(String user, String pass) {
        DbBean db = new DbBean();
        Connection cn = null;
        CallableStatement cst = null;
        ResultSet rs = null;
        Usuario u = null;

        try {
            cn = db.getConnection();
            // Llamamos al SP Usuario_Login(@Usuario, @Password)
            cst = cn.prepareCall("{call Usuario_Login(?, ?)}");
            cst.setString(1, user);
            cst.setString(2, pass);

            rs = cst.executeQuery();

            if (rs.next()) {
                u = new Usuario();
                u.setUsuarioId(rs.getInt("UsuarioID"));
                u.setEmpleadoId(rs.getInt("EmpleadoID"));
                u.setUsuario(rs.getString("Usuario"));
                u.setNombre(rs.getString("Nombre"));
                u.setApellido(rs.getString("Apellido"));
                u.setCargo(rs.getString("Cargo"));
                try {
                    u.setEstado(rs.getInt("Estado"));
                } catch (Exception e) {
                    // por si Estado viene null o no se mapea
                    u.setEstado(1);
                }
                // Si quieres guardar el password en memoria (no es obligatorio):
                u.setPassword(pass);
            }

        } catch (Exception e) {
            System.err.println("ERROR EN UsuarioDAO.validarLogin");
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception ex) {}
            try { if (cst != null) cst.close(); } catch (Exception ex) {}
            try { db.desconecta(); } catch (Exception ex) {}
        }

        return u;  // si es null, login inválido
    }
}
