import  java.io.*;
import  java.net.*;
import  java.util.*;
//服务器端
public  class MultiChatServer
{
	private int     port = 5001;
	ServerSocket    serverSock = null;
	private Vector<User>  clients = new Vector<User>();
    
    public  static void main(String args[])
    {
        new MultiChatServer().server();
    }
    
    MultiChatServer()
	{
        try {
            serverSock = new ServerSocket(port, 50);
        } catch(IOException e) {
            System.out.println(e);	return;
        }
	}

    private void server()
    {
        while(true){
            try {
	Socket socket = serverSock.accept();
	DataOutputStream remoteOut=
		new DataOutputStream(
		socket.getOutputStream());
	
	DataInputStream remoteIn =
		new DataInputStream(
		socket.getInputStream());
	String s = remoteIn.readUTF();
	clients.addElement(new User(s, remoteOut));

	new ServerHelder(remoteIn).start(); //启动线程监听输入管道
			} catch(IOException e){
			}
		}
	}

	class User
	{
		String	nam;
		DataOutputStream remoteOut;

		User(String s, DataOutputStream r)
		{
			nam = s;
			remoteOut = r;
		}
	};
	class ServerHelder extends Thread
	{
		DataInputStream		remoteIn;
		ServerHelder(DataInputStream remoteIn)
		{	this.remoteIn	= remoteIn;
			setDaemon(true);	// Thread is daemon
		}
		
		public synchronized void run()
		{
			String  buf;
			try {
				while(true){
					buf = remoteIn.readUTF();
					System.out.println(buf);
					broadcast(buf);
				}
			} catch(IOException e){
				System.out.println(e.getMessage() + ": Connection to perr lost.");
			}
		}
		
		private void broadcast(String buf)
		{
			DataOutputStream	dataOut = null;

//for(Enumeration e = clients.elements(); e.hasMoreElements();){
			for(int i=0; i<clients.size(); i++){
//User u = (User)(e.nextElement());
			User u = (User)(clients.get(i));
					
	dataOut = u.remoteOut;
	try {
		dataOut.writeUTF(u.nam+"说："+buf);
	} catch(IOException x){
		System.out.println(x.getMessage() + ": Failed to broadcast to client.");
		clients.removeElement(dataOut);
	}
		}
		}
}
	}


