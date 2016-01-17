
package bol.utils;

public enum Neighborhood {
    Moore(0),
    VonNeumann(1);
    
    private int valeur;
    
    private Neighborhood(int id){
        this.valeur = id;
    }
}
