package GenHtml;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class GenerateHtml {
	
	
	public GenerateHtml(){
		
	}
	
	
	public void GenHtml(String wantedAtom){
		 String content = null;
		 URL jc = getClass().getResource("/ressources/html/architecturemetal.html");
		 File file = null;
		try {
			file = new File(jc.toURI());
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
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
		 
	
		 content = content.replace("[frenchName]", ParseJson.frenchName);
		 content = content.replace("[name]", ParseJson.name);
		 content = content.replace("[symbol]", ParseJson.symbol);
		 content = content.replace("[atomicNumber]", ParseJson.atomicNumber);
		 content = content.replace("[meltingPoint]", ParseJson.meltingPoint);
		 content = content.replace("[boilingPoint]", ParseJson.boilingPoint);  
		 content = content.replace("[atomicRadius]", ParseJson.atomicRadius);
		 content = content.replace("[density]", ParseJson.density);
		 content = content.replace("[use]", ParseJson.use);
		 content = content.replace("[universe]", ParseJson.universe);  
		 content = content.replace("[inChIKey]", ParseJson.inChIKey);
		 content = content.replace("[wikipediaFr]", ParseJson.wikipediaFr);
		 content = content.replace("[wikipediaEn]", ParseJson.wikipediaEn);
		 
		 
		 
		 try{
			 URL jc1 = getClass().getResource("/ressources/html/contenu/"+wantedAtom+".html");
			 File zinc = new File(jc1.toURI());
			 zinc.createNewFile();
			 FileWriter fw = new FileWriter(zinc);
			 fw.write(content);
			 fw.close();
		 }
		 catch(IOException e){
			 e.printStackTrace();
		 } catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	
	
	
	
	
	
	
}
