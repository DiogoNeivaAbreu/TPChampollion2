/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package champollion;

import java.util.Date;

/**
 *
 * @author Asus
 */
public class Intervention {
    
    private final Date debut;
    private final int duree;
    private final boolean annulee;
    private final TypeIntervention type;
    
    public Intervention(Salle s, UE u, Enseignant e, Date debut, int duree, boolean annulee, TypeIntervention type){
        this.debut = debut;
        this.duree = duree;
        this.annulee = annulee;
        this.type = type;
    }
    
    
    public Date getDebut(){
        return debut;
    }
    
    public int getDuree(){
        return duree;
    }
    
    public boolean getAnnulee(){
        return annulee;
    }
}
