package champollion;

import java.util.*;


public class Enseignant extends Personne {
    
    
    private List<ServicePrevu> prevu = new ArrayList<>();
    private List<Intervention> interv = new ArrayList<>();
    

    // TODO : rajouter les autres méthodes présentes dans le diagramme UML

    public Enseignant(String nom, String email) {
        super(nom, email);
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant en "heures équivalent TD" Pour le calcul : 1 heure
     * de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure de TP vaut 0,75h
     * "équivalent TD"
     *
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevues() {
        // TODO: Implémenter cette méthode
        float equivalentTD = 0;
        for (ServicePrevu s : prevu){
            equivalentTD += 1.5*s.getVolumeCM() ;
            equivalentTD += s.getVolumeTD();
            equivalentTD += 0.75*s.getVolumeTP();
        }
        return Math.round(equivalentTD);
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant dans l'UE spécifiée en "heures équivalent TD" Pour
     * le calcul : 1 heure de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure
     * de TP vaut 0,75h "équivalent TD"
     *
     * @param ue l'UE concernée
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevuesPourUE(UE ue) {
        // TODO: Implémenter cette méthode
        int equivalentTD = 0;
        for (ServicePrevu s : prevu){
            if (s.getUE().equals(ue)){
                equivalentTD += 1.5* s.getVolumeCM();
                equivalentTD += s.getVolumeTD();
                equivalentTD += 0.75* s.getVolumeTP();
            }
        }
            
        return Math.round(equivalentTD);
    }
    
    public int heuresPlanifiees(){
        int equivalentTD = 0;
        for (Intervention i : interv){
            if (i.getAnnulee()==false){
                equivalentTD += heuresPrevues();
            }
        }
        return equivalentTD;
        
    }

    /**
     * Ajoute un enseignement au service prévu pour cet enseignant
     *
     * @param ue l'UE concernée
     * @param volumeCM le volume d'heures de cours magitral
     * @param volumeTD le volume d'heures de TD
     * @param volumeTP le volume d'heures de TP
     */
    public void ajouteEnseignement(UE ue, int volumeCM, int volumeTD, int volumeTP) {
        // TODO: Implémenter cette méthode
        ServicePrevu s = new ServicePrevu(this, ue, volumeCM, volumeTD, volumeTP);
        prevu.add(s);
        
    }
    
   
    public void ajouteIntervention(Intervention e){
        interv.add(e);
        
        
    }
    
    public boolean enSousService(){
        return false;
        
    }

}
