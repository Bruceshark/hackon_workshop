import java.io.*; 
import java.net.*; 
import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*;
//�ͻ���
public class MultiChat extends JFrame
{
  TextArea			txt;
  JTextField		usr, pwd, wrd;
  DataOutputStream	remoteOut;
  int				port=5001;

  MultiChat(String n){
	super(n);
	BorderLayout border = new BorderLayout();
    Container content = getContentPane();
    content.setLayout(border);

	usr = new JTextField();
	pwd = new JTextField();
	JButton btn = new JButton("��¼");
	btn.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent evt){
	  String s1 = usr.getText();
	  String s2 = pwd.getText();
	  init(s1, s2);
	  wrd.setText("");
  }
	});
	Box top = Box.createHorizontalBox();
	top.add(new JLabel("�û�����"));
	top.add(usr);
	top.add(new JLabel("���"));
	top.add(pwd);
	top.add(btn);

	txt = new TextArea();
	wrd = new JTextField();
	wrd.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent evt){
	  String s = wrd.getText();
	  try{
		  remoteOut.writeUTF(s);
	  }catch(Exception e){};
	  wrd.setText("");
  }
	});

	content.add(top, BorderLayout.NORTH);
	content.add(txt, BorderLayout.CENTER);
	content.add(wrd, BorderLayout.SOUTH);

  }

  public void init(String u, String p)
  {
	try {
//		if(host.equals("local"))host = null;
		InetAddress serverAddr =
			InetAddress.getByName("144.202.87.247"); //����
		Socket client =
			new Socket(serverAddr.getHostName(), port);
		remoteOut =
			new DataOutputStream(
			client.getOutputStream());
		remoteOut.writeUTF(u+":"+p); //���
            
		DataInputStream remoteIn =
			new DataInputStream(
			client.getInputStream());
		new MultiChatReceive(remoteIn).start(); //�����̣߳��ÿͻ���������
	} catch(IOException e){
		System.out.println(e.getMessage() + ": Failed to connect to server.");
	}
  }

  class MultiChatReceive extends Thread
  {
	DataInputStream remoteIn;

	MultiChatReceive(DataInputStream remoteIn)
    {
        this.remoteIn = remoteIn;
		setDaemon(true);
    }
    
    public synchronized void run()
    {
	  String s;
	  try{
		while(true){ //��������ʾ
			s = remoteIn.readUTF();
			switch(s.charAt(0)){
			case 'A':
				txt.setText(s.substring(1));
				break;
			default:
				txt.setText(s+"\n"+txt.getText());
				break;
			}
		}
      } catch(IOException e){}
    }
  }

  public static void main(String[] args)
  {
	MultiChat aWindow = new MultiChat("Java 2016"); 
    Toolkit theKit = aWindow.getToolkit();         // Get the window toolkit
    Dimension wndSize = theKit.getScreenSize();    // Get screen size

    // Set the position to screen center & size to half screen size
    aWindow.setBounds(wndSize.width/4, wndSize.height/4,   // Position
                      wndSize.width/2, wndSize.height/2);  // Size
    aWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    aWindow.setVisible(true);                      // Display the window
  }
}

