package sql;

import entity.E_Message;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Hudson Schumaker
 */
public class SQL_Select {

    public static ArrayList<String> getContactList() {

        ArrayList<String> contatos = new ArrayList<String>();
        String sql = "select * from tb_user";
        try {
            Connection con = connection.ConexaoDB.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                contatos.add(rs.getString("nome"));
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return contatos;
    }

    public static ArrayList<E_Message> getMessage(String to) {
        ArrayList<E_Message> messages = new ArrayList<E_Message>();
        String sql = "Select * from tb_sms where status = 0 AND to = '" + to + "'";
        try {
            Connection con = connection.ConexaoDB.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                E_Message aux = new E_Message();
                aux.setId(rs.getInt("id"));
                aux.setFrom(rs.getString("from"));
                aux.setMessage(rs.getString("sms"));
                messages.add(aux);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return messages;
    }
}