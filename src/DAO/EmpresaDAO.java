package DAO;

import BEAN.Empresa;
import UTIL.DbBean;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

public class EmpresaDAO {

    /* =======================
         LISTAR
       ======================= */
    public Vector<Empresa> listaEmpresas(String cad) {
        Vector<Empresa> lista = new Vector<>();
        DbBean db = new DbBean();

        try {
            Connection cn = db.getConnection();
            CallableStatement cst = cn.prepareCall("{call Empresa_Listar(?)}");

            if (cad == null || cad.trim().isEmpty()) {
                cst.setString(1, null);
            } else {
                cst.setString(1, cad);
            }

            ResultSet rs = cst.executeQuery();

            while (rs.next()) {
                Empresa emp = new Empresa();
                emp.setEmpresaId(rs.getInt("EmpresaId"));
                emp.setDescEmpresa(rs.getString("descEmpresa"));
                emp.setRUC(rs.getString("RUC"));
                emp.setContacto(rs.getString("contacto"));
                emp.setTlfConta(rs.getString("tlfConta"));
                emp.setWeb(rs.getString("web"));
                lista.add(emp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { db.desconecta(); } catch (Exception ex) {}
        }
        return lista;
    }

    /* =======================
          INSERTAR
       ======================= */
    public int insertaEmpresas(Empresa emp) {
        DbBean db = new DbBean();
        int r = 0;

        try {
            Connection cn = db.getConnection();
            CallableStatement cst = cn.prepareCall("{call Empresa_Insertar(?,?,?,?,?,?)}");

            cst.setInt(1, emp.getEmpresaId());
            cst.setString(2, emp.getDescEmpresa());
            cst.setString(3, emp.getRUC());
            cst.setString(4, emp.getContacto());
            cst.setString(5, emp.getTlfConta());
            cst.setString(6, emp.getWeb());

            r = cst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            r = 0;
        } finally {
            try { db.desconecta(); } catch (Exception ex) {}
        }

        return r;
    }

    /* =======================
           ACTUALIZAR
       ======================= */
    public int actualizaEmpresas(Empresa emp) {
        DbBean db = new DbBean();
        int r = 0;

        try {
            Connection cn = db.getConnection();
            CallableStatement cst = cn.prepareCall("{call Empresa_Actualizar(?,?,?,?,?,?)}");

            cst.setInt(1, emp.getEmpresaId());
            cst.setString(2, emp.getDescEmpresa());
            cst.setString(3, emp.getRUC());
            cst.setString(4, emp.getContacto());
            cst.setString(5, emp.getTlfConta());
            cst.setString(6, emp.getWeb());

            r = cst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            r = 0;
        } finally {
            try { db.desconecta(); } catch (Exception ex) {}
        }

        return r;
    }

    /* =======================
            ELIMINAR
       ======================= */
    public int eliminaEmpresas(int idEmp) {
        DbBean db = new DbBean();
        int r = 0;   // 0 = no eliminado / error, 1 = eliminado OK

        try {
            Connection cn = db.getConnection();
            CallableStatement cst = cn.prepareCall("{call Empresa_Eliminar(?)}");
            cst.setInt(1, idEmp);

            // Por SET NOCOUNT ON, executeUpdate() puede devolver 0,
            // así que si NO lanza excepción, asumimos éxito.
            cst.executeUpdate();
            r = 1;

        } catch (Exception e) {
            e.printStackTrace();
            r = 0;
        } finally {
            try { db.desconecta(); } catch (Exception e) {}
        }

        return r;
    }
}
