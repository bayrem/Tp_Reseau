package ripd;

import java.net.*;
import java.io.*;

public class SocketEnvoie {

 public static void envoyer(Routage r,int port) throws Exception{

    //creer la socket client et la connecter au serveur
    Socket socketClient = new Socket("127.0.0.1",port);

    //creer le flux de sortie attache au socket
    ObjectOutputStream Sortie = new ObjectOutputStream(socketClient.getOutputStream());

    //envoyer la phrase entree par l'utilisateur
    Sortie.writeObject(r);

   }
}
