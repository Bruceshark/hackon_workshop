package hackon_workshop;

import java.io.*;
import java.net.*;

public class readBin {
	String htm;
	readBin(String s){
		htm=s;
	}
	public void save(){
		String filename=htm.substring(htm.lastIndexOf("/")+1);
		try {
			URL sourceURL = new URL(htm);
			DataInputStream in =
					new DataInputStream(
					sourceURL.openStream());
			
			DataOutputStream out =
					new DataOutputStream(
					new FileOutputStream(
					new File(filename)));
			try{
				while(true)out.writeByte(in.readByte());
			}catch(Exception e){}
			out.close();
			in.close();
			}catch(Exception e){}
			
	}
}