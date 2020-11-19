package champollion;

import java.util.Date;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ChampollionJUnitTest {
	Enseignant untel;
	UE uml, java;
		
	@BeforeEach
	public void setUp() {
		untel = new Enseignant("untel", "untel@gmail.com");
		uml = new UE("UML");
		java = new UE("Programmation en java");		
	}
	

	@Test
	public void testNouvelEnseignantSansService() {
		assertEquals(0, untel.heuresPrevues(),
                        "Un nouvel enseignant doit avoir 0 heures prévues");
	}
	
	@Test
	public void testAjouteHeures() {
                // 10h TD pour UML
		untel.ajouteEnseignement(uml, 0, 10, 0);

		assertEquals(10, untel.heuresPrevuesPourUE(uml),
                        "L'enseignant doit maintenant avoir 10 heures prévues pour l'UE 'uml'");

                // 20h TD pour UML
                untel.ajouteEnseignement(uml, 0, 20, 0);
                
		assertEquals(10 + 20, untel.heuresPrevuesPourUE(uml),
                         "L'enseignant doit maintenant avoir 30 heures prévues pour l'UE 'uml'");		
		
	}
        
        @Test
	public void testHeuresprevues() {
            untel.ajouteEnseignement(uml, 5, 10, 5);
            
            assertEquals(21, untel.heuresPrevues(),
                        "L'enseignant doit maintenant avoir 21 heures prévues ");
        }
        
        @Test
	public void testAjoutIntervention() {
            
            Salle s = new Salle("B101", 25);
            Date d = new Date();
            Intervention e = new Intervention(s, uml, untel, d, 2, true, TypeIntervention.TD);
            untel.ajouteIntervention(e);
            
            assertEquals(d, e.getDebut(), "L'intervention a bien été ajoutée");
        }
        
        @Test
	public void testssService() {
            untel.ajouteEnseignement(uml, 5, 10, 5);
            
            assertEquals(true, untel.enSousService(),
                        "L'enseignant doit être en sous service ");
            
        }
        
        @Test
	public void testssService2() {
            untel.ajouteEnseignement(uml, 0, 200, 0);
            assertEquals(false, untel.enSousService(),
                        "L'enseignant ne doit pas être en sous service ");
        }
	
}
