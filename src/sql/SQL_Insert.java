package sql;

import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author Hudson Schuamker
 */
public class SQL_Insert {

    public static void insertMessage(String from, String to, String sms) {
        try {
            Connection con = connection.ConexaoDB.getConnection();
            Statement stmt = con.createStatement();
            
            System.out.println("INSERT INTO tb_sms (status,from,to, sms) VALUES( 0,"
                    + "'" + from + "',"
                    + "'" + to + "',"
                    + "'" + sms + "' )");
            
            stmt.executeUpdate("INSERT INTO tb_sms (status,from,to, sms) VALUES( 0,"
                    + "'" + from + "',"
                    + "'" + to + "',"
                    + "'" + sms + "' )");
            con.commit();
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}