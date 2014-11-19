package connection;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;


/**
 *
 * @author bp12214
 */
public class ConexaoDB {

    public static Connection getConnection() throws Exception {
        
   
        Driver d = (Driver)Class.forName ("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();  
        Connection connection = DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};"
      + "DBQ=D:/talk.mdb");
        
        return connection;
    }
}