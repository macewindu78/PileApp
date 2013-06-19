
public class Calculs {

	public Calculs(){
		
	}
	
	
	public static float CalculPotentiel(int metalChoisie, int concentrationChoisie){
		float potentiel;
		
		potentiel = (float) (MetauxCaract.potentielsStandard[metalChoisie] - 0.0592/3 * Math.log10(1/MetauxCaract.concentrationsMolaires[concentrationChoisie]));
		
		
		return potentiel;
	}
	
	
	public static float CalculDDP(float potentielLame1, float potentielLame2){
		float dDP;
		
		dDP = potentielLame1 - potentielLame2;		
		
		return dDP;
	}

	
	
	
	public static float CalculConcentrationMassique(float masseMolaire, float concentrationMolaire){
		float concentrationMassique;
		
		concentrationMassique = masseMolaire * concentrationMolaire;
		
		return concentrationMassique;
	}

}
