package Application;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class ParseJson{
	
	static JSONObject jsonFile, atome, properties, information, wikipedia;
	static String name, version, date, symbol, frenchName, atomicNumber,metingPoint, boilingPoint, atomicRadius, density, use, universe, inChIKey, wikipediaFr, wikipediaEn;
	static JSONArray jdata;
	static int goodAtom;
	
	
	public ParseJson(){

	}
	
	public static void returnSearch(String wantedAtom){
		try{
			 String content = null;
			 File file = new File("donneesmetaux.json"); 
			   try {
			       FileReader reader = new FileReader(file);
			       char[] chars = new char[(int) file.length()];
			       reader.read(chars);
			       System.out.println(chars);
			       content = new String(chars);
			       reader.close();
			   } catch (IOException e) {
			       e.printStackTrace();
			   }
			jsonFile = new JSONObject(content);
			jdata = jsonFile.getJSONArray("data");
			version = jsonFile.getString("version");
			System.out.println(version);
			date = jsonFile.getString("date");
			System.out.println(date);
			for(int i = 0; i < jdata.length() ; i++){
				atome = jdata.getJSONObject(i);
				name = atome.getString("name");
				System.out.println(name);
				if(name.equals(wantedAtom)){
					break;
				}
			}
			
			properties = atome.getJSONObject("properties");
			symbol = properties.getString("symbol");
			frenchName = properties.getString("frenchName");
			atomicNumber = properties.getString("atomicNumber");
			metingPoint = properties.getString("meltingPoint");
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
	
	
	
}
