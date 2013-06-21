

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import Application.AccueilScreen;
import Application.MetauxCaract;
import GenHtml.GenerateHtml;
import GenHtml.ParseJson;


public class Test {

	/**
	 * @param args
	 * @throws URISyntaxException 
	 * @throws IOException 
	 */
	public static void main(String[] args){
		// TODO Auto-generated method stub
		ParseJson parseJson = new ParseJson();
		GenerateHtml ghtml = new GenerateHtml();
		for (int i = 0 ; i<MetauxCaract.getmetaux().length; i++){
			try {
				parseJson.returnSearch(MetauxCaract.getmetaux()[i], "/ressources/json/donneesmetaux.json");
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ghtml.GenHtml(ParseJson.getFrenchName());
		}

		AccueilScreen win = new AccueilScreen("Piles electro-chimiques",1000,700);
	}

}
