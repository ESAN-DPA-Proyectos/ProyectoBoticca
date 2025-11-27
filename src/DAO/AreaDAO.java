package DAO;

import BEAN.Area;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.util.Vector;

public class AreaDAO {

    // LISTAR (usa Area_Listar)
    public Vector<Area> listaArea(String cad){
        DbBean db = new DbBean();
        Vector<Area> listaArea = new Vector<Area>();

        // armamos la llamada al SP
        String sql;
        if (cad == null || cad.trim().isEmpty()) {
            sql = "EXEC Area_Listar NULL";   // trae todo
        } else {
            // por seguridad duplicamos comillas simples
            String filtro = cad.replace("'", "''");
            sql = "EXEC Area_Listar '" + filtro + "'";
        }

        try{
            ResultSet rstAreas = db.resultadoSQL(sql);
            while(rstAreas.next()){
                Area area = new Area();
                area.setId_area(rstAreas.getInt(1));      // AreaID
                area.setDescripcion(rstAreas.getString(2)); // descArea
                area.setSubArea(rstAreas.getString(3));     // subArea
                area.setCentCosto(rstAreas.getInt(4));      // centCosto
                listaArea.addElement(area);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }

        try{
            db.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }

        return listaArea;
    }

    // INSERTAR (usa Area_Insertar)
    public void insertaAreas(Area area){
        DbBean db = new DbBean();
        String sql;

        try{
            String desc = area.getDescripcion().replace("'", "''");
            String sub  = area.getSubArea().replace("'", "''");

            sql  = "EXEC Area_Insertar ";
            sql += area.getId_area() + ", ";
            sql += "'" + desc + "', ";
            sql += "'" + sub + "', ";
            sql += area.getCentCosto();

            System.out.println("\nDPA (SP) " + sql);

            db.ejecutaSQL(sql);
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }

        try{
            db.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
    }

    // ACTUALIZAR (usa Area_Actualizar)
    public void actualizaAreas(Area area){
        DbBean db = new DbBean();
        String sql;

        try{
            String desc = area.getDescripcion().replace("'", "''");
            String sub  = area.getSubArea().replace("'", "''");

            sql  = "EXEC Area_Actualizar ";
            sql += area.getId_area() + ", ";
            sql += "'" + desc + "', ";
            sql += "'" + sub + "', ";
            sql += area.getCentCosto();

            db.ejecutaSQL(sql);
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }

        try{
            db.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
    }

    // ELIMINAR (primero valida en Contrato, luego llama a Area_Eliminar)
    public boolean eliminaAreas(int idArea){
        boolean sw = false;
        DbBean db = new DbBean();

        try{
            // 1. Verificamos que no existan contratos con ese AreaID
            String sql = "SELECT * FROM Contrato WHERE AreaID = " + idArea;
            ResultSet rstContrato = db.resultadoSQL(sql);

            if (!rstContrato.next()){
                // 2. Si no hay contratos, llamamos al SP de eliminación
                sql = "EXEC Area_Eliminar " + idArea;
                db.ejecutaSQL(sql);
                sw = true;
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }

        try{
            db.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }

        return sw;
    }
}
