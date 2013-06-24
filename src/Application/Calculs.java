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
	
	
	
	public void calculReactLimitantetAvancement(int metal1, int metal2, int concentrationMolaire1, int concentrationMolaire2, float volume1,float volume2, float masse1, float masse2, float R){
		
		int factmult1 =1, factmult2 =1, nbElectronEchange = 0;
		float tempsReaction1, tempsReaction2,tempsTotal;
		float f = MetauxCaract.faraday;
		float ddp;
		float avancement;
		float solutionf1, solutionf2, metal1f, metal2f;
		boolean Red2 = false;
		
		if(MetauxCaract.nbreElctronsEchanges[metal1]==MetauxCaract.nbreElctronsEchanges[metal2]){
			nbElectronEchange = MetauxCaract.nbreElctronsEchanges[metal1];
		}
		else{
			nbElectronEchange = MetauxCaract.nbreElctronsEchanges[metal1]*MetauxCaract.nbreElctronsEchanges[metal2];
			factmult1 = MetauxCaract.nbreElctronsEchanges[metal2];
			factmult2 = MetauxCaract.nbreElctronsEchanges[metal1];
		}
		
		ddp = calculDDP(calculPotentiel(metal1,concentrationMolaire1),calculPotentiel(metal2,concentrationMolaire2));
		
		if(MetauxCaract.potentielsStandard[metal1]>MetauxCaract.potentielsStandard[metal2]){
		
			tempsReaction1 = concentrationMolaire1*volume1*R*MetauxCaract.nbreElctronsEchanges[metal1]*f/Math.abs(ddp);
			tempsReaction2 = masse2/MetauxCaract.massesMolaires[metal2]*R*MetauxCaract.nbreElctronsEchanges[metal2]*f/Math.abs(ddp);
			Red2 = true;
		
		}else{
			tempsReaction1 = masse1/MetauxCaract.massesMolaires[metal1]*R*MetauxCaract.nbreElctronsEchanges[metal1]*f/Math.abs(ddp);
			tempsReaction2 = concentrationMolaire2*volume2*R*MetauxCaract.nbreElctronsEchanges[metal2]*f/Math.abs(ddp);
		}
		
		if(tempsReaction1<tempsReaction2){
			tempsTotal = tempsReaction1;
		}else{
			tempsTotal = tempsReaction2;
		}
		avancement = ddp*tempsTotal/(R*f*nbElectronEchange);
		
		if(Red2 = true){
			solutionf1 = concentrationMolaire1*volume1 - factmult1*avancement;
			solutionf2 = concentrationMolaire2*volume2 + factmult2*avancement;
		
			metal1f = masse1/MetauxCaract.massesMolaires[metal1] + factmult1*avancement;
			metal1f = masse2/MetauxCaract.massesMolaires[metal2] - factmult2*avancement;
		}else{
			solutionf1 = concentrationMolaire1*volume1 + factmult1*avancement;
			solutionf2 = concentrationMolaire2*volume2 - factmult2*avancement;
		
			metal1f = masse1/MetauxCaract.massesMolaires[metal1] - factmult1*avancement;
			metal1f = masse2/MetauxCaract.massesMolaires[metal2] + factmult2*avancement;
		}
	}
	
	public float calculReactTempsT(int metal1, int metal2, float ddp, float R, float t){
		float avancement;
		
		avancement = ddp*t/(R*MetauxCaract.faraday*MetauxCaract.nbreElctronsEchanges[metal1]*MetauxCaract.nbreElctronsEchanges[metal2]);
		
		return avancement;
	}
	
	public void calculconcentrations(float avancement, float metal){
		
		
		
		
	}
	
	
	

}
