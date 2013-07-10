package ripd;

import java.io.*;

public class Routage implements Serializable  {
  private  String node;
  private  String GW;
  private  int cout;

    public void SetGW (String WH)
    {
         GW = WH;
    }

    public String GetGW ()
    {
        return GW;
    }

    public void Setcout (int Cout)
    {
         cout = Cout;
    }

    public int Getcout ()
    {
        return cout;
    }

    public void Setnode (String Dest)
    {
         node = Dest;
    }

    public String Getnode ()
    {
        return node;
    }
}
