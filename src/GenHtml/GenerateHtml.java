package GenHtml;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

import Application.Test;

public class GenerateHtml {
	
	
	public GenerateHtml(){
		
	}
	
	
	public void GenHtml(String wantedAtom){
		String content = null;
		
		
		InputStream fis = getClass().getResourceAsStream("/html/Index.html");
		String inputSString = new Scanner(fis,"UTF-8").useDelimiter("\\A").next();

		content = inputSString;
	
		//System.out.println(content);
		
		 try{
			String path = Test.class.getProtectionDomain().getCodeSource().getLocation().getPath();
			if(!Test.eclipse){
				path = path.substring(0, path.lastIndexOf("."));
			}
			boolean success = (new File(path+"html")).mkdir();
			if(!success){
				//System.out.println("didn't create dir");
			}
			OutputStream ou = new FileOutputStream(path+"html/Index.html");
			OutputStreamWriter osw = new OutputStreamWriter(ou,"UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			bw.write(content);
			bw.close();
		 }
		 catch(IOException e){
			 e.printStackTrace();
		 }
		 
		
		
		fis = getClass().getResourceAsStream("/html/architecturemetal.html");
		String inputStreamString = new Scanner(fis,"UTF-8").useDelimiter("\\A").next();

		content = inputStreamString;
	
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
		 
		//System.out.println(content);
		 
		 try{
			String path = Test.class.getProtectionDomain().getCodeSource().getLocation().getPath();
			if(!Test.eclipse){
				path = path.substring(0, path.lastIndexOf("."));
			}
			OutputStream ou = new FileOutputStream(path+"html/"+wantedAtom+".html");
			OutputStreamWriter osw = new OutputStreamWriter(ou,"UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			bw.write(content);
			bw.close();
		 }
		 catch(IOException e){
			 e.printStackTrace();
		 }
		 
			

		 
		 	fis = getClass().getResourceAsStream("/html/style.css");
			String inputStreString = new Scanner(fis,"UTF-8").useDelimiter("\\A").next();

			content = inputStreString;
		
			//System.out.println(content);
			 
			 try{
				String path = Test.class.getProtectionDomain().getCodeSource().getLocation().getPath();
				if(!Test.eclipse){
					path = path.substring(0, path.lastIndexOf("."));
				}
				OutputStream ou = new FileOutputStream(path+"html/style.css");
				OutputStreamWriter osw = new OutputStreamWriter(ou,"UTF-8");
				BufferedWriter bw = new BufferedWriter(osw);
				bw.write(content);
				bw.close();
			 }
			 catch(IOException e){
				 e.printStackTrace();
			 }
		 
		 
		 
		 
		 
	 }
	
	
	
	
	
	
	
}
