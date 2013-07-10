package mains;

import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class c {


   public static void main(String[] argv) throws Exception {
  ArrayList <Routage> tableroutage = new ArrayList();
    String ps=new String();
    int cd=10,i,k;
    String pq;
    paquet p = new paquet();
    Routage r1= new Routage();
 r1.SetDest("A");r1.SetWH("A");r1.SetCont(1);tableroutage.add(r1);
 Routage r2= new Routage();
 r2.SetDest("B");r2.SetWH("A");r2.SetCont(2);tableroutage.add(r2);
 Routage r3= new Routage();
 r3.SetDest("D");r3.SetWH("A");r3.SetCont(3); tableroutage.add(r3);
 Routage r4= new Routage();
 r4.SetDest("E");r4.SetWH("A"); r4.SetCont(4); tableroutage.add(r4);
 Routage r5= new Routage();
 r5.SetDest("E");r5.SetWH("E");r5.SetCont(1);tableroutage.add(r5);
 Routage r6= new Routage();
 r6.SetDest("D");r6.SetWH("E");r6.SetCont(2);tableroutage.add(r6);
 Routage r7= new Routage();
 r7.SetDest("B");r7.SetWH("E");r7.SetCont(3);tableroutage.add(r7);
 Routage r8= new Routage();
 r8.SetDest("A");r8.SetWH("E");r8.SetCont(4);tableroutage.add(r8);
    Scanner sc = new Scanner(System.in);
    Scanner dt = new Scanner(System.in);
    Scanner des = new Scanner(System.in);
    p.SetSrc("C");
    String[] b = {"Envoyer un mesg", "mettre le srveur en cout","Annuler"};
		JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
		String choi = (String)jop.showInputDialog(null,
										"Veuillez choisir votre action !",
										"Serveur C !",
										JOptionPane.QUESTION_MESSAGE,
										null,
										b,
										b[2]);
		jop2.showMessageDialog(null, "Votre choix est " + choi, "Serveur C !", JOptionPane.INFORMATION_MESSAGE);


    if (choi.equals(b[0])){
        JOptionPane jop5 = new JOptionPane(), jop6 = new JOptionPane();
        String msg = jop5.showInputDialog(null, "Veuillez entrer votre msg !", "Serveur C !", JOptionPane.QUESTION_MESSAGE);
	jop6.showMessageDialog(null, "Votre msg est " + msg, "Serveur C !", JOptionPane.INFORMATION_MESSAGE);
        p.SetData(msg) ;

        String[] d = {"A", "B", "D","E"};
		JOptionPane jop3 = new JOptionPane(), jop4 = new JOptionPane();
		String dest = (String)jop3.showInputDialog(null,
										"Veuillez choisir la destination de votre msg !",
										"Serveur C !",
										JOptionPane.QUESTION_MESSAGE,
										null,
										d,
										d[2]);
		jop4.showMessageDialog(null, "Votre destination est " + dest, "Serveur C !", JOptionPane.INFORMATION_MESSAGE);
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
if (ps.equals("D"))
port=14408;
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


    // Créer un socket d'écoute sur le port 14407
    ServerSocket socketBienvenue = new ServerSocket(14407);
    System.out.println("Port n°" +socketBienvenue.getLocalPort()+"du serveur C est à l'écoute...");

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
        if (p.GetDest().compareTo("C")!=0){
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
if (ps.equals("D"))
port=14408;
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
