package hackon_workshop;

import java.io.*;
import java.net.*;

public class ReadHTML {
	String htm;
	ReadHTML(String s){
		htm=s;
	}
	public String getstring(){
		String str="";
		try {
			URL sourceURL = new URL(htm);
			BufferedReader in = new BufferedReader(
					new InputStreamReader(
					sourceURL.openStream()));
			
			String buf; 
			while(!(null==(buf=in.readLine()))){
				str+=buf;	//处理文本			
			}
			in.close();
			}catch(Exception e){}
		return str;
			
	}
}

