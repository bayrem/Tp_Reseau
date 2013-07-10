package ripd;
import java.io.*;

public class TableAdj implements Serializable  {
    
   private  String node;
  private  String GW;

     public void SetGW (String WH)
    {
         GW = WH;
    }

    public String GetGW ()
    {
        return GW;
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
