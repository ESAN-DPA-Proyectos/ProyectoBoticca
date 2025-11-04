package DAO;

import BEAN.det_venta;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class det_ventaDAO {
        public Vector<det_venta> listaItem(boolean sw, String str){
        Vector<det_venta> item = new Vector<det_venta>();
        DbBean con = new DbBean();
        String sql = "select a.DetalleVentaID,b.VentaID,c.Nombre,a.Cantidad,a.PrecioUnitario,a.Cantidad*a.PrecioUnitario "
                + "from  detallesventa a "
                + "left join ventas b "
                + "on a.ventaid=b.ventaid "
                + "left join Medicamentos c "
                + "on a.MedicamentoID=c.MedicamentoID";
        if(sw == true){
            sql = sql + " WHERE a.ventaid = '"+ str +"'"; //validar el filtro
        }
        System.out.println(sql);
        try{
            ResultSet resultado = con.resultadoSQL(sql);

            while(resultado.next()){
                det_venta detVenta = new det_venta();
                detVenta.setId_detventa(resultado.getInt(1));
                detVenta.setId_venta(resultado.getInt(2));
                detVenta.setMedicamento(resultado.getString(3));
                detVenta.setCantidad(resultado.getInt(4));
                detVenta.setPreciounit(resultado.getFloat(5));
                detVenta.setPreciototal(resultado.getFloat(6));
                item.addElement(detVenta);
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
       sql="delete from detallesventa  WHERE ventaid = "+ idVe +"";
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
    
    public void borraDetaUnit(int idVe){
       int resultado=0;
       String sql= "";
       DbBean con=new DbBean();
       sql="delete from detallesventa  WHERE detalleventaid = "+ idVe +"";
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
    
    public int procesaItem(det_venta dv, String proc){
       int resultado=0;
       String sql= "";
       DbBean con=new DbBean();
       System.out.println("test de proceso");
       if(proc.equals("insert")){
            sql="INSERT INTO detallesventa VALUES ("+ dv.getId_detventa() +", "
                    + dv.getId_venta() +", "+ dv.getId_medicamento()+", "
                    + dv.getCantidad()+", "+ dv.getPreciounit() +")";
            System.out.println("EVallll: "+sql);
       }
       if(proc.equals("update")){
            sql="UPDATE detallesventa set medicamentoid  = "+ dv.getId_medicamento() +","
                    + " preciounitario = "+ dv.getPreciounit() +", cantidad = "+ dv.getCantidad() +""
                    + " where detalleventaid = "+ dv.getId_detventa();
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
