package ripd;

import java.net.*;
import java.io.*;

public class SocketRecep {

 public static void recevoir(int port) throws Exception{

    Routage r =new Routage();
    int i=1;
    //crأ©er une socket d'ecoute sur le port indiquأ©
    ServerSocket socketBienvenue = new ServerSocket(port);
    System.out.println("Port" + socketBienvenue.getLocalPort() + "a l'ecoute");

  
    }
}
