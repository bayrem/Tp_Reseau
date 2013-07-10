package mains;

import java.io.*;



public class Routage implements Serializable  {
  private  String dest;
  private  String wh;
  private  int cont;

    public void SetWH (String WH)
    {
         wh = WH;
    }

    public String GetWH ()
    {
        return wh;
    }

    public void SetCont (int Cont)
    {
         cont = Cont;
    }

    public int GetCont ()
    {
        return cont;
    }

    public void SetDest (String Dest)
    {
         dest = Dest;
    }

    public String GetDest ()
    {
        return dest;
    }
}
