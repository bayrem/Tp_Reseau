/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ripd;

import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class Service1 extends Thread{
    Socket s;
 ArrayList tableroutage;
  Routage r1,r2, r3,r4,r5;
    ServerSocket socket;
    ServerSocket socketBienvenue;
    public Service1(Socket sock,Routage r1,Routage r2,ArrayList table,ServerSocket socketB)
    {
       s=sock;
     this.r1=r1;
       this.r2=r2;
       tableroutage=table;
       socket=socketB;
       start();
    }



    @Override
    public void run(){


      try{
      
      ObjectInputStream Entree1=new ObjectInputStream (s.getInputStream());
            try {
                r3 = (Routage) Entree1.readObject();
            }
            catch (ClassNotFoundException ex) {}


      if((r3.Getnode()!=r1.Getnode())&&(r3.Getnode()!=r2.Getnode()))
            {
                r3.Setcout(1);
                tableroutage.add(r3);

            }
       Socket socketConnexion2= socketBienvenue.accept();
     ObjectInputStream Entree2=new ObjectInputStream (socketConnexion2.getInputStream());
            try {
                r3 = (Routage) Entree2.readObject();
            } catch (ClassNotFoundException ex) {}



     if((r3.Getnode()!=r1.Getnode())&&(r3.Getnode()!=r2.Getnode()))
            {
                r3.Setcout(1);
                tableroutage.add(r3);

            }

     Socket socketConnexion3=socketBienvenue.accept();
     ObjectInputStream Entree3=new ObjectInputStream (socketConnexion3.getInputStream());
            try {
                r4 = (Routage) Entree3.readObject();
            } catch (ClassNotFoundException ex) {}


      if((r4.Getnode()!=r1.Getnode())&&(r4.Getnode()!=r2.Getnode()))
            {
                r4.Setcout(1);
                tableroutage.add(r4);

            }
      Socket socketConnexion4=socketBienvenue.accept();
     ObjectInputStream Entree4=new ObjectInputStream (socketConnexion4.getInputStream());
            try {
                r4 = (Routage) Entree4.readObject();
            } catch (ClassNotFoundException ex) {}



     if((r4.Getnode()!=r1.Getnode())&&(r4.Getnode()!=r2.Getnode()))
            {
                r4.Setcout(1);
                tableroutage.add(r4);

            }

      }
  catch(IOException e) {}





    try{
       
     ObjectInputStream Entree5=new ObjectInputStream (s.getInputStream());
            try {
                r5 = (Routage) Entree5.readObject();
            } catch (ClassNotFoundException ex) {}


      if((r5.Getnode()!=r1.Getnode())&&(r5.Getnode()!=r2.Getnode())&&(r5.Getnode()!=r3.Getnode())&&(r5.Getnode()!=r4.Getnode()))
            {
                r5.Setcout(2);
                r5.SetGW("GW2");
                tableroutage.add(r5);

            }
      Socket socketConnexion6=socketBienvenue.accept();
     ObjectInputStream Entree6=new ObjectInputStream (socketConnexion6.getInputStream());
            try {
                r5 = (Routage) Entree6.readObject();
            } catch (ClassNotFoundException ex) {}



      if((r5.Getnode()!=r1.Getnode())&&(r5.Getnode()!=r2.Getnode())&&(r5.Getnode()!=r3.Getnode())&&(r5.Getnode()!=r4.Getnode()))
            {
                r5.Setcout(2);
                r5.SetGW("GW2");
                tableroutage.add(r5);

            }


    }
    catch(IOException e) {}

}

}
