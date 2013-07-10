/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3;

import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GW1 {
    ArrayList<TableAdj> tbladj = new ArrayList();
    ArrayList<Routage> tableroutage = new ArrayList();
  static  ArrayList<LSDB> LSDB = new ArrayList();
//La table d'adjascence
        TableAdj a1 = new TableAdj();
        TableAdj a2 = new TableAdj();
        TableAdj a3 = new TableAdj();
        TableAdj a4 = new TableAdj();
//La LSDB
LSDB l1 = new LSDB();
LSDB l2 = new LSDB();
LSDB l3 = new LSDB();
LSDB l4 = new LSDB();
LSDB l5 = new LSDB();
LSDB l6 = new LSDB();
LSDB l7 = new LSDB();
LSDB l8 = new LSDB();
LSDB l9 = new LSDB();
LSDB l10 = new LSDB();
LSDB l11 = new LSDB();
LSDB l12 = new LSDB();
LSDB l13 = new LSDB();
LSDB l14 = new LSDB();
LSDB l15 = new LSDB();
LSDB l16 = new LSDB();
//La table de routage
Routage r1 = new Routage();
Routage r2 = new Routage();
Routage r3 = new Routage();
Routage r4 = new Routage();

        static int p = 111111;
        int i = 2, j = 0;
        Routage route = new Routage();
        static SocketRecep soc ;
        Socket s = new Socket();
        ServerSocket ss = new ServerSocket();

    public GW1() throws Exception {
soc = new SocketRecep();

//La table d'adjascence
//a1
        a1.Setvoisin("N1");
        a1.Setcout(0);
        tbladj.add(a1);
//a2
        a2.Setvoisin("GW2");
        a2.Setcout(7);
        tbladj.add(a2);
//a3
        a3.Setvoisin("GW3");
        a3.Setcout(4);
        tbladj.add(a3);
//a4
        a4.Setvoisin("GW4");
        a4.Setcout(1);
        tbladj.add(a4);
//****************************************************************
// La LSDDB
//l1
        l1.SetGW_source("GW1");
        l1.Setvoisin("N1");
        l1.Setcout(0);
        LSDB.add(l1);
//l2
        l2.SetGW_source("GW1");
        l2.Setvoisin("GW2");
        l2.Setcout(7);
        LSDB.add(l2);
//l3
        l3.SetGW_source("GW1");
        l3.Setvoisin("GW3");
        l3.Setcout(4);
        LSDB.add(l3);
//l4
        l4.SetGW_source("GW1");
        l4.Setvoisin("GW4");
        l4.Setcout(1);
        LSDB.add(l4);
//l5
        l5.SetGW_source("GW2");
        l5.Setvoisin("N2");
        l5.Setcout(0);
        LSDB.add(l5);
//l6
        l6.SetGW_source("GW2");
        l6.Setvoisin("GW1");
        l6.Setcout(7);
        LSDB.add(l6);
//l7
        l7.SetGW_source("GW2");
        l7.Setvoisin("GW3");
        l7.Setcout(10);
        LSDB.add(l7);
//l8
        l8.SetGW_source("GW3");
        l8.Setvoisin("N3");
        l8.Setcout(0);
        LSDB.add(l8);
//l9
        l9.SetGW_source("GW3");
        l9.Setvoisin("GW1");
        l9.Setcout(4);
        LSDB.add(l9);
//l10
        l10.SetGW_source("GW3");
        l10.Setvoisin("GW2");
        l10.Setcout(10);
        LSDB.add(l10);
//l11
        l11.SetGW_source("GW3");
        l11.Setvoisin("GW4");
        l11.Setcout(2);
        LSDB.add(l11);
//l12
        l12.SetGW_source("GW4");
        l12.Setvoisin("N4");
        l12.Setcout(0);
        LSDB.add(l12);
//l13
        l13.SetGW_source("GW4");
        l13.Setvoisin("GW1");
        l13.Setcout(1);
        LSDB.add(l13);
//l14
        l14.SetGW_source("GW4");
        l14.Setvoisin("GW3");
        l14.Setcout(2);
        LSDB.add(l14);
    }
    public static void main(String[] argv) throws Exception {
//à l'écoute de LSP du routeur2
ServerSocket socketBienvenue2=new ServerSocket(14422);
        System.out.println("Port"+socketBienvenue2.getLocalPort()+"à l'écoute...");
        Socket socketConnexion2=socketBienvenue2.accept();
        ObjectInputStream Entree2=new ObjectInputStream(socketConnexion2.getInputStream());
       ArrayList lsp2=(ArrayList<LSDB>)Entree2.readObject();
        System.out.println("LSP du routeur 2 reçu");

        for(int i=0;i<lsp2.size();i++)
        {
            LSDB l=new LSDB();
            l=(LSDB) lsp2.get(i);
            
        }
        
        

        //à l'écoute de LSP du routeur3
        ServerSocket socketBienvenue3=new ServerSocket(14423);
        System.out.println("Port"+socketBienvenue3.getLocalPort()+"à l'écoute...");
        Socket socketConnexion3=socketBienvenue3.accept();
        ObjectInputStream Entree3=new ObjectInputStream(socketConnexion3.getInputStream());
       ArrayList lsp3=(ArrayList<LSP>)Entree3.readObject();
        System.out.println("LSP du routeur 3 reçu");
        for(int i=0;i<lsp3.size();i++)
        {
           LSDB l=new LSDB();
            l=(LSDB) lsp3.get(i);
            
        }
       
       


        //à l'écoute de LSP du routeur4
        ServerSocket socketBienvenue4=new ServerSocket(14424);
        System.out.println("Port"+socketBienvenue4.getLocalPort()+"à l'écoute...");
        Socket socketConnexion4=socketBienvenue4.accept();
        ObjectInputStream Entree4=new ObjectInputStream(socketConnexion4.getInputStream());
       ArrayList lsp4=(ArrayList<LSP>)Entree4.readObject();
        System.out.println("LSP du routeur 4 recu");
        for(int i=0;i<lsp4.size();i++)
        {
            LSDB l=new LSDB();
            l=(LSDB) lsp4.get(i);
            
        }
       
        

            //maintenant que la LSDB est mises à jour correctement : le DR va la communiquer aux autres routeurs(2,3,4)
            //envoi de la LSDB au routeur 2
            Socket socketClient = new Socket("127.0.0.1", 14022);
            ObjectOutputStream Sortie = new ObjectOutputStream(socketClient.getOutputStream());
            Sortie.writeObject(LSDB);
            System.out.println("LSDB envoyée au routeur 2");

            //envoi de la LSDB au routeur 3
            Socket socketClient2 = new Socket("127.0.0.1", 14023);
            ObjectOutputStream Sortie2 = new ObjectOutputStream(socketClient2.getOutputStream());
            Sortie2.writeObject(LSDB);
            System.out.println("LSDB envoyée au routeur 3");

            //envoi de la LSDB au routeur 4
            Socket socketClient3 = new Socket("127.0.0.1", 14024);
            ObjectOutputStream Sortie3 = new ObjectOutputStream(socketClient3.getOutputStream());
            Sortie3.writeObject(LSDB);
            System.out.println("LSDB envoyée au routeur 4"); 
    
           NewJFrame fenetrePrincipale = new NewJFrame();
        fenetrePrincipale.setVisible(true); 
    }
}
