package dbmessenger;

import entity.E_Message;
import java.util.ArrayList;
import sql.SQL_Insert;
import sql.SQL_Select;

/**
 *
 * @author Hudson Schumaker
 */
public class Core implements Runnable {

    private Fr_Main main;
    private boolean running;
    private Thread t;

    public Core(Fr_Main main) {
        this.main = main;
    }

    public void getMessage() {
        ArrayList<E_Message> sms = new ArrayList<E_Message>();

        sms = SQL_Select.getMessage(main.user);

        for (int k = 0; k < sms.size(); k++) {
            main.ta_chat.append("\n");
            main.ta_chat.append(sms.get(k).getFrom() + ": " + sms.get(k).getMessage());
        }
    }

    public void sendMessage(String to, String sms) {
        SQL_Insert.insertMessage(main.user, to, sms);
    }

    public void getContacts() {
        ArrayList<String> contacts = SQL_Select.getContactList();
        for(int k=0;k<contacts.size();k++){
            Fr_Main.list_contatos.addElement(contacts.get(k));
        }
    }

    @Override
    public void run() {
        
        while (running) {
            try {
                getMessage();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }

    public void start() {
        t = new Thread(this);
        t.start();
        running = true;
    }

    public void stop() {
        running = false;
        t = null;
    }
}