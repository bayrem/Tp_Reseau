package ripd;

import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class GW2  {

     public static void main(String [] args) throws Exception {

ArrayList<Routage> tableroutage = new ArrayList();
ArrayList<TableAdj> tbladj = new ArrayList();
int p = 2222;
SocketRecep skt = new SocketRecep();
SocketEnvoie Soc = new SocketEnvoie();
Socket s = new Socket();
ServerSocket ss= new ServerSocket();
//La table d'adjascence
TableAdj a1 = new TableAdj();
        a1.Setnode("node1");
        a1.SetGW("GW1");
       tbladj.add(a1);
TableAdj a2 = new TableAdj();
        a2.Setnode("node3");
        a2.SetGW("GW4");
        tbladj.add(a2);

//la table de routage
Routage R1 = new Routage();
        R1.Setnode("node1");
        R1.SetGW("GW2");
        R1.Setcout(0);
        tableroutage.add(R1);
Routage r2 = new Routage();
        r2.Setnode("node3");
        r2.SetGW("GW2");
        r2.Setcout(0);
        tableroutage.add(r2);
        NewJFrame1 nf = new NewJFrame1();
        nf.setVisible(true);
        System.out.println("La table de routage initiale est");
System.out.println("Node*****GW*****Cout");
System.out.println(R1.Getnode()+"*****"+R1.GetGW()+"*****"+R1.Getcout());
System.out.println(r2.Getnode()+"*****"+r2.GetGW()+"*****"+r2.Getcout());
Service1 sr=new Service1(s,R1,r2,tableroutage,ss);
Service sc = new Service(2222,tableroutage);

}
}
