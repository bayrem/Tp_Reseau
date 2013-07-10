/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tp3;
import java.util.ArrayList;

public class Sommet {

    /**
     * Ensemble des sommets d'où partent une arête ayant pour arrivée l'instance courante de la classe Sommet.
     */
    private ArrayList<Sommet> entrants = new ArrayList<Sommet>();
    /**
     * Ensemble des sommets d'où arrivent une arête ayant pour départ l'instance courante de la classe Sommet.
     */
    private ArrayList<Sommet> sortants = new ArrayList<Sommet>();

    /**
     * Crée une arête partant de l'instance courante de la classe Sommet et arrivant au sommet dest.
     * Une arête est connue des deux sommets qu'il rejoint.
     * @return l'instance courante de la classe Sommet.
     */
    public Sommet ajouterSortant(Sommet dest) {
        this.sortants.add(dest);
        dest.entrants.add(this);
        return this;
    }

    /**
     * Renvoie une COPIE de la collection de sommets entrants.
     */
    public ArrayList<Sommet> getEntrants() {
        return (ArrayList<Sommet>)this.entrants.clone();
    }

    /**
     * Renvoie une COPIE de la collection de sommets sortants.
     */
    public ArrayList<Sommet> getSortants() {
        return (ArrayList<Sommet>)this.sortants.clone();
    }
}