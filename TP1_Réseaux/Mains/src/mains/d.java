package mains;

import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class d {


   public static void main(String[] argv) throws Exception {
  ArrayList <Routage> tableroutage = new ArrayList();
    String ps=new String();
    int cd=10,i,k;
    String pq;
    paquet p = new paquet();
    Routage r1= new Routage();
 r1.SetDest("E");r1.SetWH("E");r1.SetCont(1);tableroutage.add(r1);
 Routage r2= new Routage();
 r2.SetDest("C");r2.SetWH("E");r2.SetCont(2);tableroutage.add(r2);
 Routage r3= new Routage();
 r3.SetDest("A");r3.SetWH("E");r3.SetCont(3); tableroutage.add(r3);
 Routage r4= new Routage();
 r4.SetDest("B");r4.SetWH("E"); r4.SetCont(4); tableroutage.add(r4);
 Routage r5= new Routage();
 r5.SetDest("B");r5.SetWH("B");r5.SetCont(1);tableroutage.add(r5);
 Routage r6= new Routage();
 r6.SetDest("A");r6.SetWH("B");r6.SetCont(2);tableroutage.add(r6);
 Routage r7= new Routage();
 r7.SetDest("C");r7.SetWH("B");r7.SetCont(3);tableroutage.add(r7);
 Routage r8= new Routage();
 r8.SetDest("E");r8.SetWH("B");r8.SetCont(4);tableroutage.add(r8);
    Scanner sc = new Scanner(System.in);
    Scanner dt = new Scanner(System.in);
    Scanner des = new Scanner(System.in);
    p.SetSrc("D");
   String[] b = {"Envoyer un mesg", "mettre le srveur en cout","Annuler"};
		JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
		String choi = (String)jop.showInputDialog(null,
										"Veuillez choisir votre action !",
										"Serveur D !",
										JOptionPane.QUESTION_MESSAGE,
										null,
										b,
										b[2]);
		jop2.showMessageDialog(null, "Votre choix est " + choi, "Serveur D !", JOptionPane.INFORMATION_MESSAGE);


    if (choi.equals(b[0])){
        JOptionPane jop5 = new JOptionPane(), jop6 = new JOptionPane();
        String msg = jop5.showInputDialog(null, "Veuillez entrer votre msg !", "Serveur D !", JOptionPane.QUESTION_MESSAGE);
	jop6.showMessageDialog(null, "Votre msg est " + msg, "Serveur D !", JOptionPane.INFORMATION_MESSAGE);
        p.SetData(msg) ;

        String[] d = {"A", "B", "C","E"};
		JOptionPane jop3 = new JOptionPane(), jop4 = new JOptionPane();
		String dest = (String)jop3.showInputDialog(null,
										"Veuillez choisir la destination de votre msg !",
										"Serveur D !",
										JOptionPane.QUESTION_MESSAGE,
										null,
										d,
										d[2]);
		jop4.showMessageDialog(null, "Votre destination est " + dest, "Serveur D !", JOptionPane.INFORMATION_MESSAGE);
        p.SetDest(dest);
        pq = p.GetSrc()+p.GetDest()+p.GetData();
        System.out.println("le paquet devient: "+ pq);
       //choisir le prochain saut:

for (i=0;i<tableroutage.size();i++)
{k=tableroutage.get(i).GetCont();
if(p.GetDest().equals(tableroutage.get(i).GetDest()) && k<cd)
{
 cd=k;
 ps=tableroutage.get(i).GetWH();
 }}
System.out.println("prochain saut suivant la table de routage est"+ps);


int port = 0;
if (ps.equals("A"))
port=14405;
if (ps.equals("B"))
port=14406;
if (ps.equals("C"))
port=14407;
 if (ps.equals("E"))
port=14409;
//clse la socket avec son client a lui:
//socketBienvenue.close();
//cree une new socket avec le port approprié
System.out.println("le port suivant est  "+port);
Socket socketenvoie = new Socket("127.0.0.1",port);
//créer le flux de sortie attaché au socket
OutputStream Sortie = socketenvoie.getOutputStream();
ObjectOutputStream sort =new   ObjectOutputStream(Sortie);
sort.writeObject(p);
    }


    // Créer un socket d'écoute sur le port 14408
    ServerSocket socketBienvenue = new ServerSocket(14408);
    System.out.println("Port n°" +socketBienvenue.getLocalPort()+"du serveur D est à l'écoute...");

    while(true) {
        //Attendre la connexion d'un client
        Socket socketConnexion= socketBienvenue.accept();

        //Creer le flux d'entree attachأ© au socket

    ObjectInputStream Entree = new ObjectInputStream (socketConnexion.getInputStream());

    //Lire la chaine de caracteres depuis le socket

        try {
        p = (paquet) Entree.readObject();
        System.out.println("la chaine recue est:" + p.GetSrc()+p.GetDest()+p.GetData());
        System.out.println("la destination est:" + p.GetDest());
          }
         catch(ClassNotFoundException cnfex){
          System.out.println("> SERVER : Le type de l'objet recu est inconnu!" );
         }
        if (p.GetDest().compareTo("D")!=0){
        //choisir le prochain saut:

for (i=0;i<tableroutage.size();i++)
{k=tableroutage.get(i).GetCont();
if(p.GetDest().equals(tableroutage.get(i).GetDest()) && k<cd)
{
 cd=k;
 ps=tableroutage.get(i).GetWH();
 }}
System.out.println("prochain saut suivant la table de routage est"+ps);


int port = 0;
if (ps.equals("A"))
port=14405;
if (ps.equals("B"))
port=14406;
if (ps.equals("C"))
port=14407;
 if (ps.equals("E"))
port=14409;

//clse la socket avec son client a lui:
//socketBienvenue.close();

//cree une new socket avec le port approprié
System.out.println("le port suivant est  "+port);
Socket socketenvoie = new Socket("127.0.0.1",port);

//créer le flux de sortie attaché au socket
OutputStream Sortie = socketenvoie.getOutputStream();
ObjectOutputStream sort =new   ObjectOutputStream(Sortie);
sort.writeObject(p);
        }
        else{
            System.out.println("la chaine recue est:" + p.GetSrc()+p.GetDest()+p.GetData());
            System.out.println("la donnee est:" + p.GetData());
        }

        } //Reapartir et attendre une nouvelle connexion

         }


   }
