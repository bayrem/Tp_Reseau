package tp3;
import java.io.*;

public class TableAdj implements Serializable  {
    
   private  String voisin;
  private  int cout;

     public void Setcout (int cout)
    {
         this.cout = cout;
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
