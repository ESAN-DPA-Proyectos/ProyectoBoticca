package DAO;

import BEAN.Categoria;
import BEAN.Medicamento;
import BEAN.Proveedor;
import UTIL.DbBean;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

public class MedicamentoDAO {

   // LISTAR CON SP
    public Vector<Medicamento> listarMedicamentos(String cad) {
        DbBean db = new DbBean();
        Vector<Medicamento> lista = new Vector<>();

        try {
            Connection cn = db.getConnection();
            CallableStatement cst = cn.prepareCall("{call Medicamento_Listar(?)}");
            cst.setString(1, cad);

            ResultSet rs = cst.executeQuery();

            while (rs.next()) {
                Medicamento m = new Medicamento();

                m.setId_medicamento(rs.getInt("MedicamentoID"));

                // --- Categoría ---
                Categoria cat = new Categoria();
                cat.setId_categoria(rs.getInt("CategoriaID"));
                cat.setDescripcion(rs.getString("NombreCategoria"));
                m.setCategoria(cat);

                // IMPORTANTE: Guardar también el ID
                m.setId_categoria(cat.getId_categoria());

                // --- Proveedor ---
                Proveedor p = new Proveedor();
                p.setId_proveedor(rs.getInt("ProveedorID"));
                p.setNombre(rs.getString("NombreProveedor"));
                m.setProveedor(p);

                // IMPORTANTE: Guardar también el ID
                m.setId_proveedor(p.getId_proveedor());

                // --- Otros campos ---
                m.setNombre(rs.getString("Nombre"));
                m.setDescripcion(rs.getString("Descripcion"));
                m.setPrecio(rs.getFloat("Precio"));
                m.setStock(rs.getInt("Stock"));
                m.setFecha_vencimiento(rs.getString("FechaExpiracion"));

                lista.add(m);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { db.desconecta(); } catch (Exception e) {}
        }

        return lista;
    }

    // INSERTAR
    public int insertarMedicamento(Medicamento m) {
        DbBean db = new DbBean();
        int r = 0;

        try {
            Connection cn = db.getConnection();
            CallableStatement cst = cn.prepareCall("{call Medicamento_Insertar(?,?,?,?,?,?,?,?)}");

            cst.setInt(1, m.getId_medicamento());
            cst.setInt(2, m.getId_categoria());
            cst.setInt(3, m.getId_proveedor());
            cst.setString(4, m.getNombre());
            cst.setString(5, m.getDescripcion());
            cst.setBigDecimal(6, new BigDecimal(m.getPrecio()));
            cst.setInt(7, m.getStock());
            cst.setDate(8, java.sql.Date.valueOf(m.getFecha_vencimiento()));

            // Igual que EmpresaDAO:
            cst.executeUpdate();
            r = 1; // éxito

        } catch (Exception e) {
            e.printStackTrace();
            r = 0; // error
        } finally {
            try { db.desconecta(); } catch (Exception ex) {}
        }

        return r;
    }

    // ACTUALIZAR
    public int actualizarMedicamento(Medicamento m) {
        DbBean db = new DbBean();
        int r = 0;

        try {
            Connection cn = db.getConnection();
            CallableStatement cst = cn.prepareCall("{call Medicamento_Actualizar(?,?,?,?,?,?,?,?)}");

            // Parámetros en el mismo orden del SP
            cst.setInt(1, m.getId_medicamento());
            cst.setInt(2, m.getId_categoria());
            cst.setInt(3, m.getId_proveedor());
            cst.setString(4, m.getNombre());
            cst.setString(5, m.getDescripcion());
            cst.setBigDecimal(6, new BigDecimal(m.getPrecio())); // DECIMAL
            cst.setInt(7, m.getStock());
            cst.setDate(8, java.sql.Date.valueOf(m.getFecha_vencimiento())); // DATE

            cst.executeUpdate();  

            // Igual que EmpresaDAO
            r = 1;

        } catch (Exception e) {
            System.err.println("ERROR EN ACTUALIZAR MEDICAMENTO:");
            e.printStackTrace();
            r = 0;
        } finally {
            try { db.desconecta(); } catch (Exception e) {}
        }
        return r;
    }


    // ELIMINAR
    public int eliminarMedicamento(int id) {
    DbBean db = new DbBean();
    int r = 0;

    try {
        Connection cn = db.getConnection();
        CallableStatement cst = cn.prepareCall("{call Medicamento_Eliminar(?)}");

        cst.setInt(1, id);

        cst.executeUpdate();  // No usamos el valor retornado

        r = 1; // ÉXITO según patrón

    } catch (Exception e) {
        System.err.println("ERROR EN ELIMINAR MEDICAMENTO:");
        e.printStackTrace();
        r = 0; // ERROR
    } finally {
        try { db.desconecta(); } catch (Exception e) {}
    }

    return r;
}

}
