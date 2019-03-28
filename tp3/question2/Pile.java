package question2;

import question1.PilePleineException;
import question1.PileVideException;

/**
 * A remplacer en partie par votre classe Pile de la question 1.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile implements PileI {

    private Object[] zone;
    private int ptr;

    public Pile(int taille) {
        if(taille<= 0) taille= CAPACITE_PAR_DEFAUT;
        this.ptr= 0;
        this.zone= new Object[taille];
    }

    public Pile() {
        this(0);
    }

    public void empiler(Object o) throws PilePleineException {
        if(estPleine()) throw new PilePleineException();
        
        this.zone[this.ptr] = o;
        this.ptr++;
    }

    public Object depiler() throws PileVideException {
        if(estVide()) throw new PileVideException();
        
        this.ptr--;
        return zone[ptr];
    }

    public Object sommet() throws PileVideException {
        if(estVide()) throw new PileVideException();
        
        return zone[ptr-1];
    }

    public int capacite() {
        
        return zone.length;
    }

    public int taille() {
        
        return ptr;
    }

    public boolean estVide() {
        
        return ptr==0;
    }

    public boolean estPleine() {
        
        return ptr== zone.length;
    }

    public boolean equals(Object o) {
        PileI pile = (PileI) o;
        int taille = this.taille();
        int capacite= this.capacite();
        
        if(taille!= pile.taille()) return false;
        
        if(capacite!= pile.capacite()) return false;
        
        Pile tempPile = new Pile(taille);
        Object obj = new Object();
        int i;
        
        for(i=0; i<taille; i++){
            try{
                obj= pile.depiler();
                tempPile.empiler(obj);
        }catch(PileVideException excp1){}
         catch(PilePleineException excp2){}
         
         if(! obj.equals(zone[i])){
             try{
                 pile.empiler(obj);
                }catch(PilePleineException excp2){}
             return false;
         }
    }
   
     return true;
  }
    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        // a completer
        return null;
    }
}