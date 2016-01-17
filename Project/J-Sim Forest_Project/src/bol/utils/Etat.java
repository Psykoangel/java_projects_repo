
package bol.utils;

public enum Etat {
    vide(0),
    jeunePousse(1),
    arbuste(2),
    arbre(3),
    feu(4),
    cendre(5),
    infecte(6);
    
    private int valeur;
    
    private Etat(int id){
        this.valeur = id;
    }
}
