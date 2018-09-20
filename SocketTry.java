package workshop2;
import java.net.*;
import java.io.*;
import java.util.*;

public class SocketTry {
	public static void main(String[] args){
		ServerSocket server;
		Socket client;
		try {
			server = new ServerSocket(9999); //����˿ڣ�9999.���ʵ�ַ�ǣ�127.0.0.1:9999
		}catch(Exception e) {
			System.out.println("IOException:" +e);
			return;
		}
		
		while(true){
			try {
				client = server.accept(); //������������
				System.out.println("\n\naccept...");
				BufferedReader bs = 
						new BufferedReader(
						new InputStreamReader(
						client.getInputStream()));
				String cmd = bs.readLine();
				System.out.println("--=>"+cmd);
				int i=cmd.indexOf("/")+1;
				String filename = cmd.substring(i,cmd.indexOf(" ", i)); //ʶ��url�е��ļ���
				System.out.println("--=>"+filename);
				
				DataOutputStream ps =//���ͨ��
						new DataOutputStream(
						new BufferedOutputStream(
						client.getOutputStream()));
				DataInputStream br = //����ͨ��
						new DataInputStream(
						new BufferedInputStream(
						new FileInputStream(filename)));
				try {
					while(true)ps.writeByte(br.readByte());
					}
				catch(EOFException e){
					ps.close(); br.close(); //�ر�����
				}
			} catch(IOException e){
				System.out.println("IOException End."+e);
			}
		}
	}
}
