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
import tp3.NewJFrame;

public class GW4 {
    ArrayList<TableAdj> tbladj = new ArrayList();
    ArrayList<Routage> tableroutage = new ArrayList();
static ArrayList<LSDB> LSDB = new ArrayList();
static ArrayList<LSDB> LSP = new ArrayList();
//La table d'adjascence
      static  TableAdj a1 = new TableAdj();
      static  TableAdj a2 = new TableAdj();
      static  TableAdj a3 = new TableAdj();
      static  TableAdj a4 = new TableAdj();
//La LSP
LSDB LSP1 = new LSDB();
LSDB LSP2 = new LSDB();
LSDB LSP3 = new LSDB();
//La LSDB
static LSDB l1 = new LSDB();
static LSDB l2 = new LSDB();
static LSDB l3 = new LSDB();
static LSDB l4 = new LSDB();
static LSDB l5 = new LSDB();
static LSDB l6 = new LSDB();
static LSDB l7 = new LSDB();
static LSDB l8 = new LSDB();
static LSDB l9 = new LSDB();
static LSDB l10 = new LSDB();
static LSDB l11 = new LSDB();
static LSDB l12 = new LSDB();
static LSDB l13 = new LSDB();
static LSDB l14 = new LSDB();
static LSDB l15 = new LSDB();
static LSDB l16 = new LSDB();

        int p = 4444;
        int i = 2, j = 0;
        Routage route = new Routage();
        SocketRecep soc = new SocketRecep();
        Socket s = new Socket();
        ServerSocket ss = new ServerSocket();

