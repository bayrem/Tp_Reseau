package ripd;

import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class GW3  {

     public static void main(String [] args) throws Exception {

ArrayList<Routage> tableroutage = new ArrayList();
ArrayList<TableAdj> tbladj = new ArrayList();
int p = 3333;
SocketRecep skt = new SocketRecep();
SocketEnvoie Soc = new SocketEnvoie();
Socket s = new Socket();
ServerSocket ss= new ServerSocket();
//La table d'adjascence
TableAdj a1 = new TableAdj();
        a1.Setnode("node2");
        a1.SetGW("GW1");
       tbladj.add(a1);
TableAdj a2 = new TableAdj();
        a2.Setnode("node4");
        a2.SetGW("GW5");
        tbladj.add(a2);

//la table de routage
Routage R1 = new Routage();
        R1.Setnode("node2");
        R1.SetGW("GW3");
        R1.Setcout(0);
        tableroutage.add(R1);
Routage r2 = new Routage();
        r2.Setnode("node4");
        r2.SetGW("GW3");
        r2.Setcout(0);
        tableroutage.add(r2);
        NewJFrame11 nf = new NewJFrame11();
        nf.setVisible(true);
        System.out.println("La table de routage initiale est");
System.out.println("Node*****GW*****Cout");
System.out.println(R1.Getnode()+"*****"+R1.GetGW()+"*****"+R1.Getcout());
System.out.println(r2.Getnode()+"*****"+r2.GetGW()+"*****"+r2.Getcout());
Service1 sr=new Service1(s,R1,r2,tableroutage,ss);
Service sc = new Service(3333,tableroutage);

}
}
