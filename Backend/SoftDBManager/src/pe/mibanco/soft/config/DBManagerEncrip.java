
package pe.mibanco.soft.config;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import static pe.mibanco.soft.util.Cifrado.descifrarMD5;

/*
 * Author: mellcr
 */

public class DBManagerEncrip {
    private static final String ARCHIVO_CONFIGURACION = "jdbc.properties";
    
    private Connection conexion;
    
//    private String driver;
//    private String tipo_de_driver;
//    private String base_de_datos;
//    private String nombre_de_host;
//    private String puerto;
//    private String usuario;
//    private String contraseña;
    
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String tipo_de_driver="jdbc:mysql";
    private String base_de_datos="mibanco?useSSL=false";
    private String nombre_de_host="mibanco-reto.cmfcheyej0pq.us-east-1.rds.amazonaws.com";
    private String puerto="3306";
    private String usuario="admin";
    private String contraseña="ocwAoyHFoR1RTiwZKQ5tTg==";
    private static DBManagerEncrip dbManager = null;
    
    private DBManagerEncrip(){}; //constructor privado para que no se pueda instanciar
    
    public static DBManagerEncrip getInstance(){
        if (DBManagerEncrip.dbManager == null)
            createInstance(); // crea la instancia si es que aun no existe
        return DBManagerEncrip.dbManager;
    }
    
    private static void createInstance(){
        if (DBManagerEncrip.dbManager == null)
            DBManagerEncrip.dbManager = new DBManagerEncrip();
    }
    
    public Connection getConnection(){        
        try {
            //leer_archivo_de_propiedades();
            Class.forName(this.driver);
            this.conexion = DriverManager.getConnection(getURL(), this.usuario, descifrarMD5(this.contraseña));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBManagerEncrip.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {        
            Logger.getLogger(DBManagerEncrip.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.conexion;
    }
    
    private String getURL(){
        String url = this.tipo_de_driver.concat("://");
        url = url.concat(this.nombre_de_host);
        url = url.concat(":");
        url = url.concat(this.puerto);
        url = url.concat("/");
        url = url.concat(this.base_de_datos);
        System.out.println(url);
        return url;
    }
    
    private void leer_archivo_de_propiedades(){
        Properties properties = new Properties();
        String nmArchivoConf = "../resources/" + ARCHIVO_CONFIGURACION;
        try {
            properties.load(new FileInputStream(new File(nmArchivoConf)));
            this.driver = properties.getProperty("driver");
            this.tipo_de_driver = properties.getProperty("tipo_de_driver");
            this.base_de_datos = properties.getProperty("base_de_datos");
            this.nombre_de_host = properties.getProperty("nombre_de_host");
            this.puerto = properties.getProperty("puerto");
            this.usuario = properties.getProperty("usuario");
            this.contraseña = properties.getProperty("contrasenha");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DBManagerEncrip.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DBManagerEncrip.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }

}
