package DAO;

import BEAN.det_compra;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class det_compraDAO {
        public Vector<det_compra> listaItem(boolean sw, String str){
        Vector<det_compra> item = new Vector<det_compra>();
        DbBean con = new DbBean();
        String sql = "select a.CompraID,b.Nombre, a.cantidad, b.Precio,a.cantidad*b.Precio,a.medicamentoid "
                + "from DetallesCompra a "
                + "left join Medicamentos b "
                + "on a.MedicamentoID=b.MedicamentoID ";

        if(sw == true){
            sql = sql + " WHERE a.compraid = '"+ str +"'";
        }
        System.out.println(sql);
        try{
            ResultSet resultado = con.resultadoSQL(sql);

            while(resultado.next()){
                det_compra detCompra = new det_compra();
                detCompra.setId_compra(resultado.getInt(1));
                detCompra.setMedicamento(resultado.getString(2));
                detCompra.setCantidad(resultado.getInt(3));
                detCompra.setPreciounit(resultado.getFloat(4));
                detCompra.setPreciototal(resultado.getFloat(5));
                detCompra.setId_medicamento(resultado.getInt(6));
                item.addElement(detCompra);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(SQLException e){}
        System.out.println("checkpoint");
        return item;
       
    }
    
    public void borraDeta(int idVe){
       int resultado=0;
       String sql= "";
       DbBean con=new DbBean();
       sql="delete from detallescompra  WHERE compraid = "+ idVe +"";
       System.out.println("Del dc "+sql);
       try{
          resultado=con.ejecutaSQL(sql);
        }
        catch(java.sql.SQLException e){e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(SQLException e){
        }
        
    }
    
    public void borraDetaUnit(int idVe){
       int resultado=0;
       String sql= "";
       DbBean con=new DbBean();
       sql="delete from detallescompra  WHERE compraid = "+ idVe +"";
       System.out.println("Del dv "+sql);
       try{
          resultado=con.ejecutaSQL(sql);
        }
        catch(java.sql.SQLException e){e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(SQLException e){
        }
        
    }
    
    public int procesaItem(det_compra dc, String proc){
       int resultado=0;
       String sql= "";
       DbBean con=new DbBean();
       System.out.println("test de proceso");
       if(proc.equals("insert")){
            sql="INSERT INTO detallescompra VALUES ("+ dc.getId_compra() +", "
                    + dc.getId_medicamento() +", "+ dc.getCantidad()+", "
                    + dc.getPreciounit() +")";
            System.out.println("EVallll: "+sql);
       }
       if(proc.equals("update")){
            sql="UPDATE detallescompra set medicamentoid  = "+ dc.getId_medicamento() +","
                    + " preciounitario = "+ dc.getPreciounit() +", cantidad = "+ dc.getCantidad() +""
                    + " where compraid = "+ dc.getId_compra();
       }
       System.out.println("Observando el estado de la sentencia sql: "+sql);

       try{
          resultado=con.ejecutaSQL(sql);
        }
        catch(java.sql.SQLException e){e.printStackTrace();
        }
        try{
        con.desconecta();
        }
        catch(SQLException e){
        }
          return resultado;
      } 
    
}
