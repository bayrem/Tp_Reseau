/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tp3;

import java.io.*;
/**
 *
 * @author BRM
 */
public class LSDB implements Serializable  {
  private  String GW_source;
  private  String voisin;
  private  int cout;

    public void SetGW_source (String WH)
    {
         GW_source = WH;
    }

    public String GetGW_source ()
    {
        return GW_source;
    }

    public void Setcout (int Cout)
    {
         cout = Cout;
    }

    public int Getcout ()
    {
        return cout;
    }

    public void Setvoisin (String Dest)
    {
         voisin = Dest;
    }

    public String Getvoisin ()
    {
        return voisin;
    }
}
