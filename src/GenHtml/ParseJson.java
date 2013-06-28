package GenHtml;

import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class ParseJson{
	
	static JSONObject jsonFile, atome, properties, information, wikipedia;
	static String name, version, date, symbol, frenchName, atomicNumber,meltingPoint, boilingPoint, atomicRadius, density, use, universe, inChIKey, wikipediaFr, wikipediaEn;
	static JSONArray jdata;
	static int goodAtom;
	
	
	public ParseJson(){

	}
	
	public void returnSearch(String wantedAtom, String jsonPath) throws URISyntaxException{
		try{
			
			InputStream fis = getClass().getResourceAsStream(jsonPath);
	        String inputStreamString = new Scanner(fis,"UTF-8").useDelimiter("\\A").next();

			
			jsonFile = new JSONObject(inputStreamString);
			//System.out.println(jsonFile);
			jdata = jsonFile.getJSONArray("data");
			version = jsonFile.getString("version");
			//System.out.println(version);
			date = jsonFile.getString("date");
			//System.out.println(date);
			for(int i = 0; i < jdata.length() ; i++){
				atome = jdata.getJSONObject(i);
				name = atome.getString("name");
				//System.out.println(name);
				if(name.equals(wantedAtom)){
					break;
				}
			}
			
			properties = atome.getJSONObject("properties");
			symbol = properties.getString("symbol");
			frenchName = properties.getString("frenchName");
			atomicNumber = properties.getString("atomicNumber");
			meltingPoint = properties.getString("meltingPoint");
			boilingPoint = properties.getString("boilingPoint");
			atomicRadius = properties.getString("atomicRadius");
			density = properties.getString("density");
			
			information = atome.getJSONObject("information");
			use = information.getString("use");
			universe = information.getString("universe");
			inChIKey = information.getString("InChIKey");
			
			wikipedia = information.getJSONObject("wikipedia");
			wikipediaFr = wikipedia.getString("frenchValue");
			wikipediaEn = wikipedia.getString("englishValue");
		}
		catch(JSONException e){
			e.printStackTrace();
		}

	}
	
	public static String getFrenchName(){
		return frenchName;
	}
	
	
	
}
