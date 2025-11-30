package UTIL;
import java.sql.*;
public class DbBean {
    //String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=BDBOTICCA";
    
    String dbURL = "jdbc:sqlserver://server-bd-botica.database.windows.net:1433;"
             + "database=BDBOTICCA;"
             + "encrypt=true;"
             + "trustServerCertificate=false;"
             + "hostNameInCertificate=*.database.windows.net;"
             + "loginTimeout=30;";
    
    
    String dbDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    
    private Connection dbCon;
    //private String login = "sa";
    //private String password = "123456789"; 
    
    //Credemciales para Azure
    private String login = "admin@server-bd-botica";
    private String password = "admin123";
    
    public DbBean() {
        conecta();
    }
    public Connection getConnection() {
        return this.dbCon;
    }
    public boolean conecta(){
        try{
            Class.forName(this.dbDriver);
        }catch(java.lang.ClassNotFoundException e){
            System.out.println("Error al cargar el driver JDBC");
            return false;
        }
        try{
            this.dbCon = DriverManager.getConnection(this.dbURL, this.login, this.password);
            System.out.println("✔ Conectado correctamente a Azure SQL Database");
        }catch(SQLException ex){
            //System.out.println("No hay conexion al servidor");
            System.out.println("No hay conexión a Azure SQL");
            System.out.println("Error: " + ex.getMessage());
            return false;
        }
        return true;
    }
    
    public void desconecta()throws SQLException{
        if (this.dbCon != null) {
            this.dbCon.close();
        }
    }
    
       
    public ResultSet resultadoSQL(String sql)throws SQLException{
        Statement s = this.dbCon.createStatement();
        //ResultSet r = s.executeQuery(sql);
        return s.executeQuery(sql);
        
        /*
        if(r==null){
            return null;
        }else{
            return r;
        }*/
        
    }
    
    
    public int ejecutaSQL(String sql)throws SQLException{
        Statement s = this.dbCon.createStatement();
        return s.executeUpdate(sql);
        /*
        int r = s.executeUpdate(sql);
        if(r == 0){
            return 0;
        }else{
            return r;
        }*/
        
        
    }
}