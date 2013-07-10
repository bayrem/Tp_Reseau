
package tp3;

import java.io.Serializable;

public class LSP implements Serializable
{
    public String routeur;
    public String voisin;
    public int cout;

    public LSP(String routeur, String voisin, int cout)
    {
        this.routeur = routeur;
        this.voisin = voisin;
        this.cout = cout;
    }

    public LSP()
    {
        routeur="";
        voisin="";
        cout=0;
    }

    public void afficherLSP()
    {
        System.out.println(" LSP : (routeur/voisin/cout) : "+routeur+" "+voisin+" "+cout);
    }

    public int getCout()
    {
        return cout;
    }

    public String getRouteur()
    {
        return routeur;
    }

    public String getVoisin()
    {
        return voisin;
    }

    public void setCout(int cout)
    {
        this.cout = cout;
    }

    public void setRouteur(String routeur)
    {
        this.routeur = routeur;
    }

    public void setVoisin(String voisin)
    {
        this.voisin = voisin;
    }
}