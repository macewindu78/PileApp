package GenHtml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

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
			 String content = null, line;
			 StringBuilder sb = new StringBuilder();
			 System.out.println(content);
			 URL jc = getClass().getResource(jsonPath);
			 System.out.println(jc);
			 File file = new File(jc.toURI()); 
			   try {
			       FileReader reader = new FileReader(file);
			       char[] chars = new char[(int) file.length()];
			       reader.read(chars);
			       //System.out.println(chars);
			       content = new String(chars);
			       reader.close();
			   } catch (IOException e) {
			       e.printStackTrace();
			   }

			System.out.println(content);
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
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static String getFrenchName(){
		return frenchName;
	}
	
	
	
}
