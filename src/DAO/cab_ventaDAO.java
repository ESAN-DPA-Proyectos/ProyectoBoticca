
package DAO;

import BEAN.Sede;
import BEAN.cab_venta;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class cab_ventaDAO {
    public Vector<cab_venta> listaItem(boolean sw, String str){
        Vector<cab_venta> item = new Vector<cab_venta>();
        DbBean con = new DbBean();
        String sql = "Select a.ventaid,CONCAT(c.Apellido,' ',c.Nombre),a.FechaVenta,b.NombSede,a.Estado "
                + "from ventas a "
                + "left join sede b on a.SedeId=b.SedeID "
                + "left join Empleados c "
                + "on a.EmpleadoID=c.EmpleadoID";
        if(sw == true){
            sql = sql + " WHERE a.clienteid = '"+ str +"'";
        }
        System.out.println(sql);
        try{
            ResultSet resultado = con.resultadoSQL(sql);

            while(resultado.next()){
                cab_venta cabVenta = new cab_venta();
                cabVenta.setId_venta(resultado.getInt(1));
                cabVenta.setEmpleado(resultado.getString(2));
                cabVenta.setFecha(resultado.getString(3));
                cabVenta.setSede(resultado.getString(4));
                cabVenta.setEstado(resultado.getInt(5));
                item.addElement(cabVenta);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(SQLException e){}
        return item;
    }
    
    public void borraCab(int idVe){
       int resultado=0;
       String sql= "";
       DbBean con=new DbBean();
       sql="delete from ventas WHERE ventaid = "+ idVe +"";
       System.out.println("Del cv "+sql);
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
    
    public int procesaItem(cab_venta cv, String proc){
       int resultado=0;
       String sql= "";
       DbBean con=new DbBean();
       if(proc.equals("insert")){
            sql="INSERT INTO ventas VALUES ('"+ cv.getId_venta() +"', '"+ cv.getId_cliente() +"', '"+ cv.getId_empleado() +"', '"+ cv.getFecha() +"', '"+ cv.getId_sede() +"' ,'"+ cv.getEstado() +"')";
            System.out.println("uuuuuuu" + sql);
       }
       if(proc.equals("update")){
            sql="UPDATE ventas set fechaventa = '"+ cv.getFecha() +"', empleadoid = '"+ cv.getId_empleado() +"', estado = '"+ cv.getEstado() +"', sedeid = '"+ cv.getId_sede() +"' where ventaid = '"+ cv.getId_venta() +"'";
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
