package tp3;

import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class SocketRecep {

 public static void recevoir(int port) throws Exception{

    ArrayList r =new ArrayList();
    int i=1;
    // Créer un socket d'écoute sur le port 14405
        ServerSocket socketBienvenue = new ServerSocket(port);
        System.out.println("> SERVER :Port n°" + socketBienvenue.getLocalPort() + "du serveur A est à l'écoute...");

  
    }
}
