
package DAO;


import BEAN.cab_compra;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class cab_compraDAO {
    public Vector<cab_compra> listaItem(boolean sw, String str){
        Vector<cab_compra> item = new Vector<cab_compra>();
        DbBean con = new DbBean();
        String sql = "select a.CompraID,b.Nombre,concat(c.Apellido,' ',c.Nombre), a.FechaCompra, a.estado "
                + "from compras a "
                + "left join Proveedores b on a.ProveedorID=b.ProveedorID "
                + "left join Empleados c "
                + "on a.EmpleadoID=c.EmpleadoID";
        if(sw == true){
            sql = sql + " WHERE a.proveedorid = '"+ str +"'";
        }
        System.out.println(sql);
        try{
            ResultSet resultado = con.resultadoSQL(sql);

            while(resultado.next()){
                cab_compra cabCompra = new cab_compra();
                cabCompra.setId_compra(resultado.getInt(1));
                cabCompra.setProveedor(resultado.getString(2));
                cabCompra.setEmpleado(resultado.getString(3));
                cabCompra.setFecha(resultado.getString(4));
                cabCompra.setEstado(resultado.getInt(5));
                item.addElement(cabCompra);
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
       sql="delete from compras WHERE compraid = "+ idVe +"";
       System.out.println("Del cc "+sql);
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
    
    public int procesaItem(cab_compra cc, String proc){
       int resultado=0;
       String sql= "";
       DbBean con=new DbBean();
       if(proc.equals("insert")){
            sql="INSERT INTO compras VALUES ('"+ cc.getId_compra() +"', '"+ cc.getId_proveedor() +"', '"+ cc.getId_empleado() +"', '"+ cc.getFecha() +"' ,'"+ cc.getEstado() +"')";
            System.out.println("uuuuuuu" + sql);
       }
       if(proc.equals("update")){
            sql="UPDATE compras set fechacompra = '"+ cc.getFecha() +"', empleadoid = '"+ cc.getId_empleado() +"', estado = '"+ cc.getEstado() +"', proveedorid = '"+ cc.getId_proveedor() +"' where compraid = '"+ cc.getId_compra() +"'";
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
