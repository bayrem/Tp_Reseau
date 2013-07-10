package tp1client;

import java.net.*;
import java.io.*;

public class ClientSimple {
    public static void main(String[] argv) throws Exception {
        String phraseClavier;
        String phraseRecue;

   //Créer le flux d'entrée
        BufferedReader entreeClavier = new BufferedReader(new InputStreamReader(System.in));

  //Créer le socket client et le connecter au serveur
        Socket socketClient = new Socket("127.0.0.1",14404);

  //Créer le flux sortie attché au socket
        OutputStream Sortie = socketClient.getOutputStream();
        PrintWriter versServeur = new PrintWriter(Sortie,true);

  //Envoyer la phrase entée par l'utilisateur
        phraseClavier = entreeClavier.readLine();
        versServeur.println(phraseClavier);

  //Créer le flux d'entrée attaché au socket
        InputStream Entree = socketClient.getInputStream();
        InputStreamReader reader = new InputStreamReader(Entree);
        BufferedReader depuisServeur = new BufferedReader(reader);

  //Lire la phrase recue
        phraseRecue = depuisServeur.readLine();

  //Afficher le message reçue
        System.out.println("<client> Message reçu du serveur :" + phraseRecue);
        entreeClavier.close();
        depuisServeur.close();
        versServeur.close();
        socketClient.close();
    }
}