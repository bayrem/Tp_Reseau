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

public class GW3 {
    ArrayList<TableAdj> tbladj = new ArrayList();
    ArrayList<Routage> tableroutage = new ArrayList();
static ArrayList<LSDB> LSDB = new ArrayList();
static ArrayList<LSDB> LSP = new ArrayList();
//La table d'adjascence
        TableAdj a1 = new TableAdj();
        TableAdj a2 = new TableAdj();
        TableAdj a3 = new TableAdj();
        TableAdj a4 = new TableAdj();
//LSP
LSDB LSP1 = new LSDB();
LSDB LSP2 = new LSDB();
LSDB LSP3 = new LSDB();
LSDB LSP4 = new LSDB();
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

        int p = 3333;
        int i = 2, j = 0;
        Routage route = new Routage();
        SocketRecep soc = new SocketRecep();
        Socket s = new Socket();
        ServerSocket ss = new ServerSocket();

    public GW3() throws Exception {


//La table d'adjacense
//a1
        a1.Setvoisin("N3");
        a1.Setcout(0);
        tbladj.add(a1);
//a2
        a2.Setvoisin("GW1");
        a2.Setcout(4);
        tbladj.add(a2);
//a3
        a3.Setvoisin("GW2");
        a3.Setcout(10);
        tbladj.add(a3);
//a4
        a4.Setvoisin("GW4");
        a4.Setcout(2);
        tbladj.add(a4);
//La LSP
//a1
        LSP1.SetGW_source("GW3");
        LSP1.Setvoisin("N3");
       LSP1.Setcout(0);
        LSP.add(LSP1);
//a2
        LSP2.SetGW_source("GW3");
        LSP2.Setvoisin("GW1");
        LSP2.Setcout(4);
        LSP.add(LSP2);
//a3
        LSP3.SetGW_source("GW3");
        LSP3.Setvoisin("GW2");
        LSP3.Setcout(10);
        LSP.add(LSP3);
//a4
        LSP4.SetGW_source("GW3");
        LSP4.Setvoisin("GW4");
        LSP4.Setcout(2);
        LSP.add(LSP4);
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
            Socket socketClient = new Socket("127.0.0.1", 14423);
            ObjectOutputStream Sortie = new ObjectOutputStream(socketClient.getOutputStream());
            Sortie.writeObject(LSP);
            System.out.println("LSP envoyé");

            //suite à l'envoi le routeur 2 se met à l'écoute du DR pour recevoir la LSDB
            ServerSocket socketBienvenue=new ServerSocket(14023);
            System.out.println("Port"+socketBienvenue.getLocalPort()+"à l'écoute...");
            Socket socketConnexion4=socketBienvenue.accept();
            ObjectInputStream Entree=new ObjectInputStream(socketConnexion4.getInputStream());
            LSDB= (ArrayList<LSDB>) Entree.readObject();
            System.out.println("LSDB reçue recu");

            
    }
}
