package javaapplication1;



import java.net.*;
import java.io.*;


public class ServeurSimple {

public static void main(String[] argv) throws Exception {
    String phraseMinuscule;
    String phraseMajuscule;

    // Créer un socket d'écoute sur le port 14404
    ServerSocket socketBienvenue = new ServerSocket(14404);
    System.out.println("Port" +socketBienvenue.getLocalPort()+"à l'écoute...");

    while(true) {
        //Attendre la connexion d'un client
        Socket socketConnexion= socketBienvenue.accept();
        //Créer le flux d'entrée attaché au socket
        InputStream Entree=socketConnexion.getInputStream();
        InputStreamReader reader = new InputStreamReader(Entree);
        BufferedReader istream=new BufferedReader(reader);
        //Lire la chaine de caractére depuis le socket
        phraseMinuscule=istream.readLine();
        System.out.println("la chaine recue est:" + phraseMinuscule);
        //Créer le flux de sortie attaché au socket
        OutputStream Sortie=socketConnexion.getOutputStream();
        PrintWriter ostream=new PrintWriter(Sortie,true);
        phraseMajuscule=phraseMinuscule.toUpperCase();
        //Ecrire au client
        ostream.println(phraseMajuscule);
        } //Reapartir et attendre une nouvelle connexion
}
}


