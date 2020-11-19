package champollion;

public class ServicePrevu {
	// TODO : implémenter cette classe
    private final int volumeCM; 
    private final int volumeTD;
    private final int volumeTP;
    private final Enseignant e;
    private final UE u;
    
    public ServicePrevu(Enseignant e, UE u, int volumeCM, int volumeTD, int volumeTP){
        this.e = e;
        this.u = u;
        this.volumeCM = volumeCM;
        this.volumeTD = volumeTD;
        this.volumeTP = volumeTP;        
    }
    
    public int getVolumeCM(){
        return volumeCM;
    }
    
    public int getVolumeTD(){
        return volumeTD;
    }
    
    public int getVolumeTP(){
        return volumeTP;
    }
}
