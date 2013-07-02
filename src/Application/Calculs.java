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
	
	public static float calculCourant(float ddp, float R){
		float courant;
		
		courant = ddp/R;
				
		return courant;
	}
	
	
	
	public static float calculConcentrationMassique(float masseMolaire, float concentrationMolaire){
		float concentrationMassique;
		
		concentrationMassique = masseMolaire * concentrationMolaire;
		
		return concentrationMassique;
	}
	
	
	
	public static void calculReactLimitantetAvancement(){
		
		int factmult1 =1, factmult2 =1, nbElectronEchange = 0;
		float tempsReaction1, tempsReaction2,tempsTotal;
		float f = MetauxCaract.faraday;
		float ddp;
		boolean Red2 = false;
		int nbrElectronsEchanges1 = MetauxCaract.nbreElctronsEchanges[AccueilScreen.GetInstance().circuitferme.metal1],nbrElectronsEchanges2 = MetauxCaract.nbreElctronsEchanges[AccueilScreen.GetInstance().circuitferme.metal2];
		int metal1= AccueilScreen.GetInstance().circuitferme.metal1, metal2 = AccueilScreen.GetInstance().circuitferme.metal2;
		int concentrationMolaire1 = AccueilScreen.GetInstance().circuitferme.concentrationMolaire1,concentrationMolaire2 = AccueilScreen.GetInstance().circuitferme.concentrationMolaire2;
		float volume1 = 0.001f*AccueilScreen.GetInstance().circuitferme.volume1,volume2=0.001f*AccueilScreen.GetInstance().circuitferme.volume2;
		float masse1 = AccueilScreen.GetInstance().circuitferme.masse1, masse2 =  AccueilScreen.GetInstance().circuitferme.masse2;
		float R = AccueilScreen.GetInstance().circuitferme.R;
		
		
		if(nbrElectronsEchanges1==nbrElectronsEchanges2){
			nbElectronEchange = nbrElectronsEchanges1;
		}
		else{
			nbElectronEchange = nbrElectronsEchanges1*nbrElectronsEchanges2;
			factmult1 = MetauxCaract.nbreElctronsEchanges[AccueilScreen.GetInstance().circuitferme.metal2];
			factmult2 = MetauxCaract.nbreElctronsEchanges[AccueilScreen.GetInstance().circuitferme.metal1];
		}
		
		AccueilScreen.GetInstance().circuitferme.ddp = calculDDP(calculPotentiel(metal1,concentrationMolaire1),calculPotentiel(metal2, concentrationMolaire2));
		
		ddp = AccueilScreen.GetInstance().circuitferme.ddp;
		
		if(MetauxCaract.potentielsStandard[metal1]>MetauxCaract.potentielsStandard[metal2]){
		
			tempsReaction1 = MetauxCaract.concentrationsMolaires[concentrationMolaire1]*volume1*R*MetauxCaract.nbreElctronsEchanges[metal1]*f/Math.abs(ddp);
			tempsReaction2 = masse2/MetauxCaract.massesMolaires[metal2]*R*MetauxCaract.nbreElctronsEchanges[metal2]*f/Math.abs(ddp);
			Red2 = true;
		
		}else{
			tempsReaction1 = masse1/MetauxCaract.massesMolaires[metal1]*R*MetauxCaract.nbreElctronsEchanges[metal1]*f/Math.abs(ddp);
			tempsReaction2 = MetauxCaract.concentrationsMolaires[concentrationMolaire2]*volume2*R*MetauxCaract.nbreElctronsEchanges[metal2]*f/Math.abs(ddp);
			Red2 = false;
		}
		
		if(tempsReaction1<tempsReaction2){
			AccueilScreen.GetInstance().circuitferme.tempsTotal = tempsReaction1; 
		}else{
			AccueilScreen.GetInstance().circuitferme.tempsTotal = tempsReaction2;
		}
		
		tempsTotal = AccueilScreen.GetInstance().circuitferme.tempsTotal;
		AccueilScreen.GetInstance().circuitferme.avancementFinal = Math.abs(ddp)*tempsTotal/(R*f*nbElectronEchange);
		
		if(Red2 == true){
			AccueilScreen.GetInstance().circuitferme.concentrationfinale1 = (MetauxCaract.concentrationsMolaires[concentrationMolaire1]*volume1 - factmult1*AccueilScreen.GetInstance().circuitferme.avancementFinal)/volume1;
			AccueilScreen.GetInstance().circuitferme.concentrationfinale2 = (MetauxCaract.concentrationsMolaires[concentrationMolaire2]*volume2 + factmult2*AccueilScreen.GetInstance().circuitferme.avancementFinal)/volume2;
		
			AccueilScreen.GetInstance().circuitferme.masseFinale1 = (masse1/MetauxCaract.massesMolaires[metal1] + factmult1*AccueilScreen.GetInstance().circuitferme.avancementFinal)*MetauxCaract.massesMolaires[metal1];
			AccueilScreen.GetInstance().circuitferme.masseFinale2 = (masse2/MetauxCaract.massesMolaires[metal2] - factmult2*AccueilScreen.GetInstance().circuitferme.avancementFinal)*MetauxCaract.massesMolaires[metal2];
		}else{
			AccueilScreen.GetInstance().circuitferme.concentrationfinale1 = (MetauxCaract.concentrationsMolaires[concentrationMolaire1]*volume1 + factmult1*AccueilScreen.GetInstance().circuitferme.avancementFinal)/volume1;
			AccueilScreen.GetInstance().circuitferme.concentrationfinale2 = (MetauxCaract.concentrationsMolaires[concentrationMolaire2]*volume2 - factmult2*AccueilScreen.GetInstance().circuitferme.avancementFinal)/volume2;
		
			AccueilScreen.GetInstance().circuitferme.masseFinale1 = (masse1/MetauxCaract.massesMolaires[metal1] - factmult1*AccueilScreen.GetInstance().circuitferme.avancementFinal)*MetauxCaract.massesMolaires[metal1];
			AccueilScreen.GetInstance().circuitferme.masseFinale2 = (masse2/MetauxCaract.massesMolaires[metal2] + factmult2*AccueilScreen.GetInstance().circuitferme.avancementFinal)*MetauxCaract.massesMolaires[metal2];
		}
		
		
		if(AccueilScreen.GetInstance().circuitferme.concentrationfinale1 < 0.00001){
			AccueilScreen.GetInstance().circuitferme.concentrationfinale1 =0;
		}
		if(AccueilScreen.GetInstance().circuitferme.concentrationfinale2 < 0.00001){
			AccueilScreen.GetInstance().circuitferme.concentrationfinale2 =0;
		}
		if(AccueilScreen.GetInstance().circuitferme.masseFinale1 < 0.00001){
			AccueilScreen.GetInstance().circuitferme.masseFinale1 =0;
		}
		if(AccueilScreen.GetInstance().circuitferme.masseFinale2 < 0.00001){
			AccueilScreen.GetInstance().circuitferme.masseFinale2 =0;
		}
	
	}
	
	public static float calculReactTempsT(float temps,float ddp){
		float avancement;
		int nbElectronEchange = 0;
		int nbrElectronsEchanges1 = MetauxCaract.nbreElctronsEchanges[AccueilScreen.GetInstance().circuitferme.metal1],nbrElectronsEchanges2 = MetauxCaract.nbreElctronsEchanges[AccueilScreen.GetInstance().circuitferme.metal2];
		if(nbrElectronsEchanges1==nbrElectronsEchanges2){
			nbElectronEchange = nbrElectronsEchanges1;
		}
		else{
			nbElectronEchange = nbrElectronsEchanges1*nbrElectronsEchanges2;
		}
		
		avancement = Math.abs(ddp)*temps/(AccueilScreen.GetInstance().circuitferme.R*MetauxCaract.faraday*nbElectronEchange);
		
		return avancement;
	}
	
	public static void calculConcentrationsEtMasse(float avancement){
		int metal1= AccueilScreen.GetInstance().circuitferme.metal1, metal2 = AccueilScreen.GetInstance().circuitferme.metal2;
		float volume1 = 0.001f*AccueilScreen.GetInstance().circuitferme.volume1,volume2=0.001f*AccueilScreen.GetInstance().circuitferme.volume2;
		float masse1 = AccueilScreen.GetInstance().circuitferme.masse1, masse2 =  AccueilScreen.GetInstance().circuitferme.masse2;
		int concentrationMolaire1 = AccueilScreen.GetInstance().circuitferme.concentrationMolaire1,concentrationMolaire2 = AccueilScreen.GetInstance().circuitferme.concentrationMolaire2;
		int factmult1 =1, factmult2 =1;
		int nbrElectronsEchanges1 = MetauxCaract.nbreElctronsEchanges[AccueilScreen.GetInstance().circuitferme.metal1],nbrElectronsEchanges2 = MetauxCaract.nbreElctronsEchanges[AccueilScreen.GetInstance().circuitferme.metal2];

		

		if(nbrElectronsEchanges1!=nbrElectronsEchanges2){
			factmult1 = MetauxCaract.nbreElctronsEchanges[AccueilScreen.GetInstance().circuitferme.metal2];
			factmult2 = MetauxCaract.nbreElctronsEchanges[AccueilScreen.GetInstance().circuitferme.metal1];
		}
		else{
			factmult1 = 1;
			factmult2 = 1;
		}

		
		if(MetauxCaract.potentielsStandard[metal1]>MetauxCaract.potentielsStandard[metal2]){
			AccueilScreen.GetInstance().circuitferme.concentration1TempsT = (MetauxCaract.concentrationsMolaires[concentrationMolaire1]*volume1 - factmult1*avancement)/volume1;
			AccueilScreen.GetInstance().circuitferme.concentration2TempsT = (MetauxCaract.concentrationsMolaires[concentrationMolaire2]*volume2 + factmult2*avancement)/volume2;
		
			AccueilScreen.GetInstance().circuitferme.masse1TempsT = (masse1/MetauxCaract.massesMolaires[metal1] + factmult1*avancement)*MetauxCaract.massesMolaires[metal1];
			AccueilScreen.GetInstance().circuitferme.masse2TempsT = (masse2/MetauxCaract.massesMolaires[metal2] - factmult2*avancement)*MetauxCaract.massesMolaires[metal2];
			
		}else{
			AccueilScreen.GetInstance().circuitferme.concentration1TempsT = (MetauxCaract.concentrationsMolaires[concentrationMolaire1]*volume1 + factmult1*avancement)/volume1;
			AccueilScreen.GetInstance().circuitferme.concentration2TempsT = (MetauxCaract.concentrationsMolaires[concentrationMolaire2]*volume2 - factmult2*avancement)/volume2;
		
			AccueilScreen.GetInstance().circuitferme.masse1TempsT = (masse1/MetauxCaract.massesMolaires[metal1] - factmult1*avancement)*MetauxCaract.massesMolaires[metal1];
			AccueilScreen.GetInstance().circuitferme.masse2TempsT = (masse2/MetauxCaract.massesMolaires[metal2] + factmult2*avancement)*MetauxCaract.massesMolaires[metal2];
		}
		
		if(AccueilScreen.GetInstance().circuitferme.concentration1TempsT < 0.00001){
			AccueilScreen.GetInstance().circuitferme.concentration1TempsT =0;
		}
		if(AccueilScreen.GetInstance().circuitferme.concentration2TempsT < 0.00001){
			AccueilScreen.GetInstance().circuitferme.concentration2TempsT =0;
		}
		if(AccueilScreen.GetInstance().circuitferme.masse1TempsT < 0.00001){
			AccueilScreen.GetInstance().circuitferme.masse1TempsT =0;
		}
		if(AccueilScreen.GetInstance().circuitferme.masse2TempsT < 0.00001){
			AccueilScreen.GetInstance().circuitferme.masse2TempsT =0;
		}
		
		
	}
	
	
	

}
