package DAO;

import BEAN.Contrato;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class ContratoDAO {
        public Vector<Contrato> listaItem(boolean sw, String str){
        Vector<Contrato> item = new Vector<Contrato>();
        DbBean con = new DbBean();
        String sql = "select a.ContratoID,concat(b.Apellido,' ',b.Nombre),a.Fech_Ini,a.Fech_Fin,c.descArea,d.descRol,d.sueldo,b.empleadoid,c.areaid,d.rolid,a.estado "
                + "from  contrato a "
                + "left join empleados b "
                + "on a.EmpleadoID=b.EmpleadoID "
                + "left join area c "
                + "on a.AreaID=c.AreaID "
                + "left join rol d "
                + "on a.RolID=d.RolID";
        if(sw == true){
            sql = sql + " WHERE b.Apellido like '%"+ str +"%' or b.Nombre= '%"+ str+"'";
        }
        System.out.println(sql);
        try{
            ResultSet resultado = con.resultadoSQL(sql);

            while(resultado.next()){
                Contrato detVenta = new Contrato();
                detVenta.setId_contrato(resultado.getInt(1));
                detVenta.setEmpleado(resultado.getString(2));
                detVenta.setFecini(resultado.getString(3));
                detVenta.setFecfin(resultado.getString(4));
                detVenta.setArea(resultado.getString(5));
                detVenta.setRol(resultado.getString(6));
                detVenta.setSueldo(resultado.getFloat(7));
                detVenta.setId_empleado(resultado.getInt(8));
                detVenta.setId_area(resultado.getInt(9));
                detVenta.setId_rol(resultado.getInt(10));
                detVenta.setEstado(resultado.getInt(1));
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
       sql="delete from contrato  WHERE contratoid = "+ idVe +"";
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
    
    
    public int procesaItem(Contrato ct, String proc){
       int resultado=0;
       String sql= "";
       DbBean con=new DbBean();
       System.out.println("test de proceso");
       if(proc.equals("insert")){
            sql="INSERT INTO contrato VALUES ("+ ct.getId_contrato() +", "
                    + ct.getId_empleado() +", '"+ ct.getFecini()+"', '"
                    + ct.getFecfin()+"', "+ ct.getId_area() +", "+ ct.getId_rol() +", "
                    + ct.getSueldo() +", "+ ct.getEstado() +")";
            System.out.println("EVallll: "+sql);
       }
       if(proc.equals("update")){
            sql="UPDATE contrato set Fech_ini  = '"+ ct.getFecini() +"',"
                    + " Fech_fin = '"+ ct.getFecfin() +"', areaID = "+ ct.getId_area() +","
                    + " sueldo = '"+ ct.getSueldo() +"', estado = "+ ct.getEstado() +""
                    + " where contratoid = "+ ct.getId_contrato();
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
