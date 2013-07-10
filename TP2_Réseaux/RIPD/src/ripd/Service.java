
package ripd;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Service extends Thread{
      Thread travail;
      ArrayList <Routage>  table_routage=new ArrayList();
      int port;

       public Service(int port,ArrayList <Routage>  table_routage)throws IOException, ClassNotFoundException
    {
        this.port = port;
        this.table_routage=table_routage;

       if (table_routage.size() < 5)
       {
        travail=new Thread(this);
        travail.start();
       }
    }


    @Override
         public void run() {
        try {
            Thread.sleep(4000);
             Socket socketClient = new Socket("127.0.0.1",port);

        //crأ©er le flux de sortie attachأ© au socket

       OutputStream s=socketClient.getOutputStream();
       PrintWriter versServeur = new PrintWriter(s,true);
       ObjectOutputStream ss=new ObjectOutputStream(s);
       ss.writeObject(table_routage);
       versServeur.println(table_routage);
        ss.close();
       socketClient.close();

        } catch (InterruptedException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
