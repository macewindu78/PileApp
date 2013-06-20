package Application;


public class Calculs {

	public Calculs(){
		
	}
	
	
	public static float calculPotentiel(int metalChoisie, int concentrationChoisie){
		float potentiel;
		
		potentiel = (float) (MetauxCaract.potentielsStandard[metalChoisie] - 0.0592/3 * Math.log10(1/MetauxCaract.concentrationsMolaires[concentrationChoisie]));
		
		
		return potentiel;
	}
	
	
	public static float calculDDP(float potentielLame1, float potentielLame2){
		float dDP;
		
		dDP = potentielLame1 - potentielLame2;		
		
		return dDP;
	}

	
	
	
	public static float calculConcentrationMassique(float masseMolaire, float concentrationMolaire){
		float concentrationMassique;
		
		concentrationMassique = masseMolaire * concentrationMolaire;
		
		return concentrationMassique;
	}

}
