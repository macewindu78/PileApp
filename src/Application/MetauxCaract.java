package Application;


public class MetauxCaract {

	public MetauxCaract(){
		
	}
	
	protected static String[] concentrationsMolairesAff = { "0.01 mol/L" , "0.02 mol/L" , "0.03 mol/L" , "0.04 mol/L" , "0.05 mol/L"};
	protected static float[] concentrationsMolaires = { 0.01f , 0.02f , 0.03f , 0.04f , 0.05f}; // mol/L
	
	//Attention tout dépend de leur indice dans le tableau donc si vous modifiez un élément veillez à ce que chaque élément soit modifié au même indice.
	protected static String[] metaux = {"aluminium", "fer", "zinc", "cuivre", "argent", "or", "plomb"};
	protected static String[] metauxEn = {"Aluminium", "Iron", "Zinc", "Copper", "Silver", "Gold", "Lead"};
	protected static String[] solutions = {"sulfate d'aluminium", "sulfate de fer", "sulfate de zinc", "sulfate de cuivre (II)",  "nitrate d'argent", "nitrate d'or","nitrate de plomb"};
	protected static String[] ions = {"ions Al(III)", "ions fer(II)", "ions Zinc(II)", "ions cuivre(II)","ions argent", "ions Or(III)", "ions plomb(II)" };
 	protected static float[] potentielsStandard = { -1.662f , -0.44f , -0.763f , 0.337f , 0.799f , 1.498f , -0.126f }; //V
	protected static float[] massesMolaires = { 666.42f, 278.05f , 287.54f , 249.68f , 169.87f , 382.98f , 331.21f }; // g/mol
	protected static int[] nbreElctronsEchanges = {3,2,2,2,1,3,2};
	protected static float faraday = 96485.3365f;
	
	
	public static String[] getmetaux(){
		return metauxEn;
	}
}