    public GW4() throws Exception {


//La tablle d'adjacense
//a1
        a1.Setvoisin("N4");
        a1.Setcout(0);
        tbladj.add(a1);
//a2
        a2.Setvoisin("GW1");
        a2.Setcout(1);
        tbladj.add(a2);
//a3
        a3.Setvoisin("GW3");
        a3.Setcout(2);
        tbladj.add(a3);
//LSP
//a1
        LSP1.SetGW_source("GW3");
        LSP1.Setvoisin("N4");
        LSP1.Setcout(0);
        LSP.add(LSP1);
//a2
        LSP2.SetGW_source("GW3");
        LSP2.Setvoisin("GW1");
        LSP2.Setcout(1);
        LSP.add(LSP2);
//a3
        LSP3.SetGW_source("GW3");
        LSP3.Setvoisin("GW3");
        LSP3.Setcout(2);
        LSP.add(LSP3);
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
//envoi de la LSP
            Socket socketClient = new Socket("127.0.0.1", 14424);
            ObjectOutputStream Sortie = new ObjectOutputStream(socketClient.getOutputStream());
            Sortie.writeObject(LSP);
            System.out.println("LSP envoyé");

            //suite à l'envoi le routeur 2 se met à l'écoute du DR pour recevoir la LSDB
            ServerSocket socketBienvenue=new ServerSocket(14024);
            System.out.println("Port"+socketBienvenue.getLocalPort()+"à l'écoute...");
            Socket socketConnexion4=socketBienvenue.accept();
            ObjectInputStream Entree=new ObjectInputStream(socketConnexion4.getInputStream());
            LSDB= (ArrayList<LSDB>) Entree.readObject();
            System.out.println("LSDB reçue recu");
/*
                NewJFrame.jTable1.setValueAt(a1.Getvoisin(), 0, 0);
                NewJFrame.jTable1.setValueAt(a1.Getcout(), 0, 1);
                NewJFrame.jTable1.setValueAt(a2.Getvoisin(), 1, 0);
                NewJFrame.jTable1.setValueAt(a2.Getcout(), 1, 1);
                NewJFrame.jTable1.setValueAt(a3.Getvoisin(), 2, 0);
                NewJFrame.jTable1.setValueAt(a3.Getcout(), 2, 1);
                NewJFrame.jTable1.setValueAt("", 3, 0);
                NewJFrame.jTable1.setValueAt("", 3, 1);
                //LSDB
                NewJFrame.jTable3.setValueAt(l1.GetGW_source(), 0, 0);
                NewJFrame.jTable3.setValueAt(l1.Getvoisin(), 0, 1);
                NewJFrame.jTable3.setValueAt(l1.Getcout(), 0, 2);
                NewJFrame.jTable3.setValueAt(l2.GetGW_source(), 1, 0);
                NewJFrame.jTable3.setValueAt(l2.Getvoisin(), 1, 1);
                NewJFrame.jTable3.setValueAt(l2.Getcout(), 1, 2);
                NewJFrame.jTable3.setValueAt(l3.GetGW_source(), 2, 0);
                NewJFrame.jTable3.setValueAt(l3.Getvoisin(), 2, 1);
                NewJFrame.jTable3.setValueAt(l3.Getcout(), 2, 2);
                NewJFrame.jTable3.setValueAt(l4.GetGW_source(), 3, 0);
                NewJFrame.jTable3.setValueAt(l4.Getvoisin(), 3, 1);
                NewJFrame.jTable3.setValueAt(l4.Getcout(), 3, 2);
                NewJFrame.jTable3.setValueAt(l5.GetGW_source(), 4, 0);
                NewJFrame.jTable3.setValueAt(l5.Getvoisin(), 4, 1);
                NewJFrame.jTable3.setValueAt(l5.Getcout(), 4, 2);
                NewJFrame.jTable3.setValueAt(l6.GetGW_source(), 5, 0);
                NewJFrame.jTable3.setValueAt(l6.Getvoisin(), 5, 1);
                NewJFrame.jTable3.setValueAt(l6.Getcout(), 5, 2);
                NewJFrame.jTable3.setValueAt(l7.GetGW_source(), 6, 0);
                NewJFrame.jTable3.setValueAt(l7.Getvoisin(), 6, 1);
                NewJFrame.jTable3.setValueAt(l7.Getcout(), 6, 2);
                NewJFrame.jTable3.setValueAt(l8.GetGW_source(), 7, 0);
                NewJFrame.jTable3.setValueAt(l8.Getvoisin(), 7, 1);
                NewJFrame.jTable3.setValueAt(l8.Getcout(), 7, 2);
                NewJFrame.jTable3.setValueAt(l9.GetGW_source(), 8, 0);
                NewJFrame.jTable3.setValueAt(l9.Getvoisin(), 8, 1);
                NewJFrame.jTable3.setValueAt(l9.Getcout(), 8, 2);
                NewJFrame.jTable3.setValueAt(l10.GetGW_source(), 9, 0);
                NewJFrame.jTable3.setValueAt(l10.Getvoisin(), 9, 1);
                NewJFrame.jTable3.setValueAt(l10.Getcout(), 9, 2);
                NewJFrame.jTable3.setValueAt(l11.GetGW_source(), 10, 0);
                NewJFrame.jTable3.setValueAt(l11.Getvoisin(), 10, 1);
                NewJFrame.jTable3.setValueAt(l11.Getcout(), 10, 2);
                NewJFrame.jTable3.setValueAt(l12.GetGW_source(), 11, 0);
                NewJFrame.jTable3.setValueAt(l12.Getvoisin(), 11, 1);
                NewJFrame.jTable3.setValueAt(l12.Getcout(), 11, 2);
                NewJFrame.jTable3.setValueAt(l13.GetGW_source(), 12, 0);
                NewJFrame.jTable3.setValueAt(l13.Getvoisin(), 12, 1);
                NewJFrame.jTable3.setValueAt(l13.Getcout(), 12, 2);
                NewJFrame.jTable3.setValueAt(l14.GetGW_source(), 13, 0);
                NewJFrame.jTable3.setValueAt(l14.Getvoisin(), 13, 1);
                NewJFrame.jTable3.setValueAt(l14.Getcout(), 13, 2);

            NewJFrame fenetrePrincipale = new NewJFrame();
        fenetrePrincipale.setVisible(true); */
    }
}
