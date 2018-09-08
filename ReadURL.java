package hackon_workshop;

import java.io.*;
import java.net.*;

public class ReadURL {
	static String htm;
	ReadURL(String s){
		htm=s;
	}
	public static void main ( String[] args){
		try {
			URL sourceURL = new URL("http://www.h14z.com/Sub1_disp.aspx?Id=10842"); //I use h14z.com as an example :)
			BufferedReader in = new BufferedReader(
					new InputStreamReader(
					sourceURL.openStream()));
			String buf; 
			int i,j;
			while(!(null==(buf=in.readLine()))){
				if((j=buf.indexOf(".jpg"))>0){ //find the formats of tags of the pics you want
					i=buf.indexOf("<A href="); //find the formats of tags of the pics you want
					htm=buf.substring(i+9,j);  //9 means there are 9 characters in "<A href="
					String completestring="http://www.h14z.com/"+htm+".jpg";
					new readBin(completestring).save();
				System.out.println(completestring);
				}
			}
			in.close();
			}catch(Exception e){}
	}	


}


