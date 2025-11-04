
package DAO;

import BEAN.Medicamento;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.util.Vector;

public class MedicamentoDAO {
    public Vector<Medicamento> listaMedicamentos(String cad){
        DbBean db=new DbBean();
               
        Vector<Medicamento> listaMed = new Vector<Medicamento>();
        
        String sql;
        sql= "select * from medicamentos ";
        if(!cad.isEmpty()){ //con este if se agrega el where en el query sql
            sql=sql+" where nombre like '%"+ cad +"%'";
        }
        try{
            ResultSet rstMedicamentos = db.resultadoSQL(sql);
            while(rstMedicamentos.next()){
                Medicamento med = new Medicamento();
                med.setId_medicamento(rstMedicamentos.getInt(1));
                med.setId_categoria(rstMedicamentos.getInt(2));
                med.setId_proveedor(rstMedicamentos.getInt(3));
                med.setNombre(rstMedicamentos.getString(4));
                med.setDescripcion(rstMedicamentos.getString(5));
                med.setPrecio(rstMedicamentos.getFloat(6));
                med.setStock(rstMedicamentos.getInt(7));
                med.setFecha_vencimiento(rstMedicamentos.getString(8));
                listaMed.addElement(med);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            db.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
                
        return listaMed;
    }
    public void insertaMedicamentos(Medicamento med){
        DbBean db=new DbBean();
        String sql;
        try{
            sql="insert into medicamentos values (";
            sql=sql+" "+ med.getId_medicamento() +", ";
            sql=sql+" "+ med.getId_categoria() +", ";
            sql=sql+" "+ med.getId_proveedor() +", ";
            sql=sql+" '"+ med.getNombre() +"', ";
            sql=sql+" '"+ med.getDescripcion() +"', ";
            sql=sql+" "+ med.getPrecio() +", ";
            sql=sql+" "+ med.getStock() +", ";
            sql=sql+" '"+ med.getFecha_vencimiento() +"') ";
            
            
            System.out.println("\nDPA"+sql);
            
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
    public void actualizaMedicamentos(Medicamento med){
        DbBean db=new DbBean();
        String sql;
        try{
            sql="update medicamentos set ";
            sql=sql+" CategoriaID = "+med.getId_categoria()+", ";
            sql=sql+" ProveedorID = "+med.getId_proveedor()+", ";
            sql=sql+" Nombre = '"+med.getNombre()+"', ";
            sql=sql+" Descripcion = '"+med.getDescripcion()+"', ";
            sql=sql+" Precio = '"+med.getPrecio()+"', ";
            sql=sql+" Stock = '"+med.getStock()+"', ";
            sql=sql+" FechaExpiracion = '"+med.getFecha_vencimiento()+"' ";
            sql=sql+"where MedicamentoID = "+med.getId_medicamento()+"";
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
    public boolean eliminaMedicamentos(int idMed){
        //verificando la no dependencia de la tabla det_venta
        boolean sw = false;
        DbBean db=new DbBean();       
        Vector<Medicamento> listaMed = new Vector<Medicamento>();
        
        String sql;
        sql= "select * from medicamentos where MedicamentoID= "+ idMed +"";

        try{
            ResultSet rstMedicamentos = db.resultadoSQL(sql);

            if (rstMedicamentos.next()){
                sql="delete from medicamentos where MedicamentoID="+idMed+"";
                db.ejecutaSQL(sql);
                sw=true;
            }
        }catch(java.sql.SQLException e){
            
        }
        return sw;
    }
}
